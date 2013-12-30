package com.snoopdogg.moneymaking;

import org.powerbot.script.AbstractScript;

import com.snoopdogg.moneymaking.GUI;

public class Main extends AbstractScript {
	private static String selected;

	@Override
	public void run() {
		switch(GUI.chosen) {
		case "Cat": selected = "Cat";
		case "Dog": selected = "Dog";
		case "Cop": selected = "Cop";
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		new GUI();
		while(!GUI.isStarted) {
			Thread.sleep(500);
		}
		System.out.println(selected);
	}

}
