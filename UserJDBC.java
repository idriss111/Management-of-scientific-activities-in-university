package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Metier.User;





public class UserJDBC {
	public void test() {
	Connection cnx=JDBC11.connect();	
	}
	public static void saveUser(User user,int id_chercheur) { 
		 
		try {
			Connection cnx=JDBC11.connect();	
			PreparedStatement ps= cnx.prepareStatement("INSERT INTO User(username,password,profession,id_chercheur) VALUES(?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getPr());
			ps.setInt(4, id_chercheur);			
			ps.executeUpdate();
			ps.close();
			System.out.println("guut ");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	
	public static User updateUser(int id,User user) { 
		
		try{
			Connection cnx=JDBC11.connect();
			PreparedStatement ps= cnx.prepareStatement("UPDATE User SET username=?,password=? WHERE id=?");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3,user.getId());
            ps.executeUpdate();
			ps.close();
			System.out.println("guut");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
		return user;
	}
	
	public static void deleteUser(String username) { 
		
		try {
			Connection cnx=JDBC11.connect();
			PreparedStatement ps= cnx.prepareStatement("DELETE FROM User WHERE username= ?");
			ps.setString(1, username);
			ps.executeUpdate();
			ps.close();
			System.out.println("bien supp");
		}
		catch (SQLException e) {
			 e.printStackTrace();
		}
	}
	public static String[] getUser(String username,String password) {
		Connection cnx=JDBC11.connect();
		String requete = "Select username,pass,profession from User where username='"+username+"' And pass='"+password+"'";
		String[] user= {"","",""};
		try {
			cnx = JDBC11.connect();
		Statement stm = cnx.createStatement();
		ResultSet rs=stm.executeQuery(requete);
		
		while(rs.next()) {
			user[0]=rs.getString(1);
			user[1]=rs.getString(2);
			user[2]=rs.getString(3);
		}}
		catch(Exception e) {
			e.printStackTrace();  
		}
		return user;
		
	}
	public static boolean verifierInscription(String email, String nom) {
		
		
		boolean statut = false;
        
        try {
        	Connection cnx=JDBC11.connect();
        	PreparedStatement preparedStatement = cnx.prepareStatement("select * from Chercheur where email = ? and nom = ? "); 
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,nom);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()) {
            	System.out.println("email  : " + rs.getString("email"));
            	statut = true;
            }
        } 
         catch (Exception e) {
            e.getMessage();
        }
        System.out.println(statut);
        return statut;
	}
	public static boolean verifierUser(String username) {
		boolean existe=false;
		String nomUser="";
		String query ="select * from User where username='"+username+"'";
  		try {
  			Statement stm=JDBC11.connect().createStatement();
  			ResultSet rs=stm.executeQuery(query);
  			while(rs.next()) {
  				nomUser=rs.getString(2);
  				System.out.println("recup");
  			}
  			if (username.equals(nomUser)) {
  				existe=true;
  				System.out.println("true");
  			}
  			
  		} catch (SQLException e) {
  			e.printStackTrace();
  		}
		return existe;
	}
 
	
	
	
	
	public static void main(String[]args) {
	  UserJDBC usr=new UserJDBC();
	//  User user=new User("Asmae","asm",Profession.Doctorant);
	//  usr.saveUser(user);
  }
  
	
   
   
}
