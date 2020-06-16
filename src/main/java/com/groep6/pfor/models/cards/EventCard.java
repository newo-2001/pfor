package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.cards.actions.IAction;

/**
 * Represents an event card
 * @author Bastiaan Jansen
 */
public class EventCard extends Card {

    private final String name;
    private final IAction event;

    public EventCard(String name, IAction event) {
        this.name = name;
        this.event = event;
    }

    @Override
    public String getName() {
        return name;
    }

    public IAction getEvent() {
        return event;
    }


    /**
     * Executes an IAction event
     */
    public void executeEvent() {
        event.execute();
    }
}
