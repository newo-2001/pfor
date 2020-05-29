package com.groep6.pfor.views;

import com.groep6.pfor.controllers.HandController;
import com.groep6.pfor.util.IObserver;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

/**
 * The view that represents a player's hand with cards
 * @author Bastiaan Jansen
 */
public class HandView extends View implements IObserver {
    /** The handController */
    private HandController handController;
    private Scene scene;

    /** The list of cards that the player has, as CardView's */
    private ArrayList<CardView> cards;

    /**
     * The constructor
     * @param cards A list of CardView's, the cards that the player currently has
     */
    public HandView(ArrayList<CardView> cards) {
        handController = new HandController();
        this.cards = cards;

        BorderPane root = new BorderPane();

        scene = new Scene(root);
    }

    @Override
    public void update() {

    }

    @Override
    public Scene getScene() {
        return null;
    }
}
