package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Vae Victis event card
 * @author Mitchell van Rijswijk
 *
 */
public class VaeVictisAction implements IAction {

	/**
	 * Extracts amount of fallen barbarians from a battle, gives player the option to
	 * kill this amount of barbarians in a different city.
	 */
	public void execute() {
		/*
		 * get battle result;
		 * int amount = battleResult.getFallenBarbarianCount;
		 * City city = selectCity();
		 * city.removeBarbarians(amount);
		 * card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Vae Victis";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Na het verwijderen van barbaren ten gevolge van een gevecht, mag je uit 1 andere stad maximaal hetzelfde aantal barbaren verwijderen.";
	}

}
