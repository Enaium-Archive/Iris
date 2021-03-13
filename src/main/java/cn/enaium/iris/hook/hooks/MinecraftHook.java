package cn.enaium.iris.hook.hooks;

import cn.enaium.iris.Iris;
import cn.enaium.iris.hook.Hook;
import cn.enaium.iris.utils.Mapping;
import cn.enaium.iris.utils.Reflection;
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
                        super.visitCode();
                    }

                    @Override
                    public void visitMethodInsn(int opcode, String owner, String name1, String desc1, boolean itf) {
                        if ((className + "." + name + desc).equals(Mapping.net_minecraft_client_Minecraft_setScreen_desc)) {
                            if (opcode == INVOKEVIRTUAL && (owner + "." + name1 + desc1).equals(Mapping.net_minecraft_client_Minecraft_updateTitleDesc)) {
//                                mv.visitVarInsn(ALOAD, 1);
//                                mv.visitMethodInsn(INVOKESTATIC, Type.getInternalName(MinecraftHook.class), "setScreen", "(Ljava/lang/Object;)V", false);
                            }
                        }
                        super.visitMethodInsn(opcode, owner, name1, desc1, itf);
                    }
                };
            }
        };
    }

    public static void setScreen(Object o) {
        try {
            if (o.getClass() == Class.forName("doy")) {
                Object minecraft = Reflection.getMethod(Mapping.net_minecraft_client_Minecraft_getInstance).invoke(null);
                Reflection.setValue(minecraft, Mapping.net_minecraft_client_Minecraft_screen, Class.forName("IrisScreen").newInstance());
                System.out.println(Reflection.<Object>getValue(minecraft, Mapping.net_minecraft_client_Minecraft_screen));
            }
        } catch (Exception ignored) {
        }
    }
}
