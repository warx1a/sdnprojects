package com.snoopdogg.math;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class Grapher extends JPanel {
	
	public static boolean finished;
	
	public static int x;
	
	public static int y;
	
	public Graphics g;
	
	public Grapher() {
		JFrame canvas_frame = new JFrame("Snoop Dogg's grapher");
		paint(g);
		canvas_frame.pack();
		canvas_frame.setVisible(true);
		
	}
	
	public static void DisplayGUI() {
		final JFrame frame = new JFrame("Snoop Dogg's Grapher");
		final JPanel panel = new JPanel();
		final JTextPane x_pane = new JTextPane();
		final JTextPane y_pane = new JTextPane();
		final JButton finish = new JButton("Graph");
		panel.setSize(new Dimension(500,500));
		panel.setLayout(new BorderLayout());
		x_pane.setMargin(new Insets(0,10,0,10));
		y_pane.setMargin(new Insets(0,10,0,19));
		x_pane.setText("");
		y_pane.setText("");
		panel.add(x_pane,BorderLayout.WEST);
		panel.add(y_pane, BorderLayout.EAST);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isInteger(x_pane.getText())) {
					x = Integer.parseInt(x_pane.getText());
				}
				if(isInteger(y_pane.getText())) {
					y = Integer.parseInt(y_pane.getText());
				}
				finished = true;
				frame.dispose();
				
			}
		});
		panel.add(finish,BorderLayout.SOUTH);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) throws InterruptedException {
		DisplayGUI();
		while(!finished) {
			Thread.sleep(200);
		}
		System.out.println(x);
		System.out.println(y);
		new Grapher();
	}
	@Override
	public void paint(Graphics g) {
		super.paintComponent(g);
		Graphics2D g1 = (Graphics2D) g;
		g1.setColor(Color.BLUE);
		g1.drawLine(x, y, x+25, y);
	}
	
	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch(NumberFormatException e) {
			return false;
		}
		return true;
	}

}
