package com.gui.tabbedPanels;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedOrder extends JFrame{
    private JPanel panel1,panel2,panel3;
    private Label label1,label2,label3;
    private JTabbedPane tp;

    public TabbedOrder(){
        super("Order");
        super.setSize(900,600);
        super.setLocationRelativeTo(null);//appear the Jframe in center of the frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        tp = new JTabbedPane();
        
        panel1 = new JPanel( new FlowLayout());
        panel1.setSize(900,600);
        label1 = new Label("fuck");
        label1.setSize(100,100);
        panel1.add(label1);

        panel2 = new JPanel( new FlowLayout());
        label2 = new Label("fuck");
        panel2.setSize(900,600);
        label2.setSize(100,100);
        panel2.add(label2);

        panel3 = new JPanel(new FlowLayout());
        panel3.setSize(900,600);
        label3 = new Label("fuck");
        label3.setSize(100,100);
        panel3.add(label3);

        


        tp.addTab("tab1",panel1);
        tp.addTab("tab2",panel2);
        tp.addTab("tab3",panel3);

        

        super.add(tp);

        



    }
}