package com.GUI;
 
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.delivery.DeliveryM;

public class Deliveryman extends JFrame implements ActionListener{
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton exitButton;
    DeliveryM dlv ;
    public Deliveryman(String username) {
        super("Deliveryman Panel");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
 
        panel = new JPanel(new BorderLayout());
        dlv = new DeliveryM(username);
        tableModel = new DefaultTableModel(dlv.getDeliveryData(), dlv.getDeliveryHeaders());
        table = new JTable(tableModel){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Check for double-click
                    int selectedRow = table.getSelectedRow(); // Get the selected row index
                    if (selectedRow != -1) {
                        // Fetch data from the selected row
                        int id =  Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                        int otp = dlv.generateOTP();
                        System.out.println(otp);
                        String input = JOptionPane.showInputDialog(null, "Enter the OTP:", "OTP Verification", JOptionPane.PLAIN_MESSAGE);
                        if (input != null && !input.isEmpty()) {
                            try {
                                int enteredOtp = Integer.parseInt(input);
                                if (enteredOtp == otp) {
                                    JOptionPane.showMessageDialog(null, "OTP Verified Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    dlv.updateDeliveryStatus(id);
                                    tableModel.setDataVector(dlv.getDeliveryData(), dlv.getDeliveryHeaders());
                                    tableModel.fireTableDataChanged();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid OTP. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        

                    }
                }
            }
        });
        
        scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        panel.add(exitButton, BorderLayout.SOUTH);
 
        add(panel);
    }
    public Deliveryman(int id) {
        super("Deliveryman Panel");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
 
        panel = new JPanel(new BorderLayout());
        dlv = new DeliveryM(id);
        tableModel = new DefaultTableModel(dlv.getDeliveryData(), dlv.getDeliveryHeaders());
        table = new JTable(tableModel){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Check for double-click
                    int selectedRow = table.getSelectedRow(); // Get the selected row index
                    if (selectedRow != -1) {
                        // Fetch data from the selected row
                        int id =  Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                        int otp = dlv.generateOTP();
                        System.out.println(otp);
                        String input = JOptionPane.showInputDialog(null, "Enter the OTP:", "OTP Verification", JOptionPane.PLAIN_MESSAGE);
                        if (input != null && !input.isEmpty()) {
                            try {
                                int enteredOtp = Integer.parseInt(input);
                                if (enteredOtp == otp) {
                                    JOptionPane.showMessageDialog(null, "OTP Verified Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    dlv.updateDeliveryStatus(id);
                                    tableModel.setDataVector(dlv.getDeliveryData(), dlv.getDeliveryHeaders());
                                    tableModel.fireTableDataChanged();
                                } else {
                                    JOptionPane.showMessageDialog(null, "Invalid OTP. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        

                    }
                }
            }
        });
        
        scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            dispose();
        });
        panel.add(exitButton, BorderLayout.SOUTH);
 
        add(panel);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitButton) {
            System.exit(0);
        }
    }
}