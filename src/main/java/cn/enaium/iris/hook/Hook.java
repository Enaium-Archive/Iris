package cn.enaium.iris.hook;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public abstract class Hook {

    private final String name;

    protected Hook(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    protected abstract ClassVisitor hook(int api, ClassWriter classWriter);
}
