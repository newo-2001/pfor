package com.groep6.pfor.views;

import com.groep6.pfor.controllers.JoinController;
import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * The view where you can join a lobby using a code and a password if required
 * @author Mathijs
 */
public class JoinView extends View implements IObserver {
    /** The joinController */
    private JoinController joinController;

    public JoinView() {
        joinController = new JoinController();

        BorderPane root = new BorderPane();

        scene = new Scene(root);
    }

    @Override
    public void update() {

    }
}
