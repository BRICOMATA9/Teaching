package Browser;

import Interface.Dialogue;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JTextField;

// Referenced classes of package Browser:
//            Panel, BarreTachesBrowser

public class Browser extends JFrame
{

    public Browser(String s)
    {
        super("VisuMagic");
        Ladresse = new JTextField();
        fileAdresse = new URL[10];
        insertion = 0;
        lecture = 0;
        adresse = s;
        setSize(640, 480);
        try
        {
            for(int i = 0; i < 10; i++)
                fileAdresse[i] = new URL(s);

            insertion++;
        }
        catch(MalformedURLException malformedurlexception)
        {
            new Dialogue("Url mal formee : " + malformedurlexception);
        }
        Panel panel = new Panel(s, Ladresse, this);
        Ladresse.setBounds(10, 40, 630, 30);
        getContentPane().add("North", Ladresse);
        getContentPane().add(panel);
        browser = new Thread(panel);
        browser.start();
        bt = new BarreTachesBrowser(this, browser, panel);
        show();
    }

    public void inserer(URL url)
    {
        fileAdresse[insertion] = url;
        lecture = insertion;
        insertion = (insertion + 1 + 10) % 10;
    }

    public URL lireAvant()
    {
        lecture = (lecture + 1 + 10) % 10;
        insertion = (insertion + 1 + 10) % 10;
        URL url = fileAdresse[lecture];
        return url;
    }

    public URL lireArriere()
    {
        lecture = ((lecture - 1) + 10) % 10;
        insertion = ((insertion - 1) + 10) % 10;
        URL url = fileAdresse[lecture];
        return url;
    }

    BarreTachesBrowser bt;
    Thread browser;
    public String adresse;
    private JTextField Ladresse;
    private URL fileAdresse[];
    private int insertion;
    private int lecture;
}
