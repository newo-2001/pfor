package com.groep6.pfor.views.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;

import java.awt.*;

public class UICard extends BorderPane {

    public UICard(String name) {
        setMinWidth(220);
        setMinHeight(300);

        BackgroundImage backgroundImage = new BackgroundImage(new Image("images/paper.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        setBackground(new Background(backgroundImage));

        Text nameText = new Text(name);
        nameText.setFont(Font.font("verdana", FontWeight.BOLD,
                FontPosture.REGULAR, 18));

        setCenter(nameText);
    }

}
