package com.groep6.pfor.util.parsers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.groep6.pfor.models.City;
import com.groep6.pfor.util.parsers.templates.CityDTO;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CityParser extends JsonParser {
    @Override
    public City[] parseFile(String path) throws ParseException {
        return (City[]) super.parseFile(path);
    }

    @Override
    public Object[] parse(JsonArray json) {
        Gson gson = new Gson();
        List<City> cities = new ArrayList<>();
        for (Iterator<JsonElement> it = json.iterator(); it.hasNext();) {
            JsonObject cityField = (JsonObject) it.next();
            cities.add(new Gson().fromJson(cityField, CityDTO.class).toModel());
        }
        return cities.toArray(new City[cities.size()]);
    }


    /*private static final String POS = "position";
    private static final String HARBOUR = "harbour";
    private static final String FACTIONS = "factions";
    private static final String NAME = "name";
    private static final String X = "x";
    private static final String Y = "y";

    public CityParser() {
        super();
    }

    @Override
    public void parse(JsonElement json) throws ParseException {
        List<City> cities = new ArrayList<>();
        if (json.isJsonObject()) cities.add(parseCity(json.getAsJsonObject()));
        else if (!json.isJsonArray()) throw new ParseException("Parsing city failed, root is not an object or an array", 0);
        else {
            for (JsonElement element : json.getAsJsonArray()) {
                if (json.isJsonObject()) cities.add(parseCity(element.getAsJsonObject()));
                else throw new ParseException("Parsing city failed, city is not an object", 0);
            }
        }
    }

    private City parseCity(JsonObject json) throws ParseException {
        // Checks if the city contains all required fields
        for (String field : new String[]{POS, HARBOUR, FACTIONS, NAME}) {
            if (!json.has(field)) {
                throw new ParseException(String.format("Parsing city failed, city is missing the field: %s", field), 0);
            }
        }

        if (!json.get(NAME).isJsonPrimitive()) throw new ParseException(String.format("Parsing city failed, %s was not a primitive!", NAME), 0);
        if (!json.get(HARBOUR).isJsonPrimitive()) throw new ParseException(String.format("Parsing city failed, %s was not a primitive!", HARBOUR), 0);
        if (!json.get(POS).isJsonObject()) throw new ParseException(String.format("Parsing city failed, %s was not an object!", POS), 0);
        if (!json.get(FACTIONS).isJsonArray()) throw new ParseException(String.format("Parsing city failed, %s was not an array!", FACTIONS), 0);

        String name = json.get(NAME).getAsString();
        boolean harbour = json.get(HARBOUR).getAsBoolean();

        JsonObject jsonPos = json.get(POS).getAsJsonObject();
        for (String field : new String[]{X, Y}) {
            if (!jsonPos.get(field).isJsonPrimitive()) throw new ParseException(String.format("Parsing city failed, %s.%s was not a primitive!", POS, field), 0);
        }
        return null;
    }*/
}
