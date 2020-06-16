package com.groep6.pfor.models;

import com.groep6.pfor.Config;
import com.groep6.pfor.factories.CityCardFactory;
import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.factories.EventCardFactory;
import com.groep6.pfor.factories.InvasionCardFactory;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends Observable implements IObserver {

    private static final Game SINGLE_INSTANCE = new Game();
    private static GameState GAME_STATE = GameState.MENU;

    private Board board = new Board();
    private List<Player> players = new ArrayList<>();
    private final List<City> invadedCities = new ArrayList<>();
    private int decayLevel = 0;
    private final int MAX_DECAY_LEVEL = 9;
    private int invasionLevel = 0;
    private final int MAX_INVASION_LEVEL = 7;
    private Deck tradeCardsDeck = new Deck();
    private Deck invasionCardsDeck = new Deck();
    private Deck playerCardsDeck;
    private Deck invasionCardsDiscardPile = new Deck();
    private Deck cityCardsDiscardPile = new Deck();
    private final Dice[] die = new Dice[3];
    private List<Faction> friendlyFactions = new ArrayList<>();
    private String code;
    private boolean lost = false;
    private boolean won = false;

    public static Game getInstance() {
        return SINGLE_INSTANCE;
    }
    
    public static GameState getGameState() {
    	return GAME_STATE;
    }
    
    public static void setGameState(GameState state) {
    	GAME_STATE = state;
    }

    private Game() {
        Random rand = new Random();
        playerCardsDeck = new Deck(CityCardFactory.getInstance().getCityCardDeck().getCards().toArray(new Card[0]));
        playerCardsDeck.merge(EventCardFactory.getInstance().getEventCardDeck());
        playerCardsDeck.shuffle();

        invasionCardsDeck = new Deck(InvasionCardFactory.getInstance().getAllInvasionCards());
        invasionCardsDeck.shuffle();

        // Create new dice instances
        for (int i = 0; i < die.length; i++) die[i] = new Dice();

        // Add barbarians to cities
        for (int i = 0; i < 20; i++) {
            City[] cities = CityFactory.getInstance().getAllCities();
            City city = cities[rand.nextInt(cities.length)];

            if (invadedCities.contains(city) || city.getName().equals("Roma")) {
                i--;
                continue;
            }

            int barbariansCount = rand.nextInt(2);

            if (city.getTotalBarbarianCount() > 2) {
                invadedCities.add(city);
                barbariansCount = 2;
                i--;
            }

            Faction[] factions = city.getFactions();
            city.addBarbarians(factions[rand.nextInt(factions.length)].getFactionType(), barbariansCount);
        }
    }

    public Game(Board board, List<Player> players, List<Faction> friendlyFactions, int decayLevel, int invasionLevel,
                Deck tradeDeck, Deck invasionDeck, Deck cityDeck, Deck invasionDiscardPile, Deck cityDiscardPile, boolean lost, boolean won) {
        this.board = board;
        this.players = players;
        this.friendlyFactions = friendlyFactions;
        this.decayLevel = decayLevel;
        this.invasionLevel = invasionLevel;
        this.tradeCardsDeck = tradeDeck;
        this.invasionCardsDeck = invasionDeck;
        this.playerCardsDeck = cityDeck;
        this.invasionCardsDiscardPile = invasionDiscardPile;
        this.cityCardsDiscardPile = cityDiscardPile;
        this.lost = lost;
        this.won = won;

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
    public void updateGame(Game remote) {
        Player local = getLocalPlayer();
        players.clear();

        for (Player player: remote.getAllPlayers()) {
            addPlayers(player);
            if (player.equals(local)) {
                player.getHand().addCards(local.getHand().getCards().toArray(new Card[0]));
                setLocalPlayer(player);
            }
        }

        board.updateBoard(remote.board);
        decayLevel = remote.decayLevel;
        invasionLevel = remote.invasionLevel;
        invasionCardsDeck = remote.invasionCardsDeck;
        invasionCardsDiscardPile = remote.invasionCardsDiscardPile;
        playerCardsDeck = remote.playerCardsDeck;
        cityCardsDiscardPile = remote.cityCardsDiscardPile;
        tradeCardsDeck = remote.tradeCardsDeck;
        friendlyFactions = remote.friendlyFactions;

        notifyObservers();
    }

    public void addPlayers(Player... players) {
        for (Player player: players) {
            this.players.add(player);
            player.registerObserver(this);
        }
    }

    public void nextTurn() {
        if (players.size() <= 0) return;

        // Get current turn player
        Player currentPlayer = getPlayerTurn();
        Player nextPlayer;

        int index = players.indexOf(currentPlayer);

        if (players.size() > index + 1) nextPlayer = players.get(index + 1);
        else nextPlayer = players.get(0);

        currentPlayer.notTurn();
        nextPlayer.setTurn();

        notifyObservers();
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
    
   public int getMaxDecayLevel() {
       return MAX_DECAY_LEVEL;
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

        if (Config.DEBUG) System.out.println("Increasing invasion level");

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
        return friendlyFactions.contains(faction);
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

    public void addFriendlyFaction(Faction faction) {
        if (!friendlyFactions.contains(faction)) {
            friendlyFactions.add(faction);
            notifyObservers();
        }
    }

    public List<Faction> getFriendlyFactions() {
        return friendlyFactions;
    }

    public boolean isWon() {
        return won;
    }

    public boolean isLost() {
        return lost;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
}
