package com.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientPage extends JFrame{
    private JPanel panel1;

    public ClientPage(){
        super("hi there");
        super.setBounds(600, 300, 900, 600); // (x, y, width, height);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setResizable(false);

        panel1 = new JPanel();
        panel1.setBounds(600,300,900,600);
        super.add(panel1);
    }
}
