package Algorithme;

import Interface.*;
import javax.swing.text.JTextComponent;

// Referenced classes of package Algorithme:
//            Telechargement

public class Verrou
{

    public Verrou(Windows windows, MyPanelInfos mypanelinfos)
    {
        win = windows;
        infos = mypanelinfos;
    }

    public synchronized void fin(Telechargement telechargement, MyPanelTree mypaneltree, int i, boolean flag)
    {
        try
        {
            if(Telechargement.nbThread != 0)
                Telechargement.nbThread--;
            infos.enCours.setText(String.valueOf(Integer.parseInt(infos.enCours.getText()) - 1));
            if(!flag)
                infos.telecharges.setText(String.valueOf(Integer.parseInt(infos.telecharges.getText()) + 1));
            notifyAll();
            if(Telechargement.nbThread == 0)
            {
                mypaneltree.signal();
                Telechargement.CHANGEMENT = true;
            }
        }
        catch(Exception exception)
        {
            new Dialogue("Erreur sur la terminaison du thread." + exception);
        }
    }

    public synchronized void lien(String s, String s1, int i, int j, MyPanelTree mypaneltree, Telechargement telechargement)
    {
        try
        {
            while(Telechargement.nbThread >= telechargement.nbThreadMax) 
                wait();
            Telechargement.nbThread++;
            Telechargement telechargement1 = new Telechargement(win, s, s1, i, mypaneltree, this);
            infos.enCours.setText(String.valueOf(Integer.parseInt(infos.enCours.getText()) + 1));
            telechargement1.start();
        }
        catch(InterruptedException interruptedexception)
        {
            new Dialogue("Impossible de faire attendre la thread " + interruptedexception);
        }
    }

    private Windows win;
    private MyPanelInfos infos;
}
