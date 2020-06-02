package com.groep6.pfor.models;

/**
 * Faces of the dice in Pandemic: Fall of Rome. BARBARIAN face is on the dice twice.
 * @author Mitchell van Rijswijk
 *
 */
public enum DiceFace {
	BARBARIAN {
		@Override
		public void execute() {
			
		}
	},
	LEGION {
		@Override
		public void execute() {
			
		}
	},
	BOTH {
		@Override
		public void execute() {
			
		}
	},
	TWO_BARBARIAN_LEGION {
		@Override
		public void execute() {
			
		}
	},
	SPECIAL {
		@Override
		public void execute() {
			
		}
	};
	
	public abstract void execute();
	
}
