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
			city.removeBarbarian();
		}
	},
	LEGION {
		@Override
		public void execute(City city) {
			city.removeLegion();
		}
	},
	BOTH {
		@Override
		public void execute(City city) {
			city.removeBarbarian();
			city.removeLegion();
		}
	},
	TWO_BARBARIAN_LEGION {
		@Override
		public void execute(City city) {
			city.removeBarbarian();
			city.removeBarbarian();
			city.removeLegion();
		}
	},
	SPECIAL {
		@Override
		public void execute(City city) {
			// Execute order 66
		}
	};
	
	public abstract void execute(City city);
	
}
