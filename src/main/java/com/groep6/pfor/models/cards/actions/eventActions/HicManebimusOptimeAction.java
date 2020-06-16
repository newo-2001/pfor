package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Hic Manebimus Optime event card
 * @author Mitchell van Rijswijk
 *
 */
public class HicManebimusOptimeAction implements IAction {

	/**
	 * Lets the player pick 3 cities with forts to reinforce. Adds 2 legions
	 * to each of the cities.
	 */
	public void execute() {
		/*
		 * ViewController.switchView(pickCityView);
		 * ViewController.getCurrentView().viewFortCities();
		 * City city1 = <<player selection of a city>>;
		 * City city2 = <<player selection of a city>>;
		 * City city3 = <<player selection of a city>>;
		 * city1.addLegions(2); city2.addLegions(2); city3.addLegions(2);
		 * card.discard();
		 */
		
		
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Hic Manebimus Optime";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Kies maximaal 3 steden met een fort. Leg op elk van deze steden maximaal 2 legioenen.";
	}

}
