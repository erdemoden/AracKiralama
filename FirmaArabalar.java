package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Patika.Models.AracModel;


import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirmaArabalar extends JFrame {

	private JPanel contentPane;
	private JTable aracTablo;
	String firmaisim;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirmaArabalar frame = new FirmaArabalar("");
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
	public FirmaArabalar(String firmaisim) throws SQLException {
		final JOptionPane alert = new JOptionPane();
		this.firmaisim = firmaisim;
		final FirmaServices service = new FirmaServices();
		List<AracModel> aracModels = new ArrayList<AracModel>();
		aracModels = service.aracGetir(firmaisim);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 360);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		String [] titles = {"Araba Model","Günlük Fiyat","Araç Tipi","Kiralama Başlangıç","En Son Kiralama Günü"};
//		 Object[][] rec  = {
//				 {"Audi","345","Binek","2022-03-25","2022-07-25"}
//		 };
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Araba Model");
		model.addColumn("Günlük Fiyat");
		model.addColumn("Araç Tipi");
		model.addColumn("Kiralama Başlangıç");
		model.addColumn("En Son Kiralama Günü");
		model.addColumn("id");
		for (AracModel aracModel : aracModels) {
			model.addRow(new Object[]{aracModel.getAraba_model(),aracModel.getGunluk_fiyat(),aracModel.getArac_tip(),aracModel.getDate_bas(),aracModel.getDate_bit(),aracModel.getId()});
			
		}
		
		
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
		aracTablo = new JTable(model);
		scrollPane_1.setViewportView(aracTablo);
		
		JButton btnSeilenAracSil = new JButton("Seçilen Aracı Sil");
		btnSeilenAracSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) aracTablo.getModel();
				if(aracTablo.getSelectedRowCount() == 1) {
				System.out.println(model.getValueAt(aracTablo.getSelectedRow(),5));
				try {
					service.deleteSelectedCar(model.getValueAt(aracTablo.getSelectedRow(), 5));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					model.removeRow(aracTablo.getSelectedRow());
				}
				else {
					if(aracTablo.getSelectedRowCount() == 0) {
						alert.showMessageDialog(rootPane, "Lütfen Silmek İstediğiniz Aracı Seçin");
					}
					else {
						alert.showMessageDialog(rootPane, "Birden Fazla Araç Seçmeyin");
					}
				}
			}
		});
		btnSeilenAracSil.setBounds(533, 277, 117, 49);
		contentPane.add(btnSeilenAracSil);
	}
}
