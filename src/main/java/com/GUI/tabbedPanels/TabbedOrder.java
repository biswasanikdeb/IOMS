package com.GUI.tabbedPanels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.GUI.Welcome;
import com.basket.BasketM;
import com.inventory.InventoryM;
import com.order.OrderM;
import com.db.DML;

public class TabbedOrder extends JFrame implements ActionListener{
    private DML dml = new DML();
    BasketM bm = new BasketM();
    InventoryM im = new InventoryM();
    OrderM om = new OrderM();
    private JPanel panel1,panel2;
    private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11;
    private JTabbedPane tp;
    private JButton exitButton,remfrmBsktBtn;
    private Font f1;
    private JTextField tf1,tf2,tf3,tf4;
    private JButton addPrdBtn,confirmBtn;
    @SuppressWarnings("rawtypes")
    private JComboBox cb;
    private boolean flag;
    private ImageIcon logo = new ImageIcon("./images/logo.png");
    private DefaultTableModel defTM,DefTM1;
    private JTable jt,jt1;
    private JScrollPane js,js1;
    private TableColumnModel clmModel,clmModel1;
    private JFrame basket;
    

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public TabbedOrder(){
        super("Order");
        super.setSize(900,600);
        super.setLocationRelativeTo(null);//appear the Jframe in center of the frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setIconImage(logo.getImage());





        //<<<----------------Basket-------------->>>>>
        basket = new JFrame("Basket");
        basket.setSize(400, 600);
        
        basket.setLocation(super.getX()+super.getWidth()+10, super.getY());
        basket.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        basket.setLayout(new BorderLayout());
        basket.setResizable(false);
        basket.setIconImage(logo.getImage());

        defTM = new DefaultTableModel(bm.getData(),bm.getHeaderColumn());
        jt = new JTable(defTM){
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jt.setRowSelectionAllowed(true);
        clmModel = jt.getColumnModel();
        clmModel.getColumn(0).setPreferredWidth(20);
        clmModel.getColumn(1).setPreferredWidth(180);
        clmModel.getColumn(2).setPreferredWidth(70);
        clmModel.getColumn(3).setPreferredWidth(70);
        jt.getTableHeader().setResizingAllowed(false);
        jt.getTableHeader().setReorderingAllowed(false);

        js = new JScrollPane(jt);
        
        remfrmBsktBtn = new JButton("remove");
        remfrmBsktBtn.setBounds(250, 500, 100, 30);
        remfrmBsktBtn.addActionListener(this);   
     
        
        basket.add(js);
        basket.add(remfrmBsktBtn,BorderLayout.SOUTH);

        //<<------- Order List -------->>>>
        tp = new JTabbedPane();
        panel1 = new JPanel( new BorderLayout());
        panel1.setSize(900,600);

        DefTM1 = new DefaultTableModel(om.getData(), om.getHeaderColumn());
        jt1 = new JTable(DefTM1) {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jt1.setRowSelectionAllowed(true);
        clmModel1 = jt1.getColumnModel();
        clmModel1.getColumn(0).setPreferredWidth(20);
        clmModel1.getColumn(1).setPreferredWidth(180);
        clmModel1.getColumn(2).setPreferredWidth(70);
        clmModel1.getColumn(3).setPreferredWidth(70);
        clmModel1.getColumn(4).setPreferredWidth(90);
        jt1.getTableHeader().setResizingAllowed(false);
        jt1.getTableHeader().setReorderingAllowed(false);

        js1 = new JScrollPane(jt1);

        

        panel1.add(js1);

        //<<<-------------Add Order------------->>>>>
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBackground(Color.LIGHT_GRAY);

        f1 = new Font("Arial", Font.PLAIN, 20);
        label1 = new JLabel("Phone Number : ");
        label1.setBounds(50,40,200,30);
        label1.setFont(f1);
        panel2.add(label1);
        
        tf1 = new JTextField();
        tf1.setBounds(260, 40, 350, 30);
        panel2.add(tf1);
        
        label2 = new JLabel("Customer Name :");
        label2.setBounds(50,100,200,30);
        label2.setFont(f1);
        panel2.add(label2);
        
        tf2 = new JTextField();
        tf2.setBounds(260, 100, 350, 30);
        panel2.add(tf2);


        label11 = new JLabel("Address :");
        label11.setBounds(50,160,200,30);
        label11.setFont(f1);
        panel2.add(label11);

        tf4 = new JTextField();
        tf4.setBounds(260, 160, 350, 30);
        panel2.add(tf4);

        label4 = new JLabel("Items :");
        label4.setBounds(50,220,200,30);
        label4.setFont(f1); 
        panel2.add(label4);

        cb = new JComboBox(dml.getProducts());
        cb.setBounds(130,220,150,30);
        cb.addActionListener(this);
        panel2.add(cb);
        cb.setForeground(Color.BLUE);
        cb.setBackground(Color.WHITE);

        label3 = new JLabel("Quantity:");
        label3.setBounds(320,220,170,30);
        label3.setFont(f1);
        panel2.add(label3);

        tf3 = new JTextField();
        tf3.setBounds(470, 220, 50, 30);
        panel2.add(tf3);

        addPrdBtn = new JButton("Add");
        addPrdBtn.setBounds(600,220,100,30);
        addPrdBtn.setFocusable(false);
        addPrdBtn.addActionListener(this);
        panel2.add(addPrdBtn);

        label5 = new JLabel("Price :");
        label5.setBounds(50,260,200,30);
        label5.setFont(f1);
        panel2.add(label5);

        label8 = new JLabel();
        label8.setBounds(125,260,200,30);
        label8.setFont(f1);
        panel2.add(label8);

        label6 = new JLabel("Total Items :");
        label6.setBounds(50,300,200,30);
        label6.setFont(f1);
        panel2.add(label6);

        label10 = new JLabel();
        label10.setBounds(165,300,200,30);
        label10.setFont(f1);
        panel2.add(label10);

        label7 = new JLabel("Total price :");
        label7.setBounds(350,300,200,30);
        label7.setFont(f1);
        panel2.add(label7);

        label9 = new JLabel();
        label9.setBounds(475,300,200,30);
        label9.setFont(f1);
        panel2.add(label9);

        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(400,400,100,30);
        confirmBtn.setFocusable(false);
        confirmBtn.addActionListener(this);
        panel2.add(confirmBtn);

        tp.addTab("Order List",panel1);
        tp.addTab("Create Custom Order",panel2);

        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 500, 200, 35);
        exitButton.addActionListener(this);

        super.add(exitButton);
        

        super.add(tp);

        



    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exitButton) {
            dispose();
            basket.dispose();
            Welcome wlc = new Welcome();
            wlc.setVisible(true);
            dml.truncateTable("BASKET");
        }
        else if(ae.getSource()== addPrdBtn){

            Object temp[][] = im.getData();
            Object string[] =temp[cb.getSelectedIndex()];
            
            if (tf3.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Enter Quantity");
            }
            else{
                bm.addToBasketData(string[1].toString(), tf3.getText(), this);
                tf3.setText("");
            }
            defTM.setDataVector(bm.getData(), bm.getHeaderColumn());
            defTM.fireTableDataChanged();
            
            if(flag == false){
            basket.setVisible(true);
            flag = true;

            }
            label9.setText(Integer.toString(bm.total()));//TOTAL PRICE
            label10.setText(Integer.toString(bm.totalItem()));//TOTAL ITEM
            
           
        }
        if (ae.getSource()==remfrmBsktBtn) {
            int row = jt.getSelectedRow();
            if (row!=-1) {
                String name = jt.getValueAt(row, 0).toString();
                bm.deleteBasket(name);
                defTM.setDataVector(bm.getData(), bm.getHeaderColumn());
                defTM.fireTableDataChanged();
            }

        }
        if(ae.getSource()==cb){
            Object temp[][] = im.getData();
            Object string = temp[cb.getSelectedIndex()][4];
            label8.setText(string.toString()); //determinig price
            
        }
        
        
        if (ae.getSource()==confirmBtn) {
            String name = tf2.getText();
            String phoneNumber = tf1.getText();
            String address = tf4.getText();
            int custoemrId;
            if (name.isEmpty()||phoneNumber.isEmpty() || address.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please Fill up name and Phone Number and address");
            }else{
                if (om.isNewUser(phoneNumber)) {
                    custoemrId = dml.forceAddToCustomerTable(name, phoneNumber, address);
                }
                else{
                    custoemrId = dml.getPrimaryKey("CUSTOMER", phoneNumber, "PHONE#", "CUSTOMER_ID");
                }
                om.createOrder(custoemrId);
                

                DefTM1.setDataVector(om.getData(), om.getHeaderColumn());
                DefTM1.fireTableDataChanged();
                label9.setText("");
                label10.setText("");
                tf1.setText("");
                tf2.setText("");
                tf4.setText("");
                basket.dispose();
                flag= false;

                
            }
        }
    } 
}