package Browser;

import Interface.Dialogue;
import java.io.IOException;
import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.JTextComponent;

// Referenced classes of package Browser:
//            HtmlViewHyperlinkAdapter, Browser

class JHtml extends JEditorPane
{

    public JHtml(URL url, Browser browser1)
        throws IOException
    {
        super(url);
        browser = browser1;
        setEditable(false);
        addHyperlinkListener(new HtmlViewHyperlinkAdapter(this));
    }

    void htmlViewHyperlink(HyperlinkEvent hyperlinkevent)
    {
        try
        {
            URL url = hyperlinkevent.getURL();
            setPage(url);
            browser.inserer(url);
        }
        catch(IOException ioexception)
        {
            new Dialogue("Erreurs lors de l'affichage de la page : \n" + ioexception);
        }
    }

    Browser browser;
}
