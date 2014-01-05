package com.snoopdogg.bananas;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

import com.snoopdogg.util.Task;

public class Bank extends Task {
	private int d = 60834;
	private Tile[] t = new Tile[]{ new Tile(3078,3501,0), new Tile(3080,3501,0)};
	private TilePath a = new TilePath(ctx,t);

	public Bank(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.objects.select().id(d).poll().getLocation().distanceTo(ctx.players.local().getLocation()) <= 5 || ctx.bank.isOnScreen();
	}

	@Override
	public void execute() {
		a.traverse();
		if(ctx.bank.isOpen()) {
			ctx.bank.depositInventory();
		} else {
			ctx.bank.open();
		}
		
		
	}

}
