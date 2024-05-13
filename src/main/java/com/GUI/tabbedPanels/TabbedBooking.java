package com.gui.tabbedPanels;
import java.awt.FlowLayout;
import java.awt.Label;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class TabbedBooking extends JFrame {
    private JPanel panel1,panel2,panel3;
    private Label label1,label2,label3;
    private JButton exitButton,exitButton1,exitButton2;
    private JTabbedPane tp;

    public TabbedBooking(){
        super("Booking");
        super.setSize(900,600);
        super.setLocationRelativeTo(null);//appear the Jframe in center of the frame
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        tp = new JTabbedPane();

        exitButton = new JButton("Exit");
        
        //exitButton.addActionListener(this);

        exitButton1 = new JButton("Exit");
        exitButton1.setLayout(new FlowLayout(FlowLayout.CENTER,900,550));
        //exitButton1.addActionListener(this);

        exitButton2 = new JButton("Exit");
        exitButton2.setLayout(new FlowLayout(FlowLayout.CENTER,900,550));
        //exitButton2.addActionListener(this);


        
        panel1 = new JPanel( new FlowLayout());
        panel1.setSize(900,600);
        label1 = new Label("fuck");
        label1.setSize(100,100);
        panel1.add(label1);
        panel1.add(exitButton);

        panel2 = new JPanel( new FlowLayout());
        label2 = new Label("fuck");
        panel2.setSize(900,600);
        label2.setSize(100,100);
        panel2.add(label2);
        panel2.add(exitButton1);

        panel3 = new JPanel(new FlowLayout());
        panel3.setSize(900,600);
        label3 = new Label("fuck");
        label3.setSize(100,100);
        panel3.add(label3);
        panel3.add(exitButton2);
        


        tp.addTab("tab1",panel1);
        tp.addTab("tab2",panel2);
        tp.addTab("tab3",panel3);

        

        super.add(tp);

        



    }
    
}