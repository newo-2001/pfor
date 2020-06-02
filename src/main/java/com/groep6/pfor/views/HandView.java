package com.groep6.pfor.views;

import com.groep6.pfor.controllers.HandController;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.cards.EventCard;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UICard;
import com.groep6.pfor.views.components.UICityCard;
import com.groep6.pfor.views.components.UIEventCard;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * The view that represents a player's hand with cards
 * @author Bastiaan Jansen
 * @author Nils van der Velden
 */
public class HandView extends View implements IObserver {
    private HandController handController;

    /** The list of cards that the player has, as CardView's */
    private List<Card> cards = new ArrayList<>();

    private BorderPane root;
    private Button discardCardButton;
    private Button playCardButton;
    private Button goBackButton;
    private ScrollPane scrollPane;
    private FlowPane cardsPane;
    private List<UICard> uiCards = new ArrayList<>();

    public HandView(HandController handController) {
        this.handController = handController;
        cards = handController.getCards();
        handController.registerObserver(this);

        createView();

        update();
    }

    private void createView() {
        root = new BorderPane();

        scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(-1));

        VBox buttonsPane = new VBox(20);
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setPadding(new Insets(50, 50, 50, 50));

        discardCardButton = new UIButton("Kaart afleggen");
        discardCardButton.setDisable(true);
        discardCardButton.setPrefWidth(150);
        discardCardButton.addEventFilter(MouseEvent.MOUSE_CLICKED, discardCard);

        playCardButton = new UIButton("Speel kaart");
        playCardButton.setPrefWidth(150);
        playCardButton.setBackground(new Background(new BackgroundFill(Color.web("#28c946"), CornerRadii.EMPTY, Insets.EMPTY)));
        playCardButton.addEventFilter(MouseEvent.MOUSE_CLICKED, playCard);
        
        goBackButton = new UIButton("Ga terug");
        goBackButton.setDisable(false);
        goBackButton.setPrefWidth(150);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);

        buttonsPane.getChildren().addAll(discardCardButton, playCardButton, goBackButton);
        buttonsPane.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));

        root.setCenter(scrollPane);
        root.setRight(buttonsPane);
    }

    private void createCards() {
        cardsPane = new FlowPane();
        setBackground(cardsPane, "images/character_info_background.jpg");
        cardsPane.setPadding(new Insets(20, 20, 20, 20));
        cardsPane.setVgap(50);
        cardsPane.setHgap(50);

        scrollPane.setContent(cardsPane);
        
        for (Card card: cards) {
            UICard uiCard = null;

            if (card instanceof CityCard) uiCard = new UICityCard((CityCard) card);
            else if (card instanceof EventCard) uiCard = new UIEventCard((EventCard) card);

            if (uiCard != null) {
                uiCard.addEventFilter(MouseEvent.MOUSE_CLICKED, selectCard);
                uiCards.add(uiCard);
                cardsPane.getChildren().add(uiCard);
            }
        }
    }
    

    EventHandler<MouseEvent> goBack = new EventHandler<MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
        	handController.goBack();
        }
    };
    
    
    EventHandler<javafx.scene.input.MouseEvent> discardCard = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            handController.removeSelectedCard();
        }
    };
    
    EventHandler<javafx.scene.input.MouseEvent> playCard = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            //handController.playCard(card);
        }
    };

    // Select a card
    EventHandler<MouseEvent> selectCard = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            deselectAllCards();
            UICard source = (UICard) e.getSource();
            source.select();
            handController.selectCard(source.getCard());
            discardCardButton.setDisable(false);
        }
    };

    public void deselectAllCards() {
        for (UICard card: uiCards) {
            card.deselect();
        }
    }
    
    public void handleCardLimit() {
        if(cards.size() > 7) {
        	goBackButton.setDisable(true);
        } else {
        	goBackButton.setDisable(false);
        }
    }
    

    @Override
    public Pane getRoot() {
        return root;
    }

    @Override
    public void update() {
        createCards();
        handleCardLimit();
        discardCardButton.setDisable(true);
    	//goBackButton.setDisable(false);
    }
}

