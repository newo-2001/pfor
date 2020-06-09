package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.Game;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.Card;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Data Transfer Object that represents the state of a game in Firebase
 *
 * @author Owen ELderbroek
 */
public class GameDTO extends DTO {
    public BoardDTO board;
    public Map<String, PlayerDTO> players;
    public int decayLevel;
    public int invasionLevel;
    public List<CardDTO> tradeDeck;
    public List<CardDTO> invasionDeck;
    public List<CardDTO> cityDeck;
    public List<CardDTO> invasionDiscardPile;
    public List<CardDTO> cityDiscardPile;
    public Map<String, Boolean> friendlyFactions;

    public Game toModel() {
        List<Player> players = new ArrayList<>();
        for (PlayerDTO player : this.players.values()) players.add(player.toModel());
        List<Faction> factions = new ArrayList<>();
        for (String faction : this.friendlyFactions.keySet()) factions.add(FactionFactory.getInstance().getFaction(FactionType.valueOf(faction)));

        return new Game(board.toModel(), players, factions, decayLevel, invasionLevel, createDeck(tradeDeck),
                createDeck(invasionDeck), createDeck(cityDeck), createDeck(invasionDiscardPile), createDeck(cityDiscardPile));
    }

    public static GameDTO fromModel(Game game) {
        BoardDTO board = BoardDTO.fromModel(game.getBoard());
        Map<String, PlayerDTO> players = new HashMap<>();
        for (Player player : game.getAllPlayers()) players.put(player.getUsername(), PlayerDTO.fromModel(player));
        Map<String, Boolean> factions = new HashMap<>();
        for (Faction faction : FactionFactory.getInstance().getFactions()) factions.put(faction.getFactionType().toString(), game.isFriendlyFaction(faction));

        return new GameDTO(board, players, factions, game.getDecayLevel(), game.getInvasionLevel(),
                createList(game.getTradeCardsDeck()), createList(game.getInvasionCardsDeck()), createList(game.getCityCardsDeck()),
                createList(game.getInvasionCardsDiscardPile()), createList(game.getCityCardsDiscardPile()));
    }

    public GameDTO() {}

    private GameDTO(BoardDTO board, Map<String, PlayerDTO> players, Map<String, Boolean> friendlyFactions, int decayLevel, int invasionLevel,
                List<CardDTO> tradeDeck, List<CardDTO> invasionDeck, List<CardDTO> cityDeck, List<CardDTO> invasionDiscardPile, List<CardDTO> cityDiscardPile) {
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
