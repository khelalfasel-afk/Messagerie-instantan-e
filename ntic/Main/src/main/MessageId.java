package com.example.de.copy;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import jakarta.persistence.IdClass;

public class MessageId implements Serializable {

    private Timestamp createdAt;
    private Utilisateur expediteur;
    private Utilisateur destinataire;

    // Constructors
    public MessageId() {
    }

    public MessageId(Timestamp createdAt, Utilisateur expediteur, Utilisateur destinataire) {
        this.createdAt = createdAt;
        this.expediteur = expediteur;
        this.destinataire = destinataire;
    }

    // Getters and setters
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

    // Equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageId messageId = (MessageId) o;
        return Objects.equals(createdAt, messageId.createdAt) &&
                Objects.equals(expediteur, messageId.expediteur) &&
                Objects.equals(destinataire, messageId.destinataire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdAt, expediteur, destinataire);
    }
}
