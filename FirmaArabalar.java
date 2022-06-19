package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FirmaArabalar extends JFrame {

	private JPanel contentPane;
	private JTable aracTablo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirmaArabalar frame = new FirmaArabalar();
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
	public FirmaArabalar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String [] titles = {"Araba Model","Günlük Fiyat","Araç Tipi","Kiralama Başlangıç","En Son Kiralama Günü"};
		 Object[][] rec  = {
				 {"Audi","345","Binek","2022-03-25","2022-07-25"}
		 };
		JButton btnSeilenAracSil = new JButton("Seçilen Aracı Sil");
		btnSeilenAracSil.setBounds(533, 277, 117, 49);
		contentPane.add(btnSeilenAracSil);
		
		JLabel lblNewLabel = new JLabel("Tüm Arabalarım");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel.setBounds(163, 6, 192, 25);
		contentPane.add(lblNewLabel);
		
		JButton btnncekiSayfayaDn = new JButton("Önceki Sayfaya Dön");
		btnncekiSayfayaDn.setBounds(0, 277, 146, 49);
		contentPane.add(btnncekiSayfayaDn);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(6, 43, 638, 230);
		contentPane.add(scrollPane_1);
		aracTablo = new JTable(rec,titles);
		scrollPane_1.setViewportView(aracTablo);
	}
}
