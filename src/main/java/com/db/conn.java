package com.db;

import java.sql.Statement;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import io.github.cdimascio.dotenv.Dotenv;

public class conn {
    private static Connection con = null;
    private static final Logger LOGGER = Logger.getLogger(conn.class.getName());
    
    public static Connection DBcon() {
        Dotenv dotenv = Dotenv.configure().load();
        while (con == null) {
            try {
                con = DriverManager.getConnection(dotenv.get("DB_URL"),
                        dotenv.get("DB_USERNAME"), dotenv.get("DB_PASSWD"));
                System.out.println("succuss connection LOG: " + con);
            } catch (SQLException e) {
    
                LOGGER.log(Level.SEVERE, "SQL Exception", e);
            }
            
        }
        return con;
    }

    public PreparedStatement runStatement(String statement) { 
        PreparedStatement pstmt = null;
        try {
            return DBcon().prepareStatement(statement);
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        

    }

    public ResultSet runQuery(String Query) {
        Statement stmt;
        try {
            stmt = DBcon().createStatement();
            return stmt.executeQuery(Query);

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
