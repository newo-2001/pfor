package com.groep6.pfor.models;

import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.cards.RoleCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a lobby
 *
 * @author Bastiaan Jansen
 */
public class Lobby {

    private String code;
    private String passwordHash;
    private List<LobbyPlayer> players = new ArrayList<>();


    /**
     * @param password
     */
    public Lobby(String password) {
        this.code = generateCode();
        this.passwordHash = password;
    }

    /**
     * Creates a new lobbyPlayer instance with a random available roleCard, the first player is the host of the lobby
     * @param username
     * @return new instance of LobbyPlayer
     */
    public LobbyPlayer join(String username, String password) throws IncorrentPasswordException {
        if (!validatePassword(password)) throw new IncorrentPasswordException();

        boolean isHost = false;

        if (players.size() == 0) isHost = true;

        LobbyPlayer lobbyPlayer = new LobbyPlayer(username, pickRandomRoleCard(), isHost);
        players.add(lobbyPlayer);
        return lobbyPlayer;
    }

    private boolean validatePassword(String password) {
        if (password == passwordHash) return true;

        return false;
    }

    /**
     * Makes sure a role card can only be picked once
     * @return RoleCard
     */
    public RoleCard pickRandomRoleCard() {
        RoleCard card = RoleCardFactory.getInstance().pickRandomRoleCard();

        for (LobbyPlayer player: players) {
            if (player.getRoleCard() == card) return pickRandomRoleCard();
        }

        return card;
    }

    /**
     * Removes a LobbyPlayer from the lobby
     * @param player
     */
    public void leave(LobbyPlayer player) {
        players.remove(player);
    }

    /**
     * Generates a 5 digit code
     * @return 5 digit code
     */
    private String generateCode() {
        Random r = new Random( System.currentTimeMillis() );
        int number = ((1 + r.nextInt(2)) * 10000 + r.nextInt(10000));
        return String.valueOf(number);
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return List of LobbyPlayers
     */
    public List<LobbyPlayer> getPlayers() {
        return players;
    }

    /**
     * Check if a certain lobbyPlayer is the host of this lobby
     * @param lobbyPlayer
     * @return boolean
     */
    public boolean isHost(LobbyPlayer lobbyPlayer) {
        for (LobbyPlayer player : players) {
            if (player == lobbyPlayer) {
                if (player.isHost()) return true;
            }
        }

        return false;
    }

    /**
     * @param lobbyPlayer
     * @return returns whether a lobbyPlayer is in this lobby
     */
    public boolean isInLobby(LobbyPlayer lobbyPlayer) {
        return players.contains(lobbyPlayer);
    }

    /**
     * @return The host of the lobby
     */
    public LobbyPlayer getHost() {
        for (LobbyPlayer player: players) {
            if (player.isHost()) return player;
        }

        return null;
    }
}
