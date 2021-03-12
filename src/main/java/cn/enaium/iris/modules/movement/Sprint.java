package cn.enaium.iris.modules.movement;

import cn.enaium.cf4m.annotation.Event;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.cf4m.event.events.UpdateEvent;
import cn.enaium.cf4m.module.Category;
import cn.enaium.iris.utils.Mapping;
import cn.enaium.iris.utils.Reflection;
import org.lwjgl.glfw.GLFW;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Module(value = "Sprint", key = GLFW.GLFW_KEY_V, category = Category.MOVEMENT)
public class Sprint {
    @Event
    public void onUpdate(UpdateEvent event) throws Exception {
        Object minecraft = Reflection.getMethod(Mapping.net_minecraft_client_Minecraft_getInstance).invoke(null);
        Object player = Reflection.getValue(minecraft, Mapping.net_minecraft_client_Minecraft_player);
        Reflection.getMethod(Mapping.net_minecraft_client_player_LocalPlayer_setSprint, boolean.class).invoke(player, true);
    }
}
