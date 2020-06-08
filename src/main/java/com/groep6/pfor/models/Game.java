package com.groep6.pfor.models;

import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class Game extends Observable {

    private static Game SINGLE_INSTANCE = new Game();

    private Board board = new Board();
    private List<Player> players = new ArrayList<>();
    private int decayLevel = 0;
    private final int MAX_DECAY_LEVEL = 8;
    private int invasionLevel = 0;
    private final int MAX_INVASION_LEVEL = 7;
    private Deck tradeCardsDeck = new Deck();
    private Deck invasionCardsDeck = new Deck();
    private Deck playerCardsDeck = new Deck();
    private Deck invasionCardsDiscardPile = new Deck();
    private Deck cityCardsDiscardPile = new Deck();
    private Dice[] die = new Dice[3];
    private List<Faction> friendlyFactions = new ArrayList<>();

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
        if (players.size() <= 0) return null;

        // Get current turn player
        Player currentPlayer = getPlayerTurn();
        Player nextPlayer;

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
    public Deck getInvasionCardsDeck() {
        return invasionCardsDeck;
    }
    
    public Deck getTradeCardsDeck() {
    	return tradeCardsDeck;
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

    public Deck getPlayerCardsDeck() {
        return playerCardsDeck;
    }

    public Deck getInvasionCardsDiscardPile() {
        return invasionCardsDiscardPile;
    }

    public Deck getCityCardsDiscardPile() {
        return cityCardsDiscardPile;
    }

    public Dice[] getDie() {
        return die;
    }

    public boolean isFriendlyFaction(Faction faction) {
        if (friendlyFactions.contains(faction)) return true;
        return false;
    }

    public Player getLocalPlayer() {
        for (Player player: players) {
            if (player.isLocal()) return player;
        }

        return null;
    }
}
