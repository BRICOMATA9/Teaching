// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.H;

import C.A.D;
import C.A.F;
import C.A.J;
import C.A.S;
import C.A.T;
import C.A.U;
import C.J.A;
import C.J.A.G;
import C.J.Y;
import C.J.b;
import C.J.c;
import C.J.g;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

// Referenced classes of package C.H:
//            L, H

public class M extends L
{
    public static interface _A
    {

        public abstract void A(b b1, Object obj, ObjectInputStream objectinputstream)
            throws IOException;

        public abstract void A(b b1, Object obj, ObjectOutputStream objectoutputstream)
            throws IOException;
    }


    public static void A(String s, String s1)
    {
        i.put(s, s1);
        k.put(s1, s);
    }

    public static String B(String s)
    {
        String s1 = (String)k.get(s);
        return s1 == null ? s : s1;
    }

    public static String C(String s)
    {
        String s1 = (String)i.get(s);
        return s1 == null ? s : s1;
    }

    public M()
    {
        f = new LinkedHashMap();
        b = false;
    }

    public String A()
    {
        return "ygf";
    }

    public void A(b b1, OutputStream outputstream)
        throws IOException
    {
        C.E.M.A(this, "writeOS");
        e = G.H(b1);
        ObjectOutputStream objectoutputstream = new ObjectOutputStream(outputstream);
        byte byte0 = 3;
        if(f.size() > 0)
            byte0 = 4;
        objectoutputstream.writeByte(byte0);
        objectoutputstream.flush();
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(outputstream);
        objectoutputstream = new ObjectOutputStream(gzipoutputstream);
        A(b1, objectoutputstream);
        if(byte0 > 3)
            B(b1, objectoutputstream);
        objectoutputstream.flush();
        gzipoutputstream.flush();
        gzipoutputstream.finish();
    }

    void B(b b1, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeInt(0x12345678);
        objectoutputstream.writeInt(f.size());
        java.util.Map.Entry entry;
        for(Iterator iterator = f.entrySet().iterator(); iterator.hasNext(); A(b1, (_A)entry.getValue(), objectoutputstream))
        {
            entry = (java.util.Map.Entry)iterator.next();
            objectoutputstream.writeObject(entry.getKey());
        }

    }

    void A(b b1, _A _pa, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        ObjectOutputStream objectoutputstream1 = new ObjectOutputStream(bytearrayoutputstream);
        _pa.A(b1, b1, objectoutputstream1);
        G g1 = b1.h();
        for(F f1 = b1.H(); f1.C(); f1.B())
        {
            T t = f1.H();
            _pa.A(b1, t, objectoutputstream1);
            if(g1 != null && g1.C(t))
                A((b)g1.P(t), _pa, objectoutputstream1);
        }

        for(U u = b1.M(); u.C(); u.B())
        {
            J j1 = u.I();
            _pa.A(b1, j1, objectoutputstream1);
        }

        objectoutputstream1.flush();
        objectoutputstream1.close();
        bytearrayoutputstream.flush();
        objectoutputstream.writeInt(bytearrayoutputstream.size());
        bytearrayoutputstream.writeTo(objectoutputstream);
    }

    protected void A(b b1, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        C.E.M.A(this, "writeOOS");
        objectoutputstream.writeByte(2);
        if(e != null)
            d = e.C();
        else
            d = false;
        boolean flag = e != null;
        objectoutputstream.writeBoolean(d);
        objectoutputstream.writeBoolean(flag);
        objectoutputstream.writeInt(b1.G());
        for(F f1 = b1.H(); f1.C(); f1.B())
            A(b1, f1.H(), objectoutputstream);

        objectoutputstream.writeInt(b1.F());
        for(U u = b1.M(); u.C(); u.B())
        {
            J j1 = u.I();
            objectoutputstream.writeInt(j1.G().Q());
            objectoutputstream.writeInt(j1.E().Q());
            A(b1, j1, objectoutputstream);
        }

    }

    protected void A(b b1, J j1, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(1);
        C(b1, j1, objectoutputstream);
        B(b1, j1, objectoutputstream);
    }

    protected void C(b b1, J j1, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        C.J.U u = b1.R(j1);
        objectoutputstream.writeObject(B(u.getClass().getName()));
        u.B(objectoutputstream);
    }

