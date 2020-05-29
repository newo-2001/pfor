package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Board;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.*;

/**
 * @author Bastiaan Jansen
 */
public class MenuController extends Controller {

    public void buttonClicked() {
        viewController.showView(new BoardView(viewController.getPrimaryStage()));
    }

    public void goToHostView() {
        viewController.showView(new HostView(viewController.getPrimaryStage()));
    }

    public void goToJoinView() {
        viewController.showView(new JoinView(viewController.getPrimaryStage()));
    }

    @Override
    public void registerObserver(IObserver view) {}
}
