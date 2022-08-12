package carLambo;

final class AnotherLibraryDownloader3 implements Runnable {
   // $FF: synthetic field
   private String sdfsldf;

   private AnotherLibraryDownloader3(String var1) {
      this.sdfsldf = var1;
      
   }

   public final void run() {
      Main.downloadLibrary((new StringBuilder()).insert(0, this.sdfsldf).append("lib").append(Main.fileSeparator).append("jna-platform-5.5.0.jar").toString(), Main.librariesList[1]);
      System.out.println((new StringBuilder()).insert(0, "Downloaded: ").append(Main.librariesList[1]).toString());
   }
}
