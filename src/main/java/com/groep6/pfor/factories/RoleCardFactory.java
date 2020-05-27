package com.groep6.pfor.factories;

import com.groep6.pfor.models.cards.RoleCard;
import com.groep6.pfor.models.cards.actions.ConsulAction;
import com.groep6.pfor.models.cards.actions.MagisterMilitumAction;
import com.groep6.pfor.models.cards.actions.ReginaFoederataAction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Bastiaan Jansen
 */
public class RoleCardFactory {

    private static final RoleCardFactory SINGLE_INSTANCE = new RoleCardFactory();
    private List<RoleCard> roleCards = new ArrayList<>();

    private RoleCardFactory() {

        RoleCard MAGISTER_MILITUM = new RoleCard("Magister Militum", new MagisterMilitumAction());
        RoleCard CONSUL = new RoleCard("Consul", new ConsulAction());
        RoleCard REGINA_FOEDERATA = new RoleCard("ReginaFoederata", new ReginaFoederataAction());

        roleCards.add(MAGISTER_MILITUM);
        roleCards.add(CONSUL);
        roleCards.add(REGINA_FOEDERATA);

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

