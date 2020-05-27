package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Magister Militum role.
 * @author Mitchell van Rijswijk
 *
 */
public class MagisterMilitumAction implements IAction {

	/**
	 * Reduces the amount of barbarians in the current city by 2.
	 * 
	 */
	public void execute() {
		/* currentCity.setBarbarians(currentCity.getBarbarians() - 2); 
		 * */
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Magister Militum";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		String description = "Verwijder 2 barbaren uit jouw stad.";
		return description;
	}

}