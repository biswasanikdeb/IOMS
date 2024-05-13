package com.gui.tabbedPanels;

import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedCustomer extends JFrame{
    private JPanel panel1,panel2,panel3;
    private Label label1,label2,label3;
    private JTabbedPane tp;

    public TabbedCustomer(){
        super("Customer");
        super.setSize(900,600);
        super.setLocationRelativeTo(null);//appear the Jframe in center of the frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

       

        

        super.add(tp);

        



    }
}