// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import C.H.H;
import C.K.G;
import C.K.M;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.text.AttributedString;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicHTML;

// Referenced classes of package C.J:
//            p, J, DA, Y

public abstract class k
{
    static final class _F
        implements _H, _E, _B
    {
        static class _A
        {

            double B;
            float C;
            float A;
            String D;

            _A(String s1, Font font, FontRenderContext fontrendercontext)
            {
                D = s1;
                TextLayout textlayout = new TextLayout(s1, font, fontrendercontext);
                Rectangle2D rectangle2d = font.getStringBounds(D, fontrendercontext);
                B = rectangle2d.getWidth();
                C = textlayout.getAscent();
                A = textlayout.getDescent();
            }
        }


        public void A(k k1, Graphics2D graphics2d)
        {
            Graphics2D graphics2d1;
            if(!k1._)
                return;
            graphics2d1 = graphics2d;
            G g1 = k1.A();
            double d1 = g1.T();
            double d2 = g1.U();
            double d3 = g1.Q();
            double d4 = g1.R();
            double d5 = d1 + 0.5D * d3;
            double d6 = d2 + 0.5D * d4;
            d3 = k1.m;
            d4 = k1.f;
            d1 = d5 - 0.5D * d3;
            d2 = d6 - 0.5D * d4;
            if(k1.V != 0.0F)
            {
                graphics2d = (Graphics2D)graphics2d.create();
                graphics2d.rotate(Math.toRadians(k1.V), d5, d6);
            }
            k1.C(graphics2d, d1, d2, d3, d4);
            if(graphics2d != graphics2d1)
                graphics2d.dispose();
            break MISSING_BLOCK_LABEL_172;
            Exception exception;
            exception;
            if(graphics2d != graphics2d1)
                graphics2d.dispose();
            throw exception;
        }

        public void B(k k1, Graphics2D graphics2d, double d1, double d2, double d3, double d4)
        {
            double d5;
            double d6;
            if(k1.S != null)
            {
                double ad[] = B(k1, C.J.J.A().F);
                k1.S.paintIcon(null, graphics2d, (int)(d1 + ad[0]), (int)(d2 + ad[1]));
                C(k1, ad);
                d5 = ad[0];
                d6 = ad[1];
            } else
            {
                Insets insets = k1.a != null ? k1.a : k.i;
                d5 = d3 - (double)(insets.left + insets.right);
                d6 = d4 - (double)(insets.top + insets.bottom);
            }
            if(k1.R.length() > 0)
            {
                Color color = graphics2d.getColor();
                Font font = graphics2d.getFont();
                graphics2d.setColor(k1.h);
                graphics2d.setFont(k1.o);
                if(BasicHTML.isHTMLString(k1.R) && k.O)
                {
                    J j1 = C.J.J.A();
                    A(j1.I, k1);
                    double ad1[] = A(k1, C.J.J.A().F);
                    d1 += ad1[0];
                    d2 += ad1[1];
                    SwingUtilities.paintComponent(graphics2d, j1.I, j1.C, (int)d1, (int)d2, (int)d5, (int)d6);
                } else
                if(k1.h != null)
                {
                    Object obj = k1.T;
                    if(obj instanceof ArrayList)
                    {
                        ArrayList arraylist = (ArrayList)obj;
                        double ad3[] = A(k1, C.J.J.A().F);
                        double d8 = 0.0D;
                        d1 += ad3[0];
                        d2 += ad3[1];
                        for(int i1 = 0; i1 < arraylist.size(); i1++)
                        {
                            _A _la1 = (_A)arraylist.get(i1);
                            d2 += _la1.C;
                            double d9;
                            switch(k1.K)
                            {
                            case 0: // '\0'
                                d9 = 0.0D;
                                break;

                            case 1: // '\001'
                                d9 = (d5 - _la1.B) / 2D;
                                break;

                            case 2: // '\002'
                                d9 = d5 - _la1.B;
                                break;

                            default:
                                d9 = 0.0D;
                                break;
                            }
                            graphics2d.drawString(_la1.D, (float)(d1 + d9), (float)d2);
                            d2 += _la1.A;
                            if(k1.k)
                            {
                                java.awt.geom.Line2D.Double double2 = C.J.J.A().L;
                                double2.x1 = d1;
                                double2.y1 = double2.y2 = d2;
                                double2.x2 = d1 + d5;
                                graphics2d.draw(double2);
                            }
                        }

                    } else
                    if(obj instanceof _A)
                    {
                        double ad2[] = A(k1, C.J.J.A().F);
                        double d7 = 0.0D;
                        d1 += ad2[0];
                        d2 += ad2[1];
                        _A _la = (_A)obj;
                        d2 += _la.C;
                        switch(k1.K)
                        {
                        case 0: // '\0'
                            d7 = 0.0D;
                            break;

                        case 1: // '\001'
                            d7 = (d5 - _la.B) / 2D;
                            break;

                        case 2: // '\002'
                            d7 = d5 - _la.B;
                            break;

                        default:
                            d7 = 0.0D;
                            break;
                        }
                        graphics2d.drawString(_la.D, (float)(d1 + d7), (float)d2);
                        d2 += _la.A;
                        if(k1.k)
                        {
                            java.awt.geom.Line2D.Double double1 = C.J.J.A().L;
                            double1.x1 = d1;
                            double1.y1 = double1.y2 = d2;
                            double1.x2 = d1 + d5;
                            graphics2d.draw(double1);
                        }
                    }
                }
                graphics2d.setFont(font);
                graphics2d.setColor(color);
            }
        }

        public void A(k k1, Graphics2D graphics2d, double d1, double d2, double d3, double d4)
        {
            Color color = graphics2d.getColor();
            java.awt.geom.Rectangle2D.Double double1 = null;
            if(k1.L != null)
            {
                graphics2d.setColor(k1.L);
                double1 = C.J.J.A().J;
                double1.setFrame(d1, d2, d3, d4);
                graphics2d.fill(double1);
            }
            if(k1.p != null)
            {
                graphics2d.setColor(k1.p);
                if(double1 == null)
                {
                    double1 = C.J.J.A().J;
                    double1.setFrame(d1, d2, d3, d4);
                }
                graphics2d.draw(double1);
            }
            graphics2d.setColor(color);
        }

        void C(k k1, double ad[])
        {
            if(BasicHTML.isHTMLString(k1.R) && k.O)
            {
                JLabel jlabel = C.J.J.A().I;
                A(jlabel, k1);
                ad[0] = jlabel.getWidth();
                ad[1] = jlabel.getHeight();
            } else
            {
                double d1 = 0.0D;
                double d2 = 0.0D;
                Object obj = k1.T;
                if(obj instanceof ArrayList)
                {
                    ArrayList arraylist = (ArrayList)obj;
                    for(int i1 = arraylist.size() - 1; i1 >= 0; i1--)
                    {
                        _A _la1 = (_A)arraylist.get(i1);
                        if(_la1.B > d1)
                            d1 = _la1.B;
                        d2 += _la1.C + _la1.A;
                    }

                } else
                if(obj instanceof _A)
                {
                    _A _la = (_A)obj;
                    if(_la.B > d1)
                        d1 = _la.B;
                    d2 += _la.C + _la.A;
                }
                ad[0] = d1;
                ad[1] = d2;
            }
        }

        double[] B(k k1, double ad[])
        {
            if(k1.S == null)
                return null;
            Insets insets = k1.a != null ? k1.a : k.i;
            double d1 = insets.left;
            double d2 = insets.top;
            C(k1, ad);
            double d3 = ad[0];
            double d4 = ad[1];
            double d5 = k1.S.getIconWidth();
            double d6 = k1.S.getIconHeight();
            if(k1.b == 2 && d3 > d5)
                d1 += 0.5D * (d3 - d5);
            else
            if(k1.b == 8)
                d1 += d3 + (double)k1.X;
            else
            if(k1.b == 64)
                d1 += Math.max(d3, d5) - d5;
            if(k1.W == 2 && d4 > d6)
                d2 += 0.5D * (d4 - d6);
            else
            if(k1.W == 1)
                switch(k1.b)
                {
                case 2: // '\002'
                case 32: // ' '
                case 64: // '@'
                    d2 += d4 + (double)k1.X;
                    break;

                default:
                    if(d4 > d6)
                        d2 += d4 - d6;
                    break;
                }
            ad[0] = d1;
            ad[1] = d2;
            return ad;
        }

        double[] A(k k1, double ad[])
        {
            Insets insets = k1.a != null ? k1.a : k.i;
            double d1 = insets.left;
            double d2 = insets.top;
            if(k1.S != null)
            {
                C(k1, ad);
                double d3 = ad[0];
                double d4 = ad[1];
                double d5 = k1.S.getIconWidth();
                double d6 = k1.S.getIconHeight();
                if(k1.b == 2 && d5 > d3)
                    d1 += 0.5D * (d5 - d3);
                else
                if(k1.b == 16)
                    d1 += d5 + (double)k1.X;
                else
                if(k1.b == 64)
                    d1 += Math.max(d3, d5) - d3;
                if(k1.W == 2 && d6 > d4)
                    d2 += 0.5D * (d6 - d4);
                else
                if(k1.W == 4)
                    switch(k1.b)
                    {
                    case 2: // '\002'
                    case 32: // ' '
                    case 64: // '@'
                        d2 += d6 + (double)k1.X;
                        break;

                    default:
                        if(d6 > d4)
                            d2 += d6 - d4;
                        break;
                    }
            }
            ad[0] = d1;
            ad[1] = d2;
            return ad;
        }

        void A(JLabel jlabel, k k1)
        {
            jlabel.setText(k1.R);
            jlabel.setFont(k1.o);
            jlabel.setBackground(k1.L);
            jlabel.setForeground(k1.h);
            Dimension dimension = jlabel.getPreferredSize();
            jlabel.setSize(dimension.width, dimension.height);
        }

        public void A(k k1, FontRenderContext fontrendercontext)
        {
            double d1 = 0.0D;
            double d2 = 0.0D;
            if(BasicHTML.isHTMLString(k1.R) && k.O)
            {
                k1.T = null;
                if(k1.a() != 4)
                {
                    JLabel jlabel = C.J.J.A().I;
                    A(jlabel, k1);
                    d1 = jlabel.getWidth();
                    d2 = jlabel.getHeight();
                }
            } else
            {
                ArrayList arraylist = new ArrayList(5);
                int i1 = 0;
                String s1 = k1.R;
                do
                {
                    i1 = s1.indexOf("\n");
                    if(i1 < 0)
                        break;
                    String s2 = s1.substring(0, i1);
                    if(s2.length() == 0)
                        s2 = " ";
                    arraylist.add(new _A(s2, k1.o, fontrendercontext));
                    s1 = s1.substring(i1 + 1);
                } while(i1 >= 0);
                if(s1.length() > 0)
                    arraylist.add(new _A(s1, k1.o, fontrendercontext));
                d1 = d2 = 0.0D;
                for(int j1 = arraylist.size() - 1; j1 >= 0; j1--)
                {
                    _A _la = (_A)arraylist.get(j1);
                    if(_la.B > d1)
                        d1 = _la.B;
                    d2 += _la.C + _la.A;
                }

                if(arraylist.size() == 1)
                {
                    k1.T = arraylist.get(0);
                } else
                {
                    arraylist.trimToSize();
                    k1.T = arraylist;
                }
            }
            if(k1.a() != 4 && k1.S != null)
                switch(k1.b)
                {
                case 2: // '\002'
                case 32: // ' '
                case 64: // '@'
                    d1 = Math.max(d1, k1.S.getIconWidth());
                    if(k1.W != 2)
                        d2 += k1.S.getIconHeight() + k1.X;
                    else
                        d2 = Math.max(d2, k1.S.getIconHeight());
                    break;

                default:
                    if(k1.b == 32)
                    {
                        d1 = Math.max(d1, k1.S.getIconWidth());
                        if(k1.W != 2)
                            d2 += k1.S.getIconHeight() + k1.X;
                        else
                            d2 = Math.max(d2, k1.S.getIconHeight());
                    } else
                    {
                        d2 = Math.max(d2, k1.S.getIconHeight());
                        d1 += k1.S.getIconWidth() + k1.X;
                    }
                    break;
                }
            if(k1.a() == 4)
            {
                d1 = k1.m;
                d2 = k1.f;
            } else
            {
                Insets insets = k1.a != null ? k1.a : k.i;
                d1 += insets.left + insets.right;
                d2 += insets.top + insets.bottom;
            }
            k1.C(d1, d2);
        }

        static final _F A = new _F();


        _F()
        {
        }
    }

