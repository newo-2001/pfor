package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.CardView;

public class CardController extends Controller {

    public CardController() {
        viewController.showView(new CardView(this));
    }

    @Override
    public void registerObserver(IObserver view) {

    }

}
