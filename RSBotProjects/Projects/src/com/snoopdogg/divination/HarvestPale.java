package com.snoopdogg.divination;

import java.util.concurrent.Callable;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Npc;

import com.snoopdogg.util.Task;

public class HarvestPale extends Task {
	
	public HarvestPale(MethodContext ctx) {
		super(ctx);
	}
	@Override
	public boolean activate() {
		return ctx.backpack.select().id(Vars.PALE.getMemoryId()).count() == 0 || ctx.backpack.select().count() < 28;
	}
	@Override
	public void execute() {
		final Npc moth = ctx.npcs.select().name("Pale wisp", "Pale spring").nearest().poll();
		if(moth.isOnScreen()) {
			moth.interact("Harvest");
			Condition.wait(new Callable<Boolean>() {
				@Override
				public Boolean call() {
					return !moth.isValid();
				}
			}, Random.nextGaussian(700,900,1.223), 5);
		} else {
			ctx.movement.stepTowards(moth.getLocation());
			Condition.wait(new Callable<Boolean>() {
				@Override
				public Boolean call() {
					return ctx.players.local().isInMotion();
				}
			}, Random.nextGaussian(500, 800, 1.1273476), 15);
		}
		
	}

}