    static final class _G
        implements _H
    {

        public void A(k k1, Graphics2D graphics2d)
        {
            Graphics2D graphics2d1;
            if(!k1._)
                return;
            graphics2d1 = graphics2d;
            G g1 = k1.A();
            double d1 = g1.T();
            double d2 = g1.U();
            double d3 = g1.Q();
            double d4 = g1.R();
            double d5 = d1 + 0.5D * d3;
            double d6 = d2 + 0.5D * d4;
            d3 = k1.m;
            d4 = k1.f;
            d1 = d5 - 0.5D * d3;
            d2 = d6 - 0.5D * d4;
            if(k1.V != 0.0F)
            {
                graphics2d = (Graphics2D)graphics2d.create();
                graphics2d.rotate(Math.toRadians(k1.V), d5, d6);
            }
            k1.C(graphics2d, d1, d2, d3, d4);
            if(graphics2d != graphics2d1)
                graphics2d.dispose();
            break MISSING_BLOCK_LABEL_172;
            Exception exception;
            exception;
            if(graphics2d != graphics2d1)
                graphics2d.dispose();
            throw exception;
        }

        public void B(k k1, Graphics2D graphics2d, double d1, double d2, double d3, double d4)
        {
            float f1;
            float f2;
            Color color;
            HashMap hashmap;
            java.awt.Shape shape;
            LineBreakMeasurer linebreakmeasurer;
            int i1;
            boolean flag;
            boolean flag1;
            if(k1.R.length() <= 0 || k1.h == null)
                break MISSING_BLOCK_LABEL_1139;
            Insets insets = k1.N();
            if(insets == null)
                insets = k.i;
            f1 = (float)d1 + (float)insets.left;
            f2 = (float)d2 + (float)insets.top;
            d3 -= insets.left + insets.right;
            d4 -= insets.top + insets.bottom;
            if(d3 <= 0.0D || d4 <= 0.0D)
                return;
            color = graphics2d.getColor();
            graphics2d.setColor(k1.h);
            hashmap = new HashMap();
            hashmap.put(TextAttribute.FONT, k1.o);
            if(k1.k)
                hashmap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
            shape = graphics2d.getClip();
            graphics2d.clip(new java.awt.geom.Rectangle2D.Double(d1 + (double)insets.left, d2 + (double)insets.top, d3, d4));
            linebreakmeasurer = new LineBreakMeasurer((new AttributedString(k1.R, hashmap)).getIterator(), graphics2d.getFontRenderContext());
            i1 = graphics2d.getFontMetrics(k1.o).getHeight() - 3;
            flag = k1.K == 2;
            flag1 = k1.K == 1;
            int j1;
            j1 = k1.R.indexOf('\n');
            if(j1 == -1)
                j1 = k1.R.length();
            do
            {
                if(j1 > linebreakmeasurer.getPosition() || linebreakmeasurer.getPosition() >= k1.R.length())
                    break;
                TextLayout textlayout = linebreakmeasurer.nextLayout(100F, j1 + 1, false);
                f2 += textlayout.getAscent() + textlayout.getLeading() + textlayout.getDescent();
                j1 = k1.R.indexOf('\n', j1 + 1);
                if(j1 == -1)
                    j1 = k1.R.length();
            } while(true);
_L5:
            if(linebreakmeasurer.getPosition() >= k1.R.length())
                break MISSING_BLOCK_LABEL_1107;
            if(d2 + d4 >= (double)(f2 + (float)(2 * i1))) goto _L2; else goto _L1
_L1:
            TextLayout textlayout1;
            float f3;
            textlayout1 = new TextLayout("\u2026", hashmap, graphics2d.getFontRenderContext());
            f3 = textlayout1.getAdvance();
            if(linebreakmeasurer.nextOffset((float)d3, j1, false) < k1.R.length()) goto _L4; else goto _L3
_L3:
            TextLayout textlayout2 = linebreakmeasurer.nextLayout((float)d3);
            if(textlayout2 == null)
            {
                graphics2d.setClip(shape);
                graphics2d.setColor(color);
                return;
            }
            f2 += textlayout2.getAscent();
            float f7 = flag1 ? ((float)d3 - textlayout2.getAdvance()) * 0.5F : !textlayout2.isLeftToRight() || flag ? (float)d3 - textlayout2.getAdvance() : 0.0F;
            textlayout2.draw(graphics2d, f1 + f7, f2);
            graphics2d.setClip(shape);
            graphics2d.setColor(color);
            return;
_L4:
            if(d3 <= (double)f3)
                break MISSING_BLOCK_LABEL_858;
            TextLayout textlayout3 = linebreakmeasurer.nextLayout((float)d3 - f3, j1, false);
            if(linebreakmeasurer.getPosition() == j1)
            {
                j1 = k1.R.indexOf('\n', j1 + 1);
                if(j1 == -1)
                    j1 = k1.R.length();
            }
            if(textlayout3 == null)
                break MISSING_BLOCK_LABEL_845;
            f2 += textlayout3.getAscent();
            if(linebreakmeasurer.getPosition() < k1.R.length())
            {
                float f8 = textlayout3.getAdvance() + textlayout1.getAdvance();
                float f10 = flag1 ? ((float)d3 - f8) * 0.5F : !textlayout3.isLeftToRight() || flag ? (float)d3 - f8 : 0.0F;
                textlayout3.draw(graphics2d, f1 + f10, f2);
                float f11 = f10 + textlayout3.getAdvance();
                textlayout1.draw(graphics2d, f1 + f11, f2);
            } else
            {
                float f9 = flag1 ? ((float)d3 - textlayout3.getAdvance()) * 0.5F : !textlayout3.isLeftToRight() || flag ? (float)d3 - textlayout3.getAdvance() : 0.0F;
                textlayout3.draw(graphics2d, f1 + f9, f2);
            }
            graphics2d.setClip(shape);
            graphics2d.setColor(color);
            return;
            graphics2d.setClip(shape);
            graphics2d.setColor(color);
            return;
            f2 += textlayout1.getAscent();
            float f5 = flag1 ? ((float)d3 - textlayout1.getAdvance()) * 0.5F : !textlayout1.isLeftToRight() || flag ? (float)d3 - textlayout1.getAdvance() : 0.0F;
            textlayout1.draw(graphics2d, f1 + f5, f2);
            graphics2d.setClip(shape);
            graphics2d.setColor(color);
            return;
_L2:
            textlayout1 = linebreakmeasurer.nextLayout((float)d3, j1, false);
            if(textlayout1 == null)
            {
                graphics2d.setClip(shape);
                graphics2d.setColor(color);
                return;
            }
            if(linebreakmeasurer.getPosition() == j1)
            {
                j1 = k1.R.indexOf('\n', j1 + 1);
                if(j1 == -1)
                    j1 = k1.R.length();
            }
            f2 += textlayout1.getAscent();
            float f4 = flag1 ? ((float)d3 - textlayout1.getAdvance()) * 0.5F : !textlayout1.isLeftToRight() || flag ? (float)d3 - textlayout1.getAdvance() : 0.0F;
            float f6 = textlayout1.getDescent() + textlayout1.getLeading();
            textlayout1.draw(graphics2d, f1 + f4, f2);
            f2 += f6;
              goto _L5
            graphics2d.setClip(shape);
            graphics2d.setColor(color);
            break MISSING_BLOCK_LABEL_1139;
            Exception exception;
            exception;
            graphics2d.setClip(shape);
            graphics2d.setColor(color);
            throw exception;
        }

        public void A(k k1, Graphics2D graphics2d, double d1, double d2, double d3, double d4)
        {
            Color color = graphics2d.getColor();
            java.awt.geom.Rectangle2D.Double double1 = null;
            if(k1.L != null)
            {
                graphics2d.setColor(k1.L);
                double1 = C.J.J.A().J;
                double1.setFrame(d1, d2, d3, d4);
                graphics2d.fill(double1);
            }
            if(k1.p != null)
            {
                graphics2d.setColor(k1.p);
                if(double1 == null)
                {
                    double1 = C.J.J.A().J;
                    double1.setFrame(d1, d2, d3, d4);
                }
                graphics2d.draw(double1);
            }
            graphics2d.setColor(color);
        }

        public void A(k k1, FontRenderContext fontrendercontext, byte byte0)
        {
            switch(byte0)
            {
            case 3: // '\003'
            case 4: // '\004'
            default:
                break;

            case 1: // '\001'
                if(k1.R.length() > 0)
                {
                    Insets insets = k1.N();
                    if(insets == null)
                        insets = k.i;
                    Y y = ((DA)k1).x();
                    if(y == null)
                        return;
                    double d1 = y.B();
                    double d2 = 0.0D;
                    double d3 = 1.7976931348623157E+308D;
                    float f1 = (float)d2 + (float)insets.top;
                    d1 -= insets.left + insets.right;
                    if(d1 <= 0.0D || d3 <= 0.0D)
                        return;
                    HashMap hashmap1 = new HashMap();
                    hashmap1.put(TextAttribute.FONT, k1.o);
                    if(k1.k)
                        hashmap1.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    for(LineBreakMeasurer linebreakmeasurer = new LineBreakMeasurer((new AttributedString(k1.R, hashmap1)).getIterator(), fontrendercontext); linebreakmeasurer.getPosition() < k1.R.length();)
                    {
                        TextLayout textlayout1 = linebreakmeasurer.nextLayout((float)d1);
                        if(textlayout1 == null)
                            return;
                        f1 += textlayout1.getAscent() + textlayout1.getDescent() + textlayout1.getLeading();
                    }

                    k1.C(d1, f1 + 2.0F + (float)insets.bottom);
                }
                break;

            case 0: // '\0'
            case 2: // '\002'
                HashMap hashmap = new HashMap();
                hashmap.put(TextAttribute.FONT, k1.o);
                if(k1.k)
                    hashmap.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                if(k1.R.length() <= 0)
                    break;
                java.text.AttributedCharacterIterator attributedcharacteriterator = (new AttributedString(k1.R, hashmap)).getIterator();
                TextLayout textlayout = new TextLayout(attributedcharacteriterator, fontrendercontext);
                textlayout.getAdvance();
                Insets insets1 = k1.N();
                if(insets1 == null)
                    insets1 = k.i;
                k1.C(textlayout.getAdvance() + (float)insets1.left + (float)insets1.right + 3F, (float)(3 + insets1.top + insets1.bottom) + textlayout.getAscent() + textlayout.getDescent() + textlayout.getLeading());
                break;
            }
        }

        static final _G B = new _G();


        _G()
        {
        }
    }

