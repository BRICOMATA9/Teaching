package Browser;

import Interface.Dialogue;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;

// Referenced classes of package Browser:
//            BoutonActionListener, Apropos, Browser, Panel

class BarreTachesBrowser
{

    public BarreTachesBrowser(Browser browser1, Thread thread, Panel panel1)
    {
        toolbar = new JToolBar();
        jb1 = new JButton(new ImageIcon("images/navigation/Back24.gif"));
        jb2 = new JButton(new ImageIcon("images/navigation/Forward24.gif"));
        jb3 = new JButton(new ImageIcon("images/navigation/Home24.gif"));
        jb4 = new JButton(new ImageIcon("images/navigation/Stop24.gif"));
        jb5 = new JButton(new ImageIcon("images/navigation/About24.gif"));
        b = browser1;
        browser = thread;
        panel = panel1;
        jb1.setToolTipText("En arriere");
        jb2.setToolTipText("En avant");
        jb3.setToolTipText("Aide en ligne");
        jb3.setMnemonic('m');
        jb4.setToolTipText("STOP");
        jb4.setMnemonic('s');
        jb5.setToolTipText(" A propos de VisuWEB");
        jb1.addActionListener(new BoutonActionListener(browser1, jb1));
        jb2.addActionListener(new BoutonActionListener(browser1, jb2));
        jb3.addActionListener(new BoutonActionListener(browser1, jb3));
        jb4.addActionListener(new BoutonActionListener(browser1, jb4));
        jb5.addActionListener(new BoutonActionListener(browser1, jb5));
        toolbar.add(jb1);
        toolbar.add(jb2);
        toolbar.add(jb4);
        toolbar.addSeparator(new Dimension(40, jb1.getHeight()));
        toolbar.add(jb3);
        toolbar.add(jb5);
        browser1.getContentPane().add(toolbar, "North");
    }

    void menuEvent(ActionEvent actionevent, JButton jbutton)
    {
        if(jb5.equals(jbutton))
            new Apropos();
        else
        if(jb3.equals(jbutton))
        {
            String s = System.getProperty("user.dir");
            new Browser("file:" + s + "/Aide/aide.html");
        } else
        if(jb4.equals(jbutton))
            browser.stop();
        else
        if(jb1.equals(jbutton))
            try
            {
                panel.html.setPage(b.lireArriere());
            }
            catch(IOException _ex)
            {
                new Dialogue("Impossible d'afficher la page : " + actionevent);
            }
        else
        if(jb2.equals(jbutton))
            try
            {
                panel.html.setPage(b.lireAvant());
            }
            catch(IOException _ex)
            {
                new Dialogue("Impossible d'afficher la page : " + actionevent);
            }
    }

    private Browser b;
    private Thread browser;
    private Panel panel;
    private JToolBar toolbar;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
}
