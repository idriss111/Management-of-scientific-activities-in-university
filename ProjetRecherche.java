package Metier;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.http.HttpResponse;
import java.sql.Statement;
import java.sql.Date;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.sql.Blob;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.JDBC11;
public class ProjetRecherche {
	private int id_projet;
	private String titre;
	 private String description;
	 private int budget;
	 private int duree;
	 private String auteur;
	 private InputStream Attachement;
	 private String category;
	 private Date date ;
	 private String outputstream;
	 
	 public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	
	
	public ProjetRecherche(int id_projet, String titre, String description, int budget, int duree, String auteur,
			String category, Date date, String outputstream) {
		super();
		this.id_projet = id_projet;
		this.titre = titre;
		this.description = description;
		this.budget = budget;
		this.duree = duree;
		this.auteur = auteur;
		this.category = category;
		this.date = date;
		this.outputstream = outputstream;
	}

	public ProjetRecherche(int id_projet, String titre, String description, int budget, int duree, String auteur,
			String  outputstream, String category, Date date) {
		super();
		this.id_projet = id_projet;
		this.titre = titre;
		this.description = description;
		this.budget = budget;
		this.duree = duree;
		this.auteur = auteur;
		outputstream = outputstream;
		this.category = category;
		this.date = date;
	}
	public ProjetRecherche(int id_projet, String titre, String description, int budget, int duree, String auteur,
			InputStream attachement, String category, Date date) {
		super();
		this.id_projet = id_projet;
		this.titre = titre;
		this.description = description;
		this.budget = budget;
		this.duree = duree;
		this.auteur = auteur;
		Attachement = attachement;
		this.category = category;
		this.date = date;
	}
	
	
	public ProjetRecherche(int id_projet, String titre, String description, int budget, int duree, String auteur,
			InputStream attachement, String category, Date date,String outputstream) {
		super();
		this.id_projet = id_projet;
		this.titre = titre;
		this.description = description;
		this.budget = budget;
		this.duree = duree;
		this.auteur = auteur;
		Attachement = attachement;
		this.category = category;
		this.date = date;
		this.outputstream=outputstream;
	}

	public ProjetRecherche( String titre, String description, int budget, int duree, String auteur,
			InputStream attachement, String category, Date date) {
		super();
		this.titre = titre;
		this.description = description;
		this.budget = budget;
		this.duree = duree;
		this.auteur = auteur;
		Attachement = attachement;
		this.category = category;
		this.date = date;
	}

	public ProjetRecherche(String titre, String description, int budget, int duree, String auteur,
			InputStream attachement, String category) {
		super();
		this.titre = titre;
		this.description = description;
		this.budget = budget;
		this.duree = duree;
		this.auteur = auteur;
		Attachement = attachement;
		this.category = category;
	}

	public ProjetRecherche(int id,String titre, String description, int budget, int duree, String auteur,
			InputStream attachement, String category) {
		super();
		this.id_projet=id;
		this.titre = titre;
		this.description = description;
		this.budget = budget;
		this.duree = duree;
		this.auteur = auteur;
		Attachement = attachement;
		this.category = category;
	}
	
	
	public String getOutputstream() {
		return outputstream;
	}

	public void setOutputstream(String outputstream) {
		this.outputstream = outputstream;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public InputStream getAttachement() {
		return Attachement;
	}
	public void setAttachement(InputStream attachement) {
		Attachement = attachement;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//display blob to outputStream
	


	}
	
	 

