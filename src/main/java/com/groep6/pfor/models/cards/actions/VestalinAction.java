<<<<<<< HEAD
package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Vestalin role.
 * @author Mitchell van Rijswijk
 *
 */
public class VestalinAction implements IAction {

	/**
	 * Decreases the amount of legions in the current city by 1.
	 * 
	 */
	public void execute() {
		/* 
		 * currentCity.removeLegions(1); 
		 */
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Vestalin";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder 1 legioen uit jouw stad.";
	}

=======
package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Vestalin role.
 * @author Mitchell van Rijswijk
 *
 */
public class VestalinAction implements IAction {

	/**
	 * Decreases the amount of legions in the current city by 1.
	 * 
	 */
	public void execute() {
		/* 
		 * currentCity.removeLegions(1); 
		 */
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Vestalin";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder 1 legioen uit jouw stad.";
	}

>>>>>>> 513951a6156f8a63b7ad90cc4f74d9188a7efaed
}