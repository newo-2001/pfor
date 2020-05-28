package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Mortui Non Mordent event card
 * @author Mitchell van Rijswijk
 *
 */
public class MortuiNonMordentAction implements IAction {

	/**
	 * Lets player select a city. Remove 2 barbarians from that city.
	 */
	public void execute() {
		/*
		 * ViewController.showView(citySelection);
		 * City city = <<Player selection>>;
		 * city.removeBarbarians(2);
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Mortui Non Mordent";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder maximaal 2 barbaren van dezelfde kleur van het bord.";
	}

}
