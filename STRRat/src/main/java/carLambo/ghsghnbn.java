package carLambo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ghsghnbn {
   private OutputStream sdfsldf;
   private OutputStream sabretb;
   private boolean dfhttegd = true;
   private Socket bsgshsbs;
   private InputStream gsbthstgb;
   private InputStream sfsrgsbd;
   private Socket fgsbsfgsb;

   // $FF: synthetic method
   private void sdfsldf() {
      try {
         byte[] var2 = new byte[24576];

         while(this.dfhttegd) {
            int var1;
            if ((var1 = this.sfsrgsbd.read(var2, 0, 24576)) == -1) {
               this.sfsrgsbd.close();
               this.bsgshsbs.close();
               this.fgsbsfgsb.close();
               this.sdfsldf.close();
               return;
            }

            this.sdfsldf.write(var2, 0, var1);
            this.sdfsldf.flush();
         }
      } catch (Exception var4) {
         try {
            this.bsgshsbs.close();
            this.fgsbsfgsb.close();
            return;
         } catch (IOException var3) {
            Logger.getLogger(ghsghnbn.class.getName()).log(Level.SEVERE, (String)null, var3);
         }
      }

   }

   public final void sdfsldf(Socket var1, Socket var2) {
      try {
         this.bsgshsbs = var1;
         this.fgsbsfgsb = var2;
         this.gsbthstgb = var1.getInputStream();
         this.sdfsldf = var1.getOutputStream();
         this.sfsrgsbd = var2.getInputStream();
         this.sabretb = var2.getOutputStream();
         (new Thread(new ndgdfhfh(this))).start();
         (new Thread(new mdgghtdsh(this))).start();
      } catch (IOException var3) {
         this.dfhttegd = false;
      }
   }

   // $FF: synthetic method
   static void sdfsldf(ghsghnbn var0) {
      var0 = var0;

      try {
         byte[] var2 = new byte[24576];

         while(var0.dfhttegd) {
            int var1;
            if ((var1 = var0.gsbthstgb.read(var2, 0, 24576)) == -1) {
               var0.gsbthstgb.close();
               var0.bsgshsbs.close();
               var0.fgsbsfgsb.close();
               var0.sabretb.close();
               return;
            }

            var0.sabretb.write(var2, 0, var1);
            var0.sabretb.flush();
         }
      } catch (Exception var4) {
         try {
            var0.bsgshsbs.close();
            var0.fgsbsfgsb.close();
            return;
         } catch (IOException var3) {
            Logger.getLogger(ghsghnbn.class.getName()).log(Level.SEVERE, (String)null, var3);
         }
      }

   }

   // $FF: synthetic method
   static void sabretb(ghsghnbn var0) {
      var0 = var0;

      try {
         byte[] var2 = new byte[24576];

         while(var0.dfhttegd) {
            int var1;
            if ((var1 = var0.sfsrgsbd.read(var2, 0, 24576)) == -1) {
               var0.sfsrgsbd.close();
               var0.bsgshsbs.close();
               var0.fgsbsfgsb.close();
               var0.sdfsldf.close();
               return;
            }

            var0.sdfsldf.write(var2, 0, var1);
            var0.sdfsldf.flush();
         }
      } catch (Exception var4) {
         try {
            var0.bsgshsbs.close();
            var0.fgsbsfgsb.close();
            return;
         } catch (IOException var3) {
            Logger.getLogger(ghsghnbn.class.getName()).log(Level.SEVERE, (String)null, var3);
         }
      }

   }

   // $FF: synthetic method
   private void sabretb() {
      try {
         byte[] var2 = new byte[24576];

         while(this.dfhttegd) {
            int var1;
            if ((var1 = this.gsbthstgb.read(var2, 0, 24576)) == -1) {
               this.gsbthstgb.close();
               this.bsgshsbs.close();
               this.fgsbsfgsb.close();
               this.sabretb.close();
               return;
            }

            this.sabretb.write(var2, 0, var1);
            this.sabretb.flush();
         }
      } catch (Exception var4) {
         try {
            this.bsgshsbs.close();
            this.fgsbsfgsb.close();
            return;
         } catch (IOException var3) {
            Logger.getLogger(ghsghnbn.class.getName()).log(Level.SEVERE, (String)null, var3);
         }
      }

   }
}
