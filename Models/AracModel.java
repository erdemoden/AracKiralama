package Patika.Models;

import java.util.Date;

public class AracModel {

	private String araba_model;
	private int gunluk_fiyat;
	private String arac_tip;
	private Date date_bas;
	private Date date_bit;
	private int id;
	private String sehir;
	private String firmaisim;
	private String musteriIsim;
	public AracModel(String araba_model, int gunluk_fiyat, String arac_tip, Date date_bas, Date date_bit) {
		super();
		this.araba_model = araba_model;
		this.gunluk_fiyat = gunluk_fiyat;
		this.arac_tip = arac_tip;
		this.date_bas = date_bas;
		this.date_bit = date_bit;
	}
	public AracModel() {
		
	}
	
	public AracModel(String araba_model, int gunluk_fiyat, String arac_tip, Date date_bas, Date date_bit, int id) {
		super();
		this.araba_model = araba_model;
		this.gunluk_fiyat = gunluk_fiyat;
		this.arac_tip = arac_tip;
		this.date_bas = date_bas;
		this.date_bit = date_bit;
		this.id = id;
	}
	
	
	public AracModel(Object object, Object object2, Object object3, Object object4, Object object5, Object object6,
			Object object7,Object object8) {
		super();
		this.araba_model = (String) object;
		this.gunluk_fiyat = (int) object2;
		this.arac_tip = (String) object3;
		this.date_bas = (Date) object4;
		this.date_bit = (Date) object5;
		this.id = (int) object6;
		this.sehir = (String) object7;
		this.firmaisim = (String) object8;
	}	
	public String getFirmaisim() {
		return firmaisim;
	}
	public void setFirmaisim(String firmaisim) {
		this.firmaisim = firmaisim;
	}
	public String getSehir() {
		return sehir;
	}
	public void setSehir(String sehir) {
		this.sehir = sehir;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAraba_model() {
		return araba_model;
	}
	public void setAraba_model(String araba_model) {
		this.araba_model = araba_model;
	}
	public int getGunluk_fiyat() {
		return gunluk_fiyat;
	}
	public void setGunluk_fiyat(int gunluk_fiyat) {
		this.gunluk_fiyat = gunluk_fiyat;
	}
	public String getArac_tip() {
		return arac_tip;
	}
	public void setArac_tip(String arac_tip) {
		this.arac_tip = arac_tip;
	}
	public Date getDate_bas() {
		return date_bas;
	}
	public void setDate_bas(Date date_bas) {
		this.date_bas = date_bas;
	}
	public Date getDate_bit() {
		return date_bit;
	}
	public void setDate_bit(Date date_bit) {
		this.date_bit = date_bit;
	}
	public String getMusteriIsim() {
		return musteriIsim;
	}
	public void setMusteriIsim(String musteriIsim) {
		this.musteriIsim = musteriIsim;
	}
	
	
}
