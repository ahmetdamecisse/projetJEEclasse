/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.entites;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "diagnostics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Diagnostics.findAll", query = "SELECT d FROM Diagnostics d"),
    @NamedQuery(name = "Diagnostics.findByIddiagnostic", query = "SELECT d FROM Diagnostics d WHERE d.iddiagnostic = :iddiagnostic"),
    @NamedQuery(name = "Diagnostics.findByResume", query = "SELECT d FROM Diagnostics d WHERE d.resume = :resume"),
    @NamedQuery(name = "Diagnostics.findByDescription", query = "SELECT d FROM Diagnostics d WHERE d.description = :description")})
public class Diagnostics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDIAGNOSTIC")
    private Integer iddiagnostic;
    @Size(max = 3000)
    @Column(name = "RESUME")
    private String resume;
    @Size(max = 3000)
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "diagnostics")
    private List<Etablit> etablitList;

    public Diagnostics() {
    }

    public Diagnostics(Integer iddiagnostic) {
        this.iddiagnostic = iddiagnostic;
    }

    public Integer getIddiagnostic() {
        return iddiagnostic;
    }

    public Diagnostics(String resume, String description) {
        this.resume = resume;
        this.description = description;
    }

    public void setIddiagnostic(Integer iddiagnostic) {
        this.iddiagnostic = iddiagnostic;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Etablit> getEtablitList() {
        return etablitList;
    }

    public void setEtablitList(List<Etablit> etablitList) {
        this.etablitList = etablitList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddiagnostic != null ? iddiagnostic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostics)) {
            return false;
        }
        Diagnostics other = (Diagnostics) object;
        if ((this.iddiagnostic == null && other.iddiagnostic != null) || (this.iddiagnostic != null && !this.iddiagnostic.equals(other.iddiagnostic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.Diagnostics[ iddiagnostic=" + iddiagnostic + " ]";
    }
    
}
