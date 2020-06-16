package com.groep6.pfor.views;

import com.groep6.pfor.controllers.HandController;
import com.groep6.pfor.models.cards.Card;
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
    private final HandController handController;

    /** The list of cards that the player has, as CardView's */
    private List<Card> cards = new ArrayList<>();

    private BorderPane root;
    private Button discardCardButton;
    private Button playCardButton;
    private Button goBackButton;
    private Button depositCardButton;
    private ScrollPane scrollPane;
    private FlowPane cardsPane;
    private final List<UICard> uiCards = new ArrayList<>();

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

        discardCardButton = new UIButton("Kaart verwijderen");
        discardCardButton.setDisable(true);
        discardCardButton.setPrefWidth(150);
        if (handController.getLocalPlayer().getActionsRemaining() <= 0) discardCardButton.setDisable(true);
        discardCardButton.addEventFilter(MouseEvent.MOUSE_CLICKED, discardCard);

        playCardButton = new UIButton("Speel kaart");
        playCardButton.setDisable(true);
        playCardButton.setPrefWidth(150);
        playCardButton.setBackground(new Background(new BackgroundFill(Color.web("#28c946"), CornerRadii.EMPTY, Insets.EMPTY)));
        playCardButton.addEventFilter(MouseEvent.MOUSE_CLICKED, playCard);
        
        goBackButton = new UIButton("Ga terug");
        goBackButton.setDisable(false);
        goBackButton.setPrefWidth(150);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);
        
        depositCardButton = new UIButton("Kaart afleggen");
        depositCardButton.setDisable(true);
        depositCardButton.setPrefWidth(150);
        depositCardButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        depositCardButton.addEventFilter(MouseEvent.MOUSE_CLICKED, depositCard);

        buttonsPane.getChildren().addAll(depositCardButton, discardCardButton, playCardButton, goBackButton);
        buttonsPane.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));

        // Cards
        cardsPane = new FlowPane();
        setBackground(cardsPane, "/images/background-4.jpg");
        cardsPane.setPadding(new Insets(20, 20, 20, 20));
        cardsPane.setVgap(50);
        cardsPane.setHgap(50);
        scrollPane.setContent(cardsPane);

        root.setCenter(scrollPane);
        root.setRight(buttonsPane);
    }

    private void createCards() {
        cardsPane.getChildren().clear();
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
        	handController.goToBoard();
        }
    };
    
    
    EventHandler<MouseEvent> discardCard = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            handController.removeSelectedCard();
            discardCardButton.setDisable(true);
            goBackButton.setDisable(false);
        }
    };
    
    EventHandler<MouseEvent> depositCard = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
        	handController.depositCard();
            if (handController.getLocalPlayer().getActionsRemaining() <= 0) depositCardButton.setDisable(true);
        }
    };
    
    EventHandler<MouseEvent> playCard = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            handController.playCard();
            playCardButton.setDisable(true);
        }
    };

    // Select a card
    EventHandler<MouseEvent> selectCard = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            deselectAllCards();
            UICard source = (UICard) e.getSource();
            source.select();
            handController.selectCard(source.getCard());
            discardCardButton.setDisable(false);
            if (handController.getLocalPlayer().getActionsRemaining() > 0 && handController.getLocalPlayer().isTurn()) depositCardButton.setDisable(false);

            playCardButton.setDisable(!(source instanceof UIEventCard));
        }
    };

    public void deselectAllCards() {
        for (UICard card: uiCards) {
            card.deselect();
        }
    }
    
    public void handleCardLimit() {
        goBackButton.setDisable(cards.size() > 7);
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
        depositCardButton.setDisable(true);

        playCardButton.setDisable(!handController.getLocalPlayer().isTurn());
    }
}

