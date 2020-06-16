package com.groep6.pfor.models.cards;

public enum CardType {

    CITY("Stadskaart"),
    EVENT("Eventkaart"),
    ROLE("Karakterkaart"),
    REVOLT("Opstandskaart"),
    INVASION("Invasiekaart");

    private final String name;

    CardType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
