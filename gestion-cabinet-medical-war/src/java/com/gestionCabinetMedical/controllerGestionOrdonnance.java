/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionCabinetMedical;

import com.gestionCabinetMedical.entites.Ordonnances;
import com.gestionCabinetMedical.entites.Prescrit;
import com.gestionCabinetMedical.entites.Tests;
import com.gestionCabinetMedical.sessions.OrdonnancesFacade;
import com.gestionCabinetMedical.sessions.PrescritFacade;
import com.gestionCabinetMedical.sessions.TestsFacade;
import java.util.ArrayList;
import java.util.Iterator;
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
public class controllerGestionOrdonnance {

    @EJB
    private TestsFacade testsFacade;
    @EJB
    private PrescritFacade prescritFacade;
    @EJB
    private OrdonnancesFacade ordonnancesFacade;

    public boolean isModifiable() {
        return modifiable;
    }

    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }
    private boolean modifiable;

    private Ordonnances ordonnance = new Ordonnances();
    private Prescrit prescrit;
    private Integer idmedecin;
    private Integer idpatient;
    private List<Prescrit> listePrescrits = new ArrayList<Prescrit>();

    public Integer getIdmedecin() {
        return idmedecin;
    }

    public List<Ordonnances> getListeOdonnances() {
        return ordonnancesFacade.findAll();
    }

    public List<Prescrit> getListePrescrits() {
        return prescritFacade.findAll();
    }

    public void setListePrescrits(List<Prescrit> listePrescrits) {
        this.listePrescrits = listePrescrits;
    }

    public void setIdmedecin(Integer idmedecin) {
        this.idmedecin = idmedecin;
    }

    public Integer getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(Integer idpatient) {
        this.idpatient = idpatient;
    }

    public Ordonnances getOrdonnance() {
        return ordonnance;
    }

    public Prescrit getPrescrit() {
        return prescrit;
    }

    public void setPrescrit(Prescrit prescrit) {
        this.prescrit = prescrit;
    }

    public void setOrdonnance(Ordonnances ordonnance) {
        this.ordonnance = ordonnance;
    }

    /**
     * Creates a new instance of controllerGestionOrdonnance
     */
    public controllerGestionOrdonnance() {
    }

    public String ajouter() {
        //il faut un test pour s'assurer que l'id du medecin et celui du patient sont valides
        ordonnancesFacade.create(ordonnance);
        prescrit = new Prescrit(idmedecin, idpatient, ordonnance.getIdordonnance());
        prescritFacade.create(prescrit);

        listePrescrits = prescritFacade.findAll();
        return "ecrireOrdonnance.xhtml?faces-redirect=true";
    }

    public String annuler() {
        return "majOrdonnance.xhtml?faces-redirect=true";
    }

    public String modifier(Prescrit pr) {
        modifiable = true;
        idmedecin = pr.getMedecins().getIdmedecin();
        idpatient = pr.getPatients().getIdpatient();
        ordonnance = pr.getOrdonnances();
        return null;
    }

    public String maj() {
        ordonnancesFacade.edit(ordonnance);
        //'''''''''''''''''''''''''''des problèmes pur changer le patient et le medecin'''''''''''''''''''''''''''
//        prescrit = new Prescrit(idmedecin, idpatient, ordonnance.getIdordonnance());
//        System.out.println("prescrit idmedecin***********" + idmedecin);
//        System.out.println("prescrit idpatient*************" + idpatient);
//        System.out.println("prescrit id ordonnance********" + ordonnance.getIdordonnance());
//        prescritFacade.edit(prescrit);
        listePrescrits = prescritFacade.findAll();
        modifiable = false;
        return "majOrdonnance.xhtml?faces-redirect=true";
    }

    public String supprimer(Prescrit pres) {
        //Pour supprimer une ordonnance, il faut d'abord  enlever les objets precrit  et test correspondant.
        //Et pour supprimer l'objet test correspondant, il faut enlever les objets établit  et diagnostic correspondant.
        List<Prescrit> listePrescritsOrdonn = new ArrayList<Prescrit>();
        List<Tests> listeTestsOrdonn = new ArrayList<Tests>();

        Integer idordon = pres.getOrdonnances().getIdordonnance();

        listePrescritsOrdonn = ordonnancesFacade.find(idordon).getPrescritList();
        listeTestsOrdonn = ordonnancesFacade.find(idordon).getTestsList();

        for (Iterator<Tests> it = listeTestsOrdonn.iterator(); it.hasNext();) {
            Tests tests = it.next();
            //supprimer les tests effectués sur la base de cette ordonnA
            // System.out.println("listeTestsOrdonn****"+tests.getIdordonnance());
            testsFacade.remove(tests);
        }
        for (Iterator<Prescrit> it = listePrescritsOrdonn.iterator(); it.hasNext();) {
            Prescrit prescrit1 = it.next();
            //suppromer les prescriptions de cette ordonnA
            //System.out.println("listePrescritsOrdonn*******"+prescrit1.getOrdonnances().getIdordonnance());
            prescritFacade.remove(prescrit1);
        }
        //Supprimer l'ordonnanceA
        ordonnancesFacade.remove(ordonnancesFacade.find(idordon));

        listePrescrits = prescritFacade.findAll();
        return "majOrdonnance.xhtml?faces-redirect=true";
    }
}
