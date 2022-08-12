package carLambo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class shshnfdn {
   private Pattern sdfsldf = Pattern.compile("\\s*([^=]*)=(.*)");
   private Pattern sabretb = Pattern.compile("\\s*\\[([^]]*)\\]\\s*");
   private Map dfhttegd = new HashMap();

   public shshnfdn(String var1) {
      this.sdfsldf(var1);
   }

   public final int sdfsldf(String var1, String var2, int var3) {
      Map var4;
      return (var4 = (Map)this.dfhttegd.get(var1)) == null ? var3 : Integer.parseInt((String)var4.get(var2));
   }

   public final void sdfsldf(String var1) {
      try {
         BufferedReader var6 = new BufferedReader(new FileReader(var1));
         String var3 = null;

         String var2;
         while((var2 = var6.readLine()) != null) {
            Matcher var4;
            if ((var4 = this.sabretb.matcher(var2)).matches()) {
               var3 = var4.group(1).trim();
            } else if (var3 != null && (var4 = this.sdfsldf.matcher(var2)).matches()) {
               var2 = var4.group(1).trim();
               String var7 = var4.group(2).trim();
               Object var5;
               if ((var5 = (Map)this.dfhttegd.get(var3)) == null) {
                  this.dfhttegd.put(var3, var5 = new HashMap());
               }

               ((Map)var5).put(var2, var7);
            }
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public final float sdfsldf(String var1, String var2, float var3) {
      Map var4;
      return (var4 = (Map)this.dfhttegd.get(var1)) == null ? var3 : Float.parseFloat((String)var4.get(var2));
   }

   public final String sdfsldf(String var1, String var2, String var3) {
      Map var4;
      return (var4 = (Map)this.dfhttegd.get(var1)) == null ? null : (String)var4.get(var2);
   }

   public final List sdfsldf() {
      ArrayList var1 = new ArrayList();
      Iterator var2;
      Iterator var10000 = var2 = this.dfhttegd.keySet().iterator();

      while(var10000.hasNext()) {
         String var3 = (String)var2.next();
         var10000 = var2;
         var1.add(var3);
      }

      return var1;
   }

   public final double sdfsldf(String var1, String var2, double var3) {
      Map var5;
      return (var5 = (Map)this.dfhttegd.get(var1)) == null ? var3 : Double.parseDouble((String)var5.get(var2));
   }
}
