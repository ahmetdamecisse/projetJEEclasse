/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionCabinetMedical;

import com.gestionCabinetMedical.sessions.PatientsFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.gestionCabinetMedical.entites.Patients;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author Ahmet Dame CISSE
 */
@ManagedBean
@RequestScoped
public class controllerGestionPatients {

    @EJB
    private PatientsFacade patientsFacade;
    private Patients patient = new Patients();

    private List<Patients> listepatients = new ArrayList<Patients>();

    private boolean modifiable;
    Integer idPatientRecup;

    @PostConstruct
    public void init() {
        try {
        } catch (Throwable th) {
        }
    }
    
    public boolean isModifiable() {
        return modifiable;
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }

    public Patients getPatient() {
        return patient;
    }

    public List<Patients> getListepatients() {
        return patientsFacade.findAll();
    }

    public void setListepatients(List<Patients> listepatients) {
        this.listepatients = listepatients;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    /**
     * Creates a new instance of controllerGestionPatients
     */
    public controllerGestionPatients() {
    }

    public String ajouter() {
 ////       patient.getMedecinsList().add((new loginController()).getLeMedecinQuiSestConnecte());
        patientsFacade.create(patient);
        listepatients = patientsFacade.findAll();
        return "nouveauPatients.xhtml?faces-redirect=true";
    }

    public String annuler() {
        return "majPatient.xhtml?faces-redirect=true";
    }

    public void modifier(Patients pati) {
         modifiable=true;
         idPatientRecup=pati.getIdpatient();
         System.out.println("Identifiant du patient recu :"+idPatientRecup);
        patient = pati;
    }

    public String maj() {
         System.out.println("Identifiant du patient recu :"+idPatientRecup);
        patient.setIdpatient(idPatientRecup);
        System.out.println("Identifiant du patient à modifier est :"+patient.getIdpatient());
        System.out.println("Identifiant du patient à modifier est :"+patient.getNom());
        patientsFacade.edit(patient);
        listepatients = patientsFacade.findAll();
        modifiable = false;
        return "majPatient.xhtml?faces-redirect=true";
    }

    public String supprimer(Patients p) {
        patientsFacade.remove(p);
        listepatients = patientsFacade.findAll();
        return "majPatient.xhtml?faces-redirect=true";
    }
}
