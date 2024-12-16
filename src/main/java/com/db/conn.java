package com.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import io.github.cdimascio.dotenv.Dotenv;

public class conn {
    public static Connection DBcon(){
        Dotenv dotenv = Dotenv.configure().load();
        Connection con = null;
        try {
            con = DriverManager.getConnection(dotenv.get("DB_URL"), dotenv.get("DB_USERNAME"), dotenv.get("DB_PASSWD"));
            System.out.println("succuss connection LOG: "+con);
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return con;
    }
    public static PreparedStatement runStatement(String statement){ //must use execute func when used
        PreparedStatement pstmt = null;
        try {
            pstmt = DBcon().prepareStatement(statement);

        } catch (SQLException e) {
            
            e.printStackTrace();
        }
                return pstmt;
    }
    public static ResultSet runQuery(String Query){
        ResultSet rs = null;
        Statement stmt;
        try {
            stmt = DBcon().createStatement();
            rs = stmt.executeQuery(Query);
            DBcon().close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
        
        return rs;
    }
}
