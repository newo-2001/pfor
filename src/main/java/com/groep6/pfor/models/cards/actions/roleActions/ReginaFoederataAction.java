package com.groep6.pfor.models.cards.actions.roleActions;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Battle ability of the Regina Foederata role.
 * @author Mitchell van Rijswijk
 *
 */
public class ReginaFoederataAction implements IAction {
	
	private Game game = Game.getInstance();

	/**
	 * Gets the battle result. If the current city still has barbarians after the battle,
	 * 1 extra barbarian gets deleted. The legion count in the city is incremented. 
	 */
	public void execute() {
		Player player = game.getLocalPlayer();
		City city = player.getCity();
		city.removeBarbarians(1);
		city.addLegions(1);
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Regina Foederata";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder na het gevecht 1 barbaar uit jouw stad. Plaats hierbij ook maximaal 1 legioen op jouw stad.";
	}

}