package com.planetmars323.hackathon_merdeka2;
import javax.swing.*;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.table.*;

public class input_pengguna extends JFrame{
	JLabel lblNo = new JLabel("No. ");
	JLabel lblNama = new JLabel("Nama : ");
	JLabel lblNohp = new JLabel("No. HP : ");
	JLabel lblEmail = new JLabel("Email : ");
	JLabel lblAlamat = new JLabel("Alamat : ");
	JLabel lblPekerjaan = new JLabel("Pekerjaan : ");
	JRadioButton radUmum = new JRadioButton("Umum");
	JRadioButton radMahasiswa = new JRadioButton("Mahasiswa");
	JRadioButton radSMA = new JRadioButton("Pelajar SMA");
	JRadioButton radSMP = new JRadioButton("Pelajar SMP");
	ButtonGroup groupPekerjaan = new ButtonGroup();
	JTextField txtNo = new JTextField(15);
	JTextField txtNama = new JTextField();
	JTextField txtNohp = new JTextField();
	JTextField txtEmail = new JTextField();
	JTextArea txtAlamat = new JTextArea();
	JScrollPane scroll = new JScrollPane();
	JButton btnSimpan = new JButton("Simpan");
	JButton btnBatal = new JButton("Batal");
	JButton btnTambah = new JButton("Tambah");
	JTable tabelPengguna = new JTable();
	String field[] = {"No","Nama","Alamat","Pekerjaan","No. HP","E-Mail","Kelompok"};
	DefaultTableModel modelPengguna = new DefaultTableModel(null, field);
	JScrollPane scrollTabel = new JScrollPane();
	Container konten = getContentPane();
	ResultSet result = null;
	PreparedStatement ps = null;
	Connection conect = null;
	Statement state = null;
	
	public input_pengguna()
	{
		super("Aplikasi Tes Kepribadian Islam");
		setIconImage(Toolkit.getDefaultToolkit().getImage(input_pengguna.class.getResource("icon.png")));
		setLayout(new GridLayout());
		setSize(500,500);
		setVisible(true);
		setSize(914,500);
		setLocationRelativeTo(null);
		
		scroll.getViewport().add(txtAlamat);
		
		JPanel panelInput = new JPanel();
		panelInput.setBorder(BorderFactory.createTitledBorder("Input Data Diri"));
		panelInput.setLayout(new GridLayout(10,2));
		panelInput.add(lblNo);
		panelInput.add(txtNo);
		panelInput.add(lblNama);
		panelInput.add(txtNama);
		panelInput.add(lblNohp);
		panelInput.add(txtNohp);
		panelInput.add(lblEmail);
		panelInput.add(txtEmail);
		panelInput.add(lblAlamat);
		panelInput.add(scroll);
		panelInput.add(lblPekerjaan);
		groupPekerjaan.add(radUmum);
		groupPekerjaan.add(radMahasiswa);
		groupPekerjaan.add(radSMA);
		groupPekerjaan.add(radSMP);
		panelInput.add(radUmum);
		panelInput.add(i(new JLabel("")));
		panelInput.add(radMahasiswa);
		panelInput.add(i(new JLabel("")));
		panelInput.add(radSMA);
		panelInput.add(i(new JLabel("")));
		panelInput.add(radSMP);
		JPanel panelTombol = new JPanel();
		panelTombol.setLayout(new FlowLayout());
		panelTombol.add(btnTambah);
		panelTombol.add(btnSimpan);
		panelTombol.add(btnBatal);
		panelInput.add(panelTombol);
		JPanel panelMaster = new JPanel();
		panelMaster.add(panelInput);
		
		JPanel panelTabel = new JPanel();
		panelTabel.setLayout(new FlowLayout());
		tabelPengguna.setModel(modelPengguna);
		scrollTabel.getViewport().add(tabelPengguna);
		panelTabel.add(scrollTabel);
		
		panelMaster.add(panelTabel);
		
		konten.add(panelMaster);
		tampilTabel();
		kembali();
		
		penghendel hendel = new penghendel();
		btnSimpan.addActionListener(hendel);
		btnBatal.addActionListener(hendel);
		btnTambah.addActionListener(hendel);
	}
	
	private class penghendel implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource()==btnTambah)
			{
				txtNama.requestFocus();
				txtNama.setEditable(true);
				txtAlamat.setEditable(true);
				txtNohp.setEditable(true);
				txtEmail.setEditable(true);
				radUmum.setEnabled(true);
				radMahasiswa.setEnabled(true);
				radSMA.setEnabled(true);
				radSMP.setEnabled(true);
				btnSimpan.setEnabled(true);
				btnBatal.setEnabled(true);
				btnTambah.setEnabled(false);
				try
				{
					conect = koneksi.database();
					state = conect.createStatement();
					result = state.executeQuery("select nomor from bbi order by nomor desc");
					
					if(result.next())
					{
					int i = result.getInt(1) + 1;
					txtNo.setText(""+i);
					}
					else
					{
						txtNo.setText("1");
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol tambah : "+ex.getMessage());
				}
			}
			else if(e.getSource()==btnSimpan)
			{
				String a = "";
				
				if(radUmum.isSelected())
				{
					a="Umum";
				}
				else if(radMahasiswa.isSelected())
				{
					a="Mahasiswa";
				}else if(radSMA.isSelected())
				{
					a="Pelajar SMA";
				}else if(radSMP.isSelected())
				{
					a="Pelajar SMP";
				}
				
				try
				{
					conect = koneksi.database();
					ps = conect.prepareStatement("insert into bbi(nama,alamat,pekerjaan,no_hp,email) values (?,?,?,?,?)");
					
					ps.setString(1, txtNama.getText());
					ps.setString(2, txtAlamat.getText());
					ps.setString(3, a);
					ps.setString(4, txtNohp.getText());
					ps.setString(5, txtEmail.getText());
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
					
					
					tampilTabel();
					kembali();
					
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tombol simpan : "+ex.getMessage());
				}
			}
			else if(e.getSource()==btnBatal)
			{
				kembali();
			}
		}
	}
	
	public void tampilTabel()
	{
		modelPengguna.getDataVector().removeAllElements();
		modelPengguna.fireTableDataChanged();
		try
		{
			conect = koneksi.database();
			state = conect.createStatement();
			result = state.executeQuery("select * from bbi");
			
			while(result.next())
			{
				Object obj[] = new Object[6];
				obj[0] = result.getInt(1);
				obj[1] = result.getString(2);
				obj[2] = result.getString(3);
				obj[3] = result.getString(4);
				obj[4] = result.getString(5);
				obj[5] = result.getString(6);
				 
				modelPengguna.addRow(obj);
			}
		
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada tampil tabel : "+ex.getMessage());
		}
	}
	
	public JLabel i(JLabel label)
	{
		return label;
	}
	
	public void kembali()
	{
		txtNo.setEditable(false);
		txtNama.setEditable(false);
		txtAlamat.setEditable(false);
		txtNohp.setEditable(false);
		txtEmail.setEditable(false);
		btnSimpan.setEnabled(false);
		btnBatal.setEnabled(false);
		tabelPengguna.setEnabled(false);
		groupPekerjaan.clearSelection();
		radUmum.setEnabled(false);
		radMahasiswa.setEnabled(false);
		radSMA.setEnabled(false);
		radSMP.setEnabled(false);
		btnTambah.setEnabled(true);
		txtNo.setText("");
		txtNama.setText("");
		txtAlamat.setText("");
		txtNohp.setText("");
		txtEmail.setText("");
	}
}
