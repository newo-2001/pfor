package com.groep6.pfor.models.cards.actions.roleActions;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Battle ability of the Mercator role.
 * @author Mitchell van Rijswijk
 *
 */
public class MercatorAction implements IAction {

	private final Game game = Game.getInstance();

	/**
	 * Deletes 1 barbarian from the current city.
	 * Deletes 1 legion from the current city.
	 * 
	 */
	public void execute() {
		Player player = game.getLocalPlayer();
		City city = player.getCity();
		city.removeBarbarians(1);
		city.removeLegions(1);
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Mercator";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder 1 barbaar en 1 legioen uit jouw stad.";
	}

}
