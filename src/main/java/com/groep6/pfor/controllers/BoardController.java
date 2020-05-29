package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.View;

import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class BoardController extends Controller {

    private Game game;

    public BoardController() {
        game = Game.getInstance();
    };

    public void goToMenu() {
        viewController.showView(new MenuView());
    }

    public void increaseDecayLevel() {
        game.increaseDecayLevel();
    }

    public int getDecayLevel() {
        return game.getDecayLevel();
    }

    @Override
    public void registerObserver(IObserver view) {
        game.registerObserver(view);
    }
}
