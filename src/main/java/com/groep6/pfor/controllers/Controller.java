package com.groep6.pfor.controllers;

import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.View;
import javafx.stage.Stage;

public abstract class Controller {

    public abstract void registerObserver(IObserver view);
}
