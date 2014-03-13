package resume;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created by WJ001 on 3/12/14.
 */
public class Chooser {

    public Color col;

    public Chooser() {

    }

    public Color init() {
        final SharedVars vars = new SharedVars();
        final JFrame frame = new JFrame();
        final JPanel panel = new JPanel();
        frame.setSize(400,400);
        panel.setSize(400,400);
        panel.setLayout(new BorderLayout());
        final JColorChooser choice = new JColorChooser();
        panel.add(choice,BorderLayout.CENTER);
        frame.add(panel);
        frame.setVisible(true);
        choice.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                vars.chosen = choice.getColor();
            }
        });
        return vars.chosen;
    }

    public static void main(String[] args) {
        Chooser c = new Chooser();
        c.init();
    }
}
