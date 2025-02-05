package com.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import com.order.orderInfo;

public class OrderDetails extends JFrame {
    public OrderDetails(int orderId) {
        setTitle("Order Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        orderInfo oi = new orderInfo(orderId);
        // Customer details panel
        JPanel customerPanel = new JPanel(new GridLayout(3, 2));
        customerPanel.add(new JLabel("Customer Name:"));
        customerPanel.add(new JLabel(oi.getName())); // Replace with actual data
        customerPanel.add(new JLabel("Customer Phone:"));
        customerPanel.add(new JLabel(oi.getPhone())); // Replace with actual data
        customerPanel.add(new JLabel("Customer Address:"));
        customerPanel.add(new JLabel(oi.getAddress())); // Replace with actual data

        // Order details table
        String[] columnNames = {"Product Name", "Quantity", "Price"};
       
        JTable orderTable = new JTable(new DefaultTableModel(oi.getData(), columnNames)){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        
        JScrollPane tableScrollPane = new JScrollPane(orderTable);

        // Add components to frame
        add(customerPanel, BorderLayout.NORTH);
        add(tableScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}