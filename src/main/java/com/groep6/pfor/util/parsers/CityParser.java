package com.groep6.pfor.util.parsers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.groep6.pfor.models.City;
import com.groep6.pfor.util.parsers.templates.JsonCity;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A parser that parses cities from a Json file
 *
 * @author Owen Elderbroek
 */
public class CityParser extends JsonParser {
    /**
     * Parse a file of json cities
     * @param path The path to the json file
     * @return A list of cities that were parsed
     * @throws ParseException If the json was invalid
     */
    @Override
    public City[] parseFile(String path) throws ParseException {
        return (City[]) super.parseFile(path);
    }

    /**
     * Parses a gson Json array of cities
     * @param json The json array
     * @return An array of parsed cities
     */
    @Override
    public Object[] parse(JsonArray json) {
        Map<String, City> cities = new HashMap<String, City>();
        for (Iterator<JsonElement> it = json.iterator(); it.hasNext();) {
            JsonObject cityField = (JsonObject) it.next();
            City city = new Gson().fromJson(cityField, JsonCity.class).toModel();
            cities.put(city.getName().toUpperCase(), city);
        }

        for (Iterator<JsonElement> it = json.iterator(); it.hasNext();) {
            JsonObject cityField = (JsonObject) it.next();
            JsonCity dto = new Gson().fromJson(cityField, JsonCity.class);
            for (String neighbourName : dto.getNeighbours()) {
                City neighbour = cities.get(neighbourName.toUpperCase());
                cities.get(dto.getName().toUpperCase()).addNeighbour(neighbour);
            }
        }

        return cities.values().toArray(new City[0]);
    }
}
