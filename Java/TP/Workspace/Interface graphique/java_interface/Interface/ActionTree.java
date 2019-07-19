package Interface;

import Browser.Browser;
import javax.swing.JFrame;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

class ActionTree
    implements TreeSelectionListener
{

    ActionTree(JFrame jframe)
    {
        tree = jframe;
    }

    public void valueChanged(TreeSelectionEvent treeselectionevent)
    {
        DefaultMutableTreeNode defaultmutabletreenode = (DefaultMutableTreeNode)treeselectionevent.getPath().getLastPathComponent();
        if(defaultmutabletreenode.isLeaf())
        {
            String s = treeselectionevent.getPath().toString();
            String s1 = lireAdresse(s);
            String s2 = System.getProperty("user.dir");
            if(lireNom(s1))
                new Browser("file:" + s2 + "/" + s1);
        }
    }

    String lireAdresse(String s)
    {
        int i = 0;
        String s1;
        int j;
        for(s1 = ""; i < s.length() - 1; s1 = s1 + s.substring(j, i) + "/")
        {
            if(++i == 1)
                j = 1;
            else
                j = i + 1;
            for(; s.charAt(i) != ',' && s.charAt(i) != ']'; i++);
        }

        return s1.substring(0, s1.length() - 1);
    }

    boolean lireNom(String s)
    {
        int i;
        for(i = s.length() - 1; s.charAt(i) != '.'; i--);
        String s1 = s.substring(i, s.length());
        return ".html".equals(s1) || ".htm".equals(s1);
    }

    JFrame tree;
}
