package com.snoopdogg.grapher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.script.ScriptEngineManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;

public class Grapher {
	
	private static boolean graphit;
	
	private static String text;
	
	private static JTextField field;
	
	private ScriptEngineManager c;
	
	private ArrayList<Integer> x_list = new ArrayList<>();
	private ArrayList<Integer> y_list = new ArrayList<>();
	
	public Grapher() throws InterruptedException, UnknownFunctionException, UnparsableExpressionException {
		final JFrame frame = new JFrame();
		final JPanel panel = new JPanel();
		final JButton graph = new JButton("Graph");
		frame.setSize(500,500);
		
		field = new JTextField();
		field.setBounds(new Rectangle(0,0,25,100));
		graph.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				graphit = true;
				
			}
			
		});
		
		panel.setLayout(new BorderLayout());
		panel.add(field, BorderLayout.NORTH);
		panel.add(graph,BorderLayout.SOUTH);
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.GREEN);
		frame.setVisible(true);
		
		while(!graphit) {
			Thread.sleep(100);
		}
		text = field.getText();
		if(text.substring(0,2) == "y=") {
			text = text.substring(2);
		}
	}
	
	public static void main(String[] args) throws InterruptedException, UnknownFunctionException, UnparsableExpressionException {
		new Grapher();
		System.out.println(text);
	}

}
