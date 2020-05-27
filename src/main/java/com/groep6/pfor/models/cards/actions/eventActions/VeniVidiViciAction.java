package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Veni, Vidi, Vici event card
 * @author Mitchell van Rijswijk
 *
 */
public class VeniVidiViciAction implements IAction {

	/**
	 * Lets player pick a city to move to. Lets player select an amount of legions
	 * to take with him. Moves the player and his legions to the selected city.
	 * Performs a battle. Discards the card when all actions are performed.
	 */
	public void execute() {
		/*
		 * ViewController.switchView(pickCityView);
		 * City city = <<player selection of a city>>;
		 * ViewController.switchView(MoveView);
		 * int amount = player.selectLegionAmount();
		 * player.move(city, amount);
		 * battle();
		 * card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Veni, Vidi, Vici";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verplaats de huidige speler naar een willekeurige stad (samen met maximaal 3 legioenen. "
				+ "Deze speler mag hier als vrije actie een gevecht uitvoeren.";
	}

}
