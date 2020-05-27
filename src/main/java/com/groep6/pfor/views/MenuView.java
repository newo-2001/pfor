package com.groep6.pfor.views;

import com.groep6.pfor.controllers.MenuController;

/**
 * The view that show's the menu where you can control the game settings
 * @author Mathijs
 */
public class MenuView {
    /** The menuController */
    private MenuController menuController;

    /**
     * The constructor
     * @param menuController The menuController
     */
    public MenuView(MenuController menuController) {
        this.menuController = menuController;
    }
}
