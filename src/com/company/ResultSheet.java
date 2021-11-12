package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResultSheet extends JFrame {
    private Connection con;
    private Statement st;
    private ResultSet rsfResult, rsfInfo;
    private int counter, flag = 0;
    Double creditSum, cgpaSum, cgpa;
    //String Department = null;
    JFrame frame;
    JLabel label1, label2, label3, label4, label5, label6;
    DefaultTableModel model;
    JTable table;
    JPanel rightPanel;
    public ResultSheet(){
        frame = new JFrame();
        frame.setSize(900, 650);
        frame.setTitle("Result Sheet");
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.black);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(102, 51, 0));
        headerPanel.setBounds(5, 5, 874, 60);
        headerPanel.setLayout(null);
        frame.add(headerPanel);

        JLabel headerText = new JLabel("Result Sheet !!");
        headerText.setForeground(Color.white);
        headerText.setBounds(322,  5, 230, 50);
        //headerText.setBorder(new LineBorder(Color.cyan));
        headerText.setFont(new Font("Georgia", Font.BOLD, 30));
        headerPanel.add(headerText);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(5, 20, 40, 18);
        btnBack.setFont(new Font("Georgia", Font.PLAIN, 13));
        //btnBack.setBackground(new Color(0, 0, 0));
        btnBack.setBackground(new Color(102, 51, 0));
        btnBack.setForeground(Color.WHITE);
        Cursor curBack = new Cursor(Cursor.HAND_CURSOR);
        btnBack.setCursor(curBack);
        btnBack.setBorder(new LineBorder(Color.cyan));
        headerPanel.add(btnBack);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0, 57, 77));
        leftPanel.setBounds(5, 70, 478, 536);
        frame.add(leftPanel);
        leftPanel.setLayout(null);

        Font labelFont = new Font("Georgia", Font.BOLD, 17);
        Font textFont = new Font("Arial", Font.BOLD, 15);


        JLabel idLabel = new JLabel("Student ID :");
        idLabel.setBounds(90, 140, 150, 25);
        idLabel.setForeground(Color.white);
        idLabel.setFont(labelFont);
        leftPanel.add(idLabel);

        label2 = new JLabel();
        label2.setBounds(280, 140, 200, 25);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Georgia", Font.BOLD, 19));
        leftPanel.add(label2);

        JLabel semesterLabel = new JLabel("Semester :");
        semesterLabel.setBounds(100, 195, 150, 25);
        semesterLabel.setForeground(Color.white);
        semesterLabel.setFont(labelFont);
        leftPanel.add(semesterLabel);

        label3 = new JLabel();
        label3.setBounds(280, 195, 200, 25);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Georgia", Font.BOLD, 19));
        leftPanel.add(label3);

        JLabel gradeLabel = new JLabel("Grade :");
        gradeLabel.setBounds(130, 250, 150, 25);
        gradeLabel.setForeground(Color.white);
        gradeLabel.setFont(labelFont);
        leftPanel.add(gradeLabel);

        label4 = new JLabel();
        label4.setBounds(280, 250, 200, 25);
        label4.setForeground(Color.white);
        label4.setFont(new Font("Georgia", Font.BOLD, 19));
        leftPanel.add(label4);

        JLabel cgpaLabel = new JLabel("CGPA :");
        cgpaLabel.setBounds(130, 305, 150, 25);
        cgpaLabel.setForeground(Color.white);
        cgpaLabel.setFont(labelFont);
        leftPanel.add(cgpaLabel);

        label5 = new JLabel();
        label5.setBounds(280, 305, 200, 25);
        label5.setForeground(Color.white);
        label5.setFont(new Font("Georgia", Font.BOLD, 19));
        leftPanel.add(label5);

        JLabel creditLabel = new JLabel("Credit Completed :");
        creditLabel.setBounds(30, 360, 200, 25);
        creditLabel.setForeground(Color.white);
        creditLabel.setFont(labelFont);
        leftPanel.add(creditLabel);

        label6 = new JLabel();
        label6.setBounds(280, 360, 200, 25);
        label6.setForeground(Color.white);
        label6.setFont(new Font("Georgia", Font.BOLD, 19));
        leftPanel.add(label6);

        JPanel upRightPanel = new JPanel();
        upRightPanel.setBackground(new Color(0, 57, 77));
        upRightPanel.setBounds(487, 70, 392, 150);
        frame.add(upRightPanel);
        upRightPanel.setLayout(null);

        JPanel lowRightPanel = new JPanel();
        lowRightPanel.setBackground(new Color(0, 57, 77));
        lowRightPanel.setBounds(487, 455, 392, 150);
        frame.add(lowRightPanel);
        lowRightPanel.setLayout(null);

        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(0, 57, 77));
        rightPanel.setBounds(487, 210, 392, 250);
        frame.add(rightPanel);
        rightPanel.setLayout(null);

        rightPanel.setLayout(new FlowLayout());
        model = new DefaultTableModel();
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(370, 200));
        table.setFillsViewportHeight(true);
        rightPanel.add(new JScrollPane(table));
        model.addColumn("Session");
        model.addColumn("Credit");
        model.addColumn("CGPA");
        model.addColumn("Grade");

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new StudentPortal();
            }
        });

        frame.setVisible(true);
    }

    public void fetchResult(String StudentID, String Department, String Semester) {
        String result_query = "SELECT * FROM `result_sheet`";
        String info_query = null;
        String Name;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
            st = con.createStatement();
            rsfResult = st.executeQuery(result_query);
            creditSum = 0.0;
            cgpaSum = 0.0;
            cgpa = 0.0;
            counter = 0;

            while(rsfResult.next()){
                String tableID = rsfResult.getString(4);
                String tableSession = rsfResult.getString(3);
                String tableCredit = rsfResult.getString(5);
                String tableCGPA = rsfResult.getString(6);
                String tableGrade = rsfResult.getString(7);

                if(tableID.equals(StudentID)){
                    flag = 1;
                    model.addRow(new Object[]{tableSession, tableCredit, tableCGPA, tableGrade});
                    counter +=1;
                    rightPanel.setVisible(true);
                    rightPanel.validate();
                }
            }
            for(int i=0; i<model.getRowCount(); i++){
                creditSum += Double.parseDouble(String.valueOf(model.getValueAt(i, 1)));
            }
            for(int i=0; i<model.getRowCount(); i++){
                cgpaSum += Double.parseDouble(String.valueOf(model.getValueAt(i, 2)));
            }
            cgpa = (cgpaSum/(double)counter);
            label6.setText(String.valueOf(creditSum));
            label5.setText(String.format("%.2f", cgpa));
            label2.setText(StudentID);
            label3.setText(Semester);
            if(cgpa==4.00){
                label4.setText("A+");
            }
            else if(cgpa>=3.75 && cgpa<4.00){
                label4.setText("A");
            }
            else if(cgpa>=3.50 && cgpa<3.75){
                label4.setText("A-");
            }
            else if(cgpa>=3.25 && cgpa<3.50){
                label4.setText("B+");
            }
            else if(cgpa>=3.00 && cgpa<3.25){
                label4.setText("B");
            }
            else if(cgpa>=2.75 && cgpa<3.00){
                label4.setText("B-");
            }
            else if(cgpa>=2.50 && cgpa<2.75){
                label4.setText("C+");
            }
            else if(cgpa>=2.25 && cgpa<2.50){
                label4.setText("C");
            }
            else if(cgpa>=2.00 && cgpa<2.25){
                label4.setText("D");
            }
            else{
                label4.setText("F");
            }

        }catch(Exception e){
            System.err.println("Error: "+e);
        }
    }
}