    public static interface _C
    {

        public abstract void A(k k1, Object obj, ObjectOutputStream objectoutputstream)
            throws IOException;

        public abstract Object A(k k1, ObjectInputStream objectinputstream)
            throws IOException;

        public abstract Object A(k k1, Object obj, k k2);
    }

    public static interface _B
    {
    }

    public static interface _E
    {

        public abstract void A(k k1, FontRenderContext fontrendercontext);
    }

    public static interface _H
    {

        public abstract void A(k k1, Graphics2D graphics2d);

        public abstract void B(k k1, Graphics2D graphics2d, double d1, double d2, double d3, double d4);

        public abstract void A(k k1, Graphics2D graphics2d, double d1, double d2, double d3, double d4);
    }

    static final class _D
    {

        final _H B;
        final String C;
        final _E D;
        final _B A;
        final _C E;

        public _D(Map map, Map map1, String s1)
        {
            HashMap hashmap = new HashMap();
            hashmap.putAll(map1);
            hashmap.putAll(map);
            B = (_H)hashmap.get(k.class$C$J$k$_H != null ? ((Object) (k.class$C$J$k$_H)) : ((Object) (k.class$C$J$k$_H = k._mthclass$("C.J.k$_H"))));
            D = (_E)hashmap.get(k.class$C$J$k$_E != null ? ((Object) (k.class$C$J$k$_E)) : ((Object) (k.class$C$J$k$_E = k._mthclass$("C.J.k$_E"))));
            A = (_B)map.get(k.class$C$J$k$_B != null ? ((Object) (k.class$C$J$k$_B)) : ((Object) (k.class$C$J$k$_B = k._mthclass$("C.J.k$_B"))));
            E = (_C)map.get(k.class$C$J$k$_C != null ? ((Object) (k.class$C$J$k$_C)) : ((Object) (k.class$C$J$k$_C = k._mthclass$("C.J.k$_C"))));
            C = s1;
        }
    }

