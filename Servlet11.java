package Servlets;

import java.io.IOException;





import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.util.*;
import java.util.List;
import java.time.Instant;


import Metier.Chercheur;
import Metier.Encadrement;
import Metier.Equipe;
import Metier.Laboratoire;
import Metier.ProjetPDF;
import Metier.ProjetRecherche;
import Metier.Publication;
import Metier.Soutenance;
import Metier.User;
import dao.ChercheurJDBC;
import dao.EncadrementJDBC;
import dao.EquipeJDBC;
import dao.JDBC11;
import dao.LaboratoireJDBC;
import dao.ProjetRechJDBC;
import dao.PublicationJDBC;
import dao.RegisterJDBC;
import dao.SoutenanceJDBC;
import dao.UserJDBC;
import com.lowagie.text.*;
import com.itextpdf.*;
import com.lowagie.*;


@WebServlet({"/login","/register","/Admin","/ajouterChercheur","/modifierChercheur","/supprimerChercheur","/listeChercheurs",
	"/ajouterEquipe","/supprimerEquipe","/modifierEquipe","/listeEquipes","/listeLaboratoires","/ajouterLaboratoire","/supprimerLaboratoire",
	"/ajouterProjet","/supprimerProjet","/ajouterPublication","/Mathematiques","/Chimie","/Biomedical","/Engineering","/Physics",
	"/supprimerPublication","/searchProjects","/searchChercheurs","/searchEquipes","/PFE&THESE","/Projets","/pdfProjet","/encadrer","/soutenance","/profil","/logout"})
