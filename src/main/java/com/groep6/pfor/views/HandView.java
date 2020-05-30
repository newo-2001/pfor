package com.groep6.pfor.views;

import com.groep6.pfor.controllers.HandController;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.util.IObserver;
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
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * The view that represents a player's hand with cards
 * @author Bastiaan Jansen
 */
public class HandView extends View {
    private HandController handController;

    /** The list of cards that the player has, as CardView's */
    private List<Card> cards = new ArrayList<>();

    public HandView() {
        handController = new HandController();
        cards = handController.getCards();

        createView();
    }

    private void createView() {
        BorderPane root = new BorderPane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        FlowPane cardsPane = new FlowPane();
        cardsPane.setPadding(new Insets(20, 20, 20, 20));
        cardsPane.setVgap(50);
        cardsPane.setHgap(50);

        for (Card card: cards) {
            UICard uiCard = new UICard(card.getName());
            cardsPane.getChildren().add(uiCard);
        }

        scrollPane.setContent(cardsPane);

        VBox buttonsPane = new VBox(20);
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setPadding(new Insets(50, 50, 50, 50));

        Button discardCardButton = new UIButton("Kaart afleggen");
        discardCardButton.setPrefWidth(150);

        Button playCardButton = new UIButton("Speel kaart");
        playCardButton.setPrefWidth(150);
        playCardButton.setBackground(new Background(new BackgroundFill(Color.web("#28c946"), CornerRadii.EMPTY, Insets.EMPTY)));

        Button goBackButton = new UIButton("Ga terug");
        goBackButton.setPrefWidth(150);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);

        buttonsPane.getChildren().addAll(discardCardButton, playCardButton, goBackButton);
        buttonsPane.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));

        root.setCenter(scrollPane);
        root.setRight(buttonsPane);
        scene = new Scene(root);
    }

    EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            handController.goBack();
        }
    };
}
