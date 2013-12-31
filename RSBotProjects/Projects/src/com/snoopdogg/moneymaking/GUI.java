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

import org.powerbot.script.methods.MethodContext;

public class GUI extends JFrame {
	public static String chosen;
	public static boolean isStarted;
	private JButton start = new JButton("Start");
	private Object ae;
	public static String[] task = {"None","Cop","Dog","Cat"};
	static JComboBox methods = new JComboBox(task);

	public GUI(MethodContext ctx) {
		final JFrame frame = new JFrame();
		final JPanel cont = new JPanel();
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
			}
		});
		cont.add(start,BorderLayout.LINE_END);
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosen = methods.getSelectedItem().toString();
				isStarted = true;
				frame.dispose();
			}
		});
		frame.add(cont);
		frame.pack();
		
	}

}