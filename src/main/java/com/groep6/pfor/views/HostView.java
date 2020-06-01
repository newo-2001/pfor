package com.groep6.pfor.views;

import com.groep6.pfor.controllers.HostController;
import com.groep6.pfor.exceptions.EmptyFieldException;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UIPasswordField;
import com.groep6.pfor.views.components.UITextField;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

/**
 * The view that show's the screen to create a lobby as a host
 * @author Bastiaan Jansen
 */
public class HostView extends View implements IObserver {

    private HostController hostController;

    private UITextField usernameTextField;
    private UITextField passwordTextField;

    public HostView(HostController hostController) {
        this.hostController = hostController;

        StackPane root = new StackPane();

        VBox form = new VBox();

        Text text = new Text("Host Game");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        text.setFill(Color.WHITE);

        usernameTextField = new UITextField("Username");
        usernameTextField.getLabel().setTextFill(Color.WHITE);
        passwordTextField = new UIPasswordField("Password");
        passwordTextField.getLabel().setTextFill(Color.WHITE);

        Button hostGameButton = new UIButton("Host Game");
        hostGameButton.setPadding(new Insets(10));
        hostGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, hostGame);

        form.getChildren().addAll(text, usernameTextField, passwordTextField, hostGameButton);
        form.setSpacing(10);
        form.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        form.setPadding(new Insets(400));
        form.setAlignment(Pos.CENTER);

        root.getChildren().add(form);
        scene = new Scene(root);
    }

    /**
     * Send the username and password to the controller
     */
    EventHandler<MouseEvent> hostGame = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            String username = usernameTextField.getValue();
            String password = passwordTextField.getValue();

            try {
                hostController.createLobby(password, username, password); //even plaatsvervangend dubbel password i.p.v. unieke code
            } catch (EmptyFieldException error) {
                System.out.println(error.getMessage());
            }

        }
    };

    @Override
    public void update() {

    }
}
