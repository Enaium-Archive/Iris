import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.annotation.Event;
import cn.enaium.iris.events.SetScreenEvent;
import cn.enaium.iris.utils.Mapping;
import cn.enaium.iris.utils.Reflection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class ScreenManager {
    private Object minecraft;

    public ScreenManager() {
        CF4M.INSTANCE.event.register(this);
        try {
            minecraft = Reflection.getMethod(Mapping.net_minecraft_client_Minecraft_getInstance).invoke(null);
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Event
    public void onSetScreen(SetScreenEvent setScreenEvent) {
        if (setScreenEvent.getScreen().getClass() == doy.class) {
            try {
                Reflection.getMethod(Mapping.net_minecraft_client_Minecraft_setScreen, dot.class).invoke(minecraft, new IrisScreen());
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
