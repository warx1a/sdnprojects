package com.snoopdogg.bananas;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Tile;

import com.snoopdogg.util.Task;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class Picker extends Task {
	
	protected AtomicInteger picked;

    private final int[] TREE_IDS = {2073,2074,2076,2077};

	public Picker(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		Tile t = ctx.players.local().getLocation();
		return t.distanceTo(ctx.objects.select().id(TREE_IDS).poll().getLocation()) <= 10 &&
                ctx.backpack.count() < 28;
	}

	@Override
	public void execute() {
		while(ctx.backpack.size() != 28) {
			GameObject o = ctx.objects.id(TREE_IDS).nearest().poll();
            if(o.isOnScreen()) {
                o.interact("Pick");
            } else {
                ctx.movement.stepTowards(o.getLocation());
            }
            Condition.wait(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    return !ctx.players.local().isIdle();
                }
            },250,6);
            picked.incrementAndGet();
			
		}
		
		
	}
	

}
