package com.groep6.pfor.util;

/**
 * Represents a vector in 2d space. Has mathematical applications
 * but is also useful to wrap two float together, mostly used for coordinates.
 *
 * @author Owen Elderbroek
 */
public class Vector4f {
    /** The x-component of the vector */
    public float x;

    /** The y-component of the vector */
    public float y;

    public float z;
    public float w;

    /**
     * Initialises a new vector with the components (0, 0)
     * @return A new Vector2f
     */
    public Vector4f() {
        this(0, 0, 0, 0);
    }

    /**
     * Initialises a new vector with the given components.
     * @param x The x-component to initialize this vector with.
     * @param y The y-component to initialize this vector with.
     * @return A new Vector2f
     */
    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Initialises a new vector with the given integers.
     * @param x The x-component to initialize this vector with.
     * @param y The y-component to initialize this vector with.
     * @return A new Vector2f
     */
    public Vector4f(int x, int y, int z, int w) {
        this((float) x, (float) y, (float) z, (float) w);
    }

    /**
     * Creates a new vector from another one. Effectively cloning the given vector.
     * @param base The vector to be cloned.
     * @return The cloned vector.
     */
    public Vector4f(Vector4f base) {
        this(base.x, base.y, base.y, base.w);
    }

    /**
     * Add a scalar to both components of this vector.
     * @param scalar The amount to be added.
     * @return Itself for chaining.
     */
    public Vector4f add(float scalar) {
        return add(new Vector4f(scalar, scalar, scalar, scalar));
    }

    /**
     * Add another vector to this one.
     * @param vec The vector to add to this vector
     * @return Itself for chaining.
     */
    public Vector4f add(Vector4f vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
        this.w += vec.w;
        return this;
    }

    /**
     * Subtract a scalar from both components of this vector.
     * @param scalar The amount to be subtracted.
     * @return Itself for chaining.
     */
    public Vector4f sub(float scalar) {
        return sub(new Vector4f(scalar, scalar, scalar, scalar));
    }

    /**
     * Subtract a vector from this one.
     * @param vec The vector to subtract from this vector
     * @return Itself for chaining.
     */
    public Vector4f sub(Vector4f vec) {
        this.x -= vec.x;
        this.y -= vec.y;
        this.z -= vec.z;
        this.w -= vec.w;
        return this;
    }

    /**
     * Multiply both components of this vector by a scalar.
     * @param scalar The amount to be multiplied by.
     * @return Itself for chaining.
     */
    public Vector4f mul(float scalar) {
        return mul(new Vector4f(scalar, scalar, scalar, scalar));
    }

    /**
     * Multiply this vector by another one.
     * @param vec The vector to be multiplied by.
     * @return Itself for chaining.
     */
    public Vector4f mul(Vector4f vec) {
        this.x *= vec.x;
        this.y *= vec.y;
        this.z *= vec.z;
        this.w *= vec.w;
        return this;
    }

    /**
     * Divide both components of this vector by a scalar.
     * @param scalar The amount to be divided by.
     * @return Itself for chaining.
     */
    public Vector4f div(float scalar) {
        return div(new Vector4f(scalar, scalar, scalar, scalar));
    }

    /**
     * Divide this vector by another one.
     * @param vec The vector to be divided by.
     * @return Itself for chaining.
     */
    public Vector4f div(Vector4f vec) {
        if (vec.x == 0 || vec.y == 0 || vec.z == 0 || vec.w == 0) throw new ArithmeticException("Divide by 0 exception");
        this.x /= vec.x;
        this.y /= vec.y;
        this.z /= vec.z;
        this.w /= vec.w;
        return this;
    }

    /**
     * Round all the components of the vector down to the closest integer.
     * @return Itself for chaining.
     */
    public Vector4f floor() {
        x = (float) Math.floor(x);
        y = (float) Math.floor(y);
        z = (float) Math.floor(z);
        w = (float) Math.floor(w);
        return this;
    }

    /**
     * Round all the components of the vector up to the closest integer.
     * @return Itself for chaining.
     */
    public Vector4f ceil() {
        x = (float) Math.ceil(x);
        y = (float) Math.ceil(y);
        z = (float) Math.ceil(z);
        w = (float) Math.ceil(w);
        return this;
    }

    /**
     * Calculates the length (or magnitude) of this vector
     * using the pythagorean theorem.
     * @return
     */
    public float length() {
        return (float) Math.sqrt(x*x + y*y + z*z + w*w);
    }

    /**
     * Normalizes the components of this vector to be between -1 and 1.
     * Effectively reducing its length to 1.
     * @return Itself for chaining.
     */
    public Vector4f normalize() {
        return div(length());
    }

    /**
     * Given another vector calculate the distance between the ends of both vectors
     * @param vec The vector to calculate the distance to
     * @return The distance between the two ends of the given vectors
     */
    public float distance(Vector4f vec) {
        return new Vector4f(this).sub(vec).abs().length();
    }

    /**
     * Calculates the absolute version of this vector.
     * Effectively making all its values positive.
     * @return Itself for chaining.
     */
    public Vector4f abs() {
        x = Math.abs(x);
        y = Math.abs(y);
        z = Math.abs(z);
        w = Math.abs(w);
        return this;
    }

    /**
     * Compute the dot product of this vector with another.
     * The dot product represents how different both vectors are.
     * @param vec The other vector to calculate the dot product with.
     * @return The dot product of the two vectors.
     */
    public float dot(Vector4f vec) {
        return x * vec.x + y * vec.y + z * vec.z + w * vec.w;
    }

    /**
     * Compute the angle between these two vectors.
     * @param vec The other vector to calculate the angle with.
     * @return The angle between the two vectors in radians.
     */
    public float angle(Vector4f vec) {
        return (float) Math.acos(dot(vec) / (length() * vec.length()));
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", x, y, z, w);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vector4f)) return false;
        Vector4f v = (Vector4f) o;
        v.round();
        round();
        return v.x == x && v.y == y;
    }

    private void round() {
        x *= 10000f;
        y *= 10000f;
        z *= 10000f;
        w *= 10000f;
        x = (float) Math.round(x);
        y = (float) Math.round(y);
        z = (float) Math.round(z);
        w = (float) Math.round(w);
        x /= 10000f;
        y /= 10000f;
        z /= 10000f;
        w /= 10000f;
    }

}
