package cn.enaium.iris.client.modules.render;

import cn.enaium.cf4m.annotation.Event;
import cn.enaium.cf4m.annotation.module.Module;
import cn.enaium.cf4m.module.Category;
import cn.enaium.iris.client.Iris;
import cn.enaium.iris.client.events.Render2DEvent;
import cn.enaium.iris.client.utils.FontUtils;
import org.lwjgl.glfw.GLFW;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
@Module(value = "HUD", key = GLFW.GLFW_KEY_O, category = Category.RENDER)
public class HUD {
    @Event
    public void onRender(Render2DEvent event) {
        FontUtils.getInstance().drawShadow(event.getPoseStack(), Iris.INSTANCE.NAME, 0, 0, 0xFFFFFF);
    }
}
