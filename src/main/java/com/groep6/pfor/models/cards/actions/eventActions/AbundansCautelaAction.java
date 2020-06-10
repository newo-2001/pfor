package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Abundans Cautela Non Nocet event card
 * @author Mitchell van Rijswijk
 *
 */
public class AbundansCautelaAction implements IAction {

	/**
	 * Decreases the invasion rate by 2 for the next invasion.
	 */
	public void execute() {
		/*
		 * if (game.getState().equals(invasion))
		 * 		invasionController.removeInvasionsForThisRound(2);
		 */
		Game game = Game.getInstance();
		game.increaseInvasionLevel(2);

	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Abundans Cautela Non Nocet";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Trek 2 kaarten minder tijdens de volgende fase \"Steden binnenvallen\".";
	}

}
