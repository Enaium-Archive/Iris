package cn.enaium.iris.client.utils;

import java.lang.reflect.InvocationTargetException;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class FontUtils {

    private Object font;

    public FontUtils() {
        try {
            Object minecraft = Reflection.getMethod(Mapping.class_net_minecraft_client_Minecraft, Mapping.method_net_minecraft_client_Minecraft_getInstance).invoke(null);
            font = Reflection.getValue(minecraft, Mapping.field_net_minecraft_client_Minecraft_font);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Object poseStack, String text, float x, float y, int color) {
        try {
            Reflection.getMethod(Mapping.net_minecraft_client_gui_Font, Mapping.method_net_minecraft_client_gui_Font_draw,
                    Class.forName(Mapping.class_com_mojang_blaze3d_vertex_PoseStack), String.class, float.class, float.class, int.class).
                    invoke(font, poseStack, text, x, y, color);
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void drawShadow(Object poseStack, String text, float x, float y, int color) {
        try {
            Reflection.getMethod(Mapping.net_minecraft_client_gui_Font, Mapping.method_net_minecraft_client_gui_Font_drawShadow,
                    Class.forName(Mapping.class_com_mojang_blaze3d_vertex_PoseStack), String.class, float.class, float.class, int.class).
                    invoke(font, poseStack, text, x, y, color);
        } catch (IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    public static FontUtils getInstance() {
        return new FontUtils();
    }
}
