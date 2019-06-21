// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            CSSException, Condition, CombinatorCondition, NegativeCondition, 
//            PositionalCondition, AttributeCondition, LangCondition, ContentCondition

public interface ConditionFactory
{

    public abstract CombinatorCondition createAndCondition(Condition condition, Condition condition1)
        throws CSSException;

    public abstract CombinatorCondition createOrCondition(Condition condition, Condition condition1)
        throws CSSException;

    public abstract NegativeCondition createNegativeCondition(Condition condition)
        throws CSSException;

    public abstract PositionalCondition createPositionalCondition(int i, boolean flag, boolean flag1)
        throws CSSException;

    public abstract AttributeCondition createAttributeCondition(String s, String s1, boolean flag, String s2)
        throws CSSException;

    public abstract AttributeCondition createIdCondition(String s)
        throws CSSException;

    public abstract LangCondition createLangCondition(String s)
        throws CSSException;

    public abstract AttributeCondition createOneOfAttributeCondition(String s, String s1, boolean flag, String s2)
        throws CSSException;

    public abstract AttributeCondition createBeginHyphenAttributeCondition(String s, String s1, boolean flag, String s2)
        throws CSSException;

    public abstract AttributeCondition createClassCondition(String s, String s1)
        throws CSSException;

    public abstract AttributeCondition createPseudoClassCondition(String s, String s1)
        throws CSSException;

    public abstract Condition createOnlyChildCondition()
        throws CSSException;

    public abstract Condition createOnlyTypeCondition()
        throws CSSException;

    public abstract ContentCondition createContentCondition(String s)
        throws CSSException;
}
