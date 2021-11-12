package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CourseRegistration extends JFrame{
    String department[] = {"Choose Your Department", "Computer Science and Engineering", "Electrical and Electronics Engineering",
            "Bachelor of Business Administration"};

    JComboBox sectionBox, courseBox, additionalBox;
    DefaultTableModel model1, model2;
    JLabel labelOne, labelTwo, labelThree, labelFour, labelFive, labelSix;
    JTable table1, table2;
    JPanel rightPanel1, rightPanel2, rightPanel3;
    Connection con;
    Statement st;
    ResultSet rs;
    int counter1 = 0, flag1 =0;
    String combSection;
    double creditSum1 = 0.0, creditSum2 = 0.0, regularFees = 0.0, additionalFees =  0.0;

    public CourseRegistration(){
        setSize(900, 650);
        setTitle("Course Registration");
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

        JLabel headerText = new JLabel("Registration Dashboard !!");
        headerText.setForeground(Color.white);
        headerText.setBounds(232,  5, 410, 50);
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerPanel.add(headerText);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(5, 20, 40, 18);
        btnBack.setFont(new Font("Georgia", Font.PLAIN, 13));
        btnBack.setBackground(new Color(102, 51, 0));
        btnBack.setForeground(Color.WHITE);
        Cursor curback = new Cursor(Cursor.HAND_CURSOR);
        btnBack.setCursor(curback);
        btnBack.setBorder(new LineBorder(Color.cyan));
        headerPanel.add(btnBack);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0, 57, 77));
        leftPanel.setBounds(5, 70, 434, 535);
        add(leftPanel);
        leftPanel.setLayout(null);

        rightPanel1 = new JPanel();
        rightPanel1.setBackground(new Color(0, 57, 77));
        rightPanel1.setBounds(444, 70, 434, 190);//535
        add(rightPanel1);
        //rightPanel1.setLayout(null);

        rightPanel2 = new JPanel();
        rightPanel2.setBackground(new Color(0, 57, 77));
        rightPanel2.setBounds(444, 265, 434, 120);
        add(rightPanel2);

        rightPanel3 = new JPanel();
        rightPanel3.setBackground(new Color(0, 57, 77));
        rightPanel3.setBounds(444, 390, 434, 214);
        rightPanel3.setLayout(null);
        add(rightPanel3);

        Font labelFont = new Font("Georgia", Font.BOLD, 17);
        Font textFont = new Font("Arial", Font.BOLD, 13);

        JLabel deptLabel = new JLabel("Department: ");
        deptLabel.setBounds(20, 20, 130, 30);
        deptLabel.setForeground(Color.white);
        deptLabel.setFont(labelFont);
        leftPanel.add(deptLabel);

        JComboBox departmentBox = new JComboBox(department);
        departmentBox.setBounds(160, 20, 260, 30);
        departmentBox.setFont(textFont);
        departmentBox.setForeground(Color.black);
        leftPanel.add(departmentBox);

        JLabel sectionLabel = new JLabel();
        sectionLabel.setText("Section :");
        sectionLabel.setBounds(20, 80, 110, 30);
        sectionLabel.setFont(labelFont);
        sectionLabel.setForeground(Color.white);
        leftPanel.add(sectionLabel);

        sectionBox = new JComboBox();
        sectionBox.setBounds(160, 80, 260, 30);
        leftPanel.add(sectionBox);

        JLabel courseLabel = new JLabel();
        courseLabel.setText("Course Name :");
        courseLabel.setBounds(20, 140, 130, 30);
        courseLabel.setFont(labelFont);
        courseLabel.setForeground(Color.white);
        leftPanel.add(courseLabel);

        courseBox = new JComboBox();
        courseBox.setBounds(160, 140, 260, 30);
        leftPanel.add(courseBox);

        JButton btnAdd1 = new JButton("Add");
        btnAdd1.setBounds(160, 245, 80, 30);//177
        btnAdd1.setFont(new Font("Georgia", Font.BOLD, 18));
        btnAdd1.setBackground(new Color(0, 0, 0));
        btnAdd1.setForeground(Color.WHITE);
        Cursor curAdd1 = new Cursor(Cursor.HAND_CURSOR);
        btnAdd1.setCursor(curAdd1);
        btnAdd1.setBorder(new LineBorder(Color.cyan));
        leftPanel.add(btnAdd1);

        JLabel addiCourseLabel = new JLabel();
        addiCourseLabel.setText("Additional :");
        addiCourseLabel.setBounds(20, 300, 130, 30);
        addiCourseLabel.setFont(labelFont);
        addiCourseLabel.setForeground(Color.white);
        leftPanel.add(addiCourseLabel);

        model1 = new DefaultTableModel();
        table1 = new JTable(model1);
        table1.setPreferredScrollableViewportSize(new Dimension(400, 150));
        table1.setFillsViewportHeight(true);
        rightPanel1.add(new JScrollPane(table1));
        model1.addColumn("Reg. Course Name");
        model1.addColumn("Credit");
        model1.addColumn("Course Fee");

        additionalBox = new JComboBox();
        additionalBox.setBounds(160, 300, 260, 30);
        additionalBox.setFont(textFont);
        additionalBox.setForeground(Color.black);
        leftPanel.add(additionalBox);

        model2 = new DefaultTableModel();
        table2 = new JTable(model2);
        table2.setPreferredScrollableViewportSize(new Dimension(400, 80));
        table2.setFillsViewportHeight(true);
        rightPanel2.add(new JScrollPane(table2));
        model2.addColumn("Add. Course Name");
        model2.addColumn("Credit");
        model2.addColumn("Course Fee");

        JLabel regularCreditLabel = new JLabel("Regular Course Credit :");
        regularCreditLabel.setBounds(20, 20, 200, 25);
        regularCreditLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        regularCreditLabel.setForeground(Color.white);
        rightPanel3.add(regularCreditLabel);

        JLabel AdditionalCreditLabel = new JLabel("Additional Course Credit :");
        AdditionalCreditLabel.setBounds(20, 50, 200, 25);
        AdditionalCreditLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        AdditionalCreditLabel.setForeground(Color.white);
        rightPanel3.add(AdditionalCreditLabel);

        JLabel regularFeesLabel = new JLabel("Regular Course Fees :");
        regularFeesLabel.setBounds(20, 80, 200, 25);
        regularFeesLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        regularFeesLabel.setForeground(Color.white);
        rightPanel3.add(regularFeesLabel);

        JLabel additionalFeesLabel = new JLabel("Additional Course Fees :");
        additionalFeesLabel.setBounds(20, 110, 200, 25);
        additionalFeesLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        additionalFeesLabel.setForeground(Color.white);
        rightPanel3.add(additionalFeesLabel);

        JLabel othersFeesLabel = new JLabel("Others Fees :");
        othersFeesLabel.setBounds(20, 140, 150, 25);
        othersFeesLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        othersFeesLabel.setForeground(Color.white);
        rightPanel3.add(othersFeesLabel);

        JLabel totalFeesLabel = new JLabel("Total Fees :");
        totalFeesLabel.setBounds(20, 170, 150, 25);
        totalFeesLabel.setFont(new Font("Georgia", Font.BOLD, 15));
        totalFeesLabel.setForeground(Color.white);
        rightPanel3.add(totalFeesLabel);

        labelOne = new JLabel();
        labelOne.setBounds(250, 20, 100, 25);
        labelOne.setForeground(Color.white);
        labelOne.setFont(labelFont);
        rightPanel3.add(labelOne);

        labelTwo = new JLabel();
        labelTwo.setBounds(250, 50, 100, 25);
        labelTwo.setForeground(Color.white);
        labelTwo.setFont(labelFont);
        rightPanel3.add(labelTwo);

        labelThree = new JLabel();
        labelThree.setBounds(250, 80, 100, 25);
        labelThree.setForeground(Color.white);
        labelThree.setFont(labelFont);
        rightPanel3.add(labelThree);

        labelFour = new JLabel();
        labelFour.setBounds(250, 110, 100, 25);
        labelFour.setForeground(Color.white);
        labelFour.setFont(labelFont);
        rightPanel3.add(labelFour);

        labelFive = new JLabel();
        labelFive.setBounds(250, 140, 100, 25);
        labelFive.setForeground(Color.white);
        labelFive.setFont(labelFont);
        rightPanel3.add(labelFive);

        labelSix = new JLabel();
        labelSix.setBounds(250, 170, 100, 25);
        labelSix.setForeground(Color.white);
        labelSix.setFont(labelFont);
        rightPanel3.add(labelSix);

        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(160, 485, 120, 30);//177
        btnSubmit.setFont(new Font("Georgia", Font.BOLD, 18));
        btnSubmit.setBackground(new Color(0, 0, 0));
        btnSubmit.setForeground(Color.WHITE);
        Cursor curSubmit = new Cursor(Cursor.HAND_CURSOR);
        btnSubmit.setCursor(curSubmit);
        btnSubmit.setBorder(new LineBorder(Color.cyan));
        leftPanel.add(btnSubmit);

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StudentPortal();
            }
        });

        btnAdd1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Department = departmentBox.getSelectedItem().toString();
                String Section = sectionBox.getSelectedItem().toString();
                String Query = "SELECT * FROM `course_offering`";
                courseFee(Department, Section, Query);
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelFive.setText("6000.0");
                Double othersFees = Double.parseDouble(labelFive.getText());
                Double regFees = Double.parseDouble(labelThree.getText());
                Double addFees = Double.parseDouble(labelFour.getText());
                Double total = regFees + addFees + othersFees;
                labelSix.setText(String.valueOf(total));
            }
        });

        departmentBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String item = (String) e.getItem();
                switch (item) {
                    case "Choose Your Department":
                        sectionBox.removeAllItems();
                        break;
                    case "Computer Science and Engineering":
                        sectionBox.removeAllItems();
                        courseBox.removeAllItems();
                        sectionBox.addItem("1");
                        sectionBox.addItem("2");
                        sectionBox.addItem("3(A)");
                        sectionBox.addItem("3(B)");
                        sectionBox.addItem("3(C)");
                        sectionBox.addItem("4");
                        sectionBox.addItem("5");
                        sectionBox.addItem("6(A)");
                        sectionBox.addItem("6(B)");
                        sectionBox.addItem("6(C)");
                        sectionBox.addItem("7");
                        sectionBox.addItem("8");
                        sectionBox.addItem("9(A)");
                        sectionBox.addItem("9(B)");
                        sectionBox.addItem("9(C)");
                        sectionBox.addItem("10");
                        sectionBox.addItem("11");
                        sectionBox.addItem("12(A)");
                        sectionBox.addItem("12(B)");
                        sectionBox.addItem("12(C)");
                        sectionBox.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent e) {
                                String item = (String) e.getItem();
                                switch (item) {
                                    case "Choose Your Section":
                                        courseBox.removeAllItems();
                                        break;
                                    case "1":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("English Reading and Speaking");
                                        courseBox.addItem("Bangladesh Studies");
                                        courseBox.addItem("Introduction to Computers");
                                        courseBox.addItem("Introduction to Computers Sessional");
                                        courseBox.addItem("Differential and Integral Calculus");
                                        courseBox.addItem("Engineering drawing");
                                        break;
                                    case "2":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Computer Programming");
                                        courseBox.addItem("Computer Programming Sessional");
                                        courseBox.addItem("Discrete Mathematics");
                                        courseBox.addItem("Introduction to Sociology");
                                        courseBox.addItem("Linear Algebra & Complex Analysis");
                                        break;
                                    case "3(A)":
                                    case "3(B)":
                                    case "3(C)":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("English Writing and Listening");
                                        courseBox.addItem("Introduction to Sociology");
                                        courseBox.addItem("Data Structures");
                                        courseBox.addItem("Data Structures Sessional");
                                        courseBox.addItem("Differential Equations and Fourier Analysis");
                                        break;
                                    case "4":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Computer Algorithms and Complexity");
                                        courseBox.addItem("Computer Algorithms and Complexity Sessional");
                                        courseBox.addItem("Chemistry");
                                        courseBox.addItem("Chemistry: Sessional");
                                        courseBox.addItem("Principles of Accounting");
                                        courseBox.addItem("Co-Ordinate Geometry and Vector Analysis");
                                        courseBox.addItem("Electrical Circuits I Sessional");
                                        break;
                                    case "5":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Chemistry");
                                        courseBox.addItem("Chemistry: Sessional");
                                        courseBox.addItem("Co-Ordinate Geometry and Vector Analysis");
                                        courseBox.addItem("Object-Oriented Programming");
                                        courseBox.addItem("Object-Oriented Programming Sessional");
                                        courseBox.addItem("Electrical Circuits I Sessional");
                                        courseBox.addItem("Principles of Accounting");
                                        break;
                                    case "6(A)":
                                    case "6(B)":
                                    case "6(C)":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Java Programming");
                                        courseBox.addItem("Java Programming Sessional");
                                        courseBox.addItem("Digital Electronics");
                                        courseBox.addItem("Digital Electronics Sessional");
                                        courseBox.addItem("Database Management System");
                                        courseBox.addItem("Database Management System Sessional");
                                        courseBox.addItem("Probability and Statistics");
                                        break;
                                    case "7":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Theory of Computation");
                                        courseBox.addItem("Computer Networks");
                                        courseBox.addItem("Computer Networks Sessional");
                                        courseBox.addItem("Electronics");
                                        courseBox.addItem("Electronics Sessional");
                                        courseBox.addItem("Professional Ethics");
                                        break;
                                    case "8":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Electronics");
                                        courseBox.addItem("Electronics Sessional");
                                        courseBox.addItem("Operating System");
                                        courseBox.addItem("Operating System Sessional");
                                        courseBox.addItem("Professional Ethics");
                                        courseBox.addItem("Java Programming");
                                        courseBox.addItem("Java Programming Sessional");
                                        break;
                                    case "9(A)":
                                    case "9(B)":
                                    case "9(C)":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Microprocessor, Assembly Language and Computer Interfacing");
                                        courseBox.addItem("Microprocessor, Assembly Language, and Computer Interfacing Sessional");
                                        courseBox.addItem("Electronics Sessional");
                                        courseBox.addItem("Compiler Design and Construction");
                                        courseBox.addItem("Compiler Design and Construction Sessional");
                                        courseBox.addItem("Management Information System");
                                        courseBox.addItem("Project-I");
                                        break;
                                    case "10":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Digital Signal Processing");
                                        courseBox.addItem("Digital Signal Processing Sessional");
                                        courseBox.addItem("Artificial Intelligence");
                                        courseBox.addItem("Computer Graphics");
                                        courseBox.addItem("Computer Graphics Sessional");
                                        break;
                                    case "11":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Computer Security & Cryptography");
                                        courseBox.addItem("Project / Thesis (part 1)");
                                        courseBox.addItem("VLSI 1");
                                        courseBox.addItem("VLSI 1 Sessional");
                                        courseBox.addItem("Web Technologies");
                                        courseBox.addItem("Web Technologies Sessional");
                                        break;
                                    case "12(A)":
                                    case "12(B)":
                                    case "12(C)":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Project / Thesis (Part 2)");
                                        break;
                                }
                            }
                        });
                        additionalBox.addItem("Differential and Integral Calculus");
                        additionalBox.addItem("English Reading and Speaking");
                        additionalBox.addItem("Linear Algebra & Complex Analysis");
                        additionalBox.addItem("Discrete Mathematics");
                        additionalBox.addItem("Computer Programming");
                        additionalBox.addItem("Operating System");
                        additionalBox.addItem("Differential Equations and Fourier Analysis");
                        additionalBox.addItem("Computer Algorithms and Complexity");
                        additionalBox.addItem("Computer Algorithms and Complexity Sessional");
                        additionalBox.addItem("Co-Ordinate Geometry and Vector Analysis");
                        additionalBox.addItem("Object-Oriented Programming");
                        additionalBox.addItem("Object-Oriented Programming Sessional");
                        additionalBox.addItem("Java Programming");
                        additionalBox.addItem("Digital Electronics");
                        additionalBox.addItem("Database Management System");
                        additionalBox.addItem("Computer Networks");
                        additionalBox.addItem("Microprocessor, Assembly Language and Computer Interfacing");
                        additionalBox.addItem("Compiler Design and Construction");
                        additionalBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int index = additionalBox.getSelectedIndex();
                                String itemName = additionalBox.getSelectedItem().toString();
                                String itemQuery = "SELECT * FROM `additional_course`";
                                additionalBox.removeItemAt(index);
                                findItem(itemName, itemQuery);
                            }
                        });

                        break;
                    case "Electrical and Electronics Engineering":
                        sectionBox.removeAllItems();
                        courseBox.removeAllItems();
                        sectionBox.addItem("2");
                        sectionBox.addItem("3");
                        sectionBox.addItem("5");
                        sectionBox.addItem("6");
                        sectionBox.addItem("7");
                        sectionBox.addItem("8");
                        sectionBox.addItem("9");
                        sectionBox.addItem("10");
                        sectionBox.addItem("12");
                        sectionBox.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent e) {
                                String item = (String) e.getItem();
                                switch (item) {
                                    case "Choose Your Section":
                                        courseBox.removeAllItems();
                                        break;
                                    case "2":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Introduction to Sociology");
                                        courseBox.addItem("Differential and Integral Calculus");
                                        courseBox.addItem("Mechanical Engineering Fundamentals");
                                        courseBox.addItem("Mechanical Engineering Fundamentals Lab");
                                        courseBox.addItem("Physics I");
                                        courseBox.addItem("Physics I Lab");
                                        break;
                                    case "3":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Electronics I");
                                        courseBox.addItem("Electronics Circuit Simulation Lab");
                                        courseBox.addItem("Differential and Integral Calculus II");
                                        courseBox.addItem("Mechanical Engineering Fundamentals II");
                                        courseBox.addItem("Mechanical Engineering Fundamentals II Lab");
                                        courseBox.addItem("Physics II");
                                        courseBox.addItem("Physics II Lab");
                                        break;
                                    case "5":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Electronics II");
                                        courseBox.addItem("Electronics Circuit Simulation II Lab");
                                        courseBox.addItem("Mechanical Engineering Fundamentals III");
                                        courseBox.addItem("Mechanical Engineering Fundamentals III Lab");
                                        courseBox.addItem("Physics III");
                                        courseBox.addItem("Physics III Lab");
                                        break;
                                    case "6":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Computer Aided Engineering Drawing");
                                        courseBox.addItem("Numerical Methods");
                                        courseBox.addItem("Numerical Methods Lab");
                                        courseBox.addItem("Energy Conversion Lab");
                                        courseBox.addItem("Electronics II");
                                        courseBox.addItem("Electronics II Lab");
                                        courseBox.addItem("Mechanical Engineering Fundamentals IV");
                                        courseBox.addItem("Mechanical Engineering Fundamentals IV Lab");
                                        break;
                                    case "7":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Computer Aided Engineering Drawing II");
                                        courseBox.addItem("Energy Conversion Lab II");
                                        courseBox.addItem("Digital Electronics");
                                        courseBox.addItem("Digital Electronics Lab");
                                        courseBox.addItem("Signals and Linear Systems");
                                        courseBox.addItem("Signals and Linear Systems Lab");
                                        courseBox.addItem("Power System I Lab");
                                        courseBox.addItem("Mechanical Engineering Fundamentals V");
                                        courseBox.addItem("Mechanical Engineering Fundamentals V Lab");
                                        break;
                                    case "8":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Computer Aided Engineering Drawing III");
                                        courseBox.addItem("Energy Conversion Lab III");
                                        courseBox.addItem("Digital Electronics II");
                                        courseBox.addItem("Digital Electronics II Lab");
                                        courseBox.addItem("Signals and Linear Systems II");
                                        courseBox.addItem("Signals and Linear Systems II Lab");
                                        courseBox.addItem("Power System II Lab");
                                        courseBox.addItem("Mechanical Engineering Fundamentals II");
                                        courseBox.addItem("Mechanical Engineering Fundamentals II Lab");
                                        break;
                                    case "9":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Digital Electronics Lab");
                                        courseBox.addItem("Basic Communication Engineering");
                                        courseBox.addItem("Basic Communication Engineering Lab");
                                        courseBox.addItem("Control System I");
                                        courseBox.addItem("Control System I Lab");
                                        courseBox.addItem("Electrical Services Design");
                                        courseBox.addItem("Power Plant Engineering");
                                        courseBox.addItem("Renewable Energy Conversion");
                                        courseBox.addItem("VLSI I");
                                        courseBox.addItem("VLSI I Lab");
                                        break;
                                    case "10":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Renewable Energy Conversion II");
                                        courseBox.addItem("Basic Communication Engineering II");
                                        courseBox.addItem("Basic Communication Engineering II Lab");
                                        courseBox.addItem("Control System II");
                                        courseBox.addItem("Control System II Lab");
                                        courseBox.addItem("Digital Signal Processing I");
                                        courseBox.addItem("Digital Signal Processing I Lab");
                                        break;
                                    case "12":
                                        courseBox.removeAllItems();
                                        courseBox.addItem("Digital Communication Lab");
                                        courseBox.addItem("Digital Signal Processing II");
                                        courseBox.addItem("Digital Signal Processing II Lab");
                                        courseBox.addItem("Power Electronics Lab");
                                        courseBox.addItem("Measurement and Instrumentation");
                                        courseBox.addItem("Project / Thesis (Finalize & Submission)");
                                        break;
                                }
                            }
                        });
                        additionalBox.addItem("Introduction to Sociology");
                        additionalBox.addItem("Digital Signal Processing II");
                        additionalBox.addItem("Basic Communication Engineering II");
                        additionalBox.addItem("Mechanical Engineering Fundamentals");
                        additionalBox.addItem("Mechanical Engineering Fundamentals III");
                        additionalBox.addItem("Computer Aided Engineering Drawing");
                        additionalBox.addItem("Numerical Methods");
                        additionalBox.addItem("Energy Conversion Lab");
                        additionalBox.addItem("Power Plant Engineering");
                        additionalBox.addItem("Signals and Linear Systems");
                        additionalBox.addItem("Digital Electronics II");
                        additionalBox.addItem("Electrical Services Design");
                        additionalBox.addItem("Differential and Integral Calculus II");
                        additionalBox.addItem("Power Electronics Lab");
                        additionalBox.addItem("VLSI I");
                        additionalBox.addItem("Physics III");
                        additionalBox.addItem("Signals and Linear Systems");
                        additionalBox.addItem("Control System II");
                        additionalBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int index = additionalBox.getSelectedIndex();
                                String itemName = additionalBox.getSelectedItem().toString();
                                String itemQuery = "SELECT * FROM `additional_course`";
                                additionalBox.removeItemAt(index);
                                findItem(itemName, itemQuery);
                            }
                        });
                        break;
