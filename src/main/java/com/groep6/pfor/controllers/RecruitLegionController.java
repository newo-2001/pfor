package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.IObserver;

/**
 * @author Nils van der Velden
 */

public class RecruitLegionController extends Controller{
	
	private Game game;
	
    public RecruitLegionController() {
    	game = Game.getInstance();
    };
    
    public int oneClicked() {
    	return 1;
    }
    
    public int twoClicked() {
    	return 2;
    }
    
    public int threeClicked() {
    	return 3;
    }

	@Override
	public void registerObserver(IObserver view) {
		game.registerObserver(view);
		
	}

}
