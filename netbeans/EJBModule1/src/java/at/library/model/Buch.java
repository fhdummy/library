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
@Table(name = "buch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Buch.findAll", query = "SELECT b FROM Buch b"),
    @NamedQuery(name = "Buch.findByMediumId", query = "SELECT b FROM Buch b WHERE b.buchPK.mediumId = :mediumId"),
    @NamedQuery(name = "Buch.findByIsbn", query = "SELECT b FROM Buch b WHERE b.buchPK.isbn = :isbn"),
    @NamedQuery(name = "Buch.findByRegalId", query = "SELECT b FROM Buch b WHERE b.regalId = :regalId"),
    @NamedQuery(name = "Buch.findByKundeId", query = "SELECT b FROM Buch b WHERE b.kundeId = :kundeId"),
    @NamedQuery(name = "Buch.findByStartzeit", query = "SELECT b FROM Buch b WHERE b.startzeit = :startzeit"),
    @NamedQuery(name = "Buch.findByEndsollzeit", query = "SELECT b FROM Buch b WHERE b.endsollzeit = :endsollzeit"),
    @NamedQuery(name = "Buch.findByEndistzeit", query = "SELECT b FROM Buch b WHERE b.endistzeit = :endistzeit"),
    @NamedQuery(name = "Buch.findByStrafe", query = "SELECT b FROM Buch b WHERE b.strafe = :strafe"),
    @NamedQuery(name = "Buch.findByJahr", query = "SELECT b FROM Buch b WHERE b.jahr = :jahr")})
public class Buch implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BuchPK buchPK;
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
    @Column(name = "TYP")
    private String typ;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "TITEL")
    private String titel;
    @Lob
    @Size(max = 65535)
    @Column(name = "AUTOR")
    private String autor;
    @Column(name = "JAHR")
    private Integer jahr;
    @JoinColumn(name = "MEDIUM_ID", referencedColumnName = "MEDIUM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medium medium;

    public Buch() {
    }

    public Buch(BuchPK buchPK) {
        this.buchPK = buchPK;
    }

    public Buch(BuchPK buchPK, String typ, String titel) {
        this.buchPK = buchPK;
        this.typ = typ;
        this.titel = titel;
    }

    public Buch(int mediumId, String isbn) {
        this.buchPK = new BuchPK(mediumId, isbn);
    }

    public BuchPK getBuchPK() {
        return buchPK;
    }

    public void setBuchPK(BuchPK buchPK) {
        this.buchPK = buchPK;
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

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
        hash += (buchPK != null ? buchPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buch)) {
            return false;
        }
        Buch other = (Buch) object;
        if ((this.buchPK == null && other.buchPK != null) || (this.buchPK != null && !this.buchPK.equals(other.buchPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Buch[ buchPK=" + buchPK + " ]";
    }
    
}
