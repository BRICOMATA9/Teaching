// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.w3c.css.sac;


// Referenced classes of package org.w3c.css.sac:
//            CSSException, SimpleSelector, Condition, ConditionalSelector, 
//            NegativeSelector, ElementSelector, CharacterDataSelector, ProcessingInstructionSelector, 
//            Selector, DescendantSelector, SiblingSelector

public interface SelectorFactory
{

    public abstract ConditionalSelector createConditionalSelector(SimpleSelector simpleselector, Condition condition)
        throws CSSException;

    public abstract SimpleSelector createAnyNodeSelector()
        throws CSSException;

    public abstract SimpleSelector createRootNodeSelector()
        throws CSSException;

    public abstract NegativeSelector createNegativeSelector(SimpleSelector simpleselector)
        throws CSSException;

    public abstract ElementSelector createElementSelector(String s, String s1)
        throws CSSException;

    public abstract CharacterDataSelector createTextNodeSelector(String s)
        throws CSSException;

    public abstract CharacterDataSelector createCDataSectionSelector(String s)
        throws CSSException;

    public abstract ProcessingInstructionSelector createProcessingInstructionSelector(String s, String s1)
        throws CSSException;

    public abstract CharacterDataSelector createCommentSelector(String s)
        throws CSSException;

    public abstract ElementSelector createPseudoElementSelector(String s, String s1)
        throws CSSException;

    public abstract DescendantSelector createDescendantSelector(Selector selector, SimpleSelector simpleselector)
        throws CSSException;

    public abstract DescendantSelector createChildSelector(Selector selector, SimpleSelector simpleselector)
        throws CSSException;

    public abstract SiblingSelector createDirectAdjacentSelector(short word0, Selector selector, SimpleSelector simpleselector)
        throws CSSException;
}
