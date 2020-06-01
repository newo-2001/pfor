package com.groep6.pfor.views;

import com.groep6.pfor.controllers.InstructionController;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * The view where the game's instructions are shown
 * @author Mathijs
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
    }

    @Override
    public Pane getRoot() {
        return root;
    }
}
