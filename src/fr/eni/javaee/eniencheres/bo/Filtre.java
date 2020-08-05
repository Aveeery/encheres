package fr.eni.javaee.eniencheres.bo;

public class Filtre {
	
	private String motCle; 
	private int idCategorie;
	private boolean encheresOuvertes;
	private boolean mesAchatsEnCours;
	private boolean mesAchatsRemportes;
	private boolean mesVentesEnCours;
	private boolean ventesNonDebutees;
	private boolean ventesTerminees;
	
	
	public Filtre() {
		super();
	}

	public boolean isMesAchatsEnCours() {
		return mesAchatsEnCours;
	}

	public void setMesAchatsEnCours(boolean mesAchatsEnCours) {
		this.mesAchatsEnCours = mesAchatsEnCours;
	}

	public Filtre(String motCle, int idCategorie) {
		super();
		this.motCle = motCle;
		this.idCategorie = idCategorie;
	}


	public Filtre(String motCle, int idCategorie, boolean encheresOuvertes, boolean mesAchatsEnCours,
			boolean mesAchatsRemportes, boolean mesVentesEnCours, boolean ventesNonDebutees, boolean ventesTerminees) {
		super();
		this.motCle = motCle;
		this.idCategorie = idCategorie;
		this.encheresOuvertes = encheresOuvertes;
		this.mesAchatsEnCours = mesAchatsEnCours;
		this.mesAchatsRemportes = mesAchatsRemportes;
		this.mesVentesEnCours = mesVentesEnCours;
		this.ventesNonDebutees = ventesNonDebutees;
		this.ventesTerminees = ventesTerminees;
	}

	public String getMotCle() {
		return motCle;
	}

	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public boolean isEncheresOuvertes() {
		return encheresOuvertes;
	}

	public void setEncheresOuvertes(boolean encheresOuvertes) {
		this.encheresOuvertes = encheresOuvertes;
	}

	public boolean isMesAchatsRemportes() {
		return mesAchatsRemportes;
	}

	public void setMesAchatsRemportes(boolean mesAchatsRemportes) {
		this.mesAchatsRemportes = mesAchatsRemportes;
	}

	public boolean isMesVentesEnCours() {
		return mesVentesEnCours;
	}

	public void setMesVentesEnCours(boolean mesVentesEnCours) {
		this.mesVentesEnCours = mesVentesEnCours;
	}

	public boolean isVentesNonDebutees() {
		return ventesNonDebutees;
	}

	public void setVentesNonDebutees(boolean ventesNonDebutees) {
		this.ventesNonDebutees = ventesNonDebutees;
	}

	public boolean isVentesTerminees() {
		return ventesTerminees;
	}

	public void setVentesTerminees(boolean ventesTerminees) {
		this.ventesTerminees = ventesTerminees;
	} 	
	
}


