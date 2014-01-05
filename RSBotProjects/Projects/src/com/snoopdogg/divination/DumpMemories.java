package com.snoopdogg.divination;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;

import com.snoopdogg.util.Task;

public class DumpMemories extends Task {

	public DumpMemories(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.backpack.count() == 28;
	}

	@Override
	public void execute() {
		Item paleMemory = ctx.backpack.select().id(29384).poll();
		GameObject rift = ctx.objects.select().id(Variables.DRAYNOR_RIFT).poll();
		ctx.movement.stepTowards(rift.getLocation());
		while(ctx.players.local().isInMotion()) {
			sleep(250);
		}
		if(rift.isOnScreen()) {
			rift.interact("Convert memories");
		}
		while(ctx.backpack.contains(paleMemory)) {
			sleep(Random.nextInt(250, 500));
		}

	}

}