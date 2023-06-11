package dao;

import java.sql.*;
import java.util.ArrayList;

import Metier.Equipe;
import Metier.Laboratoire;

public class LaboratoireJDBC {
      public static ArrayList<Laboratoire> getLabos()  {
    	  ArrayList<Laboratoire>labos=new ArrayList<Laboratoire>();
    	  String query ="Select * from Laboratoire";
    	 try { Statement stm=JDBC11.connect().createStatement();	  
    	  ResultSet rs =stm.executeQuery(query);
    	 while(rs.next()) { 
    	  
    	  String nom_labo=rs.getString(1);
    	  String chef_labo=rs.getString(2);
    	  Laboratoire labo =new Laboratoire(nom_labo,chef_labo);
    	  labos.add(labo);
    	  }
    	 }catch(SQLException e){
 			e.printStackTrace();
 		}
     return labos;
      }
      
      public static Laboratoire getLabo(String nom) { 
      	String chef=null;
      	String query ="Select chefLabo from Laboratoire where nomLabo="+nom;
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  				chef=rs.getString("chefLabo");
  			}
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
  		Laboratoire labo =new Laboratoire(nom,chef);
  		return labo;
      }
      
      //verifier labo
      
  	public static boolean verifierLabo(String nom) {
		boolean existe=false;
		String nomLabo="";
		String query ="select * from Laboratoire where nomLabo='"+nom+"'";
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  				nomLabo=rs.getString(1);
  				System.out.println("recup");
  			}
  			if (nom.equals(nomLabo)) {
  				existe=true;
  				System.out.println("true");
  			}
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
		return existe;
	}
  	
  	//update labo
  	
	public static void UpdateLabo(Laboratoire nvlabo,String nom){
		 try {
   		 PreparedStatement ps=JDBC11.connect().prepareStatement("Update  Equipe Set nomLabo='"+nvlabo.getNom_labo()+"', chefLabo='"+nvlabo.getChef_labo()+"' where nomLabo='"+nom+"'") ;
   		 ps.executeUpdate();
   		 
   	 }catch(Exception e){
   		 e.printStackTrace();
   	 }
	}	
		 //add labo
	
		 public static void addLabo(Laboratoire labo) {
				String query ="Insert into Laboratoire(nomLabo,chefLabo) values(?,?)";
					PreparedStatement ps;
					try {
						ps = JDBC11.connect().prepareStatement(query);
						ps.setString(1, labo.getNom_labo());
						ps.setString(2, labo.getChef_labo());
						ps.executeUpdate();
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
		         
			} 
	
         //delete labo
		 
		 
			public static void deleteLabo(String nom) {
				String query ="delete from Laboratoire where nomLabo='"+nom+"'";
				try {
					PreparedStatement ps =JDBC11.connect().prepareStatement(query);
					ps.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// lister labos
			
			public static ArrayList<Laboratoire> getEquipes() {
		 		ArrayList<Laboratoire> labos=new ArrayList<Laboratoire>();
		 		String query="Select  * from Laboratoire " ;
			    Laboratoire labo=new Laboratoire();
				try {
					Statement stm=JDBC11.connect().createStatement();
					ResultSet rs=stm.executeQuery(query);
					while(rs.next()) {
						String nom_labo=rs.getString(1);
						System.out.println(nom_labo);
						String chef_labo=rs.getString(2);
						System.out.println(chef_labo);
						
						
						labo=new Laboratoire(nom_labo,chef_labo);				
						labos.add(labo);
						System.out.println("--------");
						System.out.println(labo);
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			return labos;
			}
			
			
			
}
	
	
      
      

