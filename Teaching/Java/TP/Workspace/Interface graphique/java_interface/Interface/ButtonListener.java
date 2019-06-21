package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Referenced classes of package Interface:
//            Windows, MyPanelDownload

class ButtonListener
    implements ActionListener
{

    ButtonListener(Windows windows)
    {
        win = windows;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        win.download.buttonPressed(actionevent);
    }

    Windows win;
}
