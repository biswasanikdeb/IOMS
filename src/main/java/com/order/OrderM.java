package com.order;

import com.db.DML;

public class OrderM extends DML {
    private final String VIEWTABLE = "ORDERTABLE";
    private final String TABLENAME = "ORDERS";
    private String headerColumn[] = new String[] { "Order ID", "Customer Name " ,"Phone Number","Address", "Order Date","Status" };

    public Object[][] getData() {
        return getTableData(VIEWTABLE);
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }

    public boolean isNewUser(String phoneNumber) {
        return !phoneNumber.equals(getColumnS("CUSTOMER", phoneNumber, "PHONE", "PHONE"));
    }

    
    public int createOrder(int custoemrId){
        int orderId = generateId(TABLENAME, "ORD_ID");
        addToOrder(orderId, custoemrId);
        pushToRefTable(orderId);
        truncateTable("BASKET");
        return orderId;
    }
    public int getTotalOrder(int clientId){
        return getTotalOrderById(VIEWTABLE, clientId);
    }
}
