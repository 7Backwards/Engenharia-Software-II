package com.es2.objectpool;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ReusablePool {

    private static ReusablePool instance;
    private static HashMap<HttpURLConnection,Boolean> Pool = new HashMap<>();
    private URL url;
    private static ArrayList<HttpClass> Pool = new ArrayList<>();


    private int poolSize=10;


    public synchronized void setMaxPoolSize(int size) throws IOException {
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
            Pool.put(connection,false);
        }
    }

    public synchronized void resetPool() throws IOException {
        Pool.clear();
        HttpURLConnection connection = null;
        for (int i = 0; i < poolSize; i++) {
            try {
                URL url = new URL("http://www.google.pt/");
                connection = (HttpURLConnection) url.openConnection();

            } catch (IOException e) {
                e.printStackTrace();
            }
            Pool.put(connection,false);
        }
    }


    public synchronized java.net.HttpURLConnection acquire()
            throws PoolExhaustedException, IOException {


        Iterator<Map.Entry<HttpURLConnection, Boolean>> itr = Pool.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<HttpURLConnection, Boolean> entry = itr.next();
            if (entry.getValue() == false) {
                entry.setValue(true);
                return entry.getKey();
            }
        }

        throw new PoolExhaustedException();
    }

    public synchronized void release(java.net.HttpURLConnection conn)
            throws java.io.IOException,ObjectNotFoundException {

        Iterator PoolIterator = Pool.entrySet().iterator();

        while (PoolIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)PoolIterator.next();
            if(mapElement.getKey() == conn) {
                mapElement.setValue(false);
                return;
            }

        }
        throw new ObjectNotFoundException();
    }

    public synchronized static ReusablePool getInstance() throws IOException {
        if(instance == null) {
            instance = new ReusablePool();
        }
        return instance;
    }

    private ReusablePool() throws IOException {
        resetPool();
    }
    }

