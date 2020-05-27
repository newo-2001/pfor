package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Mercator role.
 * @author Mitchell van Rijswijk
 *
 */
public class MercatorAction implements IAction {

	/**
	 * Deletes 1 barbarian from the current city.
	 * Deletes 1 legion from the current city.
	 * 
	 */
	public void execute() {
		/*
		 * currentCity.removeBarbarians(1);
		 * currentCity.removeLegions(1);
		 */
		
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Mercator";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder 1 barbaar en 1 legioen uit jouw stad.";
	}
}
