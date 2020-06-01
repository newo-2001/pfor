package com.groep6.pfor.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.Player;

import java.util.concurrent.ExecutionException;

public class LobbyService extends Service {

    private static final String COLLECTION = "lobbies";

    public DocumentSnapshot get(String documentID) throws NoDocumentException {
        DocumentSnapshot snapshot = null;

        try {
            DocumentReference docRef = db.collection(COLLECTION).document(documentID);
            ApiFuture<DocumentSnapshot> future = docRef.get();

            DocumentSnapshot document = future.get();
            if (document.exists()) {
                System.out.println("Document data: " + document.getData());
                Lobby lobby = document.toObject(Lobby.class);
//
//                System.out.println(lobby.getCode());
            } else {
                throw new NoDocumentException();
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return snapshot;
    }

    public void create() {

    }

    @Override
    public void subscribe(String documentID) {

    }
}
