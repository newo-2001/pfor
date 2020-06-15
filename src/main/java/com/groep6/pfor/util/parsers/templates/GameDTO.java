package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

import java.util.*;

/**
 * The Data Transfer Object that represents the state of a game in Firebase
 *
 * @author Owen ELderbroek
 */
public class GameDTO {
    public BoardDTO board;
    public Map<String, PlayerDTO> players;
    public int decayLevel;
    public int invasionLevel;
    public List<CardDTO> tradeDeck;
    public List<CardDTO> invasionDeck;
    public List<CardDTO> cityDeck;
    public List<CardDTO> invasionDiscardPile;
    public List<CardDTO> cityDiscardPile;
    public List<String> friendlyFactions;
    public Date updateTime;
    public boolean lost = false;
    public boolean won = false;

    public Game toModel() {
        List<Player> players = new ArrayList<>();
        for (PlayerDTO player : this.players.values()) players.add(player.toModel());
        List<Faction> factions = new ArrayList<>();
        for (String faction : this.friendlyFactions) factions.add(FactionFactory.getInstance().getFaction(FactionType.valueOf(faction)));

        return new Game(board.toModel(), players, factions, decayLevel, invasionLevel, createDeck(tradeDeck),
                createDeck(invasionDeck), createDeck(cityDeck), createDeck(invasionDiscardPile), createDeck(cityDiscardPile), lost, won);
    }

    public static GameDTO fromModel(Game game) {
        BoardDTO board = BoardDTO.fromModel(game.getBoard());
        Map<String, PlayerDTO> players = new HashMap<>();
        for (Player player : game.getAllPlayers()) players.put(player.getUsername(), PlayerDTO.fromModel(player));
        List<String> factions = new ArrayList<>();
        for (Faction faction : game.getFriendlyFactions()) factions.add(faction.getFactionType().toString());

        return new GameDTO(board, players, factions, game.getDecayLevel(), game.getInvasionLevel(),
                createList(game.getTradeCardsDeck()), createList(game.getInvasionCardsDeck()), createList(game.getPlayerCardsDeck()),
                createList(game.getInvasionCardsDiscardPile()), createList(game.getCityCardsDiscardPile()), game.isLost(), game.isWon());
    }

    public GameDTO() {}

    private GameDTO(BoardDTO board, Map<String, PlayerDTO> players, List<String> friendlyFactions, int decayLevel, int invasionLevel,
                List<CardDTO> tradeDeck, List<CardDTO> invasionDeck, List<CardDTO> cityDeck, List<CardDTO> invasionDiscardPile, List<CardDTO> cityDiscardPile, boolean lost, boolean won) {
        this.board = board;
        this.players = players;
        this.friendlyFactions = friendlyFactions;
        this.decayLevel = decayLevel;
        this.invasionLevel = invasionLevel;
        this.tradeDeck = tradeDeck;
        this.invasionDeck = invasionDeck;
        this.cityDeck = cityDeck;
        this.invasionDiscardPile = invasionDiscardPile;
        this.cityDiscardPile = cityDiscardPile;
        this.updateTime = new Date();
        this.lost = lost;
        this.won = won;
    }

    private Deck createDeck(List<CardDTO> cards) {
        Card[] deckCards = new Card[cards.size()];
        for (int i = 0; i < cards.size(); i++) deckCards[i] = cards.get(i).toModel();
        return new Deck(deckCards);
    }

    private static List<CardDTO> createList(Deck deck) {
        List<CardDTO> list = new ArrayList<>();
        for (Card card : deck.getCards()) list.add(CardDTO.fromModel(card));
        return list;
    }
}
