package com.snoopdogg.divination;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.GameObject;

import com.snoopdogg.util.Task;

public class DumpMemories extends Task {

	public DumpMemories(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28;
	}

	@Override
	public void execute() {
		ctx.antipatterns.setEnabled(true);
		final Component getXp = ctx.widgets.get(131,26);
		final GameObject rift = ctx.objects.select().id(Variables.DRAYNOR_RIFT).poll();
		if(!rift.isOnScreen()) {
			ctx.movement.stepTowards(rift.getLocation());
			while(ctx.players.local().isInMotion()) {
				sleep(250);
			}
		}
		if(rift.isOnScreen()) {
			rift.interact("Convert memories");
			sleep(2000);
			if(getXp.isValid() && getXp.isOnScreen()) {
				getXp.interact("Gain-experience");
				while(ctx.backpack.select().id(29384).count() > 0) {
					sleep(Random.nextInt(250, 500));
				}
			}
		}

	}

}
