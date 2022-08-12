package carLambo;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.HBITMAP;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.LRESULT;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinGDI.BITMAPINFO;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.win32.W32APIOptions;
import java.awt.AWTException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HBrowserNativeApis {
   private DWORD sdfsldf;
   private RobotImpl sabretb;

   public static boolean sdfsldf(HWND var0, HDC var1, int var2) {
      return User32.INSTANCE.PrintWindow(var0, var1, var2);
   }

   public static HANDLE sdfsldf(HDC var0, HANDLE var1) {
      return GDI32.INSTANCE.SelectObject(var0, var1);
   }

   public static LRESULT sdfsldf(HWND var0, int var1, WPARAM var2, LPARAM var3) {
      return User32.INSTANCE.SendMessage(var0, 16, var2, var3);
   }

   public static int GetWindowTextA(HWND var0, byte[] var1, int var2) {
      return ((User32)Native.loadLibrary(User32.class, W32APIOptions.DEFAULT_OPTIONS)).GetWindowTextA(var0, var1, 512);
   }

   public static void sdfsldf(byte var0, byte var1, int var2, int var3) {
      ((User32)Native.loadLibrary(User32.class, W32APIOptions.DEFAULT_OPTIONS)).keybd_event(var0, (byte)69, var2, 0);
   }

   public static HBITMAP sdfsldf(HDC var0, BITMAPINFO var1, int var2, PointerByReference var3, Pointer var4, int var5) {
      return GDI32.INSTANCE.CreateDIBSection(var0, var1, 0, var3, var4, 0);
   }

   public static HWND sabretb(String var0) {
      return User32.INSTANCE.FindWindow(var0, var0);
   }

   public static int sdfsldf(HWND var0, HDC var1) {
      return User32.INSTANCE.ReleaseDC(var0, var1);
   }

   public static boolean sdfsldf(HDC var0) {
      return GDI32.INSTANCE.DeleteDC(var0);
   }

   public static boolean sdfsldf(HWND var0, int var1) {
      return User32.INSTANCE.ShowWindow(var0, var1);
   }

   public static boolean sdfsldf(HWND var0, RECT var1) {
      return User32.INSTANCE.GetWindowRect(var0, var1);
   }

   public static boolean sdfsldf(HWND var0, HWND var1, int var2, int var3, int var4, int var5, int var6) {
      return User32.INSTANCE.SetWindowPos(var0, var1, 10000, 10000, var4, var5, 64);
   }

   public static boolean sdfsldf(HANDLE var0) {
      return GDI32.INSTANCE.DeleteObject(var0);
   }

   private static boolean sabretb(HWND var0, RECT var1) {
      return User32.INSTANCE.GetClientRect(var0, var1);
   }

   public static boolean sdfsldf(WNDENUMPROC var0, Pointer var1) {
      return User32.INSTANCE.EnumWindows(var0, (Pointer)null);
   }

   private static boolean sdfsldf(HDC var0, int var1, int var2, int var3, int var4, HDC var5, int var6, int var7, DWORD var8) {
      return ((GDI32)Native.loadLibrary(GDI32.class, W32APIOptions.DEFAULT_OPTIONS)).BitBlt(var0, var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public static void sabretb(HWND var0, int var1, WPARAM var2, LPARAM var3) {
      User32.INSTANCE.PostMessage(var0, var1, var2, var3);
   }

   public static HDC sdfsldf(HWND var0) {
      return User32.INSTANCE.GetDC(var0);
   }

   private static HBITMAP sdfsldf(HDC var0, int var1, int var2) {
      return GDI32.INSTANCE.CreateCompatibleBitmap(var0, var1, var2);
   }

   public static int sdfsldf(HWND var0, int var1, int var2) {
      return User32.INSTANCE.SetWindowLong(var0, -20, 128);
   }

   private static HDC sabretb(HWND var0) {
      return ((User32)Native.loadLibrary(User32.class, W32APIOptions.DEFAULT_OPTIONS)).GetWindowDC(var0);
   }

   HBrowserNativeApis() {
      DWORD var10000 = WinGDI.SRCCOPY;

      try {
         new RobotImpl();
      } catch (AWTException var2) {
         Logger.getLogger(HBrowserNativeApis.class.getName()).log(Level.SEVERE, (String)null, var2);
      }
   }

   private static int sdfsldf(HDC var0, HBITMAP var1, int var2, int var3, Pointer var4, BITMAPINFO var5, int var6) {
      return GDI32.INSTANCE.GetDIBits(var0, var1, var2, var3, var4, var5, var6);
   }

   public static HDC sabretb(HDC var0) {
      return GDI32.INSTANCE.CreateCompatibleDC(var0);
   }
}
