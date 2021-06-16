package cn.enaium.iris.mixins;

import cn.enaium.cf4m.CF4M;
import cn.enaium.iris.client.events.Events;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: Iris
 * Author: Enaium
 */
@Mixin(Gui.class)
public class GuiMixin {
    @Inject(at = @At("HEAD"), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;F)V")
    public void render(PoseStack poseStack, float v, CallbackInfo ci) {
        CF4M.EVENT.post(new Events.Render2DEvent(poseStack));
    }
}
