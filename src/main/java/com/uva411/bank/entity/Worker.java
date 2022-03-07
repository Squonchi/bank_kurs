package com.uva411.bank.entity;

public class Worker extends User { // класс работника
    public Worker() {
    }

    public Worker(String name, String surname, String patronymic, String login, String password) {
        super(name, surname, patronymic, login, password);
    }

    public boolean OpenAccount(Customer customer) { // открыть счёт клиенту
        if (!customer.isCount()) {
            customer.tumblerCount();
            customer.setCount(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean CloseCount(Customer customer) { // закрыть счёт клиенту
        if (customer.isCount()) {
            customer.tumblerCount();
            customer.setCount(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean CreateCard(Customer customer) { // создать карту клиенту
        if (!customer.isCard()) {
            customer.tumblerCard();
            customer.setCount(0);
            return true;
        } else {
            return false;
        }
    }

    public boolean registrateCustomer(String name, String surname, String patronymic, String login, String password, CustomerList list) { // зарегестрировать нового клиента
        return list.addUser(new Customer(name, surname, patronymic, login, password), list.getCustomersList());
    }

    public boolean checkWorker(String login, WorkerList list) { // проверка на существование работника
        return list.loginCheck(login, list.getWorkerList());
    }
}
