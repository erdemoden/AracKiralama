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
	
	String sorgu = ("Select patika.Arabalar.id,araba_model,gunluk_fiyat,arac_tip,patika.Arabalar.date_bas,patika.Arabalar.date_bit,sehir,isim from patika.Arabalar Inner Join patika.Firma On patika.Firma.id = patika.Arabalar.firma_id Left Join patika.Randevu On patika.Randevu.araba_id = patika.Arabalar.id where patika.Randevu.id IS NULL and sehir ="+"'"+sehir+"'");
	
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
		aracmodel.setId(rs.getInt("id"));
		aracmod.add(aracmodel);
	}
	return aracmod;
	
}
public void RandevuAl(AracModel aracModel,String musteriisim) throws SQLException {
	statement = con.createStatement();
	int musteriId = 0;
	String sorgu = ("Select id as musteriid from Musteri where isim = "+"'"+musteriisim+"'");
	ResultSet rs = statement.executeQuery(sorgu);
	
	while(rs.next()) {
		musteriId = Integer.parseInt(rs.getString("musteriid"));
		
	}
	
	String sorgu2 = ("Insert Into Randevu (date_bas,musteri_id,araba_id,date_bit) VALUES("+"'"+aracModel.getDate_bas()+"'"+","+"'"+musteriId+"'"+","+"'"+aracModel.getId()+"'"+","+"'"+aracModel.getDate_bit()+"'"+")");
	
	statement.executeUpdate(sorgu2);
}

public List<AracModel> randevuListele(String musteriisim) throws SQLException {
	List <AracModel> aracmod = new ArrayList<AracModel>();
	statement = con.createStatement();
	int musteriId = 0;
	String sorgu = ("Select id as musteriid from Musteri where isim = "+"'"+musteriisim+"'");
	ResultSet rs = statement.executeQuery(sorgu);
	
	while(rs.next()) {
		musteriId = Integer.parseInt(rs.getString("musteriid"));
		
	}
	String sorgu2 = ("Select patika.Randevu.id,araba_model,gunluk_fiyat,sehir,patika.Randevu.date_bas,patika.Randevu.date_bit from patika.Musteri Inner Join patika.Randevu On patika.Musteri.id = patika.Randevu.musteri_id Inner Join patika.Arabalar On patika.Randevu.araba_id = patika.Arabalar.id Inner Join patika.Firma On patika.Arabalar.firma_id = patika.Firma.id");

	ResultSet rs2 = statement.executeQuery(sorgu2);
	
	while(rs2.next()) {
		AracModel aracmodel = new AracModel();
		aracmodel.setId(rs2.getInt("id"));
		aracmodel.setAraba_model(rs2.getString("araba_model"));
		aracmodel.setGunluk_fiyat(rs2.getInt("gunluk_fiyat"));
		aracmodel.setSehir(rs2.getString("sehir"));
		aracmodel.setDate_bas(rs2.getDate("date_bas"));
		aracmodel.setDate_bit(rs2.getDate("date_bit"));
		aracmod.add(aracmodel);
	}
	return aracmod;

}
}
