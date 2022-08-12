package carLambo;

import com.sun.jna.platform.win32.WinUser.LASTINPUTINFO;

public final class getDelayBetweenLastUserInput {
   private long sdfsldf = 0L;

   public final String lastUserInput() {
      LASTINPUTINFO var1 = new LASTINPUTINFO();
      com.sun.jna.platform.win32.User32.INSTANCE.GetLastInputInfo(var1);
      long var2 = System.currentTimeMillis();
      long var4 = this.sdfsldf + (long)var1.dwTime;
      long var6;
      if ((var6 = (var2 - var4) / 1000L) < 1L) {
         return "Not Idle";
      } else {
         String var17;
         if (var6 > 59L) {
            long var9 = var6 / 60L;
            long var11 = var6 % 60L;
            if (var9 > 59L) {
               long var13 = var9 / 60L;
               var9 %= 60L;
               if (var13 > 23L) {
                  long var15 = var13 / 24L;
                  var13 %= 24L;
                  var17 = String.valueOf(var15 + " day " + var13 + " hr " + var9 + " min " + var11 + " sec");
               } else {
                  var17 = String.valueOf(var13 + " hr " + var9 + " min " + var11 + " sec");
               }
            } else {
               var17 = String.valueOf(var9 + " min " + var11 + " sec");
            }
         } else {
            var17 = (new StringBuilder()).insert(0, String.valueOf(var6)).append(" Sec").toString();
         }

         return var17;
      }
   }

   // $FF: synthetic method
   private static String sdfsldf(long var0) {
      if ((var0 /= 1000L) < 1L) {
         return "Not Idle";
      } else {
         String var11;
         if (var0 > 59L) {
            long var3 = var0 / 60L;
            long var5 = var0 % 60L;
            if (var3 > 59L) {
               long var7 = var3 / 60L;
               var3 %= 60L;
               if (var7 > 23L) {
                  long var9 = var7 / 24L;
                  var7 %= 24L;
                  var11 = String.valueOf(var9 + " day " + var7 + " hr " + var3 + " min " + var5 + " sec");
               } else {
                  var11 = String.valueOf(var7 + " hr " + var3 + " min " + var5 + " sec");
               }
            } else {
               var11 = String.valueOf(var3 + " min " + var5 + " sec");
            }
         } else {
            var11 = (new StringBuilder()).insert(0, String.valueOf(var0)).append(" Sec").toString();
         }

         return var11;
      }
   }

   getDelayBetweenLastUserInput() {
      long var1 = System.currentTimeMillis();
      LASTINPUTINFO var3 = new LASTINPUTINFO();
      com.sun.jna.platform.win32.User32.INSTANCE.GetLastInputInfo(var3);
      this.sdfsldf = var1 - (long)var3.dwTime;
   }
}
