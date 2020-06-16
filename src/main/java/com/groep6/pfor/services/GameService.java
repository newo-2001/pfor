package com.groep6.pfor.services;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.groep6.pfor.Config;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.ServerEvent;
import com.groep6.pfor.util.parsers.templates.GameDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * The GameService class acts as a gateway to Firebase for all Game related actions
 *
 * @author Owen Elderbroek
 */
public class GameService {

    /** This event is fired when a Game is changed */
    public static ServerEvent gameChangeEvent = new ServerEvent();
    public static ListenerRegistration listener;
    private static Game cache;

    /**
     * Obtain a game using its lobby code
     * @param code The lobby code of the requested game
     * @return The game that has that code
     * @throws NoDocumentException If the query had no results
     */
    public Game getGame(String code) throws NoDocumentException {
        if (cache != null) return cache;
        return Firebase.requestDocument("games/" + code).toObject(GameDTO.class).toModel();
    }

    /**
     * Obtain the list of players in a game
     * Note that this operation is just as expensive
     * as requesting the whole game, cache the entire game if you can.
     * @param code The code of the game
     * @return The list of players in that game
     */
    public List<Player> getPlayers(String code) throws NoDocumentException {
        return getGame(code).getAllPlayers();
    }

    /**
     * Update a game's data on server to this new data
     * Warning! This will overwrite the entire game, Only use if you have good reason to!
     * @param game The new game data that will override the old data
     */
    public void setGame(Game game) {
        Firebase.setDocument("games/" + game.getCode(), GameDTO.fromModel(game));
    }

    /**
     * Thanos snap a game out of the database, never to be seen again
     * @param code The game code of the game to be Thanos snapped
     */
    public void remove(String code) {
        DocumentReference doc = Firebase.docRefFromPath("games/" + code);
        doc.delete();
    }

    /**
     * Create a game on the server.
     * @param game The game to be created
     */
    public void create(Game game) {
        ApiFuture<WriteResult> res = Firebase.setDocument("games/" + game.getCode(), GameDTO.fromModel(game));
        try {
            res.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Firebase.docRefFromPath("lobbies/" + game.getCode()).update("started", true);
    }

    public static void removeListener() {
        if (listener == null) return;
        listener.remove();
        listener = null;
    }

    public static EventListener<DocumentSnapshot> onGameChange = (documentSnapshot, e) -> {
        if (e != null) e.printStackTrace();
        else {
            try {
                cache = documentSnapshot.toObject(GameDTO.class).toModel();
                GameService.gameChangeEvent.fire(cache);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (Config.DEBUG) System.out.println("GAME_CHANGE_EVENT");
    };
}
