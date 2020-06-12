package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.factories.FactionFactory;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.factions.FactionType;

public class JsonCityCard {
    private String city;
    private String faction;

    public CityCard toModel() {

        return new CityCard(CityFactory.getInstance().getCityByName(city),
                FactionFactory.getInstance().getFaction(FactionType.valueOf(faction)));
    }
}
