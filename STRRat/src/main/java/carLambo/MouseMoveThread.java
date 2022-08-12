package carLambo;

final class MouseMoveThread implements Runnable {
   // $FF: synthetic field
   private MouseMoveManager manager;

   public final void run() {
      MouseMoveManager.startResetMovingMouse(this.manager);
   }

   MouseMoveThread(MouseMoveManager var1) {
      this.manager = var1;
      
   }
}
