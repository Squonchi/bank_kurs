package com.uva411.bank.gui;

import com.uva411.bank.entity.Customer;
import com.uva411.bank.entity.CustomerList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CustomersGUI extends JFrame{
    //Поля окна клиента
    JLabel yourCountLabel = new JLabel();
    JLabel yourCardLabel = new JLabel();
    private JButton onCount = new JButton(" Положить деньги на счет ");
    private JButton transferCountToCard = new JButton(" Перевести со счета на кредитную карту ");
    private JButton outCard = new JButton(" Снять деньги с кредитной карты ");
    private JButton completeSession = new JButton(" Завершить сессию ");

    //Поля окна пополнения счета
    private JLabel onCountLabel = new JLabel(" Введите сумму: ");
    private JTextField onCountField = new JTextField(15);
    private JButton onCountAccept = new JButton(" Пополнить ");
    private JButton CountToCustomer = new JButton(" Назад ");

    //Поля окна перевода
    private JLabel transferLabel = new JLabel(" Введите сумму: ");
    private JTextField transferField = new JTextField(15);
    private JButton transferAccept = new JButton(" Перевести ");
    private JButton transferToCustomer = new JButton(" Назад ");

    //Поля окна снятия
    private JLabel outCardLabel = new JLabel(" Введите сумму: ");
    private JTextField outCardField = new JTextField(15);
    private JButton outCardAccept = new JButton(" Снять ");
    private JButton outCardToCustomer = new JButton(" Назад ");

    public CustomersGUI(String loginForGUI){
        CustomerList cl = new CustomerList();
        if (cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).isCount()) {
            yourCountLabel.setText(" На вашем счете " +
                    cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCount_money() + " рублей ");
        } else { yourCountLabel.setText("   У Вас закрыт счет   "); }
        if (cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).isCard()) {
            yourCardLabel.setText(" На вашей карте " +
                    cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCard_money() + " рублей ");
        } else { yourCardLabel.setText(" У Вас отсутствует карта "); }

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        //Окно клиента
        JFrame customerWindow = new JFrame(" Банк ");
        JOptionPane.showMessageDialog(customerWindow, " Вход выполнен успешно! ");
        customerWindow.setBounds(width / 2 - 150, height / 2 - 105,300,210);
        customerWindow.setDefaultCloseOperation(customerWindow.EXIT_ON_CLOSE);
        customerWindow.setResizable(false);
        customerWindow.setVisible(true);

        JPanel customerPanel = new JPanel();

        customerPanel.add(yourCountLabel);
        customerPanel.add(yourCardLabel);
        customerPanel.add(onCount);
        customerPanel.add(transferCountToCard);
        customerPanel.add(outCard);
        customerPanel.add(completeSession);

        customerWindow.add(customerPanel);


        //Окно пополнения счета
        JFrame onCountWindow = new JFrame(" Пополнение счета ");
        onCountWindow.setBounds(width / 2 - 150, height / 2 - 50, 300, 100);
        onCountWindow.setDefaultCloseOperation(onCountWindow.DO_NOTHING_ON_CLOSE);
        onCountWindow.setResizable(false);

        JPanel onCountPanel = new JPanel();

        onCountPanel.add(onCountLabel);
        onCountPanel.add(onCountField);
        onCountPanel.add(onCountAccept);
        onCountPanel.add(CountToCustomer);

        onCountWindow.add(onCountPanel);


        //Окно перевода
        JFrame transferWindow = new JFrame(" Перевод денег ");
        transferWindow.setBounds(width / 2 - 150, height / 2 - 50, 300, 100);
        transferWindow.setDefaultCloseOperation(onCountWindow.DO_NOTHING_ON_CLOSE);
        transferWindow.setResizable(false);

        JPanel transferPanel = new JPanel();

        transferPanel.add(transferLabel);
        transferPanel.add(transferField);
        transferPanel.add(transferAccept);
        transferPanel.add(transferToCustomer);

        transferWindow.add(transferPanel);


        //Окно снятия
        JFrame outCardWindow = new JFrame(" Снятие денег ");
        outCardWindow.setBounds(width / 2 - 150, height / 2 - 50, 300, 100);
        outCardWindow.setDefaultCloseOperation(outCardWindow.DO_NOTHING_ON_CLOSE);
        outCardWindow.setResizable(false);

        JPanel outCardPanel = new JPanel();

        outCardPanel.add(outCardLabel);
        outCardPanel.add(outCardField);
        outCardPanel.add(outCardAccept);
        outCardPanel.add(outCardToCustomer);

        outCardWindow.add(outCardPanel);

        //Кнопки окон
        onCount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerWindow.setVisible(false);
                onCountWindow.setVisible(true);
            }
        });

        onCountAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer cust = new Customer();
                if (!cust.PutMoneyOnAcc(cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)), Integer.parseInt(onCountField.getText()))) {
                    JOptionPane.showMessageDialog(onCountWindow, " Ошибка транзакции! ");
                } else {
                    customerWindow.repaint();
                    JOptionPane.showMessageDialog(onCountWindow, " На счет зачисленно " + onCountField.getText() + " рублей! ");
                    onCountField.setText("");
                    yourCountLabel.setText(" На вашем счете " +
                            cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCount_money() + " рублей ");
                    yourCardLabel.setText(" На вашей карте " +
                            cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCard_money() + " рублей ");
                    customerWindow.setVisible(true);
                    onCountWindow.setVisible(false);
                }
            }
        });

        CountToCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerWindow.setVisible(true);
                onCountWindow.setVisible(false);
            }
        });


        transferCountToCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerWindow.setVisible(false);
                transferWindow.setVisible(true);
            }
        });

        transferAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer cust = new Customer();
                if (!cust.TransferAccToCard(cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)), Integer.parseInt(transferField.getText()))) {
                    JOptionPane.showMessageDialog(transferWindow, " Ошибка транзакции! ");
                } else {
                    JOptionPane.showMessageDialog(transferWindow, "  Переведено " + transferField.getText() + " рублей! ");
                    transferField.setText("");
                    yourCountLabel.setText(" На вашем счете " +
                            cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCount_money() + " рублей ");
                    yourCardLabel.setText(" На вашей карте " +
                            cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCard_money() + " рублей ");
                    customerWindow.setVisible(true);
                    transferWindow.setVisible(false);
                }
            }
        });

        transferToCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerWindow.setVisible(true);
                transferField.setText("");
                transferWindow.setVisible(false);
            }
        });


        outCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerWindow.setVisible(false);
                outCardWindow.setVisible(true);
            }
        });

        outCardAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Customer cust = new Customer();
                if (!cust.WithdrawFromCard(cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)), Integer.parseInt(outCardField.getText()))) {
                    JOptionPane.showMessageDialog(onCountWindow, " Ошибка транзакции! ");
                } else {
                    JOptionPane.showMessageDialog(onCountWindow, " Снято " + outCardField.getText() + " рублей! ");
                    outCardField.setText("");
                    yourCountLabel.setText(" На вашем счете " +
                            cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCount_money() + " рублей ");
                    yourCardLabel.setText(" На вашей карте " +
                            cl.getCustomersList().get(cl.getNumberCustomer(loginForGUI)).getCard_money() + " рублей ");
                    customerWindow.setVisible(true);
                    outCardWindow.setVisible(false);
                }
            }
        });

        outCardToCustomer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                customerWindow.setVisible(true);
                outCardField.setText("");
                outCardWindow.setVisible(false);
            }
        });


        completeSession.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] options = {"Да","Нет"};
                if (JOptionPane.showOptionDialog(null, "Вы уверены, что хотите завершить работу?", "", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]) == 0) {
                    cl.listSave();
                    customerWindow.setVisible(false);
                    JOptionPane.showMessageDialog(customerWindow, "Сеанс завершен. Данные сохранены.");
                    new AuthorizeGUI();
                }
            }
        });
    }
}
