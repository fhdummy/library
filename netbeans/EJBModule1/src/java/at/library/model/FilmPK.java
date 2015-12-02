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
public class FilmPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "MEDIUM_ID")
    private int mediumId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FILM_ID")
    private int filmId;

    public FilmPK() {
    }

    public FilmPK(int mediumId, int filmId) {
        this.mediumId = mediumId;
        this.filmId = filmId;
    }

    public int getMediumId() {
        return mediumId;
    }

    public void setMediumId(int mediumId) {
        this.mediumId = mediumId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) mediumId;
        hash += (int) filmId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FilmPK)) {
            return false;
        }
        FilmPK other = (FilmPK) object;
        if (this.mediumId != other.mediumId) {
            return false;
        }
        if (this.filmId != other.filmId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "at.library.model.FilmPK[ mediumId=" + mediumId + ", filmId=" + filmId + " ]";
    }
    
}
