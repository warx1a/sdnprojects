package com.snoopdogg.paintware;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintSoftware {
	private Graphics g;
	private Color color = new Color(0);
	private String chosen;
	
	public PaintSoftware() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		final JFrame frame = new JFrame("Snoop Dogg's Paint Software");
		frame.setSize(500,500);
		final JPanel panel = new JPanel();
		panel.setSize(5005,500);
		panel.setLayout(new BorderLayout());
		final JComboBox<String> COLORS = new JComboBox<>(new String[]{"Red","Green","Blue","Yellow"});
		panel.add(COLORS, BorderLayout.WEST);
		frame.add(panel);
		frame.setVisible(true);
		g = frame.getGraphics();
		COLORS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				chosen = COLORS.getSelectedItem().toString();
			}
			
		});
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				final Point p = arg0.getPoint();
				g.setColor(getChosen());
				g.drawLine(p.x, p.y, p.x, p.y);
				
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
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				final Point p = arg0.getPoint();
				g.setColor(getChosen());
				g.drawLine(p.x, p.y, p.x, p.y);
				
			}

			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public Color getChosen() {
		switch(chosen) {
		case("Red"): color = Color.red;
		case("Blue"): color = Color.blue;
		case("Yellow"): color = Color.yellow;
		case("Green"): color = Color.green;
		default: color = Color.black;
		return color;
		}
	}
	
	public static void main(String[] args) {
		new PaintSoftware();
	}

}
