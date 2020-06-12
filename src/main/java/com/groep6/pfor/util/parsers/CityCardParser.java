package com.groep6.pfor.util.parsers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.util.parsers.templates.JsonCityCard;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A Json parser for city cards
 *
 * @author Owen Elderbroek
 */
public class CityCardParser extends JsonParser {
    /**
     * Parses a file of city cards in Json format
     * @param file The path to the json file
     * @return An array of parsed city cards
     * @throws ParseException If the json was invalid
     */
    @Override
    public CityCard[] parseFile(String file) throws ParseException {
        return (CityCard[]) super.parseFile(file);
    }

    /**
     * Parses a gson Json array of city cards
     * @param json the json array to parse
     * @return An array of parsed city cards
     * @throws ParseException If the json was invalid
     */
    @Override
    public Object[] parse(JsonArray json) {
        List<CityCard> cards = new ArrayList<>();
        for (Iterator<JsonElement> it = json.iterator(); it.hasNext();) {
            JsonObject cardField = (JsonObject) it.next();
            cards.add(new Gson().fromJson(cardField, JsonCityCard.class).toModel());
        }
        return cards.toArray(new CityCard[0]);
    }
}
