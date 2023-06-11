package dao;

import java.sql.*;
import java.util.ArrayList;

import Metier.Chercheur;
import Metier.Equipe;

public class EquipeJDBC {
   
	public static void addEquipe(Equipe eq) {
		String query ="Insert into Equipe(nomEquipe,chefEquipe,nomLabo) values(?,?,?)";
			PreparedStatement ps;
			try {
				
				ps = JDBC11.connect().prepareStatement(query);
				ps.setString(1, eq.getNom_equipe());
				ps.setString(2, eq.getChefEquipe());
				ps.setString(3,eq.getNom_labo());
				ps.executeUpdate();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static Equipe getEquipe(String nom) {
		int cpt=0;
		String nomEquipe=null;
		String chef=null;
		String nomLabo=null;
      	String query ="Select * from Equipe where nomEquipe='"+nom+"'";
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  			nomEquipe=rs.getString(1);
  			chef=rs.getString(2);
  			 nomLabo=rs.getString(3);
  			}
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		
  		String [] chercheurs=new String[10] ;
  		String query1 ="Select * from Chercheur where nomEquipe='"+nom+"'";
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
            String	nomm=rs.getString(2);
  			String prenom=rs.getString(3);
  			chercheurs[cpt]=nomm;
  			cpt++;
  			}
  			} catch (SQLException e) {
  	  			e.printStackTrace();
  	  		}
  			
  		Equipe eq=new Equipe(nomEquipe,chef,chercheurs,nomLabo);
  		return eq;
      }
	
	public static void deleteEquipe(String nom) {
		String query ="delete from Equipe where nomEquipe='"+nom+"'";
		try {
			PreparedStatement ps =JDBC11.connect().prepareStatement(query);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	 
	public static boolean verifierEquipe(String nom) {
		boolean existe=false;
		String nomEquipe="";
		String query ="select * from Equipe where nomEquipe='"+nom+"'";
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  				nomEquipe=rs.getString(1);
  				System.out.println("recup");
  			}
  			if (nom.equals(nomEquipe)) {
  				existe=true;
  				System.out.println("true");
  			}
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
		return existe;
	}
	
	public static void UpdateEquipe(Equipe nvEqp,String nom){
		 try {
    		 PreparedStatement ps=JDBC11.connect().prepareStatement("Update  Equipe Set nomEquipe='"+nvEqp.getNom_equipe()+"', chefEquipe='"+nvEqp.getChefEquipe()+"', nomLabo='"+nvEqp.getNom_labo()+"' where nomEquipe='"+nom+"'") ;
    		 ps.executeUpdate();
    		 
    	 }catch(Exception e){
    		 e.printStackTrace();
    	 }
		
	}
	
	public static void UpdateEquipeLabo(String ancien ,String nouveau){
		 try {
   		 PreparedStatement ps=JDBC11.connect().prepareStatement("Update  Equipe Set nomEquipe='"+nouveau+"' where nomEquipe='"+ancien+"'") ;
   		 ps.executeUpdate();
   		 
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
		
	}
	
	//supprimer le labo d'une equipe quand on supprime le labo
	
	public static void deleteLaboDeEquipe(String nom) {
		   String query ="Update Equipe set nomLabo=null where nomLabo='"+nom+"'";
			
			try {
				PreparedStatement ps= JDBC11.connect().prepareStatement(query);
				 ps.executeUpdate();
				 System.out.println("delete labo d'equipe");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	
	
	public static ArrayList<Equipe> getEquipes() {
 		ArrayList<Equipe> equipes=new ArrayList<Equipe>();
 		String query="Select  * from Equipe " ;
	    Equipe eq=new Equipe();
		try {
			Statement stm=JDBC11.connect().createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				String nom_equipe=rs.getString(1);
				System.out.println(nom_equipe);
				String chef_equipe=rs.getString(2);
				System.out.println(chef_equipe);
				String nom_labo=rs.getString(3);
				System.out.println(nom_labo);
				
				
				eq=new Equipe(nom_equipe,chef_equipe,nom_labo);				
				equipes.add(eq);
				System.out.println("--------");
				System.out.println(eq);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return equipes;
	}
	
	public static ArrayList<Equipe> searchEquipe(String search){
		  String query="select * from  Chercheur where nomEquipe like '%"+search+"%' or chefEquipe like '%"+search+"%' or nomLabo like '%"+search+"%'";
		  ArrayList<Equipe> equipes=new ArrayList<Equipe>();
		  Equipe eq=new Equipe();
		  try {
		  Statement stm =JDBC11.connect().createStatement();
		  ResultSet rs=stm.executeQuery(query);
		  
		  while(rs.next()){
				String nomEquipe=rs.getString(1);
				String chefLabo=rs.getString(2);
				String nomLabo=rs.getString(3);
				eq=new Equipe(nomEquipe,chefLabo,nomLabo);				
				equipes.add(eq);				
			    equipes.add(eq);
		  
		  }
		  }catch(Exception e ) {
			  e.printStackTrace();
		  }
	return equipes;
	}
	 
	 
		
		
	}
	
	
	
	

