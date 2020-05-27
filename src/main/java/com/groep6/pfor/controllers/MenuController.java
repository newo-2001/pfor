package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Board;
import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.View;

/**
 * @author Bastiaan Jansen
 */
public class MenuController {

    private static MenuController INSTANCE = new MenuController();

    private MenuController() {}

    public static MenuController getInstance() {
        return INSTANCE;
    }

    public void buttonClicked() {
        ViewController.showView(new BoardView(ViewController.getPrimaryStage()));
    }

}
