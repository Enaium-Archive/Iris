package cn.enaium.iris;

import cn.enaium.cf4m.CF4M;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public enum Iris {

    INSTANCE;

    public String NAME = Iris.class.getPackage().getImplementationTitle();
    public String VERSION = Iris.class.getPackage().getImplementationVersion();

    public void run() {
        CF4M.INSTANCE.run(this);
        try {
            Class.forName("ScreenManager").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
