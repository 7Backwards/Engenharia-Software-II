package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ReusablePool {

    private static ReusablePool instance;
    private static HashMap<HttpURLConnection, Boolean> Pool = new HashMap<>();


    private int poolSize = 10;

    private ReusablePool() {
        resetPool();
    }

    public synchronized static ReusablePool getInstance() {
        if (instance == null) {
            instance = new ReusablePool();
        }
        return instance;
    }

    public synchronized void setMaxPoolSize(int size) {
        this.poolSize = size;

        Pool.clear();
        HttpURLConnection connection = null;
        for (int i = 0; i < poolSize; i++) {
            try {
                URL url = new URL("http://www.google.pt/");
                connection = (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Pool.put(connection, false);
        }
    }

    public synchronized void resetPool() {
        Pool.clear();
        HttpURLConnection connection = null;
        for (int i = 0; i < poolSize; i++) {
            try {
                URL url = new URL("http://www.google.pt/");
                connection = (HttpURLConnection) url.openConnection();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Pool.put(connection, false);
        }
    }

    public synchronized HttpURLConnection acquire()
            throws PoolExhaustedException {


        for (Map.Entry<HttpURLConnection, Boolean> entry : Pool.entrySet())
            if (!entry.getValue()) {

                entry.setValue(true);
                return entry.getKey();
            }

        throw new PoolExhaustedException();
    }

    public synchronized void release(HttpURLConnection conn)
            throws ObjectNotFoundException {
        boolean finished = false;

        for (Map.Entry<HttpURLConnection, Boolean> httpURLConnectionBooleanEntry : Pool.entrySet())
            if (httpURLConnectionBooleanEntry.getKey() == conn) {
                httpURLConnectionBooleanEntry.setValue(false);
                finished = true;
                break;
            }
        if (!finished) {
            throw new ObjectNotFoundException();
        }
    }
}

