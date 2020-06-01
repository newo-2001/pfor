package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Do Ut Des event card
 * @author Mitchell van Rijswijk
 *
 */
public class DoUtEsAction implements IAction {

	/**
	 * Allows 2 players to trade a citycard when they are in the same city.
	 */
	public void execute() {
		/*
		 * if (city.getPlayers().length > 1)
		 * 		ViewController.setView(cardSelection);
		 * 		Card tradeCard = <<Player select card>>
		 * 		waitForPlayerSelection();
		 * 		tradeCard.trade();
		 * 		card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Do Ut Es";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Twee spelers in dezelfde stad mogen een stadkaart uit hun hand ruilen.";
	}

}
