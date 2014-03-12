package resume;

import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class PaintSoftware {
    private final SharedVars vars = new SharedVars();
	private final JFrame frame = new JFrame("SnoopDogg's Painter");
    private final JPanel panel = new JPanel();
    private final JPanel loadingpanel = new JPanel();
    private final JComboBox<Integer> pointsize = new JComboBox<>(new Integer[] {0,1,2,3,4,5});
	private final JComboBox<String> colors = new JComboBox<>(new String[]{"Black","Red","Blue","Green"});
    private final JButton clear = new JButton("Clear");
    private final JButton createcolor = new JButton("Custom color");
    private Point click;
	
	public PaintSoftware() {
		frame.setSize(500,500);
        panel.setSize(500,500);
		colors.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
                vars.picked = colors.getSelectedItem().toString();
                getChosenColor();
					
				
			}
			
		});
        pointsize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vars.size = (int)pointsize.getSelectedItem();
            }
        });
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        createcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CreateColor();
            }
        });
		frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                paintComponent(panel.getMousePosition());

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub

            }

        });
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				paintComponent(panel.getMousePosition());
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
		panel.add(colors,BorderLayout.WEST);
        panel.add(pointsize,BorderLayout.EAST);
        panel.add(clear,BorderLayout.SOUTH);
        panel.add(createcolor,BorderLayout.EAST);
		frame.add(panel);
		frame.setVisible(true);
	}

    private void paintComponent(Point p) {
        final Graphics g = panel.getGraphics();
        final Graphics2D g1 = (Graphics2D)g;
        g1.setColor(vars.chosen);
        if(vars.size == 0) {
            g1.drawLine(p.x,p.y,p.x,p.y);
        } else {
            g1.drawOval(p.x,p.y,vars.size,vars.size);
        }
    }

    private Color getChosenColor() {
        switch(vars.picked) {
            case("Red"): vars.chosen = Color.red;
                break;
            case("Blue"): vars.chosen = Color.blue;
                break;
            case("Green"): vars.chosen = Color.green;
                break;
            default:
                vars.chosen = Color.black;
                break;

        }
        return vars.chosen;
    }
	
	public static void main(String[] args) {
		new PaintSoftware();
	}
}

