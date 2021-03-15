package cn.enaium.iris.mixins;

import cn.enaium.cf4m.event.events.UpdateEvent;
import cn.enaium.iris.client.utils.Mapping;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: Iris
 * Author: Enaium
 */
@Mixin(targets = Mapping.class_net_minecraft_client_player_LocalPlayer, remap = false)
public class LocalPlayerMixin {
    @Inject(at = @At("HEAD"), method = Mapping.methodAndDescription_net_minecraft_client_player_LocalPlayer_tick, remap = false)
    public void run(CallbackInfo callbackInfo) {
        new UpdateEvent().call();
    }
}
