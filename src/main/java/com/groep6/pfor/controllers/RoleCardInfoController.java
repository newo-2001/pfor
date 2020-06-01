package com.groep6.pfor.controllers;

import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RoleCardInfoView;
import java.util.List;

public class RoleCardInfoController extends Controller {
	
    private Game game = Game.getInstance();

    public RoleCardInfoController() {
        viewController.showView(new RoleCardInfoView(this));
    }

    public List<RoleCard> getRoleCards() {
        return RoleCardFactory.getInstance().getAllRoleCards();
    }

    @Override
    public void registerObserver(IObserver view) {

    }
}
