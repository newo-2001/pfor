package com.groep6.pfor.views;

import com.groep6.pfor.controllers.HostController;
import com.groep6.pfor.exceptions.EmptyFieldException;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UIPasswordField;
import com.groep6.pfor.views.components.UIText;
import com.groep6.pfor.views.components.UITextField;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;

/**
 * The view that show's the screen to create a lobby as a host
 * @author Bastiaan Jansen
 */
public class HostView extends View implements IObserver {

    private final HostController hostController;

    private final StackPane root;
    private final UITextField usernameTextField;
    private final UITextField passwordTextField;

    public HostView(HostController hostController) {
        this.hostController = hostController;

        root = new StackPane();

        VBox form = new VBox();

        UIText text = new UIText("Host Game");
        text.setWeight(FontWeight.BOLD).setSize(30).setColor(Color.WHITE);

        usernameTextField = new UITextField("Username");
        usernameTextField.getLabel().setTextFill(Color.WHITE);
        passwordTextField = new UIPasswordField("Password");
        passwordTextField.getLabel().setTextFill(Color.WHITE);

        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(5, 0, 0, 0));
        buttonBox.setSpacing(20);

        Button hostGameButton = new UIButton("Host Game");
        hostGameButton.setPadding(new Insets(10));
        hostGameButton.setMinWidth(100);
        hostGameButton.setMaxWidth(100);
        hostGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, hostGame);
        
        Button goBackButton = new UIButton("Ga terug");
        goBackButton.setPadding(new Insets(10));
        goBackButton.setMinWidth(100);
        goBackButton.setMaxWidth(100);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);

        buttonBox.getChildren().addAll(hostGameButton, goBackButton);

        form.getChildren().addAll(text, usernameTextField, passwordTextField, buttonBox);
        form.setSpacing(10);
        form.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        form.setPadding(new Insets(400));
        form.setAlignment(Pos.CENTER);

        root.getChildren().add(form);
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
                hostController.createLobby(username, password); //even plaatsvervangend dubbel password i.p.v. unieke code
            } catch (EmptyFieldException error) {
                System.out.println(error.getMessage());
            }

        }
    };
    
    EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            hostController.goBack();
        }
    };

    @Override
    public void update() {

    }

    @Override
    public Pane getRoot() {
        return root;
    }
}