//                    case "Bachelor of Business Administration":
//                        sectionBox.removeAllItems();
//                        courseBox.removeAllItems();
//                        sectionBox.addItem("1");
//                        sectionBox.addItem("2");
//                        sectionBox.addItem("3");
//                        sectionBox.addItem("4");
//                        sectionBox.addItem("5");
//                        sectionBox.addItem("6");
//                        sectionBox.addItem("7");
//                        sectionBox.addItem("8");
//                        sectionBox.addItem("9");
//                        sectionBox.addItem("10");
//                        sectionBox.addItem("11");
//                        sectionBox.addItem("12");
//                        break;
                }
            }
        });

        setVisible(true);
    }

    private void courseFee(String department, String section, String query){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
            st = con.createStatement();
            rs = st.executeQuery(query);

            if(department.equals("Computer Science and Engineering")){
                if(section.equals("1")){
                    combSection = "cse_1";
                }
                else if(section.equals("2")){
                    combSection = "cse_2";
                }
                else if(section.equals("3(A)")){
                    combSection = "cse_3(A)";
                }
                else if(section.equals("3(B)")){
                    combSection = "cse_3(B)";
                }
                else if(section.equals("3(C)")){
                    combSection = "cse_3(C)";
                }
                else if(section.equals("4")){
                    combSection = "cse_4";
                }
                else if(section.equals("5")){
                    combSection = "cse_5";
                }
                else if(section.equals("6(A)")){
                    combSection = "cse_6(A)";
                }
                else if(section.equals("6(B)")){
                    combSection = "cse_6(B)";
                }
                else if(section.equals("6(C)")){
                    combSection = "cse_6(C)";
                }
                else if(section.equals("7")){
                    combSection = "cse_7";
                }
                else if(section.equals("8")){
                    combSection = "cse_8";
                }
                else if(section.equals("9(A)")){
                    combSection = "cse_9(A)";
                }
                else if(section.equals("9(B)")){
                    combSection = "cse_9(B)";
                }
                else if(section.equals("9(C)")){
                    combSection = "cse_9(C)";
                }
                else if(section.equals("10")){
                    combSection = "cse_10";
                }
                else if(section.equals("11")){
                    combSection = "cse_11";
                }
                else if(section.equals("12(A)")){
                    combSection = "cse_12(A)";
                }
                else if(section.equals("12(B)")){
                    combSection = "cse_12(B)";
                }
                else if(section.equals("12(C)")){
                    combSection = "cse_12(C)";
                }
            }
            else if(department.equals("Electrical and Electronics Engineering"))
            {
                if(section.equals("2")){
                    combSection = "eee_2";
                }
                else if(section.equals("3")){
                    combSection = "eee_3";
                }
                else if(section.equals("5")){
                    combSection = "eee_5";
                }
                else if(section.equals("6")){
                    combSection = "eee_6";
                }
                else if(section.equals("7")){
                    combSection = "eee_7";
                }
                else if(section.equals("8")){
                    combSection = "eee_8";
                }
                else if(section.equals("9")){
                    combSection = "eee_9";
                }
                else if(section.equals("10")){
                    combSection = "eee_10";
                }
                else if(section.equals("12")){
                    combSection = "eee_12";
                }
            }
            while(rs.next()) {
//                String tableDepartment = rs.getNString(4);
                String tableSection = rs.getNString(3);
                String tableCredit = rs.getNString(6);
                String tableCourseName = rs.getString(5);
                String tableFee = rs.getNString(7);

                if(tableSection.equals(combSection)){
                    flag1 = 1;
                    model1.addRow(new Object[]{tableCourseName, tableCredit, tableFee});
                    counter1 += 1;
                    rightPanel1.setVisible(true);
                    rightPanel1.validate();
                }
            }
            for(int i=0; i<model1.getRowCount(); i++){
                creditSum1 += Double.parseDouble(String.valueOf(model1.getValueAt(i, 1)));
            }
            for(int i=0; i<model1.getRowCount(); i++){
                regularFees += Double.parseDouble(String.valueOf(model1.getValueAt(i, 2)));
            }
            labelOne.setText(String.valueOf(creditSum1));
            labelThree.setText(String.valueOf(regularFees));

        }catch (Exception e) {
            System.err.println("Error: "+e);
        }
    }
    private void findItem(String itemName, String itemQuery) {
        String tableCredit = null, tableCourseName = null, tableFee = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
            st = con.createStatement();
            rs = st.executeQuery(itemQuery);
            while (rs.next()){
                tableCredit = rs.getNString(3);
                tableCourseName = rs.getString(2);
                tableFee = rs.getNString(4);;
                if(itemName.equals(tableCourseName)){
                    model2.addRow(new Object[]{tableCourseName, tableCredit, tableFee});
                    rightPanel2.setVisible(true);
                    rightPanel2.validate();
                    creditSum2 += Double.parseDouble(String.valueOf(tableCredit));
                    additionalFees += Double.parseDouble(String.valueOf(tableFee));
                }
            }

            labelTwo.setText(String.valueOf(creditSum2));
            labelFour.setText(String.valueOf(additionalFees));
        }catch (Exception e){
            System.err.println("Error: "+e);
        }
    }
}

