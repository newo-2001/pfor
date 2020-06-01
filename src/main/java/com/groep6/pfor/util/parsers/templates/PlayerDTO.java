package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.City;
import com.groep6.pfor.models.Player;
import com.groep6.pfor.models.cards.RoleCard;

public class PlayerDTO {
    /** The username of the player */
    public String username;

    /** If it is currently this player's turn */
    public boolean turn;

    /** The name of the city this player is in */
    public String city;

    /** The name of the rolecard this player has */
    public String role;

    /**
     * Obtains the rolecard that belongs to this player
     * @return The rolecard that belongs to this player
     */
    public RoleCard getRoleCard() {
        return RoleCardFactory.getInstance().getCardByName(role);
    }

    /**
     * Gets the city the player is currently in
     * @return The city the player is in
     */
    public City getCity() {
        return CityFactory.getInstance().getCityByName(city);
    }

    /**
     * Obtains the model that represents this DTO
     * @return The model representation of this data object
     */
    public Player toModel() {
        return new Player(username, getCity(), getRoleCard(), turn);
    }
}
