package com.groep6.pfor.factories;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.City;
import com.groep6.pfor.util.parsers.CityParser;

import java.text.ParseException;

/**
 * The CityFactory constructs the list of cities from a json file
 *
 * @author Owen Elderbroek
 */
public class CityFactory {
    private static final CityFactory SINGLE_INSTANCE = new CityFactory();
    private City[] cities;

    /** Creates the CityFactory instance */
    private CityFactory() {
        try {
            cities = new CityParser().parseFile("/cities.json");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the instance of the CityFactory
     * @return The CityFactory instance
     */
    public static CityFactory getInstance() {
        return SINGLE_INSTANCE;
    }

    /**
     * Get an array of all the cities currently loaded into the game
     * @return An array of available cities
     */
    public City[] getAllCities() {
        return cities;
    }

    /**
     * Get the amount of cities in the game
     * @return The amount of cities in the game
     */
    public int cityCount() {
        return cities.length;
    }

    /**
     * Obtains a city instance by its name
     * @param name The name of the city
     * @return The city instance or null if not found
     */
    public City getCityByName(String name) {
        for (City city : cities) {
            if (city.getName().toUpperCase().equals(name.toUpperCase())) return city;
        }
        if (Config.DEBUG) System.out.printf("[WARNING] No city was found with the name '%s'\n", name);
        return null;
    }
}