package com.example.de.copy;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.util.Date;
import java.sql.Time;


@Entity
public class Utilisateur {
    public Utilisateur() {
        // Constructor
    }

    public Utilisateur(String nom, String prenom, String nomUtilisateur, String email, String motDePasse, String avatar, String statut, Date dateDeCreation, Date dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.nomUtilisateur = nomUtilisateur;
        this.email = email;
        this.motDePasse = motDePasse;
        this.avatar = avatar;
        this.statut = statut;
        this.dateDeCreation = dateDeCreation;
        this.dateDeNaissance = dateDeNaissance;
    }

    @Column(name = "nom", length = 50)
    private String nom;

    @Column(name = "prenom", length = 50)
    private String prenom;

    @Column(name = "nom_utilisateur", length = 100)
    private String nomUtilisateur;

    @Id
    @Column(name = "email", length = 100, unique = true)
    private String email;

    @Column(name = "mot_de_passe", length = 100)
    private String motDePasse;

    @Column(name = "avatar", length = 255)
    private String avatar;

    @Column(name = "statut", length = 50)
    private String statut;

    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Date getDateDeCreation() {
		return dateDeCreation;
	}

	public void setDateDeCreation(Date dateDeCreation) {
		this.dateDeCreation = dateDeCreation;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAvatar() {
		return avatar;
	}

	@Column(name = "date_de_creation")
    private Date dateDeCreation;

    @Column(name = "date_de_naissance")
    private Date dateDeNaissance;
public void setAvatar(String avatar) {
	this.avatar = avatar;
}

    // Getters and setters
}
