package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Melius Cavere Quam Pavere event card
 * @author Mitchell van Rijswijk
 *
 */
public class MeliusCavereAction implements IAction {

	/**
	 * Lets player take the top 6 cards from the invasion deck and see them.
	 * Lets the player put those cards back to the top of the deck in any given order.
	 * Discards the card if all actions are performed.
	 */
	public void execute() {
		/*
		 * ViewController.switchView(cardView);
		 * Card card1 = <<player select card>>;
		 * Card card2 = <<player select card>>;
		 * Card card3 = <<player select card>>;
		 * Card card4 = <<player select card>>;
		 * Card card5 = <<player select card>>;
		 * Card card6 = <<player select card>>;
		 * List cards = new List<Card>();
		 * cards.addAll(card1, card2, card3, card4, card5, card6);
		 * for (Card card: cards) { invasionDeck.push(card); }
		 * card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Melius Cavere Quam Pavere";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Trek de bovenste 6 kaarten van de barbaarstapel en bekijk deze. Daarna: Leg de kaarten in gewenste volgorde"
				+ "bovenop de stapel terug.";
	}

}
