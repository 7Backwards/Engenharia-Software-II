package com.es2.decorator;

public class Auth implements AuthInterface {

    private String username = "admin";
    private String password = "admin";

    public void auth(String username, String password) throws AuthException {

        if ((!username.equals(this.username)) || !(password.equals(this.password))) {

            throw new AuthException();
        }

    }
}
