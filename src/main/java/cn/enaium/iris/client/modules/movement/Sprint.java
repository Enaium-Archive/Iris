package cn.enaium.iris.client.modules.movement;

import cn.enaium.cf4m.annotation.Event;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.iris.client.events.Events;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Module(value = "Sprint", key = GLFW.GLFW_KEY_V, type = "MOVEMENT")
public class Sprint {
    @Event
    public void onUpdate(Events.UpdateEvent event) {
        assert Minecraft.getInstance().player != null;
        Minecraft.getInstance().player.setSprinting(true);
    }
}
