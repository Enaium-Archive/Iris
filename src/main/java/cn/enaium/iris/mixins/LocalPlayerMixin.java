package cn.enaium.iris.mixins;

import cn.enaium.cf4m.CF4M;
import cn.enaium.cf4m.event.events.UpdateEvent;
import cn.enaium.sma.apt.annotation.ReMap;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: Iris
 * Author: Enaium
 */
@ReMap("net.minecraft.client.player.LocalPlayer")
@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {
    @ReMap("tick()V")
    @Inject(at = @At("HEAD"), method = "tick()V")
    public void tick(CallbackInfo callbackInfo) {
        new UpdateEvent().call();
    }

    @ReMap("chat(Ljava/lang/String;)V")
    @Inject(at = @At("HEAD"), method = "chat(Ljava/lang/String;)V", cancellable = true)
    public void chat(String chat, CallbackInfo callbackInfo) {
        if (CF4M.INSTANCE.command.isCommand(chat)) {
            callbackInfo.cancel();
        }
    }
}
