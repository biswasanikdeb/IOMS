package com.order;

import com.db.DML;

public class orderActive extends DML {
    private final String VIEWTABLE = "ORDER_ACTIVE";
    private String headerColumn[] = new String[] { "Order ID", "Products" ,"Qty", "Order Date","Status" };

    public Object[][] getData() {
        return getTableData(VIEWTABLE);
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }    
    
}
