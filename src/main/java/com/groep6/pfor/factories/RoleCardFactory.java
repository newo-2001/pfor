package com.groep6.pfor.factories;

import com.groep6.pfor.Config;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.models.cards.actions.roleActions.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Bastiaan Jansen
 */
public class RoleCardFactory {

    private static final RoleCardFactory SINGLE_INSTANCE = new RoleCardFactory();
    private final List<RoleCard> roleCards = new ArrayList<>();

    /**
     * Constructs a RoleCardFactory with all role cards
     */
    private RoleCardFactory() {

        roleCards.add(new RoleCard("Magister Militum", Color.YELLOW, new MagisterMilitumAction()));
        roleCards.add(new RoleCard("Consul", Color.BLUE, new ConsulAction()));
        roleCards.add(new RoleCard("Regina Foederata", Color.GREEN, new ReginaFoederataAction()));
        roleCards.add(new RoleCard("Mercator", Color.TEAL, new MercatorAction()));
        roleCards.add(new RoleCard("Praefectus Classis", Color.LIME, new PraefectusClassisAction()));
        roleCards.add(new RoleCard("Praefectus Fabrum", Color.DARKORANGE, new PraefectusFabrumAction()));
        roleCards.add(new RoleCard("Vestalin", Color.BLUEVIOLET, new VestalinAction()));

    }

    /**
     * Makes sure you always get the same RoleCardFactory instance
     * @return Instance of RoleCardFactory
     */
    public static RoleCardFactory getInstance() {
        return SINGLE_INSTANCE;
    }

    /**
     * @return List of role cards
     */
    public List<RoleCard> getAllRoleCards() {
        return roleCards;
    }

    /**
     * Pick a random role card
     * @return Random role card
     */
    public RoleCard pickRandomRoleCard() {
        Random randomizer = new Random();
        RoleCard card = roleCards.get(randomizer.nextInt(roleCards.size()));
        return card;
    }

    /**
     * @return Size of all role cards
     */
    public int getRoleCardCount() {
        return roleCards.size();
    }

    /**
     * @return The rolecard with the specified name
     */
    public RoleCard getCardByName(String name) {
        for (RoleCard card : roleCards) {
            if (card.getName().toUpperCase().equals(name.toUpperCase())) return card;
        }
        if (Config.DEBUG) System.out.printf("[WARNING] No rolecard was found with the name '%s'\n", name);
        return null;
    }

}