package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Board;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.BoardView;
import com.groep6.pfor.views.MenuView;
import com.groep6.pfor.views.View;

/**
 * @author Bastiaan Jansen
 */
public class MenuController extends Controller {

    private static MenuController INSTANCE = new MenuController();

    private MenuController() {}

    public static MenuController getInstance() {
        return INSTANCE;
    }

    public void buttonClicked() {
        viewController.showView(new BoardView(viewController.getPrimaryStage()));
    }

    @Override
    public void registerObserver(IObserver view) {}
}
