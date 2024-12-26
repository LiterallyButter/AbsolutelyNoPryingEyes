package me.daxanius.npe.mixins.server;

import com.mojang.authlib.GameProfile;
import me.daxanius.npe.NoPryingEyes;
import me.daxanius.npe.config.NoPryingEyesConfig;
import net.minecraft.server.filter.FilteredMessage;
import net.minecraft.server.filter.V0TextFilterer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.Executor;

@Mixin(V0TextFilterer.class)
public class TextFiltererMixin2 {

    /**
     * @reason Makes the MessageFilterer class pass everything as filtered
     * so that profanity is allowed
     * @author Daxanius
     */

    @Inject(at = @At("HEAD"), method = "filterMessage(Lcom/mojang/authlib/GameProfile;Ljava/lang/String;Lnet/minecraft/server/filter/TextFilterer$HashIgnorer;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;", cancellable = true)
    private void filterMessage(GameProfile gameProfile, String message, V0TextFilterer.HashIgnorer ignorer, Executor executor, CallbackInfoReturnable<FilteredMessage> info) {
        NoPryingEyes.LogVerbose("Message queued to be checked for profanity");

        if (NoPryingEyesConfig.getInstance().disable_profanity_filter) {
            NoPryingEyes.LogVerbose("Passing message as permitted");

            info.setReturnValue(FilteredMessage.permitted(message));
            return;
        }

        NoPryingEyes.LogVerbose("Checking for profanity");
    }
}
