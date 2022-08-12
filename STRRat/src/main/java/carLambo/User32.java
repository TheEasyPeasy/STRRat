package carLambo;

import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HWND;

public interface User32 extends com.sun.jna.platform.win32.User32 {
   void keybd_event(byte var1, byte var2, int var3, int var4);

   int GetWindowTextA(HWND var1, byte[] var2, int var3);

   HDC GetWindowDC(HWND var1);
}
