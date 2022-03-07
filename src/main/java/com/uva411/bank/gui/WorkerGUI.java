package com.uva411.bank.gui;

import com.uva411.bank.entity.CustomerList;
import com.uva411.bank.entity.Worker;
import com.uva411.bank.entity.WorkerList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WorkerGUI extends JFrame{
    //Поля окна служащего
    private JButton regClient = new JButton(" Зарегестрировать клиента ");
    private JButton openAccount = new JButton(" Открыть счет ");
    private JButton closeAccount = new JButton(" Закрыть счет ");
    private JButton getCreditCard = new JButton(" Выдать кредитную карту ");
    private JButton completeSession = new JButton(" Завершить сессию ");

    //Поля окна регистрации
    private JLabel nameLabel = new JLabel(" Имя: ");
    private JTextField nameField = new JTextField(15);
    private JLabel surnameLabel = new JLabel(" Фамилия: ");
    private JTextField surnameField = new JTextField(15);
    private JLabel patronymicLabel = new JLabel(" Отчество: ");
    private JTextField patronymicField = new JTextField(15);
    private JLabel loginLabel = new JLabel(" Логин: ");
    private JTextField loginField = new JTextField(15);
    private JLabel passwordLabel = new JLabel(" Пароль: ");
    private JTextField passwordField = new JTextField(15);
    private JButton registrate = new JButton("Зарегестрировать");

    //Поля окна открытия счета
    private JLabel openAccLabel = new JLabel(" Введите логин: ");
    private JTextField openAccField = new JTextField(15);
    private JButton openAccAccept = new JButton(" Открыть счет");

    //Поля окна закрытия счета
    private JLabel closeAccLabel = new JLabel(" Введите логин: ");
    private JTextField closeAccField = new JTextField(15);
    private JButton closeAccAccept = new JButton(" Закрыть счет ");

    //Поля окна выдачи карты
    private JLabel getCardLabel = new JLabel(" Введите логин: ");
    private JTextField getCardField = new JTextField(15);
    private JButton getCardAccept= new JButton(" Выдать карту ");

    WorkerGUI() {

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        //Таблица
        WorkerList wl = new WorkerList();
        CustomerList cl = new CustomerList();
        CustomersTableEg ct = new CustomersTableEg(cl.getCustomersList());
        JTable customersTable = new JTable(ct);
        JScrollPane customersTableScrollPage = new JScrollPane(customersTable);


        //Окно служащего
        JFrame workerWindow = new JFrame(" Банк ");
        JOptionPane.showMessageDialog(workerWindow, "Вход выполнен успешно.\n Вы зашли как служащий. ");
        workerWindow.setBounds(width / 2 - 255, height / 2 - 270,510,540);
        workerWindow.setDefaultCloseOperation(workerWindow.DO_NOTHING_ON_CLOSE);
        workerWindow.setResizable(false);
        workerWindow.setVisible(true);

        JPanel workPanel = new JPanel();

        workPanel.add(customersTableScrollPage);
        workPanel.add(regClient);
        workPanel.add(openAccount);
        workPanel.add(closeAccount);
        workPanel.add(getCreditCard);
        workPanel.add(completeSession);

        workerWindow.add(workPanel);


        //Окно регистрации
        JFrame regCustomerWindow = new JFrame(" Регистрация клиента ");
        regCustomerWindow.setBounds(width / 2 - 175, height / 2 - 115,330,230);
        regCustomerWindow.setDefaultCloseOperation(regCustomerWindow.HIDE_ON_CLOSE);
        regCustomerWindow.setResizable(false);

        JPanel regClientPanel = new JPanel();

        regClientPanel.setLayout(new GridLayout(6, 2, 5, 10));
        regClientPanel.add(nameLabel);
        regClientPanel.add(nameField);
        regClientPanel.add(surnameLabel);
        regClientPanel.add(surnameField);
        regClientPanel.add(patronymicLabel);
        regClientPanel.add(patronymicField);
        regClientPanel.add(loginLabel);
        regClientPanel.add(loginField);
        regClientPanel.add(passwordLabel);
        regClientPanel.add(passwordField);
        regClientPanel.add(registrate);

        regCustomerWindow.add(regClientPanel);


        //Окно открытия счета
        JFrame openAccountWindow = new JFrame(" Открытие счета ");
        openAccountWindow.setBounds(width / 2 - 150, height / 2 - 50,300,100);
        openAccountWindow.setDefaultCloseOperation(openAccountWindow.HIDE_ON_CLOSE);
        openAccountWindow.setResizable(false);

        JPanel openAccPanel = new JPanel();

        openAccPanel.add(openAccLabel);
        openAccPanel.add(openAccField);
        openAccPanel.add(openAccAccept);

        openAccountWindow.add(openAccPanel);


        //Окно закрытия счета
        JFrame closeAccountWindow = new JFrame(" Закрытие счета ");
        closeAccountWindow.setBounds(width / 2 - 150, height / 2 - 50,300,100);
        closeAccountWindow.setDefaultCloseOperation(closeAccountWindow.HIDE_ON_CLOSE);
        closeAccountWindow.setResizable(false);

        JPanel closeAccPanel = new JPanel();

        closeAccPanel.add(closeAccLabel);
        closeAccPanel.add(closeAccField);
        closeAccPanel.add(closeAccAccept);

        closeAccountWindow.add(closeAccPanel);


        //Окно получения карты
        JFrame getCreditCardWindow = new JFrame(" Выдача карты ");
        getCreditCardWindow.setBounds(width / 2 - 150, height / 2 - 50,300,100);
        getCreditCardWindow.setDefaultCloseOperation(closeAccountWindow.HIDE_ON_CLOSE);
        getCreditCardWindow.setResizable(false);

        JPanel getCardPanel = new JPanel();

        getCardPanel.add(getCardLabel);
        getCardPanel.add(getCardField);
        getCardPanel.add(getCardAccept);

        getCreditCardWindow.add(getCardPanel);


        //Кнопки окон
        regClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regCustomerWindow.setVisible(true);
            }
        });

        registrate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Worker wk = new Worker();
                    if (!wk.registrateCustomer(nameField.getText(), surnameField.getText(), patronymicField.getText(), loginField.getText(), passwordField.getText(), cl) && !wk.checkWorker(loginField.getText(), wl)){
                        JOptionPane.showMessageDialog(regCustomerWindow, " Клиент с таким логином существует! ");
                        loginField.setText("");
                    } else {
                        nameField.setText("");
                        surnameField.setText("");
                        patronymicField.setText("");
                        loginField.setText("");
                        passwordField.setText("");
                        ct.fireTableStructureChanged();
                        workerWindow.setVisible(true);
                        regCustomerWindow.setVisible(false);
                        JOptionPane.showMessageDialog(regCustomerWindow, " Клиент зарегестрирован! ");
                    }
                } catch (Exception er) {
                    er.printStackTrace();
                }
            }
        });


        openAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAccountWindow.setVisible(true);
            }
        });

        openAccAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Worker wk = new Worker();
                if (cl.getUser(openAccField.getText(), cl.getCustomersList()) == null) {
                    JOptionPane.showMessageDialog(openAccountWindow, " Логин введен неверно! ");
                } else {
                    if (!wk.OpenAccount(cl.getCustomersList().get(cl.getNumberCustomer(openAccField.getText())))){
                        JOptionPane.showMessageDialog(openAccountWindow, " Счет уже существует! ");
                    } else {
                        JOptionPane.showMessageDialog(openAccountWindow, " Счет окрыт! ");
                        openAccField.setText("");
                        ct.fireTableStructureChanged();
                        workerWindow.setVisible(true);
                        openAccountWindow.setVisible(false);
                    }
                }
            }
        });


        closeAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeAccountWindow.setVisible(true);
            }
        });

        closeAccAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Worker wk = new Worker();
                if (cl.getUser(closeAccField.getText(), cl.getCustomersList()) == null) {
                    JOptionPane.showMessageDialog(closeAccountWindow, " Логин введен неверно! ");
                } else {
                    if (!wk.CloseCount(cl.getCustomersList().get(cl.getNumberCustomer(closeAccField.getText())))) {
                        JOptionPane.showMessageDialog(closeAccountWindow, " Счет отсутствует! ");
                    } else {
                        JOptionPane.showMessageDialog(closeAccountWindow, " Счет закрыт! ");
                        closeAccField.setText("");
                        ct.fireTableStructureChanged();
                        workerWindow.setVisible(true);
                        closeAccountWindow.setVisible(false);
                    }
                }
            }
        });


        getCreditCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getCreditCardWindow.setVisible(true);
            }
        });

        getCardAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {Worker wk = new Worker();
                if (cl.getUser(getCardField.getText(), cl.getCustomersList()) == null) {
                    JOptionPane.showMessageDialog(getCreditCardWindow, " Логин введен неверно! ");
                } else {
                    if (!wk.CreateCard(cl.getCustomersList().get(cl.getNumberCustomer(getCardField.getText())))) {
                        JOptionPane.showMessageDialog(getCreditCardWindow, " Уже есть карта! ");
                    } else {
                        JOptionPane.showMessageDialog(getCreditCardWindow, " Карта выдана! ");
                        getCardField.setText("");
                        ct.fireTableStructureChanged();
                        workerWindow.setVisible(true);
                        getCreditCardWindow.setVisible(false);
                    }
                }

            }
        });


        completeSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Да","Нет"};
                if (JOptionPane.showOptionDialog(null, "Вы уверены, что хотите завершить работу?", "", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
                    cl.listSave();
                    wl.listSave();
                    workerWindow.setVisible(false);
                    JOptionPane.showMessageDialog(workerWindow, "Сеанс завершен. Данные сохранены.");
                    new AuthorizeGUI();
                }
            }
        });
    }
}

