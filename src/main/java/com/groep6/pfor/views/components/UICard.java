package com.groep6.pfor.views.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;

import java.awt.*;

public class UICard extends BorderPane {

    public UICard(String name) {
        setMinWidth(220);
        setMinHeight(300);
        setBackground(new Background(new BackgroundFill(Color.web("#feffd9"), CornerRadii.EMPTY, Insets.EMPTY)));

        Text nameText = new Text(name);
        nameText.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 20));

        setCenter(nameText);
    }

}
