package resume;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by WJ001 on 3/11/14.
 */
public class LoadImage {
    String url;
    Image image;
    JLabel label;

    public LoadImage() {
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        final JButton from_file = new JButton("From file");
        final JButton from_url = new JButton("From url");
        final JTextField path = new JTextField();
        final JButton load_button = new JButton("Load");
        panel.setLayout(new BorderLayout());
        frame.setSize(300, 200);
        panel.setSize(300,200);
        path.setSize(200,100);
        load_button.setVisible(false);
        from_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                from_url.setVisible(false);
                path.setVisible(true);
                load_button.setVisible(true);
            }
        });
        from_url.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                from_url.setVisible(false);
                from_file.setVisible(false);
                path.setVisible(true);
                load_button.setVisible(true);
            }
        });
        load_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                url = path.getText();
                System.out.println(url);

            }
        });
        panel.add(from_file, BorderLayout.EAST);
        panel.add(from_url,BorderLayout.WEST);
        panel.add(path,BorderLayout.CENTER);
        panel.add(load_button,BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.add(panel);
    }

    public Image createImage(String url_path) {
        try {
            image = ImageIO.read(new URL(url_path));
        } catch(IOException e) {
            e.printStackTrace();
        }
        if(label != null) {
            return image;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        new LoadImage();
    }
}
