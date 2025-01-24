package com.GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


import com.order.orderActive;
import com.order.orderHistory;
import com.customer.CustomerM;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class CustomerInfo extends JFrame {
    private JLabel nameLabel, phoneLabel, addressLabel,orderTotalLabel,name, phone, address, orderTotal;
    private JTable orderHistoryTable, activeOrderTable;
    private JScrollPane orderHistoryScrollPane, activeOrderScrollPane;
    private DefaultTableModel defTM, defTM2;
    private TableColumnModel clmModel;
    private CustomerM cm = new CustomerM();
    private orderHistory oh = new orderHistory();
    private orderActive oa = new orderActive();
    public CustomerInfo(int clientId) {
        super("Customer Info");
        super.setSize(900, 600);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
        super.setResizable(false);

        // Upper panel for customer info
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(null);
        upperPanel.setBounds(0, 0, 900, 300);

        nameLabel = new JLabel("Name: ");
        name = new JLabel(cm.getName(clientId));
        phoneLabel = new JLabel("Phone: ");
        phone = new JLabel(cm.getPhone(clientId));
        addressLabel = new JLabel("Address: ");
        address = new JLabel(cm.getAddr(clientId));
        orderTotalLabel = new JLabel("Total Order: ");
        orderTotal = new JLabel(String.valueOf(new com.order.OrderM().getTotalOrder(clientId)));

        nameLabel.setBounds(50, 50, 200, 30);
        name.setBounds(250, 50, 200, 30);
        phoneLabel.setBounds(50, 100, 200, 30);
        phone.setBounds(250, 100, 200, 30);
        addressLabel.setBounds(50, 150, 200, 30);
        address.setBounds(250, 150, 200, 30);
        orderTotalLabel.setBounds(50, 200, 200, 30);
        orderTotal.setBounds(250, 200, 200, 30);

        upperPanel.add(nameLabel);
        upperPanel.add(name);
        upperPanel.add(phoneLabel);
        upperPanel.add(phone);
        upperPanel.add(addressLabel);
        upperPanel.add(address);
        upperPanel.add(orderTotalLabel);
        upperPanel.add(orderTotal);

        // Lower panel for order history and active orders
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(1, 2));
        lowerPanel.setBounds(0, 300, 900, 300);

        // Left panel for order history table
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        defTM = new DefaultTableModel(oh.getData(clientId),oh.getHeaderColumn());
        orderHistoryTable = new JTable(defTM){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        orderHistoryTable.setRowSelectionAllowed(true);
        clmModel = orderHistoryTable.getColumnModel();
        clmModel.getColumn(0).setPreferredWidth(30);
        clmModel.getColumn(1).setPreferredWidth(40);
        clmModel.getColumn(2).setPreferredWidth(50);
        clmModel.getColumn(3).setPreferredWidth(20);
        orderHistoryTable.getTableHeader().setResizingAllowed(false);
        orderHistoryTable.getTableHeader().setReorderingAllowed(false);

        orderHistoryScrollPane = new JScrollPane(orderHistoryTable);
        leftPanel.add(orderHistoryScrollPane, BorderLayout.CENTER);

        // Right panel for active order table
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BorderLayout());
        defTM2 = new DefaultTableModel(oa.getData(clientId),oa.getHeaderColumn());
        activeOrderTable = new JTable(defTM2){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        activeOrderScrollPane = new JScrollPane(activeOrderTable);
        rightPanel.add(activeOrderScrollPane, BorderLayout.CENTER);

        lowerPanel.add(leftPanel);
        lowerPanel.add(rightPanel);

        this.setLayout(null);
        this.add(upperPanel);
        this.add(lowerPanel);
    }
}
