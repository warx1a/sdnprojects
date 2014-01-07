package com.snoopdogg.divination;

import org.powerbot.script.lang.BasicNamedQuery;
import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Npc;

import com.snoopdogg.util.IntArray;
import com.snoopdogg.util.Task;

public class HarvestPale extends Task {
	
	public HarvestPale(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean activate() {
		return ctx.backpack.select().id(Variables.Vars.PALE.getMemoryId()).count() == 0 || ctx.backpack.select().count() < 28;
	}
	@Override
	public void execute() {
		final Npc moth = ctx.npcs.select().name("Pale wisp", "Pale spring").poll();
		final IntArray npc_id_list = new IntArray(Variables.Vars.PALE.getPlayerAnim());
		if(moth.isOnScreen()) {
			moth.interact("Harvest");
			while(moth.isValid() && ctx.players.local().getAnimation() == 21231 || npc_id_list.contains(ctx.players.local().getAnimation()) ||
					ctx.players.local().isInMotion()) {
				sleep(Random.nextGaussian(400, 700, 1.9));
			}
		} else {
			ctx.movement.stepTowards(moth.getLocation());
			while(ctx.players.local().isInMotion()) {
				sleep(Random.nextGaussian(200, 350, 1.1));
			}
		}
		
	}

}
