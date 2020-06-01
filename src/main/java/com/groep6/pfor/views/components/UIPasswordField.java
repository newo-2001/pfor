package com.groep6.pfor.views.components;

import javafx.scene.control.PasswordField;

public class UIPasswordField extends UITextField {
    public UIPasswordField(String labelText) {
        super(labelText);
        getChildren().remove(textField);
        textField = new PasswordField();
        getChildren().add(textField);
    }
}
