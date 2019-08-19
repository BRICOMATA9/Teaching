// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package C.A;


// Referenced classes of package C.A:
//            Y, T, F

public class S extends Y
{
    class _A extends Y._B
        implements F
    {

        public T H()
        {
            return (T)D();
        }

        _A()
        {
        }
    }


    public S()
    {
    }

    public S(F f)
    {
        super(f);
    }

    public S(T at[])
    {
        for(int i = 0; i < at.length; i++)
            E(at[i]);

    }

    public S(T t)
    {
        E(t);
    }

    public F O()
    {
        return new _A();
    }

    public T N()
    {
        return (T)F();
    }

    public T M()
    {
        return (T)H();
    }

    public T P()
    {
        return (T)C();
    }

    public T[] Q()
    {
        return (T[])toArray(new T[size()]);
    }
}
