package com.groep6.pfor.controllers;

import java.util.List;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.Tile;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.services.GameService;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.HandView;

/**
 * @author Bastiaan Jansen
 */
public class BoardController extends Controller {

    private Game game = Game.getInstance();

    public BoardController() {
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
        System.out.println(city);
    }

    public Player getLocalPlayer() {
        return game.getLocalPlayer();
    }
    
    public void move(City city) {
        Player player = Game.getInstance().getLocalPlayer();
    	player.move(city);
        player.decreaseActionsRemaining();
    }

    public void nextTurn() {
        // Draw 2 cards from game deck
        Player player = game.getLocalPlayer();
        player.getHand().addCards(game.getPlayerCardsDeck().draw(), game.getPlayerCardsDeck().draw());

        // Open hand when there are more than 7 cards in hand
        if (player.getHand().getCards().size() > 7) new HandController();

        // Next turn
        game.nextTurn();
        GameService gameService = new GameService();
        gameService.setGame(game);
    }

    public void buildFort() {
        Player player = game.getLocalPlayer();
        City city = player.getCity();
        city.placeFort();
        player.decreaseActionsRemaining();
    }

    public boolean canRecruitBarbarians() {
        Player player = game.getLocalPlayer();
        City city = player.getCity();
        Faction[] factions = city.getFactions();

        for (Faction faction: factions) {
            if (game.isFriendlyFaction(faction)) return true;
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

        return !city.hasFort();
    }

    @Override
    public void registerObserver(IObserver view) {
        game.registerObserver(view);
    }

    public void formAlliance() {
        getLocalPlayer().formAlliance(getLocalPlayer().formableAlliances().get(0));
    }

    public boolean canFormAlliance() {
        return getLocalPlayer().formableAlliances().size() > 0;
    }

    public List<Faction> getFriendlyFactions() {
        return Game.getInstance().getFriendlyFactions();
    }
}
