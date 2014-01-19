package com.snoopdogg.pathfinding;

import java.awt.Point;
import java.util.ArrayList;

public class Heuristic {
	private Point point;
	private int HEURISTIC;
	
	public static Point master;
	
	private static ArrayList<Point> pointlist = new ArrayList<>();
	public static ArrayList<Point> adjacentlist = new ArrayList<>();
	
	public Heuristic(Point pt) {
		this.point = pt;
	}
	private Point getPoint() {
		return point;
	}
	private int calculateHeuristic(Point endpoint) {
		HEURISTIC = (Math.abs(point.x - endpoint.x) + Math.abs(point.y - endpoint.y)) * 10;
		return HEURISTIC;
	}
	
	private static ArrayList<Point> mapArea() {
		for(int i = 0; i < Map.x; i++) {
			for(int q = 0; i <Map.y; i++) {
				pointlist.add(new Point(i,q));
			}
		}
		return pointlist;
	}
	
	public static ArrayList<Point> getAdjacent(Point pt) {
		mapArea();
		for(int i = 0; i < pointlist.size();i++) {
			if(pt.equals(pointlist.get(i))) {
				master = new Point(50,50);
			}
		}
		master = new Point(50,50);
		for(Point p: pointlist) {
			if(Math.abs(p.x - master.x) <= 1 && Math.abs(p.y - master.y) <= 1) {
				adjacentlist.add(p);
			}
		}
		System.out.println(adjacentlist);
		return adjacentlist;
		
	}

}
