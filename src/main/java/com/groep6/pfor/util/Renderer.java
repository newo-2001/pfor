package com.groep6.pfor.util;

import javafx.stage.Stage;

/**
 * Represents a renderer that is able to render JavaFX nodes.
 * Used as an abstraction layer over some otherwise obnoxious JavaFX code.
 *
 * @author Owen Elderbroek
 */
public class Renderer {
    /** The stage that this renderer will render on. */
    private final Stage stage;

    /**
     * Constructs a renderer that will render on the given stage.
     * @param stage The stage to render on.
     * @param dimensions The size of the window.
     * @return A new renderer instance.
     */
    public Renderer(Stage stage) {
        stage.setTitle("Pandemic - Fall of Rome");
        this.stage = stage;
    }
}
