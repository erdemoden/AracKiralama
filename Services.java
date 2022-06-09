package Patika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Services {

	private String kullanici_adi = "sql11498331";
	private String parola = "LpMPZ9Md2P";
	private String db_ismi = "sql11498331";
	
	
	private String host = "sql11.freemysqlhosting.net";
	
	private int port = 3306;
	
	private Connection con = null;
	
	private Statement statement = null;
	
	public Services() throws SQLException {
		String url = "jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?useUnicode=true&characterEncoding=utf8";
		
		con = DriverManager.getConnection(url,kullanici_adi,parola);
		System.out.println("Bağlantı Başarılı");
		
		}
	
	public void musteri_Ekle(String isim,String sifre) throws SQLException {
		statement = con.createStatement();
		String sorgu = ("Insert into Müşteri (isim,şifre) VALUES("+"'"+isim+"'"+","+"'"+sifre+"'"+")");
		String sorgu0 = ("SELECT Case WHEN EXISTS(SELECT*from Müşteri where isim ="+"'"+isim+"'"+")"+"THEN 'true' ELSE 'false' END as kontrol");
		//"SELECT Case WHEN EXISTS(SELECT*from Müşteri where isim ="+"'"+isim+"'"+")"+"THEN 'true' ELSE 'false' END as check"
		ResultSet rs = statement.executeQuery(sorgu0);
		while(rs.next()) {
			String check = rs.getString("kontrol");
			System.out.println(check);
		}
		//statement.executeUpdate(sorgu);
	}
	
	public void firma_Ekle(String isim,String sifre,String sehir) throws SQLException {
		statement = con.createStatement();
		String sorgu = ("Insert into Firma (isim,şifre,şehir) VALUES("+"'"+isim+"'"+","+"'"+sifre+"'"+","+"'"+sehir+"'"+")");
		statement.executeUpdate(sorgu);
	}
	
}
