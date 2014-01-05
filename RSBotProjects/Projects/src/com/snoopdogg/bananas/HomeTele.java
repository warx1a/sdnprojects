package com.snoopdogg.bananas;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Component;

import com.snoopdogg.util.Task;

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
		Component hometele = ctx.widgets.get(1465,10);
		Component edge = ctx.widgets.get(1092, 45);
		if(hometele.isOnScreen() && hometele.isValid()) {
			hometele.click(true);
			if(edge.isOnScreen() && edge.isVisible()) {
				edge.click(true);
			}
		}
		while(ctx.players.local().getAnimation() == 16385) {
			sleep(500);
		}
	}

}
