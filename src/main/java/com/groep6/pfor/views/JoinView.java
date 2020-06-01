package com.groep6.pfor.views;

import com.groep6.pfor.controllers.JoinController;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * The view where you can join a lobby using a code, username and a password if required
 * @author Nils van der Velden
 */
public class JoinView extends View implements IObserver {

    /** The joincontroller  */
    private JoinController joinController;
    
    /** The textfield used that allows the user to enter a unique code  */
    private UITextField codeTextField;
    
    /** The textfield used that allows the pick a username  */
    private UITextField usernameTextField;
    
    /** The textfield that allows the user to put in a password if required  */
    private UITextField passwordTextField;
    
    /**
     * Initialises the  JoinView
     * @param the joinController
     */

    public JoinView(JoinController joinController) {
        this.joinController = joinController;
        /** Pane to put the different elements in  */
        StackPane root = new StackPane();
        
        /** VBox to put the different elements in  */
        VBox form = new VBox();
        
        /** Header text  */
        Text text = new Text("Join game");
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
        text.setFill(Color.WHITE);
        
        /** Creates the different user input fields  */
        codeTextField = new UITextField("Lobby code");
        codeTextField.getLabel().setTextFill(Color.WHITE);
        usernameTextField = new UITextField("Username");
        usernameTextField.getLabel().setTextFill(Color.WHITE);
        passwordTextField = new UIPasswordField("Password");
        passwordTextField.getLabel().setTextFill(Color.WHITE);
        
        /** Creates a button box for the different buttons */
        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(5, 0, 0, 0));
        buttonBox.setSpacing(10);
        
        /** Creates the join game button */
        Button joinGameButton = new UIButton("Join Game");
        joinGameButton.setPadding(new Insets(10));
        joinGameButton.setMinWidth(100);
        joinGameButton.setMaxWidth(100);
        joinGameButton.addEventFilter(MouseEvent.MOUSE_CLICKED, joinGame);
        
        /** Creates the go back button */
        Button goBackButton = new UIButton("Ga terug");
        goBackButton.setPadding(new Insets(10));
        goBackButton.setMinWidth(100);
        goBackButton.setMaxWidth(100);
        goBackButton.setBackground(new Background(new BackgroundFill(Color.web("#878787"), CornerRadii.EMPTY, Insets.EMPTY)));
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);
        
        /** Puts the buttons in the buttonBox */
        buttonBox.getChildren().addAll(joinGameButton, goBackButton);
        
        /** Puts all elements in the VBox*/
        form.getChildren().addAll(text, codeTextField, usernameTextField, passwordTextField, buttonBox);
        form.setSpacing(10);
        form.setBackground(new Background(new BackgroundFill(Color.web("D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        form.setPadding(new Insets(400));
        form.setAlignment(Pos.CENTER);
        
        /** Puts the VBox in the pane */
        root.getChildren().addAll(form);
        
        /** creates a scene using the pane we added the different elements to */
        scene = new Scene(root);
    }
    
    /** The event handler that gets triggered when the user presses the join game button */
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
    /** The event handler that gets triggered when the user presses the go back button */
    EventHandler<javafx.scene.input.MouseEvent> goBack = new EventHandler<javafx.scene.input.MouseEvent>() {
        @Override
        public void handle(javafx.scene.input.MouseEvent e) {
            joinController.goBack();
        }
    };

    @Override
    public void update() {

    }
}
