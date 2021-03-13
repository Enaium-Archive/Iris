package cn.enaium.iris.hook.hooks;

import cn.enaium.cf4m.CF4M;
import cn.enaium.iris.Iris;
import cn.enaium.iris.events.SetScreenEvent;
import cn.enaium.iris.hook.Hook;
import cn.enaium.iris.utils.Mapping;
import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class MinecraftHook extends Hook {
    public MinecraftHook() {
        super(Mapping.net_minecraft_client_Minecraft);
    }

    @Override
    public ClassVisitor hook(int api, ClassWriter classWriter) {
        return new ClassVisitor(api, classWriter) {

            private String className;

            @Override
            public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
                className = name;
                super.visit(version, access, name, signature, superName, interfaces);
            }

            @Override
            public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                return new MethodVisitor(api, super.visitMethod(access, name, desc, signature, exceptions)) {
                    @Override
                    public void visitCode() {
                        if ((className + "." + name + desc).equals(Mapping.net_minecraft_client_Minecraft_run_desc)) {
                            //Iris.INSTANCE
                            mv.visitFieldInsn(GETSTATIC, Type.getInternalName(Iris.class), "INSTANCE", Type.getDescriptor(Iris.class));

                            //Iris.INSTANCE.run()
                            mv.visitMethodInsn(INVOKEVIRTUAL, Type.getInternalName(Iris.class), "run", "()V", false);
                        }

                        if ((className + "." + name + desc).equals(Mapping.net_minecraft_client_Minecraft_setScreen_desc)) {
                            mv.visitVarInsn(ALOAD, 1);
                            mv.visitMethodInsn(INVOKESTATIC, Type.getInternalName(MinecraftHook.class), "setScreen", "(Ljava/lang/Object;)V", false);
                        }
                        super.visitCode();
                    }
                };
            }
        };
    }

    public static void setScreen(Object o) {
        if (CF4M.INSTANCE.event != null && o != null) {
            new SetScreenEvent(o).call();
        }
    }
}
