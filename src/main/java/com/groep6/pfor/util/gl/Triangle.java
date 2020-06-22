package com.groep6.pfor.util.gl;

public class Triangle {
    public Vertex v1, v2, v3;

    public Triangle(Vertex v1, Vertex v2, Vertex v3) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
    }

    public Vertex[] getVertices() {
        return new Vertex[] {v1, v2, v3};
    }
}
