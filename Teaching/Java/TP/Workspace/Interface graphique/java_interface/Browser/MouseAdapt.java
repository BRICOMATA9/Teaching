package Browser;

import java.awt.event.*;

// Referenced classes of package Browser:
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
