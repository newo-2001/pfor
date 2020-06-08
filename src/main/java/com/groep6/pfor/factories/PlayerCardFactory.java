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
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Sinope"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Narona"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Athenae"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Genua"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Ravenna"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Patrae"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Aquileia"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Corduba"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Narbo"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Constantinopolis"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Tyras"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Nova Carthago"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Philippopolis"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Eburacum"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Mogontiacum"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Genua"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Gesoriacum"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Narbo"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lutetia"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Burdigala"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Londinium"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Brundisium"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Carnuntum"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Iuvavum"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Philippopolis"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Mediolanum"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lutetia"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Patrae"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lugdunum"), factionFactory.getFaction(FactionType.HUNS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Corduba"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Carthago"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lugdunum"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Athenae"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Mogontiacum"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Caesaraugusta"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Cesarea"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Constantinopolis"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Burdigala"), factionFactory.getFaction(FactionType.VANDALS)));		
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Syracusae"), factionFactory.getFaction(FactionType.VANDALS)));
		playerCardDeck.addCards(new CityCard(cityFactory.getCityByName("Tingi"), factionFactory.getFaction(FactionType.VANDALS)));
	}
}
