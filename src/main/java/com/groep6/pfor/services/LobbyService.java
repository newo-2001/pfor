package com.groep6.pfor.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.cloud.firestore.*;
import com.groep6.pfor.Config;
import com.groep6.pfor.exceptions.NoDocumentException;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.util.ServerEvent;
import com.groep6.pfor.util.parsers.templates.LobbyDTO;
import com.groep6.pfor.util.parsers.templates.LobbyPlayerDTO;

import java.util.List;
import java.util.Map;

/**
 * The LobbyService class acts as a gateway to Firebase for all lobby related actions
 *
 * @author Owen Elderbroek
 */
public class LobbyService {
    /** This event is fired when a lobby is changed */
    public static ServerEvent lobbyChangeEvent = new ServerEvent();
    public static ServerEvent gameStartEvent = new ServerEvent();
    private static ListenerRegistration listener;
    private static Lobby cache;

    /**
     * Obtain the list of players in a lobby
     * @param code The code of the lobby
     * @return The list of players in that lobby
     */
    public List<LobbyPlayer> getPlayers(String code) throws NoDocumentException {
        return Firebase.requestDocument("lobbies/" + code).toObject(LobbyDTO.class).toModel().getPlayers();
    }

    /**
     * Obtain a lobby using its lobby code
     * @param code The lobby code of the requested lobby
     * @return The lobby that has that code
     * @throws NoDocumentException If the query had no results
     */
    public Lobby get(String code) throws NoDocumentException {
        if (cache != null) return cache;
        return Firebase.requestDocument("lobbies/" + code).toObject(LobbyDTO.class).toModel();
    }

    /**
     * Update a lobby's data on server to this new data
     * Warning! This will overwrite the entire lobby, Only use if you have good reason to!
     * @param lobby The new lobby data that will override the old data
     */
    public void set(Lobby lobby) {
        Firebase.setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
    }

    /**
     * Thanos snap a lobby out of the database, never to be seen again
     * @param lobby The lobby to be Thanos snapped
     */
    public void remove(Lobby lobby) {
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + lobby.getCode());
        doc.delete();
    }

    /**
     * Create a lobby on the server.
     * All the players in this lobby will automagically be joined
     * It will be assumed that all these players belong to this client (should really ever only be 1 player!)
     * @param lobby The lobby to be created
     */
    public void create(Lobby lobby) {
        for (LobbyPlayer player : lobby.getPlayers()) Firebase.registerListener("lobbies/" + player.getLobby(), onLobbyChange);
        Firebase.setDocument("lobbies/" + lobby.getCode(), LobbyDTO.fromModel(lobby));
    }

    /**
     * Sync a player's rolecard with firebase
     * @param player The player to change, note: the card to sync with is the card
     *               that the this instance has
     */
    public void updateRoleCard(LobbyPlayer player) {
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + player.getLobby());
        doc.update(FieldPath.of("players", player.getUsername(), "role"), player.getRoleCard().getName());
    }

    /**
     * Gives a player lobby host
     * Note! This does not remove host from the other players
     * You should do that yourself
     * @param player The player to be the new lobby host
     */
    public void giveHost(LobbyPlayer player) {
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + player.getLobby());
        doc.update(FieldPath.of("players", player.getUsername(), "host"), true);
    }

    /**
     * Make a player join a lobby
     * @param player The player to join a lobby, note: The lobby to join is specified
     *               in the player instance.
     */
    public void join(LobbyPlayer player) {
        if (listener == null) listener = Firebase.registerListener("lobbies/" + player.getLobby(), onLobbyChange);
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + player.getLobby());
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> kv = mapper.convertValue(LobbyPlayerDTO.fromModel(player), new TypeReference<Map<String, Object>>() {});
        doc.update("players." + player.getUsername(), kv);
    }

    /**
     * Remove a player from the firebase lobby,
     * The lobby to leave is specified in the player's lobby field
     * @param player The player that should leave
     */
    public void leave(LobbyPlayer player) {
        DocumentReference doc = Firebase.docRefFromPath("lobbies/" + player.getLobby());
        doc.update(FieldPath.of("players", player.getUsername()), FieldValue.delete());
        removeListener();
        GameService.removeListener();
        cache = null;
    }

    public static void removeListener() {
        if (listener == null) return;
        listener.remove();
        listener = null;
    }

    private static final EventListener<DocumentSnapshot> onLobbyChange = (documentSnapshot, e) -> {
        if (e != null) e.printStackTrace();
        else {
            LobbyDTO dto = documentSnapshot.toObject(LobbyDTO.class);
            if (dto.started) {
                if (Config.DEBUG) System.out.println("GAME_START_EVENT");
                GameService.listener = Firebase.registerListener("games/" + dto.code, GameService.onGameChange);
                try {
                    gameStartEvent.fire(new GameService().getGame(dto.code));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                removeListener();
            } else {
                cache = dto.toModel();
                LobbyService.lobbyChangeEvent.fire(cache);
            }
        }

        if (Config.DEBUG) System.out.println("LOBBY_CHANGE_EVENT");
    };


}
