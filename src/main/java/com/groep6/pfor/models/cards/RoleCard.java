package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.cards.actions.IAction;

public class RoleCard extends Card {

    private String name;
    private IAction ability;

    public RoleCard(String name, IAction ability) {
        this.name = name;
        this.ability = ability;
    }

    public void executeAbility() {
        ability.execute();
    }

    @Override
    public String getName() {
        return name;
    }
}
