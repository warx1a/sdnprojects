package com.snoopdogg.divination;

public class Variables {
	public static final int DRAYNOR_RIFT = 87306;
	public static final int DRAYNOT_RIFT_ANIM = 21234;
	public enum Vars {
		PALE(new int[]{18050,18173},new int[]{21228,21229},new int[]{21228, 21231},29384);
		
		private int[] interact;
		private int[] char_anims;
		private int[] spring_interact;
		private int paleMemory;
		
		Vars(int[] interact, int[] spring_interact, int[] char_anims, int paleMemory) {
			this.interact = interact;
			this.char_anims = char_anims;
			this.spring_interact = spring_interact;
			this.paleMemory = paleMemory;
		}
		
		public int[] getInteract() {
			return interact;
		}
		public int[] getPlayerAnim() {
			return char_anims;
		}
		public int[] getSpringAnim() {
			return spring_interact;
		}
		public int getMemoryId() {
			return paleMemory;
		}
	}

}