    protected void B(b b1, J j1, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        if(e == null)
            return;
        if(e.C(j1))
        {
            objectoutputstream.writeBoolean(true);
            T t = e.D(j1);
            if(t != j1.G())
            {
                objectoutputstream.writeBoolean(true);
                Object aobj[] = e.A(t);
                int i1;
                for(i1 = 1; i1 < aobj.length && aobj[i1] != j1.G(); i1++);
                objectoutputstream.writeInt(aobj.length - i1);
                for(i1++; i1 < aobj.length; i1++)
                    objectoutputstream.writeInt(((T)aobj[i1]).Q());

                objectoutputstream.writeInt(t.Q());
            } else
            {
                objectoutputstream.writeBoolean(false);
            }
            T t1 = e.B(j1);
            if(t1 != j1.E())
            {
                objectoutputstream.writeBoolean(true);
                Object aobj1[] = e.A(t1);
                int k1;
                for(k1 = 1; k1 < aobj1.length && aobj1[k1] != j1.E(); k1++);
                objectoutputstream.writeInt(aobj1.length - k1);
                for(k1++; k1 < aobj1.length; k1++)
                    objectoutputstream.writeInt(((T)aobj1[k1]).Q());

                objectoutputstream.writeInt(t1.Q());
            } else
            {
                objectoutputstream.writeBoolean(false);
            }
        } else
        {
            objectoutputstream.writeBoolean(false);
        }
    }

    protected void A(b b1, T t, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        objectoutputstream.writeByte(2);
        B(b1, t, objectoutputstream);
        D(b1, t, objectoutputstream);
        C(b1, t, objectoutputstream);
    }

    protected void B(b b1, T t, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        Y y = b1.U(t);
        objectoutputstream.writeObject(B(y.getClass().getName()));
        y.A(objectoutputstream);
        if((y instanceof A) && e == null)
            A(((A)y)._mth0106(), objectoutputstream);
    }

    protected void D(b b1, T t, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        if(e == null)
            return;
        if(e.C(t))
        {
            objectoutputstream.writeBoolean(true);
            A((b)e.P(t), objectoutputstream);
        } else
        {
            objectoutputstream.writeBoolean(false);
        }
    }

    protected void C(b b1, T t, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        if(e == null || !d)
            return;
        objectoutputstream.writeBoolean(e.A(t));
        T t1 = e.J(t);
        if(t1 != null && e.A(t1))
            objectoutputstream.writeInt(t1.Q());
        else
            objectoutputstream.writeInt(-1);
    }

    public void A(b b1, InputStream inputstream)
        throws IOException
    {
        ObjectInputStream objectinputstream;
        b1.N();
        objectinputstream = new ObjectInputStream(inputstream);
        c = objectinputstream.readByte();
        if(c > 2)
            objectinputstream = new ObjectInputStream(new GZIPInputStream(inputstream));
        e = G.H(b1);
        j = true;
        A(b1, objectinputstream);
        j = false;
        break MISSING_BLOCK_LABEL_82;
        Exception exception;
        exception;
        j = false;
        throw exception;
        if(c > 3)
            B(b1, objectinputstream);
        b1.P();
        return;
    }

    void B(b b1, ObjectInputStream objectinputstream)
        throws IOException
    {
        Object obj = null;
        int i1;
        i1 = 0;
        try
        {
            if(objectinputstream.readInt() != 0x12345678)
                return;
        }
        catch(EOFException eofexception)
        {
            return;
        }
        i1 = objectinputstream.readInt();
_L2:
        if(i1-- <= 0)
            break; /* Loop/switch isn't completed */
        try
        {
            obj = objectinputstream.readObject();
        }
        catch(EOFException eofexception1)
        {
            return;
        }
        try
        {
            _A _la = (_A)f.get(obj);
            if(_la != null)
                A(b1, _la, objectinputstream);
            else
                try
                {
                    int j1 = objectinputstream.readInt();
                    objectinputstream.skipBytes(j1);
                }
                catch(IOException ioexception)
                {
                    throw new IOException("Can't skip data registered with key " + obj);
                }
        }
        catch(ClassNotFoundException classnotfoundexception)
        {
            throw new IOException("Unable to read data." + classnotfoundexception.getMessage());
        }
        if(true) goto _L2; else goto _L1
_L1:
    }

    void A(b b1, _A _pa, ObjectInputStream objectinputstream)
        throws IOException
    {
        int i1 = objectinputstream.readInt();
        byte abyte0[] = new byte[i1];
        int k1;
        for(int j1 = 0; j1 < abyte0.length - 1; j1 += k1)
        {
            k1 = objectinputstream.read(abyte0, j1, abyte0.length - j1);
            if(k1 < 0)
                throw new EOFException("Unexpected end of file");
        }

        ObjectInputStream objectinputstream1 = new ObjectInputStream(new ByteArrayInputStream(abyte0));
        _pa.A(b1, b1, objectinputstream1);
        G g1 = b1.h();
        for(F f1 = b1.H(); f1.C(); f1.B())
        {
            T t = f1.H();
            _pa.A(b1, t, objectinputstream1);
            if(g1 != null && g1.C(t))
                A((b)g1.P(t), _pa, objectinputstream1);
        }

        for(U u = b1.M(); u.C(); u.B())
        {
            J j2 = u.I();
            _pa.A(b1, j2, objectinputstream1);
        }

        objectinputstream1.close();
    }

