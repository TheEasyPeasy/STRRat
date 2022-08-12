package carLambo;

final class StartupThread implements Runnable {
   // $FF: synthetic field
   private StartupManager startupManager;

   StartupThread(StartupManager startupManager) {
      this.startupManager = startupManager;
      
   }

   public final void run() {
      StartupManager.listener(this.startupManager);
   }
}
