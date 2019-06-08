package Interface;

import java.awt.event.*;

// Referenced classes of package Interface:
//            Windows, ContextualMenu

class EvenementListener extends MouseAdapter
    implements ActionListener
{

    EvenementListener(Windows windows, String s)
    {
        obj = windows;
        look = s;
    }

    public void mouseClicked(MouseEvent mouseevent)
    {
        obj.contextualMenu.mouseEvent(mouseevent);
    }

    public void actionPerformed(ActionEvent actionevent)
    {
        obj.look(look);
    }

    private Windows obj;
    private String look;
}
