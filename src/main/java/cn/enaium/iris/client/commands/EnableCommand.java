package cn.enaium.iris.client.commands;

import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.annotation.command.Command;
import cn.enaium.cf4m.annotation.command.Exec;
import cn.enaium.cf4m.annotation.command.Param;

/**
 * Project: Iris
 * Author: Enaium
 */
@Command({"e", "enable"})
public class EnableCommand {
    @Exec
    private void exec(@Param("module") String name) {
        Object module = CF4M.INSTANCE.module.getModule(name);

        if (module == null) {
            CF4M.INSTANCE.configuration.message("The module with the name " + name + " does not exist.");
        }

        CF4M.INSTANCE.module.enable(module);
    }
}

