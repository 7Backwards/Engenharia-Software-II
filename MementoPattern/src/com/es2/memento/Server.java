package com.es2.memento;
import java.util.ArrayList;


public class Server {

    ArrayList<String> studentNames = new ArrayList<>();

    public Server() {

    }

    public void addStudent(String studentName) throws ExistingStudentException {

        if (studentNames.contains(studentName))
            throw new ExistingStudentException();
        else
            studentNames.add(studentName);
    }

    public Memento backup() {

        return null;
    }

    public void restore(Memento state) {

        studentNames = state.getState();
    }

    public java.util.ArrayList<String> getStudentNames() {

        return studentNames;
    }


}
