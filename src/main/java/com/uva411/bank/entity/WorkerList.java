package com.uva411.bank.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WorkerList extends UserList { // список работников
    private ArrayList<Worker> workersList = new ArrayList<>();

    public WorkerList() {
        listLoad();
    }

    public ArrayList<Worker> getWorkerList() {
        return workersList;
    }

    public boolean enterAsWorker(String login, String password) { // вход в систему как работник
        return authCheck(login, password, workersList);
    }

    @Override
    public void listSave() { // сериализация списка работников
        try {
            FileOutputStream fos = new FileOutputStream("workersList");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(workersList);
            oos.flush();
            oos.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void listLoad() { // десериализация списка работников
        try {
            FileInputStream fis = new FileInputStream("workersList");
            ObjectInputStream ois = new ObjectInputStream(fis);
            workersList = (ArrayList<Worker>) ois.readObject();

            ois.close();
        } catch (Exception e) {
        }
    }
}
