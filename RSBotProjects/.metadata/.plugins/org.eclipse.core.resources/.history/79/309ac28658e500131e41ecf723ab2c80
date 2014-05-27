package com.snoopdogg.gamegui;

import org.powerbot.script.methods.MethodContext;

import java.awt.*;

public class Button implements Clicked {

    private final MethodContext ctx;
    private final Rectangle rect;
    private final Action action;

    public Button(final MethodContext ctx,final Rectangle rect,final Action action) {
        this.ctx = ctx;
        this.rect = rect;
        this.action = action;
    }

    @Override
    public boolean isClicked(Rectangle r) {
        return r.contains(ctx.mouse.getPressLocation());
    }

    public void perform() {
        switch(action.getId()) {
            case(0):
                break;
            case(1):
                ctx.getBot().stop();
                break;
            case(2):
                suspend(10000 /*can put any value in here, use scanner, etc... */);
                break;
            case(3):
                ctx.getBot().run();
                break;
            case(4):
                ///can put in unique method here
                break;
            default:
                break;
        }
    }

    public void suspend(final long millis) {
        long x = 0;
        ctx.getBot().stop();
        while(x < millis) {
            try {
                Thread.sleep(millis);
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            x += 1;
        }
    }

    public void resize(final Dimension d) {
        rect.setSize(d);
    }

    public void move() {
        rect.setLocation(ctx.mouse.getPressLocation());
    }
}
