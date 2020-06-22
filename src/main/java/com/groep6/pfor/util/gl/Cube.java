package com.groep6.pfor.util.gl;

public class Cube extends Mesh {
    private Triangle[] vertexData = new Triangle[] {
        // Front Bottom
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 0f)),
                new Vertex(new Vector3f(1f, 0f, 0f)),
                new Vertex(new Vector3f(1f, 1f, 0f))
        ),

        // Front Top
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 0f)),
                new Vertex(new Vector3f(1f, 1f, 0f)),
                new Vertex(new Vector3f(0f, 1f, 0f))
        ),


        // Back Bottom
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 1f)),
                new Vertex(new Vector3f(1f, 0f, 1f)),
                new Vertex(new Vector3f (1f, 1f, 1f))
        ),

        // Back Top
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 1f)),
                new Vertex(new Vector3f(1f, 1f, 1f)),
                new Vertex(new Vector3f(0f, 1f, 1f))
        ),


        // Left Bottom
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 1f)),
                new Vertex(new Vector3f(0f, 0f, 0f)),
                new Vertex(new Vector3f(0f, 1f, 0f))
        ),

        // Left Top
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 1f)),
                new Vertex(new Vector3f(0f, 1f, 0f)),
                new Vertex(new Vector3f(0f, 1f, 1f))
        ),


        // Right Bottom
        new Triangle(
                new Vertex(new Vector3f(1f, 0f, 1f)),
                new Vertex(new Vector3f(1f, 0f, 0f)),
                new Vertex(new Vector3f(1f, 1f, 0f))
        ),

        // Right Top
        new Triangle(
                new Vertex(new Vector3f(1f, 0f, 1f)),
                new Vertex(new Vector3f(1f, 1f, 0f)),
                new Vertex(new Vector3f(1f, 1f, 1f))
        ),


        // Top Bottom
        new Triangle(
                new Vertex(new Vector3f(0f, 1f, 0f)),
                new Vertex(new Vector3f(1f, 1f, 0f)),
                new Vertex(new Vector3f(1f, 1f, 1f))
        ),

        // Top Top
        new Triangle(
                new Vertex(new Vector3f(0f, 1f, 0f)),
                new Vertex(new Vector3f(1f, 1f, 1f)),
                new Vertex(new Vector3f(0f, 1f, 1f))
        ),


        // Bottom Bottom
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 0f)),
                new Vertex(new Vector3f(1f, 0f, 0f)),
                new Vertex(new Vector3f(1f, 0f, 1f))
        ),

        // Bottom Top
        new Triangle(
                new Vertex(new Vector3f(0f, 0f, 0f)),
                new Vertex(new Vector3f(1f, 0f, 1f)),
                new Vertex(new Vector3f(0f, 0f, 1f))
        )
    };

    public Triangle[] getVertexData() {
        return vertexData;
    }

    public void setVertexData(Triangle[] data) {
        vertexData = data;
    }

    public Cube() {
        super();
    }
}
