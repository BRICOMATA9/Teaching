package Interface;

import Algorithme.Telechargement;
import Algorithme.Verrou;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.JTextComponent;

// Referenced classes of package Interface:
//            MyPanelDownload, MyPanelInfos, MyPanelTree, Windows

class KeyAction
    implements KeyListener
{

    KeyAction(MyPanelDownload mypaneldownload, MyPanelTree mypaneltree, MyPanelInfos mypanelinfos, Telechargement telechargement, Verrou verrou1, Windows windows)
    {
        download = mypaneldownload;
        tree = mypaneltree;
        infos = mypanelinfos;
        t = telechargement;
        verrou = verrou1;
        win = windows;
    }

    public void keyTyped(KeyEvent keyevent)
    {
    }

    public void keyReleased(KeyEvent keyevent)
    {
    }

    public void keyPressed(KeyEvent keyevent)
    {
        if(keyevent.getKeyCode() == 10 && !"".equals(download.adresse.getText()))
        {
            verrou = new Verrou(win, infos);
            t = new Telechargement(win, download.adresse.getText(), download.nom.getText(), 0, tree, verrou);
            t.start();
            infos.enCours.setText(String.valueOf(Integer.parseInt(infos.enCours.getText()) + 1));
        }
    }

    MyPanelDownload download;
    MyPanelTree tree;
    MyPanelInfos infos;
    Telechargement t;
    Verrou verrou;
    Windows win;
}
