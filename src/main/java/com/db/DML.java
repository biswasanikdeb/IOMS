package com.db;

import java.awt.Component;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com._String.Sanitize;

public class DML extends conn {

    // adds data
    public boolean addToCustomerTable(String name, String username, String gender, String phone, String dob,
            Component parentComponent) {
        String takeRowCountStatement = "SELECT COUNT(CUSTOMER_ID) FROM CUSTOMER";
        String dataInsertion = "INSERT INTO CUSTOMER(CUSTOMER_ID,USERNAME,NAME,GENDER,PHONE#,DOB) VALUES(?,?, ?,?,?,TO_DATE(?,'DD/MM/YY'))";
        String checkExisting = "SELECT a.username, c.phone# FROM auth a, customer c WHERE (a.username = c.username) and (a.username = ? and c.phone# = ?)";

        PreparedStatement pstmt1 = super.runStatement(checkExisting);

        try {
            pstmt1.setString(1, Sanitize.san(username));
            pstmt1.setString(2, Sanitize.san(phone));

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
                    pstmt.setString(2, Sanitize.san(username));
                    pstmt.setString(3, Sanitize.san(name));
                    pstmt.setString(4, Sanitize.san(gender));
                    pstmt.setString(5, Sanitize.san(phone));
                    pstmt.setString(6, Sanitize.san(dob));
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

            pstmt.setString(1, Sanitize.san(username));
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(parentComponent, "A constraint violation occurred: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(parentComponent, "An SQL error occurred: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    public int getRowCount(String tableName) {
        String statement = "SELECT COUNT(*) FROM " + tableName;
        ResultSet rs = super.runQuery(statement);
        int rowCount = 0;
        try {
            if (rs.next()) {
                rowCount = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
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

    public void addProducts(String PRD_NAME, int PRD_BPRICE, int PRD_SPRICE, int PRD_QTY) {
        String rowLen = "SELECT COUNT(PRD_ID) FROM PRODUCTS";
        int length = 0;
        try {
            PreparedStatement rowLenCount = super.runStatement(rowLen);
            ResultSet rs = rowLenCount.executeQuery();
            if (rs.next()) {
                length = rs.getInt(1);
            }
            rowLenCount.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String insertionStatement = "INSERT INTO PRODUCTS(PRD_ID,PRD_NAME,AVL_QTY,B_PRICE,S_PRICE) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement pstmt = super.runStatement(insertionStatement);
            pstmt.setInt(1, length + 1);
            pstmt.setString(2, Sanitize.san(PRD_NAME));
            pstmt.setInt(3, PRD_QTY);
            pstmt.setInt(4, PRD_BPRICE);
            pstmt.setInt(5, PRD_SPRICE);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Object[][] getTableData(String tableName) {
        String statement = "SELECT * FROM " + tableName;
        ResultSet rs = super.runQuery(statement);
        int columnCount = 0;
        int rowCount = getRowCount(tableName);
        Object[][] data = null;
        try {
            columnCount = rs.getMetaData().getColumnCount();
            data = new Object[rowCount][columnCount];
            int rowIndex = 0;
            while (rs.next()) {
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    data[rowIndex][colIndex - 1] = rs.getObject(colIndex);
                }
                rowIndex++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Vector<String> getSuggestions(String text, String tableName, String columnName) {
        String statement = "SELECT " + columnName + " FROM " + tableName + " WHERE " + columnName + " LIKE '%" + text
                + "%'";
        System.out.println(statement);
        ResultSet rs = super.runQuery(statement);
        Vector<String> data = null;
        try {
            data = new Vector<>();
            while (rs.next()) {
                if (rs.getString(1) != null)
                    data.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getPrimaryKey(String tableName, String keyValue, String keyValueColumn, String primaryColumnName) {
        String statement = "SELECT " + primaryColumnName + " FROM " + tableName + " WHERE " + keyValueColumn + " = '"
                + keyValue + "'";
        ResultSet rs = super.runQuery(statement);
        int primaryKey = 0;
        try {
            if (rs.next()) {
                primaryKey = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return primaryKey;
    }

    public void updateTable(String tableName, String columnName, String value, String primaryKeyColumn,
            int primaryKeyValue) {
        String statement = "UPDATE " + tableName + " SET " + columnName + " = '" + value + "' WHERE " + primaryKeyColumn
                + " = '" + primaryKeyValue + "'";
        try {
            PreparedStatement pstmt = super.runStatement(statement);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateTable(String tableName, String columnName, int value, String primaryKeyColumn,
            int primaryKeyValue) {
        String statement = "UPDATE " + tableName + " SET " + columnName + " = '" + value + "' WHERE " + primaryKeyColumn
                + " = '" + primaryKeyValue + "'";
        try {
            PreparedStatement pstmt = super.runStatement(statement);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
