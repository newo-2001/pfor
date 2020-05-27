package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * @author Bastiaan Jansen
 */
public class RoleCard extends Card {

    private String name;
    private IAction ability;

    /**
     * @param name
     * @param ability
     */
    public RoleCard(String name, IAction ability) {
        this.name = name;
        this.ability = ability;
    }

    /**
     * Executes an IAction event
     */
    public void executeAbility() {
        ability.execute();
    }

    @Override
    public String getName() {
        return name;
    }
}
