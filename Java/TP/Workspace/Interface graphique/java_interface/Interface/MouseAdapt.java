package Interface;

import java.awt.event.*;

// Referenced classes of package Interface:
//            Apropos

class MouseAdapt extends MouseAdapter
    implements MouseListener
{

    MouseAdapt(Apropos apropos)
    {
        propos = apropos;
    }

    public void mousePressed(MouseEvent mouseevent)
    {
        propos.close();
    }

    Apropos propos;
}