    public static final class _A
    {

        public void A(String s1, Map map)
        {
            if(s1 == null)
            {
                throw new NullPointerException("description");
            } else
            {
                _D _ld = new _D(map, C, s1);
                B.put(s1, _ld);
                return;
            }
        }

        public void A(k k1, String s1)
        {
            if(s1 == null)
            {
                k1.l = k1.d();
            } else
            {
                _D _ld = (_D)B.get(s1);
                if(_ld != null)
                {
                    if(k1.l != _ld)
                        k1.l = _ld;
                } else
                {
                    throw new IllegalArgumentException("Unregistered configuration: " + s1);
                }
            }
            k1.t();
            k1.l();
        }

        private final Map C;
        Map B;
        Set A;

        _A(Map map)
        {
            B = new HashMap();
            A = Collections.unmodifiableSet(B.keySet());
            C = map;
        }
    }


    public Object Z()
    {
        return P;
    }

    public void B(Object obj)
    {
        P = obj;
    }

    public double r()
    {
        return m;
    }

    public void C(double d1)
    {
        m = d1;
        l();
    }

    public double O()
    {
        return f;
    }

    public void A(double d1)
    {
        f = d1;
        l();
    }

    public void C(double d1, double d2)
    {
        m = d1;
        f = d2;
        if(V != 0.0F)
        {
            double d3 = 0.0D;
            double d4 = 0.0D;
            double d5 = 0.0D;
            double d6 = 0.0D;
            java.awt.geom.Point2D.Double double1 = new java.awt.geom.Point2D.Double();
            AffineTransform affinetransform = AffineTransform.getRotateInstance(Math.toRadians(V));
            double1.x = -0.5D * d1;
            double1.y = -0.5D * d2;
            affinetransform.transform(double1, double1);
            d3 = Math.max(d3, double1.x);
            d4 = Math.max(d4, double1.y);
            d5 = Math.min(d5, double1.x);
            d6 = Math.min(d6, double1.y);
            double1.x = 0.5D * d1;
            double1.y = 0.5D * d2;
            affinetransform.transform(double1, double1);
            d3 = Math.max(d3, double1.x);
            d4 = Math.max(d4, double1.y);
            d5 = Math.min(d5, double1.x);
            d6 = Math.min(d6, double1.y);
            double1.x = -0.5D * d1;
            double1.y = 0.5D * d2;
            affinetransform.transform(double1, double1);
            d3 = Math.max(d3, double1.x);
            d4 = Math.max(d4, double1.y);
            d5 = Math.min(d5, double1.x);
            d6 = Math.min(d6, double1.y);
            double1.x = 0.5D * d1;
            double1.y = -0.5D * d2;
            affinetransform.transform(double1, double1);
            d3 = Math.max(d3, double1.x);
            d4 = Math.max(d4, double1.y);
            d5 = Math.min(d5, double1.x);
            d6 = Math.min(d6, double1.y);
            J = d3 - d5;
            M = d4 - d6;
        } else
        {
            J = m;
            M = f;
        }
    }

