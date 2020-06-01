package com.groep6.pfor.models.cards.actions.eventActions;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Implements (the first) action on Alea Iacta Est event card
 * @author Mitchell van Rijswijk
 *
 */
public class AleaIactaEstAction implements IAction {

	/**
	 * Lets the player pick 1 dice face in battle.
	 */
	public void execute() {
		/*
		 * if (player.inBattle())
		 * 		ViewController.showView(selectBattleOutcome);
		 * 		DiceFace df = <<Player selection>>;
		 * 		battleResult.replace(outcome[0], df);
		 * 		card.discard();
		 */
	}

	/**
	 * Gets the name of the event.
	 * @return The name of the event.
	 * 
	 */
	public String getName() {
		return "Alea Iacta Est";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Draai tijdens 1 gevecht in deze beurt de dobbelsteen naar de gewenste zijde in plaats van deze te werpen.";
	}

}
