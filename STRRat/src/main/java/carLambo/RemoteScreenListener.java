package carLambo;

final class RemoteScreenListener implements Runnable {
   // $FF: synthetic field
   private RemoteScreenManager sdfsldf;

   RemoteScreenListener(RemoteScreenManager var1) {
      this.sdfsldf = var1;
      
   }

   public final void run() {
      RemoteScreenManager.listener(this.sdfsldf);
   }
}
