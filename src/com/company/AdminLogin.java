package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {
    public AdminLogin(){
        setSize(900, 650);
        setTitle("Admin Login");
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.black);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 51, 0));
        headerPanel.setBounds(5, 5, 874, 60);
        headerPanel.setLayout(null);
        add(headerPanel);

        JLabel headerText = new JLabel("Admin Login Dashboard !!");
        headerText.setForeground(Color.white);
        headerText.setBounds(227,  5, 420, 50);
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerPanel.add(headerText);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(5, 20, 40, 18);
        btnBack.setFont(new Font("Georgia", Font.PLAIN, 13));
        btnBack.setBackground(new Color(102, 51, 0));
        btnBack.setForeground(Color.WHITE);
        Cursor curBack = new Cursor(Cursor.HAND_CURSOR);
        btnBack.setCursor(curBack);
        btnBack.setBorder(new LineBorder(Color.cyan));
        headerPanel.add(btnBack);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0, 57, 77));
        inputPanel.setBounds(5, 70, 874, 536);
        add(inputPanel);
        inputPanel.setLayout(null);

        Font labelFont = new Font("Georgia", Font.BOLD, 17);
        Font textFont = new Font("Arial", Font.BOLD, 14);

        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(260, 160, 80, 30);
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(labelFont);
        inputPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(355, 160, 270, 30);
        emailField.setFont(textFont);
        inputPanel.add(emailField);

        JLabel passLabel = new JLabel("Password :");
        passLabel.setBounds(225, 230, 110, 30);
        passLabel.setForeground(Color.white);
        passLabel.setFont(labelFont);
        inputPanel.add(passLabel);

        JTextField passField = new JTextField();
        passField.setBounds(355, 230, 270, 30);
        passField.setFont(textFont);
        inputPanel.add(passField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(355, 300, 130, 35);
        btnLogin.setFont(new Font("Georgia", Font.BOLD, 18));
        btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.setForeground(Color.WHITE);
        Cursor curLogIn = new Cursor(Cursor.HAND_CURSOR);
        btnLogin.setCursor(curLogIn);
        btnLogin.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnLogin);

        setVisible(true);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Login();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginEmail = emailField.getText();
                String loginPass = passField.getText();
                String loginQuery = "SELECT * FROM `admin_panel`";
                DbConnect db = new DbConnect();
                db.AdminLogin(loginEmail, loginPass, loginQuery);
                dispose();
            }
        });
    }
}
