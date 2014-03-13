package com.snoopdogg.moneymaking;

import javax.swing.SwingUtilities;

import org.powerbot.script.PollingScript;

import com.snoopdogg.moneymaking.GUI;

public class Main extends PollingScript {
	public String chosen;
	
	@Override
	public void start() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GUI(ctx);
			}
		});
		chosen = GUI.chosen;
	}

	@Override
	public int poll() {
		switch(chosen) {
		case "Cat": System.out.print("blah");
		}
		return 0;
	}

}