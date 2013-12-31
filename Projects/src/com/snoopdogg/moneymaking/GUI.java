package com.snoopdogg.moneymaking;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUI extends JFrame implements ActionListener {
	public static String chosen;
	public static boolean isStarted;
	private JButton start = new JButton("Start");
	public static String[] task = {"Cop","Dog","Cat"};
	static JComboBox methods = new JComboBox(task);

	public GUI() {
		Container cont = getContentPane();
		setTitle("Snoop dogg's moneymaker!");
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		cont.setLayout(new BorderLayout(0,0));
		cont.add(methods,BorderLayout.LINE_START);
		methods.addActionListener(this);
		cont.add(start,BorderLayout.LINE_END);
		start.addActionListener(this);
	}
	
	public static void main(String[] args) throws InterruptedException {
		new GUI();
		while(!isStarted) {
			Thread.sleep(500);
		}
		System.out.println(chosen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == methods) {
			JComboBox methods = (JComboBox) e.getSource();
			chosen = methods.getSelectedItem().toString();
		} else {
			isStarted = true;
		}
	}

}
