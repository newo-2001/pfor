package com.groep6.pfor.models;

/**
 * Game state for a collection of screens. MENU for MenuView, HostView, JoinView, LobbyView.
 * GAME for BoardView, MoveView, RecruitLegionView etc. Switch between states when switching between
 * collections of views.
 * @author Mitchell van Rijswijk
 *
 */
public enum GameState {
	MENU,
	GAME
}
