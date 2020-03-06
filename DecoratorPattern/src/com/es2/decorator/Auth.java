package com.es2.decorator;

public class Auth implements AuthInterface {

    String username = "admin";
    String password = "admin";

    public void auth(java.lang.String username, java.lang.String password) throws AuthException {

        if ((!username.equals(this.username)) || !(password.equals(this.password))) {

            throw new AuthException();
        }

    }
}
