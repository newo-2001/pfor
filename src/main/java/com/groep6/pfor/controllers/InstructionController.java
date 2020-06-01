package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.InstructionView;

public class InstructionController extends Controller {

    public InstructionController() {
        viewController.showView(new InstructionView(this));
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}
