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
	
	public UIPlayerInfo(Color playerColor, int playerNumber, String userName, String playerRole) {
		createDisplay(playerColor, playerNumber, userName, playerRole);
		setPadding(new Insets(0, 20, 0, 20));
		for (Node child: this.getChildren()) {
			setMargin(child, new Insets(0, 3, 0, 3));
		}
	}
	
	private void createDisplay(Color playerColor, int playerNumber, String userName, String playerRole) {
		
		Circle playerDot = new Circle();
		playerDot.setFill(playerColor);
		playerDot.setRadius(12);

		VBox playerInfoBox = new VBox(3);
		
		UIText playerID = new UIText("Speler " + playerNumber);
		playerID.setColor(Color.WHITE).setSize(13);

		UIText playerName = new UIText(userName + " (" + playerRole + ")");
		playerName.setColor(Color.WHITE).setSize(13);

		playerInfoBox.getChildren().addAll(playerID, playerName);
		setSpacing(5);
        setAlignment(Pos.CENTER);
		getChildren().addAll(playerDot, playerInfoBox);
	}

}
