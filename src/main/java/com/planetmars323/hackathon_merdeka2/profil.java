package com.planetmars323.hackathon_merdeka2;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

import java.awt.Toolkit;
import java.lang.*;

public class profil extends JFrame{
	
	Icon fotoku = new ImageIcon(getClass().getResource("Foto ku.png"));
	JLabel bingkai = new JLabel(fotoku);
	JLabel kataFounder = new JLabel("Founder");
	Font font = new Font("Book Antiqua",Font.HANGING_BASELINE, 15);
	JLabel kataFacebook = new JLabel("FB        : imam.afry");
	JLabel kataTwitter = new JLabel ("Twitter   : @ImamAfriyadi");
	JLabel kataBlog = new JLabel    ("Blog      : planetmars323.blogspot.com");
	
	//alfigar
		JLabel kataFacebook2 = new JLabel("FB        : Mo Yu Hi/ moyuhi@facebook.com");
		JLabel kataTwitter2 = new JLabel ("Twitter   : @yusufgratea");
		JLabel Blog = new JLabel         ("Blog      : u-t-s-sumbawa.blogspot.com");
		
		
	//alfigar
	JLabel kataFacebook3 = new JLabel("FB       : iga.alfigar");
	JLabel kataTwitter3 = new JLabel("Twitter   : @rohbi_alfigar");
	
	profil()
	{
		super("About");
		setIconImage(Toolkit.getDefaultToolkit().getImage(profil.class.getResource("icon.png")));
		setLayout(new FlowLayout());
		
		//foto
		JPanel panelFoto = new JPanel();
		kataFounder.setFont(new Font("BookMan Old Style", Font.CENTER_BASELINE, 30));
		panelFoto.add(bingkai);
		
		//Profil Yusuf
		JPanel Yusuf = new JPanel();
		Yusuf.setLayout(new GridLayout(3,1));
		Yusuf.setBorder(BorderFactory.createTitledBorder("Muhamad Yusuf Hidayat"));
		Yusuf.add(kataFacebook2);
		Yusuf.add(kataTwitter2);
		Yusuf.add(Blog);
		kataFacebook2.setFont(font);
		kataTwitter2.setFont(font);
		Blog.setFont(font);
		
		//Profil Alfigar
		JPanel Iga = new JPanel();
		Iga.setLayout(new GridLayout(2,1));
		Iga.setBorder(BorderFactory.createTitledBorder("Alfigar Rohbiansyah"));
		Iga.add(kataFacebook3);
		Iga.add(kataTwitter3);
		kataFacebook3.setFont(font);
		kataTwitter3.setFont(font);
		
		//alamat
		JPanel panelAlamat = new JPanel();
		panelAlamat.setLayout(new GridLayout(3,1));
		panelAlamat.setBorder(BorderFactory.createTitledBorder("Imam Afriyadi"));
		kataFacebook.setFont(font);
		kataTwitter.setFont(font);
		kataBlog.setFont(font);
		panelAlamat.add(kataFacebook);
		panelAlamat.add(kataTwitter);
		panelAlamat.add(kataBlog);
		
		JPanel gabungimamyusufiga = new JPanel();
		gabungimamyusufiga.setLayout(new GridLayout(3,1));
		gabungimamyusufiga.add(panelAlamat);
		gabungimamyusufiga.add(Yusuf);
		gabungimamyusufiga.add(Iga);
		
		//deskripsi
		JPanel panelDeskripsi = new JPanel();
		panelDeskripsi.setLayout(new FlowLayout());
		panelDeskripsi.add(gabungimamyusufiga);
		panelDeskripsi.add(panelFoto);
		
		//konten
		add(kataFounder);
		add(panelDeskripsi);
		
	}

}
