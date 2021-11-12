package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentID extends JFrame {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int counter = 0;

    String semester[] =  {"Spring 2018", "Summer 2018", "Fall 2018",
            "Spring 2019", "Summer 2019", "Fall 2019", "Spring 2020", "Summer 2020",
            "Fall 2020", "Spring 2021", "Summer 2021", "Fall 2021"};
    String department[] = {"Computer Science and Engineering", "Electrical and Electronics Engineering",
            "Bachelor of Business Administration", "English"};

    JLabel showLabel = new JLabel();


    public StudentID(){
        setSize(900, 650);
        setTitle("Student ID");
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.black);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel headerPanel = new JPanel();
        //headerPanel.setBackground(Color.cyan);
        headerPanel.setBackground(new Color(102, 51, 0));
        headerPanel.setBounds(5, 5, 874, 60);
        headerPanel.setLayout(null);
        add(headerPanel);

        JLabel headerText = new JLabel("Student ID !!");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerText.setBounds(322,  5, 230, 50);
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

        Font labelFont = new Font("Georgia", Font.BOLD, 18);
        Font textFont = new Font("Arial", Font.BOLD, 15);

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

//        JTextField passField = new JTextField();
//        passField.setBounds(350, 260, 300, 30);
//        passField.setFont(textFont);
//        inputPanel.add(passField);

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

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(372, 350, 130, 35);
        btnSubmit.setFont(new Font("Georgia", Font.BOLD, 18));
        btnSubmit.setBackground(new Color(0, 0, 0));
        btnSubmit.setForeground(Color.WHITE);
        Cursor curSubmit = new Cursor(Cursor.HAND_CURSOR);
        btnSubmit.setCursor(curSubmit);
        btnSubmit.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnSubmit);

        JLabel idLabel = new JLabel("Student ID is: ");
        idLabel.setBounds(220, 415, 200, 30);
        idLabel.setForeground(Color.white);
        idLabel.setFont(new Font("Georgia", Font.BOLD, 17));
        inputPanel.add(idLabel);

        showLabel.setBounds(400, 415, 200, 30);
        showLabel.setForeground(Color.white);
        showLabel.setFont(new Font("Georgia", Font.BOLD, 19));
        inputPanel.add(showLabel);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StudentPortal();
            }
        });


        setVisible(true);

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Department = departmentBox.getSelectedItem().toString();
                String Semester = semesterBox.getSelectedItem().toString();
                String Email = emailField.getText();
                String Pass = new String(passField.getPassword());
                String Query = null;

                if(Department.equals("Computer Science and Engineering")){
                    if(Semester.equals("Spring 2018")){
                        Query = "SELECT * FROM `cse_spring18`";
                    }
                    else if(Semester.equals("Summer 2018")){
                        Query = "SELECT * FROM `cse_summer18`";
                    }
                    else if(Semester.equals("Fall 2018")){
                        Query = "SELECT * FROM `cse_fall18`";
                    }
                    else if(Semester.equals("Spring 2019")){
                        Query = "SELECT * FROM `cse_spring19`";
                    }
                    else if(Semester.equals("Summer 2019")){
                        Query = "SELECT * FROM `cse_summer19`";
                    }
                    else if(Semester.equals("Fall 2019")){
                        Query = "SELECT * FROM `cse_fall19`";
                    }
                    else if(Semester.equals("Spring 2020")){
                        Query = "SELECT * FROM `cse_spring20`";
                    }
                    else if(Semester.equals("Summer 2020")){
                        Query = "SELECT * FROM `cse_summer20`";
                    }
                    else if(Semester.equals("Fall 2020")){
                        Query = "SELECT * FROM `cse_fall20`";
                    }
                    else if(Semester.equals("Spring 2021")){
                        Query = "SELECT * FROM `cse_spring21`";
                    }
                    else if(Semester.equals("Summer 2021")){
                        Query = "SELECT * FROM `cse_summer21`";
                    }
                    else if(Semester.equals("Fall 2021")){
                        Query = "SELECT * FROM `cse_fall21`";
                    }
                }
                else if(Department.equals("Electrical and Electronics Engineering")){
                    if(Semester.equals("Spring 2018")){
                        Query = "SELECT * FROM `eee_spring18`";
                    }
                    else if(Semester.equals("Summer 2018")){
                        Query = "SELECT * FROM `eee_summer18`";
                    }
                    else if(Semester.equals("Fall 2018")){
                        Query = "SELECT * FROM `eee_fall18`";
                    }
                    else if(Semester.equals("Spring 2019")){
                        Query = "SELECT * FROM `eee_spring19`";
                    }
                    else if(Semester.equals("Summer 2019")){
                        Query = "SELECT * FROM `eee_summer19`";
                    }
                    else if(Semester.equals("Fall 2019")){
                        Query = "SELECT * FROM `eee_fall19`";
                    }
                    else if(Semester.equals("Spring 2020")){
                        Query = "SELECT * FROM `eee_spring20`";
                    }
                    else if(Semester.equals("Summer 2020")){
                        Query = "SELECT * FROM `eee_summer20`";
                    }
                    else if(Semester.equals("Fall 2020")){
                        Query = "SELECT * FROM `eee_fall20`";
                    }
                    else if(Semester.equals("Spring 2021")){
                        Query = "SELECT * FROM `eee_spring21`";
                    }
                    else if(Semester.equals("Summer 2021")){
                        Query = "SELECT * FROM `eee_summer21`";
                    }
                    else if(Semester.equals("Fall 2021")){
                        Query = "SELECT * FROM `eee_fall21`";
                    }
                }
                else if(Department.equals("Bachelor of Business Administration")){
                    if(Semester.equals("Spring 2018")){
                        Query = "SELECT * FROM `bba_spring18`";
                    }
                    else if(Semester.equals("Summer 2018")){
                        Query = "SELECT * FROM `bba_summer18`";
                    }
                    else if(Semester.equals("Fall 2018")){
                        Query = "SELECT * FROM `bba_fall18`";
                    }
                    else if(Semester.equals("Spring 2019")){
                        Query = "SELECT * FROM `bba_spring19`";
                    }
                    else if(Semester.equals("Summer 2019")){
                        Query = "SELECT * FROM `bba_summer19`";
                    }
                    else if(Semester.equals("Fall 2019")){
                        Query = "SELECT * FROM `bba_fall19`";
                    }
                    else if(Semester.equals("Spring 2020")){
                        Query = "SELECT * FROM `bba_spring20`";
                    }
                    else if(Semester.equals("Summer 2020")){
                        Query = "SELECT * FROM `bba_summer20`";
                    }
                    else if(Semester.equals("Fall 2020")){
                        Query = "SELECT * FROM `bba_fall20`";
                    }
                    else if(Semester.equals("Spring 2021")){
                        Query = "SELECT * FROM `bba_spring21`";
                    }
                    else if(Semester.equals("Summer 2021")){
                        Query = "SELECT * FROM `bba_summer21`";
                    }
                    else if(Semester.equals("Fall 2021")){
                        Query = "SELECT * FROM `bba_fall21`";
                    }
                }
                else if(Department.equals("English")){
                    if(Semester.equals("Spring 2018")){
                        Query = "SELECT * FROM `eng_spring18`";
                    }
                    else if(Semester.equals("Summer 2018")){
                        Query = "SELECT * FROM `eng_summer18`";
                    }
                    else if(Semester.equals("Fall 2018")){
                        Query = "SELECT * FROM `eng_fall18`";
                    }
                    else if(Semester.equals("Spring 2019")){
                        Query = "SELECT * FROM `eng_spring19`";
                    }
                    else if(Semester.equals("Summer 2019")){
                        Query = "SELECT * FROM `eng_summer19`";
                    }
                    else if(Semester.equals("Fall 2019")){
                        Query = "SELECT * FROM `eng_fall19`";
                    }
                    else if(Semester.equals("Spring 2020")){
                        Query = "SELECT * FROM `eng_spring20`";
                    }
                    else if(Semester.equals("Summer 2020")){
                        Query = "SELECT * FROM `eng_summer20`";
                    }
                    else if(Semester.equals("Fall 2020")){
                        Query = "SELECT * FROM `eng_fall20`";
                    }
                    else if(Semester.equals("Spring 2021")){
                        Query = "SELECT * FROM `eng_spring21`";
                    }
                    else if(Semester.equals("Summer 2021")){
                        Query = "SELECT * FROM `eng_summer21`";
                    }
                    else if(Semester.equals("Fall 2021")){
                        Query = "SELECT * FROM `eng_fall21`";
                    }
                }
                findID(Query, Email, Pass, Semester);
            }
        });
    }

    private void findID(String query, String email, String pass, String semester) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String tableSemester = rs.getNString(10);
                String tableEmail = rs.getNString(3);
                String tablePass = rs.getNString(5);

                if(email.equals(tableEmail) && pass.equals(tablePass) && semester.equals(tableSemester)) {
                    counter = 1;
                    break;
                }
                else{
                    counter = 2;
                }
            }
            if(counter == 1) {
                showLabel.setText(rs.getString(1));
            }
            else if(counter == 2){
                JOptionPane.showMessageDialog(null, "Sorry !! Given information is incorrect.");
            }

        } catch (Exception e) {
            System.err.println("Please, Give us required information"+e);
        }
    }
}
