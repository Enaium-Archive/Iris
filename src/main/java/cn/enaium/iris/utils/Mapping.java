package cn.enaium.iris.utils;

import org.objectweb.asm.Type;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class Mapping {
    public static String net_minecraft_client_Minecraft = "djz";
    public static String net_minecraft_client_Minecraft_getInstance = getName(net_minecraft_client_Minecraft, "C");
    public static String net_minecraft_client_Minecraft_getInstance_desc = getDesc(net_minecraft_client_Minecraft_getInstance, "()V");
    public static String net_minecraft_client_Minecraft_run = getName(net_minecraft_client_Minecraft, "e");
    public static String net_minecraft_client_Minecraft_run_desc = getDesc(net_minecraft_client_Minecraft_run, "()V");
    public static String net_minecraft_client_Minecraft_setScreen = getName(net_minecraft_client_Minecraft, "a");
    public static String net_minecraft_client_Minecraft_setScreen_desc = getDesc(net_minecraft_client_Minecraft_setScreen, "(Ldot;)V");
    public static String net_minecraft_client_Minecraft_updateTitle = getName(net_minecraft_client_Minecraft, "c");
    public static String net_minecraft_client_Minecraft_updateTitleDesc = getDesc(net_minecraft_client_Minecraft_updateTitle, "()V");
    public static String net_minecraft_client_Minecraft_player = getName(net_minecraft_client_Minecraft, "s");
    public static String net_minecraft_client_Minecraft_font = getName(net_minecraft_client_Minecraft, "g");
    public static String net_minecraft_client_Minecraft_screen = getName(net_minecraft_client_Minecraft, "y");
    public static String net_minecraft_client_player_LocalPlayer = "dzm";
    public static String net_minecraft_client_player_LocalPlayer_tick = getName(net_minecraft_client_player_LocalPlayer, "j");
    public static String net_minecraft_client_player_LocalPlayer_tick_desc = getDesc(net_minecraft_client_player_LocalPlayer_tick, "()V");
    public static String net_minecraft_client_player_LocalPlayer_setSprint = getName(net_minecraft_client_player_LocalPlayer, "g");
    public static String net_minecraft_client_player_LocalPlayer_setSprint_desc = getDesc(net_minecraft_client_player_LocalPlayer_setSprint, "(Z)V");
    public static String net_minecraft_client_KeyboardHandler = "djx";
    public static String net_minecraft_client_KeyboardHandler_keyPress = getName(net_minecraft_client_KeyboardHandler, "a");
    public static String net_minecraft_client_KeyboardHandler_keyPress_desc = getDesc(net_minecraft_client_KeyboardHandler_keyPress, "(JIIII)V");
    public static String net_minecraft_client_gui_Gui = "dkv";
    public static String net_minecraft_client_gui_Gui_render = getName(net_minecraft_client_gui_Gui, "a");
    public static String net_minecraft_client_gui_Gui_render_desc = getDesc(net_minecraft_client_gui_Gui_render, "(Ldfm;F)V");
    public static String com_mojang_blaze3d_vertex_PoseStack = "dfm";
    public static String net_minecraft_client_gui_Font = "dku";
    public static String net_minecraft_client_gui_Font_draw = getName(net_minecraft_client_gui_Font, "b");
    public static String net_minecraft_client_gui_Font_draw_desc = getDesc(net_minecraft_client_gui_Font_draw,
            "L" + com_mojang_blaze3d_vertex_PoseStack + ";" + Type.getDescriptor(String.class) + "FFI");
    public static String net_minecraft_client_gui_Font_drawShadow = getName(net_minecraft_client_gui_Font, "a");
    public static String net_minecraft_client_gui_Font_drawShadow_desc = getDesc(net_minecraft_client_gui_Font_drawShadow,
            "L" + com_mojang_blaze3d_vertex_PoseStack + ";" + Type.getDescriptor(String.class) + "FFI");


    private static String getName(String type, String name) {
        return type + "." + name;
    }

    private static String getDesc(String method, String desc) {
        return method + desc;
    }
}
