package carLambo;

import java.security.SecureRandom;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;

public final class RandomUtil {
   private final char[] sdfsldf;
   private static String sabretb;
   private static String dfhttegd;
   private static String bsgshsbs;
   private final char[] gsbthstgb;
   private final Random sfsrgsbd;
   private static String fgsbsfgsb;

   private RandomUtil(int var1) {
      this(21, new SecureRandom());
   }

   private RandomUtil(int var1, Random var2) {
      this(var1, var2, sabretb);
   }

   public RandomUtil() {
      this(21);
   }

   private RandomUtil(int var1, Random var2, String var3) {
      if (var1 <= 0) {
         throw new IllegalArgumentException();
      } else if (var3.length() < 2) {
         throw new IllegalArgumentException();
      } else {
         this.sfsrgsbd = (Random)Objects.requireNonNull(var2);
         this.sdfsldf = var3.toCharArray();
         this.gsbthstgb = new char[var1];
      }
   }

   static {
      bsgshsbs = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase(Locale.ROOT);
      sabretb = (new StringBuilder()).insert(0, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").append(bsgshsbs).append("0123456789").toString();
   }

   private String sdfsldf() {
      int var1;
      for(int var10000 = var1 = 0; var10000 < this.gsbthstgb.length; var10000 = var1) {
         char[] var2 = this.gsbthstgb;
         int var10001 = var1;
         char var10002 = this.sdfsldf[this.sfsrgsbd.nextInt(this.sdfsldf.length)];
         ++var1;
         var2[var10001] = var10002;
      }

      return new String(this.gsbthstgb);
   }
}
