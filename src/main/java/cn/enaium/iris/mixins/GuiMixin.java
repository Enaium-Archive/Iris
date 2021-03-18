package cn.enaium.iris.mixins;

import cn.enaium.iris.client.events.Render2DEvent;
import cn.enaium.sma.apt.annotation.ReMap;
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
@ReMap("net.minecraft.client.gui.Gui")
@Mixin(Gui.class)
public class GuiMixin {
    @ReMap("render(Lcom/mojang/blaze3d/vertex/PoseStack;F)V")
    @Inject(at = @At("HEAD"), method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;F)V")
    public void render(PoseStack poseStack, float v, CallbackInfo ci) {
        new Render2DEvent(poseStack).call();
    }
}
