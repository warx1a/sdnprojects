package resume.paintsoftware;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoadImage {

    public String url;
    public boolean isDone = false;
    private final SharedVars vars = new SharedVars();
    private final PaintSoftware software = new PaintSoftware();

    public LoadImage() {

    }
    public void init() {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        final JTextField field = new JTextField(20);
        final JButton done = new JButton("Load");
        frame.setSize(new Dimension(300,200));
        panel.setSize(frame.getSize());
        panel.setLayout(new BorderLayout());
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                url = field.getText();
                isDone = true;
            }
        });
        panel.add(field, BorderLayout.CENTER);
        panel.add(done,BorderLayout.SOUTH);
        frame.add(panel);
        frame.setVisible(true);
    }

    public BufferedImage load() {
        try {
            vars.canvas = ImageIO.read(new URL(url));
        }catch(IOException e) {

        }
        return vars.canvas;
    }
}
