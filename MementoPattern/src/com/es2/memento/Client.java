package com.es2.memento;

public class Client {

    public static void main(String[] args) throws ExistingStudentException, NotExistingSnapshotException {
        Server s = new Server();
        BackupService backup = new BackupService(s);
        backup.takeSnapshot();
        s.addStudent("Maria José");
        backup.takeSnapshot();
        s.addStudent("Manuel António");

        System.out.println(s.getStudentNames().size());
        backup.restoreSnapshot(1);
        System.out.println(s.getStudentNames().size());
    }

}
