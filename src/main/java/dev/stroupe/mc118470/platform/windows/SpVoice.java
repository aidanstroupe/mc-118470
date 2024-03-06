package dev.stroupe.mc118470.platform.windows;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.WinDef.USHORT;
import com.sun.jna.platform.win32.WinNT.HRESULT;

import java.util.HashMap;
import java.util.Map;

public class SpVoice extends Unknown {
	private static final int IUNKNOWN_COUNT = 3;            // IUnknown
	private static final int ISPNOTIFYSOURCE_COUNT = 7;     // ISpNotifySource
	private static final int ISPEVENTSOURCE_COUNT = 3;      // ISpEventSource
	private static final int ISPVOICE_COUNT = 18;           // ISpVoice

	private static final Map<Pointer, SpVoice> INSTANCES = new HashMap<>();

	private SpVoice(Pointer pvInstance) {
		super(pvInstance);
	}

	// Create an SpVoice wrapper from a raw pointer (cached)
	public static SpVoice from(long handle) {
		final Pointer ptr = new Pointer(handle);
		return INSTANCES.computeIfAbsent(ptr, SpVoice::new);
	}

	// Invokes the corresponding vtable entry for the ISpVoice COM interface.
	// This involves finding the specific offset of the function by
	// counting all interfaces in the ISpVoice hierarchy.
	public void setVolume(short volume) {
		int result = this._invokeNativeInt(
			(IUNKNOWN_COUNT + ISPNOTIFYSOURCE_COUNT + ISPEVENTSOURCE_COUNT + ISPVOICE_COUNT) - 1,
			new Object[]{this.getPointer(), new USHORT(volume)}
		);
		COMUtils.checkRC(new HRESULT(result));
	}
}