    protected void A(b b1, ObjectInputStream objectinputstream)
        throws IOException
    {
        C.E.M.A(this, "readOIS");
        C.E.M.A(this, "read Version");
        g g1 = new g();
        c c1 = new c();
        byte byte0;
        if(j)
        {
            if(c > 2)
                byte0 = objectinputstream.readByte();
            else
                byte0 = c;
            j = false;
        } else
        {
            byte0 = objectinputstream.readByte();
        }
        g = h = false;
        if(byte0 == 0)
            h = false;
        else
        if(byte0 == 1)
            h = objectinputstream.readBoolean();
        else
        if(byte0 == 2)
        {
            g = objectinputstream.readBoolean();
            h = objectinputstream.readBoolean();
        } else
        {
            throw new H(byte0);
        }
        C.E.M.A(this, "read nodes");
        int i1 = objectinputstream.readInt();
        T at[] = new T[i1];
        Object obj = null;
        int ai1[] = null;
        if(e != null || g)
        {
            int ai[] = new int[i1];
            ai1 = l;
            l = ai;
        }
        for(int j1 = 0; j1 < i1; j1++)
        {
            at[j1] = b1.B(g1);
            D(b1, at[j1], objectinputstream);
        }

        C.E.M.A(this, "read edges");
        int k1 = objectinputstream.readInt();
        for(int l1 = 0; l1 < k1; l1++)
        {
            T t = at[objectinputstream.readInt()];
            T t1 = at[objectinputstream.readInt()];
            J j3 = b1.A(t, t1, c1);
            C(b1, j3, objectinputstream);
        }

        if(g && e != null)
        {
            for(int i2 = 0; i2 < at.length; i2++)
            {
                int j2 = l[at[i2].Q()];
                if(j2 >= 0)
                    e.A(new S(at[i2]), at[j2]);
            }

        }
        l = ai1;
        C.E.M.A(this, "readOIS done");
    }

    protected void D(b b1, T t, ObjectInputStream objectinputstream)
        throws IOException
    {
        byte byte0 = objectinputstream.readByte();
        if(byte0 == 0)
            B(b1, t, objectinputstream);
        else
        if(byte0 == 1)
        {
            B(b1, t, objectinputstream);
            C(b1, t, objectinputstream);
        } else
        if(byte0 == 2)
        {
            B(b1, t, objectinputstream);
            C(b1, t, objectinputstream);
            A(b1, t, objectinputstream);
        } else
        {
            throw new H(byte0);
        }
    }

