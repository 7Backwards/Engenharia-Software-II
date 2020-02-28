package com.es2.objectpool;

import java.io.Serializable;

public class PoolExhaustedException extends java.lang.Exception implements Serializable {
    private static final long   serialVersionUID = 1L;

    public PoolExhaustedException() {
    }
}
