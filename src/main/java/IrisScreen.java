import cn.enaium.iris.Iris;
import cn.enaium.iris.utils.FontUtils;
import org.lwjgl.opengl.GL11;

/**
 * Project: Iris
 * -----------------------------------------------------------
 * Copyright © 2020-2021 | Enaium | All rights reserved.
 */
public class IrisScreen extends Screen {
    public IrisScreen() {
        super(new oe(""));
    }

    @Override
    public void a(dfm dfm, int i, int i1, float v) {
        a(dfm);
        GL11.glScaled(10, 10, 10);
        FontUtils.getInstance().drawShadow(dfm, Iris.INSTANCE.NAME, 0, 0, 0xFFFFF);
        GL11.glScaled(0.5, 0.5, 0.5);
        super.a(dfm, i, i1, v);
    }
}
