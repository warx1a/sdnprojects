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
		return ctx.bank.isOnScreen() && ctx.backpack.isEmpty();
	}

	@Override
	public void execute() {
		ctx.equipment.getItemAt(Slot.NECK).interact("Karamja");
		}
		
	}
