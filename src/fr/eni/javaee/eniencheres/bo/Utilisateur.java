package  fr.eni.javaee.eniencheres.bo;

public class Utilisateur {

	private int idUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String cpo;
	private String ville;
	private String mdp;
	private int credit;
	private int admin;
	
	
	public Utilisateur() {
		super();
	}

	 
	 public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cpo,
				String ville) {
			super();
			this.pseudo = pseudo;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.telephone = telephone;
			this.rue = rue;
			this.cpo = cpo;
			this.ville = ville;
			
		}
	 
	 public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cpo,
				String ville, int credit) {
			super();
			this.pseudo = pseudo;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.telephone = telephone;
			this.rue = rue;
			this.cpo = cpo;
			this.ville = ville;
			this.credit = credit;
		}

	public Utilisateur(int idUtilisateur, String pseudo, String mdp) {
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
		this.mdp = mdp;
	}
	

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String cpo,
			String ville, String mdp, int credit, int admin) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cpo = cpo;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}

	public Utilisateur(int idUtilisateur, String pseudo, String nom, String prenom, String email, String telephone, String rue, String cpo,
			String ville, String mdp, int credit, int admin) {
		super();
		this.idUtilisateur = idUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.cpo = cpo;
		this.ville = ville;
		this.mdp = mdp;
		this.credit = credit;
		this.admin = admin;
	}


	public int getIdUtilisateur() {
		return idUtilisateur;
	}
	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}
	public String getPseudo(){
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCpo() {
		return cpo;
	}
	public void setCpo(String cpo) {
		this.cpo = cpo;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}

	
	
}
