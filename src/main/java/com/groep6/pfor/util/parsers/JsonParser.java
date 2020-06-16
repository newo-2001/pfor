package com.groep6.pfor.util.parsers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.groep6.pfor.util.FileReader;

import java.text.ParseException;

public abstract class JsonParser {
    public Object[] parseFile(String path) throws ParseException {
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        String content = new FileReader().read(getClass().getResourceAsStream(path));
        JsonElement json = parser.parse(content);
        if (!json.isJsonArray()) throw new ParseException(String.format("Root element in '%s' was not an array!", path), 0);
        return parse(json.getAsJsonArray());
    }

    public abstract Object[] parse(JsonArray json) throws ParseException;
}
