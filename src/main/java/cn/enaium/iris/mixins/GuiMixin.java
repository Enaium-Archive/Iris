package cn.enaium.iris.mixins;

import cn.enaium.iris.client.utils.Mapping;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Project: Iris
 * Author: Enaium
 */
@Mixin(targets = Mapping.class_net_minecraft_client_gui_Gui, remap = false)
public class GuiMixin {
//    @Inject(at = @At("HEAD"), method = Mapping.methodAndDescription_net_minecraft_client_gui_Gui_render, remap = false)
//    public void render(Object poseStack, float f, CallbackInfo callbackInfo) {
//        new Render2DEvent(poseStack).call();
//    }
}
