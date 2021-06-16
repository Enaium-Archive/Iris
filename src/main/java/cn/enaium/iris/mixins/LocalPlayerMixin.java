package cn.enaium.iris.mixins;

import cn.enaium.cf4m.CF4M;
import cn.enaium.iris.client.events.Events;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: Iris
 * Author: Enaium
 */
@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @Inject(at = @At("HEAD"), method = "tick()V")
    public void tick(CallbackInfo callbackInfo) {
        CF4M.EVENT.post(new Events.UpdateEvent());
    }

    @Inject(at = @At("HEAD"), method = "chat(Ljava/lang/String;)V", cancellable = true)
    public void chat(String chat, CallbackInfo callbackInfo) {
        if (CF4M.COMMAND.execCommand(chat)) {
            callbackInfo.cancel();
        }
    }
}
