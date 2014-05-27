package com.snoopdogg.bananas;

import java.awt.*;
import java.util.ArrayList;

import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Random;

import com.snoopdogg.util.Task;

@Manifest(authors = "Snoop Dogg", name = "Banana Pickerz", description = "Picks Bananas", version = 1.0)
public class BananaPicker extends PollingScript implements PaintListener {
	private ArrayList<Task> task = new ArrayList<Task>();

    private final Picker p = new Picker(ctx);
	
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
    @Override
    public void repaint(Graphics g) {
        final Graphics2D g1 = (Graphics2D) g;
        g1.setColor(Color.white);
        g1.setFont(new Font("Comic Sans",Font.BOLD,20));
        g1.drawString(p.picked.toString(),0,0);

    }

}
