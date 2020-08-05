package  fr.eni.javaee.eniencheres.bll;

import  fr.eni.javaee.eniencheres.dal.DAOFactory;
import  fr.eni.javaee.eniencheres.dal.UtilisateurDAO;
import  fr.eni.javaee.eniencheres.servlets.CodesResultatServlets;

import fr.eni. javaee.eniencheres.BusinessException;
import  fr.eni.javaee.eniencheres.bo.Utilisateur;


public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur selectionnerUtilisateurParPseudoEtPassword(String username, String password) throws BusinessException {
		return this.utilisateurDAO.selectByPseudoAndPassword(username, password);
	}
	
	public void insererUtilisateurBDD(Utilisateur utilisateur) throws BusinessException {
		this.utilisateurDAO.insererUtilisateurBDD(utilisateur);
	}
	
	public boolean pseudoExists(String pseudo) throws BusinessException{ 
		return this.utilisateurDAO.pseudoExists(pseudo); 
	}
	
	public boolean emailExists(String email) throws BusinessException{ 
		return this.utilisateurDAO.emailExists(email); 
	}
	
	public Utilisateur afficherProfilUtilisateur(String pseudo) throws BusinessException {
		return this.utilisateurDAO.selectByPseudo(pseudo);
	}
	
	public void updateProfil(Utilisateur utilisateur, String ancienPseudo) throws BusinessException{
		this.utilisateurDAO.updateProfil(utilisateur, ancienPseudo);
	}
	
	public void supprimerProfil(String pseudo) throws BusinessException {
		this.utilisateurDAO.deleteProfil(pseudo);
	}
	
	public void passwordVerif(String password, String passwordVerif, BusinessException businessException) {
		
		if(!password.equals(passwordVerif)) {
			businessException.ajouterErreur(CodesResultatServlets.MDP_DIFFERENT);
		}
	}
	
	public void pseudoVerif(String pseudo, BusinessException businessException) throws BusinessException {
		
		for(int i=0; i<pseudo.length(); i++) {
			char c = pseudo.charAt(i);
			if(!Character.isLetterOrDigit(c)) {
				businessException.ajouterErreur(CodesResultatServlets.PSEUDO_NOT_ALPHANUMERIC);
			}
			else if(!this.pseudoExists(pseudo)) {
				businessException.ajouterErreur(CodesResultatServlets.PSEUDO_EXISTS);
			}
		}
	}
	
	public void emailVerif(String email, BusinessException businessException) throws BusinessException {
		if (!this.emailExists(email)) {	
			businessException.ajouterErreur(CodesResultatServlets.EMAIL_EXISTS);	
		}
}


}
