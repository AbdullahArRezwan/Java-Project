package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class Registration extends JFrame{

    String department[] = {"Computer Science and Engineering", "Electrical and Electronics Engineering",
            "Bachelor of Business Administration", "English"};
    String semester[] =  {"Spring 2018", "Summer 2018", "Fall 2018",
            "Spring 2019", "Summer 2019", "Fall 2019", "Spring 2020", "Summer 2020",
            "Fall 2020", "Spring 2021", "Summer 2021", "Fall 2021"};
    String gender[] = {"Male", "Female"};
    int i=0, j=0, k=0;

    public Registration(){

        setSize(900, 650);
        setTitle("Registration Form");
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.black);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(Color.cyan);
        //headerPanel.setBackground(new Color(102, 51, 0));
        headerPanel.setBounds(5, 5, 874, 60);
        add(headerPanel);
        JLabel headerText = new JLabel("Registration Form !!");
        headerText.setForeground(Color.black);
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerPanel.add(headerText);

        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(new Color(0, 57, 77));
        inputPanel.setBounds(5, 70, 874, 536);
        add(inputPanel);
        inputPanel.setLayout(null);

        Font labelFont = new Font("Georgia", Font.BOLD, 15);
        Font textFont = new Font("Arial", Font.BOLD, 13);

        JLabel nameLabel = new JLabel("Name :");
        nameLabel.setBounds(112, 40, 63, 30);
        nameLabel.setForeground(Color.white);
        nameLabel.setFont(labelFont);
//        nameLabel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        inputPanel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(180, 40, 230, 30);
        nameField.setFont(textFont);
        inputPanel.add(nameField);

        JLabel birthLabel = new JLabel("Date of Birth :");
        birthLabel.setBounds(60, 110, 115, 30);
        birthLabel.setForeground(Color.white);
        birthLabel.setFont(labelFont);
//        birthLabel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        inputPanel.add(birthLabel);

        JTextField birthField = new JTextField("dd-mm-yyyy");
        birthField.setBounds(180, 110, 230, 30);
        birthField.setFont(textFont);
        inputPanel.add(birthField);

        JLabel emailLabel = new JLabel("Email :");
        emailLabel.setBounds(112, 180, 63, 30);
        emailLabel.setForeground(Color.white);
        emailLabel.setFont(labelFont);
//        emailLabel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        inputPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(180, 180, 230, 30);
        emailField.setFont(textFont);
        inputPanel.add(emailField);

        JLabel passLabel = new JLabel("Password :");
        passLabel.setBounds(83, 250, 92, 30);
        passLabel.setForeground(Color.white);
        passLabel.setFont(labelFont);
//        passLabel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        inputPanel.add(passLabel);

        JTextField passField = new JTextField();
        passField.setBounds(180, 250, 230, 30);
        passField.setFont(textFont);
        inputPanel.add(passField);

        JLabel confirmPassLabel = new JLabel("Confirm Password :");
        confirmPassLabel.setBounds(15, 320, 160, 30);
        confirmPassLabel.setForeground(Color.white);
        confirmPassLabel.setFont(labelFont);
//        confirmPassLabel.setBorder(BorderFactory.createLineBorder(Color.white, 1));
        inputPanel.add(confirmPassLabel);

        JTextField confirmPassField = new JTextField();
        confirmPassField.setBounds(180, 320, 230, 30);
        confirmPassField.setFont(textFont);
        inputPanel.add(confirmPassField);

        JLabel genderLabel = new JLabel("Gender :");
        genderLabel.setBounds(102, 390, 73, 30);
        genderLabel.setForeground(Color.white);
        genderLabel.setFont(labelFont);
        inputPanel.add(genderLabel);

        JComboBox genderBox = new JComboBox(gender);
        genderBox.setBounds(180, 390, 230, 30);
        genderBox.setFont(textFont);
        genderBox.setForeground(Color.black);
        inputPanel.add(genderBox);

        JLabel sscLabel = new JLabel("SSC GPA :");
        sscLabel.setBounds(455, 40, 85, 30);
        sscLabel.setForeground(Color.white);
        sscLabel.setFont(labelFont);
        inputPanel.add(sscLabel);

        JTextField sscField = new JTextField();
        sscField.setBounds(580, 40, 260, 30);
        sscField.setFont(textFont);
        inputPanel.add(sscField);

        JLabel hscLabel = new JLabel("HSC GPA :");
        hscLabel.setBounds(455, 110, 120, 30);
        hscLabel.setForeground(Color.white);
        hscLabel.setFont(labelFont);
        inputPanel.add(hscLabel);

        JTextField hscField = new JTextField();
        hscField.setBounds(580, 110, 260, 30);
        hscField.setFont(textFont);
        inputPanel.add(hscField);

        JLabel deptLabel = new JLabel("Department :");
        deptLabel.setBounds(455, 180, 120, 30);
        deptLabel.setForeground(Color.white);
        deptLabel.setFont(labelFont);
        inputPanel.add(deptLabel);

        JComboBox departmentBox = new JComboBox(department);
        departmentBox.setBounds(580, 180, 260, 30);
        departmentBox.setFont(textFont);
        departmentBox.setForeground(Color.black);
        inputPanel.add(departmentBox);

        JLabel semesterLabel = new JLabel("Semester :");
        semesterLabel.setBounds(455, 250, 120, 30);
        semesterLabel.setForeground(Color.white);
        semesterLabel.setFont(labelFont);
        inputPanel.add(semesterLabel);

        JComboBox semesterBox = new JComboBox(semester);
        semesterBox.setBounds(580, 250, 260, 30);
        semesterBox.setFont(textFont);
        semesterBox.setForeground(Color.black);
        inputPanel.add(semesterBox);

        JLabel mobileLabel = new JLabel("Mobile :");
        mobileLabel.setBounds(455, 320, 120, 30);
        mobileLabel.setForeground(Color.white);
        mobileLabel.setFont(labelFont);
        inputPanel.add(mobileLabel);

        JTextField mobileField = new JTextField();
        mobileField.setBounds(580, 320, 260, 30);
        mobileField.setFont(textFont);
        inputPanel.add(mobileField);

        JLabel addressLabel = new JLabel("Address :");
        addressLabel.setBounds(455, 390, 120, 30);
        addressLabel.setForeground(Color.white);
        addressLabel.setFont(labelFont);
        inputPanel.add(addressLabel);

        JTextField addressField = new JTextField();
        addressField.setBounds(580, 390, 260, 30);
        addressField.setFont(textFont);
        inputPanel.add(addressField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(230, 460, 130, 30);
        btnLogin.setFont(new Font("Georgia", Font.BOLD, 17));
        btnLogin.setBackground(new Color(255, 255, 255));
        btnLogin.setForeground(Color.black);
        Cursor curLogin = new Cursor(Cursor.HAND_CURSOR);
        btnLogin.setCursor(curLogin);
        btnLogin.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        inputPanel.add(btnLogin);

        JButton btnRegistration = new JButton("Registration");
        btnRegistration.setBounds(470, 460, 150, 30);
        btnRegistration.setFont(new Font("Georgia", Font.BOLD, 18));
        btnRegistration.setBackground(new Color(255, 255, 255));
        btnRegistration.setForeground(Color.black);
        Cursor curRegistration = new Cursor(Cursor.HAND_CURSOR);
        btnRegistration.setCursor(curRegistration);
        btnRegistration.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        inputPanel.add(btnRegistration);

        JLabel haveAccLabel = new JLabel("If you already have an account, click Login button");
        haveAccLabel.setBounds(245, 500, 400, 20);
        haveAccLabel.setForeground(Color.white);
        haveAccLabel.setFont(new Font("Georgia", Font.BOLD, 13));
        inputPanel.add(haveAccLabel);

        setVisible(true);

        passField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Use at least One uppercase & lowercase letter, digit and special character ");
            }
        });

        birthField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                birthField.setText("");
            }
        });

        btnRegistration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String dateOfBirth = birthField.getText();
                String email = emailField.getText();
                String pass = passField.getText();
                String conPass = confirmPassField.getText();
                String ssc = sscField.getText();
                String hsc = hscField.getText();
                String department = departmentBox.getSelectedItem().toString();
                String semester = semesterBox.getSelectedItem().toString();
                String gender = genderBox.getSelectedItem().toString();
                String mobile = mobileField.getText();
                String address = addressField.getText();

                double dssc = Double.parseDouble(ssc);
                double dhsc = Double.parseDouble(hsc);
                int waiverv = 0;

                if(dssc==5.00 && dhsc==5.00){
                    waiverv = 50;
                }
                else if((dssc >= 4.50 && dssc <= 4.99) && (dhsc >=4.50 && dhsc <= 4.99)){
                    waiverv = 30;
                }
                else if(((dssc >= 4.00 && dssc <= 4.49) && (dhsc >=4.00 )) || ((dssc >= 4.00) && (dhsc >=4.00 && dhsc <= 4.49))){
                    waiverv = 15;
                }
                else if(((dssc >= 3.50 && dssc <= 3.99) && (dhsc >=3.50 )) || ((dssc >= 3.50) && (dhsc >=3.50 && dhsc <= 3.99))){
                    waiverv = 10;
                }
                String waiver = String.valueOf(waiverv);

                String nameRegex = "^[A-Za-z .]+$";
                String sscRegex = "^[2-5]([\\.]\\d{0,2})?";
                String hscRegex = "^[2-5]([\\.]\\d{0,2})?";
                String emailRegex = "[A-Za-z0-9+_.-]+@[\\w.-]+\\.[a-zA-z]{2,10}";
                String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
                String mobRegex = "(\\+880)?01[3-9]\\d{8}";


                if (!Pattern.matches(nameRegex, name)) {
                    JOptionPane.showMessageDialog(null, "Invalid Username");
                }
                else if (!Pattern.matches(sscRegex, ssc)) {
                    JOptionPane.showMessageDialog(null, "Invalid SSC grade point");
                }
                else if (!Pattern.matches(hscRegex, hsc)) {
                    JOptionPane.showMessageDialog(null, "Invalid HSC grade point");
                }
