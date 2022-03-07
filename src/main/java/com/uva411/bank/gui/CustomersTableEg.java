package com.uva411.bank.gui;

import com.uva411.bank.entity.Customer;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CustomersTableEg extends AbstractTableModel {
    private final int columnCount = 7;
    private ArrayList<Customer> dataList;

    public CustomersTableEg(ArrayList<Customer> dataList) {
        this.dataList = dataList;
    }

    @Override
    public int getRowCount() {
        return dataList.size();
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer c = new Customer();
        switch (columnIndex) {
            case 0:
                return dataList.get(rowIndex).getName();
            case 1:
                return dataList.get(rowIndex).getSurname();
            case 2:
                return dataList.get(rowIndex).getPatronymic();
            case 3:
                return dataList.get(rowIndex).getLogin();
            case 4:
                return dataList.get(rowIndex).getPassword();
            case 5:
                return dataList.get(rowIndex).getCount();
            case 6:
                return dataList.get(rowIndex).getCard();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Имя";
            case 1:
                return "Фамилия";
            case 2:
                return "Отчество";
            case 3:
                return "Логин";
            case 4:
                return "Пароль";
            case 5:
                return "Счет";
            case 6:
                return "Кредитная карта";
        }
        return "";
    }

    public void equal(CustomersTableEg e) {
        this.dataList = e.dataList;
    }


}

