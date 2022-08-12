package carLambo;

final class RemoteScreenThread implements Runnable {
   // $FF: synthetic field
   private RemoteScreenManager sdfsldf;

   public final void run() {
      RemoteScreenManager.readAndExecute(this.sdfsldf);
   }

   RemoteScreenThread(RemoteScreenManager var1) {
      this.sdfsldf = var1;
      
   }
}
