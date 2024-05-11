package com.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Welcome extends JFrame {
    private JPanel panel1, panel2;
    private Color color1;
    private JLabel label1, label2, label3;
    private Font f1;
    private JButton b1, b2, b3, b4, b5;

    public Welcome() {
        super("IOMS");
        super.setBounds(600, 300, 900, 500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(0, 0, 220, 500);
        panel1.setBackground(Color.WHITE);
        panel1.setLayout(null);

        panel2 = new JPanel();
        panel2.setBounds(220, 0, 680, 500);
        color1 = new Color(128, 128, 128);
        panel2.setBackground(color1);
        panel2.setLayout(null);

        label1 = new JLabel("Welcome");
        label1.setBounds(270, 150, 150, 30);
        label1.setForeground(Color.white);
        panel2.add(label1);
        f1 = new Font("Arial", Font.BOLD, 30);
        label1.setFont(f1);

        label2 = new JLabel("To");
        label2.setBounds(315, 200, 120, 30);
        label2.setForeground(Color.white);
        panel2.add(label2);
        f1 = new Font("Arial", Font.BOLD, 30);
        label2.setFont(f1);

        label3 = new JLabel("Inventory & Order Management");
        label3.setBounds(110, 250, 600, 35);
        label3.setForeground(Color.white);
        panel2.add(label3);
        f1 = new Font("Arial", Font.BOLD, 30);
        label3.setFont(f1);

        b1 = new JButton("Inventory");
        b1.setBounds(60, 40, 100, 35);
        b1.setFocusable(false);
        b1.setBackground(Color.lightGray);
        panel1.add(b1);

        b2 = new JButton("Orders");
        b2.setBounds(60, 100, 100, 35);
        b2.setFocusable(false);
        b2.setBackground(Color.lightGray);
        panel1.add(b2);

        b3 = new JButton("Bookings");
        b3.setBounds(60, 160, 100, 35);
        b3.setFocusable(false);
        b3.setBackground(Color.lightGray);
        panel1.add(b3);

        b4 = new JButton("Customer Info");
        b4.setBounds(45, 220, 130, 35);
        b4.setFocusable(false);
        b4.setBackground(Color.lightGray);
        panel1.add(b4);

        b5 = new JButton("Logout and Exit");
        b5.setBounds(35, 380, 150, 35);
        b5.setFocusable(false);
        b5.setBackground(Color.lightGray);
        panel1.add(b5);

        b5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        super.add(panel1);
        super.add(panel2);
    }
    
}
