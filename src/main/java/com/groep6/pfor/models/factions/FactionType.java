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

    private final String name;

    /**
     * @param name
     */
    FactionType(String name) {
        this.name = name;
    }

    /**
     * @return Dutch name of faction
     */
    public String getName() {
        return name;
    }
}
