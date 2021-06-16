package cn.enaium.iris.client.events;

import com.mojang.blaze3d.vertex.PoseStack;

/**
 * @author Enaium
 */
public class Events {
    public static class Render2DEvent {

        private final PoseStack poseStack;

        public Render2DEvent(PoseStack poseStack) {
            this.poseStack = poseStack;
        }

        public PoseStack getPoseStack() {
            return poseStack;
        }
    }

    public static class KeyboardEvent {
        private final int key;

        public KeyboardEvent(int key) {
            this.key = key;
        }

        public int getKey() {
            return key;
        }
    }

    public static class UpdateEvent {

    }
}
