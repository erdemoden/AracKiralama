package Patika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;


public class Services {

	private String kullanici_adi = "root";
	private String parola = "password";
	private String db_ismi = "patika";
	
	
	private String host = "localhost";
	
	private int port = 3306;
	
	private Connection con = null;
	
	private Statement statement = null;
	
	public Services() throws SQLException {
		String url = "jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?useUnicode=true&characterEncoding=utf8";
		
		con = DriverManager.getConnection(url,kullanici_adi,parola);
		System.out.println("Bağlantı Başarılı");
		
		}
	
	public boolean musteri_Ekle(String isim,String sifre) throws SQLException {
		statement = con.createStatement();
		String sorgu = ("Insert into Musteri (isim,sifre) VALUES("+"'"+isim+"'"+","+"'"+sifre+"'"+")");
		String sorgu0 = ("SELECT Case WHEN EXISTS(SELECT*from Musteri where isim ="+"'"+isim+"'"+")"+"THEN 'true' ELSE 'false' END as kontrol");
		ResultSet rs = statement.executeQuery(sorgu0);
		while(rs.next()) {
			String check = rs.getString("kontrol");
			if(check.equals("true")) {
				return false;
			}
			else {
				statement.executeUpdate(sorgu);
				return true;
			}
		}
		return false;
	}
	
	public boolean firma_Ekle(String isim,String sifre,String sehir) throws SQLException {
		statement = con.createStatement();
		String sorgu = ("Insert into Firma (isim,sifre,sehir) VALUES("+"'"+isim+"'"+","+"'"+sifre+"'"+","+"'"+sehir+"'"+")");
		String sorgu0 = ("SELECT Case WHEN EXISTS(SELECT*from Firma where isim ="+"'"+isim+"'"+")"+"THEN 'true' ELSE 'false' END as kontrol");
		ResultSet rs = statement.executeQuery(sorgu0);
		while(rs.next()) {
			String check = rs.getString("kontrol");
			if(check.equals("true")) {
				return false;
			}
			else {
				statement.executeUpdate(sorgu);
				return true;
			}
		}
		return false;
	}
	
	public boolean firma_Giris(String isim,String sifre) throws SQLException {
		statement = con.createStatement();
		String sorgu = ("Select Case WHEN EXISTS(SELECT*from patika.Firma where isim="+"'"+isim+"'"+"and sifre="+"'"+sifre+"'"+")"+"then 'true' else 'false' End as kontrol");
		ResultSet rs = statement.executeQuery(sorgu);
		
		while(rs.next()) {
			String check = rs.getString("kontrol");
			if(check.equals("true")) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	public boolean musteri_Giris(String isim,String sifre) throws SQLException {
		statement = con.createStatement();
		String sorgu = ("SELECT Case WHEN EXISTS(SELECT*from patika.Musteri where isim="+"'"+isim+"'"+"AND sifre="+"'"+sifre+"'"+")"+"THEN 'true' ELSE 'false' END as kontrol");
		ResultSet rs = statement.executeQuery(sorgu);
		while(rs.next()) {
			String check = rs.getString("kontrol");
			if(check.equals("true")) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	
}
