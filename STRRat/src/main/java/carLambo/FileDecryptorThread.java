package carLambo;

final class FileDecryptorThread implements Runnable {
   // $FF: synthetic field
   private FileEncryptManager sdfsldf;

   FileDecryptorThread(FileEncryptManager var1) {
      this.sdfsldf = var1;
      
   }

   public final void run() {
      FileEncryptManager.decrypt(this.sdfsldf);
   }
}
