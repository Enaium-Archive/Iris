package cn.enaium.iris.events;

import cn.enaium.cf4m.event.Listener;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class SetScreenEvent extends Listener {

    private final Object screen;

    public SetScreenEvent(Object screen) {
        super(At.NONE);
        this.screen = screen;
    }

    public Object getScreen() {
        return screen;
    }
}
