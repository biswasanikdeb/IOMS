package com.db;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

public class DML extends conn {

    // adds data
    public boolean addToCustomerTable(String name, String username, String gender, String phone, String dob,
            Component parentComponent) {
        String takeRowCountStatement = "SELECT COUNT(CUSTOMER_ID) FROM CUSTOMER";
        String dataInsertion = "INSERT INTO CUSTOMER(CUSTOMER_ID,USERNAME,NAME,GENDER,PHONE#,DOB) VALUES(?,?, ?,?,?,TO_DATE(?,'DD/MM/YY'))";
        String checkExisting = "SELECT a.username, c.phone# FROM auth a, customer c WHERE (a.username = c.username) and (a.username = ? and c.phone# = ?)";

        PreparedStatement pstmt1 = super.runStatement(checkExisting);

        try {
            pstmt1.setString(1, username);
            pstmt1.setString(2, phone);

            ResultSet rs1 = pstmt1.executeQuery();
            
            String result[] = new String[2];
            if (rs1.next()) {
                result[0] = rs1.getString(1);
                result[1] = rs1.getString(2);
                System.out.println(result[0] + result[1]);
            }
            if (result[0] == null && result[1] == null) {

                ResultSet rs = super.runQuery(takeRowCountStatement);
                int clinetid = 0;
                try {
                    if (rs.next()) {
                        clinetid = rs.getInt(1) + 1;
                    }
                    PreparedStatement pstmt = super.runStatement(dataInsertion);
                    pstmt.setInt(1, clinetid);
                    pstmt.setString(2, username);
                    pstmt.setString(3, name);
                    pstmt.setString(4, gender);
                    pstmt.setString(5, phone);
                    pstmt.setString(6, dob);
                    pstmt.executeUpdate();
                    pstmt1.close();
                    pstmt.close();
                    return true;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return false;
                }
            } else if (result[0] == null && result[1] != null) {
                JOptionPane.showMessageDialog(parentComponent, "Duplicate Phone Number");
                return false;
            } else if (result[0] != null && result[1] == null) {
                JOptionPane.showMessageDialog(parentComponent, "Duplicate Username");
                return false;
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Duplicate username and Phone Number");
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // adds data to auth table...only for client/customer only
    public void addToAuthTable(String username, String password, Component parentComponent) {
        
        try {
            String statement = "INSERT INTO AUTH(USERNAME, PASSWORD,USERTYPE) VALUES(?,?,'client')";
            
                PreparedStatement pstmt = super.runStatement(statement);
                
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                pstmt.close();
                
            } 
         catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(parentComponent, "A constraint violation occurred: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            
        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(parentComponent, "An SQL error occurred: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
            
        }
        
    }

    public String[] getProducts() {
        String statement = "SELECT PRD_NAME FROM PRODUCTS";
        String len = "SELECT COUNT(PRD_NAME) FROM PRODUCTS";
        ResultSet rs1 = super.runQuery(len);
        ResultSet rs = super.runQuery(statement);
        String[] products = null;
        int length = 0;
        try {
            if (rs1.next()) {
                length = rs1.getInt(1);
            }
            products = new String[length];
            while (rs.next()) {
                for (int i = 0; i < length; i++) {
                    products[i] = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}
