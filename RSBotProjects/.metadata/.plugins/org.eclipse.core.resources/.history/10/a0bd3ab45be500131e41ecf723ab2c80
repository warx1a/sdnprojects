package resume;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Loading {
	private static void init() {
		JFrame.setDefaultLookAndFeelDecorated(false);
		final JFrame frame = new JFrame();
		final JPanel panel = new JPanel();
		final JComboBox<String> games = new JComboBox<>(new String[]{"Welcome","55x2","RockPaperScissors"});
		games.setSelectedItem("Welcome");
		panel.setLayout(new BorderLayout());
		panel.add(games,BorderLayout.WEST);
		frame.add(panel);
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	
	public static void main(String... args) {
		init();
	}

}
