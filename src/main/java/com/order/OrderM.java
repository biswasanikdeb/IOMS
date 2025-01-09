package com.order;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.db.DML;

public class OrderM extends DML {
    private final String VIEWTABLE = "ORDERS";
    private final String TABLENAME = "ORDERS";
    private String headerColumn[] = new String[] { "Order ID", "Customer Name ", "Total QTY", "Total price", "Date",
            "Phone Number" };

    public Object[][] getData() {
        return getTableData(VIEWTABLE);
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }

    public boolean isNewUser(String phoneNumber) {
        return !phoneNumber.equals(getColumnS("CUSTOMER", phoneNumber, "PHONE#", "PHONE#"));
    }

    public void addToOrderData(String customerName, int totalP, int totalQ, String phoneNumber) {

    }
    public int createOrder(int custoemrId){
        int orderId = generateId(TABLENAME, "ORD_ID");
        addToOrder(orderId, custoemrId);
        pushToRefTable(orderId);
        truncateTable("BASKET");
        return orderId;
    }
    public String getStatus(int order_id){
        boolean status = checkStatus("tablename", order_id,"statusColumn");
        if (!status) {
            return "Delivered";
        }
        else{
            return "Pending";
        }
    }
}
