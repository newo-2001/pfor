package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Praefectus Classis role.
 * @author Mitchell van Rijswijk
 *
 */
public class PraefectusClassisAction implements IAction {

	/**
	 * Checks if the current city is a port city. If it is, removes a
	 * barbarian from the city.
	 * 
	 */
	public void execute() {
		/* 
		 * if (currentCity.hasPort() && currentCity.hasBarbarians())
		 * 		currentCity.removeBarbarians(1);
		 */
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Praefectus Classis";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder 1 barbaar uit jouw stad als hier een haven is.";
	}

}