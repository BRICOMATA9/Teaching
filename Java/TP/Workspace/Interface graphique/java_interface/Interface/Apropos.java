package Interface;

import java.awt.*;
import javax.swing.JFrame;

// Referenced classes of package Interface:
//            MouseAdapt, Dialogue, Windows

class Apropos extends JFrame
{

    Apropos(Windows windows)
    {
        x = 0;
        y = 0;
        win = windows;
        setSize(400, 300);
        setLocation(150, 100);
        setTitle("A propos de ce logiciel ...");
        setBackground(Color.white);
        setResizable(false);
        addMouseListener(new MouseAdapt(this));
        getContentPane().setLayout(null);
        dessiner();
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.drawImage(image, 20, -10, x, y, this);
        g.drawString("Programmeurs :", 65, 130);
        g.drawString("REDONDO Julien : redondo@dil.univ-mrs.fr", 80, 150);
        g.drawString("WAHED Eric        : wahed@dil.univ-mrs.fr ", 80, 165);
        g.drawString("Ce programme a ete developpe dans l'optique des TER de fin de maitrise", 15, 200);
        g.drawString("sous la direction de Mr GISPERT.", 15, 215);
        g.drawString("Copyright \251 REDONDO-WAHED 2000", 15, 280);
        g.drawString("Version 1.0b3 - 20/06/2000", 220, 230);
    }

    void dessiner()
    {
        MediaTracker mediatracker = new MediaTracker(this);
        image = getToolkit().getImage("images/aspimagic.gif");
        mediatracker.addImage(image, 1);
        try
        {
            mediatracker.waitForID(1);
        }
        catch(InterruptedException interruptedexception)
        {
            new Dialogue("Impossible de cherger l'image : " + interruptedexception);
        }
        x = image.getWidth(this);
        y = image.getHeight(this);
    }

    void close()
    {
        dispose();
    }

    Windows win;
    int x;
    int y;
    Image image;
}