    protected void B(b b1, T t, ObjectInputStream objectinputstream)
        throws IOException
    {
        try
        {
            String s = (String)objectinputstream.readObject();
            s = C(s);
            Class class1 = Class.forName(s);
            Y y = (Y)class1.newInstance();
            b1.A(t, y);
            y.A(objectinputstream);
            if((y instanceof A) && !h)
            {
                b b2 = A(t);
                A(b2, objectinputstream);
            }
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(Exception exception)
        {
            throw new IOException(exception.toString());
        }
    }

    protected b A(T t)
    {
        return new b();
    }

    protected void C(b b1, T t, ObjectInputStream objectinputstream)
        throws IOException
    {
        if(!h)
            return;
        if(objectinputstream.readBoolean())
        {
            b b2;
            if(e != null)
            {
                e.I(t);
                b2 = (b)e.P(t);
            } else
            {
                b2 = A(t);
            }
            if(b1.U(t) instanceof A)
            {
                A a = (A)b1.U(t);
                a.A(b2);
            }
            A(b2, objectinputstream);
        }
    }

    protected void A(b b1, T t, ObjectInputStream objectinputstream)
        throws IOException
    {
        if(!g)
            return;
        boolean flag = objectinputstream.readBoolean();
        int i1 = objectinputstream.readInt();
        if(e != null)
        {
            if(flag)
                e.G(t);
            l[t.Q()] = i1;
        }
    }

    protected void C(b b1, J j1, ObjectInputStream objectinputstream)
        throws IOException
    {
        byte byte0 = objectinputstream.readByte();
        if(byte0 == 0)
            B(b1, j1, objectinputstream);
        else
        if(byte0 == 1)
        {
            B(b1, j1, objectinputstream);
            A(b1, j1, objectinputstream);
        } else
        {
            throw new H(byte0);
        }
    }

    protected void B(b b1, J j1, ObjectInputStream objectinputstream)
        throws IOException
    {
        try
        {
            Class class1 = Class.forName(C((String)objectinputstream.readObject()));
            C.J.U u = (C.J.U)class1.newInstance();
            b1.A(j1, u);
            u.G(objectinputstream);
        }
        catch(RuntimeException runtimeexception)
        {
            throw runtimeexception;
        }
        catch(Exception exception)
        {
            throw new IOException(exception.toString());
        }
    }

    protected void A(b b1, J j1, ObjectInputStream objectinputstream)
        throws IOException
    {
        if(!h)
            return;
        if(objectinputstream.readBoolean())
        {
            T t = j1.G();
            T t1 = j1.E();
            if(objectinputstream.readBoolean())
            {
                b b2 = b1;
                int i1 = objectinputstream.readInt();
                do
                {
                    int l1 = objectinputstream.readInt();
                    if(e != null)
                    {
                        D d1 = e.P(t);
                        t = A(d1, l1);
                    }
                } while(--i1 > 0);
            }
            if(objectinputstream.readBoolean())
            {
                b b3 = b1;
                int k1 = objectinputstream.readInt();
                do
                {
                    int i2 = objectinputstream.readInt();
                    if(e != null)
                    {
                        D d2 = e.P(t1);
                        t1 = A(d2, i2);
                    }
                } while(--k1 > 0);
            }
            if(e != null)
                e.A(j1, t, t1);
        }
    }

    private T A(D d1, int i1)
    {
        int j1 = 0;
        for(F f1 = d1.H(); f1.C();)
        {
            if(j1 == i1)
                return f1.H();
            f1.B();
            j1++;
        }

        return null;
    }

    static Class _mthclass$(String s)
    {
        return Class.forName(s);
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
    }

    private G e;
    private boolean h;
    private boolean g;
    private boolean d;
    private int l[];
    protected static Map i;
    protected static Map k = new HashMap();
    private Map f;
    boolean b;
    private boolean j;
    private byte c;

    static 
    {
        i = new HashMap();
        StringBuffer stringbuffer = new StringBuffer("y.view.");
        A(stringbuffer.toString() + "ShapeNodeRealizer", (C.J.g.class).getName());
        A(stringbuffer.toString() + "ImageNodeRealizer", (C.J.y.class).getName());
        A(stringbuffer.toString() + "Graph2DNodeRealizer", (C.J.A.class).getName());
        A(stringbuffer.toString() + "GenericNodeRealizer", (C.J.HA.class).getName());
        A(stringbuffer.toString() + "hierarchy.GroupNodeRealizer", (C.J.A.B.class).getName());
        A(stringbuffer.toString() + "ProxyShapeNodeRealizer", (C.J.X.class).getName());
        A(stringbuffer.toString() + "hierarchy.ProxyAutoBoundsNodeRealizer", (C.J.A.A.class).getName());
        A(stringbuffer.toString() + "PolyLineEdgeRealizer", (C.J.c.class).getName());
        A(stringbuffer.toString() + "QuadCurveEdgeRealizer", (C.J.e.class).getName());
        A(stringbuffer.toString() + "GenericEdgeRealizer", (C.J.EA.class).getName());
        A(stringbuffer.toString() + "ArcEdgeRealizer", (C.J.l.class).getName());
        A(stringbuffer.toString() + "BezierEdgeRealizer", (C.J.z.class).getName());
        A(stringbuffer.toString() + "SplineEdgeRealizer", (C.J.GA.class).getName());
        A(stringbuffer.toString() + "Port", (C.J.n.class).getName());
        A(stringbuffer.toString() + "InterfacePort", (C.J.CA.class).getName());
        stringbuffer.setLength(0);
        stringbuffer.append("demo.uml.");
        A(stringbuffer.toString() + "ClassNodeRealizer", "demo.uml.ClassNodeRealizer");
        A(stringbuffer.toString() + "NoteNodeRealizer", "demo.uml.NoteNodeRealizer");
        i.put(stringbuffer.toString() + "UMLClassNodeRealizer", "demo.uml.ClassNodeRealizer");
        i.put(stringbuffer.toString() + "UMLNoteNodeRealizer", "demo.uml.NoteNodeRealizer");
    }
}
