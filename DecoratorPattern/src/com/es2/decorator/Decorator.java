package com.es2.decorator;

public class Decorator implements AuthInterface {

    private AuthInterface auth;

    public Decorator(AuthInterface auth) {

        this.auth = auth;
    }

    public void auth(java.lang.String username, java.lang.String password) throws AuthException, java.io.IOException {


    }
}
