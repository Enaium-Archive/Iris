package cn.enaium.iris.launch;

import cn.enaium.iris.hook.HookManager;
import net.minecraft.launchwrapper.IClassTransformer;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class ClassTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        HookManager hookManager = new HookManager();
        return hookManager.hook(name, basicClass);
    }
}
