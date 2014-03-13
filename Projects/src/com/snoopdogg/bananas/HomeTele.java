package com.snoopdogg.bananas;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.util.Random;
import org.powerbot.script.wrappers.Component;

import com.snoopdogg.util.Task;

import java.util.concurrent.Callable;

public class HomeTele extends Task {

	public HomeTele(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.backpack.count() == 28;
	}

	@Override
	public void execute() {
		final Component hometele = ctx.widgets.get(1465,10);
		final Component edge = ctx.widgets.get(1092, 45);
		if(hometele.isOnScreen() && hometele.isValid()) {
			hometele.click(true);
            try {
                Thread.sleep(Random.nextInt(500,750));
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            if(edge.isOnScreen() && edge.isVisible()) {
				edge.click(true);
			}
		}
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                return ctx.players.local().getAnimation() == 16385;
            }
        },500,15);
	}

}
