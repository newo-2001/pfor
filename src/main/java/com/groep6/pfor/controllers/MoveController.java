package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.IObserver;

/**
 * @author Nils van der Velden
 */

public class MoveController extends Controller {
	
	private Game game;
	
    public MoveController() {
    	game = Game.getInstance();
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
