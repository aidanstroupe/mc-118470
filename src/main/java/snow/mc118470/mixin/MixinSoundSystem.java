package snow.mc118470.mixin;

import net.minecraft.client.sound.SoundSystem;
import net.minecraft.client.util.NarratorManager;
import net.minecraft.sound.SoundCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import snow.mc118470.util.NarratorUtils;

@Mixin(SoundSystem.class)
public abstract class MixinSoundSystem {
	@Inject(
		method = "updateSoundVolume",
		at = @At(value = "FIELD", target = "Lnet/minecraft/sound/SoundCategory;MASTER:Lnet/minecraft/sound/SoundCategory;"),
		cancellable = true
	)
	private void updateNarratorVolume(SoundCategory category, float volume, CallbackInfo ci) {
		if (category == SoundCategory.VOICE) {
			NarratorUtils.setVolume(NarratorManager.INSTANCE, volume);
			ci.cancel();
		}
	}
}