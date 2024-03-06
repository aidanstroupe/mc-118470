package dev.stroupe.mc118470.mixin.accessor;

import com.mojang.text2speech.Narrator;
import net.minecraft.client.util.NarratorManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(NarratorManager.class)
public interface AccessorNarratorManager {
	@Accessor("narrator")
	Narrator getNarrator();
}