package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.util.Vector2f;

public class Vector2fDTO {
    @SerializedName("x")
    private float x;

    @SerializedName("y")
    private float y;

    public Vector2f toModel() {
        return new Vector2f(x, y);
    }
}
