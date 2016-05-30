/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
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
    private List<String> images;
    /**
     * Creates a new instance of controllerGestionMedecin
     */
     @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 6; i++) {
            images.add("nature" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
    
    public controllerGestionMedecin() {
    }
    
}
