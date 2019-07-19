package Interface;

import java.awt.event.*;
import javax.swing.*;

// Referenced classes of package Interface:
//            EvenementListener, Windows

public class ContextualMenu
{

    ContextualMenu(Windows windows)
    {
        popupMenu = new JPopupMenu();
        laf = new JMenu("laf");
        motifItem = new JMenuItem("Motif");
        metalItem = new JMenuItem("Metal");
        windowsItem = new JMenuItem("Windows");
        obj = windows;
        motifItem.addActionListener(new EvenementListener(windows, "Motif"));
        metalItem.addActionListener(new EvenementListener(windows, "Metal"));
        windowsItem.addActionListener(new EvenementListener(windows, "Windows"));
        popupMenu.add(laf);
        laf.add(motifItem);
        laf.add(metalItem);
        laf.add(windowsItem);
    }

    void mouseEvent(MouseEvent mouseevent)
    {
        if(mouseevent.getModifiers() == 4)
            popupMenu.show(mouseevent.getComponent(), mouseevent.getX(), mouseevent.getY());
    }

    private Windows obj;
    JPopupMenu popupMenu;
    JMenu laf;
    JMenuItem motifItem;
    JMenuItem metalItem;
    JMenuItem windowsItem;
}
