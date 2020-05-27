package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Consul role.
 * @author Mitchell van Rijswijk
 *
 */
public class ConsulAction implements IAction {

	/**
	 * Increases the amount of legions in the current city by 1.
	 * 
	 */
	public void execute() {
		/* 
		 * currentCity.addLegions(1); 
		 */
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Consul";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Plaats 1 legioen op jouw stad.";
	}

}