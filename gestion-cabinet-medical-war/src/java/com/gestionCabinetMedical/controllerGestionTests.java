/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionCabinetMedical;

import com.gestionCabinetMedical.entites.Tests;
import com.gestionCabinetMedical.sessions.OrdonnancesFacade;
import com.gestionCabinetMedical.sessions.PatientsFacade;
import com.gestionCabinetMedical.sessions.TestsFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ahmet Dame CISSE
 */
@ManagedBean
@RequestScoped
public class controllerGestionTests {
    
    @EJB
    private OrdonnancesFacade ordonnancesFacade;
    @EJB
    private PatientsFacade patientsFacade;
    
    @EJB
    private TestsFacade testsFacade;
    
    private List<Tests> listeTests = new ArrayList<Tests>();
    
    public Integer getIdOrdonnance() {
        return idOrdonnance;
    }
    
    public void setIdOrdonnance(Integer idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }
    
    public Integer getIdpatient() {
        return idpatient;
    }
    
    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
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
    
    public String getResultats() {
        return resultats;
    }
    
    public void setResultats(String resultats) {
        this.resultats = resultats;
    }
    private Integer idOrdonnance;
    private Integer idpatient;
    private Integer idtestrecup;
    private String libele;
    private String type;
    private String resultats;

    public boolean isModifiable() {
        return modifiable;
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }
    private boolean modifiable;
    
    public List<Tests> getListeTests() {
        return testsFacade.findAll();
    }
    
    public void setListeTests(List<Tests> listeTests) {
        this.listeTests = listeTests;
    }
    
    public Tests getTest() {
        return test;
    }
    
    public void setTest(Tests test) {
        this.test = test;
    }
    private Tests test;

    /**
     * Creates a new instance of controllerGestionTests
     */
    public controllerGestionTests() {
    }
    
    public String ajouter() {
        //il faut un test pour s'assurer que l'id ordonn et celui du patient sont valides
        test = new Tests(libele, type, resultats, ordonnancesFacade.find(idOrdonnance), patientsFacade.find(idpatient));
        testsFacade.create(test);
        listeTests = testsFacade.findAll();
        return "demanderuntest.xhtml?faces-redirect=true";
    }
    
    public String annuler() {
        //On doit vider le formulaire
        return "majtest.xhtml?faces-redirect=true";
    }
    
    public String modifier(Tests test1) {
    modifiable=true;
        //Modifier un test
    idtestrecup=test1.getIdtest();
    idOrdonnance=test1.getIdordonnance().getIdordonnance();
    idpatient=test1.getIdpatient().getIdpatient();
    libele=test1.getLibele();
    type=test1.getType();
    resultats=test1.getResultas();
        return null;
    }
    
    public String maj() {
        test=new Tests(idtestrecup, libele, type, resultats, ordonnancesFacade.find(idOrdonnance), patientsFacade.find(idpatient));
        testsFacade.edit(test);
        return "majtest.xhtml?faces-redirect=true";
    }
    
    public String supprimer(Tests test) {
        //supprimer etablit, puis diagnostic et enfin test
        //Il reste à supprimer le digno utilisant ce test.
        testsFacade.remove(test);
        listeTests = testsFacade.findAll();
        return "majtest.xhtml?faces-redirect=true";
    }
    
}
