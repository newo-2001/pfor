package com.groep6.pfor.controllers;

import java.util.List;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.Tile;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.views.BoardView;

/**
 * @author Bastiaan Jansen
 */
public class BoardController extends Controller {

    private Game game = Game.getInstance();

    public BoardController() {
    	MusicManager.getInstance().addToQueue("src/main/resources/sounds/music/Seeds_of_the_Past.mp3");
        viewController.showView(new BoardView(this));
    };
    
    public void goToBattleView() {
    	new BattleController();
    }

    public void goToInstructionView() {
        new InstructionController();
    }

    public void goToHand() {
        new HandController();
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

    @Override
    public void registerObserver(IObserver view) {
        game.registerObserver(view);
    }
}
