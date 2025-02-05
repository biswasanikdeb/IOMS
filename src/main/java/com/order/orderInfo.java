package com.order;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DML;

public class orderInfo extends DML {
    private int orderId;

    public orderInfo(int orderId) {
        this.orderId = orderId;
    }

    public int getClinentId() {
        return getColumn("ORDERS", orderId, "ORD_ID", "CUSTOMER_ID");
    }

    public String getName() {
        return getColumnS("CUSTOMER", getClinentId(), "CUSTOMER_ID", "NAME");
    }

    public String getPhone() {
        return getColumnS("CUSTOMER", getClinentId(), "CUSTOMER_ID", "PHONE");
    }

    public String getAddress() {
        return getColumnS("CUSTOMER", getClinentId(), "CUSTOMER_ID", "ADDRESS");
    }

    public Object[][] getData() {
        String statement = "SELECT P.PRD_NAME, O.QTY, P.S_PRICE*O.QTY FROM PRODUCTS P, PRD_REF O WHERE P.PRD_ID=O.PRD_ID AND O.ORD_ID=?";
        PreparedStatement ps = runStatement(statement);
        int columnCount = 0;
        int rowCount = getRowCount("PRD_REF");
        Object[][] data = null;
        try {
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            columnCount = rs.getMetaData().getColumnCount();
            data = new Object[rowCount][columnCount];
            int rowIndex = 0;
            while (rs.next()) {
                for (int colIndex = 1; colIndex <= columnCount; colIndex++) {
                    data[rowIndex][colIndex - 1] = rs.getObject(colIndex);
                }
                rowIndex++;
            }
            ps.close();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return data;
    }

}
