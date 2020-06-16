package com.groep6.pfor.models;

import com.groep6.pfor.exceptions.IncorrentPasswordException;
import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Observable;
import com.groep6.pfor.util.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents a lobby
 *
 * @author Bastiaan Jansen
 */
public class Lobby extends Observable implements IObserver {

    private final String code;
    private String passwordHash;
    private List<LobbyPlayer> players = new ArrayList<>();

    /**
     * @param password
     */
    public Lobby(String password) {
        this.code = generateCode();
        this.passwordHash = PasswordEncoder.hash(password);
    }

    /**
     * Constructs a lobby without a password
     */
    public Lobby() {
        this.code = generateCode();
    }

    public Lobby(String code, String passwordHash, List<LobbyPlayer> players) {
        this.code = code;
        this.passwordHash = passwordHash;
        this.players.addAll(players);
    }

    /**
     * Creates a new lobbyPlayer instance with a random available roleCard, the first player is the host of the lobby
     * @param username
     * @return new instance of LobbyPlayer
     */
    public LobbyPlayer join(String code, String username, String password, boolean isLocal) throws IncorrentPasswordException {
        if (!validatePassword(password)) throw new IncorrentPasswordException();

        boolean isHost = false;

        if (players.size() == 0) isHost = true;

        LobbyPlayer lobbyPlayer = new LobbyPlayer(username, RoleCardFactory.getInstance().pickRandomRoleCard(), isHost, isLocal, code);
        players.add(lobbyPlayer);
        lobbyPlayer.registerObserver(this);
        return lobbyPlayer;
    }

    /**
     * Checks if the password is the same as the lobby password, if the lobby has no password, the method always returns true
     * @param password
     * @return Whether password is the same as the lobby password
     */
    private boolean validatePassword(String password) {
        if (passwordHash == null) return true;

        return PasswordEncoder.matches(password, passwordHash);
    }

    /**
     * Get the password of the lobby (hashed of course)
     * @return The hashed password of the lobby
     */
    public String getPasswordHash() {
        return passwordHash;
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

    public Game start() {
        return Game.getInstance();
    }

    public LobbyPlayer getLocalPlayer() {
        for (LobbyPlayer player: players) {
            if (player.isLocal()) return player;
        }

        return null;
    }

    public void removePlayer(LobbyPlayer player) {
        players.remove(player);
    }

    @Override
    public void update() {
        notifyObservers();
    }

    public void updateLobby(Lobby lobby) {

        LobbyPlayer localPlayer = getLocalPlayer();

        players = lobby.getPlayers();

        for (LobbyPlayer player: lobby.getPlayers()) {
            if (player.equals(localPlayer)) {
                player.setLocal(true);
                break;
            }
        }

        update();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Lobby)) return false;
        return ((Lobby) o).code.equals(code);
    }
}
