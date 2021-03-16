package cn.enaium.iris.client.events;

import cn.enaium.cf4m.event.Listener;
import com.mojang.blaze3d.vertex.PoseStack;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class Render2DEvent extends Listener {

    private final PoseStack poseStack;

    public Render2DEvent(PoseStack poseStack) {
        super(At.NONE);
        this.poseStack = poseStack;
    }

    public PoseStack getPoseStack() {
        return poseStack;
    }
}
