package cn.enaium.iris.hook.hooks;

import cn.enaium.cf4m.event.events.UpdateEvent;
import cn.enaium.iris.hook.Hook;
import cn.enaium.iris.utils.Mapping;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import static org.objectweb.asm.Opcodes.*;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class LocalPlayer extends Hook {
    public LocalPlayer() {
        super(Mapping.net_minecraft_client_player_LocalPlayer);
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
                        if ((className + "." + name + desc).equals(Mapping.net_minecraft_client_player_LocalPlayer_tick_desc)) {
                            //new UpdateEvent
                            mv.visitTypeInsn(NEW, Type.getInternalName(UpdateEvent.class));
                            mv.visitInsn(DUP);

                            //new UpdateEvent()
                            mv.visitMethodInsn(INVOKESPECIAL, Type.getInternalName(UpdateEvent.class), "<init>", "()V", false);

                            //mew UpdateEvent().call();
                            mv.visitMethodInsn(INVOKEVIRTUAL, Type.getInternalName(UpdateEvent.class), "call", "()V", false);
                        }
                        super.visitCode();
                    }
                };
            }
        };
    }
}
