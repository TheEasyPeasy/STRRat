package carLambo;

final class ProcessThread implements Runnable {
   // $FF: synthetic field
   private ProcessManager processManager;

   public final void run() {
      ProcessManager.listener(this.processManager);
   }

   ProcessThread(ProcessManager manager) {
      this.processManager = manager;
      
   }
}
