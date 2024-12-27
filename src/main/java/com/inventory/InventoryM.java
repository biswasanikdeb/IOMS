package com.inventory;


import com.db.DML;
import com.newCommon.DataManagement;


public class InventoryM extends DataManagement {
    // table related data
    private String headerColumn[] = new String[] { "ID", "Item Name ", "Available Quantity", "Buying Price",
            "Selling Price" };
    DML dml = new DML();
    

    public Object[][] getData() { // reads the line number first then get the data by the line
       
        return dml.getTableData("PRODUCTS");
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }

    public void addToInventoryData(String name, String b_price, String s_price, String qty ) {

        dml.addProducts(name,Integer.parseInt(b_price), Integer.parseInt(s_price), Integer.parseInt(qty));

    }
    
    public void modifyInventory(){

    }

}
