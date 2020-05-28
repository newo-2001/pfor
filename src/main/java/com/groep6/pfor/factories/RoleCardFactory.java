package com.groep6.pfor.factories;

import com.groep6.pfor.models.Color;
import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.models.cards.actions.roleActions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Bastiaan Jansen
 */
public class RoleCardFactory {

    private static final RoleCardFactory SINGLE_INSTANCE = new RoleCardFactory();
    private List<RoleCard> roleCards;

    /**
     * Constructs a RoleCardFactory with all role cards
     */
    private RoleCardFactory() {

        roleCards.add(new RoleCard("Magister Militum", new Color(null, null), new MagisterMilitumAction()));
        roleCards.add(new RoleCard("Consul", new Color(null, null), new ConsulAction()));
        roleCards.add(new RoleCard("ReginaFoederata", new Color(null, null), new ReginaFoederataAction()));
        roleCards.add(new RoleCard("Mercator", new Color(null, null), new MercatorAction()));
        roleCards.add(new RoleCard("Praefectus Classis", new Color(null, null), new PraefectusClassisAction()));
        roleCards.add(new RoleCard("Praefectus Fabrum", new Color(null, null), new PraefectusFabrumAction()));
        roleCards.add(new RoleCard("Vestalin", new Color(null, null), new VestalinAction()));

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

}

