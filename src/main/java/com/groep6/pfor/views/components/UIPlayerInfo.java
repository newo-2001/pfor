package com.groep6.pfor.views.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;

public class UIPlayerInfo extends HBox {

	private Color playerColor;
	private int playerNumber;
	private String username;
	private String playerRole;
	private boolean isTurn;
	private int actionCount;
	
	public UIPlayerInfo(Color playerColor, int playerNumber, String username, String playerRole, boolean isTurn, int actionCount) {
		this.playerColor = playerColor;
		this.playerNumber = playerNumber;
		this.username = username;
		this.playerRole = playerRole;
		this.isTurn = isTurn;
		this.actionCount = actionCount;

		createDisplay();
		setPadding(new Insets(0, 20, 0, 20));
		setSpacing(10);
	}
	
	private void createDisplay() {
		
		Circle playerDot = new Circle();
		playerDot.setFill(playerColor);
		playerDot.setRadius(12);

		VBox playerInfoBox = new VBox(3);

		TextFlow topText = new TextFlow();

		UIText playerID = new UIText("Speler " + playerNumber);
		playerID.setColor(Color.WHITE).setSize(13);
		topText.getChildren().add(playerID);

		UIText playerActionCount = new UIText(" (" + actionCount + " acties)");
		playerActionCount.setColor(Color.WHITE);
		if (isTurn) topText.getChildren().add(playerActionCount);

		UIText playerName = new UIText(username + " (" + playerRole + ")");
		playerName.setColor(Color.WHITE).setSize(13);

		if (isTurn) {
			playerID.setWeight(FontWeight.BOLD);
			playerActionCount.setWeight(FontWeight.BOLD);
			playerName.setWeight(FontWeight.BOLD);
			playerDot.setStroke(Color.WHITE);
			playerDot.setStrokeWidth(3);
		}

		playerInfoBox.getChildren().addAll(topText, playerName);
		setSpacing(5);
        setAlignment(Pos.CENTER);
		getChildren().addAll(playerDot, playerInfoBox);
	}

}
