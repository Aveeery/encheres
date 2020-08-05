package fr.eni.javaee.eniencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.javaee.eniencheres.BusinessException;
import fr.eni.javaee.eniencheres.bll.UtilisateurManager;
import fr.eni.javaee.eniencheres.bo.Utilisateur;


@WebServlet("/visiteProfil")
public class ServletVisiteProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String inputUser = new String(); 
		
		inputUser = request.getParameter("pseudo");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		
		try {
			
	
			Utilisateur utilisateur = utilisateurManager.afficherProfilUtilisateur(inputUser);
			
			
			request.setAttribute("pseudo", inputUser);
			request.setAttribute("nom", utilisateur.getNom());
			request.setAttribute("prenom", utilisateur.getPrenom());
			request.setAttribute("email", utilisateur.getEmail());
			request.setAttribute("telephone", utilisateur.getTelephone());
			request.setAttribute("rue", utilisateur.getRue());
			request.setAttribute("code_postal", utilisateur.getCpo());
			request.setAttribute("ville", utilisateur.getVille());
			request.setAttribute("credit", utilisateur.getCredit());
			
			
			
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/Profil.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);

	}

}
