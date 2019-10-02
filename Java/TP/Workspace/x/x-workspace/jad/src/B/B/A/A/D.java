// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A.A;

import java.awt.*;
import java.lang.reflect.Modifier;
import java.util.Map;

// Referenced classes of package B.B.A.A:
//            G, F, J, H, 
//            A, I, E, B

public class D
    implements G
{

    public D()
    {
        b = 0;
        _ = 0;
        p = 1.0F;
    }

    public void A(byte byte0)
    {
        switch(byte0)
        {
        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            b = byte0;
            break;

        default:
            throw new IllegalArgumentException();
        }
    }

    public byte A()
    {
        return b;
    }

    public void A(int i1)
    {
        _ = i1;
    }

    public int getIconHeight()
    {
        return (int)Math.ceil(B() * 16F);
    }

    public int getIconWidth()
    {
        return (int)Math.ceil(B() * 16F);
    }

    public void A(float f1)
    {
        p = f1;
    }

    public float B()
    {
        return p;
    }

    public void paintIcon(Component component, Graphics g1, int i1, int j1)
    {
        Graphics2D graphics2d = (Graphics2D)g1;
        graphics2d.translate(i1, j1);
        for(int k1 = 0; k1 < l.length; k1++)
        {
            l[k1] = null;
            n[k1] = f[k1] = 0;
        }

        switch(A())
        {
        default:
            break;

        case 0: // '\0'
            if(Modifier.isStatic(_))
                l[0] = j;
            else
                l[0] = o;
            if(Modifier.isPublic(_))
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 3F);
            } else
            if(Modifier.isPrivate(_))
            {
                n[0] = (int)Math.ceil(B() * 5F);
                f[0] = (int)Math.ceil(B() * 5F);
                l[1] = m;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 1.0F);
            } else
            if(Modifier.isProtected(_))
            {
                n[0] = (int)Math.ceil(B() * 5F);
                f[0] = (int)Math.ceil(B() * 5F);
                l[1] = d;
                n[1] = (int)Math.ceil(B() * 2.0F);
                f[1] = (int)Math.ceil(B() * 0.0F);
            } else
            {
                n[0] = (int)Math.ceil(B() * 5F);
                f[0] = (int)Math.ceil(B() * 5F);
                l[1] = g;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 1.0F);
            }
            break;

        case 1: // '\001'
            if(Modifier.isStatic(_))
                l[0] = a;
            else
                l[0] = c;
            if(Modifier.isPublic(_))
            {
                n[0] = (int)Math.ceil(B() * 2.0F);
                f[0] = (int)Math.ceil(B() * 2.0F);
            } else
            if(Modifier.isPrivate(_))
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 1.0F);
                l[1] = m;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 4F);
            } else
            if(Modifier.isProtected(_))
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 1.0F);
                l[1] = d;
                n[1] = (int)Math.ceil(B() * 2.0F);
                f[1] = (int)Math.ceil(B() * 4F);
            } else
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 1.0F);
                l[1] = g;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 5F);
            }
            if(Modifier.isStatic(_))
                ((F)l[0]).B(true);
            break;

        case 2: // '\002'
            if(Modifier.isStatic(_))
                l[0] = e;
            else
                l[0] = q;
            if(Modifier.isPublic(_))
            {
                n[0] = (int)Math.ceil(B() * 2.0F);
                f[0] = (int)Math.ceil(B() * 2.0F);
            } else
            if(Modifier.isPrivate(_))
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 3F);
                l[1] = m;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 1.0F);
            } else
            if(Modifier.isProtected(_))
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 3F);
                l[1] = d;
                n[1] = (int)Math.ceil(B() * 2.0F);
                f[1] = (int)Math.ceil(B() * 1.0F);
            } else
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 3F);
                l[1] = g;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 1.0F);
            }
            if(Modifier.isStatic(_))
                ((J)l[0]).D(true);
            break;

        case 3: // '\003'
            l[0] = k;
            if(Modifier.isPublic(_))
            {
                n[0] = (int)Math.ceil(B() * 2.0F);
                f[0] = (int)Math.ceil(B() * 2.0F);
                break;
            }
            if(Modifier.isPrivate(_))
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 1.0F);
                l[1] = m;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 4F);
                break;
            }
            if(Modifier.isProtected(_))
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 1.0F);
                l[1] = d;
                n[1] = (int)Math.ceil(B() * 2.0F);
                f[1] = (int)Math.ceil(B() * 4F);
            } else
            {
                n[0] = (int)Math.ceil(B() * 3F);
                f[0] = (int)Math.ceil(B() * 1.0F);
                l[1] = g;
                n[1] = (int)Math.ceil(B() * 1.0F);
                f[1] = (int)Math.ceil(B() * 5F);
            }
            break;

        case 4: // '\004'
            l[0] = Z;
            if(Modifier.isPublic(_))
            {
                n[0] = (int)Math.ceil(B() * 2.0F);
                f[0] = (int)Math.ceil(B() * 2.0F);
            }
            break;
        }
        for(int l1 = 0; l1 < l.length; l1++)
        {
            if(l[l1] == null)
                continue;
            l[l1].A(p);
            if(h != null)
                l[l1].A(h);
            l[l1].paintIcon(component, graphics2d, n[l1], f[l1]);
        }

        graphics2d.translate(-i1, -j1);
    }

    public void A(Map map)
    {
        h = map;
    }

    static boolean i = false;
    private byte b;
    private int _;
    private float p;
    private static final H o = new H();
    private static final H j;
    private static final F c = new F();
    private static final F a;
    private static final F k;
    private static final J q = new J();
    private static final J e;
    private static final A Z = new A();
    private static final I m = new I();
    private static final E d = new E();
    private static final B g = new B();
    private Map h;
    private final G l[] = new G[2];
    private final int n[] = new int[2];
    private final int f[] = new int[2];

    static 
    {
        j = new H();
        a = new F();
        k = new F();
        e = new J();
        j.C(true);
        a.B(true);
        e.D(true);
        k.A(true);
    }
}