    protected k()
    {
        b = 2;
        W = 4;
        X = 4;
        _ = true;
        Z = 0;
        o = d;
        K = 1;
        h = Color.black;
        j = true;
        Y = true;
        l = d();
    }

    _D d()
    {
        throw new InternalError("Badly shrinked");
    }

    public void A(Graphics2D graphics2d)
    {
        l.B.A(this, graphics2d);
    }

    protected void B(Graphics2D graphics2d, double d1, double d2, double d3, 
            double d4)
    {
        l.B.A(this, graphics2d, d1, d2, d3, d4);
    }

    protected void A(Graphics2D graphics2d, double d1, double d2, double d3, 
            double d4)
    {
        l.B.B(this, graphics2d, d1, d2, d3, d4);
    }

    protected void C(Graphics2D graphics2d, double d1, double d2, double d3, 
            double d4)
    {
        B(graphics2d, d1, d2, d3, d4);
        A(graphics2d, d1, d2, d3, d4);
    }

    public boolean o()
    {
        return j;
    }

    public boolean n()
    {
        return Y;
    }

    public void l()
    {
        j = true;
        Y = true;
    }

    public void t()
    {
        Y = true;
    }

    public abstract void q();

    public void T()
    {
        A(n);
    }

    public void A(FontRenderContext fontrendercontext)
    {
        j = false;
        l.D.A(this, fontrendercontext);
    }

