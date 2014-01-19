package com.snoopdogg.divination;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DivGUI {
	public static String selection;
	public static boolean finished;
	private final String[] stringvals = new String[]{"None","Pale","Flickering","Bright","Incandescent"};
	private JComboBox values = new JComboBox(stringvals);
	
	public DivGUI() {
		JButton finish = new JButton("Finish");
		final JFrame frame = new JFrame("Snoop Dogg's divinator");
		frame.setSize(new Dimension(400,400));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0,0));
		panel.add(values, BorderLayout.NORTH);
		panel.setBackground(Color.BLUE);
		values.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox values = (JComboBox) e.getSource();
				selection = (String) values.getSelectedItem();
			}
		});
		panel.add(finish, BorderLayout.SOUTH);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent c) {
				finished = true;
				frame.dispose();
			}
		});
		frame.setVisible(true);
		frame.add(panel);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new DivGUI();
		while(!finished) {
			Thread.sleep(200);
		}
		System.out.println(selection);
	}
}
