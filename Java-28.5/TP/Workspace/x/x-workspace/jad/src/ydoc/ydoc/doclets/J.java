// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import C.J.K;
import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.DocErrorReporter;
import com.sun.javadoc.RootDoc;
import com.sun.tools.doclets.Taglet;
import com.sun.tools.doclets.internal.toolkit.Configuration;
import com.sun.tools.doclets.internal.toolkit.WriterFactory;
import com.sun.tools.doclets.internal.toolkit.taglets.LegacyTaglet;
import com.sun.tools.doclets.internal.toolkit.taglets.TagletManager;
import com.sun.tools.doclets.internal.toolkit.util.Extern;
import com.sun.tools.doclets.internal.toolkit.util.MessageRetriever;
import com.sun.tools.doclets.standard.Standard;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ydoc.A.A.H;
import ydoc.A.D;
import ydoc.A.E;
import ydoc.A.G;
import ydoc.B.C;
import ydoc.filters.B;
import ydoc.resolvers.A;

// Referenced classes of package ydoc.doclets:
//            P, U, N

public abstract class J extends Configuration
{

    J(Configuration configuration)
    {
        D = configuration;
        E();
    }

    public final boolean B()
    {
        return I;
    }

    public final boolean D()
    {
        return C;
    }

    public final RootDoc H()
    {
        return root;
    }

    public final void B(RootDoc rootdoc)
    {
        root = rootdoc;
        D.root = rootdoc;
    }

    public final Extern F()
    {
        return D.extern;
    }

    public String getDocletSpecificBuildDate()
    {
        return D.getDocletSpecificBuildDate();
    }

    public final MessageRetriever getDocletSpecificMsg()
    {
        return D.getDocletSpecificMsg();
    }

    public final WriterFactory getWriterFactory()
    {
        return D.getWriterFactory();
    }

    public final Comparator getMemberComparator()
    {
        return D.getMemberComparator();
    }

    public void setSpecificDocletOptions(String as[][])
    {
        switch(ydoc.A.A.H.J().I())
        {
        default:
            break;

        case 56979: 
            if(B())
                ydoc.filters.B.A(new ydoc.filters.A(10));
            else
            if(!D());
            break;

        case -57985: 
            ydoc.filters.B.A(new ydoc.filters.A(0));
            break;

        case -59347: 
            ydoc.filters.B.A(new ydoc.filters.A(0));
            break;
        }
        E(as);
        A.setRootDirectory(new File(destDirName.length() <= 0 ? System.getProperty("user.dir") : destDirName));
    }

    public void setOptions()
    {
        String as[][];
        if(H() instanceof U)
            as = ((U)H()).D();
        else
            as = H().options();
        String as1[][] = new String[as.length][];
        int i = 0;
        for(int j = 0; j < as.length; j++)
        {
            String s = as[j][0].toLowerCase();
            if("-author".equals(s) || "-version".equals(s) || "-tag".equals(s) || "-taglet".equals(s) || "-tagletpath".equals(s))
            {
                as1[i++] = as[j];
                continue;
            }
            if("-nosince".equals(s))
            {
                as1[i++] = as[j];
                D.nosince = true;
            }
        }

        String as2[][] = new String[i][];
        System.arraycopy(as1, 0, as2, 0, i);
        D.setOptions(as2);
        super.setOptions();
    }

    public void setOptions(String as[][])
    {
        int i = 0;
        do
        {
            if(i >= as.length)
                break;
            String s = as[i].length <= 0 ? "" : as[i][0].toLowerCase();
            if("-d".equals(s))
            {
                destDirName = addTrailingFileSep(as[i][1]);
                docFileDestDirName = destDirName;
                break;
            }
            i++;
        } while(true);
    }

    public void C()
    {
        B(root.options());
    }

    public void B(String as[][])
    {
        ArrayList arraylist = new ArrayList();
        ydoc.filters.B.A();
        String s = null;
        String s1 = null;
        String s2 = null;
        String s3 = null;
        String s4 = null;
        String s5 = null;
        String s6 = null;
        for(int i = 0; i < as.length; i++)
        {
            String s7 = as[i].length <= 0 ? "" : as[i][0].toLowerCase();
            if("-docletpath".equals(s7))
            {
                s1 = as[i][1];
                continue;
            }
            if("-classpath".equals(s7))
            {
                s = as[i][1];
                continue;
            }
            if("-resourcepath".equals(s7))
            {
                s3 = as[i][1];
                continue;
            }
            if("-filter".equals(s7))
            {
                if(!arraylist.contains(as[i][1]))
                    arraylist.add(as[i][1]);
                continue;
            }
            if("-filterpath".equals(s7))
            {
                s2 = as[i][1];
                continue;
            }
            if("-license".equals(s7))
            {
                s4 = as[i][1];
                continue;
            }
            if("-public".equals(s7))
            {
                H = true;
                N = false;
                K = false;
                E = false;
                continue;
            }
            if("-protected".equals(s7))
            {
                H = true;
                N = true;
                K = false;
                E = false;
                continue;
            }
            if("-package".equals(s7))
            {
                H = true;
                N = true;
                K = true;
                E = false;
                continue;
            }
            if("-private".equals(s7))
            {
                H = true;
                N = true;
                K = true;
                E = true;
                continue;
            }
            if("-ymode".equals(s7))
            {
                if("DEBUG".equalsIgnoreCase(as[i][1]))
                {
                    ydoc.A.D.A(0);
                    continue;
                }
                if("LOG".equalsIgnoreCase(as[i][1]))
                {
                    ydoc.A.D.A(1);
                    continue;
                }
                if("SILENT".equalsIgnoreCase(as[i][1]))
                {
                    ydoc.A.D.A(2);
                    continue;
                }
                if("VERBOSE".equalsIgnoreCase(as[i][1]))
                    ydoc.A.D.A(3);
                continue;
            }
            if("-diagramlocator".equals(s7))
            {
                s5 = as[i][1];
                continue;
            }
            if("-diagramlocatorpath".equals(s7))
                s6 = as[i][1];
        }

        B = ydoc.A.E.B(s1, s);
        O = ydoc.A.E.B(s1, s3);
        ydoc.A.A.A(O, "ydoc.cfg");
        if(s4 == null)
            s4 = ydoc.A.A.H.A(O);
        B(s4);
        root.printNotice(ydoc.A.A.H.J().H());
        for(Iterator iterator = arraylist.iterator(); iterator.hasNext(); ydoc.filters.B.A((String)iterator.next(), s2));
        if(s5 != null)
            L.A(s5, s6);
        C(as);
    }

