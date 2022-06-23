package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class MusteriRandevu extends JFrame {

	private JPanel contentPane;
	private JTable randevuTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusteriRandevu frame = new MusteriRandevu();
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
	public MusteriRandevu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 401);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRandevu = new JLabel("Randevularım");
		lblRandevu.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblRandevu.setHorizontalAlignment(SwingConstants.CENTER);
		lblRandevu.setBounds(236, 17, 178, 31);
		contentPane.add(lblRandevu);
		
		JButton btnRandevuSil = new JButton("Randevu Sil");
		btnRandevuSil.setBounds(332, 308, 130, 59);
		contentPane.add(btnRandevuSil);
		
		JButton btnOncekiSayfa = new JButton("Önceki Sayfa");
		btnOncekiSayfa.setBounds(190, 308, 130, 59);
		contentPane.add(btnOncekiSayfa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 62, 638, 242);
		contentPane.add(scrollPane);
		
		randevuTable = new JTable();
		scrollPane.setViewportView(randevuTable);
	}
}
