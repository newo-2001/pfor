package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.CityCard;
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
		Game game = Game.getInstance();
		Deck cityDeck = game.getPlayerCardsDeck();
		CityCard card = (CityCard) cityDeck.draw();
		Player player = game.getPlayerTurn();
		player.getHand().addCards(card);
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
