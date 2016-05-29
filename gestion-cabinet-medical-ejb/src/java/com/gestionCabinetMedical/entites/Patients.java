/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.entites;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
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
@Table(name = "patients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findByIdpatient", query = "SELECT p FROM Patients p WHERE p.idpatient = :idpatient"),
    @NamedQuery(name = "Patients.findByCni", query = "SELECT p FROM Patients p WHERE p.cni = :cni"),
    @NamedQuery(name = "Patients.findByNom", query = "SELECT p FROM Patients p WHERE p.nom = :nom"),
    @NamedQuery(name = "Patients.findByPrenom", query = "SELECT p FROM Patients p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Patients.findByAdresse", query = "SELECT p FROM Patients p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Patients.findByTelephone", query = "SELECT p FROM Patients p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Patients.findByMail", query = "SELECT p FROM Patients p WHERE p.mail = :mail"),
    @NamedQuery(name = "Patients.findByBp", query = "SELECT p FROM Patients p WHERE p.bp = :bp"),
    @NamedQuery(name = "Patients.findByDatenaissance", query = "SELECT p FROM Patients p WHERE p.datenaissance = :datenaissance")})
public class Patients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPATIENT")
    private Integer idpatient;
    @Column(name = "CNI")
    private BigInteger cni;
    @Size(max = 200)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 200)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 200)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 25)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 200)
    @Column(name = "MAIL")
    private String mail;
    @Size(max = 20)
    @Column(name = "BP")
    private String bp;
    @Basic(optional = false)
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Column(name = "DATENAISSANCE")
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @ManyToMany(mappedBy = "patientsList")
    private List<Medecins> medecinsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpatient")
    private List<Tests> testsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patients")
    private List<Etablit> etablitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patients")
    private List<Prescrit> prescritList;

    public Patients() {
    }

    public Patients(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public Patients(Integer idpatient, byte[] photo) {
        this.idpatient = idpatient;
        this.photo = photo;
    }

    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public BigInteger getCni() {
        return cni;
    }

    public void setCni(BigInteger cni) {
        this.cni = cni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @XmlTransient
    public List<Medecins> getMedecinsList() {
        return medecinsList;
    }

    public void setMedecinsList(List<Medecins> medecinsList) {
        this.medecinsList = medecinsList;
    }

    @XmlTransient
    public List<Tests> getTestsList() {
        return testsList;
    }

    public void setTestsList(List<Tests> testsList) {
        this.testsList = testsList;
    }

    @XmlTransient
    public List<Etablit> getEtablitList() {
        return etablitList;
    }

    public void setEtablitList(List<Etablit> etablitList) {
        this.etablitList = etablitList;
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
        hash += (idpatient != null ? idpatient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.idpatient == null && other.idpatient != null) || (this.idpatient != null && !this.idpatient.equals(other.idpatient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.Patients[ idpatient=" + idpatient + " ]";
    }
    
}
