package com.upec.securityProtocols.actors;

import java.security.KeyPair;
import java.util.Map;

public abstract class Agent {
    protected String              id;
    protected KeyPair             keys;
    protected Map<String, byte[]> knowledges;
    // protected String type;
    protected boolean             status;
}
