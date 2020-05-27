<<<<<<< HEAD
package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Praefectus Fabrum role.
 * @author Mitchell van Rijswijk
 *
 */
public class PraefectusFabrumAction implements IAction {

	/**
	 * Checks if the current city has a fort. If it has, removes 2
	 * barbarians from the city.
	 * 
	 */
	public void execute() {
		/* 
		 * if (currentCity.hasFort() && currentCity.getBarbarians() >= 2)
		 * 		currentCity.removeBarbarians(2);
		 */
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Praefectus Fabrum";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder 2 barbaren uit jouw stad als hier een fort is.";
	}

=======
package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Praefectus Fabrum role.
 * @author Mitchell van Rijswijk
 *
 */
public class PraefectusFabrumAction implements IAction {

	/**
	 * Checks if the current city has a fort. If it has, removes 2
	 * barbarians from the city.
	 * 
	 */
	public void execute() {
		/* 
		 * if (currentCity.hasFort() && currentCity.getBarbarians() >= 2)
		 * 		currentCity.removeBarbarians(2);
		 */
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Praefectus Fabrum";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder 2 barbaren uit jouw stad als hier een fort is.";
	}

>>>>>>> 513951a6156f8a63b7ad90cc4f74d9188a7efaed
}