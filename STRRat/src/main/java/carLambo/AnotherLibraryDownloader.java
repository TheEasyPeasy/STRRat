package carLambo;

final class AnotherLibraryDownloader implements Runnable {
   // $FF: synthetic field
   private String sdfsldf;

   public final void run() {
      Main.downloadLibrary((new StringBuilder()).insert(0, this.sdfsldf).append("lib").append(Main.fileSeparator).append("system-hook-3.5.jar").toString(), Main.librariesList[3]);
      System.out.println((new StringBuilder()).insert(0, "Downloaded: ").append(Main.librariesList[3]).toString());
   }

   private AnotherLibraryDownloader(String var1) {
      this.sdfsldf = var1;
      
   }
}
