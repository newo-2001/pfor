package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.cards.actions.IAction;
import javafx.scene.paint.Color;

/**
 * @author Bastiaan Jansen
 */
public class RoleCard extends Card {

    private final String name;
    private final Color color;
    private final IAction ability;

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

    public IAction getAbility() {
        return ability;
    }
}
