package cn.enaium.iris.client;

import cn.enaium.cf4m.CF4M;
import org.apache.commons.io.FileUtils;

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
        System.out.println("Iris Loading...");
        CF4M.INSTANCE.run(this);
        System.out.println("Iris Loaded...");
    }
}
