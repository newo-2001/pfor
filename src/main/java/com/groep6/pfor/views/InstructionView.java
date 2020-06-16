package com.groep6.pfor.views;

import com.groep6.pfor.controllers.InstructionController;
import com.groep6.pfor.views.components.UIButton;
import com.sandec.mdfx.MDFXNode;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.Scanner;

/**
 * The view where the game's instructions are shown
 * @author Bastiaan Jansen
 */
public class InstructionView extends View {
    /** The instructionController */
    private final InstructionController instructionController;
    private final BorderPane root;

    /**
     * The constructor
     * @param instructionController The instructionController
     */
    public InstructionView(InstructionController instructionController) {
        this.instructionController = instructionController;

        root = new BorderPane();

        String markdown = new Scanner(InstructionView.class.getResourceAsStream("/misc/game_rules.md"), "UTF-8").useDelimiter("\\A").next();
        MDFXNode mdfxNode = new MDFXNode(markdown);
        mdfxNode.getStylesheets().add("/stylesheets/game_rules.css");
        ScrollPane content = new ScrollPane(mdfxNode);
        content.setFitToHeight(true);
        content.setFitToWidth(true);

        mdfxNode.setPadding(new Insets(50, 200, 50, 200));

        Button goBackButton = new UIButton("Ga terug");
        goBackButton.addEventFilter(MouseEvent.MOUSE_CLICKED, goBack);

        HBox buttonPane = new HBox(12, goBackButton);
        buttonPane.setAlignment(Pos.BOTTOM_RIGHT);
        mdfxNode.getChildren().add(0, buttonPane);

        setBackground(mdfxNode, "/images/paper_background.jpg");

        root.setPrefWidth(300);
        root.setCenter(content);
    }

    @Override
    public Pane getRoot() {
        return root;
    }

    EventHandler<MouseEvent> goBack = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent e) {
            instructionController.goBack();
        }
    };
}
