package com.groep6.pfor.views;

import com.groep6.pfor.controllers.JoinController;
import com.groep6.pfor.exceptions.EmptyFieldException;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.components.UIButton;
import com.groep6.pfor.views.components.UIPasswordField;
import com.groep6.pfor.views.components.UITextField;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The view where you can join a lobby using a code and a password if required
 * @author Nils van der Velden
 */
public class JoinView extends View implements IObserver {

    private JoinController joinController;
    
    private UITextField codeTextField;
    private UITextField usernameTextField;
    private UITextField passwordTextField;

    public JoinView(JoinController joinController) {
        this.joinController = joinController;
        
        Pane root = new Pane();
        
        VBox form = new VBox();
        
        Text text = new Text("Join game");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        text.setFill(Color.WHITE);
        
        codeTextField = new UITextField("Unique code");
        codeTextField.getLabel().setTextFill(Color.WHITE);
        usernameTextField = new UITextField("Username");
        usernameTextField.getLabel().setTextFill(Color.WHITE);
        passwordTextField = new UIPasswordField("Password");
        passwordTextField.getLabel().setTextFill(Color.WHITE);
        
        Button joinGameButton = new UIButton("Host Game");
        joinGameButton.setPadding(new Insets(10));
        joinGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, joinGame);
        
        form.getChildren().addAll(text, codeTextField, usernameTextField, passwordTextField, joinGameButton);
        form.setSpacing(10);
        form.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        form.setPadding(new Insets(50));
        
        root.getChildren().add(form);
        scene = new Scene(root);
    }
    
    EventHandler<MouseEvent> joinGame = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
        	String code = codeTextField.getValue();
            String username = usernameTextField.getValue();
            String password = passwordTextField.getValue();

            try {
                joinController.joinLobby(code, username, password);
            } catch (EmptyFieldException error) {
                System.out.println(error.getMessage());
            }

        }
    };

    @Override
    public void update() {

    }
}
