package Metier;

import java.io.InputStream;

import java.sql.Date;

public class Soutenance {
private int id_soutenance;
private String intitule;
private String date ;
private String lieu;
private String jury;
private InputStream justificatif;






public Soutenance(int id_soutenance, String intitule, String date, String lieu, String jury, InputStream justificatif) {
	super();
	this.id_soutenance = id_soutenance;
	this.intitule = intitule;
	this.date = date;
	this.lieu = lieu;
	this.jury = jury;
	this.justificatif = justificatif;
}
public Soutenance(String intitule, String date, String lieu, String jury, InputStream justificatif) {
	super();
	this.intitule = intitule;
	this.date = date;
	this.lieu = lieu;
	this.jury = jury;
	this.justificatif = justificatif;
}
public String getIntitule() {
	return intitule;
}
public void setIntitule(String intitule) {
	this.intitule = intitule;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getLieu() {
	return lieu;
}
public void setLieu(String lieu) {
	this.lieu = lieu;
}
public String getJury() {
	return jury;
}
public void setJury(String jury) {
	this.jury = jury;
}
public InputStream getJustificatif() {
	return justificatif;
}
public void setJustificatif(InputStream justificatif) {
	this.justificatif = justificatif;
}





}
