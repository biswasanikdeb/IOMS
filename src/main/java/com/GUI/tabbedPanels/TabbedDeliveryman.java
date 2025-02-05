package com.GUI.tabbedPanels;
 
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.GUI.Deliveryman;
import com.GUI.Welcome;
import com.delivery.DeliveryM;
 
public class TabbedDeliveryman extends JFrame  implements ActionListener{
    private JPanel panel;
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JButton exitButton;
    DeliveryM dlv = new DeliveryM();
    public TabbedDeliveryman() {
        super("Admin Panel");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
 
        panel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(dlv.getAdminData(), dlv.getAdminHeaders());
        table = new JTable(tableModel){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Check for double-click
                    int selectedRow = table.getSelectedRow(); // Get the selected row index
                    if (selectedRow != -1) {
                        // Fetch data from the selected row
                        int id =  Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
                        // Open a JDialog with the row's data
                        Deliveryman dm = new Deliveryman(id);
                        dm.setVisible(true);
                    }
                }
            }
        });
        table.setRowSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        
        scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        panel.add(exitButton, BorderLayout.SOUTH);
 
        add(panel);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitButton) {
            dispose();
            Welcome wlc = new Welcome();
            wlc.setVisible(true);

        }
    }
    
}