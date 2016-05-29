/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gestionCabinetMedical.sessions;

import com.gestionCabinetMedical.entites.Medecins;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ahmet Dame CISSE
 */
@Stateless
public class MedecinsFacade extends AbstractFacade<Medecins> {
    @PersistenceContext(unitName = "gestion-cabinet-medical-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedecinsFacade() {
        super(Medecins.class);
    }
    
    //*************************************************************
     public boolean loginControl(String login, String password) {
        try {
            Medecins m = em.createNamedQuery("Medecins.findByLoginAndPassword", Medecins.class).setParameter("login", login).setParameter("password", password).getSingleResult();
            if (m != null) {
               return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }  
    
}
