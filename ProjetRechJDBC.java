package dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStream.*;
import java.sql.*;
import java.sql.Date;
import java.util.ArrayList;

import com.itextpdf.io.source.ByteArrayOutputStream;

import java.util.*;



import Metier.Chercheur;
import Metier.ProjetRecherche;

public class ProjetRechJDBC {
  public static void addProjet(ProjetRecherche prj) {
	  Connection cnx=JDBC11.connect();	
		
		try {
			PreparedStatement ps= cnx.prepareStatement("INSERT INTO ProjetRecherche(titre, description, budget, duree, Auteur, Attachement, category,date) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, prj.getTitre());
			ps.setString(2, prj.getDescription());
			ps.setInt(3, prj.getBudget());
			ps.setInt(4, prj.getDuree());
			ps.setString(5,prj.getAuteur());
			ps.setBlob(6,prj.getAttachement());
			ps.setString(7, prj.getCategory());
			ps.setDate(8, (Date) prj.getDate());
			ps.executeUpdate();
			ps.close();
			System.out.println("projet recherche ajoutee!!");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
  }
  
  public static ArrayList<ProjetRecherche> getProjects() {
	  String query="Select * from ProjetRecherche";
	  ArrayList<ProjetRecherche> projets=new ArrayList<ProjetRecherche>();
	  try {
		 Statement stm=JDBC11.connect().createStatement();
		 ResultSet rs= stm.executeQuery(query);
		 while(rs.next()) {
			   int id=rs.getInt(1);
			   String titre=rs.getString(2);
			   String description=rs.getString(3);
			   int budget=rs.getInt(4);
			   int duree=rs.getInt(5);
			   String auteur=rs.getString(6);
			//   InputStream attachement= rs.getBlob(7).getBinaryStream();
			   Blob blob = rs.getBlob(7);
			   
			   InputStream inputStream = blob.getBinaryStream();
			   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			   byte[] buffer = new byte[4096];
			   int bytesRead = -1;
			    
			   try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				   outputStream.write(buffer, 0, bytesRead);
				   }
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			    
			   byte[] imageBytes = outputStream.toByteArray();
			   String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			    
			   try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    
			   
			   
			   
			   String category=rs.getString(8);
			   Date date=rs.getDate(9);
			   ProjetRecherche pr=new ProjetRecherche(id,titre,description,budget,duree,auteur,inputStream,category,date,base64Image);
			 
			   projets.add(pr);
			   
		 }
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
  return projets;
  }
  
  public static void deleteProjet(String titre) {
	  Connection cnx=JDBC11.connect();	
		
		try {
			PreparedStatement ps= cnx.prepareStatement("delete from ProjetRecherche where titre='"+titre+"'");
			ps.executeUpdate();
			ps.close();
			System.out.println("projet supprimee!!");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
  }
  
  public static boolean verifierProjet(String titre) {
		boolean existe=false;
		String titreexst="";
		String query ="select * from ProjetRecherche where titre='"+titre+"'";
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  				titreexst=rs.getString(2);
  				System.out.println(titreexst);
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
  
  public static ArrayList<ProjetRecherche> searchProjects(String search){
	  String query="select * from  ProjetRecherche where titre like '%"+search+"%' or description like '%"+search+"%' or Auteur like '%"+search+"%'  or date like '%"+search+"%' or category like '%"+search+"%' ";
	  ArrayList<ProjetRecherche> projets=new ArrayList<ProjetRecherche>();
	  try {
	  Statement stm =JDBC11.connect().createStatement();
	  ResultSet rs=stm.executeQuery(query);
	  while(rs.next()){
	  int id=rs.getInt(1);
	  String titre=rs.getString(2);
	    String description=rs.getString(3);
	   int budget=rs.getInt(4);
	    int duree=rs.getInt(5);
	  String auteur=rs.getString(6);
	  Blob blob = rs.getBlob(7);
	   
	  InputStream inputStream = blob.getBinaryStream();
	   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	   byte[] buffer = new byte[4096];
	   int bytesRead = -1;
	    
	   try {
		while ((bytesRead = inputStream.read(buffer)) != -1) {
		   outputStream.write(buffer, 0, bytesRead);
		   }
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	    
	   byte[] imageBytes = outputStream.toByteArray();
	   String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	    
	   try {
		inputStream.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   try {
		outputStream.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   String category=rs.getString(8);
	  Date date=rs.getDate(9);
	   ProjetRecherche pr=new ProjetRecherche(id,titre,description,budget,duree,auteur,inputStream,category,date,base64Image);
	  			   projets.add(pr);}
	  } catch (SQLException e) {
	  		e.printStackTrace();
	  	}
	  
	  return projets;
  }
  
 // projets de recherche du chercheur pour le profil
  
  public static ArrayList<ProjetRecherche> getProjects(String utilisateur) {
	  String query="Select * from ProjetRecherche where Auteur='"+utilisateur+"'";
	  ArrayList<ProjetRecherche> projets=new ArrayList<ProjetRecherche>();
	  try {
		 Statement stm=JDBC11.connect().createStatement();
		 ResultSet rs= stm.executeQuery(query);
		 while(rs.next()) {
			   int id=rs.getInt(1);
			   String titre=rs.getString(2);
			   String description=rs.getString(3);
			   int budget=rs.getInt(4);
			   int duree=rs.getInt(5);
			   String auteur=rs.getString(6);
			//   InputStream attachement= rs.getBlob(7).getBinaryStream();
			   Blob blob = rs.getBlob(7);
			   
			   InputStream inputStream = blob.getBinaryStream();
			   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			   byte[] buffer = new byte[4096];
			   int bytesRead = -1;
			    
			   try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				   outputStream.write(buffer, 0, bytesRead);
				   }
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			    
			   byte[] imageBytes = outputStream.toByteArray();
			   String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			    
			   try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    
			   
			   
			   
			   String category=rs.getString(8);
			   Date date=rs.getDate(9);
			   ProjetRecherche pr=new ProjetRecherche(id,titre,description,budget,duree,auteur,inputStream,category,date,base64Image);
			 
			   projets.add(pr);
			   
		 }
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
  return projets;
  }
  
  
  public static ArrayList<ProjetRecherche> getProjectsByType(String catego) {
	  String query="Select * from ProjetRecherche where category='"+catego+"'";
	  ArrayList<ProjetRecherche> projets=new ArrayList<ProjetRecherche>();
	  try {
		 Statement stm=JDBC11.connect().createStatement();
		 ResultSet rs= stm.executeQuery(query);
		 while(rs.next()) {
			   int id=rs.getInt(1);
			   String titre=rs.getString(2);
			   String description=rs.getString(3);
			   int budget=rs.getInt(4);
			   int duree=rs.getInt(5);
			   String auteur=rs.getString(6);
			//   InputStream attachement= rs.getBlob(7).getBinaryStream();
			   Blob blob = rs.getBlob(7);
			   
			   InputStream inputStream = blob.getBinaryStream();
			   ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			   byte[] buffer = new byte[4096];
			   int bytesRead = -1;
			    
			   try {
				while ((bytesRead = inputStream.read(buffer)) != -1) {
				   outputStream.write(buffer, 0, bytesRead);
				   }
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			    
			   byte[] imageBytes = outputStream.toByteArray();
			   String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			    
			   try {
				inputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   try {
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    
			   
			   
			   
			   String category=rs.getString(8);
			   Date date=rs.getDate(9);
			   ProjetRecherche pr=new ProjetRecherche(id,titre,description,budget,duree,auteur,inputStream,category,date,base64Image);
			 
			   projets.add(pr);
			   
		 }
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
  return projets;
  }
  
  
}
