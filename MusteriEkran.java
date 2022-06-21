package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Patika.Models.AracModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class MusteriEkran extends JFrame {

	private JPanel contentPane;
	private JTable Tablo;
	private JTextField txtsehir;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriEkran frame = new MusteriEkran();
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
	public MusteriEkran() throws SQLException {
		final JOptionPane alert = new JOptionPane();
		final MusteriServices musteriService = new MusteriServices();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Araba Model");
		model.addColumn("Günlük Fiyat");
		model.addColumn("Araç Tipi");
		model.addColumn("Tarihinden");
		model.addColumn("Tarihine");
		model.addColumn("Şehir");
		model.addColumn("Firma");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 76, 638, 255);
		contentPane.add(scrollPane);
		
		Tablo = new JTable(model);
		scrollPane.setViewportView(Tablo);
		
		JButton btnkirala = new JButton("Araç Kirala");
		btnkirala.setBounds(253, 334, 130, 59);
		contentPane.add(btnkirala);
		
		JLabel lblsehir = new JLabel("Şehir : ");
		lblsehir.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblsehir.setHorizontalAlignment(SwingConstants.CENTER);
		lblsehir.setBounds(102, 19, 90, 34);
		contentPane.add(lblsehir);
		
		txtsehir = new JTextField();
		txtsehir.setBounds(204, 20, 201, 38);
		contentPane.add(txtsehir);
		txtsehir.setColumns(10);
		
		JButton btnlistele = new JButton("Araçları Listele");
		btnlistele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			List<AracModel> aracModels = new ArrayList<AracModel>();
			try {
				aracModels = musteriService.aracListele(txtsehir.getText());
				if(aracModels.size()<=0) {
					alert.showMessageDialog(rootPane, "Bu Şehirde Araç Kiralayan Bulunamadı");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (AracModel aracModel : aracModels) {
				model.addRow(new Object[]{aracModel.getAraba_model(),aracModel.getGunluk_fiyat(),aracModel.getArac_tip(),aracModel.getDate_bas(),aracModel.getDate_bit(),aracModel.getSehir(),aracModel.getFirmaisim()});
			}
			}
		});
		btnlistele.setBounds(417, 18, 130, 45);
		contentPane.add(btnlistele);
		
		JButton btnMenu = new JButton("Menü");
		btnMenu.setBounds(6, 334, 130, 59);
		contentPane.add(btnMenu);
		
		JButton btnkiraladiklarim = new JButton("Tüm Kiraladığım Araçlar");
		btnkiraladiklarim.setBounds(474, 334, 170, 59);
		contentPane.add(btnkiraladiklarim);
	}
}
