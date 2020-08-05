package fr.eni.javaee.eniencheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.javaee.eniencheres.BusinessException;
import fr.eni.javaee.eniencheres.bll.ArticleManager;
import fr.eni.javaee.eniencheres.bo.Article;
import fr.eni.javaee.eniencheres.bo.Filtre;

/**
 * Servlet implementation class ServletAccueil
 */
@WebServlet("/Accueil")
public class ServletAccueil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ArticleManager articleManager = new ArticleManager();
			List<Article> listeArticles = null; 
			Filtre filtre = new Filtre(); 
			HttpSession session = request.getSession();
			String pseudoUser = (String)session.getAttribute("pseudo");
			
			listeArticles = articleManager.selectionnerArticles(filtre, pseudoUser); 
			request.setAttribute("listeArticles", listeArticles);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
			rd.forward(request, response);
		
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Filtre filtre = new Filtre(); 
		ArticleManager articleManager = new ArticleManager();
		List<Article> listeArticles = null; 
		HttpSession session = request.getSession();
		
		
		filtre.setIdCategorie(Integer.parseInt(request.getParameter("idCategorie")));
		filtre.setMotCle(request.getParameter("motCle"));
		filtre.setEncheresOuvertes(Boolean.parseBoolean(request.getParameter("encheresouvertes")));
		filtre.setMesAchatsEnCours(Boolean.parseBoolean(request.getParameter("achatsencours")));
		filtre.setMesAchatsRemportes(Boolean.parseBoolean(request.getParameter("achatsremportes")));
		filtre.setMesVentesEnCours(Boolean.parseBoolean(request.getParameter("ventesencours")));
		filtre.setVentesNonDebutees(Boolean.parseBoolean(request.getParameter("ventesnondebutees")));
		filtre.setVentesTerminees(Boolean.parseBoolean(request.getParameter("ventesterminees")));
		String pseudoUser = (String)session.getAttribute("pseudo");
		
		try {
			listeArticles = articleManager.selectionnerArticles(filtre, pseudoUser);
			
			
			if(listeArticles.isEmpty()) {
				String erreur = "Rien à afficher"; 
				request.setAttribute("erreur", erreur);
			}
			else {
				request.setAttribute("listeArticles", listeArticles);
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
			rd.forward(request, response);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
