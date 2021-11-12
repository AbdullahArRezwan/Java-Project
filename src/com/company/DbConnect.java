package com.company;

import javax.swing.*;
import java.sql.*;

public class DbConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private int counter = 0;
    String tableName;

    public DbConnect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_project", "root", "");
            st = con.createStatement();
        } catch(Exception e){
            System.err.println("Error: "+e);
        }
    }
    public void RegistrationInsert(String queryInsert) {
        try {
            st.executeUpdate(queryInsert);
            JOptionPane.showMessageDialog(null, "Registration Complete !!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Registration not Completed!!"+ex);
        }
    }

    public void UserLogin(String loginEmail, String loginPass, String loginQuery) {
        try {
            rs = st.executeQuery(loginQuery);
            while(rs.next()){
                String tableEmail = rs.getNString(3);
                String tablePass = rs.getNString(5);


                if(loginEmail.equals(tableEmail) && loginPass.equals(tablePass)) {
                    counter = 1;
                    break;
                }
                else if(loginEmail.equals(tableEmail) && !loginPass.equals(tablePass)){
                    counter = 2;
                    break;
                }
            }
            if(counter == 1) {
                JOptionPane.showMessageDialog(null, "Welcome !!");
                new StudentPortal();
            }
            else if(counter == 2){
                JOptionPane.showMessageDialog(null, "Sorry !!, The password that you've entered is incorrect.");
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry !!, You are not a valid user.\nPlease press Registration button and create an account.");
            }

        } catch (Exception e) {
            System.err.println("Login Error: "+e);
        }
    }


    public void AdminLogin(String loginEmail, String loginPass, String loginQuery) {
        try {
            rs = st.executeQuery(loginQuery);
            while(rs.next()){
                String tableEmail = rs.getNString(2);
                String tablePass = rs.getNString(3);

                if(loginEmail.equals(tableEmail) && loginPass.equals(tablePass)) {
                    counter = 1;
                    break;
                }
                else if(loginEmail.equals(tableEmail) && !loginPass.equals(tablePass)){
                    counter = 2;
                    break;
                }
            }
            if(counter == 1) {
                JOptionPane.showMessageDialog(null, "Welcome !!");
                new ResultInsert();
            }
            else if(counter == 2){
                JOptionPane.showMessageDialog(null, "Sorry !!, The password that you've entered is incorrect.");
                new AdminLogin();
            }
            else{
                JOptionPane.showMessageDialog(null, "Sorry !!, This Login portion restricted for Admin.");
                new Login();
            }

        } catch (Exception e) {
            System.err.println("Login Error: "+e);
        }
    }

    public void resultInsert(String query) {
        try{
            st.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Result Insertion Complete !!");
        }catch (Exception e){
            System.err.println("Database Error: "+e);
        }
    }
}
