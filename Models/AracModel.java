package Patika.Models;

import java.util.Date;

public class AracModel {

	private String araba_model;
	private int gunluk_fiyat;
	private String arac_tip;
	private Date date_bas;
	private Date date_bit;
	private int id;
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
	
}
