package com.groep6.pfor.models.cards.actions.roleActions;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Battle ability of the Praefectus Fabrum role.
 * @author Mitchell van Rijswijk
 *
 */
public class PraefectusFabrumAction implements IAction {

	private Game game = Game.getInstance();

	/**
	 * Checks if the current city has a fort. If it has, removes 2
	 * barbarians from the city.
	 * 
	 */
	public void execute() {
		Player player = game.getLocalPlayer();
		City city = player.getCity();

		if (city.hasFort()) city.removeBarbarians(2);
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

}