    public void A(RootDoc rootdoc)
    {
        B(rootdoc.options());
    }

    public int optionLength(String s)
    {
        if("-resourcepath".equals(s))
            return 2;
        if("-filter".equals(s))
            return 2;
        if("-filterpath".equals(s))
            return 2;
        if("-license".equals(s))
            return 2;
        if("-ymode".equals(s))
            return 2;
        if("-diagramlocator".equals(s))
            return 2;
        if("-diagramlocatorpath".equals(s))
            return 2;
        else
            return Standard.optionLength(s);
    }

    public boolean validOptions(String as[][], DocErrorReporter docerrorreporter)
    {
        return A(A(as), docerrorreporter) && D.validOptions(D(as), docerrorreporter);
    }

    public boolean A(ClassDoc classdoc)
    {
        N n;
        n = J;
        if(n != null)
            break MISSING_BLOCK_LABEL_44;
        return isGeneratedDoc(classdoc);
        NoSuchMethodError nosuchmethoderror;
        nosuchmethoderror;
        n = ydoc.doclets.N.A(com/sun/tools/doclets/internal/toolkit/Configuration, "isGeneratedDoc", com/sun/javadoc/ClassDoc);
        boolean flag = n.A(this, classdoc);
        J = n;
        return flag;
        return n.A(this, classdoc);
    }

    abstract void E(String as[][]);

    abstract void C(String as[][]);

    abstract boolean A(String as[][], DocErrorReporter docerrorreporter);

    String[][] A(String as[][])
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < as.length; i++)
            if(as[i].length > 0 && A(as[i][0]))
                arraylist.add(as[i]);

        String as1[][] = new String[arraylist.size()][0];
        for(int j = 0; j < as1.length; j++)
            as1[j] = (String[])(String[])arraylist.get(j);

        return as1;
    }

    String[][] D(String as[][])
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < as.length; i++)
            if(as[i].length > 0 && !A(as[i][0]))
                arraylist.add(as[i]);

        String as1[][] = new String[arraylist.size()][0];
        for(int j = 0; j < as1.length; j++)
            as1[j] = (String[])(String[])arraylist.get(j);

        return as1;
    }

    boolean A(String s)
    {
        return s.equals("-resourcepath") || s.equals("-filter") || s.equals("-filterpath") || s.equals("-license") || s.equals("-ymode");
    }

    void A()
    {
    }

    void I()
    {
        String s = "generated by yWorks UML Doclet $(VERSION)";
        String s1 = "http://www.yworks.com/";
        C.B = new ydoc.B.C._A("generated by yWorks UML Doclet $(VERSION)", "http://www.yworks.com/");
    }

    final TagletManager G()
    {
        return D.tagletManager;
    }

    final void A(Taglet taglet)
    {
        G().addCustomTag(new LegacyTaglet(taglet));
    }

    String addTrailingFileSep(String s)
    {
        String s1 = System.getProperty("file.separator");
        String s2 = (new StringBuilder()).append(s1).append(s1).toString();
        int i;
        while((i = s.indexOf(s2)) >= 0) 
            s = (new StringBuilder()).append(s.substring(0, i)).append(s.substring(i + s1.length())).toString();
        if(!s.endsWith(s1))
            s = (new StringBuilder()).append(s).append(s1).toString();
        return s;
    }

    boolean A(DocErrorReporter docerrorreporter)
    {
        try
        {
            new K();
        }
        catch(Error error) { }
        if(ydoc.A.C.A() > 0)
        {
            docerrorreporter.printError(ydoc.A.C.C());
            return false;
        } else
        {
            return true;
        }
    }

    private void E()
    {
        I = true;
        C = false;
        H = true;
        N = true;
        K = false;
        E = false;
        F = false;
        G = false;
        M = false;
        B = null;
        O = null;
    }

    private void B(String s)
    {
        H h = ydoc.A.A.H.J();
        h.B(s);
        I = h.C() == 0xb897d;
        C = h.C() == 0xb9925;
        if(G.A)
        {
            if(I)
                I();
            else
                A();
            String s1 = h.D();
            String s2 = h.F();
            if(s1 != null && s1.trim().length() > 0)
            {
                if(s2 == null || s2.trim().length() == 0)
                    s2 = C.B.A();
                C.B = new ydoc.B.C._A(s1, s2);
            }
        }
    }

    public boolean H;
    public boolean N;
    public boolean K;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean M;
    private boolean I;
    private boolean C;
    public ClassLoader B;
    public ClassLoader O;
    public final P A = new P();
    public final P L = new P("DiagramLocator", new A());
    private final Configuration D;
    private N J;
}
