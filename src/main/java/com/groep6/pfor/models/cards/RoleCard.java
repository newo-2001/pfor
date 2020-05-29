package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.Color;
import com.groep6.pfor.models.cards.actions.IAction;

/**
 * @author Bastiaan Jansen
 */
public class RoleCard extends Card {

    private String name;
    private Color color;
    private IAction ability;

    /**
     * @param name
     * @param ability
     */
    public RoleCard(String name, Color color, IAction ability) {
        this.name = name;
        this.color = color;
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

    public Color getColor() {
        return color;
    }
}
