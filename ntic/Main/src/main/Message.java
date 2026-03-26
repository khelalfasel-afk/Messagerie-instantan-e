package com.example.de.copy;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Column;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


import java.sql.Timestamp;
@IdClass(MessageId.class)
@Entity
public class Message {
  
    @Id
    private Timestamp createdAt;
    @Id
    @ManyToOne
    @JoinColumn(name = "expediteur_id", referencedColumnName = "email")
    private Utilisateur expediteur;
    @Id
    @ManyToOne
    @JoinColumn(name = "destinataire_id", referencedColumnName = "email")
    private Utilisateur destinataire;

    @Column(name = "contenu", columnDefinition = "TEXT")
    private String contenu;

    public Message(Utilisateur expediteur, Utilisateur destinataire, String contenu, Timestamp createdAt) {
        this.expediteur = expediteur;
        this.destinataire = destinataire;
        this.contenu = contenu;
        this.createdAt = createdAt;
       
    }
   public Message() {
	// TODO Auto-generated constructor stub
}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Utilisateur getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}

	public Utilisateur getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Utilisateur destinataire) {
		this.destinataire = destinataire;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

    // Getters and setters
}
