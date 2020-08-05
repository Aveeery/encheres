package  fr.eni.javaee.eniencheres.servlets;

import  fr.eni.javaee.eniencheres.BusinessException;
import  fr.eni.javaee.eniencheres.bll.ArticleManager;
import  fr.eni.javaee.eniencheres.bo.Article;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/vendreArticle")
public class ServletVendreArticle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/VendreArticle.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArticleManager articleManager = new ArticleManager();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        BusinessException businessException = new BusinessException();


        try {

            Article article = new Article(
                    request.getParameter("nomArticle"),
                    request.getParameter("descriptionArticle"),
                    LocalDateTime.parse(request.getParameter("debutEnchere")),
                    LocalDateTime.parse(request.getParameter("finEnchere")),
                    Integer.parseInt(request.getParameter("prixInitial")),
                    Integer.parseInt(request.getParameter("prixInitial")),
                    Integer.parseInt(request.getParameter("categorie")),
                    request.getParameter("rueRetrait"),
                    request.getParameter("codePostalRetrait"),
                    request.getParameter("villeRetrait")
            );


            HttpSession session = request.getSession();

            String username = new String();

            username = (String)session.getAttribute("pseudo");
            
           
            articleManager.validerDates(article, businessException);
            
            
			if(businessException.getListeCodesErreur().size()>0)
				
    		{
    			request.setAttribute("listeCodesErreur",businessException.getListeCodesErreur());
    			
    			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/VendreArticle.jsp");
    			rd.forward(request, response);
    			
    		}
    		
    			else {
    				
    				articleManager.insererArticle(article, username);
    				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp");
    				rd.forward(request, response);
    				
    			}
    			
      
        } catch (BusinessException e) {

            e.printStackTrace();
        }
    }
}
        
    	


