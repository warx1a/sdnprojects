package blackjack;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.snoopdogg.util.Card;
import com.snoopdogg.util.ImageSizer;

public class Cards {
	public final static ArrayList<Integer> cards = new ArrayList<Integer>();
	public static BufferedImage card;
	public static BufferedImage card2;
	
	public static void init() throws MalformedURLException, IOException {
		final JFrame frame = new JFrame();
		final JPanel panel = new JPanel();
		frame.setSize(800,800);
		frame.setResizable(false);
		panel.setSize(800,800);
		panel.setBackground(ImageSizer.PLAYINGCOLOR);
		panel.setLayout(null);
		
		final Insets i = panel.getInsets();
		
		card = ImageIO.read(new URL(Card.ACE.getClubs()));
		card2 = ImageIO.read(new URL(Card.ACE.getDiamonds()));
		
		JLabel label = new JLabel(new ImageIcon(card));
		label.setSize(card.getHeight(),card.getWidth());
		
		JLabel label2 = new JLabel(new ImageIcon(card2));
		label2.setSize(card.getHeight(),card.getWidth());
		
		final Dimension d = label.getPreferredSize();
		
		System.out.println(d);
		
		label.setBounds(i.left + 50, i.top +100, d.height,d.width + 50);
		label2.setBounds(i.left + 50, i.top + 175, d.height, d.width + 50);
		System.out.println(label.getBounds());
		panel.add(label2);
		panel.add(label);
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws IOException {
		init();
	}

}
