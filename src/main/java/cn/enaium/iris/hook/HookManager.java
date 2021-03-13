package cn.enaium.iris.hook;

import cn.enaium.iris.hook.hooks.GuiHook;
import cn.enaium.iris.hook.hooks.KeyboardHandlerHook;
import cn.enaium.iris.hook.hooks.LocalPlayer;
import cn.enaium.iris.hook.hooks.MinecraftHook;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.util.ArrayList;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class HookManager {
    private ArrayList<Hook> hooks;

    public HookManager() {
        hooks = new ArrayList<>();
        hooks.add(new MinecraftHook());
        hooks.add(new LocalPlayer());
        hooks.add(new KeyboardHandlerHook());
        hooks.add(new GuiHook());
    }

    public byte[] hook(String name, byte[] basicClass) {
        for (Hook hook : hooks) {
            if (hook.getName().equals(name)) {
                ClassReader classReader = new ClassReader(basicClass);
                ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
                classReader.accept(hook.hook(ASM5, classWriter), 0);
                return classWriter.toByteArray();
            }
        }
        return basicClass;
    }
}
