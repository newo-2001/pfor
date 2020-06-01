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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * The view that shows a card's information
 * @author Nils van der Velden
 */
public class RoleCardInfoView extends View {

    private RoleCardInfoController roleCardInfoController;

    private BorderPane root;

    public RoleCardInfoView(RoleCardInfoController roleCardInfoController) {
        this.roleCardInfoController = roleCardInfoController;
        
        createView();
    }

    public void createView() {
        root = new BorderPane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        FlowPane cardsPane = new FlowPane();
        cardsPane.setPadding(new Insets(20, 20, 20, 20));
        cardsPane.setVgap(50);
        cardsPane.setHgap(50);

        for (RoleCard card: roleCardInfoController.getRoleCards()) {
            UICard uicard = new UICard(card.getName());
            cardsPane.getChildren().add(uicard);
        }
        
        scrollPane.setContent(cardsPane);
        
        VBox buttonsPane = new VBox(20);
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setPadding(new Insets(50, 50, 50, 50));
        
        Button goBackButton = new UIButton("Ga terug");
        goBackButton.setPrefWidth(150);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);

        buttonsPane.getChildren().addAll(goBackButton);
        buttonsPane.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));

        root.setCenter(scrollPane);
        root.setRight(buttonsPane);
    }

        EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(javafx.scene.input.MouseEvent e) {
                roleCardInfoController.goBack();
            }
        };

    @Override
    public Pane getRoot() {
        return root;
    }
}

