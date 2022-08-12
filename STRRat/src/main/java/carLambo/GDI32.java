package carLambo;

import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HDC;

public interface GDI32 extends com.sun.jna.platform.win32.GDI32 {
   boolean BitBlt(HDC var1, int var2, int var3, int var4, int var5, HDC var6, int var7, int var8, DWORD var9);
}
