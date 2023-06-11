package Metier;

import java.io.InputStream;
import java.sql.Date;

public class These {
	 private int id_These;
	 private String intitule;
	 private String lieu;
	 private Date date;
	 private String[] jury;
	 private InputStream justifacatif;
	 private String category;
	
	 
	 
	 public These(String intitule, String lieu, Date date, InputStream justifacatif, String category) {
		super();
		this.intitule = intitule;
		this.lieu = lieu;
		this.date = date;
		this.justifacatif = justifacatif;
		this.category = category;
	}
	public These(String intitule, String lieu, Date date, String[] jury, InputStream justifacatif, String category) {
		super();
		this.intitule = intitule;
		this.lieu = lieu;
		this.date = date;
		this.jury = jury;
		this.justifacatif = justifacatif;
		this.category = category;
	}
	public These(int id_These, String intitule, String lieu, Date date, String[] jury, InputStream justifacatif,
			String category) {
		super();
		this.id_These = id_These;
		this.intitule = intitule;
		this.lieu = lieu;
		this.date = date;
		this.jury = jury;
		this.justifacatif = justifacatif;
		this.category = category;
	}
	public int getId_These() {
		return id_These;
	}
	public void setId_These(int id_These) {
		this.id_These = id_These;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String[] getJury() {
		return jury;
	}
	public void setJury(String[] jury) {
		this.jury = jury;
	}
	public InputStream getJustifacatif() {
		return justifacatif;
	}
	public void setJustifacatif(InputStream justifacatif) {
		this.justifacatif = justifacatif;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	 
	 
	 
	 
}
