package com.groep6.pfor.views;

import com.groep6.pfor.controllers.InstructionController;
import com.groep6.pfor.views.components.UIButton;
import com.sandec.mdfx.MDFXNode;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import javafx.scene.input.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * The view where the game's instructions are shown
 * @author Bastiaan Jansen
 */
public class InstructionView extends View {
    /** The instructionController */
    private InstructionController instructionController;
    private BorderPane root;

    /**
     * The constructor
     * @param instructionController The instructionController
     */
    public InstructionView(InstructionController instructionController) {
        this.instructionController = instructionController;

        root = new BorderPane();

        String markdown = "";
        try {
            markdown = new String(Files.readAllBytes(Paths.get(getClass().getResource("/misc/game_rules.md").toURI())));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

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
