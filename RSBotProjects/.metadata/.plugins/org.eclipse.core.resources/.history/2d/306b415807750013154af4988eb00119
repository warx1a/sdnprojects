package com.snoopdogg.bananas;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

import com.snoopdogg.util.Task;

public class Picker extends Task {

	public Picker(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile t = ctx.players.local().getLocation();
		return t.distanceTo(ctx.objects.select().id(2073,2074,2076,2076,2077).poll().getLocation()) <= 10;
	}

	@Override
	public void execute() {
		while(ctx.backpack.size() != 28) {
			GameObject o = ctx.objects.select().id(2073,2074,2075,2076,2077).poll();
			o.interact("Pick");
		}
		
		
	}
	

}
