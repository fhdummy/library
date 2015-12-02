/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "film")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Film.findAll", query = "SELECT f FROM Film f"),
    @NamedQuery(name = "Film.findByMediumId", query = "SELECT f FROM Film f WHERE f.filmPK.mediumId = :mediumId"),
    @NamedQuery(name = "Film.findByFilmId", query = "SELECT f FROM Film f WHERE f.filmPK.filmId = :filmId"),
    @NamedQuery(name = "Film.findByRegalId", query = "SELECT f FROM Film f WHERE f.regalId = :regalId"),
    @NamedQuery(name = "Film.findByKundeId", query = "SELECT f FROM Film f WHERE f.kundeId = :kundeId"),
    @NamedQuery(name = "Film.findByStartzeit", query = "SELECT f FROM Film f WHERE f.startzeit = :startzeit"),
    @NamedQuery(name = "Film.findByEndsollzeit", query = "SELECT f FROM Film f WHERE f.endsollzeit = :endsollzeit"),
    @NamedQuery(name = "Film.findByEndistzeit", query = "SELECT f FROM Film f WHERE f.endistzeit = :endistzeit"),
    @NamedQuery(name = "Film.findByStrafe", query = "SELECT f FROM Film f WHERE f.strafe = :strafe"),
    @NamedQuery(name = "Film.findByLaenge", query = "SELECT f FROM Film f WHERE f.laenge = :laenge"),
    @NamedQuery(name = "Film.findByJahr", query = "SELECT f FROM Film f WHERE f.jahr = :jahr")})
public class Film implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FilmPK filmPK;
    @Column(name = "REGAL_ID")
    private Integer regalId;
    @Column(name = "KUNDE_ID")
    private Integer kundeId;
    @Column(name = "STARTZEIT")
    @Temporal(TemporalType.DATE)
    private Date startzeit;
    @Column(name = "ENDSOLLZEIT")
    @Temporal(TemporalType.DATE)
    private Date endsollzeit;
    @Column(name = "ENDISTZEIT")
    @Temporal(TemporalType.DATE)
    private Date endistzeit;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "STRAFE")
    private Float strafe;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TITEL")
    private String titel;
    @Lob
    @Size(max = 65535)
    @Column(name = "REGISSEUR")
    private String regisseur;
    @Column(name = "LAENGE")
    @Temporal(TemporalType.TIME)
    private Date laenge;
    @Column(name = "JAHR")
    private Integer jahr;
    @JoinColumn(name = "MEDIUM_ID", referencedColumnName = "MEDIUM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medium medium;

    public Film() {
    }

    public Film(FilmPK filmPK) {
        this.filmPK = filmPK;
    }

    public Film(FilmPK filmPK, String titel) {
        this.filmPK = filmPK;
        this.titel = titel;
    }

    public Film(int mediumId, int filmId) {
        this.filmPK = new FilmPK(mediumId, filmId);
    }

    public FilmPK getFilmPK() {
        return filmPK;
    }

    public void setFilmPK(FilmPK filmPK) {
        this.filmPK = filmPK;
    }

    public Integer getRegalId() {
        return regalId;
    }

    public void setRegalId(Integer regalId) {
        this.regalId = regalId;
    }

    public Integer getKundeId() {
        return kundeId;
    }

    public void setKundeId(Integer kundeId) {
        this.kundeId = kundeId;
    }

    public Date getStartzeit() {
        return startzeit;
    }

    public void setStartzeit(Date startzeit) {
        this.startzeit = startzeit;
    }

    public Date getEndsollzeit() {
        return endsollzeit;
    }

    public void setEndsollzeit(Date endsollzeit) {
        this.endsollzeit = endsollzeit;
    }

    public Date getEndistzeit() {
        return endistzeit;
    }

    public void setEndistzeit(Date endistzeit) {
        this.endistzeit = endistzeit;
    }

    public Float getStrafe() {
        return strafe;
    }

    public void setStrafe(Float strafe) {
        this.strafe = strafe;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getRegisseur() {
        return regisseur;
    }

    public void setRegisseur(String regisseur) {
        this.regisseur = regisseur;
    }

    public Date getLaenge() {
        return laenge;
    }

    public void setLaenge(Date laenge) {
        this.laenge = laenge;
    }

    public Integer getJahr() {
        return jahr;
    }

    public void setJahr(Integer jahr) {
        this.jahr = jahr;
    }

    public Medium getMedium() {
        return medium;
    }

    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filmPK != null ? filmPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.filmPK == null && other.filmPK != null) || (this.filmPK != null && !this.filmPK.equals(other.filmPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Film[ filmPK=" + filmPK + " ]";
    }
    
}
