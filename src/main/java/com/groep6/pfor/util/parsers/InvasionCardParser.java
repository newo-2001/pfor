package com.groep6.pfor.util.parsers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.groep6.pfor.models.cards.InvasionCard;
import com.groep6.pfor.util.parsers.templates.JsonInvasionCard;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A Json parser for invasion cards
 *
 * @author Owen Elderbroek
 */
public class InvasionCardParser extends JsonParser {
    /**
     * Parses a file of invasion cards in Json format
     * @param file The path to the json file
     * @return An array of parsed invasion cards
     * @throws ParseException If the json was invalid
     */
    @Override
    public InvasionCard[] parseFile(String file) throws ParseException {
        return (InvasionCard[]) super.parseFile(file);
    }

    /**
     * Parses a gson Json array of invasion cards
     * @param json the json array to parse
     * @return An array of parsed invasion cards
     * @throws ParseException If the json was invalid
     */
    @Override
    public Object[] parse(JsonArray json) throws ParseException {
        List<InvasionCard> cards = new ArrayList<>();
        for (Iterator<JsonElement> it = json.iterator(); it.hasNext();) {
            JsonObject cardField = (JsonObject) it.next();
            InvasionCard card = new Gson().fromJson(cardField, JsonInvasionCard.class).toModel();
            cards.add(card);
        }

        return cards.toArray(new InvasionCard[0]);
    }
}
