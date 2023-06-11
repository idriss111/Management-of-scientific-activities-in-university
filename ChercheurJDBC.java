package dao;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Metier.Chercheur;
import Metier.Equipe;
import Metier.ProjetRecherche;
import Servlets.Servlet11;
public class ChercheurJDBC {
   
	
	public static Chercheur getChercheur(int id_chercheur) {
		String query="Select  * from Chercheur where id="+id_chercheur;
	   Chercheur c=null;
		try {
			Statement stm=JDBC11.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt(1);
				String nom=rs.getString(2);
				String prenom=rs.getString(3);
				String email=rs.getString(4);
				String telephone=rs.getString(5);
				String profession=rs.getString(6);
				String activite_pedagogique=rs.getString(7);
				String responsabilite=rs.getString(8);
				 String photo= rs.getString(9);
				String nomeq=rs.getString(10);
				 c=new Chercheur(id,nom,prenom,email,telephone,profession,activite_pedagogique,responsabilite,photo,nomeq);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return c;
	}
     public static void deleteChercheur(int id) throws SQLException {
    	 PreparedStatement ps=JDBC11.connect().prepareStatement("delete from Chercheur where id="+id);
    	 ps.executeUpdate();
    	 System.out.println("supprime");
     }
     
     public static void updateChercheur(Chercheur c,int id ) {
    	 try {
    		 PreparedStatement ps=JDBC11.connect().prepareStatement("Update  Chercheur Set prenom='"+c.getPrenom()+"', nom='"+c.getNom()+"', email='"+c.getEmail()+"', telephone='"+c.getTelephone()+"', profession='"+c.getProfession()+"' where id="+id);
    		 ps.executeUpdate();
    		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
     }
     
 	public static ArrayList<Chercheur> getChercheursEns() {
 		ArrayList<Chercheur> chercheurEns=new ArrayList<Chercheur>();
 		String ens="Enseignant";
 		String query="Select  * from Chercheur where nomEquipe is null and  profession='"+ens+"'";
 		System.out.println(query);
	   Chercheur c=new Chercheur();
		try {
			Statement stm=JDBC11.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt(1);
				String nom=rs.getString(2);
				String prenom=rs.getString(3);
				String email=rs.getString(4);
				String telephone=rs.getString(5);
				String profession=rs.getString(6);
				String activite_pedagogique=rs.getString(7);
				String responsabilite=rs.getString(8);
				 String photo= rs.getString(9);
				String nomeq=rs.getString(10);
				c=new Chercheur(id,nom,prenom,email,telephone,profession,activite_pedagogique,responsabilite,photo,nomeq);				
				chercheurEns.add(c);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return chercheurEns;
	}
 	
 	public static ArrayList<Chercheur> getChercheursDoc() {
 		ArrayList<Chercheur> chercheurEns=new ArrayList<Chercheur>();
 		String ens="Doctorant";
 		String query="Select  * from Chercheur where  profession='Doctorant'";
	   Chercheur c=new Chercheur();
		try {
			Statement stm=JDBC11.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt(1);
				String nom=rs.getString(2);
				String prenom=rs.getString(3);
				String email=rs.getString(4);
				String telephone=rs.getString(5);
				String profession=rs.getString(6);
				String activite_pedagogique=rs.getString(7);
				String responsabilite=rs.getString(8);
				 String photo= rs.getString(9);
				String nomeq=rs.getString(10);
				c=new Chercheur(id,nom,prenom,email,telephone,profession,activite_pedagogique,responsabilite,photo,nomeq);				
				chercheurEns.add(c);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return chercheurEns;
	}
 	
 	
 	
 	
 	
 	
 	public static ArrayList<Chercheur> getChercheurs() {
 		ArrayList<Chercheur> chercheurs=new ArrayList<Chercheur>();
 		String query="Select  * from Chercheur " ;
	    Chercheur c=new Chercheur();
		try {
			Statement stm=JDBC11.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				int id=rs.getInt(1);
				System.out.println(id);
				String nom=rs.getString(2);
				System.out.println(nom);
				String prenom=rs.getString(3);
				System.out.println(prenom);
				String email=rs.getString(4);
				System.out.println(email);
				String telephone=rs.getString(5);
				System.out.println(telephone);
				String profession=rs.getString(6);
				System.out.println(profession);
				String activite_pedagogique=rs.getString(7);
				String responsabilite=rs.getString(8);
				 String photo= rs.getString(9);
				String nomEquipe=rs.getString(10);
				System.out.println(nomEquipe);
				
				c=new Chercheur(id,nom,prenom,email,telephone,profession,activite_pedagogique,responsabilite,photo,nomEquipe);				
				chercheurs.add(c);
				System.out.println("--------");
				System.out.println(c);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return chercheurs;
	}
 	public static  ArrayList<Chercheur> getChercheursSansEq() {
		// TODO Auto-generated method stub
		ArrayList<Chercheur> chercheursSansEq=new ArrayList<Chercheur>();
		try {
			PreparedStatement ps= JDBC11.connect().prepareStatement("select * from chercheur where nomEquipe is null ");
			ResultSet rs = ps.executeQuery();
			Chercheur c =new Chercheur();
			while (rs.next()) {
				int id=rs.getInt(1);
				String nom=rs.getString(2);
				String prenom=rs.getString(3);
				String email=rs.getString(4);
				String telephone=rs.getString(5);
				String profession=rs.getString(6);
				String activite_pedagogique=rs.getString(7);
				String responsabilite=rs.getString(8);
				String photo=rs.getString(9);
				String nomeq=rs.getString(10);
				c=new Chercheur(id,nom,prenom,email,telephone,profession,activite_pedagogique,responsabilite,photo,nomeq);				
				chercheursSansEq.add(c);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return chercheursSansEq;
	}
 	
 	//ajouter le nom d'equipe
 	
 	public static void AddNomEquipe(Equipe eq,int id) {
 		String query ="Update Chercheur set nomEquipe='"+eq.getNom_equipe()+"' where id+="+id ;
 		
		try {
			PreparedStatement ps= JDBC11.connect().prepareStatement("Update Chercheur set nomEquipe='"+eq.getNom_equipe()+"' where id="+id);
			 ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
 	}
 	
 	//supprimer le nom d'equipe
 	
   public static void deleteEquipe(String nom) {
	   String query ="Update Chercheur set nomEquipe=null where nomEquipe='"+nom+"'";
		
		try {
			PreparedStatement ps= JDBC11.connect().prepareStatement(query);
			 ps.executeUpdate();
			 System.out.println("mseh equipe");
		} catch (SQLException e) {
			e.printStackTrace();
		}
   }
		//les chercheurs du meme equipe
  public static ArrayList<Chercheur> getChercheursMmEquipe(String nom) {
			
			ArrayList<Chercheur> chercheursMmeqp=new ArrayList<Chercheur>();
			try {
				PreparedStatement ps= JDBC11.connect().prepareStatement("select * from Chercheur where nomEquipe='"+nom+"'");
				ResultSet rs = ps.executeQuery();
				Chercheur c =new Chercheur();
				while (rs.next()) {
					int id=rs.getInt(1);
					String nomm=rs.getString(2);
					String prenom=rs.getString(3);
					String email=rs.getString(4);
					String telephone=rs.getString(5);
					String profession=rs.getString(6);
					String activite_pedagogique=rs.getString(7);
					String responsabilite=rs.getString(8);
					String photo=rs.getString(9);
					String nomeq=rs.getString(10);
					c=new Chercheur(id,nomm,prenom,email,telephone,profession,activite_pedagogique,responsabilite,photo,nomeq);				
					chercheursMmeqp.add(c);
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return chercheursMmeqp;
		}
  
	public static boolean verifierChercheur(String firstname) {
		boolean existe=false;
		String nomChercheur="";
		String query ="select * from Chercheur where firstname='"+firstname+"'";
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  				nomChercheur=rs.getString(3);
  				System.out.println("recup");
  			}
  			if (firstname.equals(nomChercheur)) {
  				existe=true;
  				System.out.println("true");
  			}
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
		return existe;
	}
	
	
	public static ArrayList<Chercheur> searchChercheurs(String search){
		  String query="select * from  Chercheur where nom like '%"+search+"%' or prenom like '%"+search+"%' or profession like '%"+search+"%'  or email like '%"+search+"%' or telephone like '%"+search+"%' or nomEquipe like '%"+search+"%' or responsabilite like '%"+search+"%'";
		  ArrayList<Chercheur> chercheurs=new ArrayList<Chercheur>();
		  Chercheur c=new Chercheur();
		  try {
		  Statement stm =JDBC11.connect().createStatement();
		  ResultSet rs=stm.executeQuery(query);
		  
		  while(rs.next()){
			  int id=rs.getInt(1);
				String nomm=rs.getString(2);
				String prenom=rs.getString(3);
				String email=rs.getString(4);
				String telephone=rs.getString(5);
				String profession=rs.getString(6);
				String activite_pedagogique=rs.getString(7);
				String responsabilite=rs.getString(8);
				String photo=rs.getString(9);
				String nomeq=rs.getString(10);
				c=new Chercheur(id,nomm,prenom,email,telephone,profession,activite_pedagogique,responsabilite,photo,nomeq);				
				chercheurs.add(c);				
			chercheurs.add(c);
		  
		  }
		  }catch(Exception e ) {
			  e.printStackTrace();
		  }
	return chercheurs;
	}
}
