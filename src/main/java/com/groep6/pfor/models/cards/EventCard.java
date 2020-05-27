package com.groep6.pfor.models.cards;

import com.groep6.pfor.models.cards.actions.IAction;

public class EventCard extends Card {

    private String name;
    private IAction event;

    public EventCard(String name, IAction event) {
        this.name = name;
        this.event = event;
    }

    @Override
    public String getName() {
        return name;
    }

    public void executeEvent() {
        event.execute();
    }
}
