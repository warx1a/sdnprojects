package resume;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class PaintSoftware {
	private final static Color[] str = new Color[]{Color.red,Color.green,Color.blue};
	private final static JFrame frame = new JFrame("SnoopDogg's Painter");
	private final static JPanel panel = new JPanel();
	private final static JComboBox<Color> colors = new JComboBox<>(str);
	private static Color chosen = new Color(0,0,0);
	
	public static void init() {
		final Graphics g = frame.getGraphics();
		frame.setSize(500,500);
		colors.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                Color chosen = (Color)colors.getSelectedItem();
                System.out.println(chosen);
					
				
			}
			
		});
		frame.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				final Point x = e.getPoint();
				g.setColor(chosen);
				g.drawLine(x.x, x.y, x.x, x.y);
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				final Point click = arg0.getPoint();
				g.setColor(chosen);
				g.drawLine(click.x, click.y, click.x, click.y);	
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(colors);
		frame.add(panel);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		init();
	}
}

