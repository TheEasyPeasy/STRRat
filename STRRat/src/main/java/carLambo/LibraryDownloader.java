package carLambo;

final class LibraryDownloader implements Runnable {
   // $FF: synthetic field
   private String link;
   // $FF: synthetic field
   private JarDownloader instance;
   // $FF: synthetic field
   private String name;

   LibraryDownloader(JarDownloader instance, String name, String link) {
      this.instance = instance;
      this.name = name;
      this.link = link;
      
   }

   public final void run() {
      JarDownloader.downloadJarLibrary(this.instance, this.name, this.link);
      System.out.println((new StringBuilder()).insert(0, "Downloaded: ").append(this.link).toString());
   }
}
