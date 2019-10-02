package Browser;

import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

// Referenced classes of package Browser:
//            JHtml

class HtmlViewHyperlinkAdapter
    implements HyperlinkListener
{

    HtmlViewHyperlinkAdapter(JHtml jhtml)
    {
        html = jhtml;
    }

    public void hyperlinkUpdate(HyperlinkEvent hyperlinkevent)
    {
        html.htmlViewHyperlink(hyperlinkevent);
    }

    JHtml html;
}