@MultipartConfig(maxFileSize=100000000)
public class Servlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 static String error = null;
	 
	RegisterJDBC registerJDBC;
     
    public Servlet11() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getServletPath().equals("/login")) {
			request.getRequestDispatcher("/log.jsp").forward(request, response);
			doPost(request,response);
		}	
		
		else if(request.getServletPath().equals("/register")) {
			this.getServletContext().getRequestDispatcher("/reg.jsp").forward(request, response);
			}
		
		  else if(request.getServletPath().equals("/ajouterChercheur")) {
			  doPost(request,response);
			}
		 
		  else if(request.getServletPath().equals("/supprimerChercheur")) {
			  doPost(request,response);
		  }
		  else if (request.getServletPath().equals("/modifierChercheur")) {
			  doPost(request,response);
		  }
		  else if (request.getServletPath().equals("/Admin")) {
			  this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
			  doPost(request,response);
			  }
		  else if (request.getServletPath().equals("/listeChercheurs")) {
			  doPost(request,response);
		  }
		  else if (request.getServletPath().equals("/ajouterEquipe")) {
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/supprimerEquipe")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/modifierEquipe")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/listeEquipes")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/listeLaboratoires")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/ajouterLaboratoire")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/supprimerLaboratoire")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/ajouterProjet")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/supprimerProjet")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/ajouterPublication")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/supprimerPublication")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/Mathematiques")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/Engineering")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/Physics")){
			  doPost(request,response);
		  }
		
		  else if(request.getServletPath().equals("/Chimie")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/Biomedical")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/PFE&THESE")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/Projets")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/searchProjects")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/searchChercheurs")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/searchEquipes")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/pdfProjet")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/encadrer")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/soutenance")){
			  doPost(request,response);
		  }
		  else if(request.getServletPath().equals("/profil")){
			  doPost(request,response);
		  }
		  else if (request.getServletPath().equals("/logout")) {
			doPost(request, response);}
		
	}
	
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getServletPath());
		
		if (request.getServletPath().equals("/login")) {
			
     try {
			request.setAttribute("error", "OK");

				String username = request.getParameter("username");
				String pass = request.getParameter("password");
				System.out.println("username :" + username);
				System.out.println("pass :" + pass);
				
				User user = JDBC11.getUser(username, pass);
				PrintWriter out = response.getWriter();
	
				if(user.getPassword()==null) {
					System.out.println("non");
					error= "username ou password incorrectes";	
					request.setAttribute("error", error);
					request.getRequestDispatcher("log.jsp").forward(request, response);
				}
				    //creer session
				else {
					HttpSession session= request.getSession();
					System.out.println("created ");
					//--------------------------
					Chercheur c1=ChercheurJDBC.getChercheur(user.getId_chercheur());
					//--------------------------
					System.out.println( c1.getPrenom());
					session.setAttribute("name","user");
					session.setAttribute("username", user.getUsername());
					session.setAttribute("firstname", c1.getPrenom());
					session.setAttribute("lastname", c1.getNom());
					session.setAttribute("password", user.getPassword());
					session.setAttribute("profession", user.getPr());
					session.setAttribute("telephone", c1.getTelephone());
					session.setAttribute("email", c1.getEmail());
					session.setAttribute("id", user.getId_chercheur());
					session.setAttribute("equipe", c1.getNomEquipe());
					System.out.print("------------"+user.getPr());
					
						request.getRequestDispatcher("/Projets").forward(request, response);
					
					}}catch(Exception e) {

						e.printStackTrace();
					}
		}
		else if(request.getServletPath().equals("/register")) {
			 

			String email=request.getParameter("email");
			String nom=request.getParameter("lastname");
			try {
				if(UserJDBC.verifierInscription(email, nom)){ 
					request.setAttribute("error","ce compte paraît qu'il existe déja");
					request.getRequestDispatcher("/register").forward(request, response);

				}
				
				else {
					System.out.println("1");
					String prenom=request.getParameter("firstname");
					String pass=request.getParameter("password");
					String telephone=request.getParameter("phone");
					System.out.println("2");
					String photo=request.getParameter("photo");
					System.out.println("photo :"+photo);
					response.getWriter().print("The file uploaded sucessfully.");
					String profession=request.getParameter("profession");
					System.out.println(pass);
					System.out.println(telephone);
					System.out.println("-------");
					Chercheur addC = new Chercheur();	
					addC.setNom(nom);
					addC.setPrenom(prenom);
					addC.setEmail(email);
					addC.setProfession(profession);
					addC.setTelephone(telephone);
					addC.setPhoto(photo);
					addC.setDateJoined(Instant.now());
					addC.setActivite_pedagogique("");
					addC.setResponsabilite("");
					
					RegisterJDBC.saveRegistration(addC);
					Statement stm=JDBC11.connect().createStatement();
					String query = "select id from Chercheur where email='"+email+"'";
					ResultSet rs=stm.executeQuery(query);
					System.out.println(query);
					System.out.println(rs);
				    int id_ch = -1;
					while(rs.next()) {
				    	 id_ch=rs.getInt(1);
				    	 System.out.println("id : "+id_ch);
					}
					
					User u = new User(prenom+'.'+nom, pass, profession,id_ch);
					UserJDBC.saveUser(u,id_ch);				
					Servlet11.error = "Votre nom d'utilisateur :"+u.getUsername();	
					request.setAttribute("error","Votre nom d'utilisateur :"+u.getUsername());
					System.out.println("yap register");
					
                      response.sendRedirect("log.jsp");
					//request.getRequestDispatcher("/login").forward(request, response);


				}
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (ServletException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		
			}
		
		//ajouter chercheur
		
		else if(request.getServletPath().equals("/ajouterChercheur")) {
			HttpSession session =request.getSession();
			String name=(String) session.getAttribute("name");
			//System.out.println("---___----______"+name);
			
			if(name==null) {
				request.setAttribute("source", "ajouterChercheur");
				this.getServletContext().getRequestDispatcher("/Admin").forward(request, response);
			}
			else if(name.equals("admin"))
				 this.getServletContext().getRequestDispatcher("/AdminFolder/add-professor.jsp").forward(request, response);
			System.out.println("0");
			String email=request.getParameter("email");
			String nom=request.getParameter("lastname");
			try {
				if(UserJDBC.verifierInscription(email, nom)){ 
					response.sendRedirect("deja_inscrit.jsp");}
				
				else {
					System.out.println("1");
					String prenom=request.getParameter("firstname");
					String pass=request.getParameter("password");
					String telephone=request.getParameter("phone");
					System.out.println("2");
					String photo=request.getParameter("photo");
					System.out.println("photo :" +photo);
					response.getWriter().print("The file uploaded sucessfully.");
					String profession=request.getParameter("profession");
					

					System.out.println(pass);
					System.out.println(telephone);
					System.out.println("-------");
					Chercheur addC = new Chercheur();	
					addC.setNom(nom);
					addC.setPrenom(prenom);
					addC.setEmail(email);
					//addC.setId_chercheur(id_ch);
					addC.setProfession(profession);
					addC.setTelephone(telephone);
					addC.setPhoto(photo);
					addC.setActivite_pedagogique("");
					addC.setResponsabilite("");
					
					RegisterJDBC.saveRegistration(addC);
					Statement stm=JDBC11.connect().createStatement();
					String query = "select id from Chercheur where email='"+email+"'";
					ResultSet rs=stm.executeQuery(query);
					System.out.println(query);
					System.out.println(rs);
				    int id_ch = -1;
					while(rs.next()) {
				    	 id_ch=rs.getInt(1);
				    	 System.out.println("id : "+id_ch);
					}
					
					User u = new User(prenom+'.'+nom, pass, profession,id_ch);
					UserJDBC.saveUser(u,id_ch);
					System.out.println("yap ajout cherch");


				}
			} catch (IOException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		
	}
		
		// supprimer chercheur 
		
		else if (request.getServletPath().equals("/supprimerChercheur")) {
			HttpSession session =request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println("---___----______"+name);
			if(name==null) {
				
				this.getServletContext().getRequestDispatcher("/Admin").forward(request, response);
			}
			else if(name.equals("admin")) {
				 String username =request.getParameter("username");
			 	if(username==null) {
			 		  this.getServletContext().getRequestDispatcher("/AdminFolder/delete-chercheur.jsp").forward(request, response);
			 	   }
			 	   else {
				 System.out.println("---___----______"+username);
				User usr= JDBC11.getUser(username);
				 System.out.println("---___----______"+usr.getId_chercheur());
				 				
				Chercheur c=	ChercheurJDBC.getChercheur(usr.getId_chercheur());
				request.setAttribute("c", c);
				request.setAttribute("u", usr);
				if (UserJDBC.verifierUser(username) ) {
	
				//suppression de User
				UserJDBC.deleteUser(username);
				//suppression de Cherch
				try {
					ChercheurJDBC.deleteChercheur(c.getId_chercheur());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("non errorr");
				request.getRequestDispatcher("AdminFolder/delete-chercheur.jsp").forward(request, response);
				}
				else {
					System.out.println("errorr");
					request.setAttribute("error", "chercheur non existant");
					request.getRequestDispatcher("AdminFolder/delete-chercheur.jsp").forward(request, response);
				}
				

			
				} }
			
			}
		
		//modifier chercheur
		
		else if(request.getServletPath().equals("/modifierChercheur")) {
		try {	HttpSession session =request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println("---___----______"+name);
			if(name==null) {
				
				this.getServletContext().getRequestDispatcher("/Admin").forward(request, response);
			}
			else if(name.equals("admin")) {
				 String username =request.getParameter("username");
				 String firstname=request.getParameter("firstname");
			 	if(username==null) {
			 		  this.getServletContext().getRequestDispatcher("/AdminFolder/edit-professor1.jsp").forward(request, response);
			 	   }
			 	   else {
				 System.out.println("---___----______"+username);
				User usr= JDBC11.getUser(username);
				 System.out.println("---___----______"+usr.getId_chercheur());
				 				
				Chercheur c=	ChercheurJDBC.getChercheur(usr.getId_chercheur());
				request.setAttribute("c", c);
				request.setAttribute("u", usr);
				if (UserJDBC.verifierUser(username) ) {
				this.getServletContext().getRequestDispatcher("/AdminFolder/edit-professor.jsp").forward(request, response);
			 		String lastname=request.getParameter("lastname");
			 		String telephone=request.getParameter("phone");
			 		String email=request.getParameter("email");
			 		String profession=request.getParameter("profession");
			 		//Chercheur c1=new Chercheur();
			 		c.setPrenom(firstname);
			 		c.setNom(lastname);
			 		c.setProfession(profession);
			 		c.setEmail(email);
			 		c.setTelephone(telephone);
			 		ChercheurJDBC.updateChercheur(c,Integer.parseInt(request.getParameter("id")));
			 		System.out.print("update reussie");
			 	
			 	}
				
					else {
						System.out.println("error");
						request.setAttribute("error","Chercheur non existant");
						this.getServletContext().getRequestDispatcher("/AdminFolder/edit-professor1.jsp").forward(request, response);

				}
			 	
			 	   }
				
				 
		}}catch(Exception e) {

			e.printStackTrace();
		}
		}	
		
		
		//logout
		
		else if(request.getServletPath().equals("/logout")) {
			System.out.println("invalidate");
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect("/Activites_Scientifiques");
		}
		
		//admin 
		
		else if(request.getServletPath().equals("/Admin")){
			
			System.out.println("admin pass");
			String password=request.getParameter("password");
			System.out.println(password);
			
			if(password.equals("admin000")){
				System.out.println(" hna");
				HttpSession session=request.getSession();
				session.setAttribute("name", "admin");
				System.out.println(session.getAttribute("name"));
				System.out.println("--"+request.getParameter("source")+"--");	
					request.getRequestDispatcher("/AdminFolder/index_admin.jsp").forward(request, response);}
			
			else {
				System.out.println("neiiiin");
				request.setAttribute("error", "Login as admin failed");
				  this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);

			}
		}
		
		
		// liste chercheur
		
		
		else if(request.getServletPath().equals("/listeChercheurs")) {
			 ArrayList <Chercheur> chercheurs=ChercheurJDBC.getChercheurs();
		     request.setAttribute("chercheurs", chercheurs);
		     System.out.println(chercheurs);
			HttpSession session =request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println("---___----______"+name);
			
			if(name==null) {
				request.setAttribute("source", "listeChercheurs");
				this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
			}
			else if(name.equals("admin")) {
		        request.getRequestDispatcher("/AdminFolder/all-professors.jsp").forward(request, response);
}
		}
		
		//lister les equipes
		
		else if(request.getServletPath().equals("/listeEquipes")) {
			 ArrayList <Equipe> equipes=EquipeJDBC.getEquipes();
		     request.setAttribute("equipes", equipes);
		     System.out.println(equipes);
			HttpSession session =request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println("---___----______"+name);
			
			if(name==null) {
				request.setAttribute("source", "listeEquipes");
				this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
			}
			else if(name.equals("admin")) {
		        request.getRequestDispatcher("/AdminFolder/all-equipes.jsp").forward(request, response);
}
		}
		
		else if(request.getServletPath().equals("/listeLaboratoires")) {
			 ArrayList <Laboratoire> laboratoires=LaboratoireJDBC.getLabos();
		     request.setAttribute("labos", laboratoires);
		     System.out.println(laboratoires);
			HttpSession session =request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println("---___----______"+name);
			
			if(name==null) {
				this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
			}
			else if(name.equals("admin")) {
		        request.getRequestDispatcher("/AdminFolder/all-laboratoires.jsp").forward(request, response);
}
		}
		
		//ajouter equipe et puis ajouter l'id de l'equipe au chercheur
		
		else if(request.getServletPath().equals("/ajouterEquipe")) {
		    int i=0;
		    
			ArrayList <Chercheur> chercheursEns=ChercheurJDBC.getChercheursEns();
			System.out.println("-----------");
			System.out.println("");
			request.setAttribute("chercheursEns", chercheursEns);
			ArrayList <Chercheur> chercheurs=ChercheurJDBC.getChercheursSansEq();
			request.setAttribute("chercheurs", chercheurs);
			ArrayList<Laboratoire>labos=LaboratoireJDBC.getLabos();
			request.setAttribute("labos", labos);
			HttpSession session =request.getSession();
			String name=(String) session.getAttribute("name");
			System.out.println("---___----______"+name);
			
			if(name==null) {
				request.setAttribute("source", "ajouterEquipe");
				this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
			}
			else if(name.equals("admin")) {
			
		    request.getRequestDispatcher("/AdminFolder/add-equipe.jsp").forward(request, response);
			String nom_equipe=request.getParameter("nomEquipe");
			String chef_equipe=request.getParameter("Chef_eq");
			String nom_labo=request.getParameter("nomLabo");
			String[] cherchs=request.getParameterValues("chercheurs");
			Equipe eq=new Equipe(nom_equipe,chef_equipe,cherchs,nom_labo);
			EquipeJDBC.addEquipe(eq);		
			if(cherchs !=null) {
				int[] numchers = new int[cherchs.length];
			for(i = 0;i < cherchs.length;i++)
			{
			   numchers[i] = Integer.parseInt(cherchs[i]);
			   System.out.println("boucle remp tab");
			   ChercheurJDBC.AddNomEquipe(eq,numchers[i]);
			   System.out.println("remplir cher par nomEq");
			}
}

		/*	while(i<numchers.length) {
				System.out.println(numchers[i]);
				
				System.out.println("remplir cher par nomEq");
				i++;
				} */}}
			else if(request.getServletPath().equals("/supprimerEquipe")) {
				HttpSession session =request.getSession();
				String name=(String) session.getAttribute("name");
				System.out.println("---___----______"+name);
				
				if(name==null) {
					
					this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
				}
				else if(name.equals("admin")) {
					String nomEquipe=request.getParameter("nomEquipe");
					if(nomEquipe==null) {
				this.getServletContext().getRequestDispatcher("/AdminFolder/delete-equipe.jsp").forward(request, response);}
					else {
				
						nomEquipe=request.getParameter("nomEquipe");
				System.out.println(nomEquipe);

					if(EquipeJDBC.verifierEquipe(nomEquipe)) {
						System.out.println("-------delete");
						//ChercheurJDBC.deleteEquipe(nomEquipe);
						//Update Chercheur set nomEquipe=null where nomEquipe=nomEquipe;
						ChercheurJDBC.deleteEquipe(nomEquipe);
						System.out.println("delete sur chercheur"+nomEquipe);
						EquipeJDBC.deleteEquipe(nomEquipe);
						System.out.println("delete sur equipe"+nomEquipe);
					}
					else {
						request.setAttribute("error", "equipe non existante");
						this.getServletContext().getRequestDispatcher("/AdminFolder/delete-equipe.jsp").forward(request, response);
					}
				} 
	}
			}

			
		
		
		//modifier Equipe
		
			else if(request.getServletPath().equals("/modifierEquipe")) {
				int i=0;
				HttpSession session =request.getSession();
				String name=(String) session.getAttribute("name");
				System.out.println("---___----______"+name);
				
				if(name==null) {
					request.setAttribute("source", "modifierEquipe");
					this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
				}
				else if(name.equals("admin")) {
					String nomEquipe=request.getParameter("nomEquipe");
					if(nomEquipe==null) {
				this.getServletContext().getRequestDispatcher("/AdminFolder/edit-equipe1.jsp").forward(request, response);}
					else {
				
						nomEquipe=request.getParameter("nomEquipe");
				System.out.println(nomEquipe);
				if (EquipeJDBC.verifierEquipe(nomEquipe)) {
				    Equipe eq=EquipeJDBC.getEquipe(nomEquipe);
				    request.setAttribute("eqp",eq );
				    ArrayList <Chercheur> chercheurs=ChercheurJDBC.getChercheursSansEq();
				    request.setAttribute("chercheurs",chercheurs );
				    ArrayList <Chercheur> chercheursEns=ChercheurJDBC.getChercheursEns();
				    request.setAttribute("chercheursEns",chercheursEns );
				    ArrayList<Laboratoire>labos=LaboratoireJDBC.getLabos();
				    request.setAttribute("labos",labos );
				    System.out.println(eq.toString());
					this.getServletContext().getRequestDispatcher("/AdminFolder/edit-equipe.jsp").forward(request, response);
					String nom_equipe=request.getParameter("nomEquipe");
					if(nom_equipe.length()<4) {request.setAttribute("erorr","Entrez un nom d'equipe valide !" ); }
					String chef_equipe=request.getParameter("Chef_eq");
					String nom_labo=request.getParameter("nomLabo");
					String[] cherchs=request.getParameterValues("chercheurs");
					Equipe nvEqp=new Equipe(nom_equipe,chef_equipe,cherchs,nom_labo);
					EquipeJDBC.UpdateEquipe(nvEqp, nomEquipe);
					if(cherchs !=null) {
						int[] numchers = new int[cherchs.length];
					for(i = 0;i < cherchs.length;i++)
					{
					   numchers[i] = Integer.parseInt(cherchs[i]);
					   System.out.println("boucle remp tab");
					   ChercheurJDBC.AddNomEquipe(nvEqp,numchers[i]);
					   System.out.println("remplir cher par nomEq");
					   
					}
		}
					
					
				}
				
					else {
					System.out.println("error");
					request.setAttribute("error","equipe non existant");
					this.getServletContext().getRequestDispatcher("/AdminFolder/edit-equipe1.jsp").forward(request, response);

				}
				}
				
	}

			}
	
			else if(request.getServletPath().equals("/ajouterProjet")) {
				this.getServletContext().getRequestDispatcher("/Add-ProjetRech.jsp").forward(request, response);
				HttpSession session=request.getSession();
				if(session.getAttribute("name").equals("user")) {
					String titre=request.getParameter("titre");
					System.out.println(titre);
					String description=request.getParameter("description");
					System.out.println(description);
					int budget=Integer.parseInt(request.getParameter("budget"));
					System.out.println(budget);
					int duree=Integer.parseInt(request.getParameter("duree"));
					System.out.println(duree);
					String Auteur=(String) session.getAttribute("username");
					System.out.println(Auteur);
					
						InputStream inputStream = null ;//input stream of uploaded file
					Part part = request.getPart("photo");
					if(part!=null){	
					System.out.println(part.getName());
					System.out.println(part.getSize());
					System.out.println(part.getContentType());
					inputStream = part.getInputStream();
					}
					String category=request.getParameter("category");
					Date date = new Date(System.currentTimeMillis());
					System.out.println(date);
				   ProjetRecherche prj =new ProjetRecherche(titre,description,budget,duree,Auteur,inputStream,category,date);
					System.out.println("ajout proj");
				    ProjetRechJDBC.addProjet(prj);
				    request.setAttribute("success", "Saved with success");
				    this.getServletContext().getRequestDispatcher("/Add-ProjetRech.jsp").forward(request, response);
				   
				    
				    System.out.println("ajout proj avec success");
					}
				else {
					this.getServletContext().getRequestDispatcher("404.jsp").forward(request, response);
				}
				}
		
	// liste de chercheurs projets 
		
		
			else if(request.getServletPath().equals("/Projets")) {
				
				HttpSession session=request.getSession();
				
				ArrayList<ProjetRecherche>projets=ProjetRechJDBC.getProjects();
				
			/*	Blob image = null;
				byte[ ] imgData = null ;
				try {
					String query="select attachement from ProjetRecherche ";
					Statement stm=JDBC.connect().createStatement();
					ResultSet rs=stm.executeQuery(query);
					List<String> images = new ArrayList<>();
					int i=0;
					while(i<projets.size()) {
					    imgData = ((Blob) projets.get(i).getAttachement()).getBytes(1,(int)image.length());
					    String base64Encoded = new String(Base64.getEncoder().encode(imgData), "UTF-8");
					    images.add(base64Encoded);
					    request.setAttribute("images", images);
					    i++;}
				}
					catch (SQLException e) {
					e.printStackTrace();
				}*/
				request.setAttribute("projets", projets);
				this.getServletContext().getRequestDispatcher("/BlogFolder/Blog.jsp").forward(request, response);
				
				}
		
			else if(request.getServletPath().equals("/ajouterPublication")) {
				HttpSession session=request.getSession();
				if(session.getAttribute("name").equals("user")) {
					this.getServletContext().getRequestDispatcher("/Add-pub.jsp").forward(request, response);
					String titre=request.getParameter("titre");
					System.out.println(titre);
					String abstractt=request.getParameter("abstract");
					System.out.println(abstractt);
					String Auteur=(String) session.getAttribute("username");
					System.out.println(Auteur);
					InputStream inputStream = null ;//input stream of uploaded file
					Part part = request.getPart("photo");
					if(part!=null){	
					System.out.println(part.getName());
					System.out.println(part.getSize());
					System.out.println(part.getContentType());
					inputStream = part.getInputStream();
					}
					Date date = new Date(System.currentTimeMillis());
					System.out.println(date);
					Publication pub=new Publication(titre,abstractt,Auteur,inputStream,date);
					PublicationJDBC.addPublication(pub);
					System.out.println("ajout publi avec success");
					}
				
					}
		
			else if(request.getServletPath().equals("/supprimerPublication")) {
				//jsp!!!
				
				this.getServletContext().getRequestDispatcher("/deletePub.jsp").forward(request, response);
				String titre =request.getParameter("titre");
				System.out.println(titre);
				if(PublicationJDBC.verifierPub(titre)) {
					PublicationJDBC.deletePublication(titre);
					System.out.println("supression succes");
				}
				else {
					request.setAttribute("existePas", "Publication non existante");
					System.out.println("non existant");
				}
			}
				
			else if(request.getServletPath().equals("/supprimerProjet")) {
					//
				//request.setAttribute("existePas", null);
				this.getServletContext().getRequestDispatcher("/deleteProj.jsp").forward(request, response);
					String titre =request.getParameter("titre");
					if(ProjetRechJDBC.verifierProjet(titre)) {
						ProjetRechJDBC.deleteProjet(titre);
						System.out.println("supression succes");

					}
					else {
						request.setAttribute("existePas", "Projet de recherche non existant");
						System.out.println("non existant");
					}
					
				
			}
			
		//recherche projet
			else if(request.getServletPath().equals("/searchProjects")) {
				String search=request.getParameter("search");
				System.out.println(search);
				ArrayList<ProjetRecherche> projets= ProjetRechJDBC.searchProjects(search);
				request.setAttribute("projets", projets);
				this.getServletContext().getRequestDispatcher("/BlogFolder/Blog.jsp").forward(request, response);
			}
		// recherche chercheur
		
			else if(request.getServletPath().equals("/searchChercheurs")) {
				String search=request.getParameter("search");
				System.out.println(search);
				ArrayList<Chercheur> chercheurs= ChercheurJDBC.searchChercheurs(search);
				request.setAttribute("chercheurs", chercheurs);
				this.getServletContext().getRequestDispatcher("/AdminFolder/all-professors.jsp").forward(request, response);
			}
		// recherche equipe
			else if(request.getServletPath().equals("/searchEquipes")) {
				String search=request.getParameter("search");
				System.out.println(search);
				ArrayList<Equipe> equipes=EquipeJDBC.searchEquipe(search);
				request.setAttribute("equipes", equipes);
				this.getServletContext().getRequestDispatcher("/AdminFolder/all-equipes.jsp").forward(request, response);
			}
		
		
		
		
			else if(request.getServletPath().equals("/pdfProjet")) {
				response.setContentType("application/pdf");
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
				String currentDateTime = dateFormatter.format(new java.util.Date());
				String headerKey = "Content-Disposition";
				String headerValue = "attachment; filename=liste " + currentDateTime + ".pdf";
				response.setHeader(headerKey, headerValue);
				ArrayList <ProjetRecherche> projets=ProjetRechJDBC.getProjects();
				ProjetPDF exporter = new ProjetPDF(projets);
				try {
					exporter.export(response);
				} catch (DocumentException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
               
			}
		
			else if(request.getServletPath().equals("/encadrer")) {
				HttpSession session=request.getSession();
				ArrayList<Chercheur> chercheurs=ChercheurJDBC.getChercheursDoc();
				request.setAttribute("chercheurs", chercheurs);
				this.getServletContext().getRequestDispatcher("/Encadrer.jsp").forward(request, response);
				String intitule=request.getParameter("intitule");
				System.out.println(intitule);
				String niveau=request.getParameter("niveau");
				System.out.println(niveau);
				String type=request.getParameter("type_encad");
				System.out.println(type);
				String encadrant=(String) session.getAttribute("lastname")+" "+ session.getAttribute("firstname");
				System.out.println(encadrant);
				String encadré=request.getParameter("encadre");
				System.out.println(encadré);
				InputStream inputStream = null ;//input stream of uploaded file
				Part part = request.getPart("justificatif");
				if(part!=null){	
				System.out.println(part.getName());
				System.out.println(part.getSize());
				System.out.println(part.getContentType());
				inputStream = part.getInputStream();
				}
				Encadrement encd=new Encadrement(intitule,niveau,type,inputStream,encadrant,
						encadré);
				EncadrementJDBC.addEncadrement(encd);
				System.out.println("encadrement ajoutee!!!");
			}
		
		
			else if(request.getServletPath().equals("/soutenance")) {
				HttpSession session =request.getSession();
				if(session.getAttribute("name").equals("user")) {
				this.getServletContext().getRequestDispatcher("/soutenance.jsp").forward(request, response);
				String intitule=request.getParameter("intitule");
				System.out.println(intitule);
				String lieu=request.getParameter("lieu");
				System.out.println(lieu);
				String[] dateSout = request.getParameterValues("dateSout");
				System.out.println(dateSout.toString());
				SimpleDateFormat availDate = new SimpleDateFormat("yyyy-MM-dd");
			      java.util.Date chosenDate=null;
			      String Date=null;
				try {
					chosenDate =  availDate.parse(dateSout[0]);
					System.out.println("Date:");
					System.out.println(chosenDate);
					 Date=chosenDate.toString();
					 System.out.println(Date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				String jury= session.getAttribute("lastname")+" "+ session.getAttribute("firstname");
				System.out.println(jury);
				InputStream inputStream = null ;//input stream of uploaded file
				Part part = request.getPart("justificatif");
				if(part!=null){	
				System.out.println(part.getName());
				System.out.println(part.getSize());
				System.out.println(part.getContentType());
				inputStream = part.getInputStream();
				}
				Soutenance sout= new Soutenance(intitule,Date, lieu,jury, inputStream); 
				SoutenanceJDBC.addSoutenance(sout);
				}}
		
			else if(request.getServletPath().equals("/profil")) {
				HttpSession session =request.getSession();
				if(session.getAttribute("name").equals("user")) {
				ArrayList<Chercheur> chercheurs=	ChercheurJDBC.getChercheursMmEquipe(""+session.getAttribute("equipe"));
				Equipe eqp=	EquipeJDBC.getEquipe(""+session.getAttribute("equipe"));
				System.out.println(eqp.getNom_labo());
				 session.setAttribute("chercheursMmEquipe", chercheurs);
				 session.setAttribute("equipeChercheur", eqp);
					System.out.println("L'equipe:  "+session.getAttribute("equipe"));
				ArrayList<ProjetRecherche>	projets=ProjetRechJDBC.getProjects(""+session.getAttribute("username"));
				session.setAttribute("projetsUtilisateur", projets);
				String nomPourEncad=session.getAttribute("lastname")+" "+session.getAttribute("firstname");
				System.out.println(nomPourEncad);
				ArrayList<Encadrement>	enc=EncadrementJDBC.getEncadrement(nomPourEncad);
				
				session.setAttribute("encadrements", enc);
					this.getServletContext().getRequestDispatcher("/profilee.jsp").forward(request, response);
					
					
					
					
				}
				
				
				
			}
		
			else if(request.getServletPath().equals("/PFE&THESE")) {
			    HttpSession session=request.getSession();
			//	String nomPourEncad=session.getAttribute("lastname")+" "+session.getAttribute("firstname");
                 ArrayList<Encadrement>	enc=EncadrementJDBC.getEncadrement();
				session.setAttribute("encadrements", enc);
				this.getServletContext().getRequestDispatcher("/pfe_these.jsp").forward(request, response);
			}
		
		// ajouter laboratoire

		
			else if(request.getServletPath().equals("/ajouterLaboratoire")) {
			    int i=0;
			    
				ArrayList <Chercheur> chercheursEns=ChercheurJDBC.getChercheursEns();
				System.out.println("-----------");
				System.out.println("");
				request.setAttribute("chercheursEns", chercheursEns);
				HttpSession session =request.getSession();
				String name=(String) session.getAttribute("name");
				System.out.println("---___----______"+name);
				
				if(name==null) {
					
					this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
				}
				else if(name.equals("admin")) {
			    request.getRequestDispatcher("/AdminFolder/add-laboratoire.jsp").forward(request, response);
				String nom_labo=request.getParameter("nomLabo");
				String chef_labo=request.getParameter("Chef_labo");
				Laboratoire labo =new Laboratoire(nom_labo,chef_labo);
				LaboratoireJDBC.addLabo(labo);
				System.out.println("labo ajoutee avec succeess");
				
				}}
			else if(request.getServletPath().equals("/supprimerLaboratoire")) {

				HttpSession session =request.getSession();
				String name=(String) session.getAttribute("name");
				System.out.println("---___----______"+name);
				
				if(name==null) {
					this.getServletContext().getRequestDispatcher("/Admin.jsp").forward(request, response);
				}
				else if(name.equals("admin")) {
					String nomLabo=request.getParameter("nomLabo");
					if(nomLabo==null) {
				this.getServletContext().getRequestDispatcher("/AdminFolder/delete-laboratoire.jsp").forward(request, response);}
					else {
				
						nomLabo=request.getParameter("nomLabo");
				System.out.println(nomLabo);

					if(LaboratoireJDBC.verifierLabo(nomLabo)) {
						System.out.println("-------delete");
                        
						System.out.println("-------delete labo de equipe");
						EquipeJDBC.deleteLaboDeEquipe(nomLabo);
						System.out.println("-------delete labo");
						LaboratoireJDBC.deleteLabo(nomLabo);
						System.out.println("delete sur labo"+nomLabo);
						this.getServletContext().getRequestDispatcher("/AdminFolder/delete-laboratoire.jsp").forward(request, response);}

					
					else {
						request.setAttribute("error", "Laboratoire non existant");
						this.getServletContext().getRequestDispatcher("/AdminFolder/delete-laboratoire.jsp").forward(request, response);
					}
				} 
				
				}}
				
			else if(request.getServletPath().equals("/Mathematiques")) {
				String category ="Mathematics";
			ArrayList<ProjetRecherche> projects	=ProjetRechJDBC.getProjectsByType(category);
			request.setAttribute("projets", projects);
			this.getServletContext().getRequestDispatcher("/BlogFolder/Blog.jsp").forward(request, response);
			
			}
			else if(request.getServletPath().equals("/Chimie")) {
				String category ="Chemistry";
			ArrayList<ProjetRecherche> projects	=ProjetRechJDBC.getProjectsByType(category);
			request.setAttribute("projets", projects);
			this.getServletContext().getRequestDispatcher("/BlogFolder/Blog.jsp").forward(request, response);
			
			}
			else if(request.getServletPath().equals("/Biomedical")) {
				String category ="Biomedical";
			ArrayList<ProjetRecherche> projects	=ProjetRechJDBC.getProjectsByType(category);
			request.setAttribute("projets", projects);
			this.getServletContext().getRequestDispatcher("/BlogFolder/Blog.jsp").forward(request, response);
			
			}
			else if(request.getServletPath().equals("/Engineering")) {
				String category ="Engineering";
			ArrayList<ProjetRecherche> projects	=ProjetRechJDBC.getProjectsByType(category);
			request.setAttribute("projets", projects);
			this.getServletContext().getRequestDispatcher("/BlogFolder/Blog.jsp").forward(request, response);
			
			}
			else if(request.getServletPath().equals("/Physics")) {
				String category ="Physics";
			ArrayList<ProjetRecherche> projects	=ProjetRechJDBC.getProjectsByType(category);
			request.setAttribute("projets", projects);
			this.getServletContext().getRequestDispatcher("/BlogFolder/Blog.jsp").forward(request, response);
			
			}
				
				
				
			
		
				
				
			
				
				
			
				
		
				
				
			
		
		
		
			
			
			
			
			
			
			
			
			
					
	}	
	}
	
	
		
	


