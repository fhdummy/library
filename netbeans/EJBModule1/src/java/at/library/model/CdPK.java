/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.library.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Stefan
 */
@Embeddable
public class CdPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDIUM_ID")
    private int mediumId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CD_ID")
    private int cdId;

    public CdPK() {
    }

    public CdPK(int mediumId, int cdId) {
        this.mediumId = mediumId;
        this.cdId = cdId;
    }

    public int getMediumId() {
        return mediumId;
    }

    public void setMediumId(int mediumId) {
        this.mediumId = mediumId;
    }

    public int getCdId() {
        return cdId;
    }

    public void setCdId(int cdId) {
        this.cdId = cdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mediumId;
        hash += (int) cdId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CdPK)) {
            return false;
        }
        CdPK other = (CdPK) object;
        if (this.mediumId != other.mediumId) {
            return false;
        }
        if (this.cdId != other.cdId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.CdPK[ mediumId=" + mediumId + ", cdId=" + cdId + " ]";
    }
    
}
