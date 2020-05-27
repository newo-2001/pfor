package com.groep6.pfor.models.cards.actions;

/**
 * Special ability of the Magister Militum role
 * @author Mitchell van Rijswijk
 *
 */
public class ActionMagisterMilitum implements IAction {

	/**
	 * Gets the battle result. If any legion has fallen, one legion gets replenished.
	 */
	public void execute() {
		// get battle result
		// if (fallenLegions > 0)
		// 		fallenLegions--;
	}

	/**
	 * Gets the name of the role.
	 * @return The name of the role.
	 */
	public String getName() {
		return "Magister Militum";
	}

	/**
	 * Gets the action description.
	 * @return The action description.
	 */
	public String getDescription() {
		String description = "Verminder tijdens een gevecht het aantal verloren legioenen met 1.";
		return description;
	}

}
