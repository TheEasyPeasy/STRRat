package carLambo;

import java.nio.ByteBuffer;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class EncryptionUtil {
   public static byte[] encrypt(String var0, byte[] var1) {
      try {
         SecureRandom var2 = new SecureRandom();
         byte[] var3 = new byte[16];
         var2.nextBytes(var3);
         SecretKey var6 = generateKey(var0, var3);
         Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
         IvParameterSpec var4 = new IvParameterSpec(var3);
         cipher.init(Cipher.ENCRYPT_MODE, var6, var4);
         var1 = cipher.doFinal(var1);
         ByteBuffer var7;
         (var7 = ByteBuffer.allocate(20 + var1.length)).putInt(16);
         var7.put(var3);
         var7.put(var1);
         return var7.array();
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   public static SecretKey generateKey(String var0, byte[] var1) {
      try {
         PBEKeySpec var2 = new PBEKeySpec(var0.toCharArray(), var1, 65536, 128);
         var1 = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(var2).getEncoded();
         return new SecretKeySpec(var1, "AES");
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }

   public static byte[] decrypt(String var0, byte[] var1) {
      try {
         int var2;
         ByteBuffer var5;
         if ((var2 = (var5 = ByteBuffer.wrap(var1)).getInt()) >= 12 && var2 <= 16) {
            byte[] var6 = new byte[var2];
            var5.get(var6);
            SecretKey var4 = generateKey(var0, var6);
            var5.get(var1 = new byte[var5.remaining()]);
            Cipher var3 = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            IvParameterSpec var7 = new IvParameterSpec(var6);
            var3.init(Cipher.DECRYPT_MODE, var4, var7);
            return var3.doFinal(var1);
         } else {
            throw new IllegalArgumentException("Nonce size is incorrect. Make sure that the incoming data is an AES encrypted file.");
         }
      } catch (Exception e) {
         throw new RuntimeException(e);
      }

   }
}
