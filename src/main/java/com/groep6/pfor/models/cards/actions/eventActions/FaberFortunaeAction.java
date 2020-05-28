package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Homo Faber Fortunae Suae event card
 * @author Mitchell van Rijswijk
 *
 */
public class FaberFortunaeAction implements IAction {

	/**
	 * Draws a citycard for the player and adds it to his hand.
	 */
	public void execute() {
		/*
		 * Deck deck = Game.discardDeck();
		 * Card cityCard = null;
		 * for (Card card: deck) {
		 * 		if (card.getCityColor().equals(currentCity.getColor()))
		 * 			cityCard = card;
		 * player.getHand().add(cityCard);
		 * card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Homo Faber Fortunae Suae";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "De huidige speler mag een stadkaart uit de aflegstapel (voor speelkaarten) trekken die correspondeert met zijn stad.";
	}

}
