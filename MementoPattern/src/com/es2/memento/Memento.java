package com.es2.memento;

import java.util.ArrayList;

public class Memento {

    ArrayList<String> studentNames;

    public Memento(ArrayList<String> studentNames) {

        this.studentNames = (ArrayList<String>) studentNames.clone();
    }

    public ArrayList<String> getState() {

        return studentNames;
    }
}
