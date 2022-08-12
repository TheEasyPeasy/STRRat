package carLambo;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

public final class LockFile {
   private File file = null;
   private FileOutputStream outputStream = null;
   private FileLock fileLock = null;

   public final void releaseAndClose() {
      try {
         if (this.fileLock != null) {
            this.fileLock.release();
         }

         if (this.outputStream != null) {
            this.outputStream.close();
            return;
         }
      } catch (Exception var1) {
         var1.printStackTrace();
      }

   }

   public final void buildFiles() {
      try {
         this.outputStream = new FileOutputStream(this.file);
         this.fileLock = this.outputStream.getChannel().lock();
      } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException(e);
      }
   }

   LockFile(String var1) {
      try {
         this.file = new File((new StringBuilder()).insert(0, System.getProperty("user.home")).append(File.separator).append(var1).append("lock.file").toString());
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }
}