    public abstract G A();

    public void C(byte byte0)
    {
        W = byte0;
        l();
    }

    public byte h()
    {
        return W;
    }

    public void E(byte byte0)
    {
        b = byte0;
        l();
    }

    public byte Q()
    {
        return b;
    }

    public void G(byte byte0)
    {
        X = byte0;
        l();
    }

    public byte s()
    {
        return X;
    }

    public void B(boolean flag)
    {
        k = flag;
    }

    public boolean Y()
    {
        return k;
    }

    public void B(double d1)
    {
        d1 %= 360D;
        if(d1 < 0.0D)
            d1 += 360D;
        if(d1 != (double)V)
        {
            V = (float)d1;
            l();
        }
    }

    public double i()
    {
        return (double)V;
    }

    public void A(Insets insets)
    {
        a = insets;
        l();
    }

    public Insets N()
    {
        return a;
    }

    public void A(Icon icon)
    {
        S = icon;
        l();
    }

    public Icon j()
    {
        return S;
    }

    public void C(Color color)
    {
        h = color;
    }

    public Color S()
    {
        return h;
    }

    public boolean b()
    {
        return _;
    }

    public void A(boolean flag)
    {
        _ = flag;
    }

    public byte p()
    {
        throw new InternalError("Badly shrinked");
    }

