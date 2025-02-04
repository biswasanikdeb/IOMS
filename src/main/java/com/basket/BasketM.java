package com.basket;

import java.awt.Component;
import java.sql.SQLSyntaxErrorException;

import javax.swing.JOptionPane;

import com.db.DML;

public class BasketM extends DML {
    private final String VIEWNAME = "BASKETVIEW";

    private String headerColumn[] = new String[] { "Item Name ", "Unit Price", "Qty", "Price" };

    public Object[][] getData() {
        return getTableData(VIEWNAME);
    }

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }

    public void addToBasketData(String name, String qty, Component parent) {
        int quantity = Integer.parseInt(qty);
        if (!name.equals(getColumnS("BASKETVIEW", name, "\"Item_name\"", "\"Item_name\""))) {
            if (quantity > getColumn("PRODUCTS", name, "PRD_NAME", "AVL_QTY")) {
                JOptionPane.showMessageDialog(parent, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                addToBasket(name, quantity);
            }
        } else {
            int newQty = getColumn("BASKETVIEW", name, "\"Item_name\"", "\"qty\"") + quantity;
            if (newQty > getColumn("PRODUCTS", name, "PRD_NAME", "AVL_QTY")) {
                JOptionPane.showMessageDialog(parent, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                updateTable("BASKET", "Qty", newQty, "PRD_ID", getPrimaryKey("PRODUCTS", name, "PRD_NAME", "PRD_ID"));
            }
        }
    }

    public int total() {
        String db;
        try {
            db = DBcon().getMetaData().getDatabaseProductName();
        } catch (Exception e) {
            db = "MySQL";
        }
        if (db.equals("MySQL")) {
            return getColumnTotal(VIEWNAME, "total_price");
        }
        else{
            return getColumnTotal(VIEWNAME, "\"total_price\"");
        }
    }

    public int totalItem() {
        return getRowCount(VIEWNAME);
    }

    public void deleteBasket(String name) {
        deleteRow("BASKET", "PRD_ID", getPrimaryKey("PRODUCTS", name, "PRD_NAME", "PRD_ID"));
    }
}
