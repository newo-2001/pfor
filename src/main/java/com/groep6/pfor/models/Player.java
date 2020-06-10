package com.groep6.pfor.models;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.List;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.Observable;

/**
 * @author Bastiaan Jansen
 */
public class Player extends Observable implements IObserver {

    private Hand hand = new Hand();
    private RoleCard roleCard;
    private City city;
    private String username;
    private boolean turn = false;
    private int actionsRemaining = 0;
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

        System.out.println("Player: " + username);
    }

    public Player(String username, City city, RoleCard roleCard, boolean turn, boolean isLocal) {
        this.roleCard = roleCard;
        this.city = city;
        this.username = username;
        this.isLocal = isLocal;
        if (turn) setTurn();
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
    	// if city in neighboring cities
    	if (this.city.neighbouringCities.contains(city) && actionsRemaining > 0 && isTurn()) {
        	this.city = city;
        	actionsRemaining--;
    	}
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
        System.out.println("Legions: " + city.getLegions());
        System.out.println("Barbarians: " + city.getBarbarians());
        notifyObservers();
    }


    public int formAlliance(Faction faction) {
        City city = getCity();
        List<Card> cards = getHand().getCards();

        // Get city card count with this faction
        int cardCount = 0;
        for (Card card : cards) {
            if (card instanceof CityCard && ((CityCard) card).getFaction().equals(faction)) cardCount++;
        }

        // City has no faction of this type
        if (!city.hasFaction(faction)) return -2;

        // Player has not enough cards of this faction
        if (cardCount < faction.getCardCountForAlliance()) return -1;

        // Ally this faction
        faction.ally();


        // Barbaren worden legions

        return 1;
    }
}
