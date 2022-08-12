package carLambo;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;

final class AvailableBrowserSearch implements WNDENUMPROC {
   private int sdfsldf;
   // $FF: synthetic field
   private String sabretb;
   // $FF: synthetic field
   private BrowserManager dfhttegd;

   public final boolean callback(HWND var1, Pointer var2) {
      byte[] var3 = new byte[512];
      HBrowserNativeApis.GetWindowTextA(var1, (byte[])var3, 512);
      String var4;
      if ((var4 = Native.toString(var3)).isEmpty()) {
         return true;
      } else {
         if (var4.contains(this.sabretb) && this.dfhttegd.browserHwnd == null) {
            this.dfhttegd.browserHwnd = var1;
         }

         return true;
      }
   }

   AvailableBrowserSearch(BrowserManager var1, String var2) {
      this.dfhttegd = var1;
      this.sabretb = var2;
      
   }
}
