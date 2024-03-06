package dev.stroupe.mc118470.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import dev.stroupe.mc118470.util.NarratorUtils;

@Mixin(NarratorManager.class)
public abstract class MixinNarratorManager {
	// Set the narrator's volume when the narrator manager is created.
	@Inject(method = "<init>", at = @At("TAIL"))
	private void loadVolume(CallbackInfo ci) {
		NarratorUtils.setVolume(
			(NarratorManager)(Object)this,
			MinecraftClient
				.getInstance()
				.options.getSoundVolume(SoundCategory.VOICE)
		);
	}
}