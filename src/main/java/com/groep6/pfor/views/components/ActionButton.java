package com.groep6.pfor.views.components;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class ActionButton extends UIButton {
	
	public ActionButton(String text) {
		super(text);
		setPrefSize(150, 60);
		setBackground(new Background(new BackgroundFill(Color.web("#ef4140"), CornerRadii.EMPTY, Insets.EMPTY)));
		setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		setWrapText(true);
	}

}
