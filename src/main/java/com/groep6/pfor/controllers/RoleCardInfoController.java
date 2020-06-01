package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RoleCardInfoView;

public class RoleCardInfoController extends Controller {

    public RoleCardInfoController() {
        viewController.showView(new RoleCardInfoView(this));
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}
