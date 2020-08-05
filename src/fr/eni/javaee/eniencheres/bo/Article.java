package fr.eni.javaee.eniencheres.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Article {

    private int idArticle;
    private String nomArticle;
    private String description;
    private LocalDateTime debutEnchere;
    private LocalDateTime finEnchere;
    private int prixInitial;
    private int prixVente;
    private int idUtilisateur;
    private int idCategorie;
    private String rueRetrait;
    private String cpoRetrait;
    private String villeRetrait;
    private String pseudoVendeur; 


    public Article() {
        super();
    }
    

    

    	
    public Article(int idArticle, String nomArticle, String description, LocalDateTime debutEnchere,
			LocalDateTime finEnchere, int prixInitial, int prixVente, int idUtilisateur, int idCategorie,
			String rueRetrait, String cpoRetrait, String villeRetrait, String pseudoVendeur) {
		super();
		this.idArticle = idArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEnchere = debutEnchere;
		this.finEnchere = finEnchere;
		this.prixInitial = prixInitial;
		this.prixVente = prixVente;
		this.idUtilisateur = idUtilisateur;
		this.idCategorie = idCategorie;
		this.rueRetrait = rueRetrait;
		this.cpoRetrait = cpoRetrait;
		this.villeRetrait = villeRetrait;
		this.pseudoVendeur = pseudoVendeur;
	}





	public Article(String nomArticle, String description, LocalDateTime debutEnchere, LocalDateTime finEnchere,
                   int prixInitial, int prixVente, int idUtilisateur, int idCategorie,
                    String rueRetrait, String cpoRetrait, String villeRetrait) {
        super();
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEnchere = debutEnchere;
        this.finEnchere = finEnchere;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.idUtilisateur = idUtilisateur;
        this.idCategorie = idCategorie;
        this.rueRetrait = rueRetrait;
        this.cpoRetrait = cpoRetrait;
        this.villeRetrait = villeRetrait;
    }

    public Article(String nomArticle, String description, LocalDateTime debutEnchere, LocalDateTime finEnchere,
                   int prixInitial, int prixVente, int idCategorie, String rueRetrait, String cpoRetrait, String villeRetrait) {
        super();
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEnchere = debutEnchere;
        this.finEnchere = finEnchere;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.idCategorie = idCategorie;
        this.rueRetrait = rueRetrait;
        this.cpoRetrait = cpoRetrait;
        this.villeRetrait = villeRetrait;
    }



    public Article(int idArticle, int idRetrait, String nomArticle, String description, LocalDateTime debutEnchere, LocalDateTime finEnchere, int prixInitial, int prixVente, int idUtilisateur, int idCategorie,
                   LocalTime heureDebutEnchere, LocalTime heureFinEnchere, String rueRetrait, String cpoRetrait, String villeRetrait) {

        super();
        this.idArticle = idArticle;
        
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEnchere = debutEnchere;
        this.finEnchere = finEnchere;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.idUtilisateur = idUtilisateur;
        this.idCategorie = idCategorie;
        this.rueRetrait = rueRetrait;
        this.cpoRetrait = cpoRetrait;
        this.villeRetrait = villeRetrait;
    }


    public Article(String nomArticle,  LocalDateTime debutEnchere, LocalDateTime finEnchere, int prixVente,
			int idCategorie, String pseudoVendeur) {
		super();
		this.nomArticle = nomArticle;
		this.debutEnchere = debutEnchere;
        this.finEnchere = finEnchere;
		this.prixVente = prixVente;
		this.idCategorie = idCategorie;
		this.pseudoVendeur = pseudoVendeur;
	}

	public int getIdArticle() {
        return idArticle;
    }

    public void setRueRetrait(String rueRetrait) {
        this.rueRetrait = rueRetrait;
    }

    public String getRueRetrait() {
        return rueRetrait;
    }

    public void setCpoRetrait(String cpoRetrait) {
        this.cpoRetrait = cpoRetrait;
    }

    public String getCpoRetrait() {
        return cpoRetrait;
    }

    public void setVilleRetrait(String villeRetrait) {
        this.villeRetrait = villeRetrait;
    }

    public String getVilleRetrait() {
        return villeRetrait;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getDebutEnchere() {
		return debutEnchere;
	}

	public void setDebutEnchere(LocalDateTime debutEnchere) {
		this.debutEnchere = debutEnchere;
	}

	public LocalDateTime getFinEnchere() {
		return finEnchere;
	}

	public void setFinEnchere(LocalDateTime finEnchere) {
		this.finEnchere = finEnchere;
	}

	public int getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(int prixInitial) {
        this.prixInitial = prixInitial;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPe) {
        this.prixVente = prixVente;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }


	public String getPseudoVendeur() {
			return pseudoVendeur;
		}

	public void setPseudoVendeur(String pseudoVendeur) {
			this.pseudoVendeur = pseudoVendeur;
		}

}
