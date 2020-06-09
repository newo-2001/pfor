package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityCardFactory;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class Game extends Observable implements IObserver {

    private static Game SINGLE_INSTANCE = new Game();

    private Board board = new Board();
    private List<Player> players = new ArrayList<>();
    private int decayLevel = 0;
    private final int MAX_DECAY_LEVEL = 8;
    private int invasionLevel = 0;
    private final int MAX_INVASION_LEVEL = 7;
    private Deck tradeCardsDeck = new Deck();
    private Deck invasionCardsDeck = new Deck();
    private Deck cityCardsDeck;
    private Deck invasionCardsDiscardPile = new Deck();
    private Deck cityCardsDiscardPile = new Deck();
    private Dice[] die = new Dice[3];
    private List<Faction> friendlyFactions = new ArrayList<>();
    private String code;

    public static Game getInstance() {
        return SINGLE_INSTANCE;
    }

    private Game() {
        cityCardsDeck = CityCardFactory.getInstance().getCityCardDeck();
        cityCardsDeck.shuffle();

        // Create new dice instances
        for (int i = 0; i < die.length; i++) {
            die[i] = new Dice();
        }
    }

    public Game(Board board, List<Player> players, List<Faction> friendlyFactions, int decayLevel, int invasionLevel,
                Deck tradeDeck, Deck invasionDeck, Deck cityDeck, Deck invasionDiscardPile, Deck cityDiscardPile) {
        this.board = board;
        this.players = players;
        this.friendlyFactions = friendlyFactions;
        this.decayLevel = decayLevel;
        this.invasionLevel = invasionLevel;
        this.tradeCardsDeck = tradeDeck;
        //this.invasionCardsDeck = invasionDeck;
        this.cityCardsDeck = cityDeck;
        this.invasionCardsDiscardPile = invasionDiscardPile;
        this.cityCardsDiscardPile = cityDiscardPile;

        // Create new dice instances
        for (int i = 0; i < die.length; i++) {
            die[i] = new Dice();
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Update the local game with the data from the remote version
     * @param remote The remote version of the game
     */
    public static void updateGame(Game remote) {
        Game client = getInstance();
        Player local = client.getLocalPlayer();
        getInstance().players = remote.getAllPlayers();
        for (Player player : client.getAllPlayers()) {
            if (player.equals(local)) client.setLocalPlayer(local);
        }

        client.board = remote.board;
        client.decayLevel = remote.decayLevel;
        client.invasionLevel = remote.invasionLevel;
        client.invasionCardsDeck = remote.invasionCardsDeck;
        client.invasionCardsDiscardPile = remote.invasionCardsDiscardPile;
        client.cityCardsDeck = remote.cityCardsDeck;
        client.cityCardsDiscardPile = remote.cityCardsDiscardPile;
        client.tradeCardsDeck = remote.tradeCardsDeck;
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

        notifyObservers();

        return nextPlayer;
    }

    /**
     * Adds LobbyPlayers to game
     * @param lobbyPlayers
     */
    public void addPlayers(LobbyPlayer... lobbyPlayers) {
        for (LobbyPlayer lobbyPlayer: lobbyPlayers) {
            Player player = new Player(lobbyPlayer);
            player.registerObserver(this);
            players.add(player);
        }
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

    public int getInvasionLevel() {
        return invasionLevel;
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
        return cityCardsDeck;
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

    public void setLocalPlayer(Player player) {
        for (Player p : getAllPlayers()) if (player.equals(p)) p.setLocal(true);
    }

    @Override
    public void update() {
        notifyObservers();
    }
}
