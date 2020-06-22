package com.groep6.pfor.util.gl;

import com.groep6.pfor.util.Vector2f;
import javafx.scene.canvas.GraphicsContext;

public abstract class Shader {
    protected Matrix4f projection;
    protected Matrix4f model;
    protected GraphicsContext gc;
    protected Vector2f canvasSize;

    public Shader(GraphicsContext gc) {
        this.gc = gc;
        canvasSize = new Vector2f((float) gc.getCanvas().getWidth(), (float) gc.getCanvas().getHeight());
    }

    public void setProjectionMatrix(Matrix4f mat) {
        projection = mat;
    }

    public void setModelMatrix(Matrix4f mat) {
        model = mat;
    }

    public abstract void render(Mesh tri);
}
