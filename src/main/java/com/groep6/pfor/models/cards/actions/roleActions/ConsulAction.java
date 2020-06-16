package com.groep6.pfor.models.cards.actions.roleActions;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Battle ability of the Consul role.
 * @author Mitchell van Rijswijk
 *
 */
public class ConsulAction implements IAction {

	private final Game game = Game.getInstance();

	/**
	 * Increases the amount of legions in the current city by 1.
	 * 
	 */
	public void execute() {
		Player player = game.getLocalPlayer();
		City city = player.getCity();
		city.addLegions(1);
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Consul";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Plaats 1 legioen op jouw stad.";
	}

}