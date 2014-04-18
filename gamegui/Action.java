package com.snoopdogg.gamegui;

/**
 * Created by WJ001 on 4/17/14.
 */
public enum Action {
    NONE(0),
    STOP(1),
    SUSPEND(2),
    START(3),
    UNIQUE(4);

    private Action action;
    private int id;

    Action(final int id) {
       this.action = action;
       this.id = id;
    }
    public Action getAction() {
        return this.action;
    }
    public int getId() {
        return this.id;
    }
}
