package  fr.eni.javaee.eniencheres.bll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import fr.eni.javaee.eniencheres.BusinessException;
import  fr.eni.javaee.eniencheres.bo.Article;
import fr.eni.javaee.eniencheres.bo.Filtre;
import fr.eni.javaee.eniencheres.bo.Utilisateur;
import  fr.eni.javaee.eniencheres.dal.DAOFactory;
import fr.eni.javaee.eniencheres.servlets.CodesResultatServlets;
import  fr.eni.javaee.eniencheres.dal.ArticleDAO;

public class ArticleManager {
    private ArticleDAO articleDAO;

        public ArticleManager() {
            this.articleDAO = DAOFactory.getArticleDAO();
        }

        public void insererArticle(Article article, String username) throws BusinessException {
            this.articleDAO.insertArticle(article, username);
        }
            
    public void validerDates(Article article, BusinessException businessException) throws BusinessException {
    	
    	LocalDateTime dateDebutEnchere = article.getDebutEnchere();
    	LocalDateTime dateFinEnchere = article.getFinEnchere();

    	
    	//La date de début d'enchère doit être dans le futur 	
    	if (dateDebutEnchere.isBefore(LocalDateTime.now())) {    		
    		businessException.ajouterErreur(CodesResultatServlets.DATE_BEFORE_TODAY);	  	
    	}
    		
    	//La date de début d'enchère doit être avant la date de fin d'enchère 
    	if (dateFinEnchere.isAfter(dateFinEnchere)) {
    		businessException.ajouterErreur(CodesResultatServlets.END_AUCTION_BEFORE_START);    	
    	} 
    }
    
	public List<Article> selectionnerArticles(Filtre filtre, String pseudo) throws BusinessException {
		return this.articleDAO.selectAll(filtre, pseudo);
	}
}








