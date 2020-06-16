package com.groep6.pfor.controllers;

import com.groep6.pfor.Main;
import com.groep6.pfor.models.*;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.InvasionCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.services.GameService;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.BoardView;

import java.util.Arrays;
import java.util.List;

/**
 * @author Bastiaan Jansen
 * @author Nils van der Velden
 */
public class BoardController extends Controller {

    private final Game game = Game.getInstance();

    public BoardController() {
    	changeMusic();
        viewController.showView(new BoardView(this));
    }
    
    public void goToBattleView() {
    	new BattleController();
    }

    public void goToInstructionView() {
        new InstructionController();
    }

    public void goToHand() {
        new HandController();
    }

    public Player getPlayerTurn() {
        return game.getPlayerTurn();
    }

    /**
     * @param amount
     */
    
    public void increaseDecayLevel(int amount) {
        game.increaseDecayLevel(amount);
    }

    
    public int getDecayLevel() {
        return game.getDecayLevel();
    }

    public Tile[] getTiles() {
        return game.getBoard().getTiles();
    }

    public List<Player> getPlayers() {
        return game.getAllPlayers();
    }

    public void cityPressed(City city) {
    }

    public Player getLocalPlayer() {
        return game.getLocalPlayer();
    }
    
    public void move(City city) {
        Player player = Game.getInstance().getLocalPlayer();

        if (player.getActionsRemaining() <= 0 || !player.isTurn()) return;
        if (!Arrays.asList(player.getCity().getNeighbouringCities()).contains(city)) return;

        if (player.getCity().getLegions().size() > 0) {
            new MoveController(city, player);
        } else player.move(city);
    }

    public void nextTurn() {
        // Draw 2 cards from game deck
        Player player = game.getLocalPlayer();
        player.getHand().addCards(game.getPlayerCardsDeck().draw(), game.getPlayerCardsDeck().draw());

        checkLoseConditions();

        // Open hand when there are more than 7 cards in hand
        if (player.getHand().getCards().size() > 7) new HandController();

        invadeCities();
              
    	if(game.getDecayLevel() >= game.getMaxDecayLevel() - 1) {
    		new LoseController();
    		game.setLost(true);
    	}
    	
    	checkWinConditions();

        // Next turn
        game.nextTurn();
        GameService gameService = new GameService();
        gameService.setGame(game);
    }

    public void checkLoseConditions() {
        // Go to lose screen when there are no more cards in players
        if (game.getPlayerCardsDeck().getCards().size() <= 0) {
            game.setLost(true);
        } else if (game.getDecayLevel() >= game.getMaxDecayLevel() - 1) {
            game.setLost(true);
        }
    }
    
    public void checkWinConditions() {
    	if (getFriendlyFactions().size() == 5) {
            game.setWon(true);
        }
    }

    public int getFortAmount() {
        int amount = 0;

        for (Tile tile: game.getBoard().getTiles()) {
            if (tile instanceof City) {
                City city = (City) tile;
                if (city.hasFort()) amount++;
            }
        }

        return amount;
    }

    private void invadeCities() {
        int cardAmount = 2;
        Card[] usedCards = new Card[cardAmount];
        Deck invasionCardsDeck = game.getInvasionCardsDeck();
        for (int i = 0; i < cardAmount; i++) {
            InvasionCard card = (InvasionCard) invasionCardsDeck.draw();
            invadeCity(card);
            usedCards[i] = card;
        }
        invasionCardsDeck.addCards(usedCards);
        invasionCardsDeck.shuffle();
    }

    
    private void invadeCity(InvasionCard card) {
        List<City> route = card.getRoute();

        for (int i = 0; i < route.size(); i++) {
        	if(route.get(i).getBarbarianCount(card.getFaction().getFactionType(), route.get(i).getBarbarians()) < 1) {
                route.get(i).addBarbarians(card.getFaction().getFactionType(), 1);
                if (i > 0) route.get(i - 1).addBarbarians(card.getFaction().getFactionType(), 1);
                break;
        	}
        }
        if (route.get(route.size() - 1).getBarbarianCount(card.getFaction().getFactionType(), route.get(route.size() - 1).getBarbarians()) >= 1){
    		route.get(route.size() - 1).addBarbarians(card.getFaction().getFactionType(), 1);
        }
    }

    public void buildFort() {
        Player player = game.getLocalPlayer();
        City city = player.getCity();
        city.placeFort();
        player.decreaseActionsRemaining();
    }

    public boolean canBattle() {
        Player player = game.getLocalPlayer();
        City city = player.getCity();

        return city.getTotalBarbarianCount() > 0 && city.getLegionCount() > 0;
    }

    public boolean canRecruitBarbarians() {
        Player player = game.getLocalPlayer();
        City city = player.getCity();
        Faction[] factions = city.getFactions();

        for (Faction faction: factions) {
            if (game.isFriendlyFaction(faction) && city.getBarbarianCount(faction.getFactionType()) > 0) return true;
        }

        return false;
    }

    public boolean canRecruitLegions() {
        Player player = game.getLocalPlayer();
        City city = player.getCity();

        return city.hasFort();
    }

    public boolean canBuildFort() {
        Player player = game.getLocalPlayer();
        City city = player.getCity();

        return (!city.hasFort() && getFortAmount() < 6);
    }

    @Override
    public void registerObserver(IObserver view) {
        game.registerObserver(view);
    }

    public void formAlliance() {
        Player player = getLocalPlayer();
        Faction faction = player.formableAlliances().get(0);

        // Ally this faction
        faction.ally();

        // Remove cards
        List<Card> cardsToDiscard = player.getCitycardsWithFaction(faction);
        player.getHand().removeCards(cardsToDiscard.toArray(new Card[0]));

        player.decreaseActionsRemaining();
    }
    
    public void changeMusic() {
    	Main.musicManager.stop();
    	Main.musicManager.playPlaylist();
    }

    public boolean canFormAlliance() {
        Player player = getLocalPlayer();

        return player.formableAlliances().size() > 0;
    }

    public List<Faction> getFriendlyFactions() {
        return Game.getInstance().getFriendlyFactions();
    }
}
