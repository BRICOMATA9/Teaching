package Browser;

import Interface.Dialogue;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.text.JTextComponent;

// Referenced classes of package Browser:
//            JHtml, Browser

class Panel extends JPanel
    implements Runnable
{

    Panel(String s, JTextField jtextfield, Browser browser1)
    {
        scroller = new JScrollPane(22, 31);
        couleurFond = Color.lightGray;
        adresse = s;
        Ladresse = jtextfield;
        browser = browser1;
        jtextfield.setText(s);
    }

    public void run()
    {
        setLayout(new BorderLayout());
        setBackground(couleurFond);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        scroller.setBorder(new SoftBevelBorder(1));
        scroller.setBackground(couleurFond);
        try
        {
            html = new JHtml(new URL(adresse), browser);
            Ladresse.setText(adresse);
        }
        catch(MalformedURLException malformedurlexception)
        {
            new Dialogue("URL erronee : " + malformedurlexception);
        }
        catch(IOException ioexception)
        {
            new Dialogue("IO erreur : " + ioexception);
        }
        vp = scroller.getViewport();
        vp.add(html);
        add("Center", scroller);
    }

    String adresse;
    JHtml html;
    Browser browser;
    private JTextField Ladresse;
    protected JScrollPane scroller;
    protected JViewport vp;
    final Color couleurFond;
}
