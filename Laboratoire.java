package Metier;

import java.util.ArrayList;

public class Laboratoire {
private int id_labo;
private String nom_labo;
private String chef_labo;
private ArrayList<Equipe>equipes;




public Laboratoire() {
	super();
}

public int getId_labo() {
	return id_labo;
}

public void setId_labo(int id_labo) {
	this.id_labo = id_labo;
}



public Laboratoire( String nom_labo, String chef_labo) {
	super();
	this.nom_labo = nom_labo;
	this.chef_labo = chef_labo;
}



public Laboratoire(String nom_labo, String chef_labo, ArrayList<Equipe> equipes) {
	super();
	this.nom_labo = nom_labo;
	this.chef_labo = chef_labo;
	this.equipes = equipes;
}



public String getNom_labo() {
	return nom_labo;
}
public void setNom_labo(String nom_labo) {
	this.nom_labo = nom_labo;
}
public String getChef_labo() {
	return chef_labo;
}
public void setChef_labo(String chef_labo) {
	this.chef_labo = chef_labo;
}
public ArrayList<Equipe> getEquipes() {
	return equipes;
}
public void setEquipes(ArrayList<Equipe> equipes) {
	this.equipes = equipes;
}


}
