package com.groep6.pfor.factories;

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
    private List<RoleCard> roleCards = new ArrayList<>();

    /**
     * Constructs a RoleCardFactory with all role cards
     */
    private RoleCardFactory() {

        roleCards.add(new RoleCard("Magister Militum", new MagisterMilitumAction()));
        roleCards.add(new RoleCard("Consul", new ConsulAction()));
        roleCards.add(new RoleCard("ReginaFoederata", new ReginaFoederataAction()));
        roleCards.add(new RoleCard("Mercator", new MercatorAction()));
        roleCards.add(new RoleCard("Praefectus Classis", new PraefectusClassisAction()));
        roleCards.add(new RoleCard("Praefectus Fabrum", new PraefectusFabrumAction()));
        roleCards.add(new RoleCard("Vestalin", new VestalinAction()));

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

