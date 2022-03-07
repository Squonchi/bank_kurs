package com.uva411.bank;

import com.uva411.bank.gui.AuthorizeGUI;

public class Main {
    public static void main(String[] args) {
        /*WorkerList list = new WorkerList();
        Worker worker = new Worker("Иванов", "Иван", "Иванович", "1", "1");
        list.getWorkerList().add(worker);
        list.listSave();*/
        AuthorizeGUI gui = new AuthorizeGUI();
        gui.setVisible(true);

    }
}