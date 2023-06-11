package dao;
import java.sql.*;

import Metier.User;

public class JDBC11 {
	private static Connection connection;
	
		static String url="jdbc:mysql://localhost:3306/Activites?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		static String user="root";
		static String password="idriss2001";
		
		
	
	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url,user,password);
			System.out.println("connexion établie !!!");
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}	
		return connection;
	}
	
	
	public static User getUser(String username,String password) {
		Connection cnx=JDBC11.connect();
		String requete = "Select username,password,profession,id_chercheur from User where username='"+username+"' And password='"+password+"'";
		User user=new User();
		try {
			cnx = JDBC11.connect();
		Statement stm = cnx.createStatement();
		ResultSet rs=stm.executeQuery(requete);
		System.out.print(" query :"+requete);
		while(rs.next()) {
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			user.setPr(rs.getString(3));
			user.setid_chercheur(rs.getInt(4));
			System.out.print(" username  :"+rs.getString(1));
			System.out.print(" password  :"+rs.getString(2));
			System.out.print(" profe  :"+rs.getString(3));
			System.out.print(" id :"+rs.getInt(4));
		}
		System.out.print(" ---------- :"+user.getPassword());
		
		return user;
		}
		catch(Exception e) {
			e.printStackTrace(); 
			return null;
		}
		
		
	}
	
	public static User getUser(String username) {
		Connection cnx=JDBC11.connect();
		String requete = "Select id_chercheur,profession from User where username='"+username+"'";
		User user=new User();
		try {
			cnx = JDBC11.connect();
		Statement stm = cnx.createStatement();
		ResultSet rs=stm.executeQuery(requete);
		System.out.print(" query :"+requete);
		while(rs.next()) {
			user.setUsername(username);
			user.setid_chercheur(rs.getInt(1));
			user.setPr(rs.getString(2));

		}
		
		
		return user;
		}catch(Exception e) {
			e.printStackTrace(); 
			return null;
		}}
	
	
	
}
