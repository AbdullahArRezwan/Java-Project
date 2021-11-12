package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPortal extends JFrame {
    public StudentPortal(){
        setSize(900, 650);
        setTitle("Student Portal");
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
        JLabel headerText = new JLabel("Welcome to Students Portal !!");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Georgia", Font.BOLD, 25));
        headerPanel.add(headerText);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0, 57, 77));
        inputPanel.setBounds(5, 70, 874, 536);
        add(inputPanel);
        inputPanel.setLayout(null);

        JButton btnStudentID = new JButton("Student ID");
        btnStudentID.setBounds(367, 140, 140, 35);
        btnStudentID.setFont(new Font("Arial", Font.BOLD, 18));
        btnStudentID.setBackground(new Color(0, 0, 0));
        btnStudentID.setForeground(Color.WHITE);
        Cursor curStudentID = new Cursor(Cursor.HAND_CURSOR);
        btnStudentID.setCursor(curStudentID);
        btnStudentID.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnStudentID);

        JButton btnResult = new JButton("Result");
        btnResult.setBounds(367, 205, 140, 35);
        btnResult.setFont(new Font("Arial", Font.BOLD, 18));
        btnResult.setBackground(new Color(0, 0, 0));
        btnResult.setForeground(Color.WHITE);
        Cursor curResult = new Cursor(Cursor.HAND_CURSOR);
        btnResult.setCursor(curResult);
        btnResult.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnResult);

        JButton btnC_Registration = new JButton("Course Registration");
        btnC_Registration.setBounds(337, 270, 200, 35);
        btnC_Registration.setFont(new Font("Arial", Font.BOLD, 18));
        btnC_Registration.setBackground(new Color(0, 0, 0));
        btnC_Registration.setForeground(Color.WHITE);
        Cursor curC_Registration = new Cursor(Cursor.HAND_CURSOR);
        btnC_Registration.setCursor(curC_Registration);
        btnC_Registration.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnC_Registration);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(367, 335, 140, 35);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 18));
        btnLogout.setBackground(new Color(0, 0, 0));
        btnLogout.setForeground(Color.WHITE);
        Cursor curLogout = new Cursor(Cursor.HAND_CURSOR);
        btnLogout.setCursor(curLogout);
        btnLogout.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnLogout);

        setVisible(true);

        btnStudentID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StudentID();
            }
        });

        btnResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Result();
            }
        });

        btnC_Registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CourseRegistration();
            }
        });

        btnLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You have successfully logged out.");
                dispose();
            }
        });
    }
}
