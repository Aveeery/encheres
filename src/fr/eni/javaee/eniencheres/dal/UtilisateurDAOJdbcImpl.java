package fr.eni.javaee.eniencheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.javaee.eniencheres.BusinessException;
import fr.eni.javaee.eniencheres.bo.Utilisateur;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	
	private static final String selectByPseudoAndPassword= "SELECT id_utilisateur, pseudo, password FROM Utilisateurs WHERE (pseudo = ? OR email = ?) AND password = ?"; 
	private static final String InsertUtilisateur= "INSERT into UTILISATEURS VALUES(?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
	private static final String pseudoExists= "SELECT pseudo FROM UTILISATEURS WHERE pseudo = ?";
	private static final String emailExists= "SELECT email FROM UTILISATEURS WHERE email = ?";
	private static final String selectByPseudo = "SELECT pseudo, nom, prenom, email, telephone, rue, code_postal, ville, credit from UTILISATEURS where pseudo = ?";
	private static final String updateByPseudo = "UPDATE UTILISATEURS " + 
			"SET pseudo=?, nom =?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ? WHERE pseudo = ?"; 
	private static final String deleteByPseudo = "DELETE UTILISATEURS where pseudo = ?"; 



	@Override
	public void deleteProfil(String pseudo) throws BusinessException {
		try(Connection cnx = ConnectionProvider.getConnection())
		{
			PreparedStatement rqt = cnx.prepareStatement(deleteByPseudo);
			rqt.setString(1, pseudo);
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SUPPRESSION_LISTE_ERREUR);
			throw businessException;
		}
		
		
	}
	
	
		@Override
		public void updateProfil(Utilisateur utilisateur, String ancienPseudo) throws BusinessException{
		PreparedStatement rqt = null;
		try ( Connection con = ConnectionProvider.getConnection()) {	
			
		rqt = con.prepareStatement(updateByPseudo);
		rqt.setString(1, utilisateur.getPseudo());
		rqt.setString(2, utilisateur.getNom());
		rqt.setString(3, utilisateur.getPrenom());
		rqt.setString(4, utilisateur.getEmail());
		rqt.setString(5, utilisateur.getTelephone());
		rqt.setString(6, utilisateur.getRue());
		rqt.setString(7, utilisateur.getCpo());
		rqt.setString(8, utilisateur.getVille());
		rqt.setString(9, ancienPseudo);
		rqt.executeUpdate();
				
		if (rqt != null){
			rqt.close();
			}
			if(con !=null){
			con.close();
				}
				 }
			
			catch (Exception e) {
			 e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.CONNEXION_UTILISATEUR_ECHEC);
				throw businessException;
			}

}
	

	public Utilisateur selectByPseudo(String pseudo) throws BusinessException {
		Utilisateur utilisateur = new Utilisateur();
		
		try(Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement rqt = con.prepareStatement(selectByPseudo);   
		
			rqt.setString(1, pseudo);
			ResultSet rs = rqt.executeQuery();
			
			if (rs.next()) {
				
				utilisateur = new Utilisateur(
						
						rs.getString("pseudo"), 
						rs.getString("nom"), 
						rs.getString("prenom"),
						rs.getString("email"), 
						rs.getString("telephone"), 
						rs.getString("rue"),
						rs.getString("code_postal"), 
						rs.getString("ville"),
						rs.getInt("credit"));
				
				return utilisateur;
						
			}
			else {
				throw new Exception("L'utilisateur n'existe pas.");
				}
		}
	
		 catch (Exception e) {
			 e.printStackTrace();
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.CONNEXION_UTILISATEUR_ECHEC);
				throw businessException;
			}

	}	
	
	//Utilisée pour autoriser une connexion
	@Override
	public Utilisateur selectByPseudoAndPassword(String username, String password) throws BusinessException {
		Utilisateur utilisateur;
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement rqt = con.prepareStatement(selectByPseudoAndPassword);
			rqt.setString(1, username);
			rqt.setString(2, username);
			rqt.setString(3, password);
			
			ResultSet rs = rqt.executeQuery();
			
			if (rs.next()) {
				
				utilisateur = new Utilisateur(
						
						rs.getInt("id_utilisateur"), 
						rs.getString("pseudo"), 
						rs.getString("password"));
				
				return utilisateur;
	
			}
			
			else {
				throw new Exception("L'utilisateur n'existe pas.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CONNEXION_UTILISATEUR_ECHEC);
			throw businessException;
			
		}	
	}
	
	//Utilisée pour l'inscription
	@Override
	public void insererUtilisateurBDD(Utilisateur utilisateur)
			throws BusinessException {
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement rqt = con.prepareStatement(InsertUtilisateur, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1, utilisateur.getPseudo());
			rqt.setString(2, utilisateur.getNom());
			rqt.setString(3, utilisateur.getPrenom());
			rqt.setString(4, utilisateur.getEmail());
			rqt.setString(5, utilisateur.getTelephone());
			rqt.setString(6, utilisateur.getRue());
			rqt.setString(7, utilisateur.getCpo());
			rqt.setString(8, utilisateur.getVille());
			rqt.setString(9, utilisateur.getMdp());
			rqt.setInt(10, 0);
			rqt.setInt(11, 0);
			
			int nbRows = rqt.executeUpdate(); 
			if(nbRows==1) {
				ResultSet rs = rqt.getGeneratedKeys();
				
				if(rs.next()) {
					utilisateur.setIdUtilisateur(rs.getInt(1));
				}
			}
			
			if(rqt != null) {
				rqt.close();
			}
			
			if(con != null) {
				con.close();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	//Vérifier si le pseudo choisi à l'inscription existe déjà 
	@Override
	public boolean pseudoExists(String pseudo) throws BusinessException{
		boolean valid = false; 
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement rqt = con.prepareStatement(pseudoExists);  
			
			rqt.setString(1, pseudo);
			
			ResultSet rs = rqt.executeQuery();
			
			if (rs.next()) {
				valid = false;
			}else {
				valid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valid;		
	}
	///Vérifier si l'email choisi à l'inscription existe déjà 
	@Override
	public boolean emailExists(String email) throws BusinessException{
		boolean valid = false; 
		
		try (Connection con = ConnectionProvider.getConnection()){
			PreparedStatement rqt = con.prepareStatement(emailExists);  
			
			rqt.setString(1, email);
			
			ResultSet rs = rqt.executeQuery();
			
			if (rs.next()) {
				valid = false;
			}else {
				valid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return valid;		
	}




}
