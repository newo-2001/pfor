package com.groep6.pfor.models;

import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
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
    private Deck tradeDeck = new Deck();
    private Deck invasionDeck = new Deck();
    private Deck cityDeck = new Deck();
    private Deck invasionDiscardPile = new Deck();
    private Deck cityDiscardPile = new Deck();
    private Dice[] die = new Dice[3];
    private List<Faction> friendlyFactions = new ArrayList<>();
    private Player localPlayer;

    public static Game getInstance() {
        return SINGLE_INSTANCE;
    }

    private Game() {
        // Create new dice instances
        for (int i = 0; i < die.length; i++) {
            die[i] = new Dice();
        }
    }

    public Player nextTurn() {
        // Get current turn player
        Player currentPlayer = getPlayerTurn();
        Player nextPlayer;

        if (currentPlayer == null) {
            nextPlayer = players.get(0);
            nextPlayer.setTurn();
            return nextPlayer;
        }

        int index = players.indexOf(currentPlayer);

        if (players.size() > index)  nextPlayer = players.get(index + 1);
        else nextPlayer = players.get(0);

        currentPlayer.notTurn();
        nextPlayer.setTurn();

        return nextPlayer;
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
    
    public Deck getTradeDeck() {
    	return tradeDeck;
    }

    /**
     * @return decay level
     */
    public int getDecayLevel() {
        return decayLevel;
    }

    /**
     * Increase decay level, when decay level. When reached the max, return.
     * @param amount
     */
    public void increaseDecayLevel(int amount) {
        if (decayLevel + amount >= MAX_DECAY_LEVEL) return;

        decayLevel += amount;
        notifyObservers();
    }

    /**
     * Increase invasion level. When reached the max, return.
     * @param amount
     */
    public void increaseInvasionLevel(int amount) {
        if (invasionLevel + amount >= MAX_INVASION_LEVEL) return;

        invasionLevel += amount;
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
}
