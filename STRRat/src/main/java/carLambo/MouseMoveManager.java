package carLambo;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MouseMoveManager {
   private Pattern sdfsldf;
   private Pattern sabretb;
   private Map dfhttegd;

   // $FF: synthetic method
   static void startResetMovingMouse(MouseMoveManager var0) {
      try {
         Robot var3 = new Robot();
         System.out.println("Worker started!!!");

         while(true) {
            Point var1 = MouseInfo.getPointerInfo().getLocation();
            var3.mouseMove(var1.x, var1.y);
            System.out.println("Mouse Moved!!");
            Thread.sleep(300000L);
         }
      } catch (Exception var2) {
         ;
      }
   }

   MouseMoveManager() {
      (new Thread(new MouseMoveThread(this))).start();
   }

   // $FF: synthetic method
   private static void sabretb() {
      try {
         Robot var0 = new Robot();
         System.out.println("Worker started!!!");

         while(true) {
            Point var1 = MouseInfo.getPointerInfo().getLocation();
            var0.mouseMove(var1.x, var1.y);
            System.out.println("Mouse Moved!!");
            Thread.sleep(300000L);
         }
      } catch (Exception var2) {
         ;
      }
   }

   public MouseMoveManager(String var1) {
      this.sabretb = Pattern.compile("\\s*\\[([^]]*)\\]\\s*");
      this.sdfsldf = Pattern.compile("\\s*([^=]*)=(.*)");
      this.dfhttegd = new HashMap();
      this.sdfsldf(var1);
   }

   public int sdfsldf(String var1, String var2, int var3) {
      Map var4;
      return (var4 = (Map)this.dfhttegd.get(var1)) == null ? var3 : Integer.parseInt((String)var4.get(var2));
   }

   public void sdfsldf(String var1) {
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

   public float sdfsldf(String var1, String var2, float var3) {
      Map var4;
      return (var4 = (Map)this.dfhttegd.get(var1)) == null ? var3 : Float.parseFloat((String)var4.get(var2));
   }

   public String sdfsldf(String var1, String var2, String var3) {
      Map var4;
      return (var4 = (Map)this.dfhttegd.get(var1)) == null ? null : (String)var4.get(var2);
   }

   public List sdfsldf() {
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

   public double sdfsldf(String var1, String var2, double var3) {
      Map var5;
      return (var5 = (Map)this.dfhttegd.get(var1)) == null ? var3 : Double.parseDouble((String)var5.get(var2));
   }
}
