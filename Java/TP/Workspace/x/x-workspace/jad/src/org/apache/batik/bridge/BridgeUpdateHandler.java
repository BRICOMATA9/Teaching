// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 

package org.apache.batik.bridge;

import org.apache.batik.css.engine.CSSEngineEvent;
import org.w3c.dom.events.MutationEvent;

public interface BridgeUpdateHandler
{

    public abstract void handleDOMAttrModifiedEvent(MutationEvent mutationevent);

    public abstract void handleDOMNodeInsertedEvent(MutationEvent mutationevent);

    public abstract void handleDOMNodeRemovedEvent(MutationEvent mutationevent);

    public abstract void handleDOMCharacterDataModified(MutationEvent mutationevent);

    public abstract void handleCSSEngineEvent(CSSEngineEvent cssengineevent);

    public abstract void dispose();
}
