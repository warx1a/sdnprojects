package com.snoopdogg.dungeoneering;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.GameObject;
import org.powerbot.script.wrappers.Item;

import com.snoopdogg.utils.Task;

public class Start extends Task {
	private final MethodContext d;

	public Start(MethodContext ctx) {
		super(ctx);
		d = ctx;
	}

	@Override
	public boolean activate() {
		return true;
	}

	@Override
	public void execute() {
		Item ring = d.backpack.select().id(15707).poll();
		ring.interact("Open party interface");
		final Component start_party = d.widgets.get(939,18);
		final Component floor_change = d.widgets.get(939, 80);
		final Component floor_1 = d.widgets.get(947,580);
		final Component complex_change = d.widgets.get(939,76);
		final Component complex_1 = d.widgets.get(938, 17);
		final Component get_complexity = d.widgets.get(938,13);
		final GameObject entrance = d.objects.id(85678).poll();
		
		if (start_party.isVisible()) {
			start_party.interact("Form party");
		}
		if(floor_change.isVisible() && floor_change.isOnScreen()) {
			floor_change.click();
		}
		if(floor_1.isVisible() && floor_1.isOnScreen()) {
			floor_1.click();
		}
		if(complex_change.isVisible() && complex_change.isOnScreen()) {
			complex_change.click();
		}
		if(complex_1.isVisible() && complex_1.isOnScreen() && complex_1.getTextureId() == 2877) {
			complex_1.interact("Select-complexity");
		}
		if(get_complexity.getText() == null) {
			d.widgets.get(938,84).interact("Close");
			Main.status = "Error in selecting complexity";
		}
		if(entrance.isValid()&& entrance.isOnScreen()) {
			entrance.interact("Enter");
		}
		
		
	}

}
