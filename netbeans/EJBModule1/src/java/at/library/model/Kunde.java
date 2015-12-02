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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Stefan
 */
@Entity
@Table(name = "kunde")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kunde.findAll", query = "SELECT k FROM Kunde k"),
    @NamedQuery(name = "Kunde.findByKundeId", query = "SELECT k FROM Kunde k WHERE k.kundeId = :kundeId"),
    @NamedQuery(name = "Kunde.findByPlz", query = "SELECT k FROM Kunde k WHERE k.plz = :plz"),
    @NamedQuery(name = "Kunde.findByGeburtstag", query = "SELECT k FROM Kunde k WHERE k.geburtstag = :geburtstag"),
    @NamedQuery(name = "Kunde.findByStudent", query = "SELECT k FROM Kunde k WHERE k.student = :student")})
public class Kunde implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "KUNDE_ID")
    private Integer kundeId;
    @Lob
    @Size(max = 65535)
    @Column(name = "VORNAME")
    private String vorname;
    @Lob
    @Size(max = 65535)
    @Column(name = "NACHNAME")
    private String nachname;
    @Lob
    @Size(max = 65535)
    @Column(name = "STRASSE")
    private String strasse;
    @Column(name = "PLZ")
    private Integer plz;
    @Lob
    @Size(max = 65535)
    @Column(name = "ORT")
    private String ort;
    @Lob
    @Size(max = 65535)
    @Column(name = "LAND")
    private String land;
    @Column(name = "GEBURTSTAG")
    @Temporal(TemporalType.DATE)
    private Date geburtstag;
    @Column(name = "STUDENT")
    private Short student;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kundeId")
    private Collection<Konto> kontoCollection;
    @OneToMany(mappedBy = "kundeId")
    private Collection<Medium> mediumCollection;
    @JoinColumn(name = "KONTO_ID", referencedColumnName = "KONTO_ID")
    @ManyToOne
    private Konto kontoId;

    public Kunde() {
    }

    public Kunde(Integer kundeId) {
        this.kundeId = kundeId;
    }

    public Integer getKundeId() {
        return kundeId;
    }

    public void setKundeId(Integer kundeId) {
        this.kundeId = kundeId;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public Integer getPlz() {
        return plz;
    }

    public void setPlz(Integer plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    public Short getStudent() {
        return student;
    }

    public void setStudent(Short student) {
        this.student = student;
    }

    @XmlTransient
    public Collection<Konto> getKontoCollection() {
        return kontoCollection;
    }

    public void setKontoCollection(Collection<Konto> kontoCollection) {
        this.kontoCollection = kontoCollection;
    }

    @XmlTransient
    public Collection<Medium> getMediumCollection() {
        return mediumCollection;
    }

    public void setMediumCollection(Collection<Medium> mediumCollection) {
        this.mediumCollection = mediumCollection;
    }

    public Konto getKontoId() {
        return kontoId;
    }

    public void setKontoId(Konto kontoId) {
        this.kontoId = kontoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kundeId != null ? kundeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kunde)) {
            return false;
        }
        Kunde other = (Kunde) object;
        if ((this.kundeId == null && other.kundeId != null) || (this.kundeId != null && !this.kundeId.equals(other.kundeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Kunde[ kundeId=" + kundeId + " ]";
    }
    
}
