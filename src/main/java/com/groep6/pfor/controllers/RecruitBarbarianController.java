package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RecruitBarbarianView;

public class RecruitBarbarianController extends Controller {
	
	private Game game = Game.getInstance();
	
    public RecruitBarbarianController() {
    	viewController.showView(new RecruitBarbarianView(this));
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
