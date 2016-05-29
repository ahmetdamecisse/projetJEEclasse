/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical;

import com.gestionCabinetMedical.entites.Ordonnances;
import com.gestionCabinetMedical.entites.Prescrit;
import com.gestionCabinetMedical.sessions.OrdonnancesFacade;
import com.gestionCabinetMedical.sessions.PrescritFacade;
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
public class controllerGestionOrdonnance {
    @EJB
    private PrescritFacade prescritFacade;
    @EJB
    private OrdonnancesFacade ordonnancesFacade;
    
    private Ordonnances ordonnance=new Ordonnances();
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
         prescrit=new Prescrit(idmedecin, idpatient, ordonnance.getIdordonnance());
         prescritFacade.create(prescrit);
         
         listePrescrits=prescritFacade.findAll();
       return "ecrireOrdonnance.xhtml?faces-redirect=true";
    }

    public String annuler() {
        //On doit vider le formulaire
        return "";
    }
    
     public String modifier() {
        //Modifier prescrit et ordonnance
        return "";
    }
       
          public String supprimer() {
       //supprimer prescrit et ordonnance
        return "";
    }
    
}
