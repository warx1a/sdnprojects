package com.snoopdogg.moneymaking;

import java.awt.EventQueue;

import org.powerbot.script.PollingScript;

import com.snoopdogg.moneymaking.GUI;

public class Main extends PollingScript {
	public String chosen;
	
	@Override
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI();
			}
		});
		chosen = GUI.methods.getSelectedItem().toString();
	}

	@Override
	public int poll() {
		switch(chosen) {
		case "Cat": System.out.print("blah");
		}
		return 0;
	}
	
	public static void main(String[] args) throws InterruptedException {
		new GUI();
		while(!GUI.isStarted) {
			Thread.sleep(200);
		}
		System.out.println(GUI.chosen);
	}

}