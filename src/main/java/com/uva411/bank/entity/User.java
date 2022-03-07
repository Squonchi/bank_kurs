package com.uva411.bank.entity;

import java.io.Serializable;

public abstract class User implements Serializable { //абстрактный класс пользователя, наследуется классами Customer и Worker
    private String name, surname, patronymic, login, password;

    public User() {
    }

    public User(String name, String surname, String patronymic, String login, String password) { // Параметризованный конструктор
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}