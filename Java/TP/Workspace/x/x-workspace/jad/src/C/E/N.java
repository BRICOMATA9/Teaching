// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.E;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineBreakMeasurer;
import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.AttributedString;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class N extends JPanel
{
    private final class _A extends AbstractAction
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            A(actionevent);
        }

        _A()
        {
            super("OK");
            putValue("ActionCommandKey", "OK");
        }
    }

    private final class _B extends AbstractAction
    {

        public void actionPerformed(ActionEvent actionevent)
        {
            A(!B());
        }

        _B()
        {
            super("TOGGLE_DETAILS");
            putValue("ActionCommandKey", "TOGGLE_DETAILS");
        }
    }


    protected N(String s, boolean flag, Throwable throwable)
    {
        super(new BorderLayout());
        J = 400;
        A = throwable;
        H = s;
        E = A.getLocalizedMessage();
        if(E == null)
            E = A.getMessage();
        if(E == null)
            E = A.toString();
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        try
        {
            A.printStackTrace(printwriter);
            stringwriter.close();
            printwriter.close();
        }
        catch(IOException ioexception) { }
        L = stringwriter.toString();
        B(flag);
    }

    private void B(boolean flag)
    {
        if(flag)
        {
            F = A();
            G = A(F);
        }
        B = D();
        String s = E();
        if(s != null && s.length() > 0)
            add(B(s), "North");
        JPanel jpanel = new JPanel(new BorderLayout());
        K = A(E);
        K.setName("SHORT_TEXT");
        C = A(E, L);
        jpanel.add(K, "Center");
        add(jpanel, "Center");
        jpanel.add(C(), "South");
    }

    protected Action D()
    {
        _B _lb = new _B();
        D(((Action) (_lb)));
        return _lb;
    }

    protected Action A()
    {
        _A _la = new _A();
        B(_la);
        return _la;
    }

    protected void D(Action action)
    {
        action.putValue("Name", "Details >>");
        action.putValue("ShortDescription", "Toggles Visibility of Details");
        action.putValue("AcceleratorKey", KeyStroke.getKeyStroke("alt D"));
    }

    protected void B(Action action)
    {
        action.putValue("Name", "Ok");
        action.putValue("ShortDescription", "Close Dialog");
        action.putValue("AcceleratorKey", KeyStroke.getKeyStroke("ENTER"));
    }

    protected JComponent B(String s)
    {
        JLabel jlabel = new JLabel(s);
        jlabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));
        return jlabel;
    }

    protected JComponent A(String s)
    {
        AttributedString attributedstring = new AttributedString(s);
        BreakIterator breakiterator = BreakIterator.getWordInstance();
        FontRenderContext fontrendercontext = new FontRenderContext(new AffineTransform(), false, false);
        LineBreakMeasurer linebreakmeasurer = new LineBreakMeasurer(attributedstring.getIterator(), breakiterator, fontrendercontext);
        ArrayList arraylist = new ArrayList();
        int i = 0;
        int j = linebreakmeasurer.nextOffset(J);
        do
        {
            arraylist.add(s.substring(i, j));
            i = j;
            j = linebreakmeasurer.nextOffset(J, s.length(), true);
            linebreakmeasurer.setPosition(j);
        } while(i < s.length());
        if(arraylist.size() > 1)
        {
            JPanel jpanel = new JPanel(null);
            jpanel.setLayout(new BoxLayout(jpanel, 1));
            jpanel.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));
            JLabel jlabel;
            for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); jpanel.add(jlabel))
            {
                String s1 = (String)iterator.next();
                jlabel = new JLabel(s1);
            }

            return jpanel;
        } else
        {
            return new JLabel(s);
        }
    }

    protected JComponent A(String s, String s1)
    {
        if(s1 == null || s1.length() < 1)
        {
            return null;
        } else
        {
            JTextArea jtextarea = new JTextArea();
            jtextarea.setEditable(false);
            jtextarea.setWrapStyleWord(true);
            jtextarea.setLineWrap(false);
            jtextarea.setText(s1);
            JScrollPane jscrollpane = new JScrollPane(jtextarea, 20, 30);
            Dimension dimension = jtextarea.getPreferredScrollableViewportSize();
            dimension.height = Math.min(dimension.height + 32, 250);
            dimension.width = Math.min(dimension.width + 32, J);
            jscrollpane.setMaximumSize(dimension);
            jscrollpane.setPreferredSize(dimension);
            return jscrollpane;
        }
    }

    protected JComponent C()
    {
        JPanel jpanel = new JPanel();
        BoxLayout boxlayout = new BoxLayout(jpanel, 0);
        jpanel.setLayout(boxlayout);
        Dimension dimension = new Dimension(11, 11);
        if(G != null)
        {
            jpanel.add(G);
            jpanel.add(Box.createRigidArea(dimension));
        }
        jpanel.add(Box.createHorizontalGlue());
        jpanel.setBorder(BorderFactory.createEmptyBorder(6, 0, 6, 0));
        if(C != null)
        {
            JButton jbutton = C(B);
            jpanel.add(jbutton);
        }
        return jpanel;
    }

    protected JButton A(Action action)
    {
        return new JButton(action);
    }

    protected JButton C(Action action)
    {
        return A(action);
    }

    public String E()
    {
        return H;
    }

    public boolean B()
    {
        return I;
    }

    public void A(boolean flag)
    {
        if(flag == I)
            return;
        boolean flag1 = I;
        I = flag;
        firePropertyChange("detailsShowing", flag1, flag);
        A(new ActionEvent(this, 1001, "TOGGLE_DETAILS"));
        if(flag)
        {
            add(C, "South");
            B.putValue("Name", "Details <<");
        } else
        {
            remove(C);
            B.putValue("Name", "Details >>");
        }
        java.awt.Container container = SwingUtilities.getAncestorOfClass(javax.swing.JInternalFrame.class, this);
        revalidate();
        if(container != null)
        {
            ((JInternalFrame)container).pack();
        } else
        {
            Window window = SwingUtilities.getWindowAncestor(this);
            if(window != null)
                window.pack();
        }
    }

    public void A(Component component, int i, String s)
    {
        JOptionPane joptionpane = new JOptionPane(this, i);
        if(F != null)
            joptionpane.setOptions(new Object[0]);
        final JDialog d = joptionpane.createDialog(component, s);
        if(G != null)
        {
            d.getRootPane().setDefaultButton(G);
            G.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent actionevent)
                {
                    d.setVisible(false);
                    d.dispose();
                }

            });
        }
        d.setVisible(true);
    }

    public static void A(Component component, String s, Exception exception)
    {
        A(component, s, 0, exception);
    }

    public static void A(Component component, String s, int i, Exception exception)
    {
        A(component, s, i, ((Throwable) (exception)));
    }

    public static void A(final Component parent, final String dialogTitle, final int messagetype, final Throwable t)
    {
        if(!SwingUtilities.isEventDispatchThread())
        {
            SwingUtilities.invokeLater(new Runnable() {

                public void run()
                {
                    N n1 = new N("An Exception has Occured:", true, t);
                    n1.A(parent, messagetype, dialogTitle);
                }

            });
        } else
        {
            N n = new N("An Exception has Occured:", true, t);
            n.A(parent, messagetype, dialogTitle);
        }
    }

    private void A(ActionEvent actionevent)
    {
label0:
        {
            synchronized(this)
            {
                if(D != null)
                    break label0;
            }
            return;
        }
        ArrayList arraylist = (ArrayList)D.clone();
        n;
        JVM INSTR monitorexit ;
          goto _L1
        exception;
        throw exception;
_L1:
        for(int i = 0; i < arraylist.size(); i++)
            ((ActionListener)arraylist.get(i)).actionPerformed(actionevent);

        return;
    }

    private Throwable A;
    private String E;
    private String L;
    private String H;
    private Action B;
    private Action F;
    private JButton G;
    private boolean I;
    private JComponent K;
    private JComponent C;
    private transient ArrayList D;
    private int J;

}
