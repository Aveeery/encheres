package fr.eni.javaee.eniencheres.dal;

import fr.eni.javaee.eniencheres.BusinessException;
import fr.eni.javaee.eniencheres.bo.Utilisateur;

public interface UtilisateurDAO {
	public Utilisateur selectByPseudoAndPassword(String login, String password) throws BusinessException;
	public void insererUtilisateurBDD(Utilisateur utilisateur) throws BusinessException;
	public boolean pseudoExists(String pseudo) throws BusinessException;
	public boolean emailExists(String email) throws BusinessException;
	public Utilisateur selectByPseudo(String pseudo) throws BusinessException;
	public void updateProfil(Utilisateur utilisateur, String ancienPseudo) throws BusinessException;
	public void deleteProfil(String pseudo) throws BusinessException;
}

