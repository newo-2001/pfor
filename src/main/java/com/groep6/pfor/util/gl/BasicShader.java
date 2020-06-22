package com.groep6.pfor.util.gl;

import com.groep6.pfor.util.Vector2f;
import javafx.scene.canvas.GraphicsContext;

public class BasicShader extends Shader {
    public BasicShader(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void render(Mesh mesh) {
        Triangle[] vertexData = mesh.getVertexData();
        for (Triangle triangle : vertexData) {
            Vector2f[] lines = new Vector2f[3];
            int i = 0;

            for (Vertex v : triangle.getVertices()) {
                lines[i] = vertexShader(v).mul(canvasSize);
                i++;
            }

            // Draw the triangle
            gc.strokeLine(lines[0].x, lines[0].y, lines[1].x, lines[1].y);
            gc.strokeLine(lines[1].x, lines[1].y, lines[2].x, lines[2].y);
            gc.strokeLine(lines[2].x, lines[2].y, lines[0].x, lines[0].y);
        }
    }

    /**
     * The vertex shader takes a vertex and calculates it's location mapped onto the 2d screen
     * @param v The vertex in question
     * @return The 2d location on the screen in normalized device coordinates
     */
    private Vector2f vertexShader(Vertex v) {
        // Apply model and projection matrices
        Vector4f pos = new Vector4f(v.getPos(), 1f);
        pos.mul(new Matrix4f(model).mul(projection));

        Vector2f projected = new Vector2f(pos.x, pos.y);
        if (pos.w != 0) projected.div(pos.w);

        // Map to device coordinates
        return projected.add(1f).mul(0.5f);
    }
}