//                else if(dssc>5.00 && dhsc >5.00){
//                    JOptionPane.showMessageDialog(null, "SSC & HSC grade point must be less then or equal 5.00");
//                }
                else if (!Pattern.matches(emailRegex, email)) {
                    JOptionPane.showMessageDialog(null, "Invalid Email");
                }
                else if (!Pattern.matches(passRegex, pass)) {
                    JOptionPane.showMessageDialog(null, "Invalid password");
                }
                else if (!pass.equals(conPass)) {
                    JOptionPane.showMessageDialog(null, "Pass & Confirm Pass is not matching !");
                }
                else if (!Pattern.matches(mobRegex, mobile)) {
                    JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
                }
                else {
                    try {
                        DbConnect db = new DbConnect();
                        String queryInsert = null;

                        if(department.equals("Computer Science and Engineering")){
                            if(semester.equals("Spring 2018")){
                                queryInsert = "INSERT INTO `cse_spring18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2018")){
                                queryInsert = "INSERT INTO `cse_summer18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2018")){
                                queryInsert = "INSERT INTO `cse_fall18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2019")){
                                queryInsert = "INSERT INTO `cse_spring19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2019")){
                                queryInsert = "INSERT INTO `cse_summer19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2019")){
                                queryInsert = "INSERT INTO `cse_fall19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2020")){
                                queryInsert = "INSERT INTO `cse_spring20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2020")){
                                queryInsert = "INSERT INTO `cse_summer20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2020")){
                                queryInsert = "INSERT INTO `cse_fall20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2021")){
                                queryInsert = "INSERT INTO `cse_spring21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2021")){
                                queryInsert = "INSERT INTO `cse_summer21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2021")){
                                queryInsert = "INSERT INTO `cse_fall21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                        }
                        else if(department.equals("Electrical and Electronics Engineering")){
                            if(semester.equals("Spring 2018")){
                                queryInsert = "INSERT INTO `eee_spring18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2018")){
                                queryInsert = "INSERT INTO `eee_summer18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2018")){
                                queryInsert = "INSERT INTO `eee_fall18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2019")){
                                queryInsert = "INSERT INTO `eee_spring19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2019")){
                                queryInsert = "INSERT INTO `eee_summer19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2019")){
                                queryInsert = "INSERT INTO `eee_fall19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2020")){
                                queryInsert = "INSERT INTO `eee_spring20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2020")){
                                queryInsert = "INSERT INTO `eee_summer20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2020")){
                                queryInsert = "INSERT INTO `eee_fall20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2021")){
                                queryInsert = "INSERT INTO `eee_spring21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2021")){
                                queryInsert = "INSERT INTO `eee_summer21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2021")){
                                queryInsert = "INSERT INTO `eee_fall21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                        }
                        else if(department.equals("Bachelor of Business Administration")){
                            if(semester.equals("Spring 2018")){
                                queryInsert = "INSERT INTO `bba_spring18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2018")){
                                queryInsert = "INSERT INTO `bba_summer18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2018")){
                                queryInsert = "INSERT INTO `bba_fall18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2019")){
                                queryInsert = "INSERT INTO `bba_spring19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2019")){
                                queryInsert = "INSERT INTO `bba_summer19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2019")){
                                queryInsert = "INSERT INTO `bba_fall19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2020")){
                                queryInsert = "INSERT INTO `bba_spring20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2020")){
                                queryInsert = "INSERT INTO `bba_summer20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2020")){
                                queryInsert = "INSERT INTO `bba_fall20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2021")){
                                queryInsert = "INSERT INTO `bba_spring21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2021")){
                                queryInsert = "INSERT INTO `bba_summer21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2021")){
                                queryInsert = "INSERT INTO `bba_fall21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                        }
                        else if(department.equals("English")){
                            if(semester.equals("Spring 2018")){
                                queryInsert = "INSERT INTO `eng_spring18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2018")){
                                queryInsert = "INSERT INTO `eng_summer18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2018")){
                                queryInsert = "INSERT INTO `eng_fall18`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2019")){
                                queryInsert = "INSERT INTO `eng_spring19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2019")){
                                queryInsert = "INSERT INTO `eng_summer19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2019")){
                                queryInsert = "INSERT INTO `eng_fall19`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2020")){
                                queryInsert = "INSERT INTO `eng_spring20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2020")){
                                queryInsert = "INSERT INTO `eng_summer20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2020")){
                                queryInsert = "INSERT INTO `eng_fall20`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Spring 2021")){
                                queryInsert = "INSERT INTO `eng_spring21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Summer 2021")){
                                queryInsert = "INSERT INTO `eng_summer21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                            else if(semester.equals("Fall 2021")){
                                queryInsert = "INSERT INTO `eng_fall21`(`name`, `email`, `DoB`, `password`, `ssc`, `hsc`, `waiver`, `department`, `semester`, `gender`, `mobile`, `address`) VALUES ('"+name+"','"+email+"','"+dateOfBirth+"','"+pass+"','"+ssc+"','"+hsc+"','"+waiver+"','"+department+"','"+semester+"','"+gender+"','"+mobile+"','"+address+"')";
                            }
                        }
                        db.RegistrationInsert(queryInsert);
                    } catch (Exception e2) {
                    }
                }
            }
        });
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new UserLogin();
            }
        });
    }
}
