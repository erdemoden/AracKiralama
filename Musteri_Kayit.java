package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Musteri_Kayit extends JFrame {

	private JPanel contentPane;
	private JTextField musteriad;
	private JTextField sifre;
	private JTextField sifre_tekrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Musteri_Kayit frame = new Musteri_Kayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Musteri_Kayit() {
		final JOptionPane alert = new JOptionPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMteriKayt = new JLabel("Müşteri Kayıt");
		lblMteriKayt.setHorizontalAlignment(SwingConstants.CENTER);
		lblMteriKayt.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblMteriKayt.setBounds(163, 5, 154, 25);
		contentPane.add(lblMteriKayt);
		
		JLabel lblNewLabel_1 = new JLabel("Müşteri Adı");
		lblNewLabel_1.setBounds(200, 42, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		musteriad = new JTextField();
		musteriad.setColumns(10);
		musteriad.setBounds(155, 70, 170, 34);
		contentPane.add(musteriad);
		
		JLabel lblNewLabel_2 = new JLabel("Şifre ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_2.setBounds(210, 116, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Şifre  Tekrar");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(192, 190, 97, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Kayıt Ol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					RegisterServices service = new RegisterServices();
					if(musteriad.getText().isBlank()||sifre.getText().isBlank()||sifre_tekrar.getText().isBlank()) {
						alert.showMessageDialog(rootPane, "Lütfen Bütün Alanları Doldurun!");
					}
					else if(!sifre.getText().equals(sifre_tekrar.getText())) {
						alert.showMessageDialog(rootPane, "Şifrenizi Kontrol Edin !");
					}
					else {
						boolean check = service.musteri_Ekle(musteriad.getText(), sifre.getText());
						if(check == true) {
						alert.showMessageDialog(rootPane, "Müşteri Başarı İle Kayıt Edildi Menüden Giriş Yapabilirsiniz!");
						}
						else {
							alert.showMessageDialog(rootPane, "Müşteri Kayıtlı !");
						}
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setBounds(182, 264, 117, 53);
		contentPane.add(btnNewButton);
		
		JButton btnMenyeDn = new JButton("Menüye Dön");
		btnMenyeDn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu = null;
				try {
					menu = new Menu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				menu.setVisible(true);
			}
		});
		btnMenyeDn.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnMenyeDn.setBounds(6, 8, 117, 53);
		contentPane.add(btnMenyeDn);
		
		sifre = new JTextField();
		sifre.setColumns(10);
		sifre.setBounds(155, 144, 170, 34);
		contentPane.add(sifre);
		
		sifre_tekrar = new JTextField();
		sifre_tekrar.setColumns(10);
		sifre_tekrar.setBounds(155, 218, 170, 34);
		contentPane.add(sifre_tekrar);
	}

}
