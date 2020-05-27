package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.View;

import java.util.List;

public class BoardController extends Controller {

    private static final BoardController INSTANCE = new BoardController();
    private Game game;

    private BoardController() {
        this.game = Game.getInstance();
    };

    public static BoardController getInstance() { return INSTANCE; }

    public void goToMenu() {
        ViewController.showView(new MenuView(ViewController.getPrimaryStage()));
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
