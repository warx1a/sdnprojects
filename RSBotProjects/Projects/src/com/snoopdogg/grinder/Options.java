package com.snoopdogg.grinder;

public enum Options {

	//"title" is depreciated, may be used in future
	NONE(0,null),
	CHOCOLATE(1973,"Chocolate bar"),
	BLUE_DRAG_SCALE(243,"Blue dragon scale"),
	UNICORN_HORN(237,"Unicorn horn"),
	KEBBIT_TEETH(10109,"Kebbit teeth"),
	MUD_RUNE(4698,"Mud rune"),
	DESERT_GOAT_HORN(9735,"Desert goat horn");
	
	private int id;
	private String title;
	
	Options(final int id,final String title) {
		this.id = id;
		this.title = title;
	}
	
	
	// item id
	public int id() {
		return id;
	}
	
	/// returns name of item
	public String display() {
		return title;
	}
}
