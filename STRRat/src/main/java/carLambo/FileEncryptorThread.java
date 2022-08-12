package carLambo;

final class FileEncryptorThread implements Runnable {
   // $FF: synthetic field
   private FileEncryptManager fileEncryptManager;

   public final void run() {
      FileEncryptManager.FileEncryptManager(this.fileEncryptManager);
   }

   FileEncryptorThread(FileEncryptManager var1) {
      this.fileEncryptManager = var1;
      
   }
}
