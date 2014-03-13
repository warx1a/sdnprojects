package com.snoopdogg.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;



public enum Card {
	ACE("http://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Playing_card_spade_A.svg/200px-Playing_card_spade_A.svg.png",
			"http://upload.wikimedia.org/wikipedia/commons/thumb/5/57/Playing_card_heart_A.svg/200px-Playing_card_heart_A.svg.png",
			"http://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Playing_card_diamond_A.svg/200px-Playing_card_diamond_A.svg.png",
			"http://upload.wikimedia.org/wikipedia/commons/thumb/3/36/Playing_card_club_A.svg/200px-Playing_card_club_A.svg.png", 10);
	
	public String url;
	
	public static ArrayList allvals = new ArrayList();
	
	private String Spades;
	private String Hearts;
	private String Diamonds;
	private String Clubs;
	private int Value;
	
	Card(final String Spades, final String Hearts, final String Diamonds, final String Clubs, final int Value) {
		this.Spades = Spades.toString();
		this.Hearts = Hearts;
		this.Diamonds = Diamonds;
		this.Clubs = Clubs;
	}
	
	public String getSpades() {
		url = Spades;
		return Spades;
	}
	public String getHearts() {
		url = Hearts;
		return Hearts;
	}
	public String getDiamonds() {
		url = Diamonds;
		return Diamonds;
	}
	public String getClubs() {
		url = Clubs;
		return Clubs;
	}
	public int getValue() {
		return Value;
	}
	
	public static ArrayList getAll() {
		final Card[] li = Card.values();
		for(int c = 0; c < li.length;c++) {
			allvals.add(li[c]);
		}
		return allvals;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Card.getAll());
	}

}
