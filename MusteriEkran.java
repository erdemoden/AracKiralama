package Patika;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class MusteriEkran extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JLabel musterikarsila = new JLabel();
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
	 */
	public MusteriEkran() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		musterikarsila.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		
		musterikarsila.setHorizontalAlignment(SwingConstants.CENTER);
		musterikarsila.setBounds(0, 0, 450, 44);
		contentPane.add(musterikarsila);
		
		JButton kiraladiklarimBut = new JButton("Kiraladığım Araçlar");
		kiraladiklarimBut.setBounds(0, 104, 189, 59);
		contentPane.add(kiraladiklarimBut);
		
		JButton kiralaBut = new JButton("Araç Kirala");
		kiralaBut.setBounds(264, 104, 189, 59);
		contentPane.add(kiralaBut);
		
		JButton cikisBut = new JButton("Çıkış Yap");
		cikisBut.setBounds(131, 192, 189, 59);
		contentPane.add(cikisBut);
	}
}
