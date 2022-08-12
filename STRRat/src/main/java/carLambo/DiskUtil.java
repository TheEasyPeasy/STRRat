package carLambo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class DiskUtil {
   private String sdfsldf = "null";

   public final String getSerialNumber() {
      ProcessBuilder var1;
      (var1 = new ProcessBuilder(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_logicaldisk get volumeserialnumber /format:list"})).redirectErrorStream(true);
      StringBuilder var3 = new StringBuilder();

      String var4;
      try {
         Process var6 = var1.start();
         BufferedReader var2 = new BufferedReader(new InputStreamReader(var6.getInputStream()));

         while((var4 = var2.readLine()) != null) {
            var3.append(var4 + "\r\n");
         }
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      String[] var7;
      int var8 = (var7 = var3.toString().split("\r\n")).length;

      int var9;
      for(int var10000 = var9 = 0; var10000 < var8; var10000 = var9) {
         if ((var4 = var7[var9]).trim().startsWith("VolumeSerialNumber")) {
            this.sdfsldf = var4.trim().split("=")[1];
            if (!this.sdfsldf.equals("")) {
               break;
            }
         }

         ++var9;
      }

      return this.sdfsldf;
   }
}