    public void F(byte byte0)
    {
        throw new InternalError("Badly shrinked");
    }

    public byte m()
    {
        return N;
    }

    public void B(byte byte0)
    {
        throw new InternalError("Badly shrinked");
    }

    public void B(Color color)
    {
        L = color;
    }

    public Color M()
    {
        return L;
    }

    public void A(Color color)
    {
        p = color;
    }

    public Color e()
    {
        return p;
    }

    public void B(String s1)
    {
        if(s1 == null)
            R = "";
        else
        if(!s1.equals(R))
            R = s1;
        else
            return;
        l();
    }

    public String f()
    {
        return R;
    }

    public void E(double d1, double d2)
    {
        e = d1;
        c = d2;
        Y = false;
    }

    public double R()
    {
        if(n())
            q();
        return e;
    }

    public double U()
    {
        if(n())
            q();
        return c;
    }

    public void D(byte byte0)
    {
        K = byte0;
        t();
    }

    public byte c()
    {
        return K;
    }

    public abstract M _();

    void D(double d1, double d2)
    {
        if(j)
        {
            j = false;
            T();
        } else
        {
            j = false;
        }
        J = d1;
        M = d2;
    }

    public double g()
    {
        if(o())
            T();
        return J;
    }

    public double V()
    {
        if(o())
            T();
        return M;
    }

    public String toString()
    {
        return R;
    }

    public Font u()
    {
        return o;
    }

    public void A(Font font)
    {
        if(!font.equals(o))
        {
            o = font;
            l();
        }
    }

    public void A(String s1)
    {
        A(new Font(s1, o.getStyle(), o.getSize()));
    }

    public String P()
    {
        return o.getName();
    }

    public int W()
    {
        return o.getSize();
    }

    public void B(int i1)
    {
        A(o.deriveFont(i1));
    }

    public int k()
    {
        return o.getStyle();
    }

    public void A(int i1)
    {
        A(o.deriveFont(i1));
    }

    public void A(k k1)
    {
        B(k1.f());
        B(k1.m());
        A(k1.b());
        F(k1.p());
        B(k1.M());
        H(k1.a());
        C(k1.S());
        D(k1.c());
        A(k1.u());
        e = k1.e;
        c = k1.c;
        A(k1.e());
        A(k1.j());
        E(k1.Q());
        C(k1.h());
        G(k1.s());
        A(k1.N());
        B(k1.i());
        B(k1.Y());
        l = k1.l;
        if(l.E != null)
            P = l.E.A(k1, k1.P, this);
        else
            P = null;
        D(k1.g(), k1.V());
        C(k1.r(), k1.O());
    }

    public void A(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(10);
        objectoutputstream.writeFloat((float)e);
        objectoutputstream.writeFloat((float)c);
        objectoutputstream.writeByte(a());
        objectoutputstream.writeFloat((float)m);
        objectoutputstream.writeFloat((float)f);
        objectoutputstream.writeFloat(V);
        objectoutputstream.writeObject(f());
        objectoutputstream.writeByte(m());
        objectoutputstream.writeByte(p());
        objectoutputstream.writeBoolean(_);
        objectoutputstream.writeByte(K);
        objectoutputstream.writeObject(o);
        objectoutputstream.writeObject(h);
        objectoutputstream.writeObject(j());
        objectoutputstream.writeObject(L);
        objectoutputstream.writeObject(p);
        objectoutputstream.writeObject(a);
        objectoutputstream.writeByte(W);
        objectoutputstream.writeByte(b);
        objectoutputstream.writeByte(X);
        if(X() != null)
        {
            objectoutputstream.writeObject(X());
            if(l.E != null)
            {
                objectoutputstream.writeBoolean(true);
                l.E.A(this, Z(), objectoutputstream);
            } else
            {
                objectoutputstream.writeBoolean(false);
            }
        } else
        {
            objectoutputstream.writeObject(null);
        }
        objectoutputstream.writeBoolean(k);
    }

