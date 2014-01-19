package com.snoopdogg.pathfinding;

import java.awt.Point;
import java.util.ArrayList;

public class Heuristic {
	
	public static int master;
	
	private static ArrayList<Point> pointlist = new ArrayList<>();
	public static ArrayList<Point> adjacentlist = new ArrayList<>();
	
	//////////////////////////////////////////////////////////////////////////////
	
	private static ArrayList<Point> mapArea() {
		for(int i = 0; i < Map.x; i++) {
			for(int q = 0; i <Map.y; i++) {
				pointlist.add(new Point(i,q));
			}
		}
		return pointlist;
	}
	
	public static int getIndex(Point pt) {
		mapArea();
		for(int i = 0; i < pointlist.size();i++) {
			if(pt.equals(pointlist.get(i))) {
				master = i;
			}
		}
		return master;
	}
	
	public static Point getPoint(int index) {
		return pointlist.get(index);
	}
	
	public static ArrayList<Point> getAdjacent(Point point) {
		mapArea();
		for(Object p: pointlist.toArray()) {
			Point d = (Point) p;
			if(Math.abs(getPoint(getIndex(point)).x - d.x) <= 1 && Math.abs(getPoint(getIndex(point)).y - d.y) <= 1) {
				adjacentlist.add((Point) p);
			}
		}
		System.out.println(adjacentlist);
		return adjacentlist;
	}
	
	public static void Main(String[] arsg) throws InterruptedException {
		new Map(300,300);
		while(Map.startpoint == null) {
			Thread.sleep(300);
		}
		getAdjacent(Map.startpoint);
		System.out.println(adjacentlist);
	}

}
