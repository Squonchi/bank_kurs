package com.uva411.bank.entity;

public class Customer extends User {                                                           //класс клиента
    private boolean count, card;
    private int count_money, card_money;

    public Customer() {
    }

    public Customer(String name, String surname, String patronymic, String login, String password) {
        super(name, surname, patronymic, login, password);
    }

    public int getCount_money() {
        return count_money;
    }                           //  узнать сколько денег на счету

    private void setCount_money(int count_money) {             //метод для назначения денег на счету
        this.count_money = count_money;
    }       //  назначение денег на счету

    public int getCard_money() {
        return card_money;
    }                             //  узнать сколько денег на карте

    private void setCard_money(int card_money) {               //метод для назначения денег на карте
        this.card_money = card_money;
    }           //  назначение денег на карте

    public boolean getCount() {
        return count;
    }                                  //  проверка на существование счёта

    public boolean getCard() {
        return card;
    }                                     //  проверка на существование карты

    public boolean PutMoneyOnAcc(Customer customer, int money) {                    //положить деньги на карту
        if (customer.isCount()) {
            customer.setCount_money(customer.getCount_money() + money);
            return true;
        } else {
            return false;
        }
    }

    public boolean TransferAccToCard(Customer customer, int money) {                 //перевести деньги со счёта на карту
        if (customer.isCard() && customer.isCount() && customer.getCount_money() >= money) {
            customer.setCount_money(customer.getCount_money() - money);
            customer.setCard_money(customer.getCard_money() + money);
            return true;
        } else {
            return false;
        }
    }

    public boolean WithdrawFromCard(Customer customer, int money) {                //снять деньги с карты
        if (customer.isCard() && customer.isCard() && customer.getCard_money() >= money) {
            customer.setCard_money(customer.getCard_money() - money);
            return true;
        } else {
            return false;
        }
    }

    public void tumblerCard() {                                                     //  закрыть/открыть карту
        card = !card;
    }

    public void tumblerCount() {                                                    //  закрыть/открыть счёт
        count = !count;
    }

    public boolean isCard() {
        return card;
    }                                       //  проверка на существование карты

    public void setCard(int cash) {
        card_money = cash;
    }

    public boolean isCount() {
        return count;
    }                                     //  проверка на существование счёта

    public void setCount(int cash) {
        count_money = cash;
    }


}


