package com.ioms;

import com.db.conn;
import com.gui.*;


public class Main  {
    
  
    public static void main(String[] args) {
       
        
        conn.DBcon();
        //LoginPage obj1 = new LoginPage();
        Welcome obj1 = new Welcome();
        obj1.setVisible(true);
    }
}