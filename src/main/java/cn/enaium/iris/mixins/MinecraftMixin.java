package cn.enaium.iris.mixins;

import cn.enaium.iris.client.Iris;
import cn.enaium.iris.client.utils.Mapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: Iris
 * Author: Enaium
 */
@Mixin(targets = Mapping.class_net_minecraft_client_Minecraft, remap = false)
public class MinecraftMixin {
    @Inject(at = @At("HEAD"), method = Mapping.method_net_minecraft_client_Minecraft_run, remap = false)
    public void run(CallbackInfo callbackInfo) {
        Iris.INSTANCE.run();
    }
}
