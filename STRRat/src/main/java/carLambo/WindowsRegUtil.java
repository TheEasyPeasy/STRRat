package carLambo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.prefs.Preferences;

public final class WindowsRegUtil {
   private static Method WindowsRegDeleteKey;
   private static Method WindowsRegQueryInfoKey1;
   private static int dfhttegd;
   private static Method WindowsRegCloseKey;
   private static final int gsbthstgb = 983103;
   private static int sfsrgsbd;
   private static final int fgsbsfgsb = 131097;
   private static int fgssdg;
   private static int dsgsdfge;
   private static Method WindowsRegQueryValueEx;
   private static Method WindowsRegOpenKey;
   private static Method WindowsRegDeleteValue;
   private static Method WindowsRegEnumKeyEx;
   private static int hghteerd;
   private static Preferences sgsfghhg = Preferences.userRoot();
   private static Method WindowsRegSetValueEx;
   private static int mdgghtdsh;
   private static Preferences sstydgn = Preferences.systemRoot();
   private static Method WindowsRegCreateKeyEx;
   private static Method WindowsRegEnumValue;
   private static Class dndghd;
   private static int nddfgndt;

   // $FF: synthetic method
   private static void invokeMethod(Preferences var0, int var1, String var2, String var3, String var4, int var5) {
      try {
         int[] var6 = (int[]) WindowsRegOpenKey.invoke(var0, new Integer(var1), invokeMethod(var2), new Integer(983103 | var5));
         WindowsRegSetValueEx.invoke(var0, new Integer(var6[0]), invokeMethod(var3), invokeMethod(var4));
         WindowsRegCloseKey.invoke(var0, new Integer(var6[0]));
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   private static void invokeMethod(int var0, String var1) {
      int var2 = -1;
      int var10000;
      if (var0 == -2147483646) {
         var10000 = var2 = invokeMethod(sstydgn, var0, var1);
      } else {
         if (var0 == -2147483647) {
            var2 = invokeMethod(sgsfghhg, var0, var1);
         }

         var10000 = var2;
      }

      if (var10000 != 0) {
         throw new IllegalArgumentException((new StringBuilder()).insert(0, "rc=").append(var2).append("  key=").append(var1).toString());
      }
   }

   // $FF: synthetic method
   private static int invokeMethod(Preferences var0, int var1, String var2) {
      try {
         return ((Integer) WindowsRegDeleteKey.invoke(var0, new Integer(var1), invokeMethod(var2))).intValue();

      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   // $FF: synthetic method
   private static int invokeMethod(Preferences var0, int var1, String var2, String var3, int var4) {
      try {
         int[] var5;
         if ((var5 = (int[]) WindowsRegOpenKey.invoke(var0, new Integer(var1), invokeMethod(var2), new Integer(983103 | var4)))[1] != 0) {
            return var5[1];
         } else {
            int var6 = ((Integer) WindowsRegDeleteValue.invoke(var0, new Integer(var5[0]), invokeMethod(var3))).intValue();
            WindowsRegCloseKey.invoke(var0, new Integer(var5[0]));
            return var6;
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   // $FF: synthetic method
   private static List invokeMethod(Preferences var0, int var1, String var2, int var3) {
      try {
         ArrayList var4 = new ArrayList();
         int[] var7;
         if ((var7 = (int[]) WindowsRegOpenKey.invoke(var0, new Integer(var1), invokeMethod(var2), new Integer(131097 | var3)))[1] != 0) {
            return null;
         } else {
            int[] var10000 = (int[]) WindowsRegQueryInfoKey1.invoke(var0, new Integer(var7[0]));
            int var8 = var10000[0];
            var3 = var10000[3];

            int var5;
            for(int var9 = var5 = 0; var9 < var8; var9 = var5) {
               byte[] var6 = (byte[]) WindowsRegEnumKeyEx.invoke(var0, new Integer(var7[0]), var5, new Integer(var3 + 1));
               ++var5;
               var4.add((new String(var6)).trim());
            }

            WindowsRegCloseKey.invoke(var0, new Integer(var7[0]));
            return var4;
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   // $FF: synthetic method
   private static byte[] invokeMethod(String var0) {
      byte[] var1 = new byte[var0.length() + 1];

      int var2;
      for(int var10000 = var2 = 0; var10000 < var0.length(); var10000 = var2) {
         int var10001 = var2;
         byte var10002 = (byte)var0.charAt(var2);
         ++var2;
         var1[var10001] = var10002;
      }

      var1[var0.length()] = 0;
      return var1;
   }

   public static void invokeMethod(int var0, String var1, String var2, String var3, int var4) {
      if (var0 == -2147483646) {
         invokeMethod(sstydgn, var0, var1, var2, var3, 0);
      } else if (var0 == -2147483647) {
         invokeMethod(sgsfghhg, var0, var1, var2, var3, 0);
      } else {
         throw new IllegalArgumentException((new StringBuilder()).insert(0, "hkey=").append(var0).toString());
      }
   }

   // $FF: synthetic method
   private static int[] sabretb(Preferences var0, int var1, String var2) {
      try {
         return (int[]) WindowsRegCreateKeyEx.invoke(var0, new Integer(var1), invokeMethod(var2));

      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   static {
      dndghd = sgsfghhg.getClass();
      WindowsRegOpenKey = null;
      WindowsRegCloseKey = null;
      WindowsRegQueryValueEx = null;
      WindowsRegEnumValue = null;
      WindowsRegQueryInfoKey1 = null;
      WindowsRegEnumKeyEx = null;
      WindowsRegCreateKeyEx = null;
      WindowsRegSetValueEx = null;
      WindowsRegDeleteKey = null;
      WindowsRegDeleteValue = null;

      try {
         (WindowsRegOpenKey = dndghd.getDeclaredMethod("WindowsRegOpenKey", Integer.TYPE, byte[].class, Integer.TYPE)).setAccessible(true);
         (WindowsRegCloseKey = dndghd.getDeclaredMethod("WindowsRegCloseKey", Integer.TYPE)).setAccessible(true);
         (WindowsRegQueryValueEx = dndghd.getDeclaredMethod("WindowsRegQueryValueEx", Integer.TYPE, byte[].class)).setAccessible(true);
         (WindowsRegEnumValue = dndghd.getDeclaredMethod("WindowsRegEnumValue", Integer.TYPE, Integer.TYPE, Integer.TYPE)).setAccessible(true);
         (WindowsRegQueryInfoKey1 = dndghd.getDeclaredMethod("WindowsRegQueryInfoKey1", Integer.TYPE)).setAccessible(true);
         (WindowsRegEnumKeyEx = dndghd.getDeclaredMethod("WindowsRegEnumKeyEx", Integer.TYPE, Integer.TYPE, Integer.TYPE)).setAccessible(true);
         (WindowsRegCreateKeyEx = dndghd.getDeclaredMethod("WindowsRegCreateKeyEx", Integer.TYPE, byte[].class)).setAccessible(true);
         (WindowsRegSetValueEx = dndghd.getDeclaredMethod("WindowsRegSetValueEx", Integer.TYPE, byte[].class, byte[].class)).setAccessible(true);
         (WindowsRegDeleteValue = dndghd.getDeclaredMethod("WindowsRegDeleteValue", Integer.TYPE, byte[].class)).setAccessible(true);
         (WindowsRegDeleteKey = dndghd.getDeclaredMethod("WindowsRegDeleteKey", Integer.TYPE, byte[].class)).setAccessible(true);
      } catch (Exception var1) {
         var1.printStackTrace();
      }
   }

   private static void sabretb(int var0, String var1) {
      try {
         int[] var10000;
         int[] var2;
         if (var0 == -2147483646) {
            var2 = sabretb(sstydgn, var0, var1);
            WindowsRegCloseKey.invoke(sstydgn, new Integer(var2[0]));
            var10000 = var2;
         } else {
            if (var0 != -2147483647) {
               throw new IllegalArgumentException((new StringBuilder()).insert(0, "hkey=").append(var0).toString());
            }

            var2 = sabretb(sgsfghhg, var0, var1);
            WindowsRegCloseKey.invoke(sgsfghhg, new Integer(var2[0]));
            var10000 = var2;
         }

         if (var10000[1] != 0) {
            throw new IllegalArgumentException((new StringBuilder()).insert(0, "rc=").append(var2[1]).append("  key=").append(var1).toString());
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   public static String invokeMethod(int var0, String var1, String var2, int var3) {
      if (var0 == -2147483646) {
         return sabretb(sstydgn, var0, var1, var2, var3);
      } else if (var0 == -2147483647) {
         return sabretb(sgsfghhg, var0, var1, var2, var3);
      } else {
         throw new IllegalArgumentException((new StringBuilder()).insert(0, "hkey=").append(var0).toString());
      }
   }

   public static void sabretb(int var0, String var1, String var2, int var3) {
      var3 = -1;
      int var10000;
      if (var0 == -2147483646) {
         var10000 = var3 = invokeMethod(sstydgn, var0, var1, var2, 0);
      } else {
         if (var0 == -2147483647) {
            var3 = invokeMethod(sgsfghhg, var0, var1, var2, 0);
         }

         var10000 = var3;
      }

      if (var10000 != 0) {
         throw new IllegalArgumentException((new StringBuilder()).insert(0, "rc=").append(var3).append("  key=").append(var1).append("  value=").append(var2).toString());
      }
   }

   public static List invokeMethod(int var0, String var1, int var2) {
      try {
         byte var3 = 0;
         int var8 = -2147483647;
         Preferences var7 = sgsfghhg;
         ArrayList var4 = new ArrayList();
         int[] var9;
         if ((var9 = (int[]) WindowsRegOpenKey.invoke(var7, new Integer(var8), invokeMethod(var1), new Integer(131097 | var3)))[1] != 0) {
            return null;
         } else {
            int[] var10000 = (int[]) WindowsRegQueryInfoKey1.invoke(var7, new Integer(var9[0]));
            var2 = var10000[0];
            int var11 = var10000[3];

            int var5;
            for(int var12 = var5 = 0; var12 < var2; var12 = var5) {
               byte[] var6 = (byte[]) WindowsRegEnumKeyEx.invoke(var7, new Integer(var9[0]), var5, new Integer(var11 + 1));
               ++var5;
               var4.add((new String(var6)).trim());
            }

            WindowsRegCloseKey.invoke(var7, new Integer(var9[0]));
            return var4;
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   // $FF: synthetic method
   private static String sabretb(Preferences var0, int var1, String var2, String var3, int var4) {
      try {
         int[] var5;
         if ((var5 = (int[]) WindowsRegOpenKey.invoke(var0, new Integer(var1), invokeMethod(var2), new Integer(131097 | var4)))[1] != 0) {
            return null;
         } else {
            byte[] var6 = (byte[]) WindowsRegQueryValueEx.invoke(var0, new Integer(var5[0]), invokeMethod(var3));
            WindowsRegCloseKey.invoke(var0, new Integer(var5[0]));
            return var6 != null ? (new String(var6)).trim() : null;
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   private static Map sabretb(int var0, String var1, int var2) {
      if (var0 == -2147483646) {
         return sabretb(sstydgn, var0, var1, var2);
      } else if (var0 == -2147483647) {
         return sabretb(sgsfghhg, var0, var1, var2);
      } else {
         throw new IllegalArgumentException((new StringBuilder()).insert(0, "hkey=").append(var0).toString());
      }
   }

   // $FF: synthetic method
   private static Map sabretb(Preferences var0, int var1, String var2, int var3) {
      try {
         HashMap var4 = new HashMap();
         int[] var5;
         if ((var5 = (int[]) WindowsRegOpenKey.invoke(var0, new Integer(var1), invokeMethod(var2), new Integer(131097 | var3)))[1] != 0) {
            return null;
         } else {
            int[] var10000 = (int[]) WindowsRegQueryInfoKey1.invoke(var0, new Integer(var5[0]));
            int var6 = var10000[2];
            int var7 = var10000[3];

            int var8;
            for(int var11 = var8 = 0; var11 < var6; var11 = var8) {
               byte[] var9 = (byte[]) WindowsRegEnumValue.invoke(var0, new Integer(var5[0]), var8, new Integer(var7 + 1));
               String var10 = invokeMethod(var1, var2, new String(var9), var3);
               String var10001 = new String(var9);
               ++var8;
               var4.put(var10001.trim(), var10);
            }

            WindowsRegCloseKey.invoke(var0, new Integer(var5[0]));
            return var4;
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }
}
