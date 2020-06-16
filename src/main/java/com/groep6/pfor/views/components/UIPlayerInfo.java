package com.groep6.pfor.views.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;

public class UIPlayerInfo extends HBox {

	private final Color playerColor;
	private final int playerNumber;
	private final String username;
	private final String playerRole;
	private final boolean isTurn;
	private final int actionCount;
	
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

		UIText playerName = new UIText(username);
		playerName.setColor(Color.WHITE).setSize(13);
		topText.getChildren().add(playerName);

		UIText playerActionCount = new UIText(" (" + actionCount + " acties)");
		playerActionCount.setColor(Color.WHITE);

		UIText playerRoleText = new UIText(playerRole);
		playerRoleText.setColor(Color.WHITE);

		if (isTurn) {
			topText.getChildren().add(playerActionCount);
			playerActionCount.setWeight(FontWeight.BOLD);
			playerRoleText.setWeight(FontWeight.BOLD);
			playerName.setWeight(FontWeight.BOLD);
			playerDot.setStroke(Color.WHITE);
			playerDot.setStrokeWidth(3);
		}

		playerInfoBox.getChildren().addAll(topText, playerRoleText);
		setSpacing(5);
        setAlignment(Pos.CENTER);
		getChildren().addAll(playerDot, playerInfoBox);
	}

}
