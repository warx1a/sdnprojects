package resume;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class PaintSoftware {
    CreateColor c;
    private final SharedVars vars = new SharedVars();
	private final JFrame frame = new JFrame("SnoopDogg's Painter");
    private final JFrame toolbar_frame = new JFrame("Toolbar");
    private final JPanel toolbar_panel = new JPanel();
    private final JPanel panel = new JPanel();
    private final JComboBox<Integer> pointsize = new JComboBox<>(new Integer[] {0,1,2,3,4,5,6,7,8,9,10});
	private final JComboBox<String> colors = new JComboBox<>(new String[]{"Black","Red","Blue","Lime Green",
    "Cyan","Yellow","Pink","Brown","Forest Green"});
    private final JButton clear = new JButton("Clear");
    private final JButton createcolor = new JButton("Custom color");
    private final JButton toolbar = new JButton("Toolbar");
    private BufferedImage canvas = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);
    private final JLabel label = new JLabel(new ImageIcon(canvas));
    private boolean isFirst = true;
	
	public PaintSoftware() {
		frame.setSize(500,500);
        panel.setSize(500,500);
        toolbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paintComponent(new Point(0,0));
                isFirst = false;
                launchToolbar();
            }
        });
		frame.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                paintComponent(label.getMousePosition());

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }

        });
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(final MouseEvent arg0) {
				paintComponent(label.getMousePosition());
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
        panel.add(toolbar,BorderLayout.NORTH);
        panel.add(label,BorderLayout.CENTER);
		frame.add(panel);
		frame.setVisible(true);
	}

    public void launchToolbar() {
        toolbar_frame.setSize(300,300);
        toolbar_panel.setSize(300,300);
        toolbar_panel.setLayout(new BorderLayout());
        colors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                vars.picked = colors.getSelectedItem().toString();
                vars.chosen = getChosenColor();


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
                toolbar_frame.dispose();
                isFirst = true;
                pointsize.setSelectedItem(1);
                colors.setSelectedItem("Black");
                colors.removeItem("Custom");
                vars.chosen = Color.black;
                vars.picked = "Black";
                label.repaint();
            }
        });
        createcolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c = new CreateColor();
                colors.setSelectedItem("Black");
                colors.removeItem("Custom");
                colors.addItem("Custom");
            }
        });
        toolbar_frame.setLocationRelativeTo(frame);
        toolbar_panel.add(colors,BorderLayout.WEST);
        toolbar_panel.add(pointsize,BorderLayout.CENTER);
        toolbar_panel.add(clear,BorderLayout.NORTH);
        toolbar_panel.add(createcolor,BorderLayout.SOUTH);
        toolbar_frame.add(toolbar_panel);
        toolbar_frame.setVisible(true);
    }

    private void paintComponent(Point p) {
        final Graphics g = label.getGraphics();
        final Graphics2D panel_graphics = (Graphics2D) panel.getGraphics();
        final Graphics2D g1 = (Graphics2D)g;
        panel_graphics.setColor(vars.chosen);
        g1.setColor(vars.chosen);
        panel_graphics.drawString("Current color", 2, 460);
        panel_graphics.drawRect(0,442,75,25);
        if(isFirst) {
            g1.setColor(Color.white);
            g1.fillRect(0,0,label.getWidth(),label.getHeight());
        }
        if(vars.size == 0) {
            try {
                g1.drawLine(p.x, p.y, p.x, p.y);
            } catch(NullPointerException e) {
            }
        } else {
            try {
                g1.fillOval(p.x,p.y,vars.size,vars.size);
            } catch(NullPointerException e) {
            }
        }
    }

    private Color getChosenColor() {
        switch(vars.picked) {
            case("Black"): vars.chosen = Color.black;
                break;
            case("Red"): vars.chosen = Color.red;
                break;
            case("Blue"): vars.chosen = Color.blue;
                break;
            case("Lime Green"): vars.chosen = Color.green;
                break;
            case("Custom"): vars.chosen = c.getColor();
                break;
            case("Cyan"):vars.chosen = Color.cyan;
                break;
            case("Yellow"): vars.chosen = Color.yellow;
                break;
            case("Pink"):vars.chosen = Color.pink;
                break;
            case("Brown"):vars.chosen = new Color(175,117,89);
                break;
            case("Forest Green"): vars.chosen = new Color(0,150,0);
                break;
            default:
                vars.chosen = c.getColor();
                break;

        }
        return vars.chosen;
    }
	
	public static void main(String[] args) {
		new PaintSoftware();
	}
}

