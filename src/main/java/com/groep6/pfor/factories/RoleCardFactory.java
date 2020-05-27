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

        RoleCard MAGISTER_MILITUM = new RoleCard("Magister Militum", new MagisterMilitumAction());
        RoleCard CONSUL = new RoleCard("Consul", new ConsulAction());
        RoleCard REGINA_FOEDERATA = new RoleCard("ReginaFoederata", new ReginaFoederataAction());
        RoleCard MERCATOR = new RoleCard("Mercator", new MercatorAction());
        RoleCard PRAEFECTUS_CLASSIS = new RoleCard("Praefectus Classis", new PraefectusClassisAction());
        RoleCard PRAEFECTUS_FABRUM = new RoleCard("Praefectus Fabrum", new PraefectusFabrumAction());
        RoleCard VESTALIN = new RoleCard("Vestalin", new VestalinAction());

        roleCards.add(MAGISTER_MILITUM);
        roleCards.add(CONSUL);
        roleCards.add(REGINA_FOEDERATA);
        roleCards.add(MERCATOR);
        roleCards.add(PRAEFECTUS_CLASSIS);
        roleCards.add(PRAEFECTUS_FABRUM);
        roleCards.add(VESTALIN);

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

