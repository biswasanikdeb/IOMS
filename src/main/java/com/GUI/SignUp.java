	package com.gui;
	import javax.swing.*;
	import java.awt.event.*;
	import java.awt.*;


	public class SignUp extends JFrame implements ActionListener,MouseListener{
		JLabel firstnamelbl,surnamelbl,username,phoneormaillbl,passlbl,repasslbl,dbirthlbl,genderlbl,text1,text2;
		JTextField firstnameTF,surnameTF,phoneormaillTF,dbirthTF,genderTF, unTF;
		JPasswordField passPF,repassTF;
		JCheckBox male,female;
		ButtonGroup bGroup;
		JButton signButton,clearButton;
		JPanel panel;
		Color myColor;
		Font myFont,font2;
		Cursor c1;
		
		public SignUp()
		{
			super("Create New Account");
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(900, 600);
			this.setLocation(450,200);

			
			myColor =new Color(192,192,192);
			myFont = new Font("Cambria", Font.PLAIN, 20);
			font2 = new Font("Cambria", Font.PLAIN, 30);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setSize(900,600);
			panel.setBackground(myColor);


			text1 = new JLabel("Sign Up ");
			text1.setBounds(390, 20, 160, 40);
			text1.setBackground(myColor);
			text1.setOpaque(true);
			text1.setForeground(Color.BLACK);
			text1.setFont(font2);
			panel.add(text1);
				
			firstnamelbl = new JLabel("First Name");
			firstnamelbl.setBounds(50, 100, 190, 30);
			firstnamelbl.setBackground(Color.GRAY);
			firstnamelbl.setOpaque(false);
			firstnamelbl.setForeground(Color.BLUE);
			firstnamelbl.setFont(myFont);
			panel.add(firstnamelbl);
		
			firstnameTF = new JTextField();
			firstnameTF.setBounds(50, 130, 250, 35);
			firstnameTF.setBackground(Color.WHITE);
			panel.add(firstnameTF);
		
			surnamelbl = new JLabel("Lastname");
			surnamelbl.setBounds(500, 100, 160, 40);
			surnamelbl.setBackground(Color.GRAY);
			surnamelbl.setOpaque(false);
			surnamelbl.setForeground(Color.BLUE);
			surnamelbl.setFont(myFont);
			panel.add(surnamelbl);
		
			surnameTF = new JTextField();
			surnameTF.setBounds(500, 130, 250, 35);
			surnameTF.setBackground(Color.WHITE);
			panel.add(surnameTF);
			
			username = new JLabel("Username");
			username.setBounds(50, 180, 160, 40);
			username.setBackground(Color.GRAY);
			username.setOpaque(false);
			username.setForeground(Color.BLUE);
			username.setFont(myFont);
			panel.add(username);
		
			unTF = new JTextField();
			unTF.setBounds(150, 185, 250, 35);
			unTF.setBackground(Color.WHITE);
			panel.add(unTF);

			genderlbl =new JLabel("Gender");
			genderlbl.setBounds(50, 230, 300, 40);
			genderlbl.setBackground(Color.GRAY);
			genderlbl.setOpaque(false);
			genderlbl.setForeground(Color.BLUE);
			genderlbl.setFont(myFont);
			panel.add(genderlbl);


			male=new JCheckBox("Male");
			male.setBounds(145, 235, 70, 30);
			panel.add(male);

			female=new JCheckBox("Female");
			female.setBounds(225, 235, 80, 30);
			panel.add(female);

			bGroup =new ButtonGroup();
			bGroup.add(male);
			bGroup.add(female);
			

			dbirthlbl = new JLabel("Date of Birth");
			dbirthlbl.setBounds(50, 280, 350, 35);
			dbirthlbl.setBackground(Color.GRAY);
			dbirthlbl.setOpaque(false);
			dbirthlbl.setForeground(Color.BLUE);
			dbirthlbl.setFont(myFont);
			panel.add(dbirthlbl);

			dbirthTF = new JTextField();
			dbirthTF.setBounds(170, 280, 250, 35);
			dbirthTF.setBackground(Color.WHITE);
			panel.add(dbirthTF);

			phoneormaillbl =new JLabel("Phone or Email");
			phoneormaillbl.setBounds(50, 330, 300, 40);
			phoneormaillbl.setBackground(Color.GRAY);
			phoneormaillbl.setOpaque(false);
			phoneormaillbl.setForeground(Color.BLUE);
			phoneormaillbl.setFont(myFont);
			panel.add(phoneormaillbl);

			phoneormaillTF = new JTextField();
			phoneormaillTF.setBounds(195, 330, 400, 35);
			phoneormaillTF.setBackground(Color.WHITE);
			panel.add(phoneormaillTF); 

			passlbl =new JLabel("New Password");
			passlbl.setBounds(50, 390, 160, 40);
			passlbl.setBackground(Color.GRAY);
			passlbl.setOpaque(false);
			passlbl.setForeground(Color.BLUE);
			passlbl.setFont(myFont);
			panel.add(passlbl);

			passPF = new JPasswordField();
			passPF.setBounds(190, 390, 400, 35);
			passPF.setEchoChar('*');
			panel.add(passPF); 

			repasslbl =new JLabel("Confirm Password");
			repasslbl.setBounds(50, 450, 300, 40);
			repasslbl.setBackground(Color.GRAY);
			repasslbl.setOpaque(false);
			repasslbl.setForeground(Color.BLUE);
			repasslbl.setFont(myFont);
			panel.add(repasslbl);

		repassTF = new JPasswordField();
			repassTF.setBounds(220, 450, 400, 35);
			repassTF.setEchoChar('*');
			panel.add(repassTF); 
			

			c1 =new Cursor(Cursor.HAND_CURSOR);
			
			signButton = new JButton("Create Account");
			signButton.setCursor(c1);
			signButton.setBounds(340, 505, 200, 30);
			signButton.setBackground(Color.GREEN);
			signButton.setForeground(Color.BLACK);
			signButton.setOpaque(true);
			signButton.addMouseListener(this);
			panel.add(signButton);
			
		
			this.add(panel);
		}
		public void mouseClicked(){}
		public void mousePressed(){}
		public void mouseReleased(){}
		public void actionPerformed(ActionEvent ae){}
		
		public void mouseEntered(MouseEvent me){
			if(me.getSource()==signButton){
				signButton.setBackground(Color.BLUE);
				signButton.setForeground(Color.gray);
				signButton.setOpaque(true);
			}

		}
		public void mouseExited(MouseEvent me){
			if(me.getSource()==signButton){
				signButton.setBackground(Color.GREEN);
				signButton.setForeground(Color.BLACK);
				signButton.setOpaque(true);
			}

		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
		}
		
	}
