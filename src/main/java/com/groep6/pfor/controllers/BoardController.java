package com.groep6.pfor.controllers;

import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.MenuView;

public class BoardController extends Controller {

    private static final BoardController INSTANCE = new BoardController();

    private BoardController() {};

    public static BoardController getInstance() { return INSTANCE; }

    @Override
    void registerObserver() {

    }

    public void goToMenu() {
        ViewController.showView(new MenuView(ViewController.getPrimaryStage()));
    }

}
