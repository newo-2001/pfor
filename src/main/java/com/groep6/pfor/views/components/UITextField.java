package com.groep6.pfor.views.components;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Reusable TextField component with label
 * @author Bastiaan Jansen
 */
public class UITextField extends VBox {

    private final Label label;
    protected TextField textField;

    public UITextField(String labelText) {

        label = new Label(labelText);
        textField = new TextField();

        setSpacing(5);
        getChildren().addAll(label, textField);

    }

    public String getValue() {
        return textField.getText();
    }

    public Label getLabel() {
        return label;
    }

    public TextField getTextField() {
        return textField;
    }

}
