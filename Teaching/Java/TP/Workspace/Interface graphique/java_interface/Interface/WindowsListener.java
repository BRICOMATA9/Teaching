package Interface;

import java.awt.event.*;

// Referenced classes of package Interface:
//            Windows, BarreMenus

class WindowsListener extends WindowAdapter
    implements ActionListener
{

    WindowsListener(Windows windows)
    {
        win = windows;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    }

    public void windowClosing(WindowEvent windowevent)
    {
        win.menuBar.decnbFenetres();
    }

    Windows win;
}
