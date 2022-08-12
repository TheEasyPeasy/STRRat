package carLambo;

final class BrowserListenerThread implements Runnable {
   // $FF: synthetic field
   private BrowserManager browserManager;

   BrowserListenerThread(BrowserManager var1) {
      this.browserManager = var1;
      
   }

   public final void run() {
      BrowserManager.listener(this.browserManager);
   }
}
