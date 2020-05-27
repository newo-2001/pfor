package com.groep6.pfor.views;

import com.groep6.pfor.controllers.InstructionController;

/**
 * The view where the game's instructions are shown
 * @author Mathijs
 */
public class InstructionView {
    /** The instructionController */
    private InstructionController instructionController;

    /**
     * The constructor
     * @param instructionController The instructionController
     */
    public InstructionView(InstructionController instructionController) {
        this.instructionController = instructionController;
    }
}
