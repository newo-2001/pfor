package com.groep6.pfor.views;

import com.groep6.pfor.controllers.JoinController;
import com.groep6.pfor.exceptions.EmptyFieldException;
import com.groep6.pfor.exceptions.UsernameAlreadyUsed;
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
 * The view where you can join a lobby using a code, username and a password if required
 * @author Nils van der Velden
 */
public class JoinView extends View implements IObserver {

    /** The join controller  */
    private final JoinController joinController;

    private final StackPane root;
    private final UITextField codeTextField;
    
    /** The text field used that allows the pick a username  */
    private final UITextField usernameTextField;
    
    /** The text field that allows the user to put in a password if required  */
    private final UITextField passwordTextField;
    
    /**
     * Initializes the JoinView
     * @param the joinController
     */

    public JoinView(JoinController joinController) {
        this.joinController = joinController;
        
        root = new StackPane();
        
        /** VBox to put the different elements in  */
        VBox form = new VBox();
        
        /** Header text  */
        UIText text = new UIText("Join game");
        text.setWeight(FontWeight.BOLD).setSize(30).setColor(Color.WHITE);
        
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
            } catch (EmptyFieldException | UsernameAlreadyUsed error) {
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

    @Override
    public Pane getRoot() {
        return root;
    }
}
