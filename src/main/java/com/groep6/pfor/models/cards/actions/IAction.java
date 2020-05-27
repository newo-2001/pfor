package com.groep6.pfor.models.cards.actions;

/**
 * Represents an action some cards can perform
 * @author Bastiaan Jansen
 */
public interface IAction {

    /**
     * Execute this action
     */
    void execute();

    /**
     * @return String
     */
    String getName();

    /**
     * @return String
     */
    String getDescription();

}
