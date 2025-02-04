package com.GUI;

import javax.swing.JFrame;

public class OrderDetails extends JFrame {
    
    public OrderDetails(int orderId) {
        setTitle("Order Details");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
