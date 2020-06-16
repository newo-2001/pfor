package com.groep6.pfor.views.components;

import javafx.scene.text.Text;

public class UIBorderedText extends Text {
    public UIBorderedText(String text, String borderColor, int borderWidth, String fillColor) {
        super(text);
        setStyle(borderColor, borderWidth, fillColor);
    }

    private void setStyle(String borderColor, int borderWidth, String fillColor) {
        setStyle(String.format("-fx-stroke: %s; -fx-stroke-width: %2dpx; -fx-font-weight: bold; -fx-fill: %s;", borderColor, borderWidth, fillColor));
    }
}