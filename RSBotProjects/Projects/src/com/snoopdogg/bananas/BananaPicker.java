package com.snoopdogg.bananas;

import java.util.ArrayList;

import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Random;

import com.snoopdogg.bananas.Picker;
import com.snoopdogg.bananas.Bank;
import com.snoopdogg.bananas.HomeTele;
import com.snoopdogg.bananas.TeleToKaramaja;

import com.snoopdogg.util.Task;
@Manifest(authors = "Snoop Dogg", name = "Banana Pickerz", description = "Picks shix", version = 1.0)
public class BananaPicker extends PollingScript {
	private ArrayList<Task> task = new ArrayList<Task>();
	
	@Override
	public void start() {
		task.add(new Picker(ctx));
		task.add(new Bank(ctx));
		task.add(new HomeTele(ctx));
		task.add(new TeleToKaramaja(ctx));
	}

	@Override
	public int poll() {
		for(Task t:task) {
			if (t.activate()) {
				t.execute();
			}
		}
		return Random.nextGaussian(100,200,1);
	}

}
