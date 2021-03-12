package cn.enaium.iris.hook.hooks;

import cn.enaium.cf4m.event.events.KeyboardEvent;
import cn.enaium.iris.hook.Hook;
import cn.enaium.iris.utils.Mapping;
import org.lwjgl.glfw.GLFW;
import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class KeyboardHandlerHook extends Hook {
    public KeyboardHandlerHook() {
        super(Mapping.net_minecraft_client_KeyboardHandler);
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
                        if ((className + "." + name + desc).equals(Mapping.net_minecraft_client_KeyboardHandler_keyPress_desc)) {

//                            //new KeyboardEvent
//                            mv.visitTypeInsn(NEW, Type.getInternalName(KeyboardEvent.class));
//                            mv.visitInsn(DUP);
//
//                            mv.visitVarInsn(ILOAD, 3);//var3
//
//                            //KeyboardEvent(var3)
//                            mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(KeyboardEvent.class), "<init>", "(I)V", false);
//
//                            //KeyboardEvent(var3).call()
//                            mv.visitMethodInsn(INVOKEVIRTUAL, Type.getInternalName(KeyboardEvent.class), "call", "()V", false);

                            mv.visitVarInsn(ILOAD, 3);//var3
                            mv.visitVarInsn(ILOAD, 5);//var5
                            mv.visitMethodInsn(INVOKESTATIC, Type.getInternalName(KeyboardHandlerHook.class), "onKey", "(II)V", false);
                        }
                        super.visitCode();
                    }
                };
            }
        };
    }

    public static void onKey(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            new KeyboardEvent(key).call();
        }
    }
}
