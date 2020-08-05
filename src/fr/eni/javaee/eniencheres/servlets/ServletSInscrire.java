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


/**
 * Servlet implementation class ServletSInscrire
 */
@WebServlet("/Sinscrire")
public class ServletSInscrire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSInscrire() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/sinscrire.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
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
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/sinscrire.jsp");
			rd.forward(request, response);
		} else {
		
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
			utilisateurManager.insererUtilisateurBDD(utilisateur);
			
			HttpSession session = request.getSession();
			
			session.setAttribute("pseudo", utilisateur.getPseudo());
			session.setAttribute("connected", true);
		} catch (BusinessException e) {
			
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecte.jsp");
		rd.forward(request, response);
		}
		
	}	

}
