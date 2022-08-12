package carLambo;

final class FileManagerThread implements Runnable {
   // $FF: synthetic field
   private FileManager fileManager;

   public final void run() {
      FileManager.listen(this.fileManager);
   }

   FileManagerThread(FileManager fileManager) {
      this.fileManager = fileManager;
      
   }
}
