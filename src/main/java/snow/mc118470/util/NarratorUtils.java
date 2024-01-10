package snow.mc118470.util;

import com.mojang.text2speech.Narrator;
import com.mojang.text2speech.NarratorWindows;
import net.minecraft.client.util.NarratorManager;
import snow.mc118470.mixin.accessor.AccessorNarratorManager;
import snow.mc118470.mixin.accessor.AccessorNarratorWindows;
import snow.mc118470.platform.windows.SpVoice;

public final class NarratorUtils {
	private NarratorUtils() {}

	public static void setVolume(NarratorManager manager, float volume) {
		final Narrator narrator = ((AccessorNarratorManager) manager).getNarrator();
		if (narrator instanceof NarratorWindows) {
			final long handle = AccessorNarratorWindows.getHandle();
			SpVoice.from(handle).setVolume((short)(volume * 100));
		}
	}
}
