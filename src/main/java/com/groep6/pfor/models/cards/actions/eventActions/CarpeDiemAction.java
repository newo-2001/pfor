package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Carpe Diem event card
 * @author Mitchell van Rijswijk
 *
 */
public class CarpeDiemAction implements IAction {

	/**
	 * Gives the player 2 extra actions in his turn.
	 */
	public void execute() {
		Game game = Game.getInstance();
		game.getPlayerTurn().addActions(2);
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Carpe Diem";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "De huidige speler mag deze beurt 2 extra acties uitvoeren.";
	}

}
