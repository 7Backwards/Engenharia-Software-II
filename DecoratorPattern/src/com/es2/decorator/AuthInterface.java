package com.es2.decorator;

public interface AuthInterface {

    void auth(String username, String password) throws AuthException, java.io.IOException;
}
