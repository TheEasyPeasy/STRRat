package carLambo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReverseProxyManager {
   private boolean dfhttegd = true;
   IAction action;
   String serverResponse;

   // $FF: synthetic method
   private static String sdfsldf(String var0) {
      String[] var1;
      String var2;
      if ((var2 = (var1 = var0.substring(0, var0.indexOf("\r\n")).split(" "))[1].substring(7)).contains("/")) {
         var2 = var2.substring(var2.indexOf("/"));
      } else {
         var2 = "/";
      }

      String var3 = (new StringBuilder()).insert(0, var1[0]).append(" ").append(var2).append(" ").append(var1[2]).toString();
      return (new StringBuilder()).insert(0, var3).append(var0.substring(var0.indexOf("\r\n"))).toString().replace("keep-alive", "Close").replace("Keep-alive", "Close").replace("Keep-Alive", "Close");
   }

   // $FF: synthetic method
   private String sdfsldf(InputStream var1) {
      byte[] var2 = new byte[1];
      StringBuilder var4 = new StringBuilder();

      while(this.dfhttegd) {
         int var3 = -1;
         try {
            if ((var3 = var1.read(var2, 0, 1)) == -1) {
               throw new RuntimeException();
            }
         } catch (IOException e) {
            e.printStackTrace();
         }


         var4.append(new String(var2, 0, var3));
         if (var4.toString().endsWith("\r\n\r\n")) {
            break;
         }
      }

      return var4.toString();
   }

   // $FF: synthetic method
   private void sdfsldf(Socket var1, IAction var2) {
      (new Thread(new ngdnbn(this, var1, var2))).start();
   }

   // $FF: synthetic method
   private static long sabretb(String var0) {
      if (var0.toLowerCase().contains("content-length")) {
         var0 = var0.substring(var0.toLowerCase().indexOf("content-length: ") + 16);
         return Long.parseLong(var0.substring(0, var0.indexOf("\r\n")));
      } else {
         return -1L;
      }
   }

   // $FF: synthetic method
   static void sdfsldf(ReverseProxyManager var0, Socket var1, IAction var2) {
      var1 = var1;
      var0 = var0;

      InputStream var4;
      byte[] var5;
      IAction var10000;
      String var23;
      try {
         var4 = var1.getInputStream();
         ReverseProxyManager var3 = var0;
         var5 = new byte[1];
         StringBuilder var7 = new StringBuilder();

         while(true) {
            if (var3.dfhttegd) {
               int var6;
               if ((var6 = var4.read(var5, 0, 1)) == -1) {
                  throw new RuntimeException();
               }

               var7.append(new String(var5, 0, var6));
               if (!var7.toString().endsWith("\r\n\r\n")) {
                  continue;
               }
            }

            var23 = var7.toString();
            break;
         }
      } catch (Exception var22) {
         label57: {
            try {
               var1.close();
            } catch (IOException var19) {
               Logger.getLogger(ReverseProxyManager.class.getName()).log(Level.SEVERE, (String)null, var19);
               var10000 = var2;
               break label57;
            }

            var10000 = var2;
         }

         var10000.start();
         return;
      }

      var2.start();
      String[] var25;
      if (bsgshsbs(var23).equals("CONNECT")) {
         var25 = dfhttegd(var23);

         try {
            Socket var27 = new Socket(var25[0], Integer.parseInt(var25[1]));
            String var29 = "HTTP/1.1 200 Connection Established\r\nConnection: Keep-Alive\r\n\r\n";
            OutputStream var34 = var1.getOutputStream();
            var34.write(var29.getBytes());
            var34.flush();
            (new ghsghnbn()).sdfsldf(var1, var27);
         } catch (Exception var18) {
            var2.start();

            try {
               var1.close();
            } catch (IOException var17) {
               Logger.getLogger(ReverseProxyManager.class.getName()).log(Level.SEVERE, (String)null, var17);
            }
         }
      } else {
         var25 = dfhttegd(var23);
         String var26 = sdfsldf(var23);

         try {
            Socket var28;
            Socket var32 = var28 = new Socket(var25[0], Integer.parseInt(var25[1]));
            OutputStream var30 = var32.getOutputStream();
            InputStream var8 = var32.getInputStream();
            var4 = var1.getInputStream();
            OutputStream var9 = var1.getOutputStream();
            var30.write(var26.getBytes());
            if (bsgshsbs(var23).equals("POST")) {
               long var13 = sabretb(var23);
               long var15 = 0L;
               var5 = new byte[8192];

               int var24;
               for(long var33 = 0L; var33 < var13; var33 = var15 += (long)var24) {
                  var24 = var4.read(var5, 0, 8192);
                  var30.write(var5, 0, var24);
                  var30.flush();
               }
            }

            byte[] var14 = new byte[24576];

            while(var0.dfhttegd) {
               int var31;
               if ((var31 = var8.read(var14, 0, 24576)) == -1) {
                  var8.close();
                  var1.close();
                  var4.close();
                  var28.close();
                  return;
               }

               var9.write(var14, 0, var31);
               var9.flush();
            }
         } catch (Exception var21) {
            label62: {
               try {
                  var1.close();
               } catch (IOException var20) {
                  Logger.getLogger(ReverseProxyManager.class.getName()).log(Level.SEVERE, (String)null, var20);
                  var10000 = var2;
                  break label62;
               }

               var10000 = var2;
            }

            var10000.start();
         }

      }
   }

   // $FF: synthetic method
   static void sabretb(ReverseProxyManager var0, Socket var1, IAction var2) {
      var0.sdfsldf(var1, var2);
   }

   // $FF: synthetic method
   private static String[] dfhttegd(String var0) {
      String[] var1 = (var0 = var0.substring(0, var0.indexOf("\r\n"))).split(" ");
      String[] var2 = new String[2];
      if (var0.toLowerCase().startsWith("connect")) {
         if (var1[1].contains(":")) {
            var0 = var1[1].substring(0, var1[1].indexOf(":"));
            String var3 = var1[1].substring(var1[1].indexOf(":") + 1);
            var2[0] = var0;
            var2[1] = var3;
            return var2;
         } else {
            var2[0] = var1[1];
            var2[1] = "443";
            return var2;
         }
      } else {
         if ((var0 = var1[1].substring(var1[1].indexOf("://") + 3)).contains("/")) {
            var0 = var0.substring(0, var0.indexOf("/"));
         }

         if (var0.contains(":")) {
            var2[0] = var0.substring(0, var0.indexOf(":"));
            var2[1] = var0.substring(var0.indexOf(":") + 1);
            return var2;
         } else {
            var2[0] = var0;
            var2[1] = "80";
            return var2;
         }
      }
   }

   ReverseProxyManager(String var1) {
      this.serverResponse = var1;

      try {
         Socket var5;
         OutputStream var2 = (var5 = new Socket(ConnectionUtil.socketAddress, ConnectionUtil.socketPort)).getOutputStream();
         String var3 = (new StringBuilder()).insert(0, "RProx:").append(this.serverResponse).toString();
         var2.write((var3.getBytes().length + "\r\n\r\n").getBytes());
         var2.write(var3.getBytes());
         var2.flush();
         this.action = new ReverseProxyConnector(this);
         this.sdfsldf(var5, this.action);
      } catch (Exception var4) {
         ;
      }
   }

   // $FF: synthetic method
   private static String bsgshsbs(String var0) {
      return var0.substring(0, var0.indexOf(" "));
   }

   // $FF: synthetic method
   private void sabretb(Socket var1, IAction var2) {
      String var3;
      IAction var10000;
      try {
         var3 = this.sdfsldf(var1.getInputStream());
      } catch (Exception var17) {
         label50: {
            try {
               var1.close();
            } catch (IOException var16) {
               Logger.getLogger(ReverseProxyManager.class.getName()).log(Level.SEVERE, (String)null, var16);
               var10000 = var2;
               break label50;
            }

            var10000 = var2;
         }

         var10000.start();
         return;
      }

      var2.start();
      String[] var4;
      if (bsgshsbs(var3).equals("CONNECT")) {
         var4 = dfhttegd(var3);

         try {
            Socket var23 = new Socket(var4[0], Integer.parseInt(var4[1]));
            String var24 = "HTTP/1.1 200 Connection Established\r\nConnection: Keep-Alive\r\n\r\n";
            OutputStream var28 = var1.getOutputStream();
            var28.write(var24.getBytes());
            var28.flush();
            (new ghsghnbn()).sdfsldf(var1, var23);
         } catch (Exception var15) {
            var2.start();

            try {
               var1.close();
            } catch (IOException var14) {
               Logger.getLogger(ReverseProxyManager.class.getName()).log(Level.SEVERE, (String)null, var14);
            }
         }
      } else {
         var4 = dfhttegd(var3);
         String var5 = sdfsldf(var3);

         try {
            Socket var6;
            Socket var26 = var6 = new Socket(var4[0], Integer.parseInt(var4[1]));
            OutputStream var7 = var26.getOutputStream();
            InputStream var8 = var26.getInputStream();
            InputStream var21 = var1.getInputStream();
            OutputStream var9 = var1.getOutputStream();
            var7.write(var5.getBytes());
            if (bsgshsbs(var3).equals("POST")) {
               long var10 = sabretb(var3);
               long var12 = 0L;
               byte[] var22 = new byte[8192];

               int var20;
               for(long var27 = 0L; var27 < var10; var27 = var12 += (long)var20) {
                  var20 = var21.read(var22, 0, 8192);
                  var7.write(var22, 0, var20);
                  var7.flush();
               }
            }

            byte[] var11 = new byte[24576];

            while(this.dfhttegd) {
               int var25;
               if ((var25 = var8.read(var11, 0, 24576)) == -1) {
                  var8.close();
                  var1.close();
                  var21.close();
                  var6.close();
                  return;
               }

               var9.write(var11, 0, var25);
               var9.flush();
            }
         } catch (Exception var19) {
            label56: {
               try {
                  var1.close();
               } catch (IOException var18) {
                  Logger.getLogger(ReverseProxyManager.class.getName()).log(Level.SEVERE, (String)null, var18);
                  var10000 = var2;
                  break label56;
               }

               var10000 = var2;
            }

            var10000.start();
         }

      }
   }
}
