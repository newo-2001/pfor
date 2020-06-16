package com.groep6.pfor.controllers;

import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.Lobby;
import com.groep6.pfor.models.LobbyPlayer;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.services.LobbyService;
import com.groep6.pfor.util.IObserver;
import com.groep6.pfor.views.RoleCardInfoView;

import java.util.List;

public class RoleCardInfoController extends Controller {

    private final Lobby lobby;
    private final RoleCard currentlySelectedRoleCard;

    public RoleCardInfoController(Lobby lobby) {
        this.lobby = lobby;
        this.currentlySelectedRoleCard = lobby.getLocalPlayer().getRoleCard();

        viewController.showView(new RoleCardInfoView(this));
    }

    public List<RoleCard> getRoleCards() {
        return RoleCardFactory.getInstance().getAllRoleCards();
    }

    @Override
    public void registerObserver(IObserver view) {

    }

    public RoleCard getCurrentlySelectedRoleCard() {
        return currentlySelectedRoleCard;
    }

    public void selectCard(RoleCard card) {
        LobbyPlayer localPlayer = lobby.getLocalPlayer();
        localPlayer.setRoleCard(card);
        LobbyService lobbyService = new LobbyService();
        lobbyService.updateRoleCard(localPlayer);
    }
}
