package com.order;

import com.db.DML;

public class orderActive extends DML {
    private final String VIEWTABLE = "ORDER_ACTIVE";
    private String headerColumn[] = new String[] { "Order ID", "product id","Products" ,"Qty", "Order Date","Status" };

    public Object[][] getData(int clientId) {
        return getActiveOrderData(VIEWTABLE,clientId);
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }    
    
}
