package com.groep6.pfor.models;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.services.GameService;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Bastiaan Jansen
 */
public class Player extends Observable implements IObserver {

    private final Hand hand = new Hand();
    private final RoleCard roleCard;
    private City city;
    private final String username;
    private boolean turn = false;
    private int actionsRemaining = 4;
    private boolean isLocal;

    /**
     * The Player constructor clones all necessary the information from LobbyPlayer to Player
     * @param player
     */
    public Player(LobbyPlayer player) {
        roleCard = player.getRoleCard();
        username = player.getUsername();
        isLocal = player.isLocal();

        // Add starting cards to hand
        Game game = Game.getInstance();

        int cardAmount = 3;
        for (int i = 0; i < cardAmount; i++) {
            hand.addCards(game.getPlayerCardsDeck().draw());
        }

        // Set start city
        Random rand = new Random();
        CityFactory cityFactory = CityFactory.getInstance();
        List<City> cities = Arrays.asList(cityFactory.getAllCities());
        city = cities.get(rand.nextInt(cities.size() - 1));
        city.registerObserver(this);

        // Add two legions to start city
        city.addLegions(2);
    }

    public Player(String username, City city, RoleCard roleCard, boolean turn, boolean isLocal, int actionsRemaining) {
        this.roleCard = roleCard;
        this.city = city;
        this.username = username;
        this.isLocal = isLocal;
        this.actionsRemaining = actionsRemaining;
        this.turn = turn;
    }
    
    public boolean isTurn() {
        return turn;
    }

    /**
     * Set the player turn to true
     * The player can now perform 4 actions
     */
    public void setTurn() {
        turn = true;
        actionsRemaining = 4;
    }

    public int getActionsRemaining() {
        return actionsRemaining;
    }

    public void decreaseActionsRemaining() {
        if (actionsRemaining <= 0) return;
        actionsRemaining--;
        notifyObservers();

        // Sync with server
        GameService gameService = new GameService();
        gameService.setGame(Game.getInstance());
    }

    public void setActionsRemaining(int actionsRemaining) {
        this.actionsRemaining = actionsRemaining;
    }

    public Hand getHand() {
        return hand;
    }

    public RoleCard getRoleCard() {
        return roleCard;
    }

    public String getUsername() {
        return username;
    }
    
    // Actions
    
    public DiceFace[] battle() {
    	
    	Dice dice = new Dice();
    	List<Legion> legionsBefore = city.getLegions();
    	List<Barbarian> barbariansBefore = city.getBarbarians();
    	int diceAmount = 3;

    	// Decide amount of dice to roll.
    	if (legionsBefore.size() <= 3 && legionsBefore.size() > 0) {
    		diceAmount = legionsBefore.size();
    	}

        DiceFace[] diceFaces = new DiceFace[diceAmount];
    	for (int i = 0; i < diceAmount; i++) {
            diceFaces[i] = dice.roll(city);
    	}

    	decreaseActionsRemaining();

        return diceFaces;
    }
    
    public void move(City city) {
    	if (!this.city.neighbouringCities.contains(city)) return;
        this.city = city;

    	decreaseActionsRemaining();
    	notifyObservers();
    }

    public boolean isHost() {
        return isHost();
    }

    /**
     * Add more actions
     * @param amount
     */
    public void addActions(int amount) {
        actionsRemaining += amount;
        notifyObservers();

        GameService gameService = new GameService();
        gameService.setGame(Game.getInstance());
    }

    public void setLocal(boolean local) {
        this.isLocal = local;
    }

    public City getCity() {
        return city;
    }

    public void notTurn() {
        turn = false;
    }

    public boolean isLocal() {
        return isLocal;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Player)) return false;
        return ((Player) o).username.equals(username);
    }

    public void update() {
        notifyObservers();
    }

    /**
     * Get list of factions that an alliance can be formed with.
     * @return List of factions
     */
    public List<Faction> formableAlliances() {
        FactionFactory factionFactory = FactionFactory.getInstance();
        List<Faction> factions = factionFactory.getFactions();
        List<Card> cards = getHand().getCards();
        List<Faction> formableAlliances = new ArrayList<>();

        // Loop through all factions
        for (Faction faction : factions) {
            // If current city does not have this faction, continue
            if (!city.hasFaction(faction)) continue;

            int cardCount = 0;

            // Check if player has required card count to form alliance
            for (Card card : cards) {
                if (card instanceof CityCard && ((CityCard) card).getFaction().equals(faction)) {
                    cardCount++;
                }
            }
            if (cardCount >= faction.getCardCountForAlliance()) formableAlliances.add(faction);
        }
        return formableAlliances;
    }

    /**
     * Get the cityCards that this player holds with the type of faction that you give as parameter
     * @param faction The faction you want the cards from
     * @return A list of cards
     */
    public List<Card> getCitycardsWithFaction(Faction faction) {
        List<Card> cards = getHand().getCards();
        List<Card> factionCards = new ArrayList<>();
        for (Card card : cards) {
            if (card instanceof CityCard && ((CityCard) card).getFaction().equals(faction)) {
                factionCards.add(card);
            }
        }
        return factionCards;
    }
}
