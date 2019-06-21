// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package ydoc.doclets:
//            U, h, M, S, 
//            R, G, K, L, 
//            W, X, H, d

public final class a
{

    private a()
    {
        I = null;
    }

    public RootDoc B()
    {
        return I;
    }

    public ClassDoc A(String s)
    {
        return B().classNamed(s);
    }

    RootDoc A(RootDoc rootdoc)
    {
        if(I == null)
            I = new U(rootdoc);
        return I;
    }

    PackageDoc A(PackageDoc packagedoc)
    {
        String s = packagedoc.name();
        if(!C.containsKey(s))
            C.put(s, new h(packagedoc));
        return (PackageDoc)C.get(s);
    }

    ClassDoc A(ClassDoc classdoc)
    {
        String s = classdoc.qualifiedTypeName().replace('$', '.');
        if(!J.containsKey(s))
            J.put(s, new M(classdoc));
        return (ClassDoc)J.get(s);
    }

    FieldDoc A(FieldDoc fielddoc)
    {
        String s = fielddoc.qualifiedName().replace('$', '.');
        if(!H.containsKey(s))
            H.put(s, new S(fielddoc));
        return (FieldDoc)H.get(s);
    }

    ConstructorDoc A(ConstructorDoc constructordoc)
    {
        String s = constructordoc.qualifiedName().replace('$', '.').concat(constructordoc.signature());
        if(!G.containsKey(s))
            G.put(s, new R(constructordoc));
        return (ConstructorDoc)G.get(s);
    }

    MethodDoc A(MethodDoc methoddoc)
    {
        String s = methoddoc.qualifiedName().replace('$', '.').concat(methoddoc.signature());
        if(!F.containsKey(s))
            F.put(s, new G(methoddoc));
        return (MethodDoc)F.get(s);
    }

    AnnotationTypeDoc A(AnnotationTypeDoc annotationtypedoc)
    {
        String s = annotationtypedoc.qualifiedTypeName().replace('$', '.');
        if(!M.containsKey(s))
            M.put(s, new K(annotationtypedoc));
        return (AnnotationTypeDoc)M.get(s);
    }

    AnnotationTypeElementDoc A(AnnotationTypeElementDoc annotationtypeelementdoc)
    {
        String s = annotationtypeelementdoc.qualifiedName().replace('$', '.').concat(annotationtypeelementdoc.signature());
        if(!B.containsKey(s))
            B.put(s, new L(annotationtypeelementdoc));
        return (AnnotationTypeElementDoc)B.get(s);
    }

    ParameterizedType A(ParameterizedType parameterizedtype)
    {
        ParameterizedType parameterizedtype1 = parameterizedtype;
        if(!E.containsKey(parameterizedtype1))
            E.put(parameterizedtype1, new W(parameterizedtype));
        return (ParameterizedType)E.get(parameterizedtype1);
    }

    TypeVariable A(TypeVariable typevariable)
    {
        TypeVariable typevariable1 = typevariable;
        if(!L.containsKey(typevariable1))
            L.put(typevariable1, new X(typevariable));
        return (TypeVariable)L.get(typevariable1);
    }

    WildcardType A(WildcardType wildcardtype)
    {
        WildcardType wildcardtype1 = wildcardtype;
        if(!A.containsKey(wildcardtype1))
            A.put(wildcardtype1, new H(wildcardtype));
        return (WildcardType)A.get(wildcardtype1);
    }

    Type A(Type type)
    {
        Type type1 = type;
        if(!D.containsKey(type1))
            D.put(type1, new d(type));
        return (Type)D.get(type1);
    }

    public static a A()
    {
        return K;
    }

    private final Map G = new HashMap();
    private final Map J = new HashMap();
    private final Map H = new HashMap();
    private final Map F = new HashMap();
    private final Map C = new HashMap();
    private final Map M = new HashMap();
    private final Map B = new HashMap();
    private final Map E = new HashMap();
    private final Map L = new HashMap();
    private final Map A = new HashMap();
    private final Map D = new HashMap();
    private U I;
    private static a K = new a();

}
