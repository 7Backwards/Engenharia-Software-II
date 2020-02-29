package com.es2.memento;

import java.util.ArrayList;

public class Memento {

    ArrayList<String> studentNames = new ArrayList<>();

    public Memento(java.util.ArrayList<java.lang.String> studentNames) {

        this.studentNames = (ArrayList<String>) studentNames.clone();
    }

    public java.util.ArrayList<java.lang.String> getState() {

        return studentNames;
    }
}
