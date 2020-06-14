package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Mors Tua, Vita Mea event card
 * @author Mitchell van Rijswijk
 *
 */
public class VitaMeaAction implements IAction {

	/**
	 * Replace 1 barbarian with 1 legion in the current city.
	 */
	public void execute() {
		Game game = Game.getInstance();
		Player player = game.getLocalPlayer();
		City city = player.getCity();
		city.removeBarbarians(1);
		city.addLegions(1);
		player.decreaseActionsRemaining();
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Mors Tua, Vita Mea";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Vervang 1 barbaar door 1 legioen.";
	}

}
