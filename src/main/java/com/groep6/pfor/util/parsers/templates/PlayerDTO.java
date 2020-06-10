package com.groep6.pfor.util.parsers.templates;

import com.groep6.pfor.factories.CityFactory;
import com.groep6.pfor.factories.RoleCardFactory;
import com.groep6.pfor.models.Player;

/**
 * The Data Transfer Object that represents a Player in Firebase
 *
 * @author Owen Elderbroek
 */
public class PlayerDTO {
    /** The username of the player */
    public String username;

    /** If it is currently this player's turn */
    public boolean turn;

    /** The name of the city this player is in */
    public String city;

    /** The name of the rolecard this player has */
    public String role;

    /** The amount of actions remaining for this player */
    public int actions;

    public PlayerDTO() {}

    public PlayerDTO(String username, boolean turn, String city, String role, int actions) {
        this.username = username;
        this.turn = turn;
        this.city = city;
        this.role = role;
        this.actions = actions;
    }

    public static PlayerDTO fromModel(Player player) {
        return new PlayerDTO(player.getUsername(), player.isTurn(), player.getCity().getName(), player.getRoleCard().getName(), player.getActionsRemaining());
    }

    /**
     * Obtains the model that represents this DTO
     * @return The model representation of this data object
     */
    public Player toModel() {
        return new Player(username, CityFactory.getInstance().getCityByName(city),
                RoleCardFactory.getInstance().getCardByName(role), turn, false, actions);
    }
}
