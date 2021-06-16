package cn.enaium.iris.client.commands;

import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.annotation.command.Command;
import cn.enaium.cf4m.annotation.command.Exec;
import cn.enaium.cf4m.annotation.command.Param;
import cn.enaium.cf4m.provider.ModuleProvider;
import cn.enaium.iris.client.util.ChatUtil;

/**
 * Project: Iris
 * Author: Enaium
 */
@Command({"e", "enable"})
public class EnableCommand {
    @Exec
    private void exec(@Param("module") String name) {
        ModuleProvider module = CF4M.MODULE.getByName(name);

        if (module == null) {
            ChatUtil.message("The module with the name " + name + " does not exist.");
            return;
        }

        module.enable();
    }
}

