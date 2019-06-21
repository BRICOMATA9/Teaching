// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package ydoc.doclets;

import com.sun.javadoc.*;
import ydoc.filters.B;

// Referenced classes of package ydoc.doclets:
//            c, A

class M extends c
    implements ClassDoc
{

    M(ClassDoc classdoc)
    {
        super(classdoc);
    }

    private ClassDoc G()
    {
        return (ClassDoc)A();
    }

    public ConstructorDoc[] constructors()
    {
        return A.A(G().constructors());
    }

    public ConstructorDoc[] constructors(boolean flag)
    {
        return A.A(G().constructors(flag));
    }

    public boolean definesSerializableFields()
    {
        return G().definesSerializableFields();
    }

    public FieldDoc[] fields()
    {
        return A.A(G().fields());
    }

    public FieldDoc[] fields(boolean flag)
    {
        return A.A(G().fields(flag));
    }

    public ClassDoc findClass(String s)
    {
        return ydoc.doclets.A.B(G().findClass(s));
    }

    public ClassDoc[] importedClasses()
    {
        return A.A(G().importedClasses());
    }

    public PackageDoc[] importedPackages()
    {
        return A.A(G().importedPackages());
    }

    public ClassDoc[] innerClasses()
    {
        return A.A(G().innerClasses());
    }

    public ClassDoc[] innerClasses(boolean flag)
    {
        return A.A(G().innerClasses(flag));
    }

    public ClassDoc[] interfaces()
    {
        return A.A(G().interfaces());
    }

    public boolean isAbstract()
    {
        return G().isAbstract();
    }

    public boolean isExternalizable()
    {
        return G().isExternalizable();
    }

    public boolean isSerializable()
    {
        return G().isSerializable();
    }

    public MethodDoc[] methods()
    {
        return A.A(G().methods());
    }

    public MethodDoc[] methods(boolean flag)
    {
        return A.A(G().methods(flag));
    }

    public FieldDoc[] serializableFields()
    {
        return A.A(G().serializableFields());
    }

    public MethodDoc[] serializationMethods()
    {
        return A.A(G().serializationMethods());
    }

    public boolean subclassOf(ClassDoc classdoc)
    {
        if(classdoc instanceof M)
            return G().subclassOf(((M)classdoc).G());
        else
            return G().subclassOf(classdoc);
    }

    public ClassDoc superclass()
    {
        return A.A(G().superclass());
    }

    public Type superclassType()
    {
        return A.A(G().superclassType());
    }

    public Type[] interfaceTypes()
    {
        return A.A(G().interfaceTypes());
    }

    public TypeVariable[] typeParameters()
    {
        return A.A(G().typeParameters());
    }

    public ParamTag[] typeParamTags()
    {
        return A.A(G().typeParamTags());
    }

    public FieldDoc[] enumConstants()
    {
        return A.A(G().enumConstants());
    }

    public ClassDoc asClassDoc()
    {
        return A.A(G().asClassDoc());
    }

    public String dimension()
    {
        return G().dimension();
    }

    public String qualifiedTypeName()
    {
        return G().qualifiedTypeName();
    }

    public String typeName()
    {
        return G().typeName();
    }

    public String simpleTypeName()
    {
        return G().simpleTypeName();
    }

    public boolean isPrimitive()
    {
        return G().isPrimitive();
    }

    public ParameterizedType asParameterizedType()
    {
        return A.A(G().asParameterizedType());
    }

    public TypeVariable asTypeVariable()
    {
        return A.A(G().asTypeVariable());
    }

    public WildcardType asWildcardType()
    {
        return A.A(G().asWildcardType());
    }

    public AnnotationTypeDoc asAnnotationTypeDoc()
    {
        return A.A(G().asAnnotationTypeDoc());
    }

    public boolean isIncluded()
    {
        return super.isIncluded() && B.A(G().containingPackage());
    }

    public ClassDoc containingClass()
    {
        return ydoc.doclets.A.B(G().containingClass());
    }
}
