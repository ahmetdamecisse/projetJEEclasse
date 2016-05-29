/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "ordonnances")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordonnances.findAll", query = "SELECT o FROM Ordonnances o"),
    @NamedQuery(name = "Ordonnances.findByIdordonnance", query = "SELECT o FROM Ordonnances o WHERE o.idordonnance = :idordonnance"),
    @NamedQuery(name = "Ordonnances.findByPrescription", query = "SELECT o FROM Ordonnances o WHERE o.prescription = :prescription"),
    @NamedQuery(name = "Ordonnances.findByDate", query = "SELECT o FROM Ordonnances o WHERE o.date = :date")})
public class Ordonnances implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDORDONNANCE")
    private Integer idordonnance;
    @Size(max = 3000)
    @Column(name = "PRESCRIPTION")
    private String prescription;
    @Column(name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idordonnance")
    private List<Tests> testsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordonnances")
    private List<Prescrit> prescritList;

    public Ordonnances() {
    }

    public Ordonnances(Integer idordonnance) {
        this.idordonnance = idordonnance;
    }

    public Integer getIdordonnance() {
        return idordonnance;
    }

    public void setIdordonnance(Integer idordonnance) {
        this.idordonnance = idordonnance;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public List<Tests> getTestsList() {
        return testsList;
    }

    public void setTestsList(List<Tests> testsList) {
        this.testsList = testsList;
    }

    @XmlTransient
    public List<Prescrit> getPrescritList() {
        return prescritList;
    }

    public void setPrescritList(List<Prescrit> prescritList) {
        this.prescritList = prescritList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordonnance != null ? idordonnance.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordonnances)) {
            return false;
        }
        Ordonnances other = (Ordonnances) object;
        if ((this.idordonnance == null && other.idordonnance != null) || (this.idordonnance != null && !this.idordonnance.equals(other.idordonnance))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.Ordonnances[ idordonnance=" + idordonnance + " ]";
    }
    
}
