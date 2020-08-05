package fr.eni.javaee.eniencheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.eniencheres.BusinessException;
import fr.eni.javaee.eniencheres.bll.UtilisateurManager;
import fr.eni.javaee.eniencheres.bo.Utilisateur;


@WebServlet("/modifierProfil")
public class ServletModifierProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierMonProfil.jsp");
		rd.forward(request, response);
		
	}

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			BusinessException businessException = new BusinessException();
			
			try {
				utilisateurManager.passwordVerif(request.getParameter("password"),request.getParameter("passwordVerif"), businessException);
				utilisateurManager.pseudoVerif(request.getParameter("pseudo"), businessException);
				utilisateurManager.emailVerif(request.getParameter("email"), businessException);
			} catch (BusinessException e2) {
				e2.printStackTrace();
			}
			
			if(businessException.getListeCodesErreur().size()>0)
			{	
				request.setAttribute("listeCodesErreur",businessException.getListeCodesErreur());
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/modifierMonProfil.jsp");
				rd.forward(request, response);
			} else {
			String pseudoUser = new String();

			HttpSession session = request.getSession();
			pseudoUser = (String)session.getAttribute("pseudo");
			
			try {Utilisateur utilisateur = new Utilisateur(
					
						request.getParameter("pseudo"),
						request.getParameter("nom"),
						request.getParameter("prenom"),
						request.getParameter("email"),
						request.getParameter("telephone"),
						request.getParameter("rue"),
						request.getParameter("codepostal"),
						request.getParameter("ville"),			
						request.getParameter("password"),
						0,
						0
				);
			
			utilisateurManager.updateProfil(utilisateur, pseudoUser);
			session.setAttribute("pseudo", utilisateur.getPseudo());
			
			} catch (BusinessException e) {
				
				e.printStackTrace();
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecte.jsp");
			rd.forward(request, response);
			
			}	
		}
		
	}


