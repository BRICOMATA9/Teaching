package Browser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

// Referenced classes of package Browser:
//            Browser, BarreTachesBrowser

class BoutonActionListener
    implements ActionListener
{

    public BoutonActionListener(Browser browser, JButton jbutton)
    {
        b = browser;
        jb = jbutton;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        b.bt.menuEvent(actionevent, jb);
    }

    Browser b;
    JButton jb;
}
