package com.groep6.pfor.models;

/**
 * Represents a color
 *
 * @author Nils van der Velden
 */

import com.groep6.pfor.util.Vector3f;

public class Color {
	private final Vector3f rgb;
	private final String name;

	/**
	 * Initializes a new Color with the given components.
	 * @param rgb The Vector3f of a specific color
	 * @param name The name of the specific color
	 */
	
	public Color(Vector3f rgb, String name) {
		this.rgb = rgb;
		this.name = name;
	}
	
	/**
	 * @returns the rgb value of a specific color
	 */
	
	public Vector3f getColor() {
		return rgb;
	}
	
	/**
	 * @returns the name of a specific color
	 */
	
	public String getName() {
		return name;
	}
}