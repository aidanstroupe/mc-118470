package dev.stroupe.mc118470.util;

import com.mojang.text2speech.Narrator;
import com.mojang.text2speech.NarratorWindows;
import dev.stroupe.mc118470.mixin.accessor.AccessorNarratorManager;
import dev.stroupe.mc118470.mixin.accessor.AccessorNarratorWindows;
import dev.stroupe.mc118470.platform.windows.SpVoice;
import net.minecraft.client.util.NarratorManager;

public final class NarratorUtils {
	private NarratorUtils() {}

	public static void setVolume(NarratorManager manager, float volume) {
		final Narrator narrator = ((AccessorNarratorManager) manager).getNarrator();

		// If this narrator is implemented on the Windows platform, extract the COM object pointer from it.
		// Then, cast the volume (0.0 to 1.0) to a short (0 to 100) for Windows' API.
		if (narrator instanceof NarratorWindows) {
			final long handle = AccessorNarratorWindows.getHandle();
			SpVoice.from(handle).setVolume((short)(volume * 100));
		}
	}
}
