package Interface;

import Browser.Browser;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.text.JTextComponent;

// Referenced classes of package Interface:
//            BoutonActionListener, Ouvrir, Enregistrer, Preferences, 
//            Bookmarks, MyPanelDownload, MyPanelInfos, Windows

public class BarreTaches
{

    public BarreTaches(Windows windows, MyPanelDownload mypaneldownload, MyPanelInfos mypanelinfos)
    {
        toolbar = new JToolBar();
        jb1 = new JButton(new ImageIcon("images/toolbar/New16.gif"));
        jb2 = new JButton(new ImageIcon("images/toolbar/Open16.gif"));
        jb3 = new JButton(new ImageIcon("images/toolbar/Save16.gif"));
        jb4 = new JButton(new ImageIcon("images/toolbar/SaveAs16.gif"));
        jb5 = new JButton(new ImageIcon("images/toolbar/Print16.gif"));
        jb6 = new JButton(new ImageIcon("images/toolbar/Cut16.gif"));
        jb7 = new JButton(new ImageIcon("images/toolbar/Copy16.gif"));
        jb8 = new JButton(new ImageIcon("images/toolbar/Paste16.gif"));
        jb9 = new JButton(new ImageIcon("images/toolbar/Delete16.gif"));
        jb10 = new JButton(new ImageIcon("images/toolbar/Bookmarks16.gif"));
        jb11 = new JButton(new ImageIcon("images/toolbar/Preferences16.gif"));
        jb12 = new JButton(new ImageIcon("images/toolbar/Help16.gif"));
        obj = windows;
        download = mypaneldownload;
        infos = mypanelinfos;
        jb1.setToolTipText("Nouveau");
        jb1.setMnemonic('n');
        jb2.setToolTipText("Ouvrir");
        jb2.setMnemonic('o');
        jb3.setToolTipText("Enregistrer");
        jb3.setMnemonic('s');
        jb4.setToolTipText("Enregistrer sous");
        jb5.setToolTipText("Imprimer");
        jb5.setMnemonic('p');
        jb6.setToolTipText("Couper");
        jb6.setMnemonic('x');
        jb7.setToolTipText("Copier");
        jb7.setMnemonic('c');
        jb8.setToolTipText("Coller");
        jb8.setMnemonic('v');
        jb9.setToolTipText("Annuler");
        jb9.setMnemonic('z');
        jb10.setToolTipText("Signets");
        jb10.setMnemonic('b');
        jb11.setToolTipText("Preferences");
        jb11.setMnemonic('r');
        jb12.setToolTipText("Aide");
        jb12.setMnemonic('q');
        jb1.addActionListener(new BoutonActionListener(windows, jb1));
        jb2.addActionListener(new BoutonActionListener(windows, jb2));
        jb3.addActionListener(new BoutonActionListener(windows, jb3));
        jb4.addActionListener(new BoutonActionListener(windows, jb4));
        jb5.addActionListener(new BoutonActionListener(windows, jb5));
        jb6.addActionListener(new BoutonActionListener(windows, jb6));
        jb7.addActionListener(new BoutonActionListener(windows, jb7));
        jb8.addActionListener(new BoutonActionListener(windows, jb8));
        jb9.addActionListener(new BoutonActionListener(windows, jb9));
        jb10.addActionListener(new BoutonActionListener(windows, jb10));
        jb11.addActionListener(new BoutonActionListener(windows, jb11));
        jb12.addActionListener(new BoutonActionListener(windows, jb12));
        toolbar.add(jb1);
        toolbar.add(jb2);
        toolbar.add(jb3);
        toolbar.add(jb4);
        toolbar.add(jb5);
        toolbar.addSeparator(new Dimension(10, jb1.getHeight()));
        toolbar.add(jb6);
        toolbar.add(jb7);
        toolbar.add(jb8);
        toolbar.add(jb9);
        toolbar.addSeparator(new Dimension(10, jb1.getHeight()));
        toolbar.add(jb10);
        toolbar.add(jb11);
        toolbar.addSeparator(new Dimension(10, jb1.getHeight()));
        toolbar.add(jb12);
        windows.getContentPane().add(toolbar, "North");
    }

    void menuEvent(ActionEvent actionevent, JButton jbutton)
    {
        if(jb2.equals(jbutton))
            new Ouvrir(obj);
        else
        if(jb3.equals(jbutton))
            new Enregistrer(obj);
        else
        if(jb4.equals(obj))
            new Enregistrer(obj);
        else
        if(jb11.equals(jbutton))
            new Preferences();
        else
        if(jb10.equals(jbutton))
            new Bookmarks(obj);
        else
        if(jb12.equals(jbutton))
        {
            String s = System.getProperty("user.dir");
            new Browser("file:" + s + "/Aide/aide.html");
        } else
        if(jb9.equals(jbutton))
        {
            download.adresse.setText("");
            download.nom.setText("");
            infos.enCours.setText("");
            infos.telecharges.setText("");
        }
    }

    private Windows obj;
    private MyPanelDownload download;
    private MyPanelInfos infos;
    private JToolBar toolbar;
    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private JButton jb4;
    private JButton jb5;
    private JButton jb6;
    private JButton jb7;
    private JButton jb8;
    private JButton jb9;
    private JButton jb10;
    private JButton jb11;
    private JButton jb12;
}
