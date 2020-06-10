package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.cards.actions.IAction;
import javafx.application.Platform;

/**
 * Implements (the first) action on Audentes Fortuna Iuvat event card
 * @author Mitchell van Rijswijk
 *
 */
public class AudentesFortunaAction implements IAction {

	/**
	 * Allows player to draw 2 extra cards during drawPlayerCards phase.
	 */
	public void execute() {
		Game game = Game.getInstance();
		
		Deck cityDeck = game.getPlayerCardsDeck();
		
		CityCard card1 = (CityCard) cityDeck.draw();
		
		CityCard card2 = (CityCard) cityDeck.draw();

		Player player = game.getPlayerTurn();

		player.getHand().addCards(card1 , card2);
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Audentes Fortuna Iuvat";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "De speler trekt 2 speelkaarten.";
	}

}
