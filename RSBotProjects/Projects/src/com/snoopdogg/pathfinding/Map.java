package com.snoopdogg.pathfinding;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Map implements MouseMotionListener {
	private Graphics g;
	private JFrame frame;
	
	private boolean startPointSelected;
	private boolean endPointSelected;
	private boolean obstaclePointSelected;
	
	private LinkedList<Point> obstaclelist = new LinkedList<>();
	public static Point endpoint = null;
	public static Point startpoint = null;
	
	public static int x;
	public static int y;
	
	protected static Point p = new Point(50,50);
	
	public Map(int x, int y) {
		this.x = x;
		this.y = y;
		final JMenuBar MENUBAR = new JMenuBar();
		final JMenu MENU = new JMenu("Start/End/Obst");
		final JMenuItem STARTPOINT = new JMenuItem("Start");
		final JMenuItem ENDPOINT = new JMenuItem("End");
		final JMenuItem OBSTACLEPOINT = new JMenuItem("Obstacle");
		frame = new JFrame("Pathfinder");
		final JPanel panel = new JPanel();
		frame.setSize(x,y);
		panel.setSize(x,y);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(1);
		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				p = arg0.getPoint();
				final Integer x_val = (Integer) p.x;
				final Integer y_val = (Integer) p.y;
				g = frame.getGraphics();
				if(startPointSelected) {
					g.setColor(Color.GREEN);
					/// flip 3rd and 1st element
					g.drawLine(p.x - 12, p.y - 12, p.x + 12, p.y + 12);
					g.drawLine(p.x + 12, p.y - 12, p.x - 12, p.y +12);
					g.drawOval(p.x - 15,p.y - 15,30,30);
					g.drawString("Start: " + x_val.toString() + " , " + y_val.toString(), 105, 50);
					startpoint = p;
					startPointSelected = false;
				} 
				else if(obstaclePointSelected) {
					g.setColor(Color.BLUE);
					g.drawLine(p.x, p.y, p.x, p.y);
					obstaclelist.add(p);
				}
				else if(endPointSelected) {
					g.setColor(Color.RED);
					g.drawLine(p.x - 12, p.y - 12, p.x + 12, p.y + 12);
					g.drawLine(p.x + 12, p.y - 12, p.x - 12, p.y +12);
					g.drawOval(p.x - 15,p.y - 15,30,30);
					g.drawString("End: " + x_val.toString() + " , " + y_val.toString(), 105, 75);
					endpoint = p;
					endPointSelected = false;
				}
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
		frame.addMouseMotionListener(this);
		
		STARTPOINT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				startPointSelected = true;
				endPointSelected = false;
				obstaclePointSelected = false;
				
			}
			
		});
		ENDPOINT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				endPointSelected = true;
				startPointSelected = false;
				obstaclePointSelected = false;
				
			}
			
		});
		OBSTACLEPOINT.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				obstaclePointSelected = true;
				endPointSelected = false;
				startPointSelected = false;
				
				
			}
			
		});
		
		MENU.add(STARTPOINT);
		MENU.add(ENDPOINT);
		MENU.add(OBSTACLEPOINT);
		MENUBAR.add(MENU);
		frame.add(MENUBAR);
		if(startpoint != null && endpoint != null) {
			g.drawString(startpoint.toString(), 450, 450);
			g.drawString(endpoint.toString(), 400, 400);
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		new Map(500,500);
		while(p.x == 50) {
			Thread.sleep(500);
		}
		Heuristic.getAdjacent(p);
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		g = frame.getGraphics();
		endPointSelected = false;
		startPointSelected = false;
		obstaclePointSelected = true;
		final Point z = arg0.getPoint();
		g.setColor(Color.BLUE);
		g.drawLine(z.x,z.y,z.x,z.y);
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}