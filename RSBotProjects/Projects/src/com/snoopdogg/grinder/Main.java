package com.snoopdogg.grinder;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;

import com.snoopdogg.util.Task;

public class Main extends PollingScript<org.powerbot.script.rt6.ClientContext> implements PaintListener {

	private ArrayList<Task> tasks = new ArrayList<Task>();
	public static Integer grinded;
	public Long per_hour;
	public Long time_ran;
	private long STARTTIME;
	
	@Override
	public void start() {
		STARTTIME = System.currentTimeMillis();
		tasks.add(new Bank(ctx));
	}
	
	@Override
	public void poll() {
		if(ctx.game.loggedIn()) {
			for(Task t:tasks) {
				if(t.activate()) {
					t.execute();
				}
			}
		}
	}
	
	public Integer calcHourly() {
		return (int) ((grinded) * 3600000D / (System.currentTimeMillis() - STARTTIME));	
	}

	@Override
	public void repaint(Graphics arg0) {
		final Graphics2D g = (Graphics2D) arg0;
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, 100, 100);
		g.setColor(Color.CYAN);
		g.drawString("Grinded" + grinded.toString(), 0, 0);
		g.drawString("Hourly: " +calcHourly().toString(), 25, 0);
		g.drawString("Grinding:" + GUI.chosen.display(), 50, 0);
	}
}
