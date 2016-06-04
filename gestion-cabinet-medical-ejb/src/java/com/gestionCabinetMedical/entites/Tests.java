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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tests")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tests.findAll", query = "SELECT t FROM Tests t"),
    @NamedQuery(name = "Tests.findByIdtest", query = "SELECT t FROM Tests t WHERE t.idtest = :idtest"),
    @NamedQuery(name = "Tests.findByLibele", query = "SELECT t FROM Tests t WHERE t.libele = :libele"),
    @NamedQuery(name = "Tests.findByType", query = "SELECT t FROM Tests t WHERE t.type = :type"),
    @NamedQuery(name = "Tests.findByResultas", query = "SELECT t FROM Tests t WHERE t.resultas = :resultas")})
public class Tests implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTEST")
    private Integer idtest;
    @Size(max = 500)
    @Column(name = "LIBELE")
    private String libele;
    @Size(max = 500)
    @Column(name = "TYPE")
    private String type;
    @Size(max = 3000)
    @Column(name = "RESULTAS")
    private String resultas;
    @JoinColumn(name = "IDORDONNANCE", referencedColumnName = "IDORDONNANCE")
    @ManyToOne(optional = false)
    private Ordonnances idordonnance;
    @JoinColumn(name = "IDPATIENT", referencedColumnName = "IDPATIENT")
    @ManyToOne(optional = false)
    private Patients idpatient;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tests")
    private List<Etablit> etablitList;

    public Tests() {
    }

    public Tests(String libele, String type, String resultas, Ordonnances idordonnance, Patients idpatient) {
        this.libele = libele;
        this.type = type;
        this.resultas = resultas;
        this.idordonnance = idordonnance;
        this.idpatient = idpatient;
    }
    
     public Tests(Integer idtest, String libele, String type, String resultas, Ordonnances idordonnance, Patients idpatient) {
         this.idtest=idtest;
        this.libele = libele;
        this.type = type;
        this.resultas = resultas;
        this.idordonnance = idordonnance;
        this.idpatient = idpatient;
    }

    public Tests(Integer idtest) {
        this.idtest = idtest;
    }

    public Integer getIdtest() {
        return idtest;
    }

    public void setIdtest(Integer idtest) {
        this.idtest = idtest;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResultas() {
        return resultas;
    }

    public void setResultas(String resultas) {
        this.resultas = resultas;
    }

    public Ordonnances getIdordonnance() {
        return idordonnance;
    }

    public void setIdordonnance(Ordonnances idordonnance) {
        this.idordonnance = idordonnance;
    }

    public Patients getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Patients idpatient) {
        this.idpatient = idpatient;
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
        hash += (idtest != null ? idtest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tests)) {
            return false; 
       }
        Tests other = (Tests) object;
        if ((this.idtest == null && other.idtest != null) || (this.idtest != null && !this.idtest.equals(other.idtest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.Tests[ idtest=" + idtest + " ]";
    }
    
}
