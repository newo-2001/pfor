package com.groep6.pfor.views;

import com.groep6.pfor.controllers.RoleCardInfoController;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UICard;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * The view that shows the role card's information
 * @author Nils van der Velden
 */
public class RoleCardInfoView extends View {

    /** The RoleCardInfo controller  */
    private RoleCardInfoController roleCardInfoController;
    
    /**
     * Initializes the RoleCardInfoView
     * @param the roleCardInfoController
     */

    public RoleCardInfoView(RoleCardInfoController roleCardInfoController) {
        this.roleCardInfoController = roleCardInfoController;
        
        createView();
    }

    public void createView() {
        /** Pane to put the different elements in  */
        BorderPane root = new BorderPane();
        
        /** ScrollPane to allow the user to scroll through the different role cards  */
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        
        /** FlowPane that represents the individual cards */
        FlowPane cardsPane = new FlowPane();
        cardsPane.setPadding(new Insets(20, 20, 20, 20));
        cardsPane.setVgap(50);
        cardsPane.setHgap(50);

        /** For loop to get the different role cards and put there information in the flowPane*/
        for (RoleCard card: roleCardInfoController.getRoleCards()) {
            UICard uicard = new UICard(card.getName());
            cardsPane.getChildren().add(uicard);
        }
        /** Put the different cards in the scrollPane */
        scrollPane.setContent(cardsPane);
        
        /** ButtonPane to put the button in */
        VBox buttonPane = new VBox(20);
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.setPadding(new Insets(50, 50, 50, 50));
        
        /** Creates the back button */
        Button goBackButton = new UIButton("Ga terug");
        goBackButton.setPrefWidth(150);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);

        /** Puts the back button in the buttonBox */
        buttonPane.getChildren().addAll(goBackButton);
        buttonPane.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));

        /** Puts the scrollPane and buttonPane into the BorderPane */
        root.setCenter(scrollPane);
        root.setRight(buttonPane);
        
        /** Creates a scene that uses the BorderPane filled with elements */
        scene = new Scene(root);
    }

    	/** Event handler for the back button */
        EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                roleCardInfoController.goBack();
            }
        };
    }

