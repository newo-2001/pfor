package com.groep6.pfor.factories;

import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;
import com.groep6.pfor.util.Vector2f;

public class PlayerCardFactory {
	
	private static final PlayerCardFactory SINGLE_INSTANCE = new PlayerCardFactory();
	private Deck playerCardDeck = new Deck();
	
	private PlayerCardFactory() {
        FactionFactory factionFactory = FactionFactory.getInstance();
        CityFactory cityFactory = CityFactory.getInstance();
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Carnuntum"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Aquileia"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Chersonesus"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Constantinopolis"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		
		
	}
	

}
