package statestudios;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPage {
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static ArrayList<String> methods = new ArrayList<>();
	private static BufferedImage img;
	public static void init() {
		methods.add("None");
		methods.add("Dog");
		methods.add("Cat");
		frame.setSize(700,700);
		panel.setSize(700,700);
		panel.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		try {
			img = ImageIO.read(new URL("https://pbs.twimg.com/profile_images/1331296249/state_studios.jpg"));
		}catch(MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel label = new JLabel(new ImageIcon(img));
		panel.add(label,BorderLayout.CENTER);
		frame.add(panel);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		init();
	}

}
