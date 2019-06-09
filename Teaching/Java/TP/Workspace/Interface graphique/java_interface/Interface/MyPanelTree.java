package Interface;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

// Referenced classes of package Interface:
//            WindowsListenerTree, ActionTree, Dialogue

public class MyPanelTree extends JFrame
    implements Runnable
{

    MyPanelTree()
    {
        super("Hierarchie");
        tree = new JTree();
        treescroller = new JScrollPane();
        path = "./download/";
        racine = new DefaultMutableTreeNode("download");
        firstThread = new Thread(this);
        addWindowListener(new WindowsListenerTree(this, NUMERO_FENETRE));
        NUMERO_FENETRE++;
        setBackground(Color.white);
        firstThread.start();
    }

    public void run()
    {
        construction();
    }

    public synchronized void signal()
    {
        notify();
    }

    synchronized void construction()
    {
        do
        {
            setSize(250, 250);
            setLocation(480, 30);
            arbre("./download", path, racine);
            DefaultTreeModel defaulttreemodel = new DefaultTreeModel(racine);
            tree.setModel(defaulttreemodel);
            tree.addTreeSelectionListener(new ActionTree(this));
            treescroller.setBounds(8, 15, 200, 200);
            getContentPane().add(treescroller, null);
            treescroller.getViewport().add(tree, null);
            setCursor(new Cursor(12));
            setVisible(true);
            try
            {
                wait();
            }
            catch(InterruptedException _ex)
            {
                new Dialogue("Impossible de creer la hierarchie des fichiers");
            }
            racine = new DefaultMutableTreeNode("download");
        } while(true);
    }

    void arbre(String s, String s1, DefaultMutableTreeNode defaultmutabletreenode)
    {
        File file = new File(s1);
        String as[] = file.list();
        if(as != null)
        {
            for(int i = 0; i < as.length; i++)
            {
                DefaultMutableTreeNode defaultmutabletreenode1 = new DefaultMutableTreeNode(as[i]);
                if(file.isDirectory())
                {
                    defaultmutabletreenode.add(defaultmutabletreenode1);
                    arbre(as[i], s1 + as[i] + "/", defaultmutabletreenode1);
                } else
                if(file.isFile())
                    defaultmutabletreenode.add(defaultmutabletreenode1);
            }

        }
    }

    private JTree tree;
    private JScrollPane treescroller;
    public static int NUMERO_FENETRE = 0;
    String path;
    DefaultMutableTreeNode racine;
    Thread firstThread;

}
