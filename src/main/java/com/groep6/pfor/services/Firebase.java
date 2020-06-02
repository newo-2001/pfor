package com.groep6.pfor.services;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.util.parsers.templates.DTO;

import javax.swing.text.Document;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;

/**
 * The gateway class to firebase.
 * All direct communication with the Firestore API goes through here.
 *
 * @author Owen Elderbroek
 */
public class Firebase {
    private static Firestore db;

    public static void initialize() {
        try {
            InputStream serviceAccount = new FileInputStream("src/main/java/ServiceAccountKey.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);

            FirebaseOptions options = new FirebaseOptions.Builder().setCredentials(credentials).build();
            FirebaseApp.initializeApp(options);

            db = FirestoreClient.getFirestore();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtain a document from the specified path relative to the firestore root
     * with every document or collection separated by a '/'
     * @param path The path to the document relative to the database root
     * @return The requested document
     * @throws NoDocumentException If the document was not available
     */
    protected static DocumentSnapshot requestDocument(String path) throws NoDocumentException {
        try {
            DocumentReference docRef = docRefFromPath(path);
            ApiFuture<DocumentSnapshot> future = docRef.get();
            DocumentSnapshot document = future.get();

            if (document.exists()) return document;
            else throw new NoDocumentException();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Add a DTO to a collection
     *
     * @param path The path to the collection where the object
     *             should be appended to the list with a random
     *             document Id
     * @param data The data that should form a document entry
     */
    protected static void addDocument(String path, DTO data) {
        CollectionReference collRef = collRefFromPath(path);
        collRef.add(data);
    }

    /**
     * Write a document to a location, document Id is specified
     * as the last entry in the path. Warning, overwrites existing
     * data at that location!
     * @param path The location to write the object to
     * @param data The object to write
     */
    protected static void setDocument(String path, DTO data) {
        DocumentReference docRef = docRefFromPath(path);
        docRef.set(data);
    }

    /**
     * Remove a document at a given path
     * @param path The path that points to the document to be removed
     */
    protected static void removeDocument(String path) {
        DocumentReference docRef = docRefFromPath(path);
        docRef.delete();
    }

    /**
     * Obtains the document reference pointed to by a path
     * @param path The path to the document
     * @return The reference to that document
     */
    protected static DocumentReference docRefFromPath(String path) {
        String[] paths = path.split("/");
        CollectionReference collRef = db.collection(paths[0]);
        DocumentReference docRef = null;

        for (int i = 1; i < paths.length; i++) {
            if (i % 2 == 0) collRef = docRef.collection(paths[i]);
            else docRef = collRef.document(paths[i]);
        }
        return docRef;
    }

    /**
     * Obtains the collection reference pointed to by a path
     * @param path The path to the collection
     * @return The reference to that collection
     */
    protected static CollectionReference collRefFromPath(String path) {
        String[] paths = path.split("/");
        CollectionReference collRef = db.collection(paths[0]);
        DocumentReference docRef = null;

        for (int i = 1; i < paths.length; i++) {
            if (i % 2 == 0) collRef = docRef.collection(paths[i]);
            else docRef = collRef.document(paths[i]);
        }

        return collRef;
    }

    /**
     * Allows constructing a query and executing it
     * @param query The query to perform
     * @return The result of executing the query
     */
    protected static QueryDocumentSnapshot[] query(Query query) {
        try {
            ApiFuture<QuerySnapshot> future =  query.get();
            QuerySnapshot snapshot = future.get();
            return snapshot.getDocuments().toArray(new QueryDocumentSnapshot[0]);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Wrapper for {@link #query(Query)} method that only returns the first entry.
     * @param query The query to execute
     * @return The first result of the query
     */
    public static QueryDocumentSnapshot queryOne(Query query) {
        return query(query)[0];
    }

    protected static void registerListener(String path, EventListener<DocumentSnapshot> listener) {
        docRefFromPath(path).addSnapshotListener(listener);
    }
}
