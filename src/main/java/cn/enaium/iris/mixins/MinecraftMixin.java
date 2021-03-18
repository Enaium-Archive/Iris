package cn.enaium.iris.mixins;

import cn.enaium.iris.client.Iris;
import cn.enaium.sma.apt.annotation.ReMap;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: Iris
 * Author: Enaium
 */
@ReMap("net.minecraft.client.Minecraft")
@Mixin(Minecraft.class)
public class MinecraftMixin {
    @ReMap("run()V")
    @Inject(at = @At("HEAD"), method = "run()V")
    public void run(CallbackInfo callbackInfo) {
        Iris.INSTANCE.run();
    }
}
