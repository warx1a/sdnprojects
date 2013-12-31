package com.snoopdogg.dungeoneering;

import java.awt.Graphics;
import java.util.ArrayList;

import org.powerbot.event.PaintListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;

import com.snoopdogg.utils.Task;

@Manifest(authors="Snoop Dogg", name = "ThaDogg'sDung", description="Rips shiz up")
public class Main extends PollingScript implements PaintListener{
	public static String status;
	
	private final ArrayList<Task> tasklist = new ArrayList<>();
	
	@Override
	public void start() {
		tasklist.add(new Start(getContext()));
	}

	@Override
	public int poll() {
		for(Task t: tasklist) {
			if(t.activate()) {
				t.execute();
			}
		}
		return 50;
	}

	@Override
	public void repaint(Graphics arg0) {
		// TODO Auto-generated method stub
		
	}
		
	}
