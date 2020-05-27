package com.groep6.pfor.models;

import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class Game {

    private Board board;
    private List<Player> players;
    private int decay = 0; // 0 -> 8
    private int invasionLevel = 0; // 0 -> 7
    private Deck invasionDeck;
    private Deck cityDeck;
    private Deck invasionDiscardPile;
    private Deck cityDiscardPile;
    private Dice[] die = new Dice[3];
    private List<Faction> friendlyFactions;

}
