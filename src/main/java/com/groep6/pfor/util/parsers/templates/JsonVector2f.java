package com.groep6.pfor.util.parsers.templates;

import com.google.gson.annotations.SerializedName;
import com.groep6.pfor.util.Vector2f;

/**
 * The Data Transfer Object that represents a 2D vector in json
 *
 * @author Owen Elderbroek
 */
public class JsonVector2f {
    /** The x-component of this vector */
    @SerializedName("x")
    private float x;

    /** The y-component of this vector */
    @SerializedName("y")
    private float y;

    /**
     * Convert this Data Transfer Object to the Business variant
     * @return The business equivalent of the vector
     */
    public Vector2f toModel() {
        return new Vector2f(x, y);
    }
}
