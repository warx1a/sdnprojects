package com.snoopdogg.util;

import java.util.List;

public class StringFuncts {
	
	public boolean contains(String str,Character key) {
		for(char s:str.toCharArray()) {
			if(s == key) {
				return true;
			}
		}
		return false;
	}
	public boolean contains(List<?> list,Character key) {
		for(Object s:list.toArray()) {
			if(s.equals(key)) {
				return true;
			}
		}
		return false;		
	}
	public boolean contains(Character[] chr,Character key) {
		for(Character c:chr) {
			if(c.equals(key)) {
				return true;
			}
		}
		return false;
	}
	public int getLetterCount(String str,Character k) {
		int d = 0;
		for(char s:str.toCharArray()) {
			if(s == k) {
				d += 1;
			}
		}
		return d;
	}
}