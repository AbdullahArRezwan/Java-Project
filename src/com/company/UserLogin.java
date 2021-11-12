package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLogin extends JFrame {
    String department[] = {"Computer Science and Engineering", "Electrical and Electronics Engineering",
            "Bachelor of Business Administration", "English"};
    String semester[] =  {"Spring 2018", "Summer 2018", "Fall 2018",
            "Spring 2019", "Summer 2019", "Fall 2019", "Spring 2020", "Summer 2020",
            "Fall 2020", "Spring 2021", "Summer 2021", "Fall 2021"};

    public UserLogin(){
        setSize(900, 650);
        setTitle("User Login");
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
        JLabel headerText = new JLabel("User Login Dashboard!!");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerPanel.add(headerText);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0, 57, 77));
        inputPanel.setBounds(5, 70, 874, 536);
        add(inputPanel);
        inputPanel.setLayout(null);

        Font labelFont = new Font("Georgia", Font.BOLD, 17);
        Font textFont = new Font("Arial", Font.BOLD, 14);

        JLabel deptLabel = new JLabel("Department :");
        deptLabel.setBounds(200, 80, 150, 30);
        deptLabel.setForeground(Color.white);
        deptLabel.setFont(labelFont);
        inputPanel.add(deptLabel);

        JComboBox departmentBox = new JComboBox(department);
        departmentBox.setBounds(350, 80, 300, 30);
        departmentBox.setFont(textFont);
        departmentBox.setForeground(Color.black);
        inputPanel.add(departmentBox);

        JLabel semesterLabel = new JLabel("Semester :");
        semesterLabel.setBounds(200, 140, 150, 30);
        semesterLabel.setForeground(Color.white);
        semesterLabel.setFont(labelFont);
        inputPanel.add(semesterLabel);

        JComboBox semesterBox = new JComboBox(semester);
        semesterBox.setBounds(350, 140, 300, 30);
        semesterBox.setFont(textFont);
        semesterBox.setForeground(Color.black);
        inputPanel.add(semesterBox);

        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(200, 200, 150, 30);
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(labelFont);
        inputPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(350, 200, 300, 30);
        emailField.setFont(textFont);
        inputPanel.add(emailField);

        JLabel passLabel = new JLabel("Password :");
        passLabel.setBounds(200, 260, 150, 30);
        passLabel.setForeground(Color.white);
        passLabel.setFont(labelFont);
        inputPanel.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(350, 260, 300, 30);
        passField.setEchoChar('*');
        passField.setFont(textFont);
        passField.getEchoChar();
        inputPanel.add(passField);


        JCheckBox chkBox = new JCheckBox("Show Password");
        chkBox.setBounds(348, 300, 150, 20);
        chkBox.setFont(new Font("Arial", Font.PLAIN, 13));
        chkBox.setBackground(new Color(0, 57, 77));
        chkBox.setForeground(Color.white);
        inputPanel.add(chkBox);

        chkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBox c = (JCheckBox) e.getSource();
                passField.setEchoChar(c.isSelected() ? '\u0000' : (Character) UIManager.get("PasswordField.echoChar"));
            }
        });

        JButton btnRegistration = new JButton("Registration");
        btnRegistration.setBounds(230, 350, 130, 35);
        btnRegistration.setFont(new Font("Georgia", Font.BOLD, 18));
        btnRegistration.setBackground(new Color(0, 0, 0));
        btnRegistration.setForeground(Color.WHITE);
        Cursor curRegistration = new Cursor(Cursor.HAND_CURSOR);
        btnRegistration.setCursor(curRegistration);
        btnRegistration.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnRegistration);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(470, 350, 130, 35);
        btnLogin.setFont(new Font("Georgia", Font.BOLD, 18));
        btnLogin.setBackground(new Color(0, 0, 0));
        btnLogin.setForeground(Color.WHITE);
        Cursor curLogIn = new Cursor(Cursor.HAND_CURSOR);
        btnLogin.setCursor(curLogIn);
        btnLogin.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnLogin);

        JLabel idLabel = new JLabel("if you do not complete your registration yet, then click registration");
        idLabel.setBounds(195, 410, 500, 20);
        idLabel.setForeground(Color.white);
        idLabel.setFont(new Font("Georgia", Font.BOLD, 12));
        inputPanel.add(idLabel);


        setVisible(true);

        btnRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Registration();
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String loginDepartment = departmentBox.getSelectedItem().toString();
                String loginSemester = semesterBox.getSelectedItem().toString();
                String loginEmail = emailField.getText();
                String loginPass = new String(passField.getPassword());
                String loginQuery = null;

                if(loginDepartment.equals("Computer Science and Engineering")){
                    if(loginSemester.equals("Spring 2018")){
                        loginQuery = "SELECT * FROM `cse_spring18`";
                    }
                    else if(loginSemester.equals("Summer 2018")){
                        loginQuery = "SELECT * FROM `cse_summer18`";
                    }
                    else if(loginSemester.equals("Fall 2018")){
                        loginQuery = "SELECT * FROM `cse_fall18`";
                    }
                    else if(loginSemester.equals("Spring 2019")){
                        loginQuery = "SELECT * FROM `cse_spring19`";
                    }
                    else if(loginSemester.equals("Summer 2019")){
                        loginQuery = "SELECT * FROM `cse_summer19`";
                    }
                    else if(loginSemester.equals("Fall 2019")){
                        loginQuery = "SELECT * FROM `cse_fall19`";
                    }
                    else if(loginSemester.equals("Spring 2020")){
                        loginQuery = "SELECT * FROM `cse_spring20`";
                    }
                    else if(loginSemester.equals("Summer 2020")){
                        loginQuery = "SELECT * FROM `cse_summer20`";
                    }
                    else if(loginSemester.equals("Fall 2020")){
                        loginQuery = "SELECT * FROM `cse_fall20`";
                    }
                    else if(loginSemester.equals("Spring 2021")){
                        loginQuery = "SELECT * FROM `cse_spring21`";
                    }
                    else if(loginSemester.equals("Summer 2021")){
                        loginQuery = "SELECT * FROM `cse_summer21`";
                    }
                    else if(loginSemester.equals("Fall 2021")){
                        loginQuery = "SELECT * FROM `cse_fall21`";
                    }
                }
                else if(loginDepartment.equals("Electrical and Electronics Engineering")){
                    if(loginSemester.equals("Spring 2018")){
                        loginQuery = "SELECT * FROM `eee_spring18`";
                    }
                    else if(loginSemester.equals("Summer 2018")){
                        loginQuery = "SELECT * FROM `eee_summer18`";
                    }
                    else if(loginSemester.equals("Fall 2018")){
                        loginQuery = "SELECT * FROM `eee_fall18`";
                    }
                    else if(loginSemester.equals("Spring 2019")){
                        loginQuery = "SELECT * FROM `eee_spring19`";
                    }
                    else if(loginSemester.equals("Summer 2019")){
                        loginQuery = "SELECT * FROM `eee_summer19`";
                    }
                    else if(loginSemester.equals("Fall 2019")){
                        loginQuery = "SELECT * FROM `eee_fall19`";
                    }
                    else if(loginSemester.equals("Spring 2020")){
                        loginQuery = "SELECT * FROM `eee_spring20`";
                    }
                    else if(loginSemester.equals("Summer 2020")){
                        loginQuery = "SELECT * FROM `eee_summer20`";
                    }
                    else if(loginSemester.equals("Fall 2020")){
                        loginQuery = "SELECT * FROM `eee_fall20`";
                    }
                    else if(loginSemester.equals("Spring 2021")){
                        loginQuery = "SELECT * FROM `eee_spring21`";
                    }
                    else if(loginSemester.equals("Summer 2021")){
                        loginQuery = "SELECT * FROM `eee_summer21`";
                    }
                    else if(loginSemester.equals("Fall 2021")){
                        loginQuery = "SELECT * FROM `eee_fall21`";
                    }
                }

                else if(loginDepartment.equals("Bachelor of Business Administration")){
                    if(loginSemester.equals("Spring 2018")){
                        loginQuery = "SELECT * FROM `bba_spring18`";
                    }
                    else if(loginSemester.equals("Summer 2018")){
                        loginQuery = "SELECT * FROM `bba_summer18`";
                    }
                    else if(loginSemester.equals("Fall 2018")){
                        loginQuery = "SELECT * FROM `bba_fall18`";
                    }
                    else if(loginSemester.equals("Spring 2019")){
                        loginQuery = "SELECT * FROM `bba_spring19`";
                    }
                    else if(loginSemester.equals("Summer 2019")){
                        loginQuery = "SELECT * FROM `bba_summer19`";
                    }
                    else if(loginSemester.equals("Fall 2019")){
                        loginQuery = "SELECT * FROM `bba_fall19`";
                    }
                    else if(loginSemester.equals("Spring 2020")){
                        loginQuery = "SELECT * FROM `bba_spring20`";
                    }
                    else if(loginSemester.equals("Summer 2020")){
                        loginQuery = "SELECT * FROM `bba_summer20`";
                    }
                    else if(loginSemester.equals("Fall 2020")){
                        loginQuery = "SELECT * FROM `bba_fall20`";
                    }
                    else if(loginSemester.equals("Spring 2021")){
                        loginQuery = "SELECT * FROM `bba_spring21`";
                    }
                    else if(loginSemester.equals("Summer 2021")){
                        loginQuery = "SELECT * FROM `bba_summer21`";
                    }
                    else if(loginSemester.equals("Fall 2021")){
                        loginQuery = "SELECT * FROM `bba_fall21`";
                    }
                }
                else if(loginDepartment.equals("English")){
                    if(loginSemester.equals("Spring 2018")){
                        loginQuery = "SELECT * FROM `eng_spring18`";
                    }
                    else if(loginSemester.equals("Summer 2018")){
                        loginQuery = "SELECT * FROM `eng_summer18`";
                    }
                    else if(loginSemester.equals("Fall 2018")){
                        loginQuery = "SELECT * FROM `eng_fall18`";
                    }
                    else if(loginSemester.equals("Spring 2019")){
                        loginQuery = "SELECT * FROM `eng_spring19`";
                    }
                    else if(loginSemester.equals("Summer 2019")){
                        loginQuery = "SELECT * FROM `eng_summer19`";
                    }
                    else if(loginSemester.equals("Fall 2019")){
                        loginQuery = "SELECT * FROM `eng_fall19`";
                    }
                    else if(loginSemester.equals("Spring 2020")){
                        loginQuery = "SELECT * FROM `eng_spring20`";
                    }
                    else if(loginSemester.equals("Summer 2020")){
                        loginQuery = "SELECT * FROM `eng_summer20`";
                    }
                    else if(loginSemester.equals("Fall 2020")){
                        loginQuery = "SELECT * FROM `eng_fall20`";
                    }
                    else if(loginSemester.equals("Spring 2021")){
                        loginQuery = "SELECT * FROM `eng_spring21`";
                    }
                    else if(loginSemester.equals("Summer 2021")){
                        loginQuery = "SELECT * FROM `eng_summer21`";
                    }
                    else if(loginSemester.equals("Fall 2021")){
                        loginQuery = "SELECT * FROM `eng_fall21`";
                    }
                }
                DbConnect db = new DbConnect();
                db.UserLogin(loginEmail, loginPass, loginQuery);
                dispose();
            }
        });
    }
}
