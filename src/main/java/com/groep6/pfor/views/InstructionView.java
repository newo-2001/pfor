package com.groep6.pfor.views;

import com.groep6.pfor.controllers.InstructionController;
import com.groep6.pfor.views.components.UIText;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;

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

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setPadding(new Insets(-1));

        TextFlow instructions = new TextFlow(new UIText("Instructions").setSize(30).setWeight(FontWeight.BOLD));

        Pane instructionsPane = new Pane();
        BackgroundImage backgroundImage = new BackgroundImage(new Image("images/paper.jpg"),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER, new BackgroundSize(100, 100, true, true, true, true));
        instructionsPane.setBackground(new Background(backgroundImage));
        instructionsPane.setPadding(new Insets(-1));
        instructionsPane.getChildren().add(instructions);
        instructionsPane.setPrefWidth(300);

        root.setBackground(new Background(new BackgroundFill(Color.web("#D5544F"), CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane.setContent(instructions);

        root.setCenter(instructionsPane);
    }

    @Override
    public Pane getRoot() {
        return root;
    }
}
