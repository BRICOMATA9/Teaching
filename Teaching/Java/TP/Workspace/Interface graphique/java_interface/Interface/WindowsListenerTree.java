package Interface;

import java.awt.Window;
import java.awt.event.*;

// Referenced classes of package Interface:
//            MyPanelTree

class WindowsListenerTree extends WindowAdapter
    implements ActionListener
{

    WindowsListenerTree(MyPanelTree mypaneltree, int i)
    {
        tree = mypaneltree;
        num = i;
    }

    public void actionPerformed(ActionEvent actionevent)
    {
    }

    public void windowClosing(WindowEvent windowevent)
    {
        tree.dispose();
        num--;
    }

    MyPanelTree tree;
    int num;
}
