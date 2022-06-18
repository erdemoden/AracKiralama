package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Patika.Models.AracModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FirmaEkran extends JFrame {

	private JPanel contentPane;
	private JTextField textAracModel;
	String firmaisim = "";
	String year = "2022";
	String month = "01";
	String year1 = "2022";
	String month1 = "01";
	ArrayList<String> days = new ArrayList<String>();
	ArrayList<String> days1 = new ArrayList<String>();
	private JTextField textGunlukFiyat;
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
	 * @throws SQLException 
	 */
	public FirmaEkran() throws SQLException {
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		final FirmaServices firmaService = new FirmaServices();
		final JOptionPane alert = new JOptionPane();
		setResizable(false);
		YearMonth ym = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));
		for(int i =1;i<=ym.lengthOfMonth();i++) {
			if(i<10) {
				days.add("0"+String.valueOf(i));
				days1.add("0"+String.valueOf(i));
			}
			else {
			days.add(String.valueOf(i));
			days1.add(String.valueOf(i));
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 504);
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
		
		final JComboBox comboAracTip = new JComboBox();
		comboAracTip.setModel(new DefaultComboBoxModel(new String[] {"binek", "spor", "arazi", "ticari"}));
		comboAracTip.setBounds(170, 160, 157, 27);
		contentPane.add(comboAracTip);
		
		JLabel lblErken = new JLabel("En Erken Kiralama Tarihi");
		lblErken.setHorizontalAlignment(SwingConstants.CENTER);
		lblErken.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblErken.setBounds(155, 199, 192, 16);
		contentPane.add(lblErken);
		
		final JComboBox comboErkenGun = new JComboBox(days.toArray());
		comboErkenGun.setBounds(290, 236, 67, 27);
		contentPane.add(comboErkenGun);
		
		final JComboBox comboErkenYil = new JComboBox();
		comboErkenYil.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"}));
		comboErkenYil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year = (String) comboErkenYil.getSelectedItem();
				days.removeAll(days);
				YearMonth ym = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));
				for(int i =1;i<=ym.lengthOfMonth();i++) {
					if(i<10) {
						days.add("0"+String.valueOf(i));
					}
					else {
					days.add(String.valueOf(i));
					}
				}
				adddays(days);
			}

			private void adddays(ArrayList<String> days) {
				comboErkenGun.removeAllItems();
				comboErkenGun.setModel(new DefaultComboBoxModel(days.toArray()));
				
			}
		});
		comboErkenYil.setBounds(124, 236, 83, 27);
		contentPane.add(comboErkenYil);
		
		
		
		final JComboBox comboErkenAy = new JComboBox();
		comboErkenAy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				days.removeAll(days);
				month = (String) comboErkenAy.getSelectedItem();
				YearMonth ym = YearMonth.of(Integer.parseInt(year), Integer.parseInt(month));
				for(int i =1;i<=ym.lengthOfMonth();i++) {
					if(i<10) {
						days.add("0"+String.valueOf(i));
					}
					else {
					days.add(String.valueOf(i));
					}
				}
				adddays(days);
			}

			private void adddays(ArrayList<String> days) {
				
			comboErkenGun.removeAllItems();
			comboErkenGun.setModel(new DefaultComboBoxModel(days.toArray()));
				
			}

			
		});
		comboErkenAy.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboErkenAy.setBounds(215, 236, 67, 27);
		contentPane.add(comboErkenAy);
		
		
		
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
		
		final JComboBox comboGecGun = new JComboBox(days1.toArray());
		comboGecGun.setBounds(290, 311, 67, 27);
		contentPane.add(comboGecGun);
		
		final JComboBox comboGecYil = new JComboBox();
		comboGecYil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				year1 = (String) comboGecYil.getSelectedItem();
				days1.removeAll(days1);
				YearMonth ym = YearMonth.of(Integer.parseInt(year1), Integer.parseInt(month1));
				for(int i =1;i<=ym.lengthOfMonth();i++) {
					if(i<10) {
						days1.add("0"+String.valueOf(i));
					}
					else {
					days1.add(String.valueOf(i));
					}
				}
				adddays(days1);
			}

			private void adddays(ArrayList<String> days1) {
				comboGecGun.removeAllItems();
				comboGecGun.setModel(new DefaultComboBoxModel(days1.toArray()));
				
			}
		});
		comboGecYil.setModel(new DefaultComboBoxModel(new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040"}));
		comboGecYil.setBounds(124, 311, 83, 27);
		contentPane.add(comboGecYil);
		
		final JComboBox comboGecAy = new JComboBox();
		comboGecAy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				days1.removeAll(days1);
				month1 = (String) comboGecAy.getSelectedItem();
				YearMonth ym = YearMonth.of(Integer.parseInt(year1),Integer.parseInt(month1));
				for(int i =1;i<=ym.lengthOfMonth();i++) {
					if(i<10) {
						days1.add("0"+String.valueOf(i));
					}
					else {
					days1.add(String.valueOf(i));
					}
				}
				adddays(days1);
				
			}

			private void adddays(ArrayList<String> days1) {
				comboGecGun.removeAllItems();
				comboGecGun.setModel(new DefaultComboBoxModel(days1.toArray()));
				
			}
		});
		comboGecAy.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		comboGecAy.setBounds(215, 311, 67, 27);
		contentPane.add(comboGecAy);
		
		
		
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
		
		JLabel lblGunlukFiyat = new JLabel("Günlük Fiyat");
		lblGunlukFiyat.setHorizontalAlignment(SwingConstants.CENTER);
		lblGunlukFiyat.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblGunlukFiyat.setBounds(200, 350, 100, 16);
		contentPane.add(lblGunlukFiyat);
		
		textGunlukFiyat = new JTextField();
		textGunlukFiyat.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				
				if(!Character.isDigit(c)) {
					e.consume();
				}
			}
		});
		textGunlukFiyat.setColumns(10);
		textGunlukFiyat.setBounds(170, 378, 161, 32);
		contentPane.add(textGunlukFiyat);
		
		JButton btnKayıtEt = new JButton("Aracı Kayıt Et");
		btnKayıtEt.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String sDate1 = year+"-"+month+"-"+comboErkenGun.getSelectedItem();				
				String sDate2 = year1+"-"+month1+"-"+comboGecGun.getSelectedItem();
				
				
				 try {
					Date date1= formatter.parse(sDate1);
					 Date date2= formatter.parse(sDate2);
					 if(textAracModel.getText().isBlank()|| textGunlukFiyat.getText().isBlank()) {
							alert.showMessageDialog(rootPane, "Lütfen Bütün Alanları Doldurun!");
						}
					 else if(date1.after(date2)) {
						 alert.showMessageDialog(rootPane,"En Erken Kiralama Tarihi En Geç Kiralama Tarihinden Büyük Olmamaz");
					 }
					 else {
						AracModel aracModel = new AracModel(textAracModel.getText(),Integer.parseInt(textGunlukFiyat.getText()),comboAracTip.getSelectedItem().toString(),date1,date2);
						firmaService.aracEkle(firmaisim, aracModel);
						 alert.showMessageDialog(rootPane,"Araç Başarı İle Kayıt Edildi");
					 }
				} catch (ParseException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}  
					
					
					
				 
			}
		});
		btnKayıtEt.setBounds(191, 421, 117, 49);
		contentPane.add(btnKayıtEt);
		
		JButton btnMenuDon = new JButton("Menüye Dön");
		btnMenuDon.setBounds(0, -2, 117, 49);
		contentPane.add(btnMenuDon);
		
		JButton btnTumAraclar = new JButton("Tüm Araçlarım");
		btnTumAraclar.setBounds(383, -2, 117, 49);
		contentPane.add(btnTumAraclar);
		
		
		
		
	}
}
