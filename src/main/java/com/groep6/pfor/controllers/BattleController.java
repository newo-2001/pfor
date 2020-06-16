package com.groep6.pfor.controllers;

import com.groep6.pfor.models.*;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.SoundEffectManager;
import com.groep6.pfor.views.BattleView;

import java.util.Stack;

/**
 * Controller for the battle system. Gets information from the current city and performs a battle.
 * Afterwards the results of the battle are shown in the BattleView.
 * @author Mitchell van Rijswijk
 *
 */
public class BattleController extends Controller {

	private final Game game = Game.getInstance();

	// ArrayList simulation of barbarians and legions in a city.
	// TODO implement data acquisition from the current players current city.
	Stack<Barbarian> barbarians = new Stack<>();
	Stack<Legion> legions = new Stack<>();

	/**
	 * Constructor for BattleController. First performs a battle, then places the result in a new BattleView.
	 * 
	 */
	public BattleController() {
		Player player = game.getPlayerTurn();

		int legionCount = player.getCity().getLegionCount();
		int barbarianCount = player.getCity().getTotalBarbarianCount();

		DiceFace[] battleResults = player.battle();

		int legionsLost = 0;
		int barbariansLost = 0;

		for (DiceFace battleResult : battleResults) {
			legionsLost += battleResult.getLegionCount();
			barbariansLost += battleResult.getBarbarianCount();
		}

		legionsLost = Math.min(legionCount, legionsLost);
		barbariansLost = Math.min(barbarianCount, barbariansLost);

		viewController.showView(new BattleView(this, legionsLost, barbariansLost));
		SoundEffectManager.play("/sounds/effects/BattleSound.mp3");
	}

	/**
	 * Acquires amount of legions and barbarians to fight in the players current city.
	 * TODO implement data acquisition from city.
	 */
	public void getCityData() {
		for (int i = 0; i < 3; i++)
			barbarians.push(new Barbarian(FactionType.ANGLO_SAXSONS_FRANKS));
			legions.push(new Legion());
	}

	@Override
	public void registerObserver(IObserver view) {

	}
}
