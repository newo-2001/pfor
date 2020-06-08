package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.util.MusicManager;
import com.groep6.pfor.util.SoundEffectManager;
import com.groep6.pfor.views.MoveView;

/**
 * @author Nils van der Velden
 */

public class MoveController extends Controller {
	
	private Game game = Game.getInstance();
	
    public MoveController() {

        SoundEffectManager.play("src/main/resources/sounds/effects/MarchSound.mp3");
        viewController.showView(new MoveView(this));
    };
    
    public int takeZero() {
    	return 0;
    }
    
    public int takeOne() {
    	return 1;
    }
    
    public int takeTwo() {
    	return 2;
    }
    
    public int takeThree() {
    	return 3;
    }

	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
	}
}
