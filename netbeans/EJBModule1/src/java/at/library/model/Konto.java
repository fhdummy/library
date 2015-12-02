/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "konto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Konto.findAll", query = "SELECT k FROM Konto k"),
    @NamedQuery(name = "Konto.findByKontoId", query = "SELECT k FROM Konto k WHERE k.kontoId = :kontoId"),
    @NamedQuery(name = "Konto.findByIstbetrag", query = "SELECT k FROM Konto k WHERE k.istbetrag = :istbetrag"),
    @NamedQuery(name = "Konto.findBySollbetrag", query = "SELECT k FROM Konto k WHERE k.sollbetrag = :sollbetrag")})
public class Konto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KONTO_ID")
    private Integer kontoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ISTBETRAG")
    private float istbetrag;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SOLLBETRAG")
    private Float sollbetrag;
    @JoinColumn(name = "KUNDE_ID", referencedColumnName = "KUNDE_ID")
    @ManyToOne(optional = false)
    private Kunde kundeId;
    @OneToMany(mappedBy = "kontoId")
    private Collection<Kunde> kundeCollection;

    public Konto() {
    }

    public Konto(Integer kontoId) {
        this.kontoId = kontoId;
    }

    public Konto(Integer kontoId, float istbetrag) {
        this.kontoId = kontoId;
        this.istbetrag = istbetrag;
    }

    public Integer getKontoId() {
        return kontoId;
    }

    public void setKontoId(Integer kontoId) {
        this.kontoId = kontoId;
    }

    public float getIstbetrag() {
        return istbetrag;
    }

    public void setIstbetrag(float istbetrag) {
        this.istbetrag = istbetrag;
    }

    public Float getSollbetrag() {
        return sollbetrag;
    }

    public void setSollbetrag(Float sollbetrag) {
        this.sollbetrag = sollbetrag;
    }

    public Kunde getKundeId() {
        return kundeId;
    }

    public void setKundeId(Kunde kundeId) {
        this.kundeId = kundeId;
    }

    @XmlTransient
    public Collection<Kunde> getKundeCollection() {
        return kundeCollection;
    }

    public void setKundeCollection(Collection<Kunde> kundeCollection) {
        this.kundeCollection = kundeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kontoId != null ? kontoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Konto)) {
            return false;
        }
        Konto other = (Konto) object;
        if ((this.kontoId == null && other.kontoId != null) || (this.kontoId != null && !this.kontoId.equals(other.kontoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Konto[ kontoId=" + kontoId + " ]";
    }
    
}
