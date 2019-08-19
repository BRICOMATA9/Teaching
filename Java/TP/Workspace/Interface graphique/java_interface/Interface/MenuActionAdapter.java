package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Referenced classes of package Interface:
//            Windows, BarreMenus

class MenuActionAdapter
    implements ActionListener
{

    MenuActionAdapter(Windows windows)
    {
        win = windows;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        win.menuBar.menuEvent(actionevent);
    }

    Windows win;
}
