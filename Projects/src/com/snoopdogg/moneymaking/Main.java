package com.snoopdogg.moneymaking;

import org.powerbot.script.AbstractScript;

import com.snoopdogg.moneymaking.GUI;

public class Main extends AbstractScript {
	public static String selection = GUI.methods.getSelectedItem().toString();

	@Override
	public void run() {

	}
	
	public static void main(String[] args) throws InterruptedException {
		new GUI();
		while(!GUI.isStarted) {
			Thread.sleep(250);
		}
		System.out.print(selection);
	}

}
