
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class SignUp extends JFrame implements ActionListener,MouseListener{
    JLabel firstnamelbl,surnamelbl,phoneormaillbl,passlbl,repasslbl,dbirthlbl,genderlbl,text1,text2;
	JTextField firstnameTF,surnameTF,phoneormaillTF,dbirthTF,genderTF;
	JPasswordField passPF,repassTF;
	JCheckBox male,female,others;
	ButtonGroup bGroup;
    JButton signButton,clearButton;
	JPanel panel;
	Color myColor;
	Font myFont,font2;
	Cursor c1;
	
	public SignUp()
	{
		super("create your account");
		this.setSize(750, 700);
        this.setLocation(450,200);

		
		myColor =new Color(192,192,192);
		myFont = new Font("Cambria", Font.PLAIN, 20);
        font2 = new Font("Cambria", Font.PLAIN, 30);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(myColor);

        text2 = new JLabel("It's quick and easy ");
		text2.setBounds(50, 50, 350, 30);
		text2.setBackground(Color.GRAY);
		text2.setOpaque(false);
		text2.setForeground(Color.BLACK);
		text2.setFont(myFont);
		panel.add(text2);

        text1 = new JLabel("Sign Up ");
		text1.setBounds(50, 10, 160, 40);
		text1.setBackground(myColor);
		text1.setOpaque(true);
		text1.setForeground(Color.BLACK);
		text1.setFont(font2);
		panel.add(text1);
			
		firstnamelbl = new JLabel("First Name : ");
		firstnamelbl.setBounds(50, 100, 160, 30);
		firstnamelbl.setBackground(Color.GRAY);
		firstnamelbl.setOpaque(false);
		firstnamelbl.setForeground(Color.BLUE);
		firstnamelbl.setFont(myFont);
		panel.add(firstnamelbl);
	
	    firstnameTF = new JTextField();
		firstnameTF.setBounds(50, 130, 250, 35);
		firstnameTF.setBackground(Color.WHITE);
		panel.add(firstnameTF);
	
		surnamelbl = new JLabel("Surname : ");
		surnamelbl.setBounds(400, 100, 160, 40);
		surnamelbl.setBackground(Color.GRAY);
		surnamelbl.setOpaque(false);
		surnamelbl.setForeground(Color.BLUE);
		surnamelbl.setFont(myFont);
		panel.add(surnamelbl);
	
	    surnameTF = new JTextField();
		surnameTF.setBounds(400, 130, 250, 35);
		surnameTF.setBackground(Color.WHITE);
		panel.add(surnameTF);
		
		genderlbl =new JLabel("Gender :");
		genderlbl.setBounds(50, 170, 300, 40);
		genderlbl.setBackground(Color.GRAY);
		genderlbl.setOpaque(false);
		genderlbl.setForeground(Color.BLUE);
		genderlbl.setFont(myFont);
		panel.add(genderlbl);


        male=new JCheckBox("male");
        male.setBounds(230, 170, 100, 40);
        panel.add(male);

        female=new JCheckBox("female");
        female.setBounds(330, 170, 100, 40);
        panel.add(female);

        others=new JCheckBox("others");
        others.setBounds(430, 170, 100, 40);
        panel.add(others);

		bGroup =new ButtonGroup();
		bGroup.add(male);
		bGroup.add(female);
		bGroup.add(others);

        dbirthlbl = new JLabel("Date of Birth");
		dbirthlbl.setBounds(50, 230, 350, 35);
		dbirthlbl.setBackground(Color.GRAY);
		dbirthlbl.setOpaque(false);
		dbirthlbl.setForeground(Color.BLUE);
		dbirthlbl.setFont(myFont);
		panel.add(dbirthlbl);

        dbirthTF = new JTextField();
		dbirthTF.setBounds(250, 230, 400, 35);
		dbirthTF.setBackground(Color.WHITE);
		panel.add(dbirthTF);

        phoneormaillbl =new JLabel("Phone or email : ");
		phoneormaillbl.setBounds(50, 280, 300, 40);
		phoneormaillbl.setBackground(Color.GRAY);
		phoneormaillbl.setOpaque(false);
		phoneormaillbl.setForeground(Color.BLUE);
		phoneormaillbl.setFont(myFont);
		panel.add(phoneormaillbl);

		phoneormaillTF = new JTextField();
		phoneormaillTF.setBounds(50, 320, 600, 35);
		phoneormaillTF.setBackground(Color.WHITE);
		panel.add(phoneormaillTF);

		passlbl =new JLabel("New Password:");
		passlbl.setBounds(50, 350, 160, 40);
		passlbl.setBackground(Color.GRAY);
		passlbl.setOpaque(false);
		passlbl.setForeground(Color.BLUE);
		passlbl.setFont(myFont);
		panel.add(passlbl);

        passPF = new JPasswordField();
		passPF.setBounds(50, 380, 600, 35);
		passPF.setEchoChar('*');
		panel.add(passPF);

        repasslbl =new JLabel("Confirm Password: ");
		repasslbl.setBounds(50, 410, 300, 40);
		repasslbl.setBackground(Color.GRAY);
		repasslbl.setOpaque(false);
		repasslbl.setForeground(Color.BLUE);
		repasslbl.setFont(myFont);
		panel.add(repasslbl);

        repassTF = new JPasswordField();
		repassTF.setBounds(50, 450, 600, 35);
		repassTF.setEchoChar('*');
		panel.add(repassTF);
		

		c1 =new Cursor(Cursor.HAND_CURSOR);
		
		signButton = new JButton("Create Account");
		signButton.setCursor(c1);
		signButton.setBounds(200, 560, 300, 45);
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
	
}