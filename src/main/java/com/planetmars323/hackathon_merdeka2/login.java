package com.planetmars323.hackathon_merdeka2;
import java.awt.Toolkit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame{

	JLabel username = new JLabel("Username");
	JLabel password = new JLabel("Password");
	JTextField txtUsername = new JTextField(15);
	JPasswordField txtPassword = new JPasswordField(15);
	Icon icnLogin = new ImageIcon(getClass().getResource("login.png"));
	JButton btnLogin = new JButton("Login", icnLogin);
	JPanel panelMaster = new JPanel();
	
	Container konten = getContentPane();
	
	public login()
	{
		super("Login Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("icon.png")));
		panelMaster.setLayout(new FlowLayout());
		panelMaster.add(username);
		panelMaster.add(txtUsername);
		panelMaster.add(password);
		panelMaster.add(txtPassword);
		panelMaster.add(btnLogin);
		
		//fungsi tombol login
		btnLogin.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String i = txtUsername.getText();
				String a = txtPassword.getText();
				
				
				if(i.equals("imam") && a.equals("afriyadi"))
				{
					input_pengguna obj = new input_pengguna();
					obj.setVisible(true);
				}
			}
		});
		
		konten.add(panelMaster);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(231,161);
		setLocationRelativeTo(null);
	}

}
