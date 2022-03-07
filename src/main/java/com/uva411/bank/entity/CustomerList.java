package com.uva411.bank.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CustomerList extends UserList { // класс для списка клиентов
    private ArrayList<Customer> customersList = new ArrayList<>();

    public CustomerList() {
        listLoad();
    }

    public int getNumberCustomer(String login) { // получить номер клиента в списке
        int c = 0;
        for (Customer customer : customersList) {
            if (login.equals(customer.getLogin())) {
                return c;
            }
            c++;
        }
        return -1;
    }

    public ArrayList<Customer> getCustomersList() {
        return customersList;
    }

    public boolean enterAsCustomer(String login, String password) { // вход в систему как пользователь
        return authCheck(login, password, customersList);
    }

    @Override
    public void listSave() { // сериализация списка клиентов
        try {
            FileOutputStream fos = new FileOutputStream("customersList");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customersList);
            oos.flush();
            oos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void listLoad() { // десериализацтя списка клиентов
        try {
            FileInputStream fis = new FileInputStream("customersList");
            ObjectInputStream ois = new ObjectInputStream(fis);
            customersList = (ArrayList<Customer>) ois.readObject();
            ois.close();
        } catch (Exception e) {
        }
    }
}
