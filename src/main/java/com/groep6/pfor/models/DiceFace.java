package com.groep6.pfor.models;

/**
 * Faces of the dice in Pandemic: Fall of Rome. BARBARIAN face is on the dice twice.
 * @author Mitchell van Rijswijk
 *
 */
public enum DiceFace {
	BARBARIAN {
		@Override
		public void execute(City city) {
			city.removeBarbarians(1);
		}
	},
	LEGION {
		@Override
		public void execute(City city) {
			city.removeLegions(1);
		}
	},
	BOTH {
		@Override
		public void execute(City city) {
			city.removeBarbarians(1);
			city.removeLegions(1);
		}
	},
	TWO_BARBARIAN_LEGION {
		@Override
		public void execute(City city) {
			city.removeBarbarians(2);
			city.removeLegions(1);
		}
	},
	SPECIAL {
		@Override
		public void execute(City city) {
			Game game = Game.getInstance();
			Player player =  game.getPlayerTurn();
			player.getRoleCard().executeAbility();
		}
	};
	
	public abstract void execute(City city);
	
}
