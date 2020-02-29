package com.es2.memento;
import java.util.HashMap;

public class BackupService {

    private Server server;
    HashMap<Integer,Memento> SnapShots = new HashMap<>();

    public BackupService(Server server) {

        this.server = server;
    }

    public void takeSnapshot() {

        SnapShots.put(SnapShots.size() , new Memento(server.getStudentNames()));
    }

    public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {

        if (SnapShots.containsKey(snapshotNumber)) {

            server.restore(SnapShots.get(snapshotNumber));
        }
        else
            throw new NotExistingSnapshotException();
    }
}
