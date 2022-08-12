package carLambo;

final class MouseResetThread implements Runnable {
   public final void run() {
      ConnectionUtil.moveMouse();
   }
}
