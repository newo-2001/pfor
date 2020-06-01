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
        setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(2))));

        UIText playerNumberText = new UIText("Speler " + playerNumber);
        playerNumberText.setWeight(FontWeight.BOLD).setSize(15).setAlignment(TextAlignment.CENTER).setFill(Color.WHITE);

        GridPane gridPane = new GridPane();
        gridPane.setVgap(20);
        gridPane.setHgap(30);
        gridPane.setPadding(new Insets(20, 10, 10, 10));

        UIText playerLabelText = new UIText("Gebruikersnaam:");
        playerLabelText.setFill(Color.WHITE);

        UIText playerValueText = new UIText(username);
        playerValueText.setFill(Color.WHITE);

        UIText roleLabelText = new UIText("Karakter:");
        roleLabelText.setFill(Color.WHITE);

        UIText roleValueText = new UIText(roleCard.getName());
        roleValueText.setFill(Color.WHITE);

        UIText colorLabelText = new UIText("Kleur:");
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
