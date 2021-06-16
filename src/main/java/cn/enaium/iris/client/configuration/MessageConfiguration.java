package cn.enaium.iris.client.configuration;

import cn.enaium.cf4m.configuration.CommandConfiguration;
import cn.enaium.iris.client.util.ChatUtil;

/**
 * @author Enaium
 */
public class MessageConfiguration extends CommandConfiguration {
    @Override
    public void message(String message) {
        ChatUtil.message(message);
    }
}
