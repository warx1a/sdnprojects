package com.snoopdogg.bananas;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.util.Condition;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

import com.snoopdogg.util.Task;

import java.util.concurrent.Callable;

public class Bank extends Task {
	private Tile[] t = new Tile[]{ new Tile(3078,3501,0), new Tile(3080,3501,0)};
	private TilePath a = new TilePath(ctx,t);

	public Bank(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.bank.getNearest().getLocation().distanceTo(ctx.players.local().getLocation()) <= 5 ||
                ctx.bank.isOnScreen();
	}

	@Override
	public void execute() {
        ctx.movement.findPath(ctx.bank.getNearest().getLocation()).traverse();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().isInMotion();
            }
        },500,5);
		if(ctx.bank.isOpen()) {
			ctx.bank.depositInventory();
		} else {
			ctx.bank.open();
		}
		
		
	}

}
