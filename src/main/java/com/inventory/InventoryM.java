package com.inventory;

import com.db.DML;

public class InventoryM extends DML {
    private final String TABLENAME = "PRODUCTS";
    // table related data
    private String headerColumn[] = new String[] { "ID", "Item Name ", "Available Quantity", "Buying Price",
            "Selling Price" };

    public Object[][] getData() { 

        return getTableData(TABLENAME);
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }

    public void addToInventoryData(String name, String b_price, String s_price, String qty) {

        addProducts(name, Integer.parseInt(b_price), Integer.parseInt(s_price), Integer.parseInt(qty));

    }

    public void modifyInventory(int id, String name, String b_price, String s_price, String qty) {
        if (!name.equals("")) {
            updateTable(TABLENAME, "PRD_NAME", name, "PRD_ID", id);
        }
        if (!b_price.equals("")) {
            updateTable(TABLENAME, "B_PRICE", Integer.parseInt(b_price), "PRD_ID", id);

        }
        if (!s_price.equals("")) {
            updateTable(TABLENAME, "S_PRICE", Integer.parseInt(s_price), "PRD_ID", id);

        }
        if (!qty.equals("")) {
            updateTable(TABLENAME, "AVL_QTY", Integer.parseInt(qty), "PRD_ID", id);

        }

    }

    public void deleteInventory(int id) {
        deleteRow(TABLENAME, "PRD_ID", id);
    }
}
