package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultInsert extends JFrame {
    String session[] =  {"Spring 2018", "Summer 2018", "Fall 2018",
            "Spring 2019", "Summer 2019", "Fall 2019", "Spring 2020", "Summer 2020",
            "Fall 2020", "Spring 2021", "Summer 2021", "Fall 2021"};
    String department[] = {"Computer Science and Engineering", "Electrical and Electronics Engineering",
            "Bachelor of Business Administration", "English"};

    public ResultInsert(){
        setSize(900, 650);
        setTitle("Insert Result");
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
        JLabel headerText = new JLabel("Result Insert Dashboard !!");
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
        deptLabel.setBounds(200, 60, 150, 30);
        deptLabel.setForeground(Color.white);
        deptLabel.setFont(labelFont);
        inputPanel.add(deptLabel);

        JComboBox departmentBox = new JComboBox(department);
        departmentBox.setBounds(350, 60, 300, 30);
        departmentBox.setFont(textFont);
        departmentBox.setForeground(Color.black);
        inputPanel.add(departmentBox);

        JLabel sessionLabel = new JLabel("Session :");
        sessionLabel.setBounds(200, 120, 150, 30);
        sessionLabel.setForeground(Color.white);
        sessionLabel.setFont(labelFont);
        inputPanel.add(sessionLabel);

        JComboBox sessionBox = new JComboBox(session);
        sessionBox.setBounds(350, 120, 300, 30);
        sessionBox.setFont(textFont);
        sessionBox.setForeground(Color.black);
        inputPanel.add(sessionBox);


        JLabel idLabel = new JLabel("Student ID :");
        idLabel.setBounds(200, 180, 150, 30);
        idLabel.setForeground(Color.white);
        idLabel.setFont(labelFont);
        inputPanel.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(350, 180, 300, 30);
        idField.setFont(textFont);
        inputPanel.add(idField);

        JLabel creditLabel = new JLabel("Credit :");
        creditLabel.setBounds(200, 240, 150, 30);
        creditLabel.setForeground(Color.white);
        creditLabel.setFont(labelFont);
        inputPanel.add(creditLabel);

        JTextField creditField = new JTextField();
        creditField.setBounds(350, 240, 300, 30);
        creditField.setFont(textFont);
        inputPanel.add(creditField);

        JLabel cgpaLabel = new JLabel("CGPA :");
        cgpaLabel.setBounds(200, 300, 150, 30);
        cgpaLabel.setForeground(Color.white);
        cgpaLabel.setFont(labelFont);
        inputPanel.add(cgpaLabel);

        JTextField cgpaField = new JTextField();
        cgpaField.setBounds(350, 300, 300, 30);
        cgpaField.setFont(textFont);
        inputPanel.add(cgpaField);

        JLabel gradeLabel = new JLabel("Grade :");
        gradeLabel.setBounds(200, 360, 150, 30);
        gradeLabel.setForeground(Color.white);
        gradeLabel.setFont(labelFont);
        inputPanel.add(gradeLabel);

        JTextField gradeField = new JTextField();
        gradeField.setBounds(350, 360, 300, 30);
        gradeField.setFont(textFont);
        inputPanel.add(gradeField);

        JButton btnInsert = new JButton("Insert");
        btnInsert.setBounds(372, 420, 130, 35);
        btnInsert.setFont(new Font("Georgia", Font.BOLD, 18));
        btnInsert.setBackground(new Color(0, 0, 0));
        btnInsert.setForeground(Color.WHITE);
        Cursor curInsert = new Cursor(Cursor.HAND_CURSOR);
        btnInsert.setCursor(curInsert);
        btnInsert.setBorder(new LineBorder(Color.cyan));
        inputPanel.add(btnInsert);

        setVisible(true);

        btnInsert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String department = departmentBox.getSelectedItem().toString();
                String session = sessionBox.getSelectedItem().toString();
                String studentID = idField.getText();
                String credit = creditField.getText();
                String cgpa = cgpaField.getText();
                String grade = gradeField.getText();
                String query = "INSERT INTO `result_sheet`(`department`, `session`, `studentID`, `credit`, `cgpa`, `grade`) VALUES ('"+department+"','"+session+"','"+studentID+"','"+credit+"','"+cgpa+"','"+grade+"')";
                DbConnect db = new DbConnect();
                db.resultInsert(query);
            }
        });
    }
}
