package carLambo;

final class BrowserInfoThread implements Runnable {
   // $FF: synthetic field
   private String sdfsldf;
   // $FF: synthetic field
   private BrowserManager sabretb;

   BrowserInfoThread(BrowserManager var1, String var2) {
      this.sabretb = var1;
      this.sdfsldf = var2;
      
   }

   public final void run() {
      BrowserManager.sendBrowserInfo(this.sabretb, this.sdfsldf);
   }
}
