// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import C.A.I;
import C.A.Y;
import C.J.DA;
import C.J.K;
import C.J.N;
import C.J.U;
import C.J.Z;
import C.J.b;
import C.K.G;
import C.K.M;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

// Referenced classes of package C.H:
//            L, N, C

public class B extends L
{

    public B()
    {
        O = 10D;
        S = true;
        B(2);
        A(true);
    }

    public void A(b b1, InputStream inputstream)
    {
        throw new UnsupportedOperationException("read operation not supported");
    }

    public void A(b b1, OutputStream outputstream)
        throws IOException
    {
        A(D(b1), outputstream);
    }

    public String D(b b1)
    {
        StringBuffer stringbuffer = new StringBuffer();
        if(R != null)
        {
            K k = (K)b1.i();
            K k1 = k == null ? C(b1) : k;
            Rectangle rectangle = k1.getVisibleRect();
            double d = rectangle.getX();
            double d1 = rectangle.getY();
            double d2 = k1.h();
            Graphics2D graphics2d = (Graphics2D)(new BufferedImage(1, 1, 2)).getGraphics();
            graphics2d.setClip(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            final Y order = new Y();
            Z z = new Z() {

                protected void B(Graphics2D graphics2d1, C.J.Y y2)
                {
                    order.A(y2);
                }

                protected void A(Graphics2D graphics2d1, U u1)
                {
                    order.A(u1);
                }

            };
            if(k != null && (k.o() instanceof Z))
            {
                Z z1 = (Z)k.o();
                z.A(z1.A());
            }
            z.A(graphics2d, b1);
            boolean flag = order.isEmpty();
            if(!flag || !S)
            {
                stringbuffer.append("<map");
                stringbuffer.append(" name=\"");
                stringbuffer.append(R.B());
                stringbuffer.append("\">");
                stringbuffer.append(P);
            }
            do
            {
                if(order.isEmpty())
                    break;
                Object obj = order.C();
                if(obj instanceof C.J.Y)
                {
                    C.J.Y y = (C.J.Y)obj;
                    for(int i = 0; i < y.L(); i++)
                    {
                        DA da = y.A(i);
                        C c2 = R.A(da);
                        if(c2 != null)
                        {
                            double d4 = da.A().T() - d;
                            double d7 = da.A().U() - d1;
                            A(d4, d7, d4 + da.g(), d7 + da.V(), d2, c2, stringbuffer);
                        }
                    }

                    C c3 = R.A(y.Q());
                    if(c3 != null)
                    {
                        double d3 = y.C() - d;
                        double d5 = y.A() - d1;
                        A(d3, d5, d3 + y.B(), d5 + y.D(), d2, c3, stringbuffer);
                    }
                } else
                if(obj instanceof U)
                {
                    U u = (U)obj;
                    for(int j = 0; j < u.w(); j++)
                    {
                        N n = u.D(j);
                        C c = R.A(n);
                        if(c != null)
                        {
                            double d6 = n.A().T() - d;
                            double d8 = n.A().U() - d1;
                            A(d6, d8, d6 + n.g(), d8 + n.V(), d2, c, stringbuffer);
                        }
                    }

                    double ad[] = new double[8];
                    C c1 = R.A(u.C6());
                    if(c1 != null)
                    {
                        Object obj1 = u.B5();
                        BasicStroke basicstroke = new BasicStroke((float)O, 0, 0, 1.41F);
                        obj1 = basicstroke.createStrokedShape(((Shape) (obj1)));
                        PathIterator pathiterator = ((Shape) (obj1)).getPathIterator(new AffineTransform());
                        Y y1 = new Y();
                        for(; !pathiterator.isDone(); pathiterator.next())
                        {
                            pathiterator.currentSegment(ad);
                            y1.add(new M(ad[0] - d, ad[1] - d1));
                        }

                        A(y1, d2, c1, stringbuffer);
                    }
                }
            } while(true);
            if(!flag || !S)
            {
                stringbuffer.append("</map>");
                stringbuffer.append(P);
            }
            if(k == null)
                b1.B(k1);
        }
        return stringbuffer.toString();
    }

    public void A(boolean flag)
    {
        T = flag;
        if(flag)
            P = System.getProperty("line.separator");
        else
            P = "";
    }

    public void B(int i)
    {
        U = i;
        N.delete(0, N.length());
        for(int j = 0; j < i; j++)
            N.append(" ");

    }

    public K C(b b1)
    {
        K k = new K(b1);
        Rectangle rectangle = b1.X();
        Dimension dimension = new Dimension(rectangle.width, rectangle.height);
        k.setSize(dimension);
        k.setPreferredSize(dimension);
        k.B(rectangle.x - 10, rectangle.y - 10, rectangle.width + 20, rectangle.height + 20);
        return k;
    }

    public void B(C.H.N n)
    {
        R = n;
    }

    public String A()
    {
        return "html";
    }

    private void A(String s, OutputStream outputstream)
        throws IOException
    {
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(outputstream);
        BufferedWriter bufferedwriter = new BufferedWriter(outputstreamwriter);
        bufferedwriter.write(s.toString());
        bufferedwriter.flush();
        outputstreamwriter.flush();
    }

    private void A(double d, double d1, double d2, double d3, double d4, C c, StringBuffer stringbuffer)
    {
        stringbuffer.append(N);
        stringbuffer.append("<area");
        stringbuffer.append(" shape=\"rect\"");
        stringbuffer.append(" coords=\"");
        stringbuffer.append((int)(d * d4));
        stringbuffer.append(",");
        stringbuffer.append((int)(d1 * d4));
        stringbuffer.append(",");
        stringbuffer.append((int)(d2 * d4));
        stringbuffer.append(",");
        stringbuffer.append((int)(d3 * d4));
        stringbuffer.append("\"");
        if(c.A("href"))
        {
            stringbuffer.append(" href=\"");
            stringbuffer.append(c.B("href"));
            stringbuffer.append("\"");
        }
        stringbuffer.append(" alt=\"");
        if(c.A("alt"))
            stringbuffer.append(c.B("alt"));
        stringbuffer.append("\"");
        Iterator iterator = c.A();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            if(!"shape".equals(s) && !"coords".equals(s) && !"href".equals(s) && !"alt".equals(s))
            {
                stringbuffer.append(" ");
                stringbuffer.append(s);
                stringbuffer.append("=\"");
                stringbuffer.append(c.B(s));
                stringbuffer.append("\"");
            }
        } while(true);
        if(Q)
            stringbuffer.append('/');
        stringbuffer.append(">");
        stringbuffer.append(P);
    }

