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
@Table(name = "etablit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablit.findAll", query = "SELECT e FROM Etablit e"),
    @NamedQuery(name = "Etablit.findByIdmedecin", query = "SELECT e FROM Etablit e WHERE e.etablitPK.idmedecin = :idmedecin"),
    @NamedQuery(name = "Etablit.findByIddiagnostic", query = "SELECT e FROM Etablit e WHERE e.etablitPK.iddiagnostic = :iddiagnostic"),
    @NamedQuery(name = "Etablit.findByIdpatient", query = "SELECT e FROM Etablit e WHERE e.etablitPK.idpatient = :idpatient"),
    @NamedQuery(name = "Etablit.findByIdtest", query = "SELECT e FROM Etablit e WHERE e.etablitPK.idtest = :idtest")})
public class Etablit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EtablitPK etablitPK;
    @JoinColumn(name = "IDPATIENT", referencedColumnName = "IDPATIENT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Patients patients;
    @JoinColumn(name = "IDTEST", referencedColumnName = "IDTEST", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tests tests;
    @JoinColumn(name = "IDMEDECIN", referencedColumnName = "IDMEDECIN", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Medecins medecins;
    @JoinColumn(name = "IDDIAGNOSTIC", referencedColumnName = "IDDIAGNOSTIC", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Diagnostics diagnostics;

    public Etablit() {
    }

    public Etablit(EtablitPK etablitPK) {
        this.etablitPK = etablitPK;
    }

    public Etablit(int idmedecin, int iddiagnostic, int idpatient, int idtest) {
        this.etablitPK = new EtablitPK(idmedecin, iddiagnostic, idpatient, idtest);
    }

    public EtablitPK getEtablitPK() {
        return etablitPK;
    }

    public void setEtablitPK(EtablitPK etablitPK) {
        this.etablitPK = etablitPK;
    }

    public Patients getPatients() {
        return patients;
    }

    public void setPatients(Patients patients) {
        this.patients = patients;
    }

    public Tests getTests() {
        return tests;
    }

    public void setTests(Tests tests) {
        this.tests = tests;
    }

    public Medecins getMedecins() {
        return medecins;
    }

    public void setMedecins(Medecins medecins) {
        this.medecins = medecins;
    }

    public Diagnostics getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(Diagnostics diagnostics) {
        this.diagnostics = diagnostics;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (etablitPK != null ? etablitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etablit)) {
            return false;
        }
        Etablit other = (Etablit) object;
        if ((this.etablitPK == null && other.etablitPK != null) || (this.etablitPK != null && !this.etablitPK.equals(other.etablitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.Etablit[ etablitPK=" + etablitPK + " ]";
    }
    
}
