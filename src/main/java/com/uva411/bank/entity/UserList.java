package com.uva411.bank.entity;

import com.uva411.bank.entity.User;

import java.util.ArrayList;
import java.util.List;

public abstract class UserList<T extends User> { // абстрактный класс список пользователей
    boolean loginCheck(String login, ArrayList<T> list) { // проверка на уникальность логина в списке
        boolean availability = true;
        for (T u : list) {
            if (login.equals(u.getLogin())) availability = !availability;
        }
        return availability;
    }

    boolean authCheck(String login, String password, ArrayList<T> list) { // авторизация пользователя
        for (T u : list) {
            if (login.equals(u.getLogin()) && password.equals(u.getPassword())) return true;
        }
        return false;
    }

    boolean addUser(T user, ArrayList<T> list) { // добавить пользователя в список
        boolean adding = true;
        if (loginCheck(user.getLogin(), list)) list.add(user);
        else adding = false;
        return adding;
    }

    public T getUser(String login, List<T> list) { // получить данные пользователя из списка
        for (T o : list) {
            if (o != null && o.getLogin().equals(login)) {
                return o;
            }
        }
        return null;
    }

    abstract void listSave(); // абстрактный метод для сериализации

    abstract void listLoad(); // абстрактный метод для десериализации

}
