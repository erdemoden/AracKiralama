package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTextField txtIsim;
	private JTextField txtSifre;
	private JTextField firgirisim;
	private JTextField firgirsifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Menu() throws SQLException {
		setResizable(false);
		final JOptionPane alert = new JOptionPane();
		final Services service = new Services();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCikis = new JButton("Uygulamadan Çık");
		btnCikis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		final JPanel mPanel = new JPanel();
		mPanel.setBackground(new Color(102, 205, 170));
		mPanel.setBounds(-350, 2, 298, 270);
		contentPane.add(mPanel);
		mPanel.setLayout(null);
		
		JLabel lblBaslikMus = new JLabel("Müşteri Giriş");
		lblBaslikMus.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaslikMus.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblBaslikMus.setBounds(71, 6, 157, 25);
		mPanel.add(lblBaslikMus);
		
		JLabel lblAd = new JLabel("Adınız : ");
		lblAd.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAd.setBounds(119, 53, 61, 16);
		mPanel.add(lblAd);
		
		txtIsim = new JTextField();
		txtIsim.setBounds(63, 81, 173, 35);
		mPanel.add(txtIsim);
		txtIsim.setColumns(10);
		
		JLabel lblSifre = new JLabel("Şifreniz : ");
		lblSifre.setHorizontalAlignment(SwingConstants.CENTER);
		lblSifre.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblSifre.setBounds(109, 143, 81, 16);
		mPanel.add(lblSifre);
		
		txtSifre = new JTextField();
		txtSifre.setColumns(10);
		txtSifre.setBounds(63, 172, 173, 35);
		mPanel.add(txtSifre);
		
		JButton btnMGirisyap = new JButton("Giriş");
		btnMGirisyap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean check = service.musteri_Giris(txtIsim.getText(),txtSifre.getText());
					if(check == false) {
						alert.showMessageDialog(rootPane,"Kullanıcı Bulunamadı Lütfen Tekrar Deneyiniz !");
					}
					else {
						MusteriEkran musteriEkran = new MusteriEkran();
						dispose();
						musteriEkran.setVisible(true);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnMGirisyap.setBounds(91, 219, 117, 29);
		mPanel.add(btnMGirisyap);
		
		JPanel fPanel = new JPanel();
		fPanel.setBackground(new Color(135, 206, 235));
		fPanel.setBounds(-350, 2, 298, 270);
		contentPane.add(fPanel);
		fPanel.setLayout(null);
		
		
		
		JLabel lblBaslikFir = new JLabel("Firma Giriş");
		lblBaslikFir.setHorizontalAlignment(SwingConstants.CENTER);
		lblBaslikFir.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblBaslikFir.setBounds(71, 6, 157, 25);
		fPanel.add(lblBaslikFir);
		
		
		final JButton btnMGiris = new JButton("Müşteri Giriş");
		final JButton btnFGiris = new JButton("Firma Giriş");
		
		// Slider 
		final Slider slider = new Slider(mPanel,fPanel,btnFGiris,btnMGiris);
		
		btnMGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slider.slideMPanel();
				
			}
		});
		
		btnFGiris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				slider.slideFPanel();
			}
		});
		btnMGiris.setBounds(310, 112, 134, 50);
		contentPane.add(btnMGiris);
		
		
		
		btnFGiris.setBounds(310, 2, 134, 50);
		contentPane.add(btnFGiris);
		
		
		
		
		
		JLabel lblFirmaAd = new JLabel("Firma Adı");
		lblFirmaAd.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirmaAd.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblFirmaAd.setBounds(106, 53, 86, 16);
		fPanel.add(lblFirmaAd);
		
		firgirisim = new JTextField();
		firgirisim.setColumns(10);
		firgirisim.setBounds(63, 81, 173, 35);
		fPanel.add(firgirisim);
		
		JLabel lblSifre_1 = new JLabel("Şifreniz : ");
		lblSifre_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSifre_1.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblSifre_1.setBounds(108, 143, 82, 16);
		fPanel.add(lblSifre_1);
		
		firgirsifre = new JTextField();
		firgirsifre.setColumns(10);
		firgirsifre.setBounds(63, 172, 173, 35);
		fPanel.add(firgirsifre);
		
		JButton btnFGirisyap = new JButton("Giriş");
		btnFGirisyap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnFGirisyap.setBounds(91, 219, 117, 29);
		fPanel.add(btnFGirisyap);
		btnCikis.setBounds(310, 222, 134, 50);
		contentPane.add(btnCikis);
		
		JButton btnMKayit = new JButton("Müşteri Kayıt");
		btnMKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Musteri_Kayit musteriKayit = new Musteri_Kayit();
				dispose();
				musteriKayit.setVisible(true);
			}
		});
		btnMKayit.setBounds(310, 167, 134, 50);
		contentPane.add(btnMKayit);
		
	
		
		JButton btnFkayit = new JButton("Firma Kayıt");
		btnFkayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Firma_Kayit firmaKayit = new Firma_Kayit();
				dispose();
				firmaKayit.setVisible(true);
			}
		});
		btnFkayit.setBounds(310, 57, 134, 50);
		contentPane.add(btnFkayit);
		slider.slideFPanel();
	}
}
