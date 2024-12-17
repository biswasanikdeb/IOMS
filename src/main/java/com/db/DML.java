package com.db;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.swing.JOptionPane;

public class DML extends conn {
    //adds data to auth table...only for client/customer only
    public boolean addToAuthTable(String username,String password, Component parentComponent){
        try {
            String statement = "INSERT INTO AUTH(USERNAME, PASSWORD,USERTYPE) VALUES(?,?,'client')";
            PreparedStatement pstmt = super.runStatement(statement);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(parentComponent, "A constraint violation occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(parentComponent, "An SQL error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    //adds data 
    public boolean addToCustomerTable(String name, String username,String gender,String phone,String dob,Component parentComponent){
        String takeRowCountStatement = "SELECT COUNT(CUSTOMER_ID) FROM CUSTOMER";
        String dataInsertion = "INSERT INTO CUSTOMER(CUSTOMER_ID,USERNAME,NAME,GENDER,PHONE#,DOB) VALUES(?,?, ?,?,?,TO_DATE(?,'DD/MM/YY'))";
        ResultSet rs = super.runQuery(takeRowCountStatement);
        int clinetid=0;
        try {
            while (rs.next()) {
                clinetid = rs.getInt(1)+1;
            }
            PreparedStatement pstmt = super.runStatement(dataInsertion);
            pstmt.setInt(1, clinetid);
            pstmt.setString(2, username);
            pstmt.setString(3, name);
            pstmt.setString(4, gender);
            pstmt.setString(5, phone);
            pstmt.setString(6, dob);
            pstmt.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "A constraint violation occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(parentComponent, "An SQL error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }
}

