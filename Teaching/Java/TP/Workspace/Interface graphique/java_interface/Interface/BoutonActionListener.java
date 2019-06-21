package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

// Referenced classes of package Interface:
//            Windows, BarreTaches

class BoutonActionListener
    implements ActionListener
{

    public BoutonActionListener(Windows windows, JButton jbutton)
    {
        obj = windows;
        jb = jbutton;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        obj.toolbar.menuEvent(actionevent, jb);
    }

    Windows obj;
    JButton jb;
}
