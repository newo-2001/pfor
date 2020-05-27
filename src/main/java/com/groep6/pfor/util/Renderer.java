package com.groep6.pfor.util;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Represents a renderer that is able to render JavaFX nodes.
 * Used as an abstraction layer over some otherwise obnoxious JavaFX code.
 *
 * @author Owen Elderbroek
 */
public class Renderer {
    /** The stage that this renderer will render on. */
    private Stage stage;

    /** The scene that will be rendered. */
    private Scene scene;

    /** The root object of the scenegraph. */
    private Parent root;

    /**
     * Constructs a renderer that will render on the given stage.
     * @param stage The stage to render on.
     * @param dimensions The size of the window.
     * @return A new renderer instance.
     */
    public Renderer(Stage stage, Vector2f dimensions) {
        this.stage = stage;
        scene = new Scene(new Group(), dimensions.x, dimensions.y);
    }

    /**
     * Set the root node for the new scenegraph effectively overriding
     * everything that is there and starting a scene from scratch.
     * @param root The node to act as the root of the scenegraph.
     */
    public void setSceneGraph(Parent root) {
        this.root = root;
    }

    /**
     * Render the current scenegraph, doing so will update the screen
     * and show the new changes to the user.
     */
    public void render() {

    }
}
