package Interface;

import java.io.File;
import java.io.PrintStream;
import javax.swing.JFileChooser;

// Referenced classes of package Interface:
//            Windows

class Ouvrir
{

    Ouvrir(Windows windows)
    {
        fileChooser = new JFileChooser("./");
        win = windows;
        int i = fileChooser.showOpenDialog(windows);
        if(i == 0)
        {
            String s = fileChooser.getSelectedFile().getName();
            String s1 = fileChooser.getSelectedFile().getPath();
            String s2 = fileChooser.getSelectedFile().getAbsolutePath();
            System.out.println("p : " + s1 + " ap: " + s2);
        }
    }

    Windows win;
    private JFileChooser fileChooser;
}
