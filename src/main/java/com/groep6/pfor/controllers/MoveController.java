package com.groep6.pfor.controllers;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.SoundEffectManager;
import com.groep6.pfor.views.MoveView;

/**
 * @author Nils van der Velden
 */

public class MoveController extends Controller {
	
	private Game game = Game.getInstance();
	private City destination;
	private Player player;
	
    public MoveController(City destination, Player player) {
    	this.destination = destination;
    	this.player = player;

        SoundEffectManager.play("src/main/resources/sounds/effects/MarchSound.mp3");
        viewController.showView(new MoveView(this));
    };
    
    public void moveLegions(int amount) {
    	player.getCity().removeLegions(amount);
    	destination.addLegions(amount);
    	System.out.println(player.getCity() + ": " + player.getCity().getLegionCount() + " - " + destination + ": " + destination.getLegionCount());
    	goBack();
    }

	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
	}
}
