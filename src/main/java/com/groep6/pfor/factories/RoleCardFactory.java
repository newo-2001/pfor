package com.groep6.pfor.factories;

import com.groep6.pfor.models.cards.RoleCard;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Bastiaan
 */
public class RoleCardFactory {

    private static final RoleCardFactory SINGLE_INSTANCE = new RoleCardFactory();
    private List<RoleCard> roleCards = new ArrayList<>();

    private RoleCardFactory() {
    }

    /**
     * Makes sure you always get the same RoleCardFactory instance
     * @return instance of RoleCardFactory
     */
    public static RoleCardFactory getInstance() {
        return SINGLE_INSTANCE;
    }

    /**
     * @return List<RoleCard>
     */
    public List<RoleCard> getAllRoleCards() {
        return roleCards;
    }

    /**
     * Pick a random role card
     * @return RoleCard
     */
    public RoleCard pickRandomRoleCard() {
        Random randomizer = new Random();
        RoleCard card = roleCards.get(randomizer.nextInt(roleCards.size()));
        return card;
    }

    /**
     * @return int
     */
    public int getRoleCardCount() {
        return roleCards.size();
    }

}

