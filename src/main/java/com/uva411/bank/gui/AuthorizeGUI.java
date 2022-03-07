package com.uva411.bank.gui;

import com.uva411.bank.entity.CustomerList;
import com.uva411.bank.entity.WorkerList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AuthorizeGUI extends JFrame{

    private JLabel loginLabel = new JLabel(" Логин:    ");
    private JTextField loginField = new JTextField(15);
    private JLabel passwordLabel = new JLabel(" Пароль: ");
    private JPasswordField passwordField = new JPasswordField(15);
    private JButton enterInBank = new JButton(" Войти ");

    public AuthorizeGUI(){

        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();

        JFrame logOnWindow = new JFrame(" Авторизация ");
        logOnWindow.setBounds(width / 2 - 135, height / 2 - 65,270,130);
        logOnWindow.setResizable(false);
        logOnWindow.setVisible(true);

        JPanel logOnPanel = new JPanel();

        logOnPanel.add(loginLabel);
        logOnPanel.add(loginField);
        logOnPanel.add(passwordLabel);
        logOnPanel.add(passwordField);
        logOnPanel.add(enterInBank);

        logOnWindow.add(logOnPanel);


        enterInBank.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerList cL = new CustomerList();
                WorkerList wL = new WorkerList();
                if (wL.enterAsWorker(loginField.getText(), passwordField.getText())) {
                    logOnWindow.setVisible(false);
                    new WorkerGUI();
                    loginField.setText("");
                    passwordField.setText("");
                } else {
                    if (cL.enterAsCustomer(loginField.getText(), passwordField.getText())) {
                        logOnWindow.setVisible(false);
                        new CustomersGUI(loginField.getText());
                        loginField.setText("");
                        passwordField.setText("");
                    } else {
                        JOptionPane.showMessageDialog(logOnWindow, " Почта или пароль заданы неверно! ");
                        passwordField.setText("");
                    }
                }
            }
        });


        WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(logOnWindow, "Конец работы.");
                System.exit(0);
            }
        };
        logOnWindow.addWindowListener(exitListener);
    }
}

