package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Si Vis Pacem, Para Bellum event card
 * @author Mitchell van Rijswijk
 *
 */
public class ParaBellumAction implements IAction {

	/**
	 * Lets the player pick 3 cities with forts to reinforce. Adds 2 legions
	 * to each of the cities.
	 */
	public void execute() {
		/*
		 * ViewController.switchView(pickCityView);
		 * City city = <<player selection of a city>>;
		 * city.buildFort();
		 * card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Si Vis Pacem, Para Bellum";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Plaats een fort in een willekeurige stad.";
	}

}
