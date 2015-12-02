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
@Table(name = "cd")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cd.findAll", query = "SELECT c FROM Cd c"),
    @NamedQuery(name = "Cd.findByMediumId", query = "SELECT c FROM Cd c WHERE c.cdPK.mediumId = :mediumId"),
    @NamedQuery(name = "Cd.findByCdId", query = "SELECT c FROM Cd c WHERE c.cdPK.cdId = :cdId"),
    @NamedQuery(name = "Cd.findByRegalId", query = "SELECT c FROM Cd c WHERE c.regalId = :regalId"),
    @NamedQuery(name = "Cd.findByKundeId", query = "SELECT c FROM Cd c WHERE c.kundeId = :kundeId"),
    @NamedQuery(name = "Cd.findByStartzeit", query = "SELECT c FROM Cd c WHERE c.startzeit = :startzeit"),
    @NamedQuery(name = "Cd.findByEndsollzeit", query = "SELECT c FROM Cd c WHERE c.endsollzeit = :endsollzeit"),
    @NamedQuery(name = "Cd.findByEndistzeit", query = "SELECT c FROM Cd c WHERE c.endistzeit = :endistzeit"),
    @NamedQuery(name = "Cd.findByStrafe", query = "SELECT c FROM Cd c WHERE c.strafe = :strafe"),
    @NamedQuery(name = "Cd.findByLaenge", query = "SELECT c FROM Cd c WHERE c.laenge = :laenge"),
    @NamedQuery(name = "Cd.findByJahr", query = "SELECT c FROM Cd c WHERE c.jahr = :jahr")})
public class Cd implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CdPK cdPK;
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
    @Column(name = "LAENGE")
    @Temporal(TemporalType.TIME)
    private Date laenge;
    @Lob
    @Size(max = 65535)
    @Column(name = "INTERPRET")
    private String interpret;
    @Lob
    @Size(max = 65535)
    @Column(name = "ALBUM")
    private String album;
    @Column(name = "JAHR")
    private Integer jahr;
    @JoinColumn(name = "MEDIUM_ID", referencedColumnName = "MEDIUM_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medium medium;

    public Cd() {
    }

    public Cd(CdPK cdPK) {
        this.cdPK = cdPK;
    }

    public Cd(CdPK cdPK, String titel) {
        this.cdPK = cdPK;
        this.titel = titel;
    }

    public Cd(int mediumId, int cdId) {
        this.cdPK = new CdPK(mediumId, cdId);
    }

    public CdPK getCdPK() {
        return cdPK;
    }

    public void setCdPK(CdPK cdPK) {
        this.cdPK = cdPK;
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

    public Date getLaenge() {
        return laenge;
    }

    public void setLaenge(Date laenge) {
        this.laenge = laenge;
    }

    public String getInterpret() {
        return interpret;
    }

    public void setInterpret(String interpret) {
        this.interpret = interpret;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
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
        hash += (cdPK != null ? cdPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cd)) {
            return false;
        }
        Cd other = (Cd) object;
        if ((this.cdPK == null && other.cdPK != null) || (this.cdPK != null && !this.cdPK.equals(other.cdPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.Cd[ cdPK=" + cdPK + " ]";
    }
    
}
