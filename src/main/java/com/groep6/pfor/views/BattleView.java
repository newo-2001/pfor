package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BattleController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UIText;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * BattleView. Shows the result of a passed battle.
 * @author Mathijs
 * @author Mitchell van Rijswijk
 */
public class BattleView extends View implements IObserver {
    /** The battleController */
    private final BattleController battleController;
    private StackPane root;
    private int legionsLost = 0;
    private int barbariansLost = 0;

    /**
     * The constructor
     * @param controller The battleController
     */
    public BattleView(BattleController controller, int legionsLost, int barbariansLost) {
        battleController = controller;
        this.legionsLost = legionsLost;
        this.barbariansLost = barbariansLost;
        battleController.registerObserver(this);
        createView();
        update();
    }
    
    /**
     * Create the post battle screen. Displays amount of legions died, and amount of barbarians died.
     */
    public void createView() {
    	root = new StackPane();

    	VBox log = new VBox();
    	log.setMaxSize(500, 300);
    	
    	UIText legionsLost = new UIText(this.legionsLost + " Legioenen zijn gesneuveld");
    	legionsLost.setSize(32).setColor(Color.WHITE);
        
    	UIText barbariansLost = new UIText(this.barbariansLost + " Barbaren zijn gesneuveld");
    	barbariansLost.setSize(32).setColor(Color.WHITE);
        
        Button goBackButton = new UIButton("Ga terug");
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);
        
    	log.getChildren().addAll(legionsLost, barbariansLost, goBackButton);
    	log.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
    	log.setAlignment(Pos.CENTER);
    	log.setPadding(new Insets(50));
    	log.setSpacing(24);

        setBackground(root, "/images/background-3.jpg");
    	root.getChildren().add(log);
    }
    
    EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            battleController.goBack();
        }
    };

    @Override
    public void update() {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}
