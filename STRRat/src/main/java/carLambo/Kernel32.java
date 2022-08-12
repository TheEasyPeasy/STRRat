package carLambo;

import com.sun.jna.platform.win32.WinNT.HANDLE;

public interface Kernel32 extends com.sun.jna.platform.win32.Kernel32 {
   boolean Wow64DisableWow64FsRedirection(HANDLE var1);

   boolean Wow64RevertWow64FsRedirection(HANDLE var1);
}
