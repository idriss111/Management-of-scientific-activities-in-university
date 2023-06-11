package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Metier.ProjetRecherche;
import Metier.Publication;

public class PublicationJDBC {
	
	// ajouter une publication
	
	public static void addPublication(Publication pub) {
		  Connection cnx=JDBC11.connect();	
			
			try {
				PreparedStatement ps= cnx.prepareStatement("INSERT INTO Publication(titre, abstractt, auteur, justificatif, date) VALUES(?,?,?,?,?)");
				ps.setString(1, pub.getTitre());
				ps.setString(2, pub.getAbstractt());
				ps.setString(3, pub.getAuteur());
				ps.setBlob(4,pub.getJustifacatif());
				ps.setDate(5, (Date) pub.getDate());
				ps.executeUpdate();
				ps.close();
				System.out.println("publication ajoutee!!");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
	  }

	// liste de publications
	  public static ArrayList<Publication> getPublications() {
		  String query="Select * from Publication";
		  ArrayList<Publication> publications=new ArrayList<Publication>();
		  try {
			 Statement stm=JDBC11.connect().createStatement();
			 ResultSet rs= stm.executeQuery(query);
			 while(rs.next()) {
				   int id=rs.getInt(1);
				   String titre=rs.getString(2);
				   String abstractt=rs.getString(3);
				   String auteur=rs.getString(4);
				   InputStream justif= rs.getBlob(5).getBinaryStream();
				   Date date=rs.getDate(6);
				   Publication pub=new Publication(id,titre,abstractt,auteur,justif,date);
				   publications.add(pub);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	  return publications;
	  }
	  
	  public static void deletePublication(String titre) {
		  Connection cnx=JDBC11.connect();	
			
			try {
				PreparedStatement ps= cnx.prepareStatement("delete from Publication where titre='"+titre+"'");
				ps.executeUpdate();
				ps.close();
				System.out.println("publication supprimee!!");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
	  }
	  
	  public static boolean verifierPub(String titre) {
			boolean existe=false;
			String titreexst="";
			String query ="select * from Publication where titre='"+titre+"'";
	  		try {
	  			Statement stm=JDBC11.connect().createStatement();
	  			ResultSet rs=stm.executeQuery(query);
	  			while(rs.next()) {
	  				titreexst=rs.getString(2);
	  				System.out.println("recup");
	  			}
	  			if (titre.equals(titreexst)) {
	  				existe=true;
	  				System.out.println("true");
	  			}
	  			
	  		} catch (SQLException e) {
	  			e.printStackTrace();
	  		}
			return existe;
		}

}
