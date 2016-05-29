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
public class PrescritPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDMEDECIN")
    private int idmedecin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPATIENT")
    private int idpatient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDORDONNANCE")
    private int idordonnance;

    public PrescritPK() {
    }

    public PrescritPK(int idmedecin, int idpatient, int idordonnance) {
        this.idmedecin = idmedecin;
        this.idpatient = idpatient;
        this.idordonnance = idordonnance;
    }

    public int getIdmedecin() {
        return idmedecin;
    }

    public void setIdmedecin(int idmedecin) {
        this.idmedecin = idmedecin;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getIdordonnance() {
        return idordonnance;
    }

    public void setIdordonnance(int idordonnance) {
        this.idordonnance = idordonnance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idmedecin;
        hash += (int) idpatient;
        hash += (int) idordonnance;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrescritPK)) {
            return false;
        }
        PrescritPK other = (PrescritPK) object;
        if (this.idmedecin != other.idmedecin) {
            return false;
        }
        if (this.idpatient != other.idpatient) {
            return false;
        }
        if (this.idordonnance != other.idordonnance) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.PrescritPK[ idmedecin=" + idmedecin + ", idpatient=" + idpatient + ", idordonnance=" + idordonnance + " ]";
    }
    
}
