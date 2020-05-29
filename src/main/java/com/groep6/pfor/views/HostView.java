package com.groep6.pfor.views;

import com.groep6.pfor.controllers.HostController;
import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The view that show's the screen to create a lobby as a host
 * @author Mathijs
 */
public class HostView extends View implements IObserver {
    /** The hostController */
    private HostController hostController;

    public HostView() {
        hostController = new HostController();

        BorderPane root = new BorderPane();

        scene = new Scene(root);
    }

    @Override
    public void update() {

    }
}
