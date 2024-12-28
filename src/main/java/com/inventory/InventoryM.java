package com.inventory;


import com.db.DML;
import com.newCommon.DataManagement;


public class InventoryM extends DataManagement {
    private final String TABLENAME = "PRODUCTS";
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
    
    public void modifyInventory(int id, String name, String b_price, String s_price, String qty) {
        if(!name.equals("")){
            dml.updateTable(TABLENAME, "PRD_NAME",name,"PRD_ID",id);
        }
        if (!b_price.equals("")){
            dml.updateTable(TABLENAME, "B_PRICE",Integer.parseInt(b_price),"PRD_ID",id);
            
        }
        if (!s_price.equals("")){
            dml.updateTable(TABLENAME, "S_PRICE",Integer.parseInt(s_price),"PRD_ID",id);
            
        }
        if (!qty.equals("")){
            dml.updateTable(TABLENAME, "AVL_QTY",Integer.parseInt(qty),"PRD_ID",id);
            
        }

    }
    public void deleteInventory(int id) {
        dml.deleteRow(TABLENAME, "PRD_ID", id);
    }
}
