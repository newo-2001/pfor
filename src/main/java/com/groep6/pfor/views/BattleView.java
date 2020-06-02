package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BattleController;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * BattleView. Shows the result of a passed battle.
 * @author Mathijs
 * @author Mitchell van Rijswijk
 */
public class BattleView extends View implements IObserver {
    /** The battleController */
    private BattleController battleController;
    private BorderPane root;
    private int[] battleResult;

    /**
     * The constructor
     * @param battleController The battleController
     */
    public BattleView(BattleController controller, int[] result) {
        battleController = controller;
        battleController.registerObserver(this);
        battleResult = result;
        createView();
        update();
    }
    
    public void createView() {
    	root = new BorderPane();
    	VBox log = new VBox();
    	
    	Text legionsLost = new Text(battleResult[0] + " Legions were killed");
        legionsLost.setFont(Font.font("verdana", FontWeight.NORMAL,
        		FontPosture.REGULAR, 32));
        legionsLost.setFill(Color.WHITE);
        
    	Text barbariansLost = new Text(battleResult[1] + " Barbarians were killed");
        barbariansLost.setFont(Font.font("verdana", FontWeight.NORMAL,
        		FontPosture.REGULAR, 32));
        barbariansLost.setFill(Color.WHITE);
        
        Button goBackButton = new UIButton("Ga terug");
        goBackButton.setPadding(new Insets(10));
        goBackButton.setMinWidth(100);
        goBackButton.setMaxWidth(100);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);
        
    	log.getChildren().addAll(legionsLost, barbariansLost, goBackButton);
    	log.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
    	log.setAlignment(Pos.CENTER);
    	log.setSpacing(24);
    	BorderPane.setMargin(log, new Insets(400, 750, 400, 750));
        BackgroundImage postBattle = new BackgroundImage(new Image("images/battle_result_image.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, true, true, true, true));
        root.setBackground(new Background(postBattle));
    	root.setCenter(log);
    }
    
    EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            battleController.goBack();
        }
    };

    @Override
    public void update(Object... data) {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}