    public void C(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        switch(objectinputstream.readByte())
        {
        case 0: // '\0'
            objectinputstream.readByte();
            objectinputstream.readObject();
            o = A(objectinputstream);
            K = objectinputstream.readByte();
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            break;

        case 1: // '\001'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            break;

        case 2: // '\002'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            h = (Color)objectinputstream.readObject();
            break;

        case 3: // '\003'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            h = (Color)objectinputstream.readObject();
            A((Icon)objectinputstream.readObject());
            break;

        case 4: // '\004'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            h = (Color)objectinputstream.readObject();
            S = (Icon)objectinputstream.readObject();
            L = (Color)objectinputstream.readObject();
            p = (Color)objectinputstream.readObject();
            break;

        case 5: // '\005'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            h = (Color)objectinputstream.readObject();
            S = (Icon)objectinputstream.readObject();
            L = (Color)objectinputstream.readObject();
            p = (Color)objectinputstream.readObject();
            a = (Insets)objectinputstream.readObject();
            break;

        case 6: // '\006'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            V = objectinputstream.readShort();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            h = (Color)objectinputstream.readObject();
            S = (Icon)objectinputstream.readObject();
            L = (Color)objectinputstream.readObject();
            p = (Color)objectinputstream.readObject();
            a = (Insets)objectinputstream.readObject();
            break;

        case 7: // '\007'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            V = objectinputstream.readShort();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            h = (Color)objectinputstream.readObject();
            S = (Icon)objectinputstream.readObject();
            L = (Color)objectinputstream.readObject();
            p = (Color)objectinputstream.readObject();
            a = (Insets)objectinputstream.readObject();
            W = objectinputstream.readByte();
            b = objectinputstream.readByte();
            X = objectinputstream.readByte();
            break;

        case 8: // '\b'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            J = objectinputstream.readFloat();
            M = objectinputstream.readFloat();
            V = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            if(objectinputstream.readBoolean())
                B(Color.white);
            h = (Color)objectinputstream.readObject();
            S = (Icon)objectinputstream.readObject();
            L = (Color)objectinputstream.readObject();
            p = (Color)objectinputstream.readObject();
            a = (Insets)objectinputstream.readObject();
            W = objectinputstream.readByte();
            b = objectinputstream.readByte();
            X = objectinputstream.readByte();
            break;

        case 9: // '\t'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            Z = objectinputstream.readByte();
            m = objectinputstream.readFloat();
            f = objectinputstream.readFloat();
            V = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            h = (Color)objectinputstream.readObject();
            S = (Icon)objectinputstream.readObject();
            L = (Color)objectinputstream.readObject();
            p = (Color)objectinputstream.readObject();
            a = (Insets)objectinputstream.readObject();
            W = objectinputstream.readByte();
            b = objectinputstream.readByte();
            X = objectinputstream.readByte();
            B(objectinputstream);
            C(m, f);
            break;

        case 10: // '\n'
            E(objectinputstream.readFloat(), objectinputstream.readFloat());
            Z = objectinputstream.readByte();
            m = objectinputstream.readFloat();
            f = objectinputstream.readFloat();
            V = objectinputstream.readFloat();
            B((String)objectinputstream.readObject());
            B(objectinputstream.readByte());
            F(objectinputstream.readByte());
            _ = objectinputstream.readBoolean();
            K = objectinputstream.readByte();
            o = A(objectinputstream);
            h = (Color)objectinputstream.readObject();
            S = (Icon)objectinputstream.readObject();
            L = (Color)objectinputstream.readObject();
            p = (Color)objectinputstream.readObject();
            a = (Insets)objectinputstream.readObject();
            W = objectinputstream.readByte();
            b = objectinputstream.readByte();
            X = objectinputstream.readByte();
            B(objectinputstream);
            k = objectinputstream.readBoolean();
            C(m, f);
            break;

        default:
            throw new H();
        }
    }

    private void B(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        String s1 = (String)objectinputstream.readObject();
        if(s1 == null)
        {
            l = d();
        } else
        {
            C(s1);
            if(objectinputstream.readBoolean())
            {
                if(l.E == null)
                    throw new IOException("No user data handler found for configuration to read user data.");
                P = l.E.A(this, objectinputstream);
            } else
            {
                P = null;
            }
        }
    }

    public abstract void C(String s1);

    public String X()
    {
        return l == null ? null : l.C;
    }

    public void H(byte byte0)
    {
        Z = byte0;
        l();
    }

    public byte a()
    {
        return Z;
    }

    private Font A(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        Font font = (Font)objectinputstream.readObject();
        if(Q)
            font = new Font(font.getFontName(), font.getStyle(), Math.round(font.getSize2D()));
        return font;
    }

    static Class _mthclass$(String s1)
    {
        return Class.forName(s1);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    private static final FontRenderContext n = new FontRenderContext(new AffineTransform(), false, false);
    static boolean O = true;
    byte b;
    byte W;
    byte X;
    boolean k;
    protected double e;
    protected double c;
    protected double J;
    protected double M;
    protected double m;
    protected double f;
    String R;
    boolean _;
    Color L;
    Color p;
    Font o;
    byte K;
    protected byte N;
    protected byte g;
    protected boolean j;
    protected boolean Y;
    Object T;
    Object P;
    Icon S;
    Insets a;
    _D l;
    float V;
    Color h;
    byte Z;
    private static final Font d = new Font("Dialog", 0, 12);
    public static final Insets i = new Insets(2, 2, 2, 2);
    static final boolean Q;
    private static final _D U;

    static 
    {
        HashMap hashmap = new HashMap();
        hashmap.put(C.J.k$_E.class, _F.A);
        hashmap.put(C.J.k$_H.class, _F.A);
        hashmap.put(C.J.k$_B.class, _F.A);
        hashmap.put(C.J.k$_C.class, new p((byte)0));
        U = new _D(hashmap, hashmap, "default");
        boolean flag = false;
        try
        {
            String s1 = System.getProperty("os.name").toLowerCase();
            flag = s1.startsWith("mac");
        }
        catch(Exception exception) { }
        Q = flag;
    }
}
