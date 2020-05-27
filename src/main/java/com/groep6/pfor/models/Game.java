package com.groep6.pfor.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Bastiaan Jansen
 */
public class Game {

    private Board board;
    private List<Player> players;
    private int decayLevel = 0;
    private final int MAX_DECAY_LEVEL = 8;
    private int invasionLevel = 0;
    private final int MAX_INVASION_LEVEL = 7;
    private Deck invasionDeck;
    private Deck cityDeck;
    private Deck invasionDiscardPile;
    private Deck cityDiscardPile;
    private Dice[] die = new Dice[3];
    private List<Faction> friendlyFactions;

    public Game(ArrayList<LobbyPlayer> lobbyPlayers) {
        // Create players from LobbyPlayers
        createPlayers(lobbyPlayers);
    }

    private void createPlayers(ArrayList<LobbyPlayer> lobbyPlayers) {
        for (LobbyPlayer player: lobbyPlayers) players.add(new Player(player));
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getAllPlayers() {
        return players;
    }

    public Player getCurrentPlayer() {
        for (Player player: players) {
            if (player.isTurn()) return player;
        }

        return null;
    }

    public Deck getInvasionDeck() {
        return invasionDeck;
    }

    public int getDecayLevel() {
        return decayLevel;
    }

    public void increaseDecayLevel() {
        if (decayLevel >= MAX_DECAY_LEVEL) return;

        decayLevel++;
    }

    public void increaseInvasionLevel() {
        if (invasionLevel >= MAX_INVASION_LEVEL) return;

        invasionLevel++;
    }

    public Deck getCityDeck() {
        return cityDeck;
    }

    public Deck getInvasionDiscardPile() {
        return invasionDiscardPile;
    }

    public Deck getCityDiscardPile() {
        return cityDiscardPile;
    }

    public Dice[] getDie() {
        return die;
    }

    public boolean isFriendlyFaction(Faction faction) {
        if (friendlyFactions.contains(faction)) return true;
        return false;
    }

}
