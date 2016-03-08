package com.planetmars323.hackathon_merdeka2;
import java.sql.*;

import javax.swing.JOptionPane;

public class koneksi {
	private static Connection con;
	
	public static Connection database()
	{
		try
		{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hackathon","root","antonystark");
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null,"Terjadi kesalahan pada koneksi database : "+ex.getMessage());
		}
		return con;
	}
}
