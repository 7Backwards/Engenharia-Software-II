package com.es2.decorator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CommonWordsValidator extends Decorator {

    private String username = "admin";
    private String password = "admin";

    public CommonWordsValidator(AuthInterface auth) {
        super(auth);
    }

    public void auth(String username, String password) throws AuthException, IOException {

        if (!username.equals(this.username) || !(password.equals(this.password))) throw new AuthException();
        //getHTTPRequest(password);
        super.auth(username,password);
    }

    public String getHTTPRequest(String word) throws IOException {

        StringBuilder result = new StringBuilder();
        URL url = new URL("https://owlbot.info/api/v2/dictionary/" + word + "?format=json");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        return result.toString();
    }
}
