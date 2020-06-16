package com.groep6.pfor.models.cards.actions.roleActions;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Battle ability of the Magister Militum role.
 * @author Mitchell van Rijswijk
 *
 */
public class MagisterMilitumAction implements IAction {

	private final Game game = Game.getInstance();

	/**
	 * Reduces the amount of barbarians in the current city by 2.
	 * 
	 */
	public void execute() {
		Player player = game.getLocalPlayer();
		City city = player.getCity();
		city.removeBarbarians(2);
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Magister Militum";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		String description = "Verwijder 2 barbaren uit jouw stad.";
		return description;
	}

}