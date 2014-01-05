package com.snoopdogg.divination;

import org.powerbot.script.lang.BasicNamedQuery;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

import com.snoopdogg.util.Task;

public class HarvestPale extends Task {
	
	public HarvestPale(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	private final GameObject rift = ctx.objects.select().id(Variables.DRAYNOR_RIFT).poll();
	private final Tile t = rift.getLocation();
	@Override
	public boolean activate() {
		return t.distanceTo(ctx.players.local().getLocation()) <= 5;
	}
	@Override
	public void execute() {
		
		
	}

}
