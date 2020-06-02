package com.groep6.pfor.controllers;

import java.util.Stack;

import com.groep6.pfor.models.Barbarian;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Legion;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.BattleView;

/**
 * Controller for the battle system. Gets information from the current city and performs a battle.
 * Afterwards the results of the battle are shown in the BattleView.
 * @author Mitchell van Rijswijk
 *
 */
public class BattleController extends Controller {

	// ArrayList simulation of barbarians and legions in a city.
	// TODO implement data acquisition from the current players current city.
	Stack<Barbarian> barbarians = new Stack<>();
	Stack<Legion> legions = new Stack<>();

	/**
	 * Constructor for BattleController. First performs a battle, then places the result in a new BattleView.
	 * 
	 */
	public BattleController() {
//		Game game = Game.getInstance();
//		Player player = game.getPlayerTurn();
//		int[] battleResult = player.battle();
		int[] battleResult = {2, 3};

		MediaController.getInstance().play(MediaController.getInstance().getMedia("src/main/resources/sounds/effects/BattleSound.mp3"), false);

		viewController.showView(new BattleView(this, battleResult));
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
