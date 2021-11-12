package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    public Login(){
        setSize(900, 650);
        setTitle("Login");
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.black);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 51, 0));
        headerPanel.setBounds(5, 5, 874, 60);
        add(headerPanel);
        JLabel headerText = new JLabel("Login Portal !!");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerPanel.add(headerText);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0, 57, 77));
        inputPanel.setBounds(5, 70, 874, 536);
        add(inputPanel);
        inputPanel.setLayout(null);

        JButton btnUser = new JButton("User Login");
        btnUser.setBounds(347, 190, 180, 35);
        btnUser.setFont(new Font("Georgia", Font.BOLD, 18));
        btnUser.setBackground(new Color(0, 0, 0));
        btnUser.setForeground(Color.WHITE);
        Cursor curUser = new Cursor(Cursor.HAND_CURSOR);
        btnUser.setCursor(curUser);
        btnUser.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnUser);

        JButton btnAdmin = new JButton("Admin Login");
        btnAdmin.setBounds(347, 280, 180, 35);
        btnAdmin.setFont(new Font("Georgia", Font.BOLD, 18));
        btnAdmin.setBackground(new Color(0, 0, 0));
        btnAdmin.setForeground(Color.WHITE);
        Cursor curResult = new Cursor(Cursor.HAND_CURSOR);
        btnAdmin.setCursor(curResult);
        btnAdmin.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnAdmin);

        setVisible(true);

        btnAdmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AdminLogin();
            }
        });

        btnUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserLogin();
            }
        });

    }
}
