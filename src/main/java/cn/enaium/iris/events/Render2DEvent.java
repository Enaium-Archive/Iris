package cn.enaium.iris.events;

import cn.enaium.cf4m.event.Listener;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class Render2DEvent extends Listener {

    private final Object poseStack;

    public Render2DEvent(Object poseStack) {
        super(At.NONE);
        this.poseStack = poseStack;
    }

    public Object getPoseStack() {
        return poseStack;
    }
}
