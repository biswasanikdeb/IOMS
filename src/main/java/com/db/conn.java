package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
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
}
