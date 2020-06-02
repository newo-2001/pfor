package com.groep6.pfor.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.EventListener;
import com.google.cloud.firestore.FirestoreException;
import com.google.firebase.database.annotations.Nullable;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class GameService {

    private static final String COLLECTION = "games";

    public DocumentSnapshot get(String documentID) {

        DocumentSnapshot snapshot = null;

//        try {
//            DocumentReference docRef = db.collection(COLLECTION).document(documentID);
//            ApiFuture<DocumentSnapshot> future = docRef.get();
//
//            DocumentSnapshot document = future.get();
//            if (document.exists()) {
//                System.out.println("Document data: " + document.getData());
//                snapshot = document;
//            } else {
//                System.out.println("No such document!");
//            }
//        } catch (InterruptedException | ExecutionException e) {
//            e.printStackTrace();
//        }

        return snapshot;
    }
}
