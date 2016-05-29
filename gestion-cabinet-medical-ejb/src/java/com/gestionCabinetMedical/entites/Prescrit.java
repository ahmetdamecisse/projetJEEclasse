/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.entites;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "prescrit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prescrit.findAll", query = "SELECT p FROM Prescrit p"),
    @NamedQuery(name = "Prescrit.findByIdmedecin", query = "SELECT p FROM Prescrit p WHERE p.prescritPK.idmedecin = :idmedecin"),
    @NamedQuery(name = "Prescrit.findByIdpatient", query = "SELECT p FROM Prescrit p WHERE p.prescritPK.idpatient = :idpatient"),
    @NamedQuery(name = "Prescrit.findByIdordonnance", query = "SELECT p FROM Prescrit p WHERE p.prescritPK.idordonnance = :idordonnance")})
public class Prescrit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrescritPK prescritPK;
    @JoinColumn(name = "IDPATIENT", referencedColumnName = "IDPATIENT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patients patients;
    @JoinColumn(name = "IDORDONNANCE", referencedColumnName = "IDORDONNANCE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordonnances ordonnances;
    @JoinColumn(name = "IDMEDECIN", referencedColumnName = "IDMEDECIN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medecins medecins;

    public Prescrit() {
    }

    public Prescrit(PrescritPK prescritPK) {
        this.prescritPK = prescritPK;
    }

    public Prescrit(int idmedecin, int idpatient, int idordonnance) {
        this.prescritPK = new PrescritPK(idmedecin, idpatient, idordonnance);
    }

    public PrescritPK getPrescritPK() {
        return prescritPK;
    }

    public void setPrescritPK(PrescritPK prescritPK) {
        this.prescritPK = prescritPK;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Ordonnances getOrdonnances() {
        return ordonnances;
    }

    public void setOrdonnances(Ordonnances ordonnances) {
        this.ordonnances = ordonnances;
    }

    public Medecins getMedecins() {
        return medecins;
    }

    public void setMedecins(Medecins medecins) {
        this.medecins = medecins;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescritPK != null ? prescritPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prescrit)) {
            return false;
        }
        Prescrit other = (Prescrit) object;
        if ((this.prescritPK == null && other.prescritPK != null) || (this.prescritPK != null && !this.prescritPK.equals(other.prescritPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.Prescrit[ prescritPK=" + prescritPK + " ]";
    }
    
}
