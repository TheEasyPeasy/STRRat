package carLambo;

import java.awt.*;
import java.awt.event.KeyEvent;

public final class RobotImpl extends Robot {

   public RobotImpl() throws AWTException {
   }

   public final void sdfsldf(String var1) {
      String[] var7;
      int var2 = (var7 = var1.split("\\+")).length;

      int var3;
      for(int var10000 = var3 = 0; var10000 < var2; var10000 = var3) {
         String var4 = var7[var3];

         try {
            System.out.println(var4);
            this.keyPress(KeyEvent.class.getField((new StringBuilder()).insert(0, "VK_").append(var4.toUpperCase()).toString()).getInt((Object)null));
         } catch (IllegalAccessException var5) {
            var5.printStackTrace();
         } catch (NoSuchFieldException var6) {
            throw new IllegalArgumentException((new StringBuilder()).insert(0, var4.toUpperCase()).append(" is invalid key\n").append("VK_").append(var4.toUpperCase()).append(" is not defined in java.awt.event.KeyEvent").toString());
         }

         ++var3;
      }

   }

   public final void sabretb(String var1) {
      String[] var7;
      int var2 = (var7 = var1.split("\\+")).length;

      int var3;
      for(int var10000 = var3 = 0; var10000 < var2; var10000 = var3) {
         String var4 = var7[var3];

         try {
            this.keyRelease(KeyEvent.class.getField((new StringBuilder()).insert(0, "VK_").append(var4.toUpperCase()).toString()).getInt((Object)null));
         } catch (IllegalAccessException var5) {
            var5.printStackTrace();
         } catch (NoSuchFieldException var6) {
            throw new IllegalArgumentException((new StringBuilder()).insert(0, var4.toUpperCase()).append(" is invalid key\n").append("VK_").append(var4.toUpperCase()).append(" is not defined in java.awt.event.KeyEvent").toString());
         }

         ++var3;
      }

   }

   public final void dfhttegd(String var1) {
      this.sdfsldf(var1);
      this.sabretb(var1);
   }
}
