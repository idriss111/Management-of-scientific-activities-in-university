package dao;

import java.io.FileInputStream;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Activite;
import Metier.Chercheur;

public class RegisterJDBC {
	public void test() {
	Connection cnx=JDBC11.connect();	
	}
	/* InputStream photoo =new FileInputStream("/Users/macbookpro/Downloads/vecteezy_professor-teaching-in-the-classroom-concept__590/vecteezy_professor-teaching-in-the-classroom-concept_.jpg");
	 Chercheur cher1=new Chercheur(4,"El Qoraychy", "Idriss", "idf123@gmail.com", "qwerty","0612345678",
			Profession.Doctorant, "Chef de xxx", "chef de filliere", photoo);*/
		public static void saveRegistration(Chercheur chercheur) {		
			Connection cnx=JDBC11.connect();	
			
			try {
				PreparedStatement ps= cnx.prepareStatement("INSERT INTO Chercheur(nom,prenom,email,telephone,profession,photo) VALUES(?,?,?,?,?,?)");
				ps.setString(1, chercheur.getNom());
				ps.setString(2, chercheur.getPrenom());
				ps.setString(3, chercheur.getEmail());
				ps.setString(5, chercheur.getProfession());
				ps.setString(4,chercheur.getTelephone());
				ps.setString(6,chercheur.getPhoto());
				ps.executeUpdate();
				ps.close();
				System.out.println("valide");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
		}
			
			
			
			
			
			
			
			
			
			
			
		}
	
	
	

