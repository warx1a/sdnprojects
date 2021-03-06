package com.snoopdogg.grinder;

import java.util.concurrent.Callable;

import org.powerbot.script.Condition;
import org.powerbot.script.Locatable;
import org.powerbot.script.rt6.ClientContext;

import com.snoopdogg.util.Task;

public class Bank extends Task {
	
	public Bank(ClientContext ctx) {
		super(ctx);
	}
	
	// unused, may be in future
	@Deprecated
	private final int[] products = {10111,235,241,1975,9594,9736};
	
	@Override
	public boolean activate() {
		return ctx.backpack.select().count() == 28 || ctx.backpack.select().id(GUI.chosen.id()).count() == 0;
	}
	
	@Override
	public void execute() {
		final Locatable BANK_TILE = ctx.bank.nearest();
		if(BANK_TILE.tile().distanceTo(ctx.players.local().tile()) >= 10) {
			ctx.movement.step(BANK_TILE);
			Condition.wait(new Callable<Boolean>() {
				@Override
				public Boolean call() throws Exception {
					return ctx.players.local().inMotion();
				}
				
			},1000,3);
		}
		if(BANK_TILE.tile().matrix(ctx).inViewport()) {
			if(BANK_TILE.tile().matrix(ctx).interact("Bank")) {
				if(ctx.bank.depositInventory()) {
					if(ctx.bank.withdraw(GUI.chosen.id(), 28)) {
						// had no reason to put under boolean
						ctx.bank.close();
					}
				}
			}
		}
	}

}
