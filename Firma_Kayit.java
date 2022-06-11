package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class Firma_Kayit extends JFrame {

	private JPanel contentPane;
	private JTextField firma_adi;
	private JTextField sifre;
	private JTextField sifre_tekrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Firma_Kayit frame = new Firma_Kayit();
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
	public Firma_Kayit() {
		final JOptionPane alert = new JOptionPane();
		String[] iller = {"Adana", "Adıyaman", "Afyonkarahisar", "Ağrı", "Aksaray", "Amasya", "Ankara", "Antalya", "Ardahan", "Artvin", "Aydın", "Balıkesir", "Bartın", "Batman", "Bayburt", "Bilecik", "Bingöl", "Bitlis", "Bolu", "Burdur", "Bursa", "Çanakkale", "Çankırı", "Çorum", "Denizli", "Diyarbakır", "Düzce", "Edirne", "Elazığ", "Erzincan", "Erzurum", "Eskişehir", "Gaziantep", "Giresun", "Gümüşhane", "Hakkâri", "Hatay", "Iğdır", "Isparta", "İstanbul", "İzmir", "Kahramanmaraş", "Karabük", "Karaman", "Kars", "Kastamonu", "Kayseri", "Kilis", "Kırıkkale", "Kırklareli", "Kırşehir", "Kocaeli", "Konya", "Kütahya", "Malatya", "Manisa", "Mardin", "Mersin", "Muğla", "Muş", "Nevşehir", "Niğde", "Ordu", "Osmaniye", "Rize", "Sakarya", "Samsun", "Şanlıurfa", "Siirt", "Sinop", "Sivas", "Şırnak", "Tekirdağ", "Tokat", "Trabzon", "Tunceli", "Uşak", "Van", "Yalova", "Yozgat", "Zonguldak"};
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 385);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Firma Kayıt");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(172, 6, 137, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Firma Adı");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(200, 42, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		firma_adi = new JTextField();
		firma_adi.setBounds(155, 59, 170, 34);
		contentPane.add(firma_adi);
		firma_adi.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Şifre ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_2.setBounds(210, 158, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Şifre  Tekrar");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_2_1.setBounds(191, 224, 97, 16);
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Kayıt Ol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Services service = new Services();
					if(firma_adi.getText().isBlank()||sifre.getText().isBlank()||sifre_tekrar.getText().isBlank()) {
						alert.showMessageDialog(rootPane, "Lütfen Bütün Alanları Doldurun!");
					}
					else if(!sifre.getText().equals(sifre_tekrar.getText())) {
						alert.showMessageDialog(rootPane, "Şifrenizi Kontrol Edin !");
					}
					else {
						boolean check = service.musteri_Ekle(firma_adi.getText(), sifre.getText());
						if(check == true) {
						alert.showMessageDialog(rootPane, "Firma Başarı İle Kayıt Edildi Menüden Giriş Yapabilirsiniz!");
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
		btnNewButton.setBounds(181, 287, 117, 53);
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
		btnMenyeDn.setBounds(6, 25, 117, 53);
		contentPane.add(btnMenyeDn);
		
		sifre = new JTextField();
		sifre.setColumns(10);
		sifre.setBounds(155, 178, 170, 34);
		contentPane.add(sifre);
		
		sifre_tekrar = new JTextField();
		sifre_tekrar.setColumns(10);
		sifre_tekrar.setBounds(155, 241, 170, 34);
		contentPane.add(sifre_tekrar);
		
		JLabel lblNewLabel_1_1 = new JLabel("Şehir");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(210, 103, 61, 16);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(155, 131, 170, 27);
		comboBox.setModel(new DefaultComboBoxModel(iller));
		contentPane.add(comboBox);
	
	}
}
