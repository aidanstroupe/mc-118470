package snow.mc118470.platform.windows;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.COM.Unknown;
import com.sun.jna.platform.win32.WinDef.USHORT;
import com.sun.jna.platform.win32.WinNT.HRESULT;

import java.util.HashMap;
import java.util.Map;

public class SpVoice extends Unknown {
	private static final int IUNKNOWN_COUNT = 3;
	private static final int ISPNOTIFYSOURCE_COUNT = 7;
	private static final int ISPEVENTSOURCE_COUNT = 3;
	private static final int ISPVOICE_COUNT = 18;

	private static final Map<Pointer, SpVoice> INSTANCES = new HashMap<>();

	private SpVoice(Pointer pvInstance) {
		super(pvInstance);
	}

	public static SpVoice from(long handle) {
		final Pointer ptr = new Pointer(handle);
		return INSTANCES.computeIfAbsent(ptr, SpVoice::new);
	}

	public void setVolume(short volume) {
		int result = this._invokeNativeInt(
			(IUNKNOWN_COUNT + ISPNOTIFYSOURCE_COUNT + ISPEVENTSOURCE_COUNT + ISPVOICE_COUNT) - 1,
			new Object[]{this.getPointer(), new USHORT(volume)}
		);
		COMUtils.checkRC(new HRESULT(result));
	}
}