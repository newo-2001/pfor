package com.groep6.pfor.views.components;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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
		
		Text playerID = new Text("Speler " + playerNumber);
		playerID.setFont(Font.font("verdana", FontWeight.NORMAL,
                FontPosture.REGULAR, 13));
        playerID.setFill(Color.WHITE);
        
        Text playerName = new Text(userName);
        playerName.setFont(Font.font("verdana", FontWeight.NORMAL,
        		FontPosture.REGULAR, 13));
        playerName.setFill(Color.WHITE);
        
        Text role = new Text("(" + playerRole + ")");
        role.setFont(Font.font("verdana", FontWeight.NORMAL,
        		FontPosture.REGULAR, 13));
        role.setFill(Color.WHITE);
		
		getChildren().addAll(playerDot, playerID, playerName, role);
	}

}
