// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.dom;

import org.apache.batik.dom.util.HashTable;
import org.w3c.dom.Node;
import org.w3c.dom.stylesheets.StyleSheet;

public interface StyleSheetFactory
{

    public abstract StyleSheet createStyleSheet(Node node, HashTable hashtable);
}
