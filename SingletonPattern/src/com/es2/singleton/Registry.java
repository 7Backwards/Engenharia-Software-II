package com.es2.singleton;

public class Registry {

    private String path;
    private String connectionString;
    private static Registry instance;

    private Registry() {
    }

    public String getPath() {
        return path;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static Registry getInstance() {
        if(instance == null) {
            instance = new Registry();
        }
        return instance;
    }

}
