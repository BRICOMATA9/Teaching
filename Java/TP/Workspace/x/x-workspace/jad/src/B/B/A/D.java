// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package B.B.A;

import B.B.B.*;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;

// Referenced classes of package B.B.A:
//            F

public class D
    implements F
{

    public D()
    {
        if(A == null)
        {
            Class class1 = getClass();
            A = new HashMap();
            A.put("PUBLIC_CONSTRUCTOR", new ImageIcon(class1.getResource("resource/icons/public_constructor.gif")));
            A.put("PROTECTED_CONSTRUCTOR", new ImageIcon(class1.getResource("resource/icons/protected_constructor.gif")));
            A.put("PACKAGE_CONSTRUCTOR", new ImageIcon(class1.getResource("resource/icons/package_constructor.gif")));
            A.put("PRIVATE_CONSTRUCTOR", new ImageIcon(class1.getResource("resource/icons/private_constructor.gif")));
            A.put("PUBLIC_METHOD", new ImageIcon(class1.getResource("resource/icons/public_method.gif")));
            A.put("PROTECTED_METHOD", new ImageIcon(class1.getResource("resource/icons/protected_method.gif")));
            A.put("PACKAGE_METHOD", new ImageIcon(class1.getResource("resource/icons/package_method.gif")));
            A.put("PRIVATE_METHOD", new ImageIcon(class1.getResource("resource/icons/private_method.gif")));
            A.put("PUBLIC_STATIC_METHOD", new ImageIcon(class1.getResource("resource/icons/static_public_method.gif")));
            A.put("PROTECTED_STATIC_METHOD", new ImageIcon(class1.getResource("resource/icons/static_protected_method.gif")));
            A.put("PACKAGE_STATIC_METHOD", new ImageIcon(class1.getResource("resource/icons/static_package_method.gif")));
            A.put("PRIVATE_STATIC_METHOD", new ImageIcon(class1.getResource("resource/icons/static_private_method.gif")));
            A.put("PUBLIC_FIELD", new ImageIcon(class1.getResource("resource/icons/public_field.gif")));
            A.put("PROTECTED_FIELD", new ImageIcon(class1.getResource("resource/icons/protected_field.gif")));
            A.put("PACKAGE_FIELD", new ImageIcon(class1.getResource("resource/icons/package_field.gif")));
            A.put("PRIVATE_FIELD", new ImageIcon(class1.getResource("resource/icons/private_field.gif")));
            A.put("PUBLIC_STATIC_FIELD", new ImageIcon(class1.getResource("resource/icons/static_public_field.gif")));
            A.put("PROTECTED_STATIC_FIELD", new ImageIcon(class1.getResource("resource/icons/static_protected_field.gif")));
            A.put("PACKAGE_STATIC_FIELD", new ImageIcon(class1.getResource("resource/icons/static_package_field.gif")));
            A.put("PRIVATE_STATIC_FIELD", new ImageIcon(class1.getResource("resource/icons/static_private_field.gif")));
        }
    }

    public Icon A(H h)
    {
        if(h instanceof B)
        {
            int i = h.D();
            if(Modifier.isStatic(i))
            {
                if(Modifier.isPublic(i))
                    return (Icon)A.get("PUBLIC_STATIC_FIELD");
                if(Modifier.isProtected(i))
                    return (Icon)A.get("PROTECTED_STATIC_FIELD");
                if(Modifier.isPrivate(i))
                    return (Icon)A.get("PRIVATE_STATIC_FIELD");
                else
                    return (Icon)A.get("PACKAGE_STATIC_FIELD");
            }
            if(Modifier.isPublic(i))
                return (Icon)A.get("PUBLIC_FIELD");
            if(Modifier.isProtected(i))
                return (Icon)A.get("PROTECTED_FIELD");
            if(Modifier.isPrivate(i))
                return (Icon)A.get("PRIVATE_FIELD");
            else
                return (Icon)A.get("PACKAGE_FIELD");
        }
        if(h instanceof G)
        {
            String s = h.B();
            int j = h.D();
            if(s == null || s.length() == 0)
            {
                if(Modifier.isPublic(j))
                    return (Icon)A.get("PUBLIC_CONSTRUCTOR");
                if(Modifier.isProtected(j))
                    return (Icon)A.get("PROTECTED_CONSTRUCTOR");
                if(Modifier.isPrivate(j))
                    return (Icon)A.get("PRIVATE_CONSTRUCTOR");
                else
                    return (Icon)A.get("PACKAGE_CONSTRUCTOR");
            }
            if(Modifier.isStatic(j))
            {
                if(Modifier.isPublic(j))
                    return (Icon)A.get("PUBLIC_STATIC_METHOD");
                if(Modifier.isProtected(j))
                    return (Icon)A.get("PROTECTED_STATIC_METHOD");
                if(Modifier.isPrivate(j))
                    return (Icon)A.get("PRIVATE_STATIC_METHOD");
                else
                    return (Icon)A.get("PACKAGE_STATIC_METHOD");
            }
            if(Modifier.isPublic(j))
                return (Icon)A.get("PUBLIC_METHOD");
            if(Modifier.isProtected(j))
                return (Icon)A.get("PROTECTED_METHOD");
            if(Modifier.isPrivate(j))
                return (Icon)A.get("PRIVATE_METHOD");
            else
                return (Icon)A.get("PACKAGE_METHOD");
        } else
        {
            return null;
        }
    }

    private static Map A;
}
