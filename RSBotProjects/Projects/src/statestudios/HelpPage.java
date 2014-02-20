package statestudios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelpPage {
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static ArrayList<String> methods = new ArrayList<>();
	static String method;
	public static void init() {
		methods.add("None");
		methods.add("Dog");
		methods.add("Cat");
		frame.setSize(700,700);
		panel.setSize(700,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		final JComboBox mainMethod = new JComboBox(methods.toArray());
		final JComboBox secondary = new JComboBox(new String[] {"Hi"});
		secondary.setVisible(false);
		panel.add(mainMethod,BorderLayout.WEST);
		mainMethod.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				method = mainMethod.getSelectedItem().toString();
				if(method.equals("Dog")) {
					panel.add(secondary,BorderLayout.EAST);
					secondary.setVisible(true);
					panel.repaint();
					frame.repaint();
				}
				
			}
			
		});
		frame.add(panel);
		frame.setTitle("API Menu Helper");
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		init();
	}

}
