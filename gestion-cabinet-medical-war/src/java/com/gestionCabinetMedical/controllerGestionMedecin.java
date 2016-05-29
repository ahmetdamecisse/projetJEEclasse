/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Ahmet Dame CISSE
 */
@ManagedBean
@RequestScoped
public class controllerGestionMedecin {

    public Date getCalendriermedecin() {
        return calendriermedecin;
    }

    public void setCalendriermedecin(Date calendriermedecin) {
        this.calendriermedecin = calendriermedecin;
    }

    private Date calendriermedecin;
    /**
     * Creates a new instance of controllerGestionMedecin
     */
    public controllerGestionMedecin() {
    }
    
}
