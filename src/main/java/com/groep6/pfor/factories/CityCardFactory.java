package com.groep6.pfor.factories;

import com.groep6.pfor.models.Deck;
import com.groep6.pfor.models.cards.CityCard;
import com.groep6.pfor.models.factions.Faction;
import com.groep6.pfor.models.factions.FactionType;

/**
 *
 * @author Nils van der Velden
 */

import java.util.function.Predicate;

public class CityCardFactory {
	
	private static final CityCardFactory INSTANCE = new CityCardFactory();
	public Deck testDeck = new Deck();
	private Deck cityCardDeck = new Deck();
	
	private CityCardFactory() {
        FactionFactory factionFactory = FactionFactory.getInstance();
        CityFactory cityFactory = CityFactory.getInstance();
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Carnuntum"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Aquileia"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Chersonesus"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Constantinopolis"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Sinope"), factionFactory.getFaction(FactionType.OSTROGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Narona"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Athenae"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Genua"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Ravenna"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Patrae"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Aquileia"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Corduba"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Narbo"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Constantinopolis"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Tyras"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Nova Carthago"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Philippopolis"), factionFactory.getFaction(FactionType.VISIGOTHS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Eburacum"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Mogontiacum"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Genua"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Gesoriacum"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Narbo"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lutetia"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Burdigala"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Londinium"), factionFactory.getFaction(FactionType.ANGLO_SAXSONS_FRANKS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Brundisium"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Carnuntum"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Iuvavum"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Philippopolis"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Mediolanum"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lutetia"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Patrae"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lugdunum"), factionFactory.getFaction(FactionType.HUNS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Corduba"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Carthago"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Lugdunum"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Roma"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Athenae"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Mogontiacum"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Caesaraugusta"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Cesarea"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Constantinopolis"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Burdigala"), factionFactory.getFaction(FactionType.VANDALS)));		
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Syracusae"), factionFactory.getFaction(FactionType.VANDALS)));
		cityCardDeck.addCards(new CityCard(cityFactory.getCityByName("Tingi"), factionFactory.getFaction(FactionType.VANDALS)));
	}

	public CityCard getCardByName(String name, Faction faction) {
		// Yes, java 8 stream are beautiful
		return (CityCard) cityCardDeck.getCards().stream().filter(card -> card.getName() == name && ((CityCard) card).getFaction() == faction).toArray()[0];
	}

	public static CityCardFactory getInstance() {
		return INSTANCE;
	}

	public Deck getCityCardDeck() {
		return cityCardDeck;
	}
}
