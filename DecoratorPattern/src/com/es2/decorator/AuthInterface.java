package com.es2.decorator;

public interface AuthInterface {

    void auth(java.lang.String username, java.lang.String password) throws AuthException, java.io.IOException;
}
