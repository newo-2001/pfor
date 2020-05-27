package com.groep6.pfor.views;

import com.groep6.pfor.controllers.BoardController;
import com.groep6.pfor.util.IObserver;

/**
 * The view that shows the board
 * @author Mathijs
 */
public class BoardView implements IObserver {
    /** The boardController */
    private BoardController boardController;

    /**
     * The constructor
     * @param boardController The boardController
     */
    public BoardView(BoardController boardController) {
        this.boardController = boardController;
    }

    @Override
    public void update() {

    }
}
