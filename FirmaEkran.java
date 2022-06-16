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
import javax.swing.JComboBox;
import javax.swing.JButton;

public class FirmaEkran extends JFrame {

	private JPanel contentPane;
	private JTextField textAracModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirmaEkran frame = new FirmaEkran();
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
	public FirmaEkran() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAracEkle = new JLabel("Araç Ekle");
		lblAracEkle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblAracEkle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAracEkle.setBounds(179, 6, 142, 25);
		contentPane.add(lblAracEkle);
		
		JLabel lblAracModel = new JLabel("Araç Model");
		lblAracModel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAracModel.setHorizontalAlignment(SwingConstants.CENTER);
		lblAracModel.setBounds(200, 60, 100, 16);
		contentPane.add(lblAracModel);
		
		textAracModel = new JTextField();
		textAracModel.setBounds(170, 88, 161, 32);
		contentPane.add(textAracModel);
		textAracModel.setColumns(10);
		
		JLabel lblAracTip = new JLabel("Araç Tipi");
		lblAracTip.setHorizontalAlignment(SwingConstants.CENTER);
		lblAracTip.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblAracTip.setBounds(200, 132, 100, 16);
		contentPane.add(lblAracTip);
		
		JComboBox comboAracTip = new JComboBox();
		comboAracTip.setBounds(170, 160, 157, 27);
		contentPane.add(comboAracTip);
		
		JLabel lblErken = new JLabel("En Erken Kiralama Tarihi");
		lblErken.setHorizontalAlignment(SwingConstants.CENTER);
		lblErken.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblErken.setBounds(155, 199, 192, 16);
		contentPane.add(lblErken);
		
		JComboBox comboErkenYil = new JComboBox();
		comboErkenYil.setBounds(140, 236, 67, 27);
		contentPane.add(comboErkenYil);
		
		JComboBox comboErkenAy = new JComboBox();
		comboErkenAy.setBounds(215, 236, 67, 27);
		contentPane.add(comboErkenAy);
		
		JComboBox comboErkenGun = new JComboBox();
		comboErkenGun.setBounds(290, 236, 67, 27);
		contentPane.add(comboErkenGun);
		
		JLabel lblErkenYil = new JLabel("Yıl");
		lblErkenYil.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblErkenYil.setHorizontalAlignment(SwingConstants.CENTER);
		lblErkenYil.setBounds(150, 222, 47, 16);
		contentPane.add(lblErkenYil);
		
		JLabel lbkErkenAy = new JLabel("Ay");
		lbkErkenAy.setHorizontalAlignment(SwingConstants.CENTER);
		lbkErkenAy.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lbkErkenAy.setBounds(225, 222, 47, 16);
		contentPane.add(lbkErkenAy);
		
		JLabel lblErkenGun = new JLabel("Gün");
		lblErkenGun.setHorizontalAlignment(SwingConstants.CENTER);
		lblErkenGun.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblErkenGun.setBounds(300, 222, 47, 16);
		contentPane.add(lblErkenGun);
		
		JLabel lblGec = new JLabel("En Geç Kiralama Tarihi");
		lblGec.setHorizontalAlignment(SwingConstants.CENTER);
		lblGec.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblGec.setBounds(155, 275, 192, 16);
		contentPane.add(lblGec);
		
		JComboBox comboGecYil = new JComboBox();
		comboGecYil.setBounds(140, 311, 67, 27);
		contentPane.add(comboGecYil);
		
		JComboBox comboGecAy = new JComboBox();
		comboGecAy.setBounds(215, 311, 67, 27);
		contentPane.add(comboGecAy);
		
		JComboBox comboGecGun = new JComboBox();
		comboGecGun.setBounds(290, 311, 67, 27);
		contentPane.add(comboGecGun);
		
		JLabel lblGecYil = new JLabel("Yıl");
		lblGecYil.setHorizontalAlignment(SwingConstants.CENTER);
		lblGecYil.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblGecYil.setBounds(150, 297, 47, 16);
		contentPane.add(lblGecYil);
		
		JLabel lblGecAy = new JLabel("Ay");
		lblGecAy.setHorizontalAlignment(SwingConstants.CENTER);
		lblGecAy.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblGecAy.setBounds(225, 297, 47, 16);
		contentPane.add(lblGecAy);
		
		JLabel lblGecGun = new JLabel("Gün");
		lblGecGun.setHorizontalAlignment(SwingConstants.CENTER);
		lblGecGun.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblGecGun.setBounds(300, 297, 47, 16);
		contentPane.add(lblGecGun);
		
		JButton btnKayıtEt = new JButton("Aracı Kayıt Et");
		btnKayıtEt.setBounds(190, 360, 117, 49);
		contentPane.add(btnKayıtEt);
		
		JButton btnMenuDon = new JButton("Menüye Dön");
		btnMenuDon.setBounds(0, -2, 117, 49);
		contentPane.add(btnMenuDon);
		
		JButton btnTumAraclar = new JButton("Tüm Araçlarım");
		btnTumAraclar.setBounds(383, -2, 117, 49);
		contentPane.add(btnTumAraclar);
	}
}
