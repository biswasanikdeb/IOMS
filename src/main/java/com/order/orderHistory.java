package com.order;

import com.db.DML;

public class orderHistory extends DML {
    private final String VIEWTABLE = "ORDER_HISTORY";
    private String headerColumn[] = new String[] { "Order ID", "Products" ,"Qty", "Order Date","Status" };

    // public Object[][] getData(int clientId) {
    //     return getOrderHistory(VIEWTABLE,clientId);
    // }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }    
    
}
