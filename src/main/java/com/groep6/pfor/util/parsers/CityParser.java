package com.groep6.pfor.util.parsers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.groep6.pfor.models.City;
import com.groep6.pfor.util.parsers.templates.CityDTO;

import java.text.ParseException;
import java.util.*;

public class CityParser extends JsonParser {
    @Override
    public City[] parseFile(String path) throws ParseException {
        return (City[]) super.parseFile(path);
    }

    @Override
    public Object[] parse(JsonArray json) {
        Map<String, City> cities = new HashMap<String, City>();
        for (Iterator<JsonElement> it = json.iterator(); it.hasNext();) {
            JsonObject cityField = (JsonObject) it.next();
            City city = new Gson().fromJson(cityField, CityDTO.class).toModel();
            cities.put(city.getName().toUpperCase(), city);
        }

        for (Iterator<JsonElement> it = json.iterator(); it.hasNext();) {
            JsonObject cityField = (JsonObject) it.next();
            CityDTO dto = new Gson().fromJson(cityField, CityDTO.class);
            for (String neighbourName : dto.getNeighbours()) {
                City neighbour = cities.get(neighbourName.toUpperCase());
                cities.get(dto.getName().toUpperCase()).addNeighbour(neighbour);
            }
        }

        return cities.values().toArray(new City[0]);
    }
}
