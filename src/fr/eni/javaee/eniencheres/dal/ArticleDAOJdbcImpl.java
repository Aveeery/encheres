package  fr.eni.javaee.eniencheres.dal;

import  fr.eni.javaee.eniencheres.BusinessException;
import  fr.eni.javaee.eniencheres.bo.Article;
import fr.eni.javaee.eniencheres.bo.Filtre;
import fr.eni.javaee.eniencheres.bo.Utilisateur;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOJdbcImpl implements ArticleDAO {

    private static final String selectIdByPseudo = "select id_utilisateur from utilisateurs where pseudo = ?";
    private static final String insertArticle= "INSERT into ARTICLES (nom_article, description, debut_encheres, fin_encheres, prix_initial, prix_vente, id_utilisateur, id_categorie, rue, code_postal, ville)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String selectAll= "select a.nom_article, a.prix_vente, a.id_categorie, a.debut_encheres, a.fin_encheres,u.pseudo " + 
    		"from articles a " + 
    		"inner join UTILISATEURS u " + 
    		"on u.id_utilisateur = a.id_utilisateur WHERE 1=1";

    @Override
    public void insertArticle(Article article, String pseudo) throws BusinessException {
        try (Connection con = ConnectionProvider.getConnection()){
           
            PreparedStatement rqt2 = con.prepareStatement(insertArticle, Statement.RETURN_GENERATED_KEYS);

            rqt2.setString(1, article.getNomArticle());
            rqt2.setString(2, article.getDescription());
            rqt2.setTimestamp(3, java.sql.Timestamp.valueOf(article.getDebutEnchere()));
            rqt2.setTimestamp(4, java.sql.Timestamp.valueOf(article.getFinEnchere()));
            rqt2.setInt(5, article.getPrixInitial());
            rqt2.setInt(6, article.getPrixInitial());
            rqt2.setInt(7, getIdByPseudo(pseudo));
            rqt2.setInt(8,article.getIdCategorie());
            rqt2.setString(9, article.getRueRetrait());
            rqt2.setString(10, article.getCpoRetrait());
            rqt2.setString(11, article.getVilleRetrait());  

            int nbRows = rqt2.executeUpdate();

            if(nbRows==1) {
                ResultSet rs2 = rqt2.getGeneratedKeys();

                if(rs2.next()) {
                    article.setIdArticle(rs2.getInt(1));
                }
                
            }

            if(rqt2!= null) {
                rqt2.close();
            }

            if(con != null) {
                con.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
   

	@Override
	public List<Article> selectAll(Filtre filtre, String pseudo) throws BusinessException {
	List<Article> listeArticles = new ArrayList<Article>();
	String requete = FiltreRequete(filtre, pseudo); 
	try(Connection con = ConnectionProvider.getConnection()) {
		PreparedStatement rqt = con.prepareStatement(selectAll + requete);
		ResultSet rs = rqt.executeQuery();
		Article articleCourant = new Article(); 
			
		while(rs.next()) {
			articleCourant = articleBuilder(rs);
			listeArticles.add(articleCourant);		
		}
	
	} catch (Exception e) {
		e.printStackTrace();
		BusinessException businessException = new BusinessException();
		businessException.ajouterErreur(CodesResultatDAL.CONNEXION_UTILISATEUR_ECHEC);
		throw businessException;
	}
	return listeArticles;	
	}
	
	private Article articleBuilder(ResultSet rs) throws SQLException {
		Article articleCourant; 
		articleCourant = new Article();
		articleCourant.setNomArticle(rs.getString("nom_article"));
		articleCourant.setDebutEnchere(rs.getTimestamp("debut_encheres").toLocalDateTime());
		articleCourant.setFinEnchere(rs.getTimestamp("fin_encheres").toLocalDateTime());
		articleCourant.setPrixVente(rs.getInt("prix_vente"));
		articleCourant.setIdCategorie(rs.getInt("id_categorie"));
		articleCourant.setPseudoVendeur(rs.getString("pseudo"));	
		return articleCourant; 
	}

		public String FiltreRequete(Filtre filtre, String pseudo) throws BusinessException {
		StringBuffer restriction = new StringBuffer();
		
		try {
	
			if (filtre.getIdCategorie() !=0){
			restriction.append(" AND id_categorie =" + filtre.getIdCategorie());
			}
			if(filtre.getMotCle() !=null) {
			restriction.append(" AND nom_article like('%"+ filtre.getMotCle() +"%')");
			}
			if(filtre.isEncheresOuvertes()) {
			restriction.append("AND getdate() between debut_encheres and fin_encheres");
			}
			if(filtre.isMesAchatsEnCours()) {
				restriction.append(" and exists " + 
						"(select * from encheres " + 
						"where " + getIdByPseudo(pseudo) + " = e.id_utilisateur AND a.id_article = id_article)");
				}
			if(filtre.isMesAchatsRemportes()) {
				restriction.append(" and where " + getIdByPseudo(pseudo) + " = a.id_acheteur");
			}
			if(filtre.isMesVentesEnCours()) {
				restriction.append(" and " + getIdByPseudo(pseudo) + " = a.id_utilisateur AND getdate() between debut_encheres and fin_encheres");
			}
			if(filtre.isVentesNonDebutees()) {
				restriction.append(" and " + getIdByPseudo(pseudo) + " = a.id_utilisateur AND getdate() < debut_encheres");
		}
			if(filtre.isVentesTerminees()) {
				restriction.append(" and " + getIdByPseudo(pseudo) + " = a.id_utilisateur AND getdate() > fin_encheres");
			}
			
		} catch (SQLException e) {
			 e.printStackTrace();
			 
	}
			
		

		
		return restriction.toString();
	}
	
	private int getIdByPseudo(String pseudo) throws SQLException {
		 try (Connection con = ConnectionProvider.getConnection()){
		 PreparedStatement rqt1 = con.prepareStatement(selectIdByPseudo);
		    rqt1.setString(1, pseudo);
		    int idUser=0;
		             
		    ResultSet rs1 = rqt1.executeQuery();
		              
		    if (rs1.next()) {     	
		        idUser = rs1.getInt("id_utilisateur");                
		    }
			return idUser;
		 }
	}
}
