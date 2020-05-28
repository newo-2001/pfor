package com.groep6.pfor.util;

public class Vector3f {
	
	 /** The x-component of the vector */
    public float x;

    /** The y-component of the vector */
    public float y;
    
    /** The z-component of the vector */
    public float z;

    /**
     * Initializes a new vector with the components (0, 0, 0)
     * @return A new Vector3f
     */
    public Vector3f() {
        this(0, 0, 0);
    }

    /**
     * Initializes a new vector with the given components.
     * @param x The x-component to initialize this vector with.
     * @param y The y-component to initialize this vector with.
     * @param y The z-component to initialize this vector with.
     * @return A new Vector3f
     */
    
    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Initializes a new vector with the given integers.
     * @param x The x-component to initialize this vector with.
     * @param y The y-component to initialize this vector with.
     * @param y The z-component to initialize this vector with.
     * @return A new Vector3f
     */
    public Vector3f(int x, int y, int z) {
        this((float) x, (float) y, (float) z);
    }

    /**
     * Creates a new vector from another one. Effectively cloning the given vector.
     * @param base The vector to be cloned.
     * @return The cloned vector.
     */
    public Vector3f(Vector3f base) {
        this(base.x, base.y, base.z);
    }

    /**
     * Add a scalar to all components of this vector.
     * @param scalar The amount to be added.
     * @return Itself for chaining.
     */
    public Vector3f add(float scalar) {
        return add(new Vector3f(scalar, scalar, scalar));
    }

    /**
     * Add another vector to this one.
     * @param vec The vector to add to this vector
     * @return Itself for chaining.
     */
    public Vector3f add(Vector3f vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
        return this;
    }

    /**
     * Subtract a scalar from both components of this vector.
     * @param scalar The amount to be subtracted.
     * @return Itself for chaining.
     */
    public Vector3f sub(float scalar) {
        return sub(new Vector3f(scalar, scalar, scalar));
    }

    /**
     * Subtract a vector from this one.
     * @param vec The vector to subtract from this vector
     * @return Itself for chaining.
     */
    public Vector3f sub(Vector3f vec) {
        this.x -= vec.x;
        this.y -= vec.y;
        this.z -= vec.z;
        return this;
    }

    /**
     * Multiply all components of this vector by a scalar.
     * @param scalar The amount to be multiplied by.
     * @return Itself for chaining.
     */
    public Vector3f mul(float scalar) {
        return mul(new Vector3f(scalar, scalar, scalar));
    }

    /**
     * Multiply this vector by another one.
     * @param vec The vector to be multiplied by.
     * @return Itself for chaining.
     */
    public Vector3f mul(Vector3f vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
        return this;
    }

    /**
     * Divide all components of this vector by a scalar.
     * @param scalar The amount to be divided by.
     * @return Itself for chaining.
     */
    public Vector3f div(float scalar) {
        return div(new Vector3f(scalar, scalar, scalar));
    }

    /**
     * Divide this vector by another one.
     * @param vec The vector to be divided by.
     * @return Itself for chaining.
     */
    public Vector3f div(Vector3f vec) {
        this.x += vec.x;
        this.y += vec.y;
        this.z += vec.z;
        return this;
    }

    /**
     * Round all the components of the vector down to the closest integer.
     * @return Itself for chaining.
     */
    public Vector3f floor() {
        x = (float) Math.floor(x);
        y = (float) Math.floor(y);
        z = (float) Math.floor(y);
        return this;
    }

    /**
     * Round all the components of the vector up to the closest integer.
     * @return Itself for chaining.
     */
    public Vector3f ceil() {
        x = (float) Math.ceil(x);
        y = (float) Math.ceil(y);
        z = (float) Math.ceil(z);
        return this;
    }

    /**
     * Calculates the length (or magnitude) of this vector
     * using the pythagorean theorem.
     * @return
     */
    public float length() {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    /**
     * Normalizes the components of this vector to be between -1 and 1.
     * Effectively reducing its length to 1.
     * @return Itself for chaining.
     */
    public Vector3f normalize() {
        return div(length());
    }

    /**
     * Calculates the absolute version of this vector.
     * Effectively making all its values positive.
     * @return Itself for chaining.
     */
    public Vector3f abs() {
        x = Math.abs(x);
        y = Math.abs(y);
        z = Math.abs(z);
        return this;
    }

    /**
     * Compute the dot product of this vector with another.
     * The dot product represents how different both vectors are.
     * @param vec The other vector to calculate the dot product with.
     * @return The dot product of the two vectors.
     */
    public float dot(Vector3f vec) {
        return x * vec.x + y * vec.y + z * vec.z;
    }

    /**
     * Compute the angle between these two vectors.
     * @param vec The other vector to calculate the angle with.
     * @return The angle between the two vectors in radiant.
     */
    public float angle(Vector3f vec) {
        return (float) Math.acos(dot(vec) / (length() * vec.length()));
    }
}

