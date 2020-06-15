package com.groep6.pfor.models;

import java.util.Random;

/**
 * Dice for Pandemic: Fall of Rome. Each face on this dice represents an outcome
 * in battle. A DiceFace is returned when rolled.
 * @author Mitchell van Rijswijk
 *
 */
public class Dice {
	
	DiceFace[] faces = new DiceFace[6];
	Random r = new Random();
	
	/**
	 * Initialise dice faces on creation.
	 * 
	 */
	public Dice() {
		facesInit();
	}
	
	/**
	 * Initialise faces. BARBARIAN face is put on the dice twice. 
	 * 
	 */
	public void facesInit() {
		faces[0] = DiceFace.BARBARIAN;
		faces[1] = DiceFace.BARBARIAN;
		faces[2] = DiceFace.LEGION;
		faces[3] = DiceFace.BOTH;
		faces[4] = DiceFace.TWO_BARBARIAN_LEGION;
		faces[5] = DiceFace.SPECIAL;
	}
	
	/**
	 * Rolls dice and yields an outcome of a battle.
	 * @return DiceFace representation of the outcome in a battle.
	 * 
	 */
	public DiceFace roll(City city) {
		int randomIndex = r.nextInt(6);
		DiceFace outcome = faces[randomIndex];
		outcome.execute(city);
		return outcome;
	}
	
}
