package com.snoopdogg.utils;

import java.util.Arrays;

/*
 * class will be used to sort through int[] arrays and main methods needed are contains
 * and indexof the object
 */

public class IntArray {
	private int[] array;
	public IntArray(int... array) {
		this.array = array;
	}
	
	public boolean contains(int obj) {
		for(int i: array) {
			if(i == obj) {
				return true;
			}
		}
		return false;
	}
	
	public int getIndex(int obj, boolean bysearcher) {
		if(bysearcher) {
			Arrays.sort(array);
			return Arrays.binarySearch(array,obj);
		} else {
			for(int i = 0;i < array.length;i++) {
				if(array[i] == obj) {
					return i;
				}
			}
		}
		return -1;
	}

}
