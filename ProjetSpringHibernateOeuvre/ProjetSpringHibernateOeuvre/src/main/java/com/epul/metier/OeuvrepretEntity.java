package com.epul.metier;

import javax.persistence.*;

/**
 * Created by christian on 29/03/2017.
 */
@Entity
@Table(name = "oeuvrepret", schema = "baseoeuvre", catalog = "")
public class OeuvrepretEntity {
    private int idOeuvrepret;
    private String titreOeuvrepret;
    private Integer idProprietaire;
    private ProprietaireEntity proprietaireByIdProprietaire;

    @Id
    @Column(name = "id_oeuvrepret")
    public int getIdOeuvrepret() {
        return idOeuvrepret;
    }

    public void setIdOeuvrepret(int idOeuvrepret) {
        this.idOeuvrepret = idOeuvrepret;
    }

    @Basic
    @Column(name = "titre_oeuvrepret")
    public String getTitreOeuvrepret() {
        return titreOeuvrepret;
    }

    public void setTitreOeuvrepret(String titreOeuvrepret) {
        this.titreOeuvrepret = titreOeuvrepret;
    }

    @Basic
    @Column(name = "id_proprietaire",insertable = false, updatable = false)
    public Integer getIdProprietaire() {
        return idProprietaire;
    }

    public void setIdProprietaire(Integer idProprietaire) {
        this.idProprietaire = idProprietaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OeuvrepretEntity that = (OeuvrepretEntity) o;

        if (idOeuvrepret != that.idOeuvrepret) return false;
        if (titreOeuvrepret != null ? !titreOeuvrepret.equals(that.titreOeuvrepret) : that.titreOeuvrepret != null)
            return false;
        if (idProprietaire != null ? !idProprietaire.equals(that.idProprietaire) : that.idProprietaire != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOeuvrepret;
        result = 31 * result + (titreOeuvrepret != null ? titreOeuvrepret.hashCode() : 0);
        result = 31 * result + (idProprietaire != null ? idProprietaire.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_proprietaire", referencedColumnName = "id_proprietaire")
    public ProprietaireEntity getProprietaireByIdProprietaire() {
        return proprietaireByIdProprietaire;
    }

    public void setProprietaireByIdProprietaire(ProprietaireEntity proprietaireByIdProprietaire) {
        this.proprietaireByIdProprietaire = proprietaireByIdProprietaire;
    }
}
