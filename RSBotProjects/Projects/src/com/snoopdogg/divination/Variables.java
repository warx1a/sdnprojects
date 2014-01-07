package com.snoopdogg.divination;

public class Variables {
	public static final int DRAYNOR_RIFT = 87306;
	public static final int DRAYNOT_RIFT_ANIM = 21234;
	public static final int[] char_anims = {21228,21229, 21231};
	public enum Vars {
		PALE(new int[]{18050,18173},29384,0),
		FLICKERING(new int[]{18151,18174},29385,29396);
		
		private int[] ids;
		private int paleMemory;
		private int enrichedId;
		
		Vars(int[] ids, int paleMemory, int enriched) {
			this.ids = ids;
			this.paleMemory = paleMemory;
			this.enrichedId = enriched;
		}
		
		public int[] getIds() {
			return ids;
		}
		public int getMemoryId() {
			return paleMemory;
		}
		public int getEnrichedId() {
			return enrichedId;
		}
	}

}
