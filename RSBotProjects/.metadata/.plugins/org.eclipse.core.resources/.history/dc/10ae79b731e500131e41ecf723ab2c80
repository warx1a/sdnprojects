package com.snoopdogg.divination;

import java.util.concurrent.Callable;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.GameObject;

import com.snoopdogg.util.Task;

public class DumpMemories extends Task {
	
	private final int DRAYNOR_RIFT = 87306;

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
		final GameObject rift = ctx.objects.select().id(DRAYNOR_RIFT).nearest().poll();
		if(!rift.isOnScreen()) {
			ctx.movement.stepTowards(rift.getLocation());
			Condition.wait(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					return !ctx.players.local().isInMotion();
				}
			}, (int) Random.nextDouble(500,780), 15);
		}
		if(rift.isOnScreen()) {
			rift.interact("Convert memories");
			sleep(2000);
			if(getXp.isValid() && getXp.isOnScreen()) {
				getXp.interact("Gain-experience");
			}
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return !rift.isValid();
                }
            }, Random.nextGaussian(400, 650, 1.992), 25);
		}

	}

}
