package com.groep6.pfor.controllers;

import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RecruitLegionView;

/**
 * @author Nils van der Velden
 */

public class RecruitLegionController extends Controller{
	
	private Game game = Game.getInstance();
	private Player player = game.getPlayerTurn();
	
    public RecruitLegionController() {
    	viewController.showView(new RecruitLegionView(this));
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
