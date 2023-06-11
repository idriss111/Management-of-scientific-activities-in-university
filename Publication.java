package Metier;

import java.io.InputStream;

import java.sql.Date;

public class Publication {
  private int id_projet;
  private String titre;
  private String abstractt;
  private String auteur;
  private InputStream justifacatif;
  private Date date;
   

  

public Publication(String titre, String abstractt, String auteur, InputStream justifacatif, Date date) {
	super();
	this.titre = titre;
	this.abstractt = abstractt;
	this.auteur = auteur;
	this.justifacatif = justifacatif;
	this.date = date;
}

public Publication(int id_projet, String titre, String abstractt, String auteur, InputStream justifacatif, Date date) {
	super();
	this.id_projet = id_projet;
	this.titre = titre;
	this.abstractt = abstractt;
	this.auteur = auteur;
	this.justifacatif = justifacatif;
	this.date = date;
}

public String getAuteur() {
	return auteur;
}

public void setAuteur(String auteur) {
	this.auteur = auteur;
}

public int getId_projet() {
	return id_projet;
}

public void setId_projet(int id_projet) {
	this.id_projet = id_projet;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getAbstractt() {
	return abstractt;
}

public void setAbstractt(String abstractt) {
	this.abstractt = abstractt;
}

public InputStream getJustifacatif() {
	return justifacatif;
}

public void setJustifacatif(InputStream justifacatif) {
	this.justifacatif = justifacatif;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}
	
	
}
