package com.groep6.pfor.models.cards.actions;

/**
 * Battle ability of the Regina Foederata role.
 * @author Mitchell van Rijswijk
 *
 */
public class ReginaFoederataAction implements IAction {

	/**
	 * Gets the battle result. If the current city still has barbarians after the battle,
	 * 1 extra barbarian gets deleted. The legion count in the city is incremented. 
	 */
	public void execute() {
		/* get battle result
		 * if (currentCity.getBarbarians() - fallenBarbarians > 0)
		 * 		fallenBarbarians--;
		 * currentCity.setLegions(currentCity.getLegions() + 1);
		 * */ 
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 * 
	 */
	public String getName() {
		return "Regina Foederata";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 * 
	 */
	public String getDescription() {
		return "Verwijder na het gevecht 1 barbaar uit jouw stad. Plaats hierbij ook maximaal 1 legioen op jouw stad.";
	}

}