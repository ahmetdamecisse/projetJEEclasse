/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.entites;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Embeddable
public class EtablitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMEDECIN")
    private int idmedecin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDIAGNOSTIC")
    private int iddiagnostic;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPATIENT")
    private int idpatient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDTEST")
    private int idtest;

    public EtablitPK() {
    }

    public EtablitPK(int idmedecin, int iddiagnostic, int idpatient, int idtest) {
        this.idmedecin = idmedecin;
        this.iddiagnostic = iddiagnostic;
        this.idpatient = idpatient;
        this.idtest = idtest;
    }

    public int getIdmedecin() {
        return idmedecin;
    }

    public void setIdmedecin(int idmedecin) {
        this.idmedecin = idmedecin;
    }

    public int getIddiagnostic() {
        return iddiagnostic;
    }

    public void setIddiagnostic(int iddiagnostic) {
        this.iddiagnostic = iddiagnostic;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getIdtest() {
        return idtest;
    }

    public void setIdtest(int idtest) {
        this.idtest = idtest;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmedecin;
        hash += (int) iddiagnostic;
        hash += (int) idpatient;
        hash += (int) idtest;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EtablitPK)) {
            return false;
        }
        EtablitPK other = (EtablitPK) object;
        if (this.idmedecin != other.idmedecin) {
            return false;
        }
        if (this.iddiagnostic != other.iddiagnostic) {
            return false;
        }
        if (this.idpatient != other.idpatient) {
            return false;
        }
        if (this.idtest != other.idtest) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.EtablitPK[ idmedecin=" + idmedecin + ", iddiagnostic=" + iddiagnostic + ", idpatient=" + idpatient + ", idtest=" + idtest + " ]";
    }
    
}
