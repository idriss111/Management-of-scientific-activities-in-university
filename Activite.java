package Metier;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Date;

import com.mysql.cj.jdbc.Blob;

public class Activite implements Serializable{
private int id_activite;
private String titre;
private Date date;
private String budget;
private String description;
private String duree;
private Blob piece;
private InputStream justificatif;
private String auteur;
private int id_chercheur;

public Activite(int id_activite, String titre, Date date, String budget, String description, String duree, Blob piece,
		InputStream justificatif, String auteur, int id_chercheur) {
	super();
	this.id_activite = id_activite;
	this.titre = titre;
	this.date = date;
	this.budget = budget;
	this.description = description;
	this.duree = duree;
	this.piece = piece;
	this.justificatif = justificatif;
	this.auteur = auteur;
	this.id_chercheur = id_chercheur;
}
public int getId_activite() {
	return id_activite;
}
public void setId_activite(int id_activite) {
	this.id_activite = id_activite;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public String getBudget() {
	return budget;
}
public void setBudget(String budget) {
	this.budget = budget;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDuree() {
	return duree;
}
public void setDuree(String duree) {
	this.duree = duree;
}
public Blob getPiece() {
	return piece;
}
public void setPiece(Blob piece) {
	this.piece = piece;
}
public InputStream getJustificatif() {
	return justificatif;
}
public void setJustificatif(InputStream justificatif) {
	this.justificatif = justificatif;
}
public String getAuteur() {
	return auteur;
}
public void setAuteur(String auteur) {
	this.auteur = auteur;
}
public int getId_chercheur() {
	return id_chercheur;
}
public void setId_chercheur(int id_chercheur) {
	this.id_chercheur = id_chercheur;
}
@Override
public String toString() {
	return "Activite [id_activite=" + id_activite + ", titre=" + titre + ", date=" + date + ", budget=" + budget
			+ ", description=" + description + ", duree=" + duree + ", piece=" + piece + ", justificatif="
			+ justificatif + ", auteur=" + auteur + ", id_chercheur=" + id_chercheur + "]";
}


}