    private void A(Y y, double d, C c, StringBuffer stringbuffer)
    {
        stringbuffer.append(N);
        stringbuffer.append("<area");
        stringbuffer.append(" shape=\"poly\"");
        stringbuffer.append(" coords=\"");
        I i = y.B();
        do
        {
            if(!i.C())
                break;
            M m = (M)i.D();
            stringbuffer.append((int)(m.A * d));
            stringbuffer.append(",");
            stringbuffer.append((int)(m.D * d));
            i.B();
            if(i.C())
                stringbuffer.append(",");
        } while(true);
        stringbuffer.append("\"");
        if(c.A("href"))
        {
            stringbuffer.append(" href=\"");
            stringbuffer.append(c.B("href"));
            stringbuffer.append("\"");
        }
        stringbuffer.append(" alt=\"");
        if(c.A("alt"))
            stringbuffer.append(c.B("alt"));
        stringbuffer.append("\"");
        Iterator iterator = c.A();
        do
        {
            if(!iterator.hasNext())
                break;
            String s = (String)iterator.next();
            if(!"shape".equals(s) && !"coords".equals(s) && !"href".equals(s) && !"alt".equals(s))
            {
                stringbuffer.append(" ");
                stringbuffer.append(s);
                stringbuffer.append("=\"");
                stringbuffer.append(c.B(s));
                stringbuffer.append("\"");
            }
        } while(true);
        if(Q)
            stringbuffer.append('/');
        stringbuffer.append(">");
        stringbuffer.append(P);
    }

    private C.H.N R;
    private int U;
    private final StringBuffer N = new StringBuffer();
    private boolean T;
    private String P;
    private boolean Q;
    private double O;
    private boolean S;
}
