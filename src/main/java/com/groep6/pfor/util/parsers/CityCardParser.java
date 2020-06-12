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

public class CityCardParser extends JsonParser {
    @Override
    public CityCard[] parseFile(String file) throws ParseException {
        return (CityCard[]) super.parseFile(file);
    }

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
