package com.groep6.pfor.factories;

import com.groep6.pfor.models.cards.RoleCard;

import java.util.ArrayList;
import java.util.List;

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

    public List<RoleCard> getAllRoleCards() {
        return roleCards;
    }

}

