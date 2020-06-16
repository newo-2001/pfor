package com.groep6.pfor.controllers;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.SoundEffectManager;
import com.groep6.pfor.views.MoveView;

/**
 * @author Nils van der Velden
 */

public class MoveController extends Controller {

	private final City destination;
	private final Player player;
	
    public MoveController(City destination, Player player) {
    	this.destination = destination;
    	this.player = player;

        viewController.showView(new MoveView(this));
    }

	public void moveLegions(int amount) {
    	player.getCity().removeLegions(amount);
    	destination.addLegions(amount);

		SoundEffectManager.play("/sounds/effects/MarchSound.mp3");
		player.move(destination);
    	goBack();
    }

    public int getAmountOfLegionsInCurrentCity() {
    	return player.getCity().getLegions().size();
	}

	@Override
	public void registerObserver(IObserver view) {}
}
