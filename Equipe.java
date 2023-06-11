package Metier;

import java.util.ArrayList;
import java.util.Arrays;

public class Equipe {

private String nom_equipe;
private String chefEquipe;
private String[] chercheurs;
private String nom_labo;


public Equipe() {
	super();
}


public Equipe(String nom_equipe, String chefEquipe, String nom_labo) {
	super();
	this.nom_equipe = nom_equipe;
	this.chefEquipe = chefEquipe;
	this.nom_labo = nom_labo;
}


public Equipe(String nom_equipe, String chefEquipe, String[] chercheurs, String nom_labo) {
	super();
	this.nom_equipe = nom_equipe;
	this.chefEquipe = chefEquipe;
	this.chercheurs = chercheurs;
	this.nom_labo = nom_labo;
}
	

public String getNom_equipe() {
	return nom_equipe;
}
public void setNom_equipe(String nom_equipe) {
	this.nom_equipe = nom_equipe;
}
public String getChefEquipe() {
	return chefEquipe;
}
public void setChefEquipe(String chefEquipe) {
	this.chefEquipe = chefEquipe;
}
public String[] getChercheurs() {
	return chercheurs;
}
public void setChercheurs(String[] chercheurs) {
	this.chercheurs = chercheurs;
}
public String getNom_labo() {
	return nom_labo;
}
public void setNom_labo(String nom_labo) {
	this.nom_labo = nom_labo;
}


@Override
public String toString() {
	return "Equipe [nom_equipe=" + nom_equipe + ", chefEquipe=" + chefEquipe + ", chercheurs="
			+ Arrays.toString(chercheurs) + ", nom_labo=" + nom_labo + "]";
}


}
