package cn.enaium.iris.mixins;

import cn.enaium.iris.client.Iris;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: Iris
 * Author: Enaium
 */
@Mixin(Minecraft.class)
public class MinecraftMixin {
    @Inject(at = @At("HEAD"), method = "run()V", remap = false)
    public void run(CallbackInfo callbackInfo) {
        Iris.INSTANCE.run();
    }
}
