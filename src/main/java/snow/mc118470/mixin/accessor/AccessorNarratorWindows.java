package snow.mc118470.mixin.accessor;

import com.mojang.text2speech.NarratorWindows;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(NarratorWindows.class)
public interface AccessorNarratorWindows {
	@Accessor("voice")
	static long getHandle() {
		throw new AssertionError();
	}
}