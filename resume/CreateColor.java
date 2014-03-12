package resume;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateColor {

    private final SharedVars vars = new SharedVars();

    final JFrame frame = new JFrame();
    final JPanel panel = new JPanel();
    final JTextField help = new JTextField("In order of red,green,blue");
    final JTextField red = new JTextField(7);
    final JTextField green = new JTextField(7);
    final JTextField blue = new JTextField(7);
    final JButton done = new JButton("Done");

    public CreateColor() {
        frame.setSize(300,200);
        panel.setSize(300,200);
        panel.setLayout(new BorderLayout());
        help.setEditable(false);
        panel.add(help,BorderLayout.NORTH);
        panel.add(red, BorderLayout.WEST);
        panel.add(green,BorderLayout.CENTER);
        panel.add(blue,BorderLayout.EAST);
        panel.add(done,BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(getColor() != null) {
                    vars.chosen = getColor();
                }
            }
        });
    }

    public Color getColor() {
        try {
            return new Color(Integer.parseInt(red.getText()),Integer.parseInt(green.getText()),Integer.parseInt(blue.getText()));
        } catch(NumberFormatException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        new CreateColor();
    }
}
