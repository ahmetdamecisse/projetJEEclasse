/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.entites;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Entity
@Table(name = "medecins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medecins.findAll", query = "SELECT m FROM Medecins m"),
    @NamedQuery(name = "Medecins.findByIdmedecin", query = "SELECT m FROM Medecins m WHERE m.idmedecin = :idmedecin"),
    @NamedQuery(name = "Medecins.findByCni", query = "SELECT m FROM Medecins m WHERE m.cni = :cni"),
    @NamedQuery(name = "Medecins.findByNinmedecin", query = "SELECT m FROM Medecins m WHERE m.ninmedecin = :ninmedecin"),
    @NamedQuery(name = "Medecins.findByNom", query = "SELECT m FROM Medecins m WHERE m.nom = :nom"),
    @NamedQuery(name = "Medecins.findByPrenom", query = "SELECT m FROM Medecins m WHERE m.prenom = :prenom"),
    @NamedQuery(name = "Medecins.findByAdresse", query = "SELECT m FROM Medecins m WHERE m.adresse = :adresse"),
    @NamedQuery(name = "Medecins.findByTelephone", query = "SELECT m FROM Medecins m WHERE m.telephone = :telephone"),
    @NamedQuery(name = "Medecins.findByMail", query = "SELECT m FROM Medecins m WHERE m.mail = :mail"),
    @NamedQuery(name = "Medecins.findByLogin", query = "SELECT m FROM Medecins m WHERE m.login = :login"),
    @NamedQuery(name = "Medecins.findByPassword", query = "SELECT m FROM Medecins m WHERE m.password = :password"),
    @NamedQuery(name = "Medecins.findByLoginAndPassword", query = "SELECT m FROM Medecins m WHERE m.login = :login and m.password = :password"),
    @NamedQuery(name = "Medecins.findByBp", query = "SELECT m FROM Medecins m WHERE m.bp = :bp")})
public class Medecins implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMEDECIN")
    private Integer idmedecin;
    @Column(name = "CNI")
    private BigInteger cni;
    @Size(max = 100)
    @Column(name = "NINMEDECIN")
    private String ninmedecin;
    @Size(max = 200)
    @Column(name = "NOM")
    private String nom;
    @Size(max = 200)
    @Column(name = "PRENOM")
    private String prenom;
    @Size(max = 1000)
    @Column(name = "ADRESSE")
    private String adresse;
    @Size(max = 20)
    @Column(name = "TELEPHONE")
    private String telephone;
    @Size(max = 200)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "login")
    private String login;
    @Size(max = 200)
    @Column(name = "password")
    private String password;
    @Size(max = 20)
    @Column(name = "BP")
    private String bp;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @JoinTable(name = "suit", joinColumns = {
        @JoinColumn(name = "IDMEDECIN", referencedColumnName = "IDMEDECIN")}, inverseJoinColumns = {
        @JoinColumn(name = "IDPATIENT", referencedColumnName = "IDPATIENT")})
    @ManyToMany
    private List<Patients> patientsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medecins")
    private List<Etablit> etablitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medecins")
    private List<Prescrit> prescritList;

    public Medecins() {
    }

    public Medecins(Integer idmedecin) {
        this.idmedecin = idmedecin;
    }

    public Medecins(Integer idmedecin, String login, byte[] photo) {
        this.idmedecin = idmedecin;
        this.login = login;
        this.photo = photo;
    }

    public Integer getIdmedecin() {
        return idmedecin;
    }

    public void setIdmedecin(Integer idmedecin) {
        this.idmedecin = idmedecin;
    }

    public BigInteger getCni() {
        return cni;
    }

    public void setCni(BigInteger cni) {
        this.cni = cni;
    }

    public String getNinmedecin() {
        return ninmedecin;
    }

    public void setNinmedecin(String ninmedecin) {
        this.ninmedecin = ninmedecin;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @XmlTransient
    public List<Patients> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patients> patientsList) {
        this.patientsList = patientsList;
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
        hash += (idmedecin != null ? idmedecin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medecins)) {
            return false;
        }
        Medecins other = (Medecins) object;
        if ((this.idmedecin == null && other.idmedecin != null) || (this.idmedecin != null && !this.idmedecin.equals(other.idmedecin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gestionCabinetMedical.entites.Medecins[ idmedecin=" + idmedecin + " ]";
    }
    
}
