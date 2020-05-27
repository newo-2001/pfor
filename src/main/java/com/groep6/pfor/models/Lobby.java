package com.groep6.pfor.models;

import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.cards.RoleCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a lobby
 *
 * @author Bastiaan
 */
public class Lobby {

    private String code;
    private String passwordHash;
    private List<LobbyPlayer> players = new ArrayList<>();


    public Lobby(String passwordHash) {
        this.code = generateCode();
        this.passwordHash = passwordHash;
    }


    /**
     * Creates a new lobbyPlayer instance with a random available roleCard
     * @param username
     * @return new instance of LobbyPlayer
     */
    public LobbyPlayer join(String username, boolean isHost) {
        LobbyPlayer lobbyPlayer = new LobbyPlayer(username, pickRandomRoleCard(), isHost);
        players.add(lobbyPlayer);
        return lobbyPlayer;
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
}
