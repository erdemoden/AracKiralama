package Patika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Patika.Models.AracModel;

public class MusteriServices {

private Connection con = null;
	
private Statement statement = null;

private String kullanici_adi = "root";
private String parola = "password";
private String db_ismi = "patika";


private String host = "localhost";

private int port = 3306;


public MusteriServices() throws SQLException {
	String url = "jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?useUnicode=true&characterEncoding=utf8";
	
	con = DriverManager.getConnection(url,kullanici_adi,parola);
	System.out.println("Bağlantı Başarılı");
}

public List<AracModel> aracListele(String sehir ) throws SQLException {
	List <AracModel> aracmod = new ArrayList<AracModel>();
	statement = con.createStatement();
	
	String sorgu = ("Select araba_model,gunluk_fiyat,arac_tip,date_bas,date_bit,sehir,isim from patika.Arabalar Inner Join patika.Firma On patika.Firma.id = patika.Arabalar.firma_id where sehir ="+"'"+sehir+"'");
	
	ResultSet rs = statement.executeQuery(sorgu);
	
	while(rs.next()) {
		AracModel aracmodel = new AracModel();
		aracmodel.setAraba_model(rs.getString("araba_model"));
		aracmodel.setGunluk_fiyat(rs.getInt("gunluk_fiyat"));
		aracmodel.setArac_tip(rs.getString("arac_tip"));
		aracmodel.setDate_bas(rs.getDate("date_bas"));
		aracmodel.setDate_bit(rs.getDate("date_bit"));
		aracmodel.setSehir(rs.getString("sehir"));
		aracmodel.setFirmaisim(rs.getString("isim"));
		aracmod.add(aracmodel);
	}
	return aracmod;
	
}

}
