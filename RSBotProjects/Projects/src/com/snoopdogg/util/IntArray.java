package com.snoopdogg.util;

public class IntArray {
	
	private int[] array;
	
	public IntArray(int... array) {
		this.array = array;
	}
	
	public boolean contains(int id) {
		for(int i = 0; i < array.length;i++) {
			if(array[i] == id) {
				return true;
			}
		}
	return false;
	}

}
