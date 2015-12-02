/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "medium")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medium.findAll", query = "SELECT m FROM Medium m"),
    @NamedQuery(name = "Medium.findByMediumId", query = "SELECT m FROM Medium m WHERE m.mediumId = :mediumId"),
    @NamedQuery(name = "Medium.findByStartzeit", query = "SELECT m FROM Medium m WHERE m.startzeit = :startzeit"),
    @NamedQuery(name = "Medium.findByEndsollzeit", query = "SELECT m FROM Medium m WHERE m.endsollzeit = :endsollzeit"),
    @NamedQuery(name = "Medium.findByEndistzeit", query = "SELECT m FROM Medium m WHERE m.endistzeit = :endistzeit"),
    @NamedQuery(name = "Medium.findByStrafe", query = "SELECT m FROM Medium m WHERE m.strafe = :strafe")})
public class Medium implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDIUM_ID")
    private Integer mediumId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medium")
    private Collection<Cd> cdCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medium")
    private Collection<Buch> buchCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medium")
    private Collection<Film> filmCollection;
    @JoinColumn(name = "KUNDE_ID", referencedColumnName = "KUNDE_ID")
    @ManyToOne
    private Kunde kundeId;
    @JoinColumn(name = "REGAL_ID", referencedColumnName = "REGAL_ID")
    @ManyToOne
    private Regal regalId;

    public Medium() {
    }

    public Medium(Integer mediumId) {
        this.mediumId = mediumId;
    }

    public Integer getMediumId() {
        return mediumId;
    }

    public void setMediumId(Integer mediumId) {
        this.mediumId = mediumId;
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

    @XmlTransient
    public Collection<Cd> getCdCollection() {
        return cdCollection;
    }

    public void setCdCollection(Collection<Cd> cdCollection) {
        this.cdCollection = cdCollection;
    }

    @XmlTransient
    public Collection<Buch> getBuchCollection() {
        return buchCollection;
    }

    public void setBuchCollection(Collection<Buch> buchCollection) {
        this.buchCollection = buchCollection;
    }

    @XmlTransient
    public Collection<Film> getFilmCollection() {
        return filmCollection;
    }

    public void setFilmCollection(Collection<Film> filmCollection) {
        this.filmCollection = filmCollection;
    }

    public Kunde getKundeId() {
        return kundeId;
    }

    public void setKundeId(Kunde kundeId) {
        this.kundeId = kundeId;
    }

    public Regal getRegalId() {
        return regalId;
    }

    public void setRegalId(Regal regalId) {
        this.regalId = regalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediumId != null ? mediumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medium)) {
            return false;
        }
        Medium other = (Medium) object;
        if ((this.mediumId == null && other.mediumId != null) || (this.mediumId != null && !this.mediumId.equals(other.mediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Medium[ mediumId=" + mediumId + " ]";
    }
    
}
