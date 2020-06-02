package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Barbarian;
import com.groep6.pfor.models.Faction;
import com.groep6.pfor.models.Legion;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.BattleView;

/**
 * Controller for the battle system. Gets information from the current city and performs a battle.
 * Afterwards the results of the battle are shown in the BattleView.
 * @author Mitchell van Rijswijk
 *
 */
public class BattleController extends Controller {

	// Array simulation of barbarians and legions in a city.
	// TODO implement data aquisition from the current players current city.
	private Barbarian[] barbarians = { new Barbarian(Faction.ANGLO_SAXSONS_FRANKS), new Barbarian(Faction.ANGLO_SAXSONS_FRANKS),
			new Barbarian(Faction.ANGLO_SAXSONS_FRANKS) };
	private Legion[] legions = {new Legion(), new Legion(), new Legion()};

	/**
	 * Constructor for BattleController. First performs a battle, then places the result in a new BattleView.
	 * 
	 */
	public BattleController() {
		battle();
		viewController.showView(new BattleView(this));
	}

	public void battle() {

	}

	@Override
	public void registerObserver(IObserver view) {

	}
}
