package Metier;

import java.io.InputStream;

public class Encadrement {
 private int id_Encadrement;
 private String intitule;
 private String niveau;
 private String type_Encadrement;
 private InputStream justifacatif;
 private String Encadrant;
 private String Encadré;
 
 
 
 public Encadrement() {
	super();
}
public String getEncadrant() {
	return Encadrant;
}
public void setEncadrant(String encadrant) {
	Encadrant = encadrant;
}
public String getEncadré() {
	return Encadré;
}
public void setEncadré(String encadré) {
	Encadré = encadré;
}



public Encadrement(String intitule, String niveau, String type_Encadrement, InputStream justifacatif, String encadrant,
		String encadré) {
	super();
	this.intitule = intitule;
	this.niveau = niveau;
	this.type_Encadrement = type_Encadrement;
	this.justifacatif = justifacatif;
	Encadrant = encadrant;
	Encadré = encadré;
}
public Encadrement(int id_Encadrement, String intitule, String niveau, String type_Encadrement,
		InputStream justifacatif, String encadrant, String encadré) {
	super();
	this.id_Encadrement = id_Encadrement;
	this.intitule = intitule;
	this.niveau = niveau;
	this.type_Encadrement = type_Encadrement;
	this.justifacatif = justifacatif;
	Encadrant = encadrant;
	Encadré = encadré;
}
public int getId_Encadrement() {
	return id_Encadrement;
}
public void setId_Encadrement(int id_Encadrement) {
	this.id_Encadrement = id_Encadrement;
}
public String getIntitule() {
	return intitule;
}
public void setIntitule(String intitule) {
	this.intitule = intitule;
}
public String getNiveau() {
	return niveau;
}
public void setNiveau(String niveau) {
	this.niveau = niveau;
}
public String getType_Encadrement() {
	return type_Encadrement;
}
public void setType_Encadrement(String type_Encadrement) {
	this.type_Encadrement = type_Encadrement;
}
public InputStream getJustifacatif() {
	return justifacatif;
}
public void setJustifacatif(InputStream justifacatif) {
	this.justifacatif = justifacatif;
}
 
 
}
