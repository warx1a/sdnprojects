package com.snoopdogg.grinder;

import org.powerbot.script.rt6.ClientContext;
import org.powerbot.script.rt6.Item;

import com.snoopdogg.util.Task;

public class Grind extends Task {

	public Grind(ClientContext ctx) {
		super(ctx);
	}

	@Override
	public boolean activate() {
		return ctx.backpack.select().id(GUI.chosen.getId()).count() > 0;
	}

	@Override
	public void execute() {
		Item gridable = ctx.backpack.select().id(GUI.chosen.getId()).poll();
		if(gridable.interact("Grind")) {
			Main.grinded += 1;
		}
	}

}
