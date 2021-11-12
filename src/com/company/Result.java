package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Result extends JFrame{
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int counter = 0;
    String Semester;

    String semester[] =  {"Spring 2018", "Summer 2018", "Fall 2018",
            "Spring 2019", "Summer 2019", "Fall 2019", "Spring 2020", "Summer 2020",
            "Fall 2020", "Spring 2021", "Summer 2021", "Fall 2021"};
    String department[] = {"Computer Science and Engineering", "Electrical and Electronics Engineering",
            "Bachelor of Business Administration", "English"};
    public Result() {
        setSize(900, 650);
        setTitle("Result");
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

        JLabel headerText = new JLabel("Result !!");
        headerText.setForeground(Color.white);
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerText.setBounds(372,  5, 130, 50);
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
        deptLabel.setBounds(220, 100, 180, 30);
        deptLabel.setForeground(Color.white);
        deptLabel.setFont(labelFont);
        inputPanel.add(deptLabel);

        JComboBox departmentBox = new JComboBox(department);
        departmentBox.setBounds(370, 100, 280, 30);
        departmentBox.setFont(textFont);
        departmentBox.setForeground(Color.black);
        inputPanel.add(departmentBox);

        JLabel semesterLabel = new JLabel("Semester :");
        semesterLabel.setBounds(220, 160, 150, 30);
        semesterLabel.setForeground(Color.white);
        semesterLabel.setFont(labelFont);
        inputPanel.add(semesterLabel);

        JComboBox semesterBox = new JComboBox(semester);
        semesterBox.setBounds(370, 160, 280, 30);
        semesterBox.setFont(textFont);
        semesterBox.setForeground(Color.black);
        inputPanel.add(semesterBox);

        JLabel idLabel = new JLabel("Student ID :");
        idLabel.setBounds(220, 220, 150, 30);
        idLabel.setForeground(Color.white);
        idLabel.setFont(labelFont);
        inputPanel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(370, 220, 280, 30);
        idField.setFont(textFont);
        inputPanel.add(idField);

        JLabel DoBLabel = new JLabel("Date of Birth :");
        DoBLabel.setBounds(220, 280, 150, 30);
        DoBLabel.setForeground(Color.white);
        DoBLabel.setFont(labelFont);
        inputPanel.add(DoBLabel);

        JTextField DoBField = new JTextField("dd-mm-yyyy");
        DoBField.setBounds(370, 280, 280, 30);
        DoBField.setFont(textFont);
        inputPanel.add(DoBField);

        DoBField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                DoBField.setText("");
            }
        });

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(372, 340, 130, 35);
        btnSubmit.setFont(new Font("Georgia", Font.BOLD, 18));
        btnSubmit.setBackground(new Color(0, 0, 0));
        btnSubmit.setForeground(Color.WHITE);
        Cursor curSubmit = new Cursor(Cursor.HAND_CURSOR);
        btnSubmit.setCursor(curSubmit);
        btnSubmit.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnSubmit);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StudentPortal();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Department = departmentBox.getSelectedItem().toString();
                Semester = semesterBox.getSelectedItem().toString();
                String StudentID = idField.getText();
                String dateOfBirth = DoBField.getText();
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
                findResult(Query, StudentID, dateOfBirth, Semester, Department);
            }
        });

        setVisible(true);
    }

    private void findResult(String query, String studentID, String dateOfBirth, String semester, String department) {
        String tableStudentID = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
            st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                String tableSemester = rs.getNString(10);
                tableStudentID = String.valueOf(rs.getInt(1));
                String tableDoB = rs.getNString(4);

                if(studentID.equals(tableStudentID) && dateOfBirth.equals(tableDoB) && semester.equals(tableSemester)) {
                    counter = 1;
                    break;
                }
                else{
                    counter = 2;
                }
            }
            if(counter == 1) {
                dispose();
                ResultSheet RS = new ResultSheet();
                RS.fetchResult(tableStudentID, department, semester);
            }
            else if(counter == 2){
                JOptionPane.showMessageDialog(null, "Sorry !! Given information is incorrect.");
            }

        } catch (Exception e) {
            System.err.println("Please, Give us required information"+e);
        }
    }
}
