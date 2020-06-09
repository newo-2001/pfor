package com.groep6.pfor.controllers;

import java.util.List;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.Tile;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.views.BoardView;

/**
 * @author Bastiaan Jansen
 */
public class BoardController extends Controller {

    private Game game = Game.getInstance();

    public BoardController() {
    	queueMusic();
        viewController.showView(new BoardView(this));
    };
    
    public void queueMusic() {
    	// to be expanded.
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

    @Override
    public void registerObserver(IObserver view) {
        game.registerObserver(view);
    }
}
