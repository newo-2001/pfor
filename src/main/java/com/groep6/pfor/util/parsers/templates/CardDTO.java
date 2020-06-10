package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.CityCardFactory;
import com.groep6.pfor.factories.EventCardFactory;
import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.factories.InvasionCardFactory;
import com.groep6.pfor.models.cards.*;
import com.groep6.pfor.models.factions.FactionType;

/**
 * The representation of a card in Firebase
 *
 * @author Owen Elderbroek
 */
public class CardDTO {
    public String type;
    public String name;
    public String city;
    public String faction;

    public CardDTO () {}

    private CardDTO(String type) {
        this.type = type;
    }

    private CardDTO(String type, String name) {
        this(type);
        this.name = name;
    }

    private CardDTO(String type, String name, String faction) {
        this(type, name);
        this.faction = faction;
    }

    private CardDTO(String type, String name, String faction, String city) {
        this(type, name, faction);
        this.city = city;
    }

    public Card toModel() {
        switch (type) {
            case "city":
                return CityCardFactory.getInstance().getCardByName(name, FactionFactory.getInstance().getFaction(FactionType.valueOf(faction)));
            case "event":
                return EventCardFactory.getInstance().getCardByName(name);
            case "invasion":
                return InvasionCardFactory.getInstance().getInvasionCardByName(name, FactionFactory.getInstance().getFaction(FactionType.valueOf(faction)));
        }
        return null;
        // TODO cast card from the database to correct model
    }

    public static CardDTO fromModel(Card model) {
        if (model instanceof CityCard) {
            CityCard card = (CityCard) model;
            return new CardDTO("city", card.getName(), card.getFaction().getFactionType().toString(), card.getCity().getName());
        } else if (model instanceof EventCard) {
            return new CardDTO("event", model.getName());
        } else if (model instanceof InvasionCard) {
            InvasionCard card = (InvasionCard) model;
            return new CardDTO("invasion", card.getName(), card.getFaction().getFactionType().toString());
        } else if (model instanceof RevoltCard) {
            return new CardDTO("revolt");
        }
        return null;
    }
}
