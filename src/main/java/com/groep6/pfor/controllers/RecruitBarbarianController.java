package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.IObserver;

public class RecruitBarbarianController extends Controller {
	
	private Game game;
	
    public RecruitBarbarianController() {
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
		
	}

}
