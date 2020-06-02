package com.groep6.pfor.models.factions;

/**
 * @author Bastiaan Jansen
 */
public enum FactionType {
    ANGLO_SAXSONS_FRANKS("Angelsaksen"),
    VANDALS("Vandalen"),
    HUNS("Hunnen"),
    VISIGOTHS("Visigoten"),
    OSTROGOTHS("Ostrogoten");

    private String name;

    FactionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
