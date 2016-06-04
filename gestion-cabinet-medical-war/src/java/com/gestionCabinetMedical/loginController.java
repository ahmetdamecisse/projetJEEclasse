/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gestionCabinetMedical;

import com.gestionCabinetMedical.entites.Medecins;
import com.gestionCabinetMedical.sessions.MedecinsFacade;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ahmet Dame CISSE
 */
@ManagedBean
@RequestScoped
public class loginController {

    @EJB
    private MedecinsFacade medecinsFacade;

    public String username;
    public String password;
    public Medecins leMedecinQuiSestConnecte=new Medecins();

    /**
     * Creates a new instance of loginController
     */
    public loginController() {
    }

    public String getUsername() {
        return username;
    }

    public Medecins getLeMedecinQuiSestConnecte() {
        return leMedecinQuiSestConnecte;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String loginControl() {
        try {
            //à partir d'ici, ondoit recrupèrer l'id du medecin qui s'est connecté 
            //pour pour pouvoir le suivre durant toute ses activités
            if (medecinsFacade.loginControl(getUsername(), getPassword()) != null) {
                leMedecinQuiSestConnecte = medecinsFacade.loginControl(getUsername(), getPassword());
                System.out.println("Le medecin qui s'est connecté est: "+leMedecinQuiSestConnecte.getNom()+leMedecinQuiSestConnecte.getPrenom());
                return "medecin.xhtml?faces-redirect=true";
            }
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Login ou mot de passe incorrect!!!"));
        } catch (Exception e) {
        }
        return "";
    }

}
