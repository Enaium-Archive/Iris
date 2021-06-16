package cn.enaium.iris.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.TextComponent;

/**
 * @author Enaium
 */
public class ChatUtil {
    public static void message(String message) {
        Minecraft.getInstance().gui.getChat().addMessage(new TextComponent(message));
    }
}
