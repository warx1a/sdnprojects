package com.snoopdogg.divination;

import java.util.LinkedList;

import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Random;

import com.snoopdogg.util.Task;
@Manifest(authors = "Snoop Dogg", name = "Diva", description = "Stuff", version = 1.0)
public class Main extends PollingScript {
	private LinkedList<Task> task = new LinkedList<Task>();
	
	@Override
	public void start() {
		task.add(new HarvestPale(ctx));
		task.add(new DumpMemories(ctx));
	}

	@Override
	public int poll() {
		for(Task t:task) {
			if(t.activate()) {
				t.execute();
			}
		}
		return Random.nextGaussian(100,250,1.2);
	}

}