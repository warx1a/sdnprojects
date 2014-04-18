package com.snoopdogg.gamegui;

import org.powerbot.event.PaintListener;
import org.powerbot.script.methods.MethodContext;

import java.awt.*;

/**
 * Created by WJ001 on 4/18/14.
 */
public class DropMenu implements Clicked {

    private String[] values;
    private Rectangle start_button;
    private Point start_location;
    private MethodContext ctx;

    public DropMenu(MethodContext ctx,Rectangle start_button,Point start_location,String... values) {
        this.values = values;
        this.ctx = ctx;
        this.start_button = start_button;
        this.start_location = start_location;
    }

    @Override
    public boolean isClicked(Rectangle r) {
        return r.contains(ctx.mouse.getPressLocation());
    }

    public void displayAll(Graphics g,Color bg,Color text) {
        int offset = 0;
        if(isClicked(start_button)) {
            g.setColor(bg);
            g.setFont(new Font("Times new roman",Font.BOLD,10));
            g.drawRect(start_location.x,start_location.y,25,(values.length * 10));
            g.setColor(text);
            for(String s:values) {
                g.drawString(s,start_location.x + offset,start_location.y);
                offset += 10;
            }
        }
    }

}
