package com.db;

import java.awt.Component;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com._string.Sanitize;

public class DML extends conn {
    private static final Logger LOGGER = Logger.getLogger(conn.class.getName());

    // adds data
    public int addToCustomerTable(String name, String username, String gender, String phone, String dob, String addr,
            Component parentComponent) {
        String dataInsertion = "INSERT INTO CUSTOMER(CUSTOMER_ID,NAME,GENDER,PHONE#,DOB,ADDRESS) VALUES(?, ?,?,?,TO_DATE(?,'DD/MM/YY'),?)";
        String checkExisting = "SELECT a.username, c.phone# FROM auth a, customer c WHERE (a.CUSTOMER_ID = c.CUSTOMER_ID) and (a.username = ? or c.phone# = ?)";

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

                int clinetid = generateId("CUSTOMER", "CUSTOMER_ID");
                try {

                    PreparedStatement pstmt = super.runStatement(dataInsertion);
                    pstmt.setInt(1, clinetid);
                    pstmt.setString(2, Sanitize.san(name));
                    pstmt.setString(3, Sanitize.san(gender));
                    pstmt.setString(4, Sanitize.san(phone));
                    pstmt.setString(5, Sanitize.san(dob));
                    pstmt.setString(6, Sanitize.san(addr));
                    pstmt.executeUpdate();
                    pstmt1.close();
                    pstmt.close();
                    return clinetid;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return 0;
                }
            } else if (result[0] == null && result[1] != null) {
                JOptionPane.showMessageDialog(parentComponent, "Duplicate Phone Number");
                return 0;
            } else if (result[0] != null && result[1] == null) {
                JOptionPane.showMessageDialog(parentComponent, "Duplicate Username");
                return 0;
            } else {
                JOptionPane.showMessageDialog(parentComponent, "Duplicate username and Phone Number");
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int forceAddToCustomerTable(String name, String phone, String addr) {
        String dataInsertion = "INSERT INTO CUSTOMER(CUSTOMER_ID,NAME, PHONE#,ADDRESS) VALUES(?, ?,?,?)";
        int clinetid = generateId("CUSTOMER", "CUSTOMER_ID");
        try {
            PreparedStatement pstmt = super.runStatement(dataInsertion);
            pstmt.setInt(1, clinetid);
            pstmt.setString(2, Sanitize.san(name));
            pstmt.setString(3, Sanitize.san(phone));
            pstmt.setString(4, Sanitize.san(addr));
            pstmt.executeUpdate();
            pstmt.close();
            return clinetid;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // adds data to auth table...only for client/customer only
    public void addToAuthTable(String username, String password, int id, Component parentComponent) {

        try {
            String statement = "INSERT INTO AUTH(USERNAME, PASSWORD,USERTYPE,CUSTOMER_ID) VALUES(?,?,'client',?)";

            PreparedStatement pstmt = super.runStatement(statement);

            pstmt.setString(1, Sanitize.san(username));
            pstmt.setString(2, password);
            pstmt.setInt(3, id);
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

    public int generateId(String tablename, String primarykeyCol) {
        String statement = "SELECT MAX(NVL(" + primarykeyCol + ",0)) FROM " + tablename;
        ResultSet rs = super.runQuery(statement);
        int id = 0;
        try {
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
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
            int i = 0;
            while (rs.next()) {

                products[i] = rs.getString(1);
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProducts(String PRD_NAME, int PRD_BPRICE, int PRD_SPRICE, int PRD_QTY) {
        String rowLen = "SELECT MAX(NVL(\"PRD_ID\",0)) FROM PRODUCTS";
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
    public Object[][] getOrderHistory(String tableName, int clientId) {
        String statement = "SELECT * FROM " + tableName ;
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

    public int getColumn(String tableName, String keyValue, String keyValueColumn, String primaryColumnName) {
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
    public int getColumn(String tableName, int keyValue, String keyValueColumn, String primaryColumnName) {
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

    public String getColumnS(String tableName, String keyValue, String keyValueColumn, String primaryColumnName) {
        String statement = "SELECT " + primaryColumnName + " FROM " + tableName + " WHERE " + keyValueColumn + " = '"
                + keyValue + "'";
        ResultSet rs = super.runQuery(statement);
        String primaryKey = null;
        try {
            if (rs.next()) {
                primaryKey = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return primaryKey;
    }
    public String getColumnS(String tableName, int keyValue, String keyValueColumn, String primaryColumnName) {
        String statement = "SELECT " + primaryColumnName + " FROM " + tableName + " WHERE " + keyValueColumn + " = '"
                + keyValue + "'";
        ResultSet rs = super.runQuery(statement);
        String primaryKey = null;
        try {
            if (rs.next()) {
                primaryKey = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return primaryKey;
    }

    public int getColumnTotal(String tablename, String columnname) {
        String statement = "SELECT SUM(" + columnname + ") FROM " + tablename;
        ResultSet rs = super.runQuery(statement);
        int total = 0;
        try {
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return total;
    }

    public void addToBasket(String name, int qty) {

        String statement = "INSERT INTO BASKET(PRD_ID,QTY) VALUES(?,?)";
        try {
            PreparedStatement pstmt = super.runStatement(statement);
            pstmt.setInt(1, getPrimaryKey("PRODUCTS", name, "PRD_NAME", "PRD_ID"));
            pstmt.setInt(2, qty);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addToOrder(int orderId, int customerId) {
        String statement = "INSERT INTO ORDERS(ORD_ID,CUSTOMER_ID,ORD_DATE,STATUS) VALUES(?,?,?,'PENDING')";
        try {
            PreparedStatement pstmt = super.runStatement(statement);
            pstmt.setInt(1, orderId);
            pstmt.setInt(2, customerId);
            pstmt.setDate(3, Date.valueOf(LocalDate.now()));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pushToRefTable(int orderId) {
        String stmt = "SELECT B.QTY, B.PRD_ID FROM BASKET B";
        ResultSet rs = super.runQuery(stmt);
        try {
            while (rs.next()) {
                String statement = "UPDATE PRODUCTS SET AVL_QTY = AVL_QTY - ? WHERE PRD_ID = ?";
                PreparedStatement pstmt = super.runStatement(statement);
                pstmt.setInt(1, rs.getInt(1));
                pstmt.setInt(2, rs.getInt(2));
                pstmt.executeUpdate();
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String statement = "INSERT INTO PRD_REF(ORD_ID, PRD_ID, QTY) SELECT O.ORD_ID, B.PRD_ID, B.QTY FROM ORDERS O, BASKET B WHERE O.ORD_ID = ?";
        try {
            PreparedStatement preparedStatement = super.runStatement(statement);
            preparedStatement.setInt(1, orderId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    public void deleteRow(String tableName, String primaryKeyColumn, int primaryKeyValue) {
        String statement = "DELETE FROM " + tableName + " WHERE " + primaryKeyColumn + " = '" + primaryKeyValue + "'";
        try {
            PreparedStatement pstmt = super.runStatement(statement);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "SQL Exception", e);

        }
    }

    public void truncateTable(String tableName) {
        String statement = "TRUNCATE TABLE " + tableName;
        try {
            PreparedStatement pstmt = super.runStatement(statement);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}