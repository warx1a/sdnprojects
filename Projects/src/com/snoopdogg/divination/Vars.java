package com.snoopdogg.divination;

public enum Vars {
	PALE(new int[]{18050,18173},29384,0),
	FLICKERING(new int[]{18151,18174},29385,29396),
	BRIGHT(new int[]{18153,18176},29386,29397),
	GLOWING(new int[]{18155,18178},29387,29398);

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
