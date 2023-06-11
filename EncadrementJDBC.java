package dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Metier.Chercheur;
import Metier.Encadrement;
import Metier.Publication;

public class EncadrementJDBC {

	public static void addEncadrement(Encadrement encd) {
		  Connection cnx=JDBC11.connect();	
			
			try {
				PreparedStatement ps= cnx.prepareStatement("INSERT INTO Encadrement(intitule, niveau, type, Encadrant, Encadre, justificatif) VALUES(?,?,?,?,?,?)");
				ps.setString(1,encd.getIntitule());
				ps.setString(2,encd.getNiveau());
				ps.setString(3, encd.getType_Encadrement());
				ps.setString(4,encd.getEncadrant());
				ps.setString(5,encd.getEncadré());
				ps.setBlob(6,encd.getJustifacatif());
				ps.executeUpdate();
				ps.close();
				System.out.println("encadrement ajoutee!!");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
	  }
	public static ArrayList<Encadrement> getEncadrement(String nom) {
		System.out.println(nom);
		ArrayList<Encadrement> Encadrement=new ArrayList<Encadrement>();
		try {
			PreparedStatement ps= JDBC11.connect().prepareStatement("select * from Encadrement where Encadrant='"+nom+"'");
			ResultSet rs = ps.executeQuery();
			Encadrement enc = new Encadrement();
			while (rs.next()) {
				int id=rs.getInt(1);
				String intitule=rs.getString(2);
				System.out.println(intitule);
				String niveau=rs.getString(3);
				System.out.println(niveau);
				String type_Encadrement=rs.getString(4);
				String encadrant=rs.getString(5);
				String encadré=rs.getString(6);
				enc=new Encadrement(intitule, niveau,type_Encadrement,null, encadrant,
						 encadré);				
				Encadrement.add(enc);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("succes getting encads");
		return Encadrement;
		
	}
	
	
	
	public static ArrayList<Encadrement> getEncadrement() {
		System.out.println();
		ArrayList<Encadrement> Encadrement=new ArrayList<Encadrement>();
		try {
			PreparedStatement ps= JDBC11.connect().prepareStatement("select * from Encadrement ");
			ResultSet rs = ps.executeQuery();
			Encadrement enc = new Encadrement();
			while (rs.next()) {
				int id=rs.getInt(1);
				String intitule=rs.getString(2);
				System.out.println(intitule);
				String niveau=rs.getString(3);
				System.out.println(niveau);
				String type_Encadrement=rs.getString(4);
				String encadrant=rs.getString(5);
				String encadré=rs.getString(6);
				enc=new Encadrement(intitule, niveau,type_Encadrement,null, encadrant,
						 encadré);				
				Encadrement.add(enc);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		System.out.println("succes getting encads");
		return Encadrement;
		
	}
	
	
	
}
