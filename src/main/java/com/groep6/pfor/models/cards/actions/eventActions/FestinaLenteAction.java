package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Festina Lente event card
 * @author Mitchell van Rijswijk
 *
 */
public class FestinaLente implements IAction {

	/**
	 * Allows the player to move another player to a city of choice, with his 
	 * permission. Player picks a city, asks another player for permission to move him
	 * there, the action is performed and the event card gets discarded. 
	 */
	public void execute() {
		/*
		 * ViewController.switchView(pickCityView);
		 * City city = <<player selection of a city>>;
		 * Player player = selectPlayer();
		 * if (player.moveRequest()) 
		 * 		player.move(city);
		 * card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Festina Lente";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Kies een stad. Verplaats hier 1 pion naartoe (met toestemming)";
	}

}
