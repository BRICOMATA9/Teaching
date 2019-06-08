// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.J;

import java.io.*;
import java.lang.reflect.*;

// Referenced classes of package C.J:
//            HA, EA, k, Y, 
//            U

public class p
    implements HA._G, EA._G, k._C
{

    public p(byte byte0)
    {
        A = 0;
        A = byte0;
    }

    public Object A(Y y, Object obj, Y y1)
    {
        return A(obj);
    }

    protected Object A(Object obj)
    {
        if(obj == null)
            break MISSING_BLOCK_LABEL_122;
        Method method;
        if(!(obj instanceof Cloneable))
            break MISSING_BLOCK_LABEL_76;
        Class class1 = obj.getClass();
        method = class1.getMethod("clone", (Class[])null);
        if(Modifier.isPublic(method.getModifiers()))
            return method.invoke(obj, (Object[])null);
        break MISSING_BLOCK_LABEL_76;
        Object obj1;
        obj1;
        Throwable throwable = ((InvocationTargetException) (obj1)).getTargetException();
        if(throwable instanceof RuntimeException)
            throw (RuntimeException)throwable;
        break MISSING_BLOCK_LABEL_76;
        obj1;
        break MISSING_BLOCK_LABEL_76;
        obj1;
        switch(A)
        {
        case 2: // '\002'
        default:
            throw new IllegalArgumentException("Cloning failed.");

        case 0: // '\0'
            return obj;

        case 1: // '\001'
            return null;
        }
        return null;
    }

    public Object A(Y y, ObjectInputStream objectinputstream)
        throws IOException
    {
        return A(objectinputstream);
    }

    protected Object A(ObjectInputStream objectinputstream)
        throws IOException
    {
        return objectinputstream.readObject();
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        if(A == 1)
            return null;
        else
            throw new IOException(classnotfoundexception.getMessage());
    }

    public void A(Y y, Object obj, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        A(obj, objectoutputstream);
    }

    protected void A(Object obj, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        if(obj == null || (obj instanceof Serializable))
        {
            objectoutputstream.writeObject(obj);
        } else
        {
            if(A == 2)
                throw new IOException("Could not write userData.");
            objectoutputstream.writeObject(null);
        }
    }

    public void A(U u, Object obj, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        A(obj, objectoutputstream);
    }

    public Object A(U u, ObjectInputStream objectinputstream)
        throws IOException
    {
        return A(objectinputstream);
    }

    public Object A(U u, Object obj, U u1)
    {
        return A(obj);
    }

    public void A(k k1, Object obj, ObjectOutputStream objectoutputstream)
        throws IOException
    {
        A(obj, objectoutputstream);
    }

    public Object A(k k1, ObjectInputStream objectinputstream)
        throws IOException
    {
        return A(objectinputstream);
    }

    public Object A(k k1, Object obj, k k2)
    {
        return A(obj);
    }

    private byte A;
}
