package com.groep6.pfor.models;

import com.groep6.pfor.util.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class Game extends Observable {

    private static Game SINGLE_INSTANCE = new Game();

    private Board board;
    private List<Player> players = new ArrayList<>();
    private int decayLevel = 0;
    private final int MAX_DECAY_LEVEL = 8;
    private int invasionLevel = 0;
    private final int MAX_INVASION_LEVEL = 7;
    private Deck invasionDeck;
    private Deck cityDeck;
    private Deck invasionDiscardPile;
    private Deck cityDiscardPile;
    private Dice[] die = new Dice[3];
    private List<Faction> friendlyFactions;
    private Player localPlayer;
    private Lobby lobby;

    public static Game getInstance() {
        return SINGLE_INSTANCE;
    }

    private Game() {
        // Create players from LobbyPlayers
    }

    /**
     * Adds LobbyPlayers to game
     * @param lobbyPlayers
     */
    public void addPlayers(LobbyPlayer... lobbyPlayers) {
        for (LobbyPlayer player: lobbyPlayers) players.add(new Player(player));
        notifyObservers();
    }

    /**
     * @return board object
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return All players in game
     */
    public List<Player> getAllPlayers() {
        return players;
    }

    public Player getPlayerTurn() {
        for (Player player: players) {
            if (player.isTurn()) return player;
        }

        return null;
    }

    /**
     * @return player with current turn
     */
    public Player getCurrentPlayer() {
        for (Player player: players) {
            if (player.isTurn()) return player;
        }

        return null;
    }

    /**
     * @return invasion deck
     */
    public Deck getInvasionDeck() {
        return invasionDeck;
    }

    /**
     * @return decay level
     */
    public int getDecayLevel() {
        return decayLevel;
    }

    /**
     * Increase decay level, when decay level. When reached the max, return
     */
    public void increaseDecayLevel() {
        if (decayLevel >= MAX_DECAY_LEVEL) return;

        decayLevel++;
        notifyObservers();
    }

    /**
     * Increase invasion level. When reached the max, return
     */
    public void increaseInvasionLevel() {
        if (invasionLevel >= MAX_INVASION_LEVEL) return;

        invasionLevel++;
        notifyObservers();
    }

    public Deck getCityDeck() {
        return cityDeck;
    }

    public Deck getInvasionDiscardPile() {
        return invasionDiscardPile;
    }

    public Deck getCityDiscardPile() {
        return cityDiscardPile;
    }

    public Dice[] getDie() {
        return die;
    }

    public boolean isFriendlyFaction(Faction faction) {
        if (friendlyFactions.contains(faction)) return true;
        return false;
    }

    public Player getLocalPlayer() {
        return localPlayer;
    }

    public void setLocalPlayer(Player localPlayer) {
        this.localPlayer = localPlayer;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
}
