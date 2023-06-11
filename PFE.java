package Metier;

import java.io.InputStream;
import java.sql.Date;

public class PFE {
 private int id_PFE;
 private String intitule;
 private String lieu;
 private Date date;
 private String[] jury;
 private InputStream justifacatif;
 private String category;
 
 
 
 
 public PFE(String intitule, String lieu, Date date, InputStream justifacatif, String category) {
	super();
	this.intitule = intitule;
	this.lieu = lieu;
	this.date = date;
	this.justifacatif = justifacatif;
	this.category = category;
}
public PFE(int id_PFE, String intitule, String lieu, Date date, InputStream justifacatif, String category) {
	super();
	this.id_PFE = id_PFE;
	this.intitule = intitule;
	this.lieu = lieu;
	this.date = date;
	this.justifacatif = justifacatif;
	this.category = category;
}
public PFE(int id_PFE, String intitule, String lieu, Date date, String[] jury, InputStream justifacatif,
		String category) {
	super();
	this.id_PFE = id_PFE;
	this.intitule = intitule;
	this.lieu = lieu;
	this.date = date;
	this.jury = jury;
	this.justifacatif = justifacatif;
	this.category = category;
}
public int getId_PFE() {
	return id_PFE;
}
public void setId_PFE(int id_PFE) {
	this.id_PFE = id_PFE;
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
 
 
 
 
}
