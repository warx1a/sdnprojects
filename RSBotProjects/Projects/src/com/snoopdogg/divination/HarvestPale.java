package com.snoopdogg.divination;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

import com.snoopdogg.util.Task;

public class HarvestPale extends Task {
	
	public HarvestPale(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean activate() {
		final GameObject rift = ctx.objects.select().id(Variables.DRAYNOR_RIFT).poll();
		final Tile t = rift.getLocation();
		return t.distanceTo(ctx.players.local().getLocation()) <= 5 && ctx.backpack.select().id(Variables.Vars.PALE.getMemoryId()).count() == 0;
	}
	@Override
	public void execute() {
		
		
	}

}