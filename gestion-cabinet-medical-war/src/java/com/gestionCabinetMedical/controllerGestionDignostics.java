/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionCabinetMedical;

import com.gestionCabinetMedical.entites.Diagnostics;
import com.gestionCabinetMedical.entites.Etablit;
import com.gestionCabinetMedical.sessions.DiagnosticsFacade;
import com.gestionCabinetMedical.sessions.EtablitFacade;
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
public class controllerGestionDignostics {
    
    @EJB
    private DiagnosticsFacade diagnosticsFacade;
    @EJB
    private EtablitFacade etablitFacade;
    
    public boolean isModifiable() {
        return modifiable;
    }
    
    public void setModifiable(boolean modifiable) {
        this.modifiable = modifiable;
    }
    
    private boolean modifiable;
    
    private List<Etablit> listeEtablits = new ArrayList<Etablit>();
    
    public Integer getIdmedecin() {
        return idmedecin;
    }
    
    public List<Etablit> getListeEtablits() {
        return etablitFacade.findAll();
    }
    
    public void setListeEtablits(List<Etablit> listeEtablits) {
        this.listeEtablits = listeEtablits;
    }
    
    public Diagnostics getDiagnostic() {
        return diagnostic;
    }
    
    public void setDiagnostic(Diagnostics diagnostic) {
        this.diagnostic = diagnostic;
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
    
    public Integer getIdTest() {
        return idTest;
    }
    
    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    /**
     * Creates a new instance of controllerGestionDignostics
     */
    private Integer idmedecin;
    private Integer idpatient;
    private Integer idTest;
    private Diagnostics diagnostic = new Diagnostics();
    private Etablit etablit;
    
    public Etablit getEtablit() {
        return etablit;
    }
    
    public void setEtablit(Etablit etablit) {
        this.etablit = etablit;
    }
    
    public controllerGestionDignostics() {
    }
    
    public String ajouter() {
        //il faut un test pour s'assurer que l'id du medecin ,celui du patient  et celui du test sont valides
        diagnosticsFacade.create(diagnostic);
        etablit = new Etablit(idmedecin, diagnostic.getIddiagnostic(), idpatient, idTest);
        etablitFacade.create(etablit);
        listeEtablits = etablitFacade.findAll();
        
        return "etablirdiagnostic.xhtml?faces-redirect=true";
    }
    
    public String annuler() {
        //On doit vider le formulaire
        return "etablirdiagnostic.xhtml?faces-redirect=true";
    }
    
    public String modifier(Etablit etab) {
        //Modifier prescrit et ordonnance
        modifiable = true;
        
        idmedecin = etab.getMedecins().getIdmedecin();
        idpatient = etab.getPatients().getIdpatient();
        idTest = etab.getTests().getIdtest();
        diagnostic = etab.getDiagnostics();
        
        return "";
    }
    
    public String maj() {
//Modifier Diagnostic
        diagnosticsFacade.edit(diagnostic);
//Modifier Etablit
        //etablitFacade.edit(etablit);
        return "majDiagnostic.xhtml?faces-redirect=true";
    }
      
    public String supprimer(Etablit eta) {
        //supprimer etablit et diagnostic.
        Integer idDagnosticAsup = eta.getDiagnostics().getIddiagnostic();
        etablitFacade.remove(eta);
        diagnosticsFacade.remove(diagnosticsFacade.find(idDagnosticAsup));
        return "majDiagnostic.xhtml?faces-redirect=true";
    }
    
}
