package com.groep6.pfor.views;

import java.util.ArrayList;
import java.util.List;

import com.groep6.pfor.controllers.TradeController;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UICard;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * The view where you can trade cards with the trade deck
 * @author Nils van der Velden
 */
public class TradeView extends View implements IObserver {
    /** The tradeController */
    private TradeController tradeController;
    
    private List<Card> cards = new ArrayList<>();
    
    private BorderPane root;

    /**
     * The constructor
     * @param tradeController the tradeController
     */
    public TradeView(TradeController tradeController) {
        this.tradeController = tradeController;
        cards = tradeController.getTradeCard();
        
        createView();
    }
    
    private void createView() {
        root = new BorderPane();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        FlowPane cardsPane = new FlowPane();
        cardsPane.setPadding(new Insets(20, 20, 20, 20));
        cardsPane.setVgap(50);
        cardsPane.setHgap(50);
        
        for (Card card: cards) {
//            UICard uiCard = new UICard("KAART");
//            cardsPane.getChildren().add(uiCard);
        }
        
        scrollPane.setContent(cardsPane);

        VBox buttonsPane = new VBox(20);
        buttonsPane.setAlignment(Pos.CENTER);
        buttonsPane.setPadding(new Insets(50, 50, 50, 50));

        Button discardCardButton = new UIButton("Withdrawal card");
        discardCardButton.setPrefWidth(150);

        Button playCardButton = new UIButton("Deposit card");
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
    }
    
    EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            tradeController.goBack();
        }
    };
        
    

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pane getRoot() {
		return root;
	}

}
