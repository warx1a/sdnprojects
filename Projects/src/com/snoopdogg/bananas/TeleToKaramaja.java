package com.snoopdogg.bananas;

import org.powerbot.script.methods.MethodContext;
import org.powerbot.script.methods.Equipment.Slot;

import com.snoopdogg.util.Task;

public class TeleToKaramaja extends Task {

	public TeleToKaramaja(MethodContext ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean activate() {
		return ctx.bank.isOnScreen() && ctx.backpack.select().isEmpty();
	}

	@Override
	public void execute() {
        if(ctx.equipment.getItemAt(Slot.NECK) != ctx.equipment.getNil()) {
            ctx.equipment.getItemAt(Slot.NECK).interact("Karamja");
        }
	}
}
