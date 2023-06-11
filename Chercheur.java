package Metier;

import java.io.InputStream;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;

public class Chercheur implements Serializable{
	private String username;
	private int id_chercheur;
	private String nom;
	private String prenom;
	private String email;
	
	private String telephone;
	private String activite_pedagogique;
	private String responsabilite;
	private String photo;
	private InputStream justificatif;
	private String profession;
	private ArrayList<Activite> activite_sc; 
	private int Id_equipe;
	private Instant dateJoined;
	private String nomEquipe;
	
	

	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public Instant getDateJoined() {
		return dateJoined;
	}
	public void setDateJoined(Instant dateJoined) {
		this.dateJoined = dateJoined;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Chercheur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chercheur(int id_chercheur, String nom, String prenom, String email,  String telephone,
			String profession, String activite_pedagogique, String responsabilite, String photo,String nomEquipe
			) {
		super();
		this.id_chercheur = id_chercheur;
		this.nom = nom;
		this.prenom = prenom; 
		this.email = email;
		this.telephone = telephone;
		this.profession=profession;
		this.activite_pedagogique = activite_pedagogique;
		this.responsabilite = responsabilite;
		this.photo = photo;
		this.justificatif = justificatif;
		this.activite_sc = activite_sc;
		this.Id_equipe = Id_equipe;
		this.nomEquipe=nomEquipe;
	}
	
	
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getId_chercheur() {
		return id_chercheur;
	}
	public void setId_chercheur(int id_chercheur) {
		this.id_chercheur = id_chercheur;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getActivite_pedagogique() {
		return activite_pedagogique;
	}
	public void setActivite_pedagogique(String activite_pedagogique) {
		this.activite_pedagogique = activite_pedagogique;
	}
	public String getResponsabilite() {
		return responsabilite;
	}
	public void setResponsabilite(String responsabilite) {
		this.responsabilite = responsabilite;
	}

	public String getUsername() {
		return nom+"."+prenom;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public InputStream getJustificatif() {
		return justificatif;
	}
	public void setJustificatif(InputStream justificatif) {
		this.justificatif = justificatif;
	}
	public ArrayList<Activite> getActivite_sc() {
		return activite_sc;
	}
	public void setActivite_sc(ArrayList<Activite> activite_sc) {
		this.activite_sc = activite_sc;
	}
	public int getId_equipe() {
		return Id_equipe;
	}
	public void setId_equipe(int id_equipe) {
		Id_equipe = id_equipe;
	}
	@Override
	public String toString() {
		return "Chercheur [username=" + username + ", id_chercheur=" + id_chercheur + ", nom=" + nom + ", prenom="
				+ prenom + ", email=" + email + ", telephone=" + telephone + ", activite_pedagogique="
				+ activite_pedagogique + ", responsabilite=" + responsabilite + ", photo=" + photo + ", justificatif="
				+ justificatif + ", profession=" + profession + ", activite_sc=" + activite_sc + ", Id_equipe="
				+ Id_equipe + ", dateJoined=" + dateJoined + ", nomEquipe=" + nomEquipe + "]";
	}
	
	
	
	
	
	
	
}
