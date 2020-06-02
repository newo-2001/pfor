package com.groep6.pfor.models.factions;

/**
 * @author Bastiaan Jansen
 */
public enum FactionType {
    ANGLO_SAXSONS_FRANKS("Anglo Saxsons Franks"),
    VANDELS("Vandels"),
    HUNS("Huns"),
    VISIGOTHS("Visigoths"),
    OSTROGOTHS("Ostrogoths");

    private String name;

    FactionType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
