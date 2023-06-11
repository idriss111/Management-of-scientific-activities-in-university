package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Metier.Encadrement;
import Metier.Soutenance;

public class SoutenanceJDBC {
	public static void addSoutenance(Soutenance sout) {
		  Connection cnx=JDBC11.connect();	
			try {
				PreparedStatement ps= cnx.prepareStatement("INSERT INTO Soutenance(intitule, date, lieu, jury, justificatif) VALUES(?,?,?,?,?)");
				ps.setString(1,sout.getIntitule());
				ps.setString(2, sout.getDate());
				ps.setString(3,sout.getLieu());
				ps.setString(4,sout.getJury());
				ps.setBlob(5,sout.getJustificatif());
				ps.executeUpdate();
				ps.close();
				System.out.println("soutenance ajoutee!!");
			}
			catch (SQLException e) {
				 e.printStackTrace();
			}
	  }
}
