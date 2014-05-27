package resume.paintsoftware;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Created by WJ001 on 3/11/14.
 */
public class SharedVars {
    public Color chosen;
    public String picked = "Black";
    public int size = 0;
    public BufferedImage canvas = new BufferedImage(400,400,BufferedImage.TYPE_INT_RGB);

    public SharedVars() {

    }
}
