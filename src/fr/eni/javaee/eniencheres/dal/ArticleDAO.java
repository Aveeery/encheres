package  fr.eni.javaee.eniencheres.dal;

import java.util.List;

import  fr.eni.javaee.eniencheres.BusinessException;
import  fr.eni.javaee.eniencheres.bo.Article;
import fr.eni.javaee.eniencheres.bo.Filtre;

public interface ArticleDAO {
    public void insertArticle(Article article, String pseudo)throws BusinessException;

	public List<Article> selectAll(Filtre filtre, String pseudo)throws BusinessException;
}
