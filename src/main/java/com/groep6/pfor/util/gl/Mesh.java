package com.groep6.pfor.util.gl;

public abstract class Mesh {
    public abstract Triangle[] getVertexData();
    public abstract void setVertexData(Triangle[] data);

    public Mesh() {}

    public int tris() {
        return getVertexData().length;
    }

    public int vertices() {
        return tris() * 3;
    }
}
