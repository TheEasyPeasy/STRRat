package carLambo;

final class AnotherLibraryDownloader2 implements Runnable {
   // $FF: synthetic field
   private String sdfsldf;

   public final void run() {
      Main.downloadLibrary((new StringBuilder()).insert(0, this.sdfsldf).append("lib").append(Main.fileSeparator).append("jna-5.5.0.jar").toString(), Main.librariesList[0]);
      System.out.println((new StringBuilder()).insert(0, "Downloaded: ").append(Main.librariesList[0]).toString());
   }

   private AnotherLibraryDownloader2(String var1) {
      this.sdfsldf = var1;
      
   }
}
