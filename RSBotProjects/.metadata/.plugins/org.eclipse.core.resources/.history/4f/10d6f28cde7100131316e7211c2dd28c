package com.snoopdogg.moneymaking;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class GUI extends JFrame {
	public static String chosen;
	public static boolean isStarted;
	private JButton start = new JButton("Start");
	private Object ae;
	public static String[] task = {"None","Cop","Dog","Cat"};
	static JComboBox methods = new JComboBox(task);

	public GUI() {
		JFrame frame = new JFrame();
		JPanel cont = new JPanel();
		frame.setSize(400,400);
		frame.setTitle("SnoopDogg's moneymaker");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		cont.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		cont.setLayout(new BorderLayout(0,0));
		cont.add(methods,BorderLayout.LINE_START);
		methods.setSelectedItem("None");
		methods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				JComboBox methods = (JComboBox) c.getSource();
				chosen = methods.getSelectedItem().toString();
			}
		});
		cont.add(start,BorderLayout.LINE_END);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStarted = true;
			}
		});
		frame.add(cont);
		frame.pack();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		new GUI();
		while(!isStarted) {
			Thread.sleep(500);
		}
		System.out.println(chosen);
	}

}