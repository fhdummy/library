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
import javax.validation.constraints.Size;

/**
 *
 * @author Stefan
 */
@Embeddable
public class BuchPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDIUM_ID")
    private int mediumId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ISBN")
    private String isbn;

    public BuchPK() {
    }

    public BuchPK(int mediumId, String isbn) {
        this.mediumId = mediumId;
        this.isbn = isbn;
    }

    public int getMediumId() {
        return mediumId;
    }

    public void setMediumId(int mediumId) {
        this.mediumId = mediumId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mediumId;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuchPK)) {
            return false;
        }
        BuchPK other = (BuchPK) object;
        if (this.mediumId != other.mediumId) {
            return false;
        }
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.BuchPK[ mediumId=" + mediumId + ", isbn=" + isbn + " ]";
    }
    
}
