package com.basket;

import java.awt.Component;
import java.io.File;

import javax.swing.JOptionPane;

import com.newCommon.*;
import com.db.DML;
public class BasketM extends DataManagement {
    DML dml = new DML();
    private final String VIEWNAME = "BASKETVIEW";
    // table related data

    private String headerColumn[] = new String[] { "Item Name ", "Unit Price", "Qty",
            "Price" };
    File basketFile = new File("./basket.txt");

    

    public Object[][] getData() { return dml.getTableData(VIEWNAME);}

    public String[] getHeaderColumn() {
        return this.headerColumn;
    }

    public void addToBasketData(String name, String qty, Component parent) {
        int quantity = Integer.parseInt(qty);
        if (!name.equals(dml.getColumnS("BASKETVIEW", name, "\"Item_name\"", "\"Item_name\""))) {
            if (quantity> dml.getColumn("PRODUCTS", name, "PRD_NAME", "AVL_QTY")) {
                JOptionPane.showMessageDialog(parent, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
                return;  
            }
            else{
                dml.addToBasket(name, quantity);       
            }
        }else{
            int newQty = dml.getColumn("BASKETVIEW", name, "\"Item_name\"", "\"qty\"")+quantity;
            if (newQty > dml.getColumn("PRODUCTS", name, "PRD_NAME", "AVL_QTY")) {
                JOptionPane.showMessageDialog(parent, "Not enough stock available", "Error", JOptionPane.ERROR_MESSAGE);
                return;  
            }
            else{
                dml.updateTable("BASKET", "Qty", newQty, "PRD_ID", dml.getPrimaryKey("PRODUCTS",name, "PRD_NAME", "PRD_ID"));
            }
        }
    }
    public int total(){ return dml.getColumnTotal(VIEWNAME, "\"total_price\"");}
    public int totalItem(){ return dml.getRowCount(VIEWNAME);}
    public void deleteBasket(String name) {
        dml.deleteRow("BASKET", "PRD_ID", dml.getPrimaryKey("PRODUCTS",name, "PRD_NAME", "PRD_ID"));
    }
}
