package resume.paintsoftware;

import java.awt.*;

/**
 * Created by WJ001 on 3/14/14.
 */
public enum Colors {
    BLACK(new Color(0,0,0)),
    WHITE(new Color(255,255,255)),
    GRAY(new Color(90,90,90)),
    RED_BROWN(new Color(102,0,0)),
    MEDIUM_BLUE(new Color(112,112,255)),
    ORANGE(new Color(255,128,0)),
    YELLOW_TINT(new Color(246,246,117)),
    VIOLET(new Color(238,130,238)),
    DARK_ORANGE(new Color(255,69,0)),
    PURPLE(new Color(170,0,255)),
    MEDIUM_BROWN(new Color(140,112,76)),
    BROWN(new Color(79,70,0));


    private Color color;

    Colors(Color color) {
        this.color = color;
    }
    public Color getColor() {
        return color;
    };
}
