package com.auth;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.db.DML;

public class Authentication {
    DML dml = new DML();
    private String Username, password;

    public Authentication(String Username, String Password) {
        this.Username = Username;
        this.password = Password;
    }

    // this verifies from the admin data set
    // public boolean verify() {
    //     boolean flag = false;
    //     try {
    //         File datafile = new File("./admin.txt");
    //         datafile.createNewFile();

    //         Scanner sc = new Scanner(datafile);
    //         DataManagement dtm = new DataManagement();
    //         while (sc.hasNextLine()) {
    //             String data[] = dtm.readData(datafile, sc);
    //             if (data[0].equals(Username) && data[1].equals(password)) {
    //                 flag = true;
    //             }
    //         }
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     }

    //     return flag;
    // }
    public boolean verify(){

        ResultSet rs = dml.runQuery("Select * from auth");
        boolean flag = false;
        try {
            while (rs.next()) {
                String usernm = rs.getString("username");
                String pass = rs.getString("PASSWORD");
                String  type = rs.getString("usertype");
                if (usernm.equals(Username) && pass.equals(password) && type.equals("admin") ) {
                    flag = true; 
                    break;   
                }
                
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return flag;
    }

    // this verifies from the customer data set
    // public boolean customerVerify() {
    //     boolean flag = false;
    //     File datafile = new File("./user.txt");

    //     try {
    //         datafile.createNewFile();
    //         Scanner sc = new Scanner(datafile);
    //         DataManagement dtm = new DataManagement();
    //         while (sc.hasNextLine()) {
    //             String data[] = dtm.readData(datafile, sc);
    //             if (data[0].equals(Username) && data[1].equals(password)) {
    //                 flag = true;
    //             }
    //         }
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //     }

    //     return flag;
    // }
    public boolean customerVerify(){

        ResultSet rs = dml.runQuery("Select * from auth");
        boolean flag = false;
        try {
            while (rs.next()) {
                String usernm = rs.getString("username");
                String pass = rs.getString("password");
                String  type = rs.getString("usertype");
                if (usernm.equals(Username) && pass.equals(password) && type.equals("client")) {
                    flag = true;
                    break;   
                }
                
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return flag;
    }


    //adds customer account
    public String addAccount(){
        try {
            String statement = "INSERT INTO AUTH(USERNAME, PASSWORD,USERTYPE) VALUES(?,?,'client')";
            PreparedStatement pstmt = dml.runStatement(statement);
            pstmt.setString(1, Username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e);
            return "0";
        }
        catch(SQLException e){
            System.out.println(e);
            return "1";
        }
        return null;
    }
    
}
