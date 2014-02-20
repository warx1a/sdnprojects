package com.snoopdogg.util;

import java.util.List;

import org.powerbot.script.util.Random;

public class Randomization {
	
	public static Integer randChoice(List<Integer> list) {
		final int randint = Random.nextGaussian(0, list.size(), Random.nextDouble());
		if(list != null){
			Integer val = list.get(randint);
			return val;
		}
		return randint;
	}

}
