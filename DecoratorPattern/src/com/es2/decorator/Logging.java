package com.es2.decorator;

import java.io.IOException;
import java.sql.Timestamp;

public class Logging extends Decorator {

    public Logging(AuthInterface auth) {

        super(auth);
    }

    @Override
    public void auth(java.lang.String username, java.lang.String password) throws AuthException, IOException {

        System.out.println(new Timestamp(System.currentTimeMillis()) + ",auth()");
        super.auth(username,password);
    }
}
