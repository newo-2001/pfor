package com.groep6.pfor.views.components;

import com.groep6.pfor.models.cards.RoleCard;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class UILobbyPlayerInfo extends VBox {

    private int playerNumber;
    private String username;
    private RoleCard roleCard;

    public UILobbyPlayerInfo(int playerNumber, String username, RoleCard roleCard) {
        this.playerNumber = playerNumber;
        this.username = username;
        this.roleCard = roleCard;

        createView();
    }

    private void createView() {

        setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        setPadding(new Insets(30));

        Text playerNumberText = new Text("Player " + playerNumber);
        playerNumberText.setTextAlignment(TextAlignment.CENTER);
        playerNumberText.setFill(Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(30);
        gridPane.setPadding(new Insets(20, 10, 10, 10));

        Text playerLabelText = new Text("Spelernaam:");
        playerLabelText.setFill(Color.WHITE);

        Text playerValueText = new Text(username);
        playerValueText.setFill(Color.WHITE);

        Text roleLabelText = new Text("Karakter:");
        roleLabelText.setFill(Color.WHITE);

        Text roleValueText = new Text(roleCard.getName());
        roleValueText.setFill(Color.WHITE);

        Text colorLabelText = new Text("Kleur:");
        colorLabelText.setFill(Color.WHITE);

        gridPane.add(playerLabelText, 0, 0);
        gridPane.add(playerValueText, 1, 0);
        gridPane.add(roleLabelText, 0, 1);
        gridPane.add(roleValueText, 1, 1);
        gridPane.add(colorLabelText, 0, 2);

        getChildren().addAll(playerNumberText, gridPane);
        setAlignment(Pos.CENTER);
    }

}
