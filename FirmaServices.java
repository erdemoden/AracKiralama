package Patika;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Patika.Models.AracModel;

public class FirmaServices {

	private String kullanici_adi = "root";
	private String parola = "password";
	private String db_ismi = "patika";
	
	
	private String host = "localhost";
	
	private int port = 3306;
	
	private Connection con = null;
	
	private Statement statement = null;
	
	
	public FirmaServices() throws SQLException {
		String url = "jdbc:mysql://"+host+":"+port+"/"+db_ismi+"?useUnicode=true&characterEncoding=utf8";
		
		con = DriverManager.getConnection(url,kullanici_adi,parola);
		System.out.println("Bağlantı Başarılı");
		
		}
	
	public void aracEkle(String firmaisim,AracModel aracModel) throws SQLException {
		final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		statement = con.createStatement();
		int firmaid = 0;
		String sorgu = ("Select id as firmaid from Firma where isim = "+"'"+firmaisim+"'");
		ResultSet rs = statement.executeQuery(sorgu);
		while(rs.next()) {
			firmaid = Integer.parseInt(rs.getString("firmaid"));
		}
		String sorgu2 = ("Insert into Arabalar (araba_model,gunluk_fiyat,arac_tip,date_bas,date_bit,firma_id) VALUES("+"'"+aracModel.getAraba_model()+"'"+","+"'"+aracModel.getGunluk_fiyat()+"'"+","+"'"+aracModel.getArac_tip()+"'"+","+"'"+formatter.format(aracModel.getDate_bas())+"'"+","+"'"+formatter.format(aracModel.getDate_bit())+"'"+","+"'"+firmaid+"'"+")");
		statement.executeUpdate(sorgu2);
	}
	
	public List<AracModel> aracGetir(String firmaisim) throws SQLException {
		List <AracModel> aracmod = new ArrayList<AracModel>();
		statement = con.createStatement();
		int firmaid = 0;
		String sorgu = ("Select id as firmaid from Firma where isim = "+"'"+firmaisim+"'");
		ResultSet rs = statement.executeQuery(sorgu);
		
		while(rs.next()) {
			firmaid = Integer.parseInt(rs.getString("firmaid"));
			
		}
		
		String sorgu2 = ("Select araba_model,gunluk_fiyat,arac_tip,date_bas,date_bit,id from Arabalar where firma_id = "+"'"+firmaid+"'");
		
		ResultSet rs2 = statement.executeQuery(sorgu2);
		
		while(rs2.next()) {
			AracModel aracmodel = new AracModel();
			aracmodel.setAraba_model(rs2.getString("araba_model"));
			aracmodel.setGunluk_fiyat(rs2.getInt("gunluk_fiyat"));
			aracmodel.setArac_tip(rs2.getString("arac_tip"));
			aracmodel.setDate_bas(rs2.getDate("date_bas"));
			aracmodel.setDate_bit(rs2.getDate("date_bit"));
			aracmodel.setId(rs2.getInt("id"));
			aracmod.add(aracmodel);
		}
		for (AracModel aracModel : aracmod) {
			System.out.println(aracModel.getAraba_model());
		}
		System.out.println(firmaid);
		return aracmod;
		
	}
	
	public void deleteSelectedCar(Object object) throws SQLException {
		statement = con.createStatement();
		
		String sorgu = ("Delete from Arabalar where id = "+"'"+object+"'");
		
		statement.executeUpdate(sorgu);
	}